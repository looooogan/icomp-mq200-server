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
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '合成刀编码',
                    width: '9%',
                    name: 'synthesisParametersCode'
                }, {
                    title: '合成刀编号 ',
                    width: '9%',
                    name: 'synthesisParametersNumber'
                }, {
                    title: '加工设备',
                    width: '8%',
                    name: 'equipmentName'
                }, {
                    title: '轴编号',
                    width: '6%',
                    name: 'axleName'
                }, {
                    title: '零部件',
                    width: '7%',
                    name: 'partsName'
                }, {
                    title: '安上时间',
                    width: '11%',
                    name: 'createTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate4 (r.createTime) + '</span>';
                    }
                }, {
                    title: '安上者',
                    width: '6%',
                    name: 'createUser'
                }, {
                    title: '卸下时间',
                    name: 'outerTime',
                    width: '11%',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate4 (r.outerTime) + '</span>';
                    }
                }, {
                    title: '卸下者',
                    width: '6%',
                    name: 'outerUser'
                }, {
                    title: '卸下原因',
                    name: 'removeReason',
                    width: '10%',
                    format: function (t) {
                        //(0刀片1钻头2复合刀具3热套类)
                        if (t.removeReason == 0) {
                            return '<span class="ui-grid-tdtx">正常卸下</span>';
                        }
                        else if (t.removeReason == 1) {
                            return '<span class="ui-grid-tdtx">加工尺寸不满足</span>';
                        }
                        else if (t.removeReason == 2) {
                            return '<span class="ui-grid-tdtx">表面质量不满足</span>';
                        }
                        else if (t.removeReason == 3) {
                            return '<span class="ui-grid-tdtx">机床原因</span>';
                        } else if (t.removeReason == 4) {
                            return '<span class="ui-grid-tdtx">其他</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '额定数量',
                    width: '8%',
                    name: 'toolDurable'
                }, {
                    title: '实际加工数量',
                    width: '8%',
                    name: 'processAmount',
                    format: function (t) {
                        //0 aa1bb2cc
                        if ((t.toolDurable < t.processAmount) || (t.toolDurable > t.processAmount)) {
                            return '<span class="ui-grid-tdtx" style="color: red">' + (t.processAmount) + '</span>';
                        }
                        else {
                            return '<span class="ui-grid-tdtx">' + (t.processAmount) + '</span>';
                        }
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
                if (datestr == "" && dateend == "") {
                    alert ("卸下时间段不能为空")
                    return false;
                }
                var param = {
                    opt: 'list',
                    productionLine: $ (searchForm.productionLine).val (),
                    procedure: $ (searchForm.procedure).val (),
                    equipment: $ (searchForm.equipment).val (),
                    axisNumber: $ (searchForm.axisNumber).val (),
                    model: $ (searchForm.model).val (),
                    toolCode: $ (searchForm.toolCode).val (),
                    datePeriod: $ (searchForm.datePeriod).val (),
                    removeReason: $ (searchForm.removeReason).val (),
                    dstar: datestr,
                    dend: dateend,
                }
                $ ('#list').grid ('url', 'B04S001.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });
            //导出
            $ ("#infoExport").click (function () {
                var datestr = $ (searchForm.dstar).val ();
                var dateend = $ (searchForm.dend).val ();
                if (datestr == "" && dateend == "") {
                    alert ("卸下时间段不能为空")
                    return false;
                }
                $.dialog.confirm ('您确定要导出么？', function () {
                    $ ("#dateStarHid").val (datestr);
                    $ ("#dateEndHid").val (dateend);
                    $ ("#productionLineHid").val ($ (searchForm.productionLine).val ());
                    $ ("#procedureHid").val ($ (searchForm.procedure).val ());
                    $ ("#equipmentHid").val ($ (searchForm.equipment).val ());
                    $ ("#axisNumberHid").val ($ (searchForm.axisNumber).val ());
                    $ ("#modelHid").val ($ (searchForm.model).val ());
                    $ ("#toolCodeHid").val ($ (searchForm.toolCode).val ());
                    $ ("#removeReasonHid").val ($ (searchForm.removeReason).val ());
                    $ ("#hidFrom").submit ();
                });
            });

        });
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;加工信息&gt;换刀记录</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<form action="exportExcel04S001.action" method="post" id="hidFrom">
    <input type="hidden" name="dstar" id="dateStarHid">
    <input type="hidden" name="dend" id="dateEndHid">
    <input type="hidden" name="productionLine" id="productionLineHid">
    <input type="hidden" name="procedure" id="procedureHid">
    <input type="hidden" name="equipment" id="equipmentHid">
    <input type="hidden" name="axisNumber" id="axisNumberHid">
    <input type="hidden" name="model" id="modelHid">
    <input type="hidden" name="toolCode" id="toolCodeHid">
    <input type="hidden" name="removeReason" id="removeReasonHid">
</form>
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
                        卸下时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>
                    <th>
                        卸下原因
                    </th>
                    <td>
                        <select class="u-sel" name="removeReason" maxlength="16" id="removeReason">
                            <option value="" selected="selected">--请选择--</option>
                            <option value="0">正常卸下</option>
                            <option value="1">加工尺寸不满足</option>
                            <option value="2">表面质量不满足</option>
                            <option value="3">报废</option>
                            <option value="4">其他</option>
                        </select>
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" id="infoExport">导出</button>
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

