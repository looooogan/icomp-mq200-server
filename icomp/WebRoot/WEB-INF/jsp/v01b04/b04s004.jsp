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
                    title: '生产线',
                    name: 'assemblyLineName'
                },{
                    title: '材料号',
                    name: 'toolCode'
                }, {
                    title: '加工设备',
                    name: 'equipmentName'
//						format:function(t){
//							//0 aa1bb2cc
//							if(t.equipment == 0 ){return '<span class="ui-grid-tdtx">aa</span>';}
//							else if(t.equipment == 1 ){return '<span class="ui-grid-tdtx">bb</span>';}
//							else if(t.equipment == 2 ){return '<span class="ui-grid-tdtx">cc</span>';}
//							return '<span class="ui-grid-tdtx"></span>';
//						}
                }, {
                    title: '轴编号',
                    name: 'axleCode'
                }, {
                    title: '工序',
                    name: 'processName'
                }, {
                    title: '最后执行时间',
                    name: 'outerTime',
                    format:function(r){
                        return '<span class="ui-grid-tdtx">'+fdate4(r.outerTime)+'</span>';
                    }
                }, {
                    title: '加工数量',
                    name: 'processAmount'
                }, {
                    title: '刀具消耗（次数）',
                    name: 'procesNumber'
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
             * 刀具消耗查询
             */
            $("#searchSubmit").click(function () {
                var param = {
                    opt: 'list',
                    productionLine: $(searchForm.productionLine).val(),
                    procedure: $(searchForm.procedure).val(),
                    equipment: $(searchForm.equipment).val(),
                    axisNumber: $(searchForm.axisNumber).val(),
                    model: $(searchForm.model).val(),
                    toolCode: $(searchForm.toolCode).val(),
                    dstar: $(searchForm.dstar).val(),
                    dend: $(searchForm.dend).val(),
                }
                $('#list').grid('url', 'B04S004.action');
                $('#list').grid('data', param);
                $('#list').grid('load', 1);
                return false;
            });
        });

        function dowm() {
            $("#procedures").val("");
            $("#equipments").val("");
            $("#axisNumbers").val("");
            $("#models").val("");
            param = {
                productionLineID: $("#productionLine").val(),
                procedureID: $("#procedures").val(),
                axisNumberID: $("#axisNumbers").val(),
                equipmentID: $("#equipments").val(),
            }
            $.ajax({
                url: "prossAndBuss.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {

                    if (d.status < 0) {
                        $(searchForm.procedures).find('option').remove();
                        $(searchForm.procedures).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                    } else {
                        $(searchForm.procedure).find('option').remove();
                        $(searchForm.procedure).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        $.each(d.data, function (key, val) {
                            $(searchForm.procedure).append("<option value='" + val.processID + "'>" + val.processName + "</option>");
                        })
                        $("#procedures").val("");
                        $("#equipments").val("");
                        $("#axisNumbers").val("");
                        $("#models").val("");

                    }
                }

            });
        }
        $(function () {


            //导出
            $("#infoExport").click(function () {
                $.dialog.confirm('您确定要导出么？', function (){
                    $("#productionLineHid").val($(searchForm.productionLine).val());
                    $("#procedureHid").val($(searchForm.procedure).val());
                    $("#equipmentHid").val($(searchForm.equipment).val());
                    $("#axisNumberHid").val($(searchForm.axisNumber).val());
                    $("#modelHid").val($(searchForm.model).val());
                    $("#toolCodeHid").val($(searchForm.toolCode).val());
                    $("#dstarHid").val($(searchForm.dstar).val());

                    $("#dendHid").val($(searchForm.dend).val());
                    $("#hidFrom").submit();
                });

            });

            $("#procedures").change(function () {
                $("#equipments").val("");
                $("#axisNumbers").val("");
                $("#models").val("");
                param = {
                    productionLineID: $("#productionLine").val(),
                    procedureID: $("#procedures").val(),
                    axisNumberID: $("#axisNumber").val(),
                    equipmentID: $("#equipments").val(),
                }
                $.ajax({
                    url: "prossAndBuss1.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {

                        if (d.status < 0) {
                            $(searchForm.equipment).find('option').remove();
                            $(searchForm.equipment).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {

                            $(searchForm.equipment).find('option').remove();
                            $(searchForm.equipment).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                $(searchForm.equipment).append("<option value='" + val.equipmentID + "'>" + val.equipmentName + "</option>");
                            })


                        }
                    }

                });


            });

        });
        $(function () {
            $("#equipments").change(function () {
                $("#axisNumbers").val("");
                $("#models").val("");
                param = {
                    productionLineID: $("#productionLine").val(),

                    procedureID: $("#procedures").val(),
                    equipmentID: $("#equipments").val(),
                    axisNumberID: $("#axisNumbers").val(),

                }
                $.ajax({
                    url: "prossAndBuss2.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {

                        if (d.status < 0) {
                            $(searchForm.axisNumbers).find('option').remove();
                            $(searchForm.axisNumbers).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {

                            $(searchForm.axisNumbers).find('option').remove();
                            $(searchForm.axisNumbers).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                $(searchForm.axisNumbers).append("<option value='" + val.axleID + "'>" + val.axleCode + "</option>");
                            })
                        }
                    }
                });
            });
        });
        $(function () {
            $("#axisNumbers").change(function () {
                $("#models").val("");
                param = {
                    productionLineID: $("#productionLine").val(),
                    procedureID: $("#procedures").val(),
                    axisNumberID: $("#axisNumbers").val(),
                    equipmentID: $("#equipments").val(),
                }
                $.ajax({
                    url: "prossAndBuss3.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {

                        if (d.status < 0) {
                            $(searchForm.models).find('option').remove();
                            $(searchForm.models).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                        } else {

                            $(searchForm.models).find('option').remove();
                            $(searchForm.models).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");
                            $.each(d.data, function (key, val) {
                                $(searchForm.models).append("<option value='" + val.partsID + "'>" + val.partsName + "</option>");
                            })


                        }
                    }

                });


            });

        });


            </script>
        </head>
        <body>

        <div id="hiddDiv" style="display: none">
            <form action="exportExcel04S004.action" method="post" id="hidFrom">
                <input type="hidden" name="productionLine" id="productionLineHid">
                <input type="hidden" name="procedure"       id="procedureHid">
                <input type="hidden" name="equipment"    	id="equipmentHid">
                <input type="hidden" name="axisNumber"    	id="axisNumberHid">
                <input type="hidden" name="model"    	    id="modelHid">
                <input type="hidden" name="toolCode"    	id="toolCodeHid">
                <input type="hidden" name="dstar"       	id="dstarHid">
                <input type="hidden" name="dend"        	id="dendHid">
            </form>
        </div>


        <div class="ui-layout-north g-ct-tt">
            <div class="g-ct-ttc">
                <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.MachiningInformationText}&gt;${sessionScope.lang.ToolConsumptionQueryText}</span>
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
                                <select class="u-sel" name="productionLine" maxlength="16" id="productionLine" onchange="return dowm()">
                                    <option value="">--${sessionScope.lang.PleaseSelect}--</option>
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
                                    <option value="">--${sessionScope.lang.PleaseSelect}--</option>
                                    <s:iterator value="#request.ProcessList" id="p">
                                <s:if test='%{#p.processID == #request.processID}'>
                                    <option value="${p.processID}">${p.processName}</option>
                                </s:if>
                                <s:else>
                                    <option value="${p.processID}">${p.processName}</option>
                                </s:else>
                            </s:iterator>

                        </select>

                        </select>

                        </select>
                    </td>
                    <th width="100">
                        加工设备
                    </th>
                    <td>
                        <select class="u-sel" name="equipment" maxlength="16" id="equipments">
                            <option value="">--${sessionScope.lang.PleaseSelect}--</option>
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
                            <option value="">--${sessionScope.lang.PleaseSelect}--</option>
                            <s:iterator value="#request.AxleLineList" id="axle">
                                <s:if test='%{#axle.axleID == #request.axleID}'>
                                <option value="${axle.axleID}">${axle.axleCode}</option>
                                </s:if>
                                <s:else>
                                <option value="${axle.axleID}">${axle.axleCode}</option>
                                </s:else>

                            </s:iterator>

                        </select>
                    </td>

                    <th>
                        零部件
                    </th>
                    <td>
                        <select class="u-sel" name="model" maxlength="16" id="models">
                            <option value="">--${sessionScope.lang.PleaseSelect}--</option>
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
                        材料号
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
                <button type="button" class="u-btn2" id="infoExport" >导出</button>
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

