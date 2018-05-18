<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
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
						title:'${session.lang.PartsText}',
						name:'partsName',
					    visible:'${session.gridcol.partsName}',
					},{
						title:'${session.lang.ToolNameText}',
						name:'toolName',
					    visible:'${session.gridcol.toolName}',
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
					    visible:'${session.gridcol.toolCode}',
					},{
						title:'${session.lang.ActualProcessingVolumeText}',
						name:'processAmount',
					    visible:'${session.gridcol.processAmount}',
					},{
						title:'${session.lang.AvgCountText}',
						name:'avgNum',
					    visible:'${session.gridcol.avgNum}'
					},{
						title:'${session.lang.PlanGrindingTimesText}',
						name:'planGrindingTimes',
					    visible:'${session.gridcol.planGrindingTimes}',
					},{
						title:'${session.lang.ActualGrindingTimesText}',
						name:'actualGrindingTimes',
					    visible:'${session.gridcol.actualGrindingTimes}',
				}],
					success:function(d){
						if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});
			
			
			$(function(){
			var baseData='';
			
				/**
				* 刀具消耗量分析
				*/
				$("#submitSearch").click(function(){
					var param = {
							opt:'list',
							//刀具编码
							ToolCode:$(searchForm.ToolCode).val(),
						}
						$('#list').grid('url','B06S007.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});
					/*
					 * 线性统计图-加载
					 */
			   		function myHighcharts(data){
			   		//数量
				 	var str  =  new Array(); 
				 	var arrName = new Array(); 
				 	var str2  = new Array(); 
				 	var str3  = new Array(); 
				 	var str3  = new Array(); 
				 	var str4  = new Array(); 
					$.each($.parseJSON(data).rows,function (i , dataRow){
						str[i] = parseInt(dataRow.planGrindingTimes==null?0:dataRow.planGrindingTimes);//sting转化为int
						arrName[i]=dataRow.toolCode;
						str2[i] = parseInt(dataRow.actualGrindingTimes==null?0:dataRow.actualGrindingTimes);
						str3[i] = parseInt(dataRow.quotaProcessingVolume==null?0:dataRow.quotaProcessingVolume);//平均值
						str4[i] = parseInt(dataRow.quotaProcessingVolume==null?0:dataRow.quotaProcessingVolume);//平均值
				    });
				     $('#container').highcharts({
				        title: {
				            text: '${session.lang.ConsumptionToolText}',
				            x: -20 // center
				        },
				        subtitle: {
				            text: '${session.lang.IcompKnifeSystem}',
				            x: -20
				        },
				        xAxis: {
				          
					       categories: arrName//每个节点名称
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
				            name: '${session.lang.ActualGrindingTimesText}',
				            data: str
				        },{
				            name: '${session.lang.PlanGrindingTimesText}',
				            data: str2
				        },{
				            name: '${session.lang.QuotaProcessingVolumeText}',
				            data: str3
				        }]
				     });
			   		}
			   		
			   		/**
					 * 柱 形 图 统计图
					 */
			   		
			   		function mycontainer1(data){
			   			//数量
				 	var str  =  new Array(); 
				 	var arrName = new Array(); 
				 	var str2  = new Array(); 
				 	var str3  = new Array(); 
					$.each($.parseJSON(data).rows,function (i , dataRow){
						str[i] = parseInt(dataRow.planGrindingTimes==null?0:dataRow.planGrindingTimes);//sting转化为int
						arrName[i]=dataRow.toolCode;
						str2[i] = parseInt(dataRow.actualGrindingTimes==null?0:dataRow.actualGrindingTimes);
						str3[i] = parseInt(dataRow.quotaProcessingVolume==null?0:dataRow.quotaProcessingVolume);
				    });
					     $('#container1').highcharts({
					        chart: {
					            type: 'column'
					        },
					        title: {
					            text: '${session.lang.ConsumptionToolText}'
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
					                text: '${session.lang.TotalConsumptionNumbers}'
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
					            name: '${session.lang.ActualGrindingTimesText}',
					           data: str
					        },{
					            name: '${session.lang.PlanGrindingTimesText}',
					           data: str2
					        },{
					            name: '${session.lang.QuotaProcessingVolumeText}',
					           data: str3
					        }]
						});	
					}
					 /**
					 * 饼 形 图
					 */
					function mycontainer2 (data){
						//数量
					 	var str  =  new Array(); 
					 	var arrName = new Array(); 
					 	var str2  = new Array(); 
					 	var str3  = new Array(); 
					 	  var PicArray = new Array();
						$.each($.parseJSON(data).rows,function (i , dataRow){
							str[i] = parseInt(dataRow.planGrindingTimes==null?0:dataRow.planGrindingTimes);//sting转化为int
							arrName[i]=dataRow.toolCode;
							str2[i] = parseInt(dataRow.actualGrindingTimes==null?0:dataRow.actualGrindingTimes);
							str3[i] = parseInt(dataRow.quotaProcessingVolume==null?0:dataRow.quotaProcessingVolume);
					     	PicArray.push(new Array(arrName[i],str[i]));
					    });
					     $('#container2').highcharts({
					        chart: {
					            plotBackgroundColor: null,
					            plotBorderWidth: null,
					            plotShadow: false
					        },
					        title: {
					            text: '${session.lang.TotalConsumptionNumber}'
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
					}
					
					
				/**
				 * 刀具消耗量分析统计
				 */
			 	$("#statistically").click(function(){
					var param = {
							opt: "list",
							//刀具编码
							ToolCode:$(searchForm.ToolCode).val(),
						};
					$('#list').grid('url','B06S007.action');
					$('#list').grid('data',param);
					$('#list').grid('load',1);
					 $.ajax({
						   type: "POST",
						   url: "statistics_b06S007.action",
						   data: param,
						   success: function(data){
							//线形图
							myHighcharts(data);	
							mycontainer1(data);	   
							mycontainer2(data);
						   	baseData=data;
							//显示统计框		
							$.dialog({
								id:'tj_list_dialog',
								title:'${session.lang.Statistics}',
								lock: true,
								content:document.getElementById('tj_list'),
							});
								}
					}); 

				});
		//线性图显示
		$("#lineBtn").click(function(){
			$("#container").show();
			$("#container1").hide();
			$("#container2").hide();
			myHighcharts(baseData);
		});
		
		//柱形图显示
		$("#barBtn").click(function(){
			$("#container").hide();
			$("#container1").show();
			$("#container2").hide();
			mycontainer1(baseData);
		});
		//饼形图显示 
		$("#pieBtn").click(function(){
			$("#container").hide();
			$("#container1").hide();
			$("#container2").show();
			mycontainer2(baseData);

		});

});
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.ConsumptionToolText}</span>
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
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" id="submitSearch" >${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" id="statistically" >${sessionScope.lang.submitStatisticsText}</button><!--
						<button type="button" class="u-btn2" >${sessionScope.lang.submitPrintText}</button>
					--></div>
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

