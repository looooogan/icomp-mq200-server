<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
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
                barid: '#bar',
                datatype: 'json',
                type:'post',
                width:'100%',
                fit:true,
                lazy:false,
                //async:false,
                rowno:true,
                rows:${session.rowsize},
                roll:6,
                pager:true,
                pagerpos:'right',
                pagercon:'first,last,number,next,prev',
                column:[{
                    title:'材料号',
                    name:'toolCode'
                },
                    <!-- 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC -->
//					{
//					title:'场所',
//					name:'toolState'

//					format:function(r){
//						if(r.toolState == 0 ){return '<span class="ui-grid-tdtx">备用刀</span>';}
//
//						return '<span class="ui-grid-tdtx"></span>';
//					}
//				},
                    <!-- 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC -->
                    {
                        title:'数量',
                        name:'spareKnifeSum'
                        <%--},{--%>
                        <%--title:'${session.lang.OperationText}',--%>
                        <%--name:'-',--%>
                        <%--width:'130px',--%>
                        <%--visible:'true',--%>
                        <%--format:function(r,t){--%>
                        <%--return option(r);--%>
                        <%--}r--%>
                    }
                    ,{
                        title: '操作',
                        name: '-',
                        width: '130px',
                        visible: 'true',
                        format: function (r, t) {
                            return option(r);
                        }
                    }
                ],
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
        });

        /**
         * 操作列超链接
         */
        function option(r){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            <%--ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.ToolID,'',this)}));--%>
            ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.toolCode,'',r.updateTime,r.updateUser,this)}));
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**
         * 查询处理
         */
        $(function(){
            $("#submits").click(function(){
                var param = {
                    opt:'list',
                    Contain:$(printForm.Contain).val(),
                    expandSpace1:$(printForm.expandSpace1).val(),
                    ToolDurable:$(printForm.ToolDurable).val(),

                }
                $('#list').grid('url','B09S005.action');
                $('#list').grid('data',param);
                $('#list').grid('load',1);
                return false;
            });


        });

        /**
         * 删除处理
         */
        function del(id,version,time,user,obj){
            $.dialog.confirm('${session.lang.RoleDelInfo}',function(){
                var param = {
                    ID:id,
                    version:version,
                    updatetime:time,
                    updateuser:user
                }
                $.ajax({
                    url:"printItemDelete.action",
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

        //打印项目添加
        function wd_printEdit(data,id,obj){
            $('#printEditForm').form('reset');
            var title = '新建非单品刀具初始化';
            $('#printEditForm :input').removeClass('u-ipt-err');
            $('#printEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });
            if(typeof(data) == 'object'){
                $(printEditForm.opt).val('edit');
                $(printEditForm.containerCarrierID).val(id);
                $(printEditForm.DivCarrietCode).val(data.data.containerCarrierCode);
                $(printEditForm.DivCarrietName).val(data.data.containerCarrierName);
                $(printEditForm.DivCarrietType).val(data.data.containerCarrierType);
                $(printEditForm.DivCarrietRFID).val(data.data.rfidContainerID);
                $(printEditForm.DivPerson).val(data.data.person);
                $(printEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
                $(printEditForm.DivVersion).val(data.data.version);//版本号
                $(printEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
                $(printEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分

                //编辑
                $('#printEditForm').attr('action','printItemEdit.action');
                title = '${session.lang.printEditText}';
            }else{
                //添加

                $('#printEditForm').attr('action','sferAdd.action');

            }
            $.dialog({
                id:'printEdit_dialog',
                title:title,
                lock: true,
                content:document.getElementById('printEdit'),
                button:[{
                    name:'${session.lang.submitSaveText}',
                    focus:true,
                    callback:function(){
                        $('#printEditForm').form('submit',{
                            success:function(d){
                                $('#printEditForm :input').removeClass('u-ipt-err');

                                $('#printEditForm').find("*").each(function () {
                                    if($(this).hasClass("u-sel")){
                                        $(this).removeAttr("style");
                                    }
                                });
                                debugger
                                if($.parseJSON(d).status >= 0){
                                    <!-- 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC -->
                                    var param = {
                                        opt:'list',
                                        PageName:$(printEditForm.PageName).val(),
                                        expandSpace1:$(printEditForm.DivexpandSpace1).val()
                                    }
                                    $('#list').grid('url','B09S005.action');
                                    $('#list').grid('data',param);
                                    if($(printEditForm.opt).val()!='edit'){
                                        $('#list').grid('load',1);
                                    }else{
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message,"OK");
                                    $.dialog.list['printEdit_dialog'].close();
                                } else if($.parseJSON(d).status == -1){
                                    artDialog($.parseJSON(d).message,"OK");
                                }else {
                                    artDialog(setContorllBackColor($('#printEditForm'),$.parseJSON(d).message),"OK");
                                }
                                <!-- 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC -->
                            }

                        });
                        return false;
                    }
                }]
            });
            return false;
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>基础数据管理>非单品刀具初始化</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="printForm" name="printForm" method="post">

            <input type="text" class="f-dn" name="containerCarrierID" />
            <input type="text" class="f-dn" name="containRfid" />
            <table width="100%" class="m-frmtb">
                <tr>
                    <!-- 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC -->
                    <%--<th width="150">--%>
                    <%--场所--%>
                    <%--</th>--%>
                    <%--<td>--%>
                    <%--<select class="u-sel" name="Contain">--%>
                    <%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>
                    <%--<s:iterator value="#request.ContainercarriersList" id="contain">--%>
                    <%--<s:if test='%{#contain.containerCarrierID == #contain.containerCarrierName}'>--%>
                    <%--<option value="${contain.containerCarrierID}">${contain.containerCarrierName}</option>--%>
                    <%--</s:if>--%>
                    <%--<s:else>--%>
                    <%--<option value="${contain.containerCarrierID}">${contain.containerCarrierName}</option>--%>
                    <%--</s:else>--%>
                    <%--</s:iterator>--%>

                    <%--</select>--%>
                    <%--</td>--%>
                    <!-- 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC -->
                    <th width="150">
                        材料号
                    </th>

                    <td>
                        <input name="expandSpace1" type="text" class="u-ipt" maxlength="36" onkeyup="this.value=this.value.toUpperCase()">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="submit" class="u-btn2" id="submits">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" onclick="return wd_printEdit()" >${sessionScope.lang.submitAddText}</button>
            </div>
        </form>
        <div class="f-cb"></div>

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
<div id="printEdit" class="f-dn">
    <form id="printEditForm" name="printEditForm" method="post">
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivUpdateUser" />
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <input type="text" class="f-dn" name="DIVDelFlag" />
        <input type="text" class="f-dn" name="DivCarrietRFID" />
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">材料号</th>
                <td>
                    <input name="DivexpandSpace1" type="text" class="u-ipt" maxlength="50" onkeyup="this.value=this.value.toUpperCase()">

                </td>
                <!-- 2017/08/30 宋健 变更↓↓↓　dazhong@YMSC -->
                <%--<th width="150">场所</th>--%>
                <%--<td>--%>
                <%--<select class="u-sel" name="DivContain">--%>
                <%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>
                <%--<s:iterator value="#request.ContainercarriersList" id="contain">--%>
                <%--<s:if test='%{#contain.containerCarrierID == #contain.containerCarrierName}'>--%>
                <%--<option value="${contain.containerCarrierID}">${contain.containerCarrierName}</option>--%>
                <%--</s:if>--%>
                <%--<s:else>--%>
                <%--<option value="${contain.containerCarrierID}">${contain.containerCarrierName}</option>--%>
                <%--</s:else>--%>
                <%--</s:iterator>--%>
                <%--</select>--%>
                <%--</td>--%>
                <!-- 2017/08/30 宋健 变更↑↑↑　dazhong@YMSC -->

                <th width="150">数量</th>
                <td>
                    <input name="DivToolDurable" type="text" class="u-ipt" maxlength="8">
                </td>



            </tr>


        </table>
    </form>
</div>
</body>
</html>

