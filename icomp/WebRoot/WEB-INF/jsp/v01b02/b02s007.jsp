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
					async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.SynthesisParametersCodeText}',
						name:'synthesisParametersCode',
						visible:'${session.gridcol.synthesisParametersCode}'
					},{
						title:'${session.lang.TimeText}',
						name:'operationTime',
						visible:'${session.gridcol.time}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.operationTime)+'</span>';
						}
					},{
						title:'${session.lang.ToolRepairNoticeUserText}',
						name:'recipientUser',
						visible:'${session.gridcol.recipientUser}'
					},{
						title:'${session.lang.ServiceTypeText}',
						name:'businessName',
						visible:'${session.gridcol.businessName}'
					},{
						title:'${session.lang.NumberText}',
						name:'count',
						visible:'${session.gridcol.count}'
				}],
						success:function(d){
						 if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});
			
			/**
			* 查询处理
			*/
			function search(){

				var param = {
					opt:'list',
					BusinessName:$(OperationForm.BusinessCode).val(),
					DateStar:$(OperationForm.dstar).val(),
					DateEnd:$(OperationForm.dend).val(),
					RecipientUser:$(OperationForm.RecipientUser).val(),
					
				}
				$('#list').grid('url','B02S007.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}			
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b02s007pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="OperationForm" name="OperationForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${session.lang.ServiceTypeText}
							</th>
							<td>
								<select class="u-sel" name="BusinessCode">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									
										<option value="C01S008">
											${session.lang.RemoveAssistiveToolText}
										</option>
									
										<option value="C01S009">
											${session.lang.CuttingBackToShopText}
										</option>
										
										<option value="C01S010">
											${session.lang.InstallAssistiveToolText}
										</option>
										
										<option value="C01S012">
											${session.lang.RecyclingOldKnifeText}
										</option>
                                 </select>
							</td>
						    <th width="150">
								${session.lang.TimeText}
							</th>
							<td style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
							<th width="150">
								${session.lang.ToolRepairNoticeUserText}
							</th>
							<td>
								<input name="RecipientUser" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
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

