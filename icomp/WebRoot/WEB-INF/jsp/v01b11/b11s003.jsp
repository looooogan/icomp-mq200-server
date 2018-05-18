<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
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
                    title: '${session.lang.AgencyText}',
                    name: 'agencyName',
                    visible: '${session.gridcol.agencyName}'
                }, {
                    title: '${session.lang.DepartmentText}',
                    name: 'departmentName',
                    visible: '${session.gridcol.departmentName}'
                }, {
                    title: '${session.lang.PositionNameText}',
                    name: 'positionName',
                    visible: '${session.gridcol.positionName}'
                }, {
                    title: '${session.lang.LanguageText}',
                    name: 'languageName',
                    visible: '${session.gridcol.languageName}'
                }, {
                    title: '${session.lang.PositionCodeText}',
                    name: 'positionCode',
                    visible: '${session.gridcol.positionCode}'
                }, {
                    title: '${session.lang.DelFlagText}',
                    name: 'delFlag',
                    visible: '${session.gridcol.delFlag}',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + (r.delFlag == '0' ? '${session.lang.DataDelNo}' : '${session.lang.DataDelYes}') + '</span>';
                    }
                }, {
                    title: '${session.lang.OperationText}',
                    name: '',
                    width: '130px',
                    visible: 'true',
                    format: function (r, t) {
                        return option(r);
                    }
                }],
                success: function (d) {
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    }
                }
            });
        });

        /**
         * 操作列超链接
         */
        function option(r) {
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function () {
                edit(r.positionID, r.version, this)
            }));
            ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function () {
                if (r.delFlag == 0) {
                    del(r.positionID, r.version, r.updateTime, r.updateUser, this)
                }
            }));
            $.each(ary_li, function (i, o) {
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**
         * 编辑处理
         */
        function edit(id, version, obj) {
            var param = {
                roleID: id,
                version: version
            }
            $.ajax({
                url: "roleInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    } else {
                        wd_user(d, id, obj);
                    }
                }
            });
        }
        //添加用户
        function wd_user(data, id, obj) {
            $('#roleEditForm').form('reset');
            var title = '${session.lang.AddRoleTitle}';
            $('#roleEditForm :input').removeClass('u-ipt-err');
            $('#roleEditForm').find("*").each(function () {
                if ($(this).hasClass("u-sel")) {
                    $(this).removeAttr("style");
                }
            });
            if (typeof(data) == 'object') {
                $(roleEditForm.opt).val('edit');

                // 页面赋值
                $(roleEditForm.DivPositionID).val(id);//角色ID
                $(roleEditForm.DIV_AgencyID).val(data.data.agencyID);//机构
                $(roleEditForm.DIVAgencyID).val(data.data.agencyID);
                $(roleEditForm.DIVDepartmentID).val(data.data.departmentID);
                changeAgency(2, data.data.departmentID);//部门设定
                $(roleEditForm.DIV_PositionName).val(data.data.positionName);//职务名称
                $(roleEditForm.DIV_PositionCode).val(data.data.positionCode);//职务编码
                $(roleEditForm.DIV_LanguageCode).val(data.data.languageCode);//语言
                $(roleEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
                $(roleEditForm.DivVersion).val(data.data.version);//版本号
                $(roleEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
                $(roleEditForm.DIV_DelFlag).val(data.data.delFlag);//删除区分
                $('#roleEditForm').attr('action', 'roleEdit.action');
                title = '${session.lang.EditRoleTitle}';

            } else {
                $(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
                $(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
                $(roleEditForm.DIV_DelFlag).val(0);//删除区分-有效
                $(roleEditForm.DivVersion).val(0);//版本号
                $('#roleEditForm').attr('action', 'roleAdd.action');
            }
            $.dialog({
                id: 'roleEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById('roleEdit'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
                        $(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
                        $('#roleEditForm').form('submit', {
                            success: function (d) {
                                $('#roleEditForm :input').removeClass('u-ipt-err');
                                $('#roleEditForm').find("*").each(function () {
                                    if ($(this).hasClass("u-sel")) {
                                        $(this).removeAttr("style");
                                    }
                                });
                                if ($.parseJSON(d).status >= 0) {
                                    var param = {
                                        opt: 'list',
                                        AgencyID: $(roleForm.AgencyID).val(),
                                        DepartmentID: $(roleForm.DepartmentID).val(),
                                        PositionID: $(roleForm.PositionID).val(),
                                        DelFlag: $(roleForm.DelFlag).val()
                                    }
                                    $('#list').grid('url', 'B11S003.action');
                                    $('#list').grid('data', param);
                                    if ($(roleEditForm.opt).val() != 'edit') {
                                        $('#list').grid('load', 1);
                                    } else {
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message, "OK");
                                    $.dialog.list['roleEdit_dialog'].close();
                                } else if ($.parseJSON(d).status == -1) {
                                    artDialog(d.message, "OK");
                                } else {
                                    //if($.parseJSON(d).errtype){
                                    //  var o=getObject($.parseJSON(d).contoll);
                                    //  o.addClass('u-ipt-err');//发生错误控件描红
                                    //  artDialog($.parseJSON(d).message,"OK");
                                    //  o.foucs();
                                    //}else{
                                    //artDialog($.parseJSON(d).message,"OK");
                                    //控件描红
                                    //弹出消息

                                    artDialog(setContorllBackColor($('#roleEditForm'), $.parseJSON(d).message), "OK");
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

        /**
         * 删除处理
         */
        function del(id, version, time, user, obj) {
            $.dialog.confirm('${session.lang.RoleDelInfo}', function () {
                var param = {
                    roleID: id,
                    version: version,
                    updatetime: time,
                    updateuser: user
                }
                $.ajax({
                    url: "roleDelete.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status >= 0) {
                            $('#list').grid('load');
                        }
                        artDialog(d.message, "OK");
                    }
                });
            });
        }

        /**
         * 查询处理
         */
        function search() {
            var param = {
                opt: 'list',
                AgencyID: $(roleForm.AgencyID).val(),
                DepartmentID: $(roleForm.DepartmentID).val(),
                PositionID: $(roleForm.PositionID).val(),
                DelFlag: $(roleForm.DelFlag).val()
            }
            $('#list').grid('url', 'B11S003.action');
            $('#list').grid('data', param);
            $('#list').grid('load', 1);
            return false;
        }

        /**
         * 取得机构下的部门
         */
        function changeAgency(i, f) {
            var param;
            if (i == 1) {
                param = {
                    AgencyID: $(roleForm.AgencyID).val()
                }
            } else {
                param = {
                    AgencyID: $(roleEditForm.DIV_AgencyID).val()
                }
            }
            $.ajax({
                url: "getAgency.action",
                type: "post",
                dataType: "json",
                data: param,
                async: 'true',
                success: function (d) {
                    if (d.status < 0) {
                        if (i == 1) {//查询条件
                            $(roleForm.DepartmentID).find('option').remove();
                            $(roleForm.PositionID).find('option').remove();
                            $(roleForm.DepartmentID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $(roleForm.PositionID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {//编辑DIV
                            $(roleEditForm.DIV_DepartmentID).find('option').remove();
                            $(roleEditForm.DIV_DepartmentID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            if (f != undefined) {
                                $(roleEditForm.DIV_DepartmentID).val(f);//部门设定
                                $(roleEditForm.DIV_AgencyID).attr("disabled", "");//禁用机构
                                $(roleEditForm.DIV_DepartmentID).attr("disabled", "");//禁用部门
                            }
                        }
                    } else {
                        if (i == 1) {//查询条件
                            $(roleForm.DepartmentID).find('option').remove();
                            $(roleForm.PositionID).find('option').remove();
                            $(roleForm.DepartmentID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $(roleForm.PositionID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");

                            $.each(d.data, function (key, val) {
                                $(roleForm.DepartmentID).append("<option value='" + val.departmentID + "'>" + val.departmentName + "</option>");
                            });
                        } else {//编辑DIV
                            $(roleEditForm.DIV_DepartmentID).find('option').remove();
                            $(roleEditForm.DIV_DepartmentID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                $(roleEditForm.DIV_DepartmentID).append("<option value='" + val.departmentID + "'>" + val.departmentName + "</option>");
                            });
                            if (f != undefined) {
                                $(roleEditForm.DIV_DepartmentID).val(f);//部门设定
                                $(roleEditForm.DIV_AgencyID).attr("disabled", "");//禁用机构
                                $(roleEditForm.DIV_DepartmentID).attr("disabled", "");//禁用部门
                            }
                        }
                    }
                }
            });
        }


        /**
         * 取得部门下的职务
         */
        function changeDepartment() {
            var param;
            param = {
                DepartmentID: $(roleForm.DepartmentID).val(),
                AgencyID: $(roleForm.AgencyID).val()
            }
            $.ajax({
                url: "getDepartment.action",
                type: "post",
                dataType: "json",
                data: param,
                async: 'true',
                success: function (d) {
                    if (d.status < 0) {
                        $(roleForm.PositionID).find('option').remove();
                        $(roleForm.PositionID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                    } else {
                        $(roleForm.PositionID).find('option').remove();
                        $(roleForm.PositionID).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        $.each(d.data, function (key, val) {
                            $(roleForm.PositionID).append("<option value='" + val.positionID + "'>" + val.positionName + "</option>");
                        });
                    }
                }
            });
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页:首页 > 用户管理模块> 角色管理</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="roleForm" name="roleForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        ${sessionScope.lang.AgencyText}
                    </th>
                    <td>
                        <select class="u-sel" name="AgencyID" onchange="return changeAgency(1)">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.AgencyList" id="agency">
                                <s:if test='%{#agency.agencyID == #request.AgencyID}'>
                                    <option value="${agency.agencyID}" selected>
                                            ${agency.agencyName}
                                    </option>
                                </s:if>
                                <s:else>
                                    <option value="${agency.agencyID}">
                                            ${agency.agencyName}
                                    </option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>
                    <th width="150">
                        ${sessionScope.lang.DepartmentText}
                    </th>
                    <td>
                        <select class="u-sel" name="DepartmentID"
                                onchange="return changeDepartment()">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.DepartmentList" id="department">
                                <s:if
                                        test='%{#department.departmentID == #request.DepartmentID}'>
                                    <option value="${department.departmentID}" selected>
                                            ${department.departmentName}
                                    </option>
                                </s:if>
                                <s:else>
                                    <option value="${department.departmentID}">
                                            ${department.departmentName}
                                    </option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>
                    <th width="150">
                        ${sessionScope.lang.PositionNameText}
                    </th>
                    <td>
                        <select class="u-sel" name="PositionID">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.PositionList" id="position">
                                <s:if test='%{#position.positionID == #request.PositionID}'>
                                    <option value="${position.positionID}" selected>
                                            ${position.positionName}
                                    </option>
                                </s:if>
                                <s:else>
                                    <option value="${position.positionID}">
                                            ${position.positionName}
                                    </option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>
                    <th width="150">
                        ${sessionScope.lang.DelFlagText}
                    </th>
                    <td>
                        <select class="u-sel" name="DelFlag">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.DelFlagList" id="comlist">
                                <s:if test='%{#comlist.comListValue == #request.DelFlag}'>
                                    <option value="${comlist.comListValue}" selected="selected">
                                            ${comlist.comListText}
                                    </option>
                                </s:if>
                                <s:else>
                                    <option value="${comlist.comListValue}">
                                            ${comlist.comListText}
                                    </option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    ${sessionScope.lang.submitSearchText}
                </button>
                <button type="button" class="u-btn2" onclick="return wd_user()">
                    ${sessionScope.lang.submitAddText}
                </button>
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
<div id="roleEdit" class="f-dn">
    <form id="roleEditForm" name="roleEditForm" method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivPositionID"/>
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivUpdateUser"/>
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <input type="text" class="f-dn" name="DIVAgencyID"/>
        <input type="text" class="f-dn" name="DIVDepartmentID"/>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    ${sessionScope.lang.AgencyText}
                </th>
                <td>
                    <select class="u-sel" name="DIV_AgencyID" onchange="return changeAgency(2)">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.AgencyList" id="agency">
                            <option value="${agency.agencyID}">${agency.agencyName}</option>
                        </s:iterator>
                    </select>
                </td>
                <th width="150">
                    ${sessionScope.lang.DepartmentText}
                </th>
                <td>
                    <select class="u-sel" name="DIV_DepartmentID">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.DepartmentList" id="department">
                            <option value="${department.departmentID}">${department.departmentName}</option>
                        </s:iterator>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.PositionNameText}
                </th>
                <td>
                    <input name="DIV_PositionName" type="text" class="u-ipt" maxlength="36">
                </td>
                <th width="150">
                    ${sessionScope.lang.PositionCodeText}
                </th>
                <td>
                    <input name="DIV_PositionCode" type="text" class="u-ipt" maxlength="36">
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.LanguageText}
                </th>
                <td>
                    <select class="u-sel" name="DIV_LanguageCode">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.LanguageCodeList" id="languagetable">
                            <option value="${languagetable.languageCode}">${languagetable.languageName}</option>
                        </s:iterator>
                    </select>
                </td>
                <th width="150">
                    ${sessionScope.lang.DelFlagText}
                </th>
                <td>
                    <select class="u-sel" name="DIV_DelFlag">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.DelFlagList" id="comlist">
                            <option value="${comlist.comListValue}">${comlist.comListText}</option>
                        </s:iterator>
                    </select>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

