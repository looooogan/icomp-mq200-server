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
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.NumberText}',
						name:'toolCount',
						visible:'${session.gridcol.toolCount}'
					},{
						title:'${session.lang.OperationUserText}',
						name:'returnUser',
						visible:'${session.gridcol.returnUser}'
					},{
						title:'${session.lang.TimeText}',
						name:'returnTime',
						visible:'${session.gridcol.returnTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.returnTime)+'</span>';
                        }
					},{
						title:'${session.lang.ToolStateText}',
						name:'toolStatus',
						visible:'${session.gridcol.toolStatus}',
						format:function(r){
						//0待刃磨1待报废2待入库
						if(r.toolStatus == 0){return '<span class="ui-grid-tdtx">${session.lang.ForGrindingText}</span>';}
						   else if(r.toolStatus == 1){return '<span class="ui-grid-tdtx">${session.lang.ToBeScrappedText}</span>';}
						   else if(r.toolStatus == 2){return '<span class="ui-grid-tdtx">${session.lang.ToBePutInStorageText}</span>';}
							return '';
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
				* 待处理刀具信息查询
				*/
				$("#processingToolsSubmit").click(function(){
					var param = {
							opt:'list',
							ToolCode:$(processingToolsForm.ToolCode).val(),
							DateStar:$(processingToolsForm.dstar).val(),
							DateEnd:$(processingToolsForm.dend).val(),
							ToolStatus:$(processingToolsForm.ToolStatus).val(),
						}
						$('#list').grid('url','B01S003.action');
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
				<span>${sessionScope.lang.b01s003pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="processingToolsForm" name="processingToolsForm"
					method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${session.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="40">
							</td>
							<th width="150">
								${session.lang.TimeText}
							</th>
							<td  style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate"
									onclick="WdatePicker()">
								<input name="dend" type="text" class="u-ipt Wdate"
									onclick="WdatePicker()">
							</td>
							<th width="150">
								${session.lang.ToolStateText}
							</th>
							<td>
								<select class="u-sel" name="ToolStatus">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>

									<option value="0">
										${session.lang.ForGrindingText}
									</option>

									<option value="1">
										${session.lang.ToBeScrappedText}
									</option>

									<option value="2">
										${session.lang.ToBePutInStorageText}
									</option>

								</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="processingToolsSubmit">
							${sessionScope.lang.submitSearchText}
						</button>
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

