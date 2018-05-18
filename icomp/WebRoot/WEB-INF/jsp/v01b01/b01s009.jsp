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
					//url:'init.action?opt=list',
					barid:'#bar',
					datatype:'json',
					type:'post',
					width:'100%',
					fit:true,
					lazy:false,
					async:false,
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
						title:'${session.lang.ToolSupplierText}',
						name:'toolSupplier',
						visible:'${session.gridcol.toolSupplier}'
					},{
						title:'${session.lang.ToolBrandText}',
						name:'toolBrand',
						visible:'${session.gridcol.toolBrand}'
					},{
						title:'${session.lang.ProcuredCountText}',
						name:'procuredCount',
						visible:'${session.gridcol.procuredCount}'
					},{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
						visible:'${session.gridcol.unitPrice}',
						format:function(r){
							var money=fmoney(r.unitPrice,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.TheyStatusText}',
						name:'theyStatus',
						visible:'${session.gridcol.theyStatus}',
						format:function(r){
						//0未到货1已到货2质检通过3质检未通过
						if(r.theyStatus == 0 ){return '<span class="ui-grid-tdtx">${session.lang.NotArrive}</span>';}
				   else if(r.theyStatus == 1 ){return '<span class="ui-grid-tdtx">${session.lang.HasArrived}</span>';}
				   else if(r.theyStatus == 2 ){return '<span class="ui-grid-tdtx">${session.lang.QualityInspection}</span>';}
				   else if(r.theyStatus == 3 ){return '<span class="ui-grid-tdtx">${session.lang.QualityInspectionNo}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.InspectionUserText}',
						name:'inspectionUser',
						visible:'${session.gridcol.inspectionUser}'
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
				* 质检记录查询
				*/
				$("#inspectionRecordSubmit").click(function(){
					var param = {
							opt:'list',
							ProcuredBatch:$(inspectionRecordFrom.ProcuredBatch).val(),
							ToolCode:$(inspectionRecordFrom.ToolCode).val(),
						}
						$('#list').grid('url','B01S009.action');
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
				<span>${sessionScope.lang.b01s009pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="inspectionRecordFrom" name="inspectionRecordFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ProcuredBatchText}
							</th>
							<td>
								<input name="ProcuredBatch" type="text" class="u-ipt"  maxlength="20">
							</td>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt"  maxlength="40">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="inspectionRecordSubmit" >${sessionScope.lang.submitSearchText}</button>
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

