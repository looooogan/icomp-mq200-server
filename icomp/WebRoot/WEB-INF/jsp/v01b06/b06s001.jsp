<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp"%>
	<script type="text/javascript"
			src="<%=path%>/script/highcharts/highcharts.js"></script>
	<script type="text/javascript"
			src="<%=path%>/script/highcharts/myhighcharts.js"></script>
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
				type:'post',
				width:'100%',
				fit:true,
				lazy:false,
				async:false,
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
//
//				},
					{
					title:'材料号',
					name:'toolCode'
				},{
					title:'入库时间',
					name:'createTimes'
					,
					format:function(r){
						return '<span class="ui-grid-tdtx">'+fdate1(r.createTimes)+'</span>';
					}
				},
					<!-- 2017/07/03 宋健 变更↓↓↓　dazhong@YMSC -->
					{
						title:'报废前状态',
						name:'businessName'
					},
					<!-- 2017/07/03 宋健 变更↑↑↑　dazhong@YMSC -->
					{
						title:'操作者',
						name:'createUsers'
					},{
						title:'报废原因',
						name:'scrapCause',
						format:function(r) {
							//  （0.断刀1.丢刀2.到寿3.出库报废4.其他）
							if (r.scrapCause == 0) {
								return '<span class="ui-grid-tdtx">断刀</span>';
							}
							else if (r.scrapCause == 1) {
								return '<span class="ui-grid-tdtx">丢刀</span>';
							}
							else if (r.scrapCause == 2) {
								return '<span class="ui-grid-tdtx">到寿</span>';
							}

							else  {
								return '<span class="ui-grid-tdtx">其他</span>';
							}


						}
					},
					<!-- 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC -->
					{
						title:'报废数量',
						name:'scrapNumber'
					},
					<!-- 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC -->
					{
						title:'授权人',
						name:'authorizationUser'

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
						// 没有数据
						artDialog(d.message,"OK");
					}
				}
			}) ;
		});


		$(function(){
			/**
			 * 报废分析查询
			 */
			$("#submitSearch").click(function(){
				var param = {
					opt: "list",

					//ToolConsumetype:$(searchForm.ToolConsumetype).val(),
					//刀具编码
					ToolCode:$(searchForm.systeCode).val(),
					//开始时间
					DateStar:$(searchForm.dstar).val(),
					//结束时间
					DateEnd:$(searchForm.dend).val(),
					//授权者
					Authorized:$(searchForm.Authorized).val(),
					//报废原因
					ScrapReason:$(searchForm.ScrapReason).val(),
					//操作流程
					Operation:$(searchForm.operation).val(),
					//操作者
					StorageCheck:$(searchForm.StorageCheck).val(),

				}
				$('#list').grid('url','B06S001.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});
			//导出
			$("#infoExport").click(function () {
				$.dialog.confirm('您确定要导出么？', function (){
					//$("#toolConsumetypeHid").val($(searchForm.ToolConsumetype).val());
					$("#dateStarHid").val($(searchForm.dstar).val());
					$("#dateEndHid").val($(searchForm.dend).val());
					$("#systeCodeHid").val($(searchForm.systeCode).val());
					$("#operationHid").val($(searchForm.operation).val());
					$("#authorizedHid").val($(searchForm.Authorized).val());
					$("#scrapReasonHid").val($(searchForm.ScrapReason).val());
					$("#storageCheckHid").val($(searchForm.StorageCheck).val());

					$("#hidFrom").submit();
				});

			});
			/**
			 * 报废分析统计
			 */
			$("#statistically").click(function(){
				var param = {
					opt: "list",
					//刀具编码
					ToolCode:$(searchForm.systeCode).val(),
					//开始时间
					DateStar:$(searchForm.dstar).val(),
					//结束时间
					DateEnd:$(searchForm.dend).val(),
					//报废原因
					ToolState:$(searchForm.ScrapReason).val(),
				};
				$('#list').grid('url','B06S001.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				$.ajax({
					type: "POST",
					url: "statistics_b06S001.action",
					data: param,
					success: function(data){
						//数量
						var str  = data.substr(1,data.length-2).split(",");
						//sting转化为int
						for ( var i = 0; i < str.length; i++) {
							str[i] = parseInt(str[i]);
						}
						if (data.length > 0) {
							var breakKnife = '${session.lang.CuttingKnife}';
							var throwingKnife ='${session.lang.LoseKnife}';
							var daoshouKnife= '到寿';
							var othe='其他';
							var arrName = new Array();
//					   0.断刀1.丢刀2.到寿3.出库报废4.其他
							arrName[0] =  breakKnife;
							arrName[1] = throwingKnife;
							arrName[2] = daoshouKnife;
							arrName[3] = othe;

							var PicArray = new Array(
									new Array(breakKnife,str[0]),
									new Array(throwingKnife,str[1]) ,
									new Array(daoshouKnife,str[2]),
									new Array(othe,str[3])
							);

							/*
							 * 线性统计图
							 */
							$('#container').highcharts({
								title: {
									text: '${session.lang.KnifeScrapAnalysis}',
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
										text: '${session.lang.Number}'
									},
									plotLines: [{
										value: 0,
										width: 1,
										color: '#808080'
									}]
								},
								tooltip: {
									valueSuffix: '${session.lang.Number}'
								},
								legend: {
									layout: 'vertical',
									align: 'right',
									verticalAlign: 'middle',
									borderWidth: 0
								},
								series: [{
									name: '${session.lang.CumulativeScrapNumber}',
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
									text: '${session.lang.KnifeScrapAnalysis}'
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
										text: '${session.lang.KnifeScrapNumber}'
									}
								},
								tooltip: {
									headerFormat: '<span style="font-size:10px">{point.key}</span><table>',
									pointFormat: '<tr><td style="color:{series.color};padding:0">{series.name}: </td>' +
									'<td style="padding:0"><b>{point.y:f} 个</b></td></tr>',
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
									name: '${session.lang.CumulativeScrapNumber}',
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
									text: '${session.lang.CumulativeScrapNumber}'
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
											formatter: function() {
												return '<b>'+ this.point.name +'</b>: '+ this.percentage.toFixed(1)+' %';
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
							$.dialog({
								id:'tj_list_dialog',
								title:'${session.lang.Statistics}',
								lock: true,
								content:document.getElementById('tj_list'),
							});


						}

					}
				});

			});
			//线性图显示
			$("#lineBtn").click(function(){
				$("#container").show();
				$("#container1").hide();
				$("#container2").hide();
			});

			//柱形图显示
			$("#barBtn").click(function(){
				$("#container").hide();
				$("#container1").show();
				$("#container2").hide();
			});
			//饼形图显示
			$("#pieBtn").click(function(){
				$("#container").hide();
				$("#container1").hide();
				$("#container2").show();

			});



		});
	</script>
</head>
<body>
<div id="hiddDiv" style="display: none">
	<form action="exportExcel06S001.action" method="post" id="hidFrom">

		<input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
		<input type="hidden" name="dateStar"        id="dateStarHid">
		<input type="hidden" name="dateEnd"    		id="dateEndHid">
		<input type="hidden" name="systeCode"		 id="systeCodeHid">
		<input type="hidden" name="authorized"	 id="authorizedHid">
		<input type="hidden" name="operation"	 id="operationHid">
		<input type="hidden" name="scrapReason" 		id="scrapReasonHid">
		<input type="hidden" name="storageCheck" 		id="storageCheckHid">

	</form>
</div>


<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText}
					&gt;${sessionScope.lang.DecisionAnalysisText}&gt;报废原因分析</span>
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

							<%--<option value="6">--%>
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
					<th width="100">
						材料号
					</th>
					<td>
						<input name="systeCode" type="text" class="u-ipt" maxlength="50">
					</td>
					<th width="100">
						授权人
					</th>
					<td>
						<input name="Authorized" type="text" class="u-ipt" maxlength="50">
					</td>
				</tr>
				<tr>
					<th>
						报废原因
					</th>
					<td>
						<%-- //  （0.断刀1.丢刀2.到寿3.出库报废4.其他）--%>
						<select class="u-sel" name="ScrapReason" maxlength="16">
							<option value="">
								--请选择--
							</option>

							<option value="0">
								断刀
							</option>

							<option value="1">
								丢刀
							</option>

							<option value="2">
								到寿
							</option>

							<option value="4">
								其他
							</option>

						</select>
					</td>
					<th width="100">
						操作流程
					</th>
					<td>
						<select class="u-sel" name="operation" maxlength="16">
							<option value="">
								--请选择--
							</option>
							<option value="C01S005">
								刀具报废
							</option>

							<option value="C01S010">
								刀具换装
							</option>

							<option value="C01S013">
								卸下设备
							</option>

						</select>
					</td>
					<th width="100">
						操作者
					</th>
					<td>
						<input name="StorageCheck" type="text" class="u-ipt" maxlength="50">
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
				</tr>


			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="submitSearch">
					${sessionScope.lang.submitSearchText}
				</button>
				<button type="button" class="u-btn2" id="statistically">
					${sessionScope.lang.submitStatisticsText}
				</button>
				<button type="button" class="u-btn2" id="infoExport">
					导出
				</button>
			</div>
		</form>
		<div class="f-cb"></div>

		<div class="u-ptt">
			<div style="float:left;">${sessionScope.lang.searchList}</div>
			<div style="float:right;">
				共： <span id="number1"></span> &nbsp;条
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

