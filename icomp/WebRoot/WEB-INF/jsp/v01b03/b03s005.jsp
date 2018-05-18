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
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.NoticeOldLengthText}',
						name:'noticeOldLength',
						visible:'${session.gridcol.noticeOldLength}'
					},{
						title:'${session.lang.GrindingText}',
						name:'isRepaired',
						visible:'${session.gridcol.whetherGrinding}'
					},{
						title:'${session.lang.UsageCounterText}',
						name:'usageCounter',
						visible:'${session.gridcol.usageCounter}'
					},{
						
						title:'${session.lang.ScrapValueText}',
						name:'residualValue',
						visible:'${session.gridcol.salvageValue}',
						format:function(r){
							var money=fmoney(r.residualValue,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
						visible:'${session.gridcol.unitPrice}',
						format:function(r){
							var money=fmoney(r.unitPrice,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'修复方式',
						name:'repairWay',
						format:function(r){
							var type=r.repairWay;
							if(type=='0'){
							return '<span class="ui-grid-tdtx">厂内复磨</span>';
							}
							if(type=='1'){
							return '<span class="ui-grid-tdtx">厂内维修</span>';
							}
							if(type=='2'){
							return '<span class="ui-grid-tdtx">厂内涂层</span>';
							}
							if(type=='3'){
							return '<span class="ui-grid-tdtx">出厂涂层</span>';
							}
							if(type=='4'){
							return '<span class="ui-grid-tdtx">出厂维修</span>';
							}
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
				* 快速查询
				*/
				$("#searchSubmit").click(function(){
					var param = {
							opt:'list',
							ToolCode:$(searchForm.ToolCode).val(),
						}
						$('#list').grid('url','B03S005.action');
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
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.GrindingInformationText}&gt;${sessionScope.lang.QuickSearchText}</span>
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
						<button type="button" class="u-btn2" id="searchSubmit" >${sessionScope.lang.submitSearchText}</button>
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

