<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp" %>
    <script type="text/javascript">
        $ (function () {
            jQuery ('body').layout ({
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
            $ ('#list').grid ({
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
                    title: '${session.lang.AgencyNameText}',
                    name: 'agencyName',
                    visible: '${session.gridcol.agencyName}'
                }, {
                    title: '${session.lang.DepartmentText}',
                    name: 'departmentName',
                    visible: '${session.gridcol.departmentName}'
                }, {
                    title: '${session.lang.PositionText}',
                    name: 'positionName',
                    visible: '${session.gridcol.positionName}'
                }, {
                    title: '姓名',
                    name: 'userName',
                    visible: '${session.gridcol.userName}'
                }, {
                    title: '${session.lang.EmployeeCardText}',
                    name: 'employeeCard',
                    visible: '${session.gridcol.employeeCard}'
                }, {
                    title: '${session.lang.OperationText}',
                    name: '',
                    width: '130px',
                    visible: 'true',
                    format: function (r, t) {
                        return option (r);
                    }
                }],
                success: function (d) {
                    if (undefined == d.total) {
                        $ ("#number1").text (0);
                    } else if (0 == d.total) {
                        $ ("#number1").text (1);
                    } else {
                        $ ("#number1").text (d.total);
                    }
                    if (d.status < 0) {
                        artDialog (d.message, "OK");
                    }
                }
            });
        });
        $ (function () {
            $ ("#editDivUserPass").click (function () {
                $ ("#editDivUserPass").hide ();
                $ ("input[name=DivUserPass]").show ();//禁用密码修改修改
            });
        });
        /**
         * 操作列超链接
         */
        function option(r) {
            var $ul = $ ('<ul class="u-option"></ul>');
            var $li = $ ('');
            var ary_li = new Array ();
            ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click (function () {
                edit (r.customerID, r.customerVersion, this)
            }));
            ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click (function () {
                if (r.customerDelFlag == 0) {
                    del (r.customerID, r.customerVersion, r.customerUpdateTime, r.customerUpdateUser, this)
                }
            }));
            <%--ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitDetailText}</a></li>').click (function () {--%>
                <%--detail (r.customerID, r.customerVersion, this)--%>
            <%--}));--%>
            $.each (ary_li, function (i, o) {
                $li.after (o);
            });
            return $ul.append ($li);
        }
