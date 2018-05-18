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
						title:'${session.lang.ToolCodeText }',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.ToolStateText}',
						name:'toolState',
						visible:'${session.gridcol.toolState}',
						format:function(r){
						//0断刀1丢失2不合格3借入4申领9其他
					if(r.toolState == 0){return '<span class="ui-grid-tdtx">${session.lang.CuttingKnife}</span>';}
					   else if(r.toolState == 1){return '<span class="ui-grid-tdtx">${session.lang.Missing}</span>';}
					   else if(r.toolState == 2){return '<span class="ui-grid-tdtx">${session.lang.Unqualified}</span>';}
					   else if(r.toolState == 3){return '<span class="ui-grid-tdtx">${session.lang.Borrow}</span>';}
					   else if(r.toolState == 4){return '<span class="ui-grid-tdtx">${session.lang.Apply}</span>';}
					   else {return '<span class="ui-grid-tdtx">${session.lang.Other}</span>';}
						}
					},{
						title:'${session.lang.ProcessNumberText}',
						name:'avgProcessAmount',
						visible:'${session.gridcol.salvageValue}'
					},{
						title:'${session.lang.ScrapValueText}',
						name:'salvageValue',
						visible:'${session.gridcol.salvageValue}'
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
				* 加工信息快速查询
				*/
				$("#searchSubmit").click(function(){
					var param = {
							opt:'list',
							ToolCode:$(searchForm.ToolCode).val(),
						}
						$('#list').grid('url','B04S006.action');
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
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.MachiningInformationText}&gt;${sessionScope.lang.QuickSearchText}</span>
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
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
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

