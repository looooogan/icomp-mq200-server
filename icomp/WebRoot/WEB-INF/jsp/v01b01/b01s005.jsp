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
//              async:false,
              rowno: true,
              rows:${session.rowsize},
              roll: 6,
              pager: true,
              pagerpos: 'right',
              pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '补领单号',
                    name: 'replacementID'
                },{
                    title: '材料号',
                    name: 'toolCode'
                }, {
                    title: '补领原因',
                    name: 'replacementReason',
                    format: function (r) {
                        //0.借用 1.补充周转量 2.特殊领用
                        if (r.replacementReason == 0) {
                            return '<span class="ui-grid-tdtx">借用</span>';
                        }
                        else if (r.replacementReason == 1) {
                            return '<span class="ui-grid-tdtx">补充周转量</span>';
                        }
                        else if (r.replacementReason == 2) {
                            return '<span class="ui-grid-tdtx">特殊领用</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '时间',
                    name: 'applyTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate1(r.applyTime) + '</span>';
                    }
                }, {
                    title: '借用归还状态',
                    name: 'stockState',
                    format: function (r) {
                        //0.aaaa 1.bbbb 2.cccc
                        if (r.stockState == 0) {
                            return '<span class="ui-grid-tdtx">已归还-未到期</span>';
                        }
                        else if (r.stockState == 1) {
                            return '<span class="ui-grid-tdtx">未归还-未到期</span>';
                        }
                        else if (r.stockState == 2) {
                            return '<span class="ui-grid-tdtx">未归还-已到期</span>';
                        }else {
                            return '<span class="ui-grid-tdtx">无</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '借用周期',
                    name: 'cycle'

                }, {
                    title: '申领人',
                    name: 'applyUser'
                },
                    {
                        title: '部门',
                        name: 'departmentName'
                    }, {
                        title: '联系电话',
                        name: 'departmentTel'
                    },{
                       title: '邮箱',
                        name: 'emil'
                   },{
                        title: '单位',
                        name: 'expandSpace1'
                    },
                    {
                        title: '经办人',
                        name: 'receiveUser'
                    }, {
                        title: '操作',
                        name: '-',
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
                edit(r.replacementID, '', this)
            }));
            ary_li.push($('<li><a href="javascript:void(0)">明细</a></li>').click(function () {
                showDd(r)
            }));
            $.each(ary_li, function (i, o) {
                $li.after(o);
            });
            return $ul.append($li);
        }


        function onchh(){
                var a = $("#reissueReason").val();
                if (a == 0) {
                    $("#returnStatus").show();
                } else {
                    $("#returnStatus").hide();
                }

        }


        //编辑下拉
         function Divonchh(){

                var a = $("#DIVreissueReason").val();
                if (a == 0) {
                    $("#DIVreturnStatus").show();
                    $("#receiveDepartment").show();
//                    $("#DivDay").attr("disabled", false);
//                    $("#jyday").css({color:"black"});
//                    $("#DivDay").val("");


                    $("#DivDay").show();
                    $("#jyday").show();
                    $("#DivDay").val("");

                    $("#jydwip").show();
                    $("#jydwip").val("");
                    $("#jydw").show();
                    $("#jybmip").show();
                    $("#jybmip").val("");
                    $("#jybm").show();
                    $("#jyrip").show();
                    $("#jyrip").val("");
                    $("#jyr").show();
                    $("#jytelip").show();
                    $("#jytelip").val("");
                    $("#jytel").show();
                    $("#jyemilip").show();
                    $("#jyemilip").val("");
                    $("#jyemil").show();
                    $("#DivRede").hide();
                    $("#lybm").hide();
                    $("#DivRede").val("");
                    $("#DivapplyUsers").hide();
                    $("#slr").hide();
                    $("#DivapplyUsers").val("");


                } else {
                    $("#DIVreturnStatus").hide();

                    $("#DivDay").hide();
                    $("#jyday").hide();
                    $("#DivDay").val("");

                    $("#jydwip").hide();
                    $("#jydw").hide();
                    $("#jydwip").val("");

                    $("#jybmip").hide();
                    $("#jybm").hide();
                    $("#jybmip").val("");

                    $("#jyrip").hide();
                    $("#jyr").hide();
                    $("#jyrip").val("");

                    $("#jytelip").hide();
                    $("#jytel").hide();
                    $("#jytelip").val("");

                    $("#jyemilip").hide();
                    $("#jyemil").hide();
                    $("#jyemilip").val("");

                    $("#DivRede").show();
                    $("#lybm").show();
                    $("#DivRede").val("");

                    $("#DivapplyUsers").show();
                    $("#slr").show();
                    $("#DivapplyUsers").val("");

                }

        }


        /**
         * 查询处理
         */
        function search() {

            var param = {
                opt: 'list',
                replacementID: $(printForm.replacementID).val(),
                dstar: $(printForm.dstar).val(),
                dends: $(printForm.dend).val(),
                reissueReason: $(printForm.reissueReason).val(),
                systeCode: $(printForm.systeCode).val(),
                returnStatus: $(printForm.returnStatus).val(),
                applyPerson: $(printForm.applyPerson).val(),
                operator: $(printForm.operator).val(),
                receiveDepartment: $(printForm.receiveDepartment).val(),

            }
            $('#list').grid('url', 'B01S005.action');
            $('#list').grid('data', param);
            $('#list').grid('load', 1);
            return false;
        }

        /**
         * 删除处理
         */
        function del(id, version, time, user, obj) {
            $.dialog.confirm('${session.lang.RoleDelInfo}', function () {
                var param = {
                    ID: id,
                    version: version,
                    updatetime: time,
                    updateuser: user
                }
                $.ajax({
                    url: "printItemDelete.action",
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
        //详细
        function showDd(obj) {

            $(printEditForm2.DIVreplacementID).val(obj.replacementID).attr("disabled", true);

            //材料号
            $(printEditForm2.DIVsysteCode).val(obj.toolCode).attr("disabled", true);;
            $(printEditForm2.DIV_DepartmentID).val(obj.departmentID).attr("disabled", true);;
            //补领原因
            $(printEditForm2.DIVreissueReason).val(obj.replacementReason).attr("disabled", true);;

            //借用归还状态0借用状态显示 其他不显示
            var c = obj.replacementReason;
            if(c==0){
                $(printEditForm2.DIVreturnStatus).val(obj.stockState).show().attr("disabled", true);;
            }else {
                $(printEditForm2.DIVreturnStatus).hide().attr("disabled", true);;
            }
            if(c==0){
                $("#jyday1").show();
                $(printEditForm2.DivDay).val(obj.cycle).show().attr("disabled", true);;

                $("#jydw1").show();
                $(printEditForm2.Divdv).val(obj.expandSpace1).show().attr("disabled", true);;

                $("#jybm1").show();
                $(printEditForm2.Divbm).val(obj.departmentName).show().attr("disabled", true);;

                $("#jyr1").show();
                $(printEditForm2.Divjyr).val(obj.applyUser).show().attr("disabled", true);;

                $("#jytel1").show();
                $(printEditForm2.DivTel).val(obj.departmentTel).show().attr("disabled", true);;

                $("#jyemil1").show();
                $(printEditForm2.DivEmil).val(obj.emil).show().attr("disabled", true);;

                $("#DivRede1").hide();
                $("#lybm1").hide();

                $("#DivapplyUsers1").hide();
                $("#slr1").hide();

                $("#ghsj").show();
                $(printEditForm2.DivReturnTime).show();
            }else {
                $("#jyday1").hide();
                $(printEditForm2.DivDay).hide();

                $("#jydw1").hide();
                $(printEditForm2.Divdv).hide();

                $("#jybm1").hide();
                $(printEditForm2.Divbm).hide();

                $("#jyr1").hide();
                $(printEditForm2.Divjyr).hide();

                $("#jytel1").hide();
                $(printEditForm2.DivTel).hide();

                $("#jyemil1").hide();
                $(printEditForm2.DivEmil).hide();

                $("#ghsj").hide();
                $(printEditForm2.DivReturnTime).hide();
                //领用部门
                $("#DivRede1").show().val(obj.departmentName).attr("disabled", true);
                $("#slr1").show();
                //申领人
                $("#DivapplyUsers1").show().val(obj.applyUser).attr("disabled", true);

              $("#lybm1").show().attr("disabled", true);
            }
            //隐藏域传值
            $(printEditForm2.DIVreturnStatush).val(obj.stockState).attr("disabled", true);
            //申领时间
            var  tc = obj.applyTime;
            if(tc==null||undefined==tc){
                $(printEditForm2.DIVtime).val(obj.applyTime).attr("disabled", true);
            }else {
                var  tcs = tc.split("T");
                var tcse = tcs[0]+" "+tcs[1];
                $(printEditForm2.DIVtime).val(tcse).attr("disabled", true);
            }
            $(printEditForm2.DIVtimeh).val(obj.applyTime).attr("disabled", true);
            //申领人
            $(printEditForm2.DIVapplyUser).val(obj.applyID).attr("disabled", true);
            $(printEditForm2.DIVapplyUserh).val(obj.applyUser).attr("disabled", true);

            //申领部门
            $(printEditForm2.DIVreceiveDepartment).val(obj.departmentID).attr("disabled", true);


            //申领数量
            $(printEditForm2.DivNuber).val(obj.appliedNumber).attr("disabled", true);
            $(printEditForm2.DivNuber).val(obj.appliedNumber).attr("disabled", true);
            //领取人
            $(printEditForm2.DivUser).val(obj.receiveUser).attr("disabled", true);
            $(printEditForm2.DivUserh).val(obj.receiveUser).attr("disabled", true);

            $(printEditForm2.DivUpdateTime).val(obj.updateTime);//更新时间
            $(printEditForm2.DivVersion).val(obj.version);//版本号
            $(printEditForm2.DivUpdateUser).val(obj.updateUser);//更新者
            $(printEditForm2.DIVDelFlag).val(obj.delFlag);//删除区分

            var ob = obj.toolCode;
            var bc = ob.charAt(0);
            $(printEditForm2.DivToolCode).val(bc);
            //申领数量
            $(printEditForm2.DivBorrowNum).val(obj.appliedTotalNumber);
            //领取人

            var  tc =obj.returnTime;

            if(tc==null||undefined==tc){

                $(printEditForm2.DivReturnTime).val(obj.returnTime);
            }else {

                var  tcs = tc.split("T");
                var tcse = tcs[0]+" "+tcs[1];
                $(printEditForm2.DivReturnTime).val(tcse);
            }

            $.dialog({
                id: 'tj_list_dialog',
                title: '详细',
                lock: true,
                content: document.getElementById('printEdit2'),
            });
        }


        /**
         * 编辑处理
         */
        function edit(id, version, obj) {
            var param = {
                replacementID: id,
            }
            $.ajax({
                url: "replacementInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    } else {
                        wd_printEdit(d, id, obj);
                    }
                }
            });
        }
        /**
         * 部门与用户联动
         *
         */

        $(function () {
            $("#receiveDepartment").change(function () {
                param = {
                    departmentID: $("#receiveDepartment").val(),}
                $.ajax({
                    url: "replacementLink.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {

                        if (d.status < 0) {
                            $(printForm.applyUsers).find('option').remove();
                            $(printForm.applyUsers).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            var  optins = '<option value="">--' + "${sessionScope.lang.PleaseSelect}" + '--</option>"';
                            $(printForm.applyUsers).find('option').remove();
                            $(printForm.applyUsers).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                optins+='<option value="' + val.customerID + '">' + val.userName + '</option>';
                            })
                            $(printForm.applyPerson).empty();
                            $(printForm.applyPerson).append(optins);
                        }
                    }
                });
            });

            //导出
            $("#infoExport").click(function () {
                $.dialog.confirm('您确定要导出么？', function (){
                    $("#systeCodeHid").val($(printForm.systeCode).val()); //材料号
                    $("#reissueReasonHid").val($(printForm.reissueReason).val()); //补领原因
                    $("#returnStatusHid").val($(printForm.returnStatus).val()); //借用归还状态
                    $("#dstarHid").val($(printForm.dstar).val()); //开始时间
                    $("#dendsHid").val($(printForm.dend).val()); //结束时间
                    $("#receiveDepartmentHid").val($(printForm.receiveDepartment).val()); //领用部门
                    $("#applyPersonHid").val($(printForm.applyPerson).val()); //经办人
                    $("#operatorHid   ").val($(printForm.operator).val()); //申领人
                    $("#hidFrom").submit();
                });

            });
        });
        $(function () {
            $("#DivRede").change(function () {

                param = {
                    departmentID: $("#DivRede").val(),}
                $.ajax({
                    url: "replacementLink.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {

                        if (d.status < 0) {
                            $("#DivapplyUsers").find('option').remove();
                            $("#DivapplyUsers").append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            var  optins = '<option value="">--' + "${sessionScope.lang.PleaseSelect}" + '--</option>"';
                            $("#DivapplyUsers").find('option').remove();
                            $("#DivapplyUsers").append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                optins+='<option value="' + val.customerID + '">' + val.userName + '</option>';
                            })
                            $("#DivapplyUsers").empty();
                            $("#DivapplyUsers").append(optins);
                        }
                    }
                });
            });
        });

        //添加
        function wd_printEdit(data, id, obj) {

            $('#printEditForm').form('reset');
            var title = '新建补领单';
            $('#printEditForm :input').removeClass('u-ipt-err');
            $('#printEditForm').find("*").each(function () {
                if ($(this).hasClass("u-sel")) {
                    $(this).removeAttr("style");

                }
            });
            if (typeof(data) == 'object') {
                $(printEditForm.opt).val('edit');
                $(printEditForm.DIVreplacementID).val(id);
                $(printEditForm.DIVreplacementIDh);
                $(printEditForm.DIVreplacementID).val(data.data.replacementID);
                $(printEditForm.DIVreplacementIDh).val(data.data.replacementID);
                //材料号
                $(printEditForm.DIVsysteCode).val(data.data.toolCode);
                $(printEditForm.DIVsysteCodeh).val(data.data.toolCode);
                $(printEditForm.DIV_DepartmentID).val(data.data.departmentID);
                //补领原因
                $(printEditForm.DIVreissueReason).val(data.data.replacementReason);
                $(printEditForm.DIVreissueReasonh).val(data.data.replacementReason);
                //借用归还状态0借用状态显示 其他不显示
                var c = data.data.replacementReason;
                if(c==0){
                    $(printEditForm.DIVreturnStatus).val(data.data.stockState).show();
                }else {
                    $(printEditForm.DIVreturnStatus).hide();
                }
                if(c==0){
                    var b = data.data.applyUser;
                    //2017/11/03 王冉 变更↓↓↓　dazhong@YMSC
                    var sb =b.split("#");
                    //2017/11/03 王冉 追加↑↑↑　dazhong@YMSC

                    $("#jyday").show();
                    $(printEditForm.DivDay).val(data.data.cycle).show();

                    $("#jydw").show();
                    $(printEditForm.Divdv).val(sb[0]).show();

                    $("#jybm").show();
                    $(printEditForm.Divbm).val(sb[1]).show();

                    $("#jyr").show();
                    $(printEditForm.Divjyr).val(sb[2]).show();

                    $("#jytel").show();
                    $(printEditForm.DivTel).val(sb[3]).show();

                    $("#jyemil").show();
                    $(printEditForm.DivEmil).val(sb[4]).show();

                    $("#DivRede").hide();
                    $("#lybm").hide();

                    $("#DivapplyUsers").hide();
                    $("#slr").hide();
                }else {
                    $("#jyday").hide();
                    $(printEditForm.DivDay).hide();

                    $("#jydw").hide();
                    $(printEditForm.Divdv).hide();

                    $("#jybm").hide();
                    $(printEditForm.Divbm).hide();

                    $("#jyr").hide();
                    $(printEditForm.Divjyr).hide();

                    $("#jytel").hide();
                    $(printEditForm.DivTel).hide();

                    $("#jyemil").hide();
                    $(printEditForm.DivEmil).hide();

                    $("#DivRede").show();
                    $("#lybm").show();

                    $("#DivapplyUsers").show();
                    $("#slr").show();
                }
                //隐藏域传值
                $(printEditForm.DIVreturnStatush).val(data.data.stockState);
                //申领时间
                var  tc = data.data.applyTime;
                if(tc==null||undefined==tc){
                    $(printEditForm.DIVtime).val(data.data.applyTime);
                }else {
                    var  tcs = tc.split("T");
                    var tcse = tcs[0]+" "+tcs[1];
                    $(printEditForm.DIVtime).val(tcse);
                }
                $(printEditForm.DIVtimeh).val(data.data.applyTime);
                //申领人
                $(printEditForm.DIVapplyUser).val(data.data.applyID);
                $(printEditForm.DIVapplyUserh).val(data.data.applyUser);

                //申领部门
                $(printEditForm.DIVreceiveDepartment).val(data.data.departmentID);
                $(printEditForm.DIVreceiveDepartmenth).val(data.data.departmentID);

                //申领数量
                $(printEditForm.DivNuber).val(data.data.appliedNumber);
                $(printEditForm.DivBorrowNum).val(data.data.appliedTotalNumber);
                //领取人
                $(printEditForm.DivUser).val(data.data.receiveUser);
                $(printEditForm.DivUserh).val(data.data.receiveUser);

                $(printEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
                $(printEditForm.DivVersion).val(data.data.version);//版本号
                $(printEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
                $(printEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
                //编辑
                title = '补领编辑';
                $(printEditForm.DIVsysteCode);
                $(printEditForm.DIVreplacementID);
                $(printEditForm.DIVreissueReason);

                $(printEditForm.DIVtime);
                $(printEditForm.DIVapplyUser);
                $(printEditForm.DIVreceiveDepartment);
                $(printEditForm.DivUser);
                $('#printEditForm').attr('action','replacementEdit.action');

            } else {
                $(printEditForm.DIVreturnStatus).show();
                $("#jyday").show();
                $(printEditForm.DivDay).show();
                $("#jydw").show();
                $(printEditForm.Divdv).show();
                $("#jybm").show();
                $(printEditForm.Divbm).show();
                $("#jyr").show();
                $(printEditForm.Divjyr).show();
                $("#jytel").show();
                $(printEditForm.DivTel).show();
                $("#jyemil").show();
                $(printEditForm.DivEmil).show();
                $("#DivRede").show();
                $("#lybm").show();
                $("#DivapplyUsers").show();
                $("#slr").show();
                //添加flase
                $(printEditForm.DIVsysteCode).removeAttr("disabled");
                $(printEditForm.DIVreplacementID).removeAttr("disabled");
                $(printEditForm.DIVreissueReason).removeAttr("disabled");
                $(printEditForm.DIVreturnStatus).removeAttr("disabled");
                $(printEditForm.DIVtime).removeAttr("disabled");
                $(printEditForm.DIVapplyUser).removeAttr("disabled");
                $(printEditForm.DIVreceiveDepartment).removeAttr("disabled");
                $(printEditForm.DivUser).removeAttr("disabled");
                $(printEditForm.DivDay).val();//版本号改为周期

                $('#printEditForm').attr('action', 'replacementAdd.action');
            }
            debugger;
            $.dialog({
                id: 'printEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById('printEdit'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $('#printEditForm').form('submit', {
                            success: function (d) {
                                $('#printEditForm :input').removeClass('u-ipt-err');
                                $('#printEditForm').find("*").each(function () {
                                    if ($(this).hasClass("u-sel")) {
//                                        $(this).removeAttr("style");
                                    }
                                });
                                if ($.parseJSON(d).status >= 0) {
                                    var param = {
                                        opt: 'list',
                                        PageName: $(printEditForm.PageName).val()
                                    }
                                    $('#list').grid('url', 'B01S005.action');
                                    $('#list').grid('data', param);
                                    if ($(printEditForm.opt).val() != 'edit') {
                                        $('#list').grid('load', 1);
                                    } else {
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message, "OK");
                                    $.dialog.list['printEdit_dialog'].close();
                                } else if ($.parseJSON(d).status == -1) {
                                    artDialog(d.message, "OK");
                                } else {
                                    artDialog(setContorllBackColor($('#printEditForm'), $.parseJSON(d).message), "OK");
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

<div id="hiddDiv" style="display: none">
    <form action="exportExcel01S005.action" method="post" id="hidFrom">
        <input type="hidden" name="systeCode"      id="systeCodeHid">
        <input type="hidden" name="reissueReason"   id="reissueReasonHid">
        <input type="hidden" name="dstars"       	id="dstarHid">
        <input type="hidden" name="dends"    	     id="dendsHid">
        <input type="hidden" name="receiveDepartment"    id="receiveDepartmentHid">
        <input type="hidden" name="applyPerson"   	  id="applyPersonHid">
        <input type="hidden" name="operator"        id="operatorHid">
        <input type="hidden" name="returnStatus"        id="returnStatusHid">
    </form>
</div>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>库存信息>补领信息查询</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="printForm" name="printForm" method="post">
            <input type="hidden" name="replacementID">

            <table width="100%" class="m-frmtb">
                <tr>
                    <th>
                        材料号
                    </th>

                    <td>
                        <input name="systeCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                    </td>

                    <th width="150">
                        补领原因
                    </th>
                    <td>
                        <select class="u-sel" name="reissueReason" id="reissueReason" maxlength="6" onchange="onchh()">
                            <option value="">
                                --请选择--
                            </option>
                            <option value="0">
                                借用
                            </option>
                            <option value="1">
                                补充周转量
                            </option>

                            <option value="2">
                                特殊领用
                            </option>

                        </select>
                    </td>
                    <th width="150">
                        借用归还状态
                    </th>
                    <td>
                        <select class="u-sel" name="returnStatus" selected="selected"  maxlength="6" id="returnStatus" style="display: none">
                            <option value="">
                                --请选择--
                            </option>

                            <option value="0">
                                已归还-未到期
                            </option>

                            <option value="1">
                                未归还-未到期
                            </option>

                            <option value="2">
                               未归还-已到期
                            </option>


                        </select>
                    </td>


                </tr>
                <tr>
                    <th width="150">
                        补领时间段
                    </th>

                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>


                    <th width="150" >
                        领用部门
                    </th>
                    <td>
                        <select name="receiveDepartment" class="u-sel" maxlength="6" id="receiveDepartment">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.DepartmentList" id="d">
                            <option value="${d.departmentID}">${d.departmentName}</option>
                        </s:iterator>
                        </select>
                    </td>
                    <th width="150" id="lyslr">
                        申请人
                    </th>
                    <td>
                               <input name="applyPerson" type="text" class="u-ipt" maxlength="8">
                    </td>


                </tr>
                <tr>
                    <th width="150">
                        经办人
                    </th>
                    <td>
                        <input name="operator" type="text" class="u-ipt" maxlength="8">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" onclick="return wd_printEdit()">${sessionScope.lang.submitAddText}</button>
                <button type="button" class="u-btn2" id="infoExport"> 导出</button>
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
        <input type="text" class="f-dn" name="DivUpdateUser"/>
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <input type="text" class="f-dn" name="DivreplacementID"/>
        <input type="text" class="f-dn" name="DIVDelFlag"/>
        <input type="text" class="f-dn" name="DIVreplacementIDh"/>
        <input type="text" class="f-dn" name="DIVsysteCodeh"/>
        <input type="text" class="f-dn" name="DIVreissueReasonh"/>
        <input type="text" class="f-dn" name="DIVreturnStatush"/>
        <input type="text" class="f-dn" name="DIVtimeh"/>
        <input type="text" class="f-dn" name="DIVreceiveDepartmenth"/>
        <input type="text" class="f-dn" name="DIVapplyUserh"/>
        <input type="text" class="f-dn" name="DivUserh"/>


        <table class="m-frmtb" width="100%">
            <tr>

                <th width="150">
                    材料号
                </th>
                <td>
                    <input name="DIVsysteCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                </td>


                <th width="150">
                    补领原因
                </th>
                <td>
                    <select class="u-sel" name="DIVreissueReason" id="DIVreissueReason" maxlength="2"  onchange="Divonchh()">
                        <option value="">
                            --请选择--
                        </option>

                        <option value="0">
                            借用
                        </option>

                        <option value="1">
                            补充周转量
                        </option>

                        <option value="2">
                            特殊领用
                        </option>

                    </select>
                    <select class="u-sel" name="DIVreturnStatus" id="DIVreturnStatus" maxlength="2" style ="display: none">
                        <option value="">
                            --请选择--
                        </option>

                        <option value="0">
                            已归还-未到期
                        </option>

                        <option value="1">
                            未归还-未到期
                        </option>

                        <option value="2">
                            未归还-已到期
                        </option>

                    </select>
                </td>
            </tr>
            <tr>

                <th width="150">
                    补领时间
                </th>
                <td>
                    <input name="DIVtime" type="text" class="u-ipt Wdate"  onclick="WdatePicker()" >
                </td>
                <th width="150">
                    申领数量
                </th>
                <td>
                    <input name="DivBorrowNum" type="text" class="u-ipt" maxlength="6" >
                </td>

                </tr>
<%--            <tr>
                <th width="150" id="lybm">
                    领用部门
                </th>
                <td>
                    <select class="u-sel" name="DIVreceiveDepartment" selected="selected" id="DivRede">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.DepartmentList" id="d">
                            <option value="${d.departmentID}">
                                    ${d.departmentName}</option>
                        </s:iterator>
                    </select>

                </td>

                <th width="150" id="slr">
                    申领人
                </th>
                <td>
                    <select name="DIVapplyUser" class="u-sel"  id="DivapplyUsers">
                       <option value="">--${sessionScope.lang.PleaseSelect}--</option>
                        <s:if test="#request.vapplyList!=null">
                            <s:iterator value="#request.vapplyList" id="ts">
                                <s:if test='%{#ts.departmentID == #request.DepartmentID}'>
                                    <option value="${ts.customerID}">${ts.userName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${ts.customerID}"selected="selected">${ts.userName}</option>
                                </s:else>
                            </s:iterator>
                        </s:if>
                        <s:else>
                            <s:iterator value="#request.UserLists" id="us">
                                <option value="${us.customerID}">${us.userName}</option>
                            </s:iterator>
                        </s:else>

                    </select>
                </td>


            </tr>--%>
            <tr>

                <th width="150" id="jyday">
                    借用周期（天）
                </th>
                <td>
                    <input name="DivDay"  id="DivDay" type="text" class="u-ipt" maxlength="3">
                </td>
                <th width="150" id="jydw">
                    借用单位
                </th>
                <td>
                    <input name="Divdv" id="jydwip" type="text" class="u-ipt" maxlength="10" >
                </td>
            </tr>
            <tr>
                <th width="150" id="jybm">
                    借用部门
                </th>
                <td>
                    <input name="Divbm"  id="jybmip" type="text" class="u-ipt" maxlength="6">
                </td>

                <th width="150" id="jyr">
                    借用人
                </th>
                <td>
                    <input name="Divjyr" id="jyrip" type="text" class="u-ipt" maxlength="6" >
                </td>
            </tr>
            <tr>

                <th width="150" id="jytel">
                    借用人电话
                </th>
                <td>
                    <input name="DivTel" id="jytelip" type="text" class="u-ipt" maxlength="12">
                </td>

                <th width="150" id="jyemil">
                    借用邮箱
                </th>
                <td>
                    <input name="DivEmil" id="jyemilip" type="text" class="u-ipt" maxlength="20" >
                </td>
            </tr>
        </table>
    </form>
</div>

<%--详情--%>
<div id="printEdit2" class="f-dn">
    <form id="printEditForm2" name="printEditForm2" method="post">
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    刀具类型
                </th>
                <td>
                    <input name="DivToolCode" type="text" class="u-ipt" maxlength="36" disabled >
                </td>
                <th width="150">
                    申请数量
                </th>
                <td>
                    <input name="DivBorrowNum" type="text" class="u-ipt" maxlength="36" disabled >
                </td>
            </tr>


            <tr>

                <th width="150">
                    材料号
                </th>
                <td>
                    <input name="DIVsysteCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                </td>


                <th width="150">
                    补领原因
                </th>
                <td>
                    <select class="u-sel" name="DIVreissueReason" id="DIVreissueReason1" maxlength="2"  >
                        <option value="">
                            --请选择--
                        </option>

                        <option value="0">
                            借用
                        </option>

                        <option value="1">
                            补充周转量
                        </option>

                        <option value="2">
                            特殊领用
                        </option>

                    </select>
                    <select class="u-sel" name="DIVreturnStatus" id="DIVreturnStatus1" maxlength="2" style ="display: none">
                        <option value="">
                            --请选择--
                        </option>

                        <option value="0">
                            已归还-未到期
                        </option>

                        <option value="1">
                            未归还-未到期
                        </option>

                        <option value="2">
                            未归还-已到期
                        </option>

                    </select>
                </td>
            </tr>
            <tr>

                <th width="150">
                    补领时间
                </th>
                <td>
                    <input name="DIVtime" type="text" class="u-ipt Wdate"  onclick="WdatePicker()" >
                </td>
                <th width="150">
                    已领数量
                </th>
                <td>
                    <input name="DivNuber" type="text" class="u-ipt" maxlength="6" >
                </td>

            </tr>
            <tr>
                <th width="150" id="lybm1">
                    领用部门
                </th>
                <td>
                       <input  id="DivRede1" type="text" class="u-ipt" maxlength="6" >
                </td>
                <th width="150" id="slr1">
                    申领人
                </th>
                <td>
                       <input  id="DivapplyUsers1" type="text" class="u-ipt" maxlength="6" >

                </td>


            </tr>
            <tr>

                <th width="150" id="jyday1">
                    借用周期（天）
                </th>
                <td>
                    <input name="DivDay"  id="DivDay1" type="text" class="u-ipt" maxlength="3">
                </td>
                <th width="150" id="jydw1">
                    借用单位
                </th>
                <td>
                    <input name="Divdv" id="jydwip1" type="text" class="u-ipt" maxlength="10" >
                </td>
            </tr>
            <tr>
                <th width="150" id="jybm1">
                    借用部门
                </th>
                <td>
                    <input name="Divbm"  id="jybmip1" type="text" class="u-ipt" maxlength="6">
                </td>

                <th width="150" id="jyr1">
                    借用人
                </th>
                <td>
                    <input name="Divjyr" id="jyrip1" type="text" class="u-ipt" maxlength="6" >
                </td>
            </tr>
            <tr>

                <th width="150" id="jytel1">
                    借用人电话
                </th>
                <td>
                    <input name="DivTel" id="jytelip1" type="text" class="u-ipt" maxlength="12">
                </td>

                <th width="150" id="jyemil1">
                    借用邮箱
                </th>
                <td>
                    <input name="DivEmil" id="jyemilip1" type="text" class="u-ipt" maxlength="20" >
                </td>
            </tr>
            <tr>
                <th width="150" id="ghsj">
                    归还时间
                </th>
                <td>
                    <input name="DivReturnTime" id="DivReturnTime" type="text" class="u-ipt" maxlength="36" disabled >
                </td>
            </tr>
          </table>
        </form>
</div>


</body>
</html>


