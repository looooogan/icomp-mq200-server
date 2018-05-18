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
                column: [
//                        {
//                    title: '刀具类型',
//                    name: 'toolType'
//
//                },
                    {

                    title: '材料号',
                    name: 'toolCode'
                },{
                    title: '出库时间',
                    name: 'receiveTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate4(r.receiveTime) + '</span>';
                    }
                }, {
                    title: '申请人',
                    name: 'libraryUser'
                }, {
                    title: '出库数量',
                    name: 'receiveCount'

                }, {
                    title: '领用人',
                    name: 'receiveUser'
                }, {
                    title: '出库原因',
                    name: 'libraryCause',
                    format: function (r) {
                        //申领1换领2外借
                        if (r.libraryCause == 0) {
                            return '<span class="ui-grid-tdtx">补领出库</span>';
                        }
                        else if (r.libraryCause == 1) {
                            return '<span class="ui-grid-tdtx">换领出库</span>';
                        }
                        else if (r.libraryCause == 2) {
                            return '<span class="ui-grid-tdtx">外借</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '补领原因',
                    name: 'replacementReason',
                    format: function (r) {
                        //0借用1补充周转量2特殊领用
                        if(r.libraryCause == 0){
                            if (r.replacementReason == 0) {
                                return '<span class="ui-grid-tdtx">借用</span>';
                            }
                            else if (r.replacementReason == 1) {
                                return '<span class="ui-grid-tdtx">补充周转量</span>';
                            }
                            else if (r.replacementReason == 2) {
                                return '<span class="ui-grid-tdtx">特殊领用其他 </span>';
                            }
                        }else {

                        }

                        return '<span class="ui-grid-tdtx"></span>';
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

        $(function () {
            /**
             * 出库信息查询
             */
            $("#toolLibrarySubmit").click(function () {
                var param = {
                    opt: 'list',
//                    ToolConsumetype: $(toolLibraryFrom.ToolConsumetype).val(),
                    systeCode: $(toolLibraryFrom.systeCode).val(),
                    //knifeInventoryType:$(toolLibraryFrom.knifeInventoryType).val(),
                    deliveryReason: $(toolLibraryFrom.deliveryReason).val(),//换领出库
                    deliveryReason1: $(toolLibraryFrom.deliveryReason1).val(),//补领出库
                    dstar: $(toolLibraryFrom.dstar).val(),
                    dend: $(toolLibraryFrom.dend).val(),
                    libraryMember: $(toolLibraryFrom.libraryMember).val(),//库管员
                    usePerson: $(toolLibraryFrom.usePerson).val(),//领用人

                }
                $('#list').grid('url', 'B01S002.action');
                $('#list').grid('data', param);
                $('#list').grid('load', 1);
                return false;
            });
            //导出
            $("#toolLibraryOut").click(function () {
                $.dialog.confirm('您确定要导出么？', function () {
                    $("#toolConsumetypeHid").val($(toolLibraryFrom.ToolConsumetype).val());
                    $("#dateStarHid").val($(toolLibraryFrom.dstar).val());
                    $("#dateEndHid").val($(toolLibraryFrom.dend).val());
                    $("#systeCodeHid").val($(toolLibraryFrom.systeCode).val());
                    $("#deliveryReasonHid").val($(toolLibraryFrom.deliveryReason).val());
                    $("#deliveryReason1Hid").val($(toolLibraryFrom.deliveryReason1).val());
                    $("#libraryMemberHid").val($(toolLibraryFrom.libraryMember).val());
                    $("#usePersonHid").val($(toolLibraryFrom.usePerson).val());

                    $("#hidFrom").submit();
                });

            });
            //选择
            $("#deliveryReason").change(function () {
                var a = $("#deliveryReason").val();
                if (a == 0) {
                    $("#deliveryReason1").show();
                } else {
                    $("#deliveryReason1").hide();
                }


            });


        });
    </script>


</head>
<body>
<div id="hiddDiv" style="display: none">
    <form action="exportExcel01S002.action" method="post" id="hidFrom">
        <input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
        <input type="hidden" name="dateStar" id="dateStarHid">
        <input type="hidden" name="dateEnd" id="dateEndHid">
        <input type="hidden" name="systeCode" id="systeCodeHid">
        <input type="hidden" name="usePerson" id="usePersonHid">
        <input type="hidden" name="libraryMember" id="libraryMemberHid">
        <input type="hidden" name="deliveryReason1" id="deliveryReason1Hid">
        <input type="hidden" name="deliveryReason" id="deliveryReasonHid">
    </form>
</div>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.b01s002pageTitle}</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}

        </div>
        <form id="toolLibraryFrom" name="toolLibraryFrom" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <%--<th>--%>
                        <%--刀具类型--%>
                    <%--</th>--%>
                    <%--<td>--%>
                        <%--<select class="u-sel" name="ToolConsumetype" maxlength="6">--%>
                            <%--<option value="">--%>
                                <%----请选择----%>
                            <%--</option>--%>

                            <%--<option value="A">--%>
                                <%--A--%>
                            <%--</option>--%>

                            <%--<option value="B">--%>
                                <%--B--%>
                            <%--</option>--%>

                            <%--<option value="C">--%>
                                <%--C--%>
                            <%--</option>--%>

                            <%--<option value="D">--%>
                                <%--D--%>
                            <%--</option>--%>

                            <%--<option value="E">--%>
                                <%--E--%>
                            <%--</option>--%>
                            <%--<option value="F">--%>
                                <%--F--%>
                            <%--</option>--%>
                            <%--<option value="G">--%>
                               <%--G--%>
                            <%--</option>--%>
                            <%--<option value="H">--%>
                                <%--H--%>
                            <%--</option>--%>

                            <%--<option value="I">--%>
                                <%--I--%>
                            <%--</option>--%>
                            <%--<option value="S">--%>
                                <%--S--%>
                            <%--</option>--%>
                            <%--<option value="Z">--%>
                                <%--Z--%>
                            <%--</option>--%>

                        <%--</select>--%>
                    <%--</td>--%>

                    <th>
                        材料号
                    </th>

                    <td>
                        <input name="systeCode" type="text" class="u-ipt" maxlength="15">
                    </td>
                    <th width="100">
                        领用人
                    </th>
                    <td>
                        <input name="usePerson" type="text" class="u-ipt" maxlength="16">
                    </td>

                </tr>
                <tr>
                    <th>
                        出库原因
                    </th>
                    <td>
                        <select class="u-sel" name="deliveryReason" id="deliveryReason" >
                            <option value="">
                                --请选择--
                            </option>

                            <option value="1" >
                                换领出库
                            </option>

                            <option value="0">
                                补领出库
                            </option>

                        </select>

                        <select class="u-sel" id="deliveryReason1" name="deliveryReason1" style="display: none">
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

                    <th width="100">
                        出库时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>

                    <th width="100">
                        库管员
                    </th>
                    <td>
                        <input name="libraryMember" type="text" class="u-ipt" maxlength="16">
                    </td>
                </tr>


            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="toolLibrarySubmit">查询</button>

                <button type="button" class="u-btn2" id="toolLibraryOut">导出</button>
            </div>


        </form>
        <div class="f-cb"></div>
        <div class="u-ptt">
            <div style="float:left;">${sessionScope.lang.searchList}</div>
            <div style="float:right;">
                共: <span id="number1"></span> &nbsp;条
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

