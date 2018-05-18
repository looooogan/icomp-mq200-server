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
            $ ('div.u-ptt').css ("font-size", "16px");
            $ ('div.u-ptt span').css ({
                fontSize: "12px",
                fontWeight: "400"
            });
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
                    title: '库房',
                    name: 'numberDevices4'
                }, {
                    title: '备刀库',
                    name: 'numberDevices5',
                }, {
                    title: '待修磨（厂内）',
                    name: 'numberDevices'
                }, {
                    title: '待修磨（厂外）',
                    name: 'numberDevices1'
                },
//                {
//                    title: '待送回',
//                    name: 'numberDevices2'
//                },
                    {
                    title: '厂外修磨',
                    name: 'numberDevices3'
                }, {
                    title: '生产线',
                    name: 'expandSpace1'
                },
//                    {
//                    title: '待报废',
//                    name: 'expandSpace2'
//                }, {
//                    title: '报废（累积）',
//                    name: 'numberDevices6'
//                },
                    {
                    title: '合计',
                    name: 'sprice'
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
             * 刀具资金占用情况分析
             */
            $ ("#submitSearch").click (function () {
                var param = {
                    opt: 'list',
                    //刀具编码
                    //ToolConsumetype: $ (searchForm.ToolConsumetype).val (),
                    SysteCode: $ (searchForm.SysteCode).val (),
                }
                $ ('#list').grid ('url', 'B06S008.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });
            /**
             * 刀具资金占用情况分析统计
             */
            $ ("#statisticallyi").click (function () {
                var param = {
                    opt: "list",
                    //刀具编码
                    //ToolConsumetype: $ (searchForm.ToolConsumetype).val (),
                    SysteCode: $ (searchForm.SysteCode).val (),
                };
                $ ('#list').grid ('url', 'B06S008.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                jschar (1);
            });
            //线性图显示
            $ ("#lineBtn").click (function () {
                $ ("#container").show ();
                $ ("#container1").hide ();
                $ ("#container2").hide ();
                jschar (1);
            });
            //柱形图显示
            $ ("#barBtn").click (function () {
                $ ("#container").hide ();
                $ ("#container1").show ();
                $ ("#container2").hide ();
                jschar (2);
            });
            //饼形图显示
            $ ("#pieBtn").click (function () {
                $ ("#container").hide ();
                $ ("#container1").hide ();
                $ ("#container2").show ();
                jschar (3);
            });
        });

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.AnalysisToolFundsText}</span>
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

                            <%--<option value="a">--%>
                                <%--A--%>
                            <%--</option>--%>

                            <%--<option value="b">--%>
                                <%--B--%>
                            <%--</option>--%>

                            <%--<option value="c">--%>
                                <%--C--%>
                            <%--</option>--%>

                            <%--<option value="d">--%>
                                <%--D--%>
                            <%--</option>--%>

                            <%--<option value="e">--%>
                                <%--E--%>
                            <%--</option>--%>

                            <%--<option value="f">--%>
                                <%--F--%>
                            <%--</option>--%>
                            <%--<option value="g">--%>
                                <%--G--%>
                            <%--</option>--%>
                            <%--<option value="h">--%>
                                <%--H--%>
                            <%--</option>--%>
                            <%--<option value="i">--%>
                                <%--I--%>
                            <%--</option>--%>
                            <%--<option value="s">--%>
                                <%--S--%>
                            <%--</option>--%>
                        <%--</select>--%>
                    <%--</td>--%>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input name="SysteCode" type="text" class="u-ipt" maxlength="50">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="submit" class="u-btn2" id="submitSearch">
                    ${sessionScope.lang.submitSearchText}
                </button>
                <button type="button" class="u-btn2" id="statisticallyi">
                    ${sessionScope.lang.submitStatisticsText}
                </button>
                <%--<button type="button" class="u-btn2">--%>
                <%--${sessionScope.lang.submitPrintText}--%>
                <%--</button> --%>
            </div>
        </form>
        <div class="f-cb"></div>
        <div class="u-ptt">

            <div style="float:left;">${sessionScope.lang.searchList}<span>(单位/万元)</span></div>
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
<script type="application/javascript">
    var dates = null;
    function jschar(state) {
        var param = {
            opt: "list",
            //刀具编码
            //ToolConsumetype: $ (searchForm.ToolConsumetype).val (),
            SysteCode: $ (searchForm.SysteCode).val (),
        };
        $.ajax ({
            type: "POST",
            url: "statistics_b06S008.action",
            data: param,
            success: function (data) {
                //数量
                var str = data.substr (1, data.length - 2).split (",");
                //sting转化为float
                for (var i = 0; i < str.length; i++) {
                    str[i] = parseFloat (str[i]);
                }
                if (data.length > 0) {
                    var name0 = '内待修磨';
                    var name1 = '外待修磨';
                    //var name2 = '待送回';
                    var name3 = '厂外修磨';
                    var name4 = '库房';
                    var name5 = '备刀库';
                    //var name6 = '报废（累积）';
                    var name7 = '生产线';
                    //var name8 = '待报废';
                    var arrName = new Array ();
                    arrName[0] = name0;
                    arrName[1] = name1;
                    //arrName[2] = name2;
                    arrName[3] = name3;
                    arrName[4] = name4;
                    arrName[5] = name5;
                    //arrName[6] = name6;
                    arrName[7] = name7;
                    //arrName[8] = name8;
                    var PicArray = new Array (
                            new Array (name0, str[0]),
                            new Array (name1, str[1]),
                            //new Array (name2, str[2]),
                            new Array (name3, str[3]),
                            new Array (name4, str[4]),
                            new Array (name5, str[5]),
                            //new Array (name6, str[6]),
                            new Array (name7, str[7])
                            //new Array (name8, str[8])
                    );
                    //     if (1 == state) {
                    /*
                     * 线性统计图
                     */
                    $ ('#container').highcharts ({
                        title: {
                            text: '${session.lang.AnalysisToolFundsTextAnalysisToolFundsText}',
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
                                text: '万元'
                            },
                            plotLines: [{
                                value: 0,
                                width: 1,
                                color: '#808080'
                            }]
                        },
                        tooltip: {
                            valueSuffix: '万元'
                        },
                        legend: {
                            layout: 'vertical',
                            align: 'right',
                            verticalAlign: 'middle',
                            borderWidth: 0
                        },
                        series: [{
                            name: '${session.lang.CumulativeAmountOfFundsOccupied}',
                            data: str
                        }]
                    });
                    //         } else if (2 == state) {
                    /**
                     * 柱 形 图 统计图
                     */
                    $ ('#container1').highcharts ({
                        chart: {
                            type: 'column'
                        },
                        title: {
                            text: '${session.lang.AnalysisToolFundsTextAnalysisToolFundsText}'
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
                                text: '累计资金占用金额（万元）'
                            }
                        },
                        tooltip: {
                            headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
                            pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
                            '<td style="padding:0"><b>{point.y:f}万 元</b></td></tr>',
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
                            name: '${session.lang.CumulativeAmountOfFundsOccupied}',
                            data: str
                        }]
                    });
                    //             } else {
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
                            text: '${session.lang.CumulativeAmountOfFundsOccupied}'
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
                    //           }
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
    }
</script>
</body>
</html>

