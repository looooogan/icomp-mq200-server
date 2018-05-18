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
					rowEdit:true, //合并单元格为true
					colEdit:1,  //参照合并列索引
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
					    visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.ToolSupplierText}',
						name:'toolSupplier',
					    visible:'${session.gridcol.toolSupplier}'
					},{
						title:'${session.lang.ProcuredBatchText}',
						name:'procuredBatch',
					    visible:'${session.gridcol.procuredBatch}'
					},{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
					    visible:'${session.gridcol.unitPrice}'
					},{
						title:'${session.lang.AvgCountText}',
						name:'avgCount',
					    visible:'${session.gridcol.avgCount}'
					},{
						title:'${session.lang.CostPerText}',
						name:'unitCount',
					    visible:'${session.gridcol.unitCount}',
					},{
						title:'${session.lang.ExcDiscardeText}',
						name:'excDiscarde',
					    visible:'${session.gridcol.excDiscarde}',
					    format:function(r){
						return '<span class="ui-grid-tdtx">'+r.excDiscarde * 100+'%</span>';
						}
					},{
						title:'${session.lang.PlanText}',
						name:'plan',
					    visible:'${session.gridcol.plan}',
					    format:function(r){
						return '<span class="ui-grid-tdtx">'+r.plan * 100+'%</span>';
						}
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
				* 刀具供应商分析
				*/
				$("#submitSearch").click(function(){
					var param = {
							opt:'list',
							//时间段开始时间 
							DateStar:$(searchForm.dstar).val(),
							//时间段结束时间
							DateEnd:$(searchForm.dend).val(),
							//供应商
							ToolSupplier:$(searchForm.ToolSupplier).val(),
							//刀具编码
							ToolCode:$(searchForm.ToolCode).val(),
						}
						$('#list').grid('url','B06S004.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});



				/**
				 * 刀具供应商分析统计
				 */
			 	$("#statistically").click(function(){
					var param = {
							//供应商
							ToolSupplier:$(searchForm.ToolSupplier).val(),
							//刀具编码
							ToolCode:$(searchForm.ToolCode).val(),
						};
					$('#list').grid('url','B06S004.action');
					$('#list').grid('data',param);
					$('#list').grid('load',1);
					 $.ajax({
						   type: "POST",
						   url: "statistics_b06S004.action",
						   data: param,
						   success: function(data){
						   //数量
						 	var str  = data.substr(1,data.length-2).split(",");
						 	
						 		//sting转化为int
						 		for ( var i = 0; i < str.length; i++) {
								   str[i] = parseInt(str[i]);
								}
							   if (data.length > 0) {
								   var name0 ="${session.lang.AdvanceTo}";
								   var name1 ='${session.lang.ArriveOnTime}';
								   var name2 ='${session.lang.DelayTo}';
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
									            text: '${session.lang.ToolSupplierAnalysisText}',
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
									            name: '${session.lang.CumulativeArrivalNumber}',
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
									            text: '${session.lang.ToolSupplierAnalysisText}'
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
									                text: '${session.lang.CumulativeArrivalNumbers}'
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
									            name: '${session.lang.CumulativeArrivalNumber}',
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
									            text: '${session.lang.CumulativeArrivalNumber}'
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
				
/***************************************合并单元格   *********************************/
 
 
/*
 * 合并单元格   
 * parts：rowSapn 参照合并列索引
*/
function _w_table_rowspan(rowSpan){
	var secondRow = 9;
	var textArr = new Array();
	//总行的数量
	var count = 0;
	//第几行
	var colIndex = 0;
	//获取总行的数量
	
	 $('#list tbody tr').each(function(){count++ });

	  //获取要合并的内容
	  $('#list tbody tr').each(function(){ 
			  //找到要合并的列
	  		$('td', this).filter(':visible').each(function() { 
	  			if($(this).index() == rowSpan){
		  			//要合并的列加上rowsqan属性
	  				textArr[colIndex] = $(this).text();
	  				colIndex++;
	  			}
	  		});
	  });

	  //相邻相同的数量 (rowspan要赋值)
	  var countArr = findCount(textArr);
	  //显示的数量
	  var showRow = rowCount(countArr);
  	
		  count = 0; //行数
		  indexCount = 0; //rowspan的下标
	  	//进行合并
		  var showRowIndex = 0;
	  $('#list tbody tr').each(function(){  //行
		  

	  			if((count+1) == showRow[showRowIndex]){
	  				//显示列数 
			  		$('td', this).filter(':visible').each(function() {  //列
					  //要合并的列数 
			  			if($(this).index() == secondRow){
		  						$(this).attr("rowspan",countArr[indexCount]);
				  				showRowIndex++;
					  		}
			  		});
			  		
			  		//rowspan的下标
			  		indexCount++;
			  		
			  		//showRowIndex -= 1;//如果只合并单列  取消此运算 ;增加列要减去相应的列数 （2列减1，3列减2，3列减2...) 
	  			}else{
					  //要隐藏列数 
			  		$('td', this).filter(':visible').each(function() {  //列
			  			if($(this).index() == secondRow){
		  						$(this).hide();
					  		}
			  		});	
  				}
	  		count++;
	  });
}
/**
 * 求要合并的行数
 * paras：要合并内容的数组
 * return：要合并的第一行的行数
 */ 
function findCount(arr){ 
	//要合并的行
	var arr1 = new Array();
	/**
	 *要合并的行
	 */
	var h = 0;
	 a:	for (var i = 0; i < arr.length; i++) {
			var count = 0;
			for (var j = i; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					if(j == arr.length-1){
						arr1[h] = count; 
						break a;
					}
				}else if (j >= i) {
					i = j-1;
					break;
				}
			}
			arr1[h] = count;
			h++;
		}
	return  arr1;
}

	/**
	 *要合并的行数(显示)
	 */
function rowCount(arr){
	// 要合并的行数（那几个合并,返回的数组）
	var reArr = new Array();
		
	for (var i = 0; i < arr.length; i++) {
		h = 0;
		for (var j = 0; j < i ; j++) {
			h += (arr[j]+1);
		}
		if (i == 0) {
			reArr[i] = 1;
		}else {
			reArr[i] = h-(i-1);
		}
	}
	return  reArr;
}

/***************************************合并单元格   *********************************/	
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.ToolSupplierAnalysisText}</span>
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
								${sessionScope.lang.ToolSupplierText}
							</th>
							<td>
								<input name="ToolSupplier" type="text" class="u-ipt" maxlength="50">
							</td>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="submitSearch" >${sessionScope.lang.submitSearchText}</button>
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

