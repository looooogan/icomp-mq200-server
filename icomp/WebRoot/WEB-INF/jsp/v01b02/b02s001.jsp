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
					roll:4,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
					column:[{
						title:'${session.lang.SynthesisParametersCodeText}',
						name:'synthesisParametersCode',
						visible:'${session.gridcol.synthesisParametersCode}'
					},{
						title:'${session.lang.ToolStateText}',
						name:'busStates',
						visible:'${session.gridcol.busStates}',
						format:function(r){
							if(r.busStates=='0'){
								return '<span class="ui-grid-tdtx">${sessionScope.lang.ToSetupText}</span>';
							}else if(r.busStates=='1'){
								return '<span class="ui-grid-tdtx">${sessionScope.lang.ToUnlodeText}</span>';
							}else if(r.busStates=='2'){
								return '<span class="ui-grid-tdtx">${sessionScope.lang.ToAdjustText}</span>';
							}else if(r.busStates=='3'){
								return '<span class="ui-grid-tdtx">${sessionScope.lang.ToRecycleText}</span>';
							}else if(r.busStates=='4'){
								return '<span class="ui-grid-tdtx">${sessionScope.lang.ToGivebackText}</span>';
							}
						}
					},{
						title:'${session.lang.LastOperatorText}',
						name:'updateUser',
						visible:'${session.gridcol.updateUser}'
					},{
						title:'${session.lang.LastOperateTimeText}',
						name:'updateTime',
						visible:'${session.gridcol.updateUser}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.updateTime)+'</span>';
                        }
					},{
						title:'${session.lang.LastOperateBusinessText}',
						name:'businessName',
						visible:'${session.gridcol.businessName}'
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
				* 待处理刀具信息查询
				*/
				$("#processingToolsSubmit").click(function(){
					var param = {
							opt:'list',
							SynthesisParametersCode:$(processingToolsForm.SynthesisParametersCode).val(),
							DivStates:$(processingToolsForm.DivStates).val(),
							DateStar:$(processingToolsForm.dstar).val(),
							DateEnd:$(processingToolsForm.dend).val(),
						}
						$('#list').grid('url','B02S001.action');
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
				<span>${sessionScope.lang.b02s001pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="processingToolsForm" name="processingToolsForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${session.lang.SynthesisParametersCodeText}
							</th>
							<td>
								<input name="SynthesisParametersCode" type="text" class="u-ipt" maxlength="50">
							</td>
							<th width="150">
								${sessionScope.lang.TimeText}
							</th>
							<td style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
							<th width="150">
								${session.lang.ToolStateText}
							</th>
							<td>
								<select class="u-sel"  name="DivStates" >
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<option value="0">${sessionScope.lang.ToSetupText}</option>
									<option value="1">${sessionScope.lang.ToUnlodeText}</option>
									<option value="2">${sessionScope.lang.ToAdjustText}</option>
									<option value="3">${sessionScope.lang.ToRecycleText}</option>
									<option value="4">${sessionScope.lang.ToGivebackText}</option>
								</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="processingToolsSubmit" >${sessionScope.lang.submitSearchText}</button>
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

