<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp"%>
	<script type="text/javascript" src="<%=path%>/script/highcharts/highcharts.js"></script>
	<script type="text/javascript" src="<%=path%>/script/highcharts/myhighcharts.js"></script>
	<script type="text/javascript">
		$(function(){
			jQuery('body').layout({
				center__childOptions:{
					north__resizable:false,
					spacing_open:0
				},
				north:{
					size:'auto',
					spacing_open:0,
					closable:false,
					resizable:false
				}
			});

			$('#list').grid({
				barid:'#bar',
				datatype:'json',
				type:'post',
				width:'100%',
				fit:true,
				lazy:false,
//					async:false,
				rowno:true,
//					rowEdit:true, //合并单元格为true
//					colEdit:6,  //参照合并列索引
				rows:${session.rowsize},
				roll:6,
				pager:true,
				pagerpos:'right',
				pagercon:'first,last,number,next,prev',
				column:[
//						{
//					title:'刀具类型',
//					name:'toolType'
//				},
					{
					title:'材料号',
					name:'toolCode'
				},{
					title:'库房',
					name:'numberDevices4'
				},{
					title:'备刀库',
					name:'numberDevices5',
				}, {
					title:'待修磨（厂内）',
					name:'numberDevices'
				}, {
					title:'待修磨（厂外）',
					name:'numberDevices1'
				},
					<!-- 2017/08/31 宋健 变更↓↓↓　dazhong@YMSC -->
//						{
//                            title:'待送回',
//                            name:'numberDevices2'
//                       },
					<!-- 2017/08/31 宋健 变更↑↑↑　dazhong@YMSC -->
					{
						title:'厂外修磨',
						name:'numberDevices3'
					}, {
						title:'生产线',
						name:'expandSpace1'
					} ,
					<!-- 2017/08/31 宋健 变更↓↓↓　dazhong@YMSC -->
//						{
//                            title:'待报废',
//                            name:'expandSpace2'
//                        },
					<!-- 2017/08/31 宋健 变更↑↑↑　dazhong@YMSC -->
					{
						title:'报废（累积）',
						name:'numberDevices6'
					}],
				success:function(d){
					if(undefined== d.total){
						$("#number1").text(0);
					}else if(0== d.total){
						$("#number1").text(1);
					} else {
						$("#number1").text(d.total);
					}
					if(d.status < 0){
						artDialog(d.message,"OK");
					}
				}
			}) ;
		});
		$(function(){

			$("#submitSearch").click(function(){
				var param = {
					opt:"list",
					//刀具类别
					//ToolConsumetype:$(searchForm.ToolConsumetype).val(),
					//材料号
					SysteCode:$(searchForm.SysteCode).val(),
				}

				$('#list').grid('url','B06S005.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);



				return false;
			});







			/**
			 * 刀具资金占用情况分析统计
			 */
			$("#statistically").click(function () {
				var param = {
					opt: "list",
					//刀具编码
					//ToolConsumetype: $(searchForm.ToolConsumetype).val(),
					SysteCode: $(searchForm.SysteCode).val(),
				};
				$('#list').grid('url', 'B06S005.action');
				$('#list').grid('data', param);
				$('#list').grid('load', 1);
				$.ajax({
					type: "POST",
					url: "statistics_b06S005.action",
					data: param,
					success: function (data) {
						//数量
						var str = data.substr(1, data.length - 2).split(",");
						//sting转化为float
						for (var i = 0; i < str.length; i++) {
							str[i] = parseFloat(str[i]);
						}
						if (data.length > 0) {
							var name0 = '厂内';
							var name1 = '厂外';
							var name2 = '厂外修磨';
							var name3 = '库房';
							var name4 = '备刀库';
							var name5 = '报废（累积）';
							var name6 = '生产线';
//								var name7 = '';
//								var name8 = '';
							var arrName = new Array();
							arrName[0] = name0;
							arrName[1] = name1;
							arrName[2] = name2;
							arrName[3] = name3;
							arrName[4] = name4;
							arrName[5] = name5;
							arrName[6] = name6;
//								arrName[7] = name7;
//								arrName[8] = name8;
							var PicArray = new Array(
									new Array(name0, str[0]),
									new Array(name1, str[1]),
									new Array(name2, str[2]),
									new Array(name3, str[3]),
									new Array(name4, str[4]),
									new Array(name5, str[5]),
									new Array(name6, str[6])
//										new Array(name7, str[7]),
//										new Array(name8, str[8])
							);

							/*
							 * 线性统计图
							 */
							$('#container').highcharts({
								title: {
									text: '${session.lang.AnalysisToolFundsTextAnalysisToolFundsText}',
									x: -20 // center
								},
								subtitle: {
									text: '刀具实时分布',
									x: -20
								},
								xAxis: {
									// categories: d.title
									categories: arrName
								},
								yAxis: {
									title: {
										text: ''
									},
									plotLines: [{
										value: 0,
										width: 1,
										color: '#808080'
									}]
								},
								tooltip: {
									valueSuffix: ''
								},
								legend: {
									layout: 'vertical',
									align: 'right',
									verticalAlign: 'middle',
									borderWidth: 0
								},
								series: [{
									name: '刀具实时分布',
									data: str
								}]
							});

							/**
							 * 柱 形 图 统计图
							 */
							$('#container1').highcharts({
								chart: {
									type: 'column'
								},
								title: {
									text: '${session.lang.AnalysisToolFundsTextAnalysisToolFundsText}'
								},
								subtitle: {
									text: ''
								},
								xAxis: {
									// categories: d.title
									categories: arrName
								},
								yAxis: {
									min: 0,
									title: {
										text: '刀具实时分布'
									}
								},
								tooltip: {
									headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
									pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
									'<td style="padding:0"><b>{point.y:f} </b></td></tr>',
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
									name: '刀具实时分布',
									data: str
								}]
							});

							/**
							 * 饼 形 图
							 */
							$('#container2').highcharts({
								chart: {
									plotBackgroundColor: null,
									plotBorderWidth: null,
									plotShadow: false
								},
								title: {
									text: '刀具实时分布'
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
												return '<b>' + this.point.name + '</b>: ' + this.percentage.toFixed(1) + ' %';
											}
										}
									}
								},
								series: [{
									type: 'pie',
									name: '刀具实时分布',
									data: PicArray
								}]
							});

							//显示统计框
							$.dialog({
								id: 'tj_list_dialog',
								title: '${session.lang.Statistics}',
								lock: true,
								content: document.getElementById('tj_list'),
							});
						}

					}
				});

			});
			//线性图显示
			$("#lineBtn").click(function () {
				$("#container").show();
				$("#container1").hide();
				$("#container2").hide();
			});

			//柱形图显示
			$("#barBtn").click(function () {
				$("#container").hide();
				$("#container1").show();
				$("#container2").hide();
			});
			//饼形图显示
			$("#pieBtn").click(function () {
				$("#container").hide();
				$("#container1").hide();
				$("#container2").show();

			});

		});


	</script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;库存信息&gt;${sessionScope.lang.ToolRealtimeDistributionText}</span>
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
					<th width="150">
						材料号
					</th>
					<td>
						<input name="SysteCode" type="text" class="u-ipt" maxlength="50">
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="submitSearch" >${sessionScope.lang.submitSearchText}</button>
				<button type="button" class="u-btn2" id="statistically">
					${sessionScope.lang.submitStatisticsText}
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
<%--加载div--%>
<div id="loads" align="center"><img src="images/loading.gif" width="28" height="28" align="absmiddle"/>加载中...</div>
</body>
</html>

