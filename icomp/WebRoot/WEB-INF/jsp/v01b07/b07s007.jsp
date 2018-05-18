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
						title:'${session.lang.RfidPurchaseIDText}',
						name:'rfidPurchaseID',
					    visible:'${session.gridcol.rfidPurchaseID}' ,
					},{
						title:'${session.lang.ProcuredCountText}',
						name:'purchaseCount',
					    visible:'${session.gridcol.purchaseCount}' ,
					},{
						title:'${session.lang.PurchaseUserText}',
						name:'purchaseUserWhere',
					    visible:'${session.gridcol.purchaseUser}' ,
					},{
						title:'${session.lang.BalanceText}',
						name:'balance',
					    visible:'${session.gridcol.balance}' ,
					},{
						title:'${session.lang.UsingCountText}',
						name:'usingCount',
					    visible:'${session.gridcol.usingCount}' ,
					},{
						title:'${session.lang.DelFlagText}',
						name:'delFlag',
					    visible:'${session.gridcol.delFlag}' ,
						format:function(r){
						return '<span class="ui-grid-tdtx">'+(r.delFlag == '0'?'${session.lang.DataDelNo}':'${session.lang.DataDelYes}')+'</span>';
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
			* 标签采购
			*/
			function search(){
				var param = {
					opt:'list',
					RfidPurchaseID:$(rfidPurchaseForm.RfidPurchaseID).val(),
				}
				$('#list').grid('url','B07S007.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}		
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b07s007pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="rfidPurchaseForm" name="rfidPurchaseForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.RfidPurchaseIDText}
							</th>
							<td>
								<input name="RfidPurchaseID" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
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

