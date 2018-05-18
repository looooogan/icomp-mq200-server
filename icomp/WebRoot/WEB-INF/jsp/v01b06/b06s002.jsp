<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp" %>
    <script type="text/javascript" src="<%=path%>/script/highcharts/highcharts.js"></script>
    <script type="text/javascript" src="<%=path%>/script/highcharts/myhighcharts.js"></script>
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
                //async:false,
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
//                },
                    {
                    title: '材料号',
                    name: 'toolCode'
                }, {
                    title: '时间',
                    name: 'outerTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate4 (r.outerTime) + '</span>';
                    }
                }, {
                    title: '异常原因',
                    name: 'removeReason',
                    format: function (t) {
                        //0正常1 加工尺寸不满足2表面质量不满足3机床原因
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
                        }
                        else if (t.removeReason == 4) {
                            return '<span class="ui-grid-tdtx">其他</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '操作者',
                    name: 'outerUser'
                }, {
                    title: '工序',
                    name: 'processName'
                }, {
                    title: '加工设备编号',
                    name: 'equipmentName'
                }, {
                    title: '零部件',
                    name: 'partsName'
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
             * 加工异常分析
             */
            $ ("#submitSearch").click (function () {
                var param = {
                    opt: 'list',
                    //合成刀具编码
                    //ToolConsumetype: $ (searchForm.ToolConsumetype).val (),//刀具分类
                    systeCode: $ (searchForm.systeCode).val (),//材料号
                    abnormal: $ (searchForm.abnormal).val (),//异常原因
                    operator: $ (searchForm.operator).val (),//操作者
                    aprocess: $ (searchForm.aprocess).val (),//工序
                    spareParts: $ (searchForm.spareParts).val (),//零部件
                    dstar: $ (searchForm.dstar).val (),
                    dend: $ (searchForm.dend).val (),
                    //时间段开始时间
                    DateStar: $ (searchForm.dstar).val (),
                    line: $ (searchForm.lines).val (),
                    //时间段结束时间
                    DateEnd: $ (searchForm.dend).val (),
                }
                $ ('#list').grid ('url', 'B06S002.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });

            /**
             * 生产线下拉选
             */
            $ ("#lines").change (function () {
                $("#spareParts").empty();
                var param = {
                    AssemblyLineID: $ ("#lines").val () //生产线ID
                }
                $.ajax ({
                    type: "POST",
                    url: "getPartsById.action",
                    data: param,
                    success:function (data) {
                        var obj = eval('(' + data + ')');
                        var toption_next = "";
                        if(obj.length == 0){
                            toption_next += "<option value=''>--请选择--</option>";
                        }else{
                            toption_next += "<option value=''>--请选择--</option>";
                            for(var i = 0,l=obj.length;i<l;i++){
                                toption_next += "<option value='"+obj[i].partsID+"'>"+obj[i].partsName+"</option>";
                            }
                        }

                        $("#spareParts").append(toption_next);

                    }
                });
            });

            $ ("#infoExport").click (function () {
                $.dialog.confirm ('您确定要导出么？', function () {
                    //$ ("#toolConsumetypeHid").val ($ (searchForm.ToolConsumetype).val ());
                    $ ("#dateStarHid").val ($ (searchForm.dstar).val ());
                    $ ("#dateEndHid").val ($ (searchForm.dend).val ());
                    $ ("#systeCodeHid").val ($ (searchForm.systeCode).val ());
                    $ ("#abnormalHid").val ($ (searchForm.abnormal).val ());
                    $ ("#operatorHid").val ($ (searchForm.operator).val ());
                    $ ("#aprocessHid").val ($ (searchForm.aprocess).val ());
                    $ ("#sparePartsHid").val ($ (searchForm.spareParts).val ());
                    $ ("#hidFrom").submit ();
                });
            });
            /**
             * 加工异常分析统计
             */
            $ ("#statisticallys").click (function () {
                var param = {
                    opt: 'list',
                    //合成刀具编码
                    //ToolConsumetype: $ (searchForm.ToolConsumetype).val (),//刀具分类
                    systeCode: $ (searchForm.systeCode).val (),//材料号
                    abnormal: $ (searchForm.abnormal).val (),//异常原因
                    operator: $ (searchForm.operator).val (),//操作者
                    aprocess: $ (searchForm.aprocess).val (),//工序
                    spareParts: $ (searchForm.spareParts).val (),//零部件
                    dstar: $ (searchForm.dstar).val (),
                    dend: $ (searchForm.dend).val (),
                    //时间段开始时间
                    DateStar: $ (searchForm.dstar).val (),
                    //时间段结束时间
                    DateEnd: $ (searchForm.dend).val (),
                }
                $ ('#list').grid ('url', 'B06S002.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                $.ajax ({
                    type: "POST",
                    url: "statistics_b06S002.action",
                    data: param,
                    success: function (data) {
                        //数量
                        var str = data.substr (1, data.length - 2).split (",");
                        //sting转化为int
                        for (var i = 0; i < str.length; i++) {
                            str[i] = parseInt (str[i]);
                        }
                        if (data.length > 0) {
                            var name0 = '尺寸不满';
                            var name1 = '表面不满';
                            var name2 = '机床原因';
                            var name3 = '其他';
                            var arrName = new Array ();
                            arrName[0] = name0;
                            arrName[1] = name1;
                            arrName[2] = name2;
                            arrName[3] = name3;
                            var PicArray = new Array (
                                    new Array (name0, str[0]),
                                    new Array (name1, str[1]),
                                    new Array (name2, str[2]),
                                    new Array (name3, str[3])
                            );
                            /*
                             * 线性统计图
                             */
                            $ ('#container').highcharts ({
                                title: {
                                    text: '${session.lang.KnifeAbnormalAnalysis}',
                                    x: -20 // center
                                },
                                subtitle: {
                                    text: '${session.lang.IcompKnifeSystem}',
                                    x: -20
                                },
                                xAxis: {
                                    // categories: d.title
                                    categories: arrName
                                },
                                yAxis: {
                                    title: {
                                        text: '${session.lang.Article}'
                                    },
                                    plotLines: [{
                                        value: 0,
                                        width: 1,
                                        color: '#808080'
                                    }]
                                },
                                tooltip: {
                                    valueSuffix: '${session.lang.Article}'
                                },
                                legend: {
                                    layout: 'vertical',
                                    align: 'right',
                                    verticalAlign: 'middle',
                                    borderWidth: 0
                                },
                                series: [{
                                    name: '${session.lang.CumulativeAbnormalNumber}',
                                    data: str
                                }]
                            });
                            /**
                             * 柱 形 图 统计图
                             */
                            $ ('#container1').highcharts ({
                                chart: {
                                    type: 'column'
                                },
                                title: {
                                    text: '${session.lang.KnifeAbnormalAnalysis}'
                                },
                                subtitle: {
                                    text: '${session.lang.IcompKnifeSystem}'
                                },
                                xAxis: {
                                    // categories: d.title
                                    categories: arrName
                                },
                                yAxis: {
                                    min: 0,
                                    title: {
                                        text: '${session.lang.CumulativeAbnormalNumbers}'
                                    }
                                },
                                tooltip: {
                                    headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                                    pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                                    '<td style="padding:0"><b>{point.y:f} ${session.lang.Number}</b></td></tr>',
                                    footerFormat: '</table>',
                                    shared: true,
                                    useHTML: true
                                },
                                plotOptions: {
                                    column: {
                                        pointPadding: 0.2,
                                        borderWidth: 0
                                    }
                                },
                                series: [{
                                    name: '${session.lang.CumulativeAbnormalNumber}',
                                    data: str
                                }]
                            });
                            /**
                             * 饼 形 图
                             */
                            $ ('#container2').highcharts ({
                                chart: {
                                    plotBackgroundColor: null,
                                    plotBorderWidth: null,
                                    plotShadow: false
                                },
                                title: {
                                    text: '${session.lang.CumulativeAbnormalNumber}'
                                },
                                tooltip: {
                                    pointFormat: '{series.name}: <b>{point.percentage:.1f}%</b>'
                                },
                                plotOptions: {
                                    pie: {
                                        allowPointSelect: true,
                                        cursor: 'pointer',
                                        dataLabels: {
                                            enabled: true,
                                            color: '#ffffff',
                                            connectorColor: '#000000',
                                            formatter: function () {
                                                return '<b>' + this.point.name + '</b>: ' + this.percentage.toFixed (1) + ' %';
                                            }
                                        }
                                    }
                                },
                                series: [{
                                    type: 'pie',
                                    name: '${session.lang.Percentage}',
                                    data: PicArray
                                }]
                            });
                            //显示统计框
                            $.dialog ({
                                id: 'tj_list_dialog',
                                title: '${session.lang.Statistics}',
                                lock: true,
                                content: document.getElementById ('tj_list'),
                            });
                        }
                    }
                });
            });
            //线性图显示
            $ ("#lineBtn").click (function () {
                $ ("#container").show ();
                $ ("#container1").hide ();
                $ ("#container2").hide ();
            });
            //柱形图显示
            $ ("#barBtn").click (function () {
                $ ("#container").hide ();
                $ ("#container1").show ();
                $ ("#container2").hide ();
            });
            //饼形图显示
            $ ("#pieBtn").click (function () {
                $ ("#container").hide ();
                $ ("#container1").hide ();
                $ ("#container2").show ();
            });
        });
    </script>
</head>
<body>

<div id="hiddDiv" style="display: none">
    <form action="exportExcel06S002.action" method="post" id="hidFrom">

        <input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
        <input type="hidden" name="dateStar" id="dateStarHid">
        <input type="hidden" name="dateEnd" id="dateEndHid">
        <input type="hidden" name="systeCode" id="systeCodeHid">
        <input type="hidden" name="abnormal" id="abnormalHid">
        <input type="hidden" name="operator" id="operatorHid">
        <input type="hidden" name="aprocess" id="aprocessHid">
        <input type="hidden" name="spareParts" id="sparePartsHid">
    </form>
</div>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.AnalysisAbnormalProcessingText}</span>
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
                    <%--<th>--%>
                        <%--刀具类型--%>
                    <%--</th>--%>
                    <%--<td>--%>
                        <%--<select class="u-sel" name="ToolConsumetype" maxlength="16">--%>
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


                        <%--</select>--%>
                    <%--</td>--%>
                    <th width="100">
                        材料号
                    </th>
                    <td>
                        <input name="systeCode" type="text" class="u-ipt" maxlength="50">
                    </td>
                    <th>
                        异常原因
                    </th>
                    <td>
                        <%--//0 加工尺寸不满足1表面质量不满足2机床原因--%>
                        <select class="u-sel" name="abnormal" maxlength="16">
                            <option value="">
                                --请选择--
                            </option>
                            <option value="0">
                                正常卸下
                            </option>
                            <option value="1">
                                加工尺寸不满足
                            </option>
                            <option value="2">
                                表面质量不满足
                            </option>
                            <option value="3">
                                机床原因
                            </option>
                            <option value="4">
                                其他
                            </option>

                        </select>
                    </td>
                </tr>
                <tr>
                    <th width="100">
                        工序
                    </th>
                    <td>
                        <select name="aprocess" class="u-sel" maxlength="50">
                            <option value="">--请选择--</option>
                            <s:iterator value="#request.ProcessList" id="process">
                                <option value="${process.processID}">${process.processName}</option>
                            </s:iterator>
                        </select>
                    </td>

                    <!-- 2017/07/03 宋健 追加↓↓↓　dazhong@YMSC -->
                    <th width="100">
                        生产线
                    </th>
                    <td>
                        <select id="lines" name="lines" class="u-sel" maxlength="50">
                            <option value="">--请选择--</option>
                            <s:iterator value="#request.AssemblylineList" id="al">
                                <option value="${al.assemblyLineID}">${al.assemblyLineName}</option>
                            </s:iterator>
                        </select>
                    </td>
                    <!-- 2017/07/03 宋健 追加↑↑↑　dazhong@YMSC -->

                    <th width="100">
                        零部件
                    </th>
                    <td>
                        <select id="spareParts" name="spareParts" class="u-sel" maxlength="50">
                            <option value="">--请选择--</option>
                            <%--<s:iterator value="#request.PatrsList" id="pl">--%>
                            <%--<option value="${pl.partsID}">${pl.partsName}</option>--%>
                            <%--</s:iterator>--%>
                        </select>
                    </td>

                </tr>
                <tr>
                    <th width="150">
                        时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>

                    <th width="100">
                        操作者
                    </th>
                    <td>
                        <input name="operator" type="text" class="u-ipt" maxlength="50">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="submitSearch">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" id="statisticallys">${sessionScope.lang.submitStatisticsText}</button>
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
<div id="tj_list" class="f-dn">
    <table id="tongji">
        <tr>
            <td colspan=14 align=center>
                <input type="button" id="lineBtn" class="u-btn2" value="${sessionScope.lang.LineChart}">
                <input type="button" id="barBtn" class="u-btn2" value="${sessionScope.lang.ColumnChart}">
                <input type="button" id="pieBtn" class="u-btn2" value="${sessionScope.lang.PieChart}">
                <br>
                <div id="container" style="min-width: 800px; height: 400px; algin: center"></div>
                <div id="container1" style="min-width: 800px; height: 400px; algin: center; display: none"></div>
                <div id="container2" style="min-width: 800px; height: 400px; algin: center; display: none"></div>
            </td>
        </tr>
    </table>
</div>
</body>
</html>

