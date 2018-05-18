<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
                    resizable: false,
                }
            });
            $ ('#list').grid ({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                //async:false,
                rowno: true,
                rows:${session.rowsize},
                roll: 9,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '合成刀编码',
                    name: 'synthesisParametersCode'
                },{
                    title: '材料号',
                    name: 'toolCode'
                },{
                    title: '生产线',
                    name: 'assemblyLineName'
                }, {
                    title: '工序',
                    name: 'processName'
                },{
                    title: '设备',
                    name: 'equipmentName'
                },{
                    title: '轴',
                    name: 'axleName'
                },{
                    title: '零部件',
                    name: 'partsName'
                },{
                    title: '调刀人',
                    name: 'changeUser'
                },{
                    title: '调刀时间',
                    name: 'changeDate'
                }

                ],
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
            $ ("#procedures").val ("");
            $ ("#equipments").val ("");
            $ ("#axisNumbers").val ("");
            $ ("#models").val ("");
            $ ("#productionLines").change (function () {
                $ ("#procedures").val ("");
                $ ("#equipments").val ("");
                $ ("#axisNumbers").val ("");
                $ ("#models").val ("");
                param = {
                    productionLineID: $ ("#productionLines").val (),
                }
                $.ajax ({
                    url: "prossAnd.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status < 0) {
                            $ (searchForm.procedure).find ('option').remove ();
                            $ (searchForm.procedure).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            $ (searchForm.procedure).find ('option').remove ();
                            $ (searchForm.procedure).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (searchForm.procedure).append ("<option value='" + val.processID + "'>" + val.processName + "</option>");
                            })
                        }
                    }
                })
            })
            $ ("#procedures").change (function () {
                $ ("#equipments").val ("");
                $ ("#axisNumbers").val ("");
                $ ("#models").val ("");
                param = {
                    productionLineID: $ ("#productionLines").val (),
                    procedureID: $ ("#procedures").val (),
                }
                $.ajax ({
                    url: "prossAndBuss1.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status < 0) {
                            $ (searchForm.equipment).find ('option').remove ();
                            $ (searchForm.equipment).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            $ (searchForm.equipment).find ('option').remove ();
                            $ (searchForm.equipment).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (searchForm.equipment).append ("<option value='" + val.equipmentID + "'>" + val.equipmentName + "</option>");
                            })
                        }
                    }
                });
            });
            $ ("#equipments").change (function () {
                $ ("#axisNumbers").val ("");
                $ ("#models").val ("");
                param = {
                    productionLineID: $ ("#productionLines").val (),
                    procedureID: $ ("#procedures").val (),
                    equipmentID: $ ("#equipments").val (),
                }
                $.ajax ({
                    url: "prossAndBuss2.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status < 0) {
                            $ (searchForm.axisNumber).find ('option').remove ();
                            $ (searchForm.axisNumber).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            $ (searchForm.axisNumber).find ('option').remove ();
                            $ (searchForm.axisNumber).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (searchForm.axisNumber).append ("<option value='" + val.axleID + "'>" + val.axleCode + "</option>");
                            })
                        }
                    }
                });
            });
            $ ("#axisNumbers").change (function () {
                $ ("#models").val ("");
                param = {
                    productionLineID: $ ("#productionLines").val (),
                    procedureID: $ ("#procedures").val (),
                    axisNumberID: $ ("#axisNumbers").val (),
                    equipmentID: $ ("#equipments").val (),
                }
                $.ajax ({
                    url: "prossAndBuss3.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status < 0) {
                            $ (searchForm.model).find ('option').remove ();
                            $ (searchForm.model).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {
                            $ (searchForm.model).find ('option').remove ();
                            $ (searchForm.model).append ("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each (d.data, function (key, val) {
                                $ (searchForm.model).append ("<option value='" + val.partsID + "'>" + val.partsName + "</option>");
                            })
                        }
                    }
                });
            });
            /**
             * 换刀记录
             */
            $ ("#searchSubmit").click (function () {
                var datestr = $(searchForm.dstar).val();
                var dateend = $(searchForm.dend).val();
                var param = {
                    opt: 'list',
                    productionLine: $ (searchForm.productionLine).val (),
                    procedure: $ (searchForm.procedure).val (),
                    equipment: $ (searchForm.equipment).val (),
                    axisNumber: $ (searchForm.axisNumber).val (),
                    model: $ (searchForm.model).val (),
                    toolCode: $ (searchForm.toolCode).val (),
                    datePeriod: $ (searchForm.datePeriod).val (),
                    dstar: datestr,
                    dend: dateend,
                }
                $ ('#list').grid ('url', 'B01S015.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });


        });
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;加工信息&gt;调刀记录</span>
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
                        生产线
                    </th>
                    <td>
                        <select class="u-sel" name="productionLine" maxlength="16" id="productionLines">
                            <option value="">
                                --请选择--
                            </option>
                            <s:iterator value="#request.AssemblyLineList" id="assembly">
                                <s:if test='%{#assembly.assemblyLineID == #request.AssemblyLineID}'>
                                    <option value="${assembly.assemblyLineID}">${assembly.assemblyLineName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${assembly.assemblyLineID}">${assembly.assemblyLineName}</option>
                                </s:else>
                            </s:iterator>

                        </select>
                    </td>
                    <th>
                        工序
                    </th>
                    <td>
                        <select class="u-sel" name="procedure" maxlength="16" id="procedures">
                            <option value="">
                                --请选择--
                            </option>
                            <s:iterator value="#request.ProcessList" id="p">
                                <s:if test='%{#p.processID == #request.processID}'>
                                    <option value="${p.processID}">${p.processName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${p.processID}">${p.processName}</option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>
                    <th width="100">
                        加工设备
                    </th>
                    <td>
                        <select class="u-sel" name="equipment" maxlength="16" id="equipments">
                            <option value="">
                                --请选择--
                            </option>
                            <s:iterator value="#request.EquipmentList" id="equip">
                                <s:if test='%{#equip.equipmentID == #request.equipmentID}'>
                                    <option value="${equip.equipmentID}">${equip.equipmentName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${equip.equipmentID}">${equip.equipmentName}</option>
                                </s:else>
                            </s:iterator>

                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        轴编号
                    </th>
                    <td>
                        <select class="u-sel" name="axisNumber" maxlength="16" id="axisNumbers">
                            <option value="">
                                --请选择--
                            </option>
                            <s:iterator value="#request.AxleLineList" id="axle">
                                <s:if test='%{#axle.axleID == #request.axleID}'>
                                    <option value="${axle.axleID}">${axle.axleName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${axle.axleID}">${axle.axleName}</option>
                                </s:else>
                            </s:iterator>
                        </select>
                    </td>

                    <th>
                        零部件
                    </th>
                    <td>
                        <select class="u-sel" name="model" maxlength="16" id="models">
                            <option value="">
                                --请选择--
                            </option>
                            <s:iterator value="#request.PartsList" id="parts">
                                <s:if test='%{#parts.partsID == #request.partsID}'>
                                    <option value="${parts.partsID}">${parts.partsName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${parts.partsID}">${parts.partsName}</option>
                                </s:else>
                            </s:iterator>

                        </select>
                    </td>
                    <th width="100">
                        合成刀具编码
                    </th>
                    <td>
                        <input name="toolCode" type="text" class="u-ipt" maxlength="50">
                    </td>
                </tr>
                <tr>
                    <th width="100">
                        调刀时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>

                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
                <%--<button type="button" class="u-btn2" id="infoExport">导出</button>--%>
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
</body>
</html>

