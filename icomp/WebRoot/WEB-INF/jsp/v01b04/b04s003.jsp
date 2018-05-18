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
                    title: '生产线',
                    name: 'assemblyLineName'
//					format:function(t){
//						//0 aa1bb2cc
//						if(t.productionLine == 0 ){return '<span class="ui-grid-tdtx">aa</span>';}
//						else if(t.productionLine == 1 ){return '<span class="ui-grid-tdtx">bb</span>';}
//						else if(t.productionLine == 2 ){return '<span class="ui-grid-tdtx">cc</span>';}
//						return '<span class="ui-grid-tdtx"></span>';
//					}
                }, {
                    title: '材料号',
                    name: 'toolCode'
                },
                    {
                        title: '加工设备',
                        name: 'equipmentName'
                    }, {
                        title: '轴编号',
                        name: 'axleCode'
                    }, {
                        title: '工序号',
                        name: 'processName'
                    }, {
                        title: '零部件',
                        name: 'partsName'
                    }, {
                        title: '操作者',
                        name: 'outerUser'
                    }, {
                        title: '卸下时间',
                        name: 'outerTime',
                        format: function (r) {
                            return '<span class="ui-grid-tdtx">' + fdate4 (r.outerTime) + '</span>';
                        }
                    }, {
                        title: '额定数量',
                        name: 'toolDurable'
                    }, {
                        title: '实际加工数量',
                        name: 'processAmount',
                        format: function (t) {
                            //0 aa1bb2cc
                            if (t.toolDurable < t.processAmount) {
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
            /**
             * 加工量异常报警
             */
            $ ("#searchSubmit").click (function () {
                var param = {
                    opt: 'list',
                    productionLine: $ (searchForm.productionLine).val (),
                    procedure: $ (searchForm.procedure).val (),
                    equipment: $ (searchForm.equipment).val (),
                    axisNumber: $ (searchForm.axisNumber).val (),
                    model: $ (searchForm.model).val (),
                    toolCode: $ (searchForm.toolCode).val (),
                    datePeriod: $ (searchForm.datePeriod).val (),
                    dstar: $ (searchForm.dstar).val (),
                    dend: $ (searchForm.dend).val (),
                }
                $ ('#list').grid ('url', 'B04S003.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
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
        })
        $ (function () {
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
        });
        $ (function () {
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
        });
        $ (function () {
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
        });

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;预警管理模块&gt;${sessionScope.lang.ProcessingAmountAbnormalAlarmText}</span>
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
                        时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>

                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
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

