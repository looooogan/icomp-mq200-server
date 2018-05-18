<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
					rowEdit:true,
					colEdit:6,
					rowno:true,
					//rows:${session.rowsize},
					roll:6,
					pager:false,
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
						title:'${session.lang.InventoryText}',
						name:'toolCount',
						visible:'${session.gridcol.inventory}'
					},{
						title:'${session.lang.purchaseCountText}',
						name:'purchaseCount',
						visible:'${session.gridcol.procurementCount}'
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'130px',
						visible:'true',
						format:function(r,t){
						return '<a href="javascript:void(0)"  class="editDiv">${session.lang.addText}</a>';
						}
				}],
					success:function(d){
						if(d.status < 0){
						     artDialog(d.message,"OK");
						   }else{
							   $("#saveAll").show();
							}
					}
				}) ; 

				
				
	});

	$(function(){
		/**
		* 建议采购计划
		*/
		$("#create").click(function(){
			//零部件名称
			var paritId =$(searchForm.PartsID).val(); 
			//周期(天)
			var cycleDays = $(searchForm.CycleDays).val();
			//总数量
			var number = $(searchForm.Number).val();
			var param = {
					opt:'list',
					ToolCode:$(searchForm.ToolCode).val()
				}
				$('#list').grid('url','B06S003.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
					
		});
 	/**
	 * 操作列编辑
	 */	
	$(".editDiv").live("click",function(){
		$("#saveAll").show();
		var $procurementVar = $(this).parent("td").prev("td").children(".ui-grid-tdtx");
		var $toolCodeVar = $(this).parent("td").siblings("td[field='toolCode']").children(".ui-grid-tdtx");
		var $toolIDVar = $(this).parent("td").siblings("td[field='toolID']").children(".ui-grid-tdtx");
		var $assemblyLineNameVar = $(this).parent("td").siblings("td[field='assemblyLineName']").children(".ui-grid-tdtx");
		var $toolCountVar = $(this).parent("td").siblings("td[field='toolCount']").children(".ui-grid-tdtx");
		//给弹出DIV赋值
		$("#div_procurement").val($procurementVar.text());
		//清空错误提示内容框
		$("#spanText").text("");
		//弹出DIV
		$.dialog({
			id:'roleEdit_dialog',
			title:'${session.lang.EditText}',
			lock: false,
			content:document.getElementById('procurementDiv'),
			button:[{
				name:'${session.lang.SureText}',
				callback:function(){
					//确定添加到提交列表中
					return addTOcommitList($toolCodeVar,$toolIDVar,$assemblyLineNameVar, $toolCountVar);
				}
			}]
		});
		});
		
	//确定添加到提交列表中
	function addTOcommitList($toolCodeVar,$toolIDVar,$assemblyLineNameVar, $toolCountVar){
		//采购数量
		var proCurement=$("#div_procurement").val();
		if (isNum(proCurement)) {
			if((proCurement*1)>0){
			$("#proListTable").append("<tr>"+
				"<td style='display: none;'>"+$toolIDVar.text()+"</td>"+
				"<td  align='center'>"+$toolCodeVar.text()+"</td>"+
				"<td style='display: none;'>"+$assemblyLineNameVar.text()+"</td>"+
				"<td style='display: none;'>"+$toolCountVar.text()+"</td>"+
				"<td align='center'>"+proCurement+"</td>"+
				"<td align='center'><a href='javascript:void(0)' class='delTr'>${session.lang.submitDelText}</a></td></tr>");
				return true;
			 }else{
				$("#spanText").text('${session.lang.purchaseCountMsg}');
				return false;
			 }
		}else{
			//只能是数字!
			$("#spanText").text('${sessionScope.lang.OnlyDigits}');
			return false;
		}
	}
	//删除
	$(".delTr").live("click",function(){
  		$(this).parent("td").parent("tr").remove();
	});
	/**
	 * 保存 所有的数据
	 */
	$("#saveAll").live("click",function(){
		$("#saveAll").hide();
		//参数
		var params = '';
		var index=0;
		$("#proListTable tr").children().each(function() {
			if(index>5){
				if($(this).text() != '${sessionScope.lang.submitDelText}'){
					params += $(this).text()+',';
				}else{
					params += "###";	
				}
			}
			index++;
		});
		var param = {opt:'list',
					//要传递的内容
					Contents:params	
				};
			$.ajax({
				url:"b06S003Save.action",
				type: "post",
				dataType:"json",
				data:param,
				success:function(d){
				    artDialog(d.message,"OK");
				    //除了第一行全部清除
 					$("#proListTable tr:gt(0)").empty();
				    
				}
			});
	});
});

/*
*判断是否是数字
*/
function isNum(num){
      var reNum = /^\d*$/;
      return (reNum.test(num));
   }

			
</script>
	</head>
	<body>
		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText}
					&gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.ProposedProcurementPlanText}</span>
				<%@ include file="../head_div.jsp"%>
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
						<button type="button" class="u-btn2" id="create">
							${sessionScope.lang.submitCreateText}
						</button>
					</div>
				</form>
				<div class="f-cb"></div>
			</div>
			<div class="ui-layout-center">
				<div class="u-ptt">
					${sessionScope.lang.ProcuredOrderText}
				</div>
				<div>
					<table id="proListTable" width="100%" class="m-frmtb">
						<tr align="left">
							<th style='display: none;'>
							</th>
							<th align="left">
								${session.lang.ToolCodeText}
							</th>
							<th style='display: none;'>
							</th>
							<th style='display: none;'>
							</th>
							<th>
								${sessionScope.lang.ProcuredCountText}
							</th>
							<th>
								${session.lang.OperationText}
							</th>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" style="display: none"
							id="saveAll">
							${sessionScope.lang.submitSaveText}
						</button>
					</div>
				</div>
				<div class="u-ptt">
					${sessionScope.lang.searchList}
				</div>
				<table id="list"></table>
			</div>

		</div>

		<div id="procurementDiv" class="f-dn">
			<table class="m-frmtb" width="100%">
				<tr>
					<th width="150">
						${sessionScope.lang.ShouldPurchaseQuantity}
					</th>
					<td style="white-space: nowrap">
						<input id="div_procurement" type="text" class="u-ipt" maxlength="10">
						<span id="spanText" style="color: red"> </span>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>

