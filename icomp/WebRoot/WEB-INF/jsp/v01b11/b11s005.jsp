<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link type="text/css" rel="stylesheet" href="/icomp/style/b11s005.css">
    <%@ include file="../common/header_common.jsp" %>
    <script type="text/javascript">

        $(function () {
            jQuery('body').layout({
                center__childOptions: {
                    north__resizable: false,
                    spacing_open: 0
                },
                north: {
                    size: 'auto',
                    spacing_open: 0,
                    closable: false,
                    resizable: false
                }
            });

            $('#list').grid({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                async: false,
                rowno: true,
                rows:${session.rowsize},//页面值
                roll:6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '激光码',
                     name: 'laserCode',

                 },{
                    title:'操作',
                    name:'',
                    visible:'true',
                    format:function(r,t){
                        return option(r);
                    }
                }],
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    }
                }
            });
            submitList()
        });

        //操作
        function option(r){

            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();

                ary_li.push($('<li><a href="javascript:void(0)">复制</a></li>').click(function(){ctlc(r.laserCode,this)}));
//0激活1未激活
                ary_li.push($('<li><a href="javascript:void(0)">确认</a></li>').click(function(){ssp(r.leaserID,this,0)}));
                ary_li.push($('<li><a href="javascript:void(0)">取消</a></li>').click(function(){ssp(r.leaserID,this,1)}));
               ary_li.push($('<li class="clearBoth"></li>'));
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }
        function myrefresh()
        {

            window.location.reload();
        }
        setTimeout('myrefresh()',9000); //指定1秒刷新一次
        /**
         * 刀具消耗查询
         */
        function submitList() {
                var param = {
                    opt: 'list',
                }
                $('#list').grid('url', 'B11S005.action');
                $('#list').grid('data', param);
                $('#list').grid('load', 1);
                return false;
            };


        function ctlc(id,obj){
            var c =window.clipboardData;
            if (window.clipboardData!=c) {
                window.clipboardData.clearData();
                window.clipboardData.setData("Text", id);
                alert("已经成功复制到剪帖板上！");
            }else {
                alert("您的浏览器不支持此复制功能，请选择相应内容并使用Ctrl+C进行复制 或者使用IE浏览器")
            }
        }


        function ssp(id,obj,i){
            var s = i;
            if(i == 0) {
                s  = '是否确认绑定？';
            }else {
                s= '是否取消？';
            }
                $.dialog.confirm(s,function(){
                    var param = {
                        leaserID:id,
                        sspID:i,
                    async:false,
                    }
                $.ajax({
                    url:"leaserEdit.action",
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


    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;刀具激光码绑定&gt;激光码绑定</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <%--<div class="ui-layout-north">--%>
        <%--<form id="searchForm" name="searchForm" method="post">--%>
            <%--<div class="g-fx1 f-fr">--%>
                <%--<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>--%>
            <%--</div>--%>
        <%--</form>--%>
        <%--<div class="f-cb"></div>--%>
        <%--<div class="u-ptt">--%>
            <%--${sessionScope.lang.searchList}--%>
        <%--</div>--%>
    <%--</div>--%>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>

</body>
</html>

