<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
					//async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.SynthesisParametersCodeText}',
						name:'synthesisParametersCode',
					    visible:'${session.gridcol.synthesisParametersCode}',
					},{
						title:'${session.lang.SynthesisParametersNumberText}',
						name:'synthesisParametersNumber',
					    visible:'${session.gridcol.synthesisParametersNumber}',
					},{
						title:'${session.lang.QuotaProcessingVolumeText}',
						name:'quotaProcessingVolume',
					    visible:'${session.gridcol.quotaProcessingVolume}',
					},{
						title:'${session.lang.ActualProcessingVolumeText}',
						name:'actualProcessingVolume',
					    visible:'${session.gridcol.actualProcessingVolume}',
				}],
					success:function(d){
						if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});
			
			$(function(){
				/**
				* 定额执行情况分析
				*/
				$("#submitSearch").click(function(){
					var param = {
							opt:'list',
							//合成刀具编码
							SynthesisParametersCode:$(searchForm.SynthesisParametersCode).val(),
							//时间段开始时间 
							DateStar:$(searchForm.dstar).val(),
							//时间段结束时间
							DateEnd:$(searchForm.dend).val(),
						}
						$('#list').grid('url','B06S006.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});

				/**
				 * 定额执行情况分析统计
				 */
			 	$("#statistically").click(function(){
					var param = {
							opt: "list",
							//合成刀具编码
							SynthesisParametersCode:$(searchForm.SynthesisParametersCode).val(),
							//时间段开始时间 
							DateStar:$(searchForm.dstar).val(),
							//时间段结束时间
							DateEnd:$(searchForm.dend).val(),
						};
					$('#list').grid('url','B06S006.action');
					$('#list').grid('data',param);
					$('#list').grid('load',1);
					 $.ajax({
						   type: "POST",
						   url: "statistics_b06S006.action",
						   data: param,
						   success: function(data){
						   //数量
						 	var str  = data.substr(1,data.length-2).split(",");
						 		//sting转化为int
						 		for ( var i = 0; i < str.length; i++) {
								   str[i] = parseInt(str[i]);
								}
							   if (data.length > 0) {
								   var name0 ='${session.lang.Excess}';
								   var name1 ='${session.lang.Equal}';
								   var name2 ='${session.lang.Lack}';
								   var arrName = new Array(); 
								   	arrName[0] =  name0;
								   	arrName[1] = name1;
								   	arrName[2] = name2;
								   var PicArray = new Array(
											   new Array(name0,str[0]),
											   new Array(name1,str[1]),
											   new Array(name2,str[2])

										   );
										   					   
									/*
									 * 线性统计图
									 */
									     $('#container').highcharts({
									        title: {
									            text: '${session.lang.QuotaImplementationAnalysis}',
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
									            name: '${session.lang.TotalQuotaImplementation}',
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
									            text: '${session.lang.QuotaImplementationAnalysis}'
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
									                text: '${session.lang.TotalQuotaImplementation}'
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
									            name: '${session.lang.TotalQuotaImplementation}',
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
									            text: '${session.lang.TotalQuotaImplementation}'
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

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.AnalysisImplementationQuotaText}</span>
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
							<th width="150">
								${sessionScope.lang.SynthesisParametersCodeText}
							</th>
							<td>
								<input name="SynthesisParametersCode" type="text" class="u-ipt" maxlength="50">
							</td>
							<th width="150">
								${sessionScope.lang.UnloadingTime}
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()"> --
							    <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" id="submitSearch" >${sessionScope.lang.submitSearchText}</button> 
						<button type="button" class="u-btn2" id="statistically" >${sessionScope.lang.submitStatisticsText}</button>
					</div>
				</form>
				<div class="f-cb"></div>

				<div class="u-ptt">
					${sessionScope.lang.searchList}
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

