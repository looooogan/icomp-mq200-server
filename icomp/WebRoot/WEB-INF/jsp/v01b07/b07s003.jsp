<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="../common/header_common.jsp"%>
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
						async:true,
						rowno:true,
						rowEdit:true, //合并单元格为true
						colEdit:6,  //参照合并列索引
						rows:${session.rowsize},
						roll:6,
						pager:true,
						pagerpos:'right',
						pagercon:'first,last,number,next,prev',
					column:[{
						title:'${session.lang.ToolIDText}',
						name:'toolID',
					    visible:'${session.gridcol.toolID}'
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
					    visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.ShouldPurchaseQuantity}',
						name:'procurementCount',
					    visible:'${session.gridcol.procurementCount}'
					},{
						title:'${session.lang.CreateTimeText}',
						name:'createTime',
					    visible:'${session.gridcol.createTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.createTime)+'</span>';
                        }
					},{
						title:'${session.lang.CreateUserText}',
						name:'userName',
					    visible:'${session.gridcol.userName}'
					},{
						title:'${session.lang.ProcurementPlanCodeText}',
						name:'procurementPlansCode',
					    visible:'${session.gridcol.procurementPlansCode}'
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'130px',
						visible:'true',
						format:function(r,t){
						return option(r);
						}
					}],
						success:function(d){
							if(d.status < 0){
							     artDialog(d.message,"OK");
							   }
						}
					}) ; 
				});
				
				
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)" class="editDiv">${session.lang.EnableText}</a></li>'));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(0 == 0){del(r.procurementPlansCode,r.version,r.updateTime,r.updateUser,this)}}));
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
			
			
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.DepartmentDelInfo}',function(){
				    var param = {
					procurementPlansCode:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"procurementPlansDel.action",
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status >= 0){
								$('#list').grid('load');
							}
							artDialog(d.message,"OK");
						}
					});
				});
			}
				
	$(function(){
			/**
			* 采购计划处理
			*/
			$("#search").click(function(){
				var param = {
					opt:'list',
					//时间段开始时间 
					DateStar:$(searchForm.dstar).val(),
					//时间段结束时间
					DateEnd:$(searchForm.dend).val(),
					ProcurementPlansID:$(searchForm.ProcurementPlansID).val()
				}
				$('#list').grid('url','B07S003.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});


			/**
			 * 操作列编辑
			 */	
			$(".editDiv").live("click",function(){
				var $this = $(this);
				
				//找到前一列的值 
				var procurementVar = $(this).parents("td").prev("td").children(".ui-grid-tdtx").text();
				//到货数量(总数)
				var procurementCountVal  = $(this).parents("td").siblings("td").eq(3).text();
				var param = {
						ProcurementPlansCode:procurementVar
					}
				$.ajax({
					url:"procurementInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.data.length == 0){
					     artDialog(d.message,"OK");
					   }else{
						   var relist = d.data;
						   $("#procurementDiv").empty();
						   var pHtml = '';
						   		pHtml += '<table id="listTable" class="m-frmtb" width="100%">';
						   		pHtml += '<tr><th width="150">${session.lang.ProcuredPayingText}</th><td><select class="u-sel" id="procuredPaying"><option value="1">${session.lang.NotPayText}</option><option value="0">${session.lang.PaidText}</option></select></td>';
						   		pHtml += '<th width="150">${session.lang.ProcuredTimeText}</th>';
						   		pHtml +='<td style="white-space: nowrap"><input id="procuredTime" type="text" class="u-ipt Wdate" onclick="WdatePicker()" >';
						   		pHtml += '<span id="procuredTimeErrorSpan" style="color: red"></span>';
						   		pHtml += '</td></tr>';
							for ( var i = 0; i < relist.length; i++) {
								pHtml +='<tr><th width="150">${session.lang.ToolCodeText}</th><td><input id="toolCode_'+i+'" value="'+relist[i].toolCode+'" type="text" disabled="true" class="u-ipt" ></td>'; 
								pHtml += '<th width="150">${session.lang.UnitPriceText}</th>'
								pHtml += '<td style="white-space: nowrap"><input id="unitPrice_'+i+'"  type="text" class="u-ipt" maxLength="10">';
								pHtml += '<input id="procuredCount_'+i+'"  type="hidden" value="'+relist[i].procurementCount+'"><input id="toolID_'+i+'"  type="hidden" value="'+relist[i].toolID+'" maxlength="11">';
								pHtml += '<span id="ErrorSpan_'+i+'" style="color: red"></span>';
								pHtml += '</td></tr>';
							}
							pHtml += '</table>';
							$("#procurementDiv").append(pHtml);
							
							//弹出框
							$.dialog({
								id:'roleEdit_dialog',
								title:'${session.lang.EnableProcurementPlan}',
								lock: false,
								content:document.getElementById('procurementDiv'),
								button:[{
									name:'${session.lang.submitSaveText}',
									focus:true,
									callback:function(){
										var flag=false;
										//是否付费
										var procuredPaying = $("#procuredPaying").val();
										//采购时间
										var procuredTime = $("#procuredTime").val();
										$("#procuredTimeErrorSpan").text('');
										
										if(procuredTime.length < 1){
											//请填写采购时间
											$("#procuredTimeErrorSpan").text('${session.lang.PleaseFillInTheTimeOfThePurchase}');
										}else{
											if(fdate2(procurementCountVal)*1>fdate2(procuredTime)*1){
												//请填写采购时间
												$("#procuredTimeErrorSpan").text('采购时间应晚于提出时间');
												flag=true;
											}
										}
										//采购单价
										var  unitPrice ='';
										//刀具ID
										var toolId = '';
										//采购数量
										var procuredCount = '';
										
										for ( var i = 0; i < relist.length; i++) {
											$("#ErrorSpan_"+i).text('');
											//采购单价
											unitPrice += $("#unitPrice_"+i).val()+',';
											var nowUnitPrice =$("#unitPrice_"+i).val();
											//金额验证正则表达式
											var re = /^([1-9]{1}[0-9]{0,2}(\,[0-9]{3})*(\.[0-9]{0,2})?|[1-9]{1}\d*(\.[0-9]{0,2})?|0(\.[0-9]{0,2})?|(\.[0-9]{1,2})?)$/;
											
											if(nowUnitPrice=="" ||nowUnitPrice== null){
											    //请填写完采购单价!
												$("#ErrorSpan_"+i).text('${session.lang.PleaseFillOutThePurchasePrice}');
												flag=true;
											}else if(re.test(nowUnitPrice)==false){
											    //请重新确认金额格式"!
												$("#ErrorSpan_"+i).text("请重新确认金额格式!");
												flag=true;
											}
											//刀具ID
											toolId += $("#toolID_"+i).val()+',';
											//采购数量
											procuredCount += $("#procuredCount_"+i).val()+',';
										}
										if(flag){
											return false;
										}
									  /**
									  *启用采购计划提交
									  */
										var param = {
											ProcurementPlansCode:procurementVar,//采购计划编号 
											ToolId:toolId,//刀具ID
											ProcuredPaying:procuredPaying,//是否付费
											ProcuredTime:procuredTime,//采购时间
											UnitPrice:unitPrice,//采购单价
											ProcuredCount:procuredCount//采购数量
										}
										$this.removeAttr("class");
										$this.text("${session.lang.EnabledText}");
										$.ajax({
											url:"procurementAdd.action",
											type: "post",
											dataType:"json",
											data:param,
											success:function(d){
												if(d.status < 0){
													if(d.status ==-4){
														artDialog(setContorllBackColor($('#toolEditForm'),$.parseJSON(d).message),"OK");
													}else{
													 	$this.attr("class","editDiv");
														$this.text("${session.lang.EnableText}");
												     	artDialog(d.message,"OK");
												     }
												}else{
												     $('#list').grid('load',1);
												     artDialog(d.message,"OK");
												     //$this.removeAttr("class");
													//	$this.text("已启用");
												}
										}
										});
									}
								}]
							});
						}
					}
				});

				/*
				//寻找要用的值
				  $('#list tbody tr').each(function(){	// 行
			  		$('td', this).each(function() { //列
			  			if($(this).text() == procurementVar){
			  				$(this).siblings().each(function(){
								if($(this).attr("field")=== "toolCode"){
										//alert($(this).text());
								}				
				  				});
			  			}
			  		});
			  });
			  */
			
				
				
				
				});


			
	});	




	
/***************************************合并单元格   *********************************/
 
 
/*
 * 合并单元格   
 * parts：rowSapn 参照合并列索引
*/
function _w_table_rowspan(rowSpan){
	var secondRow = 7;
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
			  			if($(this).index() == rowSpan || $(this).index() == 5 ||  $(this).index() == secondRow){
		  						$(this).attr("rowspan",countArr[indexCount]);
				  				showRowIndex++;
					  		}
			  		});
			  		
			  		//rowspan的下标
			  		indexCount++;
			  		
			  		showRowIndex -= 2;//如果只合并单列  取消此运算 ;增加列要减去相应的列数 （2列减1，3列减2，3列减2...) 
	  			}else{
					  //要隐藏列数 
			  		$('td', this).filter(':visible').each(function() {  //列
			  			if($(this).index() == rowSpan || $(this).index() == 5 ||  $(this).index() == secondRow){
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
				<span>${sessionScope.lang.b07s003pageTitle}</span>
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
								${session.lang.ProcurementPlanCodeText}
							</th>
							<td>
								<input name="ProcurementPlansID" type="text" class="u-ipt" maxlength="20">
							</td>
							<th width="150">
								${session.lang.CreateTimeText}
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								--
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" id="search">${sessionScope.lang.submitSearchText}</button>
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
		<div id="procurementDiv" class="f-dn">
		
		</div>
	</body>
</html>

