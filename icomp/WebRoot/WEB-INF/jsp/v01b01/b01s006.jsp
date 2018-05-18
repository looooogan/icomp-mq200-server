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
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.TempToolCodeText}',
						name:'tempToolCode',
						visible:'${session.gridcol.tempToolCode}'
					},{
						title:'${session.lang.CutterTypeText}',
						name:'cutterType',
						visible:'${session.gridcol.cutterType}'
					},{
						title:'${session.lang.SynthesisCutterNumberText}',
						name:'synthesisCutterNumber',
						visible:'${session.gridcol.synthesisCutterNumber}'
					},{
						title:'${session.lang.InventoryText}',
						name:'amount',
						visible:'${session.gridcol.amount}'
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
				* 更替刀具库存查询
				*/
				$("#replacementSubmit").click(function(){
					var param = {
							opt:'list',
							SynthesisParametersCode:$(replacementFrom.SynthesisParametersCode).val(),
						}
						$('#list').grid('url','B01S006.action');
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
				<span>${sessionScope.lang.b01s006pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="replacementFrom" name="replacementFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.SynthesisParametersCodeText}
							</th>
							<td>
								<input name="SynthesisParametersCode" type="text" class="u-ipt"  maxlength="40">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="replacementSubmit" >${sessionScope.lang.submitSearchText}</button>
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

