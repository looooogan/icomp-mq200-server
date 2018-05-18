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
						title:'${session.lang.RedemptionAppliedIDText}',
						name:'redemptionAppliedID',
						visible:'${session.gridcol.redemptionAppliedID}'
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.AppliedNumberText}',
						name:'appliedNumber',
						visible:'${session.gridcol.appliedNumber}'
					},{
						title:'${session.lang.ReturnNumberText}',
						name:'returnNumber',
						visible:'${session.gridcol.returnNumber}'
					},{
						title:'${session.lang.BrokenNumberText}',
						name:'brokenNumber',
						visible:'${session.gridcol.brokenNumber}'
					},{
						title:'${session.lang.LostNumberText}',
						name:'lostNumber',
						visible:'${session.gridcol.lostNumber}'
					},{
						title:'${session.lang.ReceiveNumberText}',
						name:'receiveNumber',
						visible:'${session.gridcol.receiveNumber}'
					},{
						title:'${session.lang.ApplyUserText}',
						name:'applyUserName',
						visible:'${session.gridcol.applyUserName}'
					},{
						title:'${session.lang.ApplyTimeText}',
						name:'-',
						visible:'${session.gridcol.applyTime}',
						format:function(r){
						var appTime=r.applyTime.substr(0,r.applyTime.indexOf('T'));
						return '<span class="ui-grid-tdtx">'+appTime+'</span>';
						}
						
					},{
						title:'${session.lang.ReceiveUserText}',
						name:'receiveUserName',
						visible:'${session.gridcol.receiveUserName}'
					},{
						title:'${session.lang.ReceiveTimeText}',
						name:'receiveTime',
						visible:'${session.gridcol.receiveTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.applyTime)+'</span>';
                        }
					},{
						title:'${session.lang.ProcessingStatusText}',
						name:'processingStatus',
						visible:'${session.gridcol.processingStatus}',
						format:function(r){
						if(r.processingStatus == '0'){//申请中
						return '<span class="ui-grid-tdtx">${session.lang.ProcessingStatus0Text}</span>';
						}else if(r.processingStatus == '1'){//已备货
						return '<span class="ui-grid-tdtx">${session.lang.ProcessingStatus1Text}</span>';
						}else if(r.processingStatus == '2'){//换领已送回
						return '<span class="ui-grid-tdtx">${session.lang.ProcessingStatus2Text}</span>';
						}else if(r.processingStatus == '3'){//换领未送回
						return '<span class="ui-grid-tdtx">${session.lang.ProcessingStatus3Text}</span>';
						}else if(r.processingStatus == '4'){//换领完毕
						return '<span class="ui-grid-tdtx">${session.lang.ProcessingStatus4Text}</span>';
						}
						}
					},{
						title:'${session.lang.DelFlagText}',
						name:'delFlag',
						visible:'${session.gridcol.delFlag}',
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

	$(function(){
		/**
		* 换领申请信息查询
		*/
		$("#redemptionSearch").click(function(){
			var param = {
					opt:'list',
					RedemptionAppliedID:$(redemptionFrom.RedemptionAppliedID).val(),
					ApplyUser:$(redemptionFrom.ApplyUser).val(),
					DateStar:$(redemptionFrom.dstar).val(),
					DateEnd:$(redemptionFrom.dend).val(),
				}
				$('#list').grid('url','B02S002.action');
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
				<span>${sessionScope.lang.b02s002pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="redemptionFrom" name="redemptionFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.RedemptionAppliedIDText}
							</th>
							<td>
								<input name="RedemptionAppliedID" type="text" class="u-ipt" maxlength="20">
							</td>
							<th width="150">
								${sessionScope.lang.ApplyUserText}
							</th>
							<td>
								<input name="ApplyUser" type="text" class="u-ipt" maxlength="36">
							</td>
							<th width="150">
								${sessionScope.lang.ApplyTimeText}
							</th>
							<td  style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="redemptionSearch" >${sessionScope.lang.submitSearchText}</button>
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

