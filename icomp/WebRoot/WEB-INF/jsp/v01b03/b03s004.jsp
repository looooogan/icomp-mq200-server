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
						title:'${session.lang.NoticeTimeText}',
						name:'noticeTime',
						visible:'${session.gridcol.noticeTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.noticeTime)+'</span>';
                        }
					},{
						title:'${session.lang.ToolRepairNoticeUserText}',
						name:'userName',
						visible:'${session.gridcol.userName}'
					},{
						title:'${session.lang.GrindingSizeText}',
						name:'toolGrindingLength',
						visible:'${session.gridcol.toolGrindingLength}'
					},{
						title:'${session.lang.OverproofText}',
						name:'overproof',
						visible:'${session.gridcol.overproof}',
						format:function(r){
						var type=r.overproof;
							if(type=='0'){
							return '<span class="ui-grid-tdtx">${session.lang.NotExceedStandard}</span>';
							}
							if(type=='1'){
							return '<span class="ui-grid-tdtx">${session.lang.HaveExceedStandard}</span>';
							}
						}
					},{
						title:'加工${session.lang.TotalNumberText}',
						name:'toolProcessingVolume',
						visible:'${session.gridcol.toolProcessingVolume}'
					},{
						title:'${session.lang.DepreciationAmountText}',
						name:'depreciationAmount',
						visible:'${session.gridcol.depreciationAmount}',
						format:function(r){
							var money=fmoney(r.depreciationAmount,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.ScrapValueText}',
						name:'salvageValue',
						visible:'${session.gridcol.salvageValue}',
						format:function(r){
							var money=fmoney(r.salvageValue,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
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
				* 刃磨工作量汇总
				*/
				$("#searchSubmit").click(function(){
					var param = {
							opt:'list',
							UserName:$(searchForm.UserName).val(),
							DateStar:$(searchForm.dstar).val(),
					        DateEnd:$(searchForm.dend).val(),
						}
						$('#list').grid('url','B03S004.action');
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
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.GrindingInformationText}&gt;${sessionScope.lang.GrindingWorkSummaryText}</span>
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
								${sessionScope.lang.ToolRepairNoticeUserText}
							</th>
							<td>
								<input name="UserName" type="text" class="u-ipt" maxlength="20">
							</td>
							<th width="150">
								${sessionScope.lang.NoticeTimeText}
							</th>
							<td  style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
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

