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
                    resizable: false
                }
            });
            <!-- 2017/07/03 宋健 变更↓↓↓　dazhong@YMSC -->
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
                column: [
                    <!-- 2017/09/1 宋健 变更↓↓↓　dazhong@YMSC -->
                    {
                        title: '合成刀具编码',
                        name: 'synthesisParametersCode'
                    }, {
                        title: '备刀库数量',
                        name: 'bdSum'
                    },{
                        title: '安上数量',
                        name: 'asSum'
                    },{
                        title: '卸下待换装/修磨数量',
                        name: 'dzzSum'
                    },{
                        title: '合计',
                        name: 'totalSum'
                    }],
                <!-- 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC -->
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
        <!-- 2017/07/03 宋健 变更↑↑↑　dazhong@YMSC -->
        $ (function () {
            //导出
            $ ("#infoExport").click (function () {
                $.dialog.confirm ('您确定要导出么？', function () {
//                    $ ("#productionLineHid").val ($ (searchForm.productionLine).val ());
//                    $ ("#procedureHid").val ($ (searchForm.procedure).val ());
                    $ ("#toolCodeHid").val ($ (searchForm.toolCode).val ());
                    $ ("#pNumberHid").val ($ (searchForm.pNumber).val ());
                    $ ("#hidFrom").submit ();
                });
            });
            /**
             * （合成刀具状态）车间刀具状态查询
             */
            $ ("#searchSubmit").click (function () {
                var param = {
                    opt: 'list',
//                    productionLine: $ (searchForm.productionLine).val (),//生产线
//                    procedure: $ (searchForm.procedure).val (),//工序
                    pNumber: $ (searchForm.pNumber).val (),//优先查询
                    toolCode: $ (searchForm.toolCode).val (),//合成编码
                }
                $ ('#list').grid ('url', 'B04S002.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });
        });
        $ (function () {
            $ ("#productionLines").change (function () {
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

    </script>
</head>
<body>
<div id="hiddDiv" style="display: none">
    <form action="exportExcel04S002.action" method="post" id="hidFrom">
        <input type="hidden" name="productionLine" id="productionLineHid">
        <input type="hidden" name="procedure" id="procedureHid">
        <input type="hidden" name="toolCode" id="toolCodeHid">
        <input type="hidden" name="pNumber" id="pNumberHid">
    </form>
</div>
<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页：首页>加工信息>合成刀具状态查询</span>
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

                    <%--<th width="100">--%>
                    <%--生产线--%>
                    <%--</th>--%>
                    <%--<td>--%>
                    <%--<select class="u-sel" name="productionLine" maxlength="16" id="productionLines">--%>
                    <%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>
                    <%--<s:iterator value="#request.AssemblyLineList" id="assembly">--%>
                    <%--<s:if test='%{#assembly.assemblyLineID == #request.AssemblyLineID}'>--%>
                    <%--<option value="${assembly.assemblyLineID}">${assembly.assemblyLineName}</option>--%>
                    <%--</s:if>--%>
                    <%--<s:else>--%>
                    <%--<option value="${assembly.assemblyLineID}">${assembly.assemblyLineName}</option>--%>
                    <%--</s:else>--%>
                    <%--</s:iterator>--%>

                    <%--</select>--%>
                    <%--</td>--%>
                    <%--<th width="100">--%>
                    <%--工序--%>
                    <%--</th>--%>
                    <%--<td>--%>
                    <%--<select class="u-sel" name="procedure" maxlength="16">--%>
                    <%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>
                    <%--<s:iterator value="#request.ProcessList" id="p">--%>
                    <%--<s:if test='%{#p.processID == #request.ProcessID}'>--%>
                    <%--<option value="${p.processID}">${p.processName}</option>--%>
                    <%--</s:if>--%>
                    <%--<s:else>--%>
                    <%--<option value="${p.processID}">${p.processName}</option>--%>
                    <%--</s:else>--%>
                    <%--</s:iterator>--%>

                    <%--</select>--%>
                    <%--</td>--%>
                    <th width="100">
                        合成刀具编码
                    </th>
                    <td>
                        <input name="toolCode" type="text" class="u-ipt" maxlength="10">
                    </td>

                    <%--</tr>--%>
                    <%--<tr>--%>
                    <th width="100">
                        优先查询
                    </th>
                    <td>
                        <select class="u-sel" name="pNumber" maxlength="16">
                            <option value="" selected="selected">--${sessionScope.lang.PleaseSelect}--</option>
                            <option value="bdSum">备刀库数量</option>
                            <option value="asSum">安上数量</option>
                            <option value="dzzSum">卸下待换装/修磨数量</option>
                        </select>
                    </td>
                </tr>
            </table>
            <br/>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
                <!-- 2017/09/1 宋健 变更↓↓↓　dazhong@YMSC -->
                <%--<button type="button" class="u-btn2" id="infoExport">导出</button>--%>
                <!-- 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC -->
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

