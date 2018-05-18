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
					//async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.ProcuredBatchText}',
						name:'procuredBatch',
						visible:'${session.gridcol.procuredBatch}'
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.InventoryText}',
						name:'inventory',
						visible:'${session.gridcol.inventory}'
					},{
						title:'${session.lang.ToolTurnoverText}',
						name:'toolTurnover',
						visible:'${session.gridcol.toolTurnover}'
				    },{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
						visible:'${session.gridcol.unitPrice}',
						format:function(r){
							var money=fmoney(r.unitPrice,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.AmountMoneyText}',
						name:'amountMoney',
						visible:'${session.gridcol.amountMoney}',
						format:function(r){
							var money=fmoney(r.amountMoney,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},],
					success:function(d){
					if(d.status < 0){
					     artDialog(d.message,"OK");
					   }
					}
				}) ; 
			});

			$(function(){
				/**
				* 库存信息快速查询
				*/
				$("#toolQuickSearchSubmit").click(function(){
					var param = {
							opt:'list',
							ToolCode:$(toolQuickSearchFrom.ToolCode).val(),
						}
						$('#list').grid('url','B01S010.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});
			});

			
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b01s010pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="toolQuickSearchFrom" name="toolQuickSearchFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt"  maxlength="40">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="toolQuickSearchSubmit" >${sessionScope.lang.submitSearchText}</button>
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
	</body>
</html>

