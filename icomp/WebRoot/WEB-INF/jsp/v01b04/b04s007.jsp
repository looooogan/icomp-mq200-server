<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
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
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '功能',
                    name: 'warningFunction',
                    format:function(t){
							if(t.warningFunction == 0 ){return '<span class="ui-grid-tdtx">加工异常预警</span>';}
							else if(t.warningFunction == 1 ){return '<span class="ui-grid-tdtx">库存量预警</span>';}
							return '<span class="ui-grid-tdtx"></span>';}
                }, {
                    title: '人员',
                    name: 'warningName'
                }, {
                    title: '状态',
                    name: 'sorT',
                    format:function(t){
                        if(t.sorT == 0 ){return '<span class="ui-grid-tdtx">已启用</span>';}
                        else if(t.sorT == 1 ){return '<span class="ui-grid-tdtx">已停用</span>';}
                        }
                }, {
                    title:'操作',
                    name:'',
                    width:'130px',
                    visible:'true',
                    format:function(r,t){
                        return option(r);
                    }
                }],
                success: function (d) {
                    if (d.status < 0) {
                        if(undefined== d.total){
                            $("#number1").text(0);
                        }else if(0== d.total){
                            $("#number1").text(1);
                        } else {
                            $("#number1").text(d.total);
                        }

                        artDialog(d.message, "OK");
                    }
                }
            });
        });

        //操作
        function option(r){

            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if(r.sorT == 0) {
                ary_li.push($('<li><a href="javascript:void(0)">停用</a></li>').click(function(){ssp(r.warningID,this,1)}));
            }else{
                ary_li.push($('<li><a href="javascript:void(0)">启动</a></li>').click(function(){ssp(r.warningID,this,0)}));
            }
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        $(function () {
            /**
             * 刀具消耗查询
             */
            $("#searchSubmit").click(function () {
                var param = {
                    opt: 'list',
                    warningfunction: $(searchForm.WarningFunction).val(),
                    warningname: $(searchForm.WarningName).val(),

                }
                $('#list').grid('url', 'B04S007.action');
                $('#list').grid('data', param);
                $('#list').grid('load', 1);
                return false;
            });
        });
        function ssp(id,obj,i){
            var s = i;
            if(i == 0) {
                s  = '是否停用';
            }else if(i==1){
                s = '是否启用'
            }
                $.dialog.confirm(s,function(){
                    var param = {
                        warningID:id,
                        sspID:i,
                    async:false,
                    }
                $.ajax({
                    url:"waningSsp.action",
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
        function wd_waining(data,id,obj){
            $('#roleEditForm').form('reset');
            var title = '新建预警';
            $('#roleEditForm :input').removeClass('u-ipt-err');
            $('#roleEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });

            if(typeof(data) == 'object'){
                $(roleEditForm.opt).val('edit');
                // 页面赋值
                $(roleEditForm.DIVmerchantsUser).val(data.data.innerName);//
                $(roleEditForm.DIVmerchantsID).val(data.data.customerID);//
                $('#roleEditForm').attr('action','merchantsEdit.action');
                title = '${session.lang.EditRoleTitle}';
            }else{
                $(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
                $(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
                $(roleEditForm.DIV_DelFlag).val(0);//删除区分-有效
                $(roleEditForm.DivVersion).val(0);//版本号
                $('#roleEditForm').attr('action','warningAdd.action');
            }
            $.dialog({
                id:'roleEdit_dialog',
                title:title,
                lock: true,
                content:document.getElementById('roleEdit'),
                button:[{
                    name:'保存',
                    focus:true,
                    callback:function(){
                        $(roleEditForm.DIVmerchantsCode).removeAttr("disabled");//启用机构
                        $(roleEditForm.DIVmerchantsName).removeAttr("disabled");//启用部门
                        $(roleEditForm.DIVmerchantsType).removeAttr("disabled");//启用部门

                        $('#roleEditForm').form('submit',{
                            success:function(d){
                                $('#roleEditForm :input').removeClass('u-ipt-err');
                                $('#roleEditForm').find("*").each(function () {
                                    if($(this).hasClass("u-sel")){
                                        $(this).removeAttr("style");
                                    }
                                });
                                if($.parseJSON(d).status >= 0){
                                    var param = {
                                        opt:'list',
//											AgencyID:$(roleForm.AgencyID).val(),
//											DepartmentID:$(roleForm.DepartmentID).val(),
//											PositionID:$(roleForm.PositionID).val(),
//											DelFlag:$(roleForm.DelFlag).val()
                                    }
                                    $('#list').grid('url','B04S007.action');
                                    $('#list').grid('data',param);
                                    if($(roleEditForm.opt).val()!='edit'){
                                        $('#list').grid('load',1);
                                    }else{
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message,"OK");
                                    $.dialog.list['roleEdit_dialog'].close();
                                } else if($.parseJSON(d).status == -1){
                                    artDialog(d.message,"OK");
                                }else {
                                    //if($.parseJSON(d).errtype){
                                    //  var o=getObject($.parseJSON(d).contoll);
                                    //  o.addClass('u-ipt-err');//发生错误控件描红
                                    //  artDialog($.parseJSON(d).message,"OK");
                                    //  o.foucs();
                                    //}else{
                                    //artDialog($.parseJSON(d).message,"OK");
                                    //控件描红
                                    //弹出消息

                                    artDialog(setContorllBackColor($('#roleEditForm'),$.parseJSON(d).message),"OK");
                                    //}
                                }
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
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;预警模块管理&gt;预警</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="searchForm" name="searchForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th>
                        功能
                    </th>
                    <td>
                        <select class="u-sel" name="WarningFunction" maxlength="2" id="productionLine" onchange="return dowm()">
                            <option value="">--${sessionScope.lang.PleaseSelect}--</option>
                            <option value="0">加工异常预警</option>
                            <option value="1">库存量预警 </option>

                        </select>
                    </td>
                    <th>
                       人员
                    </th>
                    <td>
                        <input class="u-ipt" name="WarningName" maxlength="16" type="text">
                    </td>

                </tr>

            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" id="searchSubmit2" onclick="return wd_waining()">新建</button>
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
<%--新建厂家DIV--%>
<div id="roleEdit" class="f-dn">
    <form id="roleEditForm" name="roleEditForm" method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivUpdateUser" />
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <input type="text" class="f-dn" name="DIVmerchantsID" />
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                  功能
                </th>
                <td>
                    <select class="u-sel" name="DIVwarningfunction" maxlength="2">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <option value="0">加工异常预警</option>
                        <option value="1">库存量预警 </option>

                    </select>
                </td>
                <th width="150">
                   员工卡号
                </th>
                <td>
                    <input name="DIVwarningcar" type="text" class="u-ipt" maxlength="16">
                </td>

            </tr>
        </table>
    </form>
</div>

</body>
</html>