//        /**
//         * 编辑用户详细处理
//         */
//        function detail(id, version, obj) {
//            var param = {
//                userID: id,
//                opt: 'detail',
//                version: version
//            }
//            $.ajax ({
//                url: "userInfo.action",
//                type: "post",
//                dataType: "json",
//                data: param,
//                success: function (d) {
//                    wd_userdetail (d, id);
//                }
//            });
//        }
        /**
         * 编辑处理
         */
        function edit(id, version, obj) {
            var param = {
                userID: id,
                opt: 'edit',
                version: version
            }
            $.ajax ({
                url: "userInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog (d.message, "OK");
                    } else {
                        wd_user (d, id, obj);
                    }
                }
            });
        }
        /**
         * 编辑用户详细信息
         */
        function wd_userdetail(data, id) {
            $ ('#detailForm').form ('reset');
            var title = '${session.lang.EditDetailTitle}';
            $ ('#detailForm :input').removeClass ('u-ipt-err');
            $ (detailForm.opt).val ('detail');
            // 页面赋值
            $ (detailForm.DivUserID).val (id);//用户ID
            if (typeof  data.data != "undefined") {
                $ (detailForm.DivUserName).val (data.data.userName);//姓名
                $ (detailForm.DivUserSex).val (data.data.userSex);//性别
                $ (detailForm.DivUserAge).val (data.data.userAge);//年龄
                $ (detailForm.DivUserBirthday).val (fdate3 (data.data.userBirthday));//生年月日
                $ (detailForm.DivUserCardID).val (data.data.userCardID);//身份证号
                $ (detailForm.DivUserMobile).val (data.data.userMobile);//移动电话
                $ (detailForm.DivUserLandline).val (data.data.userLandline);//座机
                $ (detailForm.DivUserPrivacies).val (data.data.userPrivacies);//婚否
                $ (detailForm.DivUserUniversity).val (data.data.userUniversity);//毕业院校
                $ (detailForm.DivUserProfessional).val (data.data.userProfessional);//专业
                $ (detailForm.DivUserEducation).val (data.data.userEducation);//学历
                $ (detailForm.DivUserBloodGroup).val (data.data.userBloodGroup);//血型
                $ (detailForm.DivUserHeight).val (data.data.userHeight);//身高
                $ (detailForm.DivUserWeight).val (data.data.userWeight);//体重
                $ (detailForm.DivUpdateUser).val (data.data.updateUser);//更新者
                $ (detailForm.DivUpdateTime).val (data.data.updateTime);//更新时间
                $ (detailForm.DivVersion).val (data.data.version);//版本号
                $ (detailForm.DivDelFlag).val (data.data.delFlag);//删除区分
            }
            $ ('#detailForm').attr ('action', 'userDetail.action');
            $.dialog ({
                id: 'userDetail_dialog',
                title: title,
                lock: true,
                content: document.getElementById ('userDetail'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $ ('#detailForm').form ('submit', {
                            success: function (d) {
                                $ ('#detailForm :input').removeClass ('u-ipt-err');
                                $ ('#detailForm').find ("*").each (function () {
                                    if ($ (this).hasClass ("u-sel")) {
                                        $ (this).removeAttr ("style");
                                    }
                                });
                                if ($.parseJSON (d).status >= 0) {
                                    //插入成功
                                    $ ('#list').grid ('load');
                                    $.dialog.list['userDetail_dialog'].close ();
                                    artDialog ($.parseJSON (d).message, "OK");
                                } else if ($.parseJSON (d).status == -1) {
                                    artDialog (d.message, "OK");
                                } else {
                                    artDialog (setContorllBackColor ($ ('#detailForm'), $.parseJSON (d).message), "OK");
                                }
                            }
                        });
                        return false;
                    }
                }]
            });
            return false;
        }
        //添加用户
        function wd_user(data, id, obj) {
                 var txt = $ ("#userEditForm tr:eq(3) th:eq(1)").text ();
            if (txt == '') {
                var html = '<th width="150">真实姓名</th><td><input name="DivRealName" type="text" class="u-ipt" maxlength="36"></td>';
                $ ("#userEditForm tr:eq(3)").append (html);
            }
            $ ('#userEditForm').form ('reset');
            var title = '${session.lang.AddUserTitle}';
            $ ('#userEditForm :input').removeClass ('u-ipt-err');
            $ ('#userEditForm').find ("*").each (function () {
                if ($ (this).hasClass ("u-sel")) {
                    $ (this).removeAttr ("style");
                }
            });
            if (typeof(data) == 'object') {
                $ (userEditForm.opt).val ('edit');
                $ (userEditForm.DivUserName).attr ("disabled", "");//启用用户名输入
                $ ("#editDivUserPass").show ();
                $ ("input[name=DivUserPass]").hide ();//禁用密码修改修改
                // 页面赋值
                $ (userEditForm.DivUserID).val (id);//用户ID
                $ (userEditForm.DivUserName).val (data.data.userName);//用户名
                $ (userEditForm.DivUserPass).val (data.data.userPass);//密码
                $ (userEditForm.DivAgencyID).val (data.data.agencyID);//部门设定
                changeAgency (2, data.data.departmentID);//部门设定
                changeDepartment (2, data.data.positionID);//取得职务列表
                $ (userEditForm.DivUserType).val (data.data.userType);//用户类型
                $ (userEditForm.DivEmployeeCard).val (data.data.employeeCard);//员工卡
                $ (userEditForm.DivUpdateUser).val (data.data.customerUpdateUser);//更新者
                $ (userEditForm.DivUpdateTime).val (data.data.customerUpdateTime);//更新时间
                $ (userEditForm.DivVersion).val (data.data.customerVersion);//版本号
                $ (userEditForm.DivDelFlag).val (data.data.customerDelFlag);//删除区分
                $ (userEditForm.DivPass).val (data.data.expandSpace1);//删除区分
                $ ("#userEditForm tr:eq(3) th:eq(1)").remove ();
                $ ("#userEditForm tr:eq(3) td:eq(1)").remove ();
                $ ('#userEditForm').attr ('action', 'userEdit.action');
                title = '${session.lang.EditUserTitle}';
            } else {
                $ (userEditForm.DivDelFlag).val (0);//删除区分
                $ (userEditForm.DivUserName).removeAttr ("disabled");//禁用用户名修改
                $ ("#editDivUserPass").hide ();
                $ ("input[name=DivUserPass]").show ();//禁用密码修改修改
                $ (userEditForm.DivVersion).val (0);//版本号
                $ ('#userEditForm').attr ('action', 'userAdd.action');
            }
            $.dialog ({
                id: 'userEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById ('userEdit'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $ ('#userEditForm').form ('submit', {
                            success: function (d) {
                                $ ('#userEditForm :input').removeClass ('u-ipt-err');
                                $ ('#userEditForm').find ("*").each (function () {
                                    if ($ (this).hasClass ("u-sel")) {
                                        $ (this).removeAttr ("style");
                                    }
                                });
                                if ($.parseJSON (d).status >= 0) {
                                    var param = {
                                        opt: 'list',
                                        AgencyID: $ (userForm.AgencyID).val (),
                                        UserName: $ (userForm.UserName).val (),
                                        DepartmentID: $ (userForm.DepartmentID).val (),
                                        PositionID: $ (userForm.PositionID).val (),
                                        UserType: $ (userForm.UserType).val (),
                                        DelFlag: $ (userForm.DelFlag).val ()
                                    }
                                    $ ('#list').grid ('url', 'B11S004.action');
                                    $ ('#list').grid ('data', param);
                                    if ($ (userEditForm.opt).val () != 'edit') {
                                        $ ('#list').grid ('load', 1);
                                    } else {
                                        $ ('#list').grid ('load');
                                    }
                                    artDialog ($.parseJSON (d).message, "OK");
                                    $.dialog.list['userEdit_dialog'].close ();
                                } else if ($.parseJSON (d).status == -1) {
                                    artDialog (d.message, "OK");
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
                                    artDialog (setContorllBackColor ($ ('#userEditForm'), $.parseJSON (d).message), "OK");
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
            $.dialog.confirm ('${session.lang.UserDelInfo}', function () {
                var param = {
                    userID: id,
                    version: version,
                    async: false,
                    updatetime: time,
                    updateuser: user
                }
                $.ajax ({
                    url: "userDelete.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status >= 0) {
                            $ ('#list').grid ('load');
                        }
                        artDialog (d.message, "OK");
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
                AgencyID: $ (userForm.AgencyID).val (),
                UserName: $ (userForm.UserName).val (),
                DepartmentID: $ (userForm.DepartmentID).val (),
                PositionID: $ (userForm.PositionID).val (),
                UserType: $ (userForm.UserType).val (),
                DelFlag: $ (userForm.DelFlag).val ()
            }
            $ ('#list').grid ('url', 'B11S004.action');
            $ ('#list').grid ('data', param);
            $ ('#list').grid ('load', 1);
            return false;
        }
        /**
         * 取得机构下的部门
         */
        function changeAgency(i, f) {
            var param;
            if (i == 1) {
                param = {
                    AgencyID: $ (userForm.AgencyID).val ()
                }
            } else {
                param = {
                    AgencyID: $ (userEditForm.DivAgencyID).val ()
                }
            }
            $.ajax ({
                url: "changeAgency.action",
                type: "post",
                dataType: "json",
                data: param,
                async: false,
                success: function (d) {
                    if (d.status < 0) {
                        if (i == 1) {
                            $ (userForm.DepartmentID).find ('option').remove ();
                            $ (userForm.PositionID).find ('option').remove ();
                            $ (userForm.DepartmentID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $ (userForm.PositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {//编辑DIV
                            $ (userEditForm.DivDepartmentID).find ('option').remove ();
                            $ (userEditForm.DivPositionID).find ('option').remove ();
                            $ (userEditForm.DivDepartmentID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $ (userEditForm.DivPositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        }
                    } else {
                        if (i == 1) {//查询条件
                            $ (userForm.DepartmentID).find ('option').remove ();
                            $ (userForm.PositionID).find ('option').remove ();
                            $ (userForm.DepartmentID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $ (userForm.PositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (userForm.DepartmentID).append ("<option value='" + val.departmentID + "'>" + val.departmentName + "</option>");
                            });
                        } else {//编辑DIV
                            $ (userEditForm.DivDepartmentID).find ('option').remove ();
                            $ (userEditForm.DivPositionID).find ('option').remove ();
                            $ (userEditForm.DivDepartmentID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $ (userEditForm.DivPositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (userEditForm.DivDepartmentID).append ("<option value='" + val.departmentID + "'>" + val.departmentName + "</option>");
                            });
                            if (f != undefined) {
                                $ (userEditForm.DivDepartmentID).val (f);//职务设定
                            }
                        }
                    }
                }
            });
        }
        /**
         * 取得部门下的职务
         */
        function changeDepartment(i, f) {
            var param;
            if (i == 1) {
                param = {
                    DepartmentID: $ (userForm.DepartmentID).val (),
                    AgencyID: $ (userForm.AgencyID).val ()
                }
            } else {
                param = {
                    DepartmentID: $ (userEditForm.DivDepartmentID).val (),
                    AgencyID: $ (userEditForm.DivAgencyID).val ()
                }
            }
            $.ajax ({
                url: "changeDepartment.action",
                type: "post",
                dataType: "json",
                data: param,
                async: false,
                success: function (d) {
                    if (d.status < 0) {
                        if (i == 1) {//查询条件
                            $ (userForm.PositionID).find ('option').remove ();
                            $ (userForm.PositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {//编辑DIV
                            $ (userEditForm.DivPositionID).find ('option').remove ();
                            $ (userEditForm.DivPositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            if (f != undefined) {
                                $ (userEditForm.DivPositionID).val (f);//职务设定
                            }
                        }
                    } else {
                        if (i == 1) {//查询条件
                            $ (userForm.PositionID).find ('option').remove ();
                            $ (userForm.PositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (userForm.PositionID).append ("<option value='" + val.positionID + "'>" + val.positionName + "</option>");
                            });
                        } else {//编辑DIV
                            $ (userEditForm.DivPositionID).find ('option').remove ();
                            $ (userEditForm.DivPositionID).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (userEditForm.DivPositionID).append ("<option value='" + val.positionID + "'>" + val.positionName + "</option>");
                            });
                            if (f != undefined) {
                                $ (userEditForm.DivPositionID).val (f);//职务设定
                            }
                        }
                    }
                }
            });
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页:首页 > 用户管理模块> 用户管理</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="userForm" name="userForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        员工号
                    </th>
                    <td>
                        <input name="UserName" type="text" class="u-ipt" maxlength="36">
                    </td>
                    <th width="150">
                        用户类型
                    </th>
                    <td>
                        <select class="u-sel" name="UserType">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.UserTypeList" id="comlist">
                                <s:if test='%{#comlist.comListValue == #request.UserType}'>
                                    <option value="${comlist.comListValue}" selected>
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
                    <th width="150">
                        机构
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
                </tr>
                <tr>

                    <th width="150">
                        ${sessionScope.lang.DepartmentText}
                    </th>
                    <td>
                        <select class="u-sel" name="DepartmentID" onchange="return changeDepartment(1)">
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
                        ${sessionScope.lang.PositionText}
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
<div id="userEdit" class="f-dn">
    <form id="userEditForm" name="userEditForm" method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivUserID"/>
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivUpdateUser"/>
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <input type="hidden" class="f-dn" name="DivPass"/>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserNameText}
                </th>
                <td>
                    <input name="DivUserName" size="20" type="text" class="u-ipt" maxlength="36">
                </td>
                <th width="150">
                    ${sessionScope.lang.UserPassText}
                </th>
                <td>
                    <input name="DivUserPass" type="password" class="u-ipt" maxlength="255">
                    <span><a href="javascript:void(0)" id="editDivUserPass">修改密码</a></span>
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.AgencyNameText}
                </th>
                <td>
                    <select class="u-sel" name="DivAgencyID"
                            onchange="return changeAgency(2)">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.AgencyList" id="agency">
                            <option value="${agency.agencyID}">
                                    ${agency.agencyName}
                            </option>
                        </s:iterator>
                    </select>
                </td>
                <th width="150">
                    ${sessionScope.lang.DepartmentText}
                </th>
                <td>
                    <select class="u-sel" name="DivDepartmentID"
                            onchange="return changeDepartment(2)">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.DepartmentList" id="department">
                            <option value="${department.departmentID}">
                                    ${department.departmentName}
                            </option>
                        </s:iterator>
                    </select>
                </td>

            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.PositionText}
                </th>
                <td>
                    <select class="u-sel" name="DivPositionID">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.PositionList" id="position">
                            <option value="${position.positionID}">
                                    ${position.positionName}
                            </option>
                        </s:iterator>
                    </select>
                </td>
                <th width="150">
                    ${sessionScope.lang.UserTypeText}
                </th>
                <td>
                    <select class="u-sel" name="DivUserType">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.UserTypeList" id="comlist">
                            <option value="${comlist.comListValue}">
                                    ${comlist.comListText}
                            </option>
                        </s:iterator>
                    </select>
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.EmployeeCardText}
                </th>
                <td>
                    <input name="DivEmployeeCard" type="text" class="u-ipt" maxlength="36">
                </td>
                <th width="150">
                    真实姓名
                </th>
                <td>
                    <input name="DivRealName" type="text" class="u-ipt" maxlength="36">
                </td>
            </tr>
        </table>
    </form>
</div>
<div id="userDetail" class="f-dn">
    <form id="detailForm" name="detailForm" method="post">
        <input type="text" class="f-dn" name="DivCustomerID"/>
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivUserID" value="${requestScope.DivUserID}"/>
        <input type="text" class="f-dn" name="DivDetailID" value="${requestScope.DivDetailID}"/>
        <input type="text" class="f-dn" name="DivVersion" value="${requestScope.DivVersion}"/>
        <input type="text" class="f-dn" name="DivUpdateUser" value="${requestScope.DivUpdateUser}"/>
        <input type="text" class="f-dn" name="DivUpdateTime" value="${requestScope.DivUpdateTime}"/>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    ${sessionScope.lang.DetailNameText}
                </th>
                <td>
                    <input name="DivUserName" type="text" class="u-ipt">
                </td>
                <th width="150">
                    ${sessionScope.lang.UserSexText}
                </th>
                <td>
                    <select class="u-sel" name="DivUserSex">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.UserSexList" id="comlist">
                            <s:if test='%{#comlist.comListValue == #request.UserSex}'>
                                <option value="${comlist.comListValue}" selected>
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
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserAgeText}
                </th>
                <td>
                    <input name="DivUserAge" type="text" class="u-ipt" maxlength="3">
                </td>
                <th width="150">
                    ${sessionScope.lang.UserBirthdayText}
                </th>
                <td>
                    <input name="DivUserBirthday" class="u-ipt Wdate" onclick="WdatePicker()" type="text"/>
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserCardIDText}
                </th>
                <td>
                    <input name="DivUserCardID" type="text" class="u-ipt" maxlength="18">
                </td>
                <th width="150">
                    ${sessionScope.lang.UserMobileText}
                </th>
                <td>
                    <input name="DivUserMobile" type="text" class="u-ipt" maxlength="11">
                </td>
            </tr>
            <tr>
                <th width="150">
                    邮箱
                </th>
                <td>
                    <input name="DivUserLandline" type="text" class="u-ipt" maxlength="13">
                </td>
                <th width="150">
                    ${sessionScope.lang.UserPrivaciesText}
                </th>
                <td>
                    <select class="u-sel" name="DivUserPrivacies">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.UserPrivaciesList" id="comlist">
                            <s:if test='%{#comlist.comListValue == #request.UserPrivacies}'>
                                <option value="${comlist.comListValue}" selected>
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
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserUniversityText}
                </th>
                <td>
                    <input name="DivUserUniversity" type="text" class="u-ipt" maxlength="200"/>
                </td>
                <th width="150">
                    ${sessionScope.lang.UserProfessionalText}
                </th>
                <td>
                    <input name="DivUserProfessional" type="text" class="u-ipt" maxlength="200"/>
                </td>
            </tr>
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserEducationText}
                </th>
                <td>
                    <input name="DivUserEducation" type="text" class="u-ipt" maxlength="200"/>
                </td>
                <th width="150">
                    ${sessionScope.lang.UserBloodGroupText}
                </th>
                <td>
                    <select class="u-sel" name="DivUserBloodGroup">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.UserBloodGroupList" id="comlist">
                            <s:if
                                    test='%{#comlist.comListValue == #request.UserBloodGroup}'>
                                <option value="${comlist.comListValue}" selected>
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
            <tr>
                <th width="150">
                    ${sessionScope.lang.UserHeightText}
                </th>
                <td>
                    <input name="DivUserHeight" type="text" class="u-ipt" maxlength="6"/>
                </td>
                <th width="150">
                    ${sessionScope.lang.UserWeightText}
                </th>
                <td>
                    <input name="DivUserWeight" type="text" class="u-ipt" maxlength="6"/>
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

