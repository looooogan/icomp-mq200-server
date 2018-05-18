<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp"%>
    <script type="text/javascript">
        $(function(){
            jQuery('body').layout({
                center__childOptions:{
                    north__resizable:false,
                    spacing_open:0
                },
                north:{
                    size:'auto',
                    spacing_open:0,
                    closable:false,
                    resizable:false
                }
            });

            $('#list').grid({
                barid:'#bar',
                datatype:'json',
                type:'post',
                width:'100%',
                fit:true,
                lazy:false,
                async:false,
                rowno:true,
                rows:${session.rowsize},
                roll:6,
                pager:true,
                pagerpos:'right',
                pagercon:'first,last,number,next,prev',
                column:[{
					title:'授权编码',
					name:'onOffCode'
				}, {
					title: '授权名称',
					name: 'onOffName'
				},{
					title:'备注',
					name:'onOffNoed'
				} ,{
                        title:'操作',
                        name:'',
                        width:'130px',
                        visible:'true',
                        format:function(r,t){
                            return option(r);
                        }
				}],
                success:function(d){
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }
                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
            search();
        });
        function option(r){

            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if(r.onOffState == 1) {
                ary_li.push($('<li><a href="javascript:void(0)">开启权限</a></li>').click(function(){ssp(r.onOffID,this,0)}));
            }else{
                ary_li.push($('<li><a href="javascript:void(0)">关闭权限</a></li>').click(function(){ssp(r.onOffID,this,1)}));
            }
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        function ssp(id,obj,i){
            var s = i;
            if(i == 0) {
                s  = '是否开启权限';
            }else if(i==1){
                s = '是否关闭权限'
            }
            $.dialog.confirm(s,function(){
                var param = {
                    onoffID:id,
                    nf:i,
                    async:false,
                }
                $.ajax({
                    url:"onOffch.action",
                    type: "post",
                    dataType:"json",
                    data:param,
                    success:function(d){

                        if(d.status >= 0){
                            $('#list').grid('load');
                        }
                        artDialog(d.message,"OK");
                    }
                });
            });
        }
        /**
         * 库存异常报警查询
         */
        function search(){
            var param = {
                opt:'list',
                //	ToolCode:$(knifeinventoryForm.toolCode).val(),
            }
            $('#list').grid('url','B08S002.action');
            $('#list').grid('data',param);
            $('#list').grid('load',1);
            return false;
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页:首页 > 基础数据管理 > 权限开关</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptt">
            <div style="float:left;">${sessionScope.lang.searchList}</div>
            <div style="float:right;">
                共：<span id="number1"></span> &nbsp;条
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>
</body>
</html>

