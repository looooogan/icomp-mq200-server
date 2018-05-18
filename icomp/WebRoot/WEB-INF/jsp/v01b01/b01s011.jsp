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
						title:'${session.lang.TheyTimeText}',
						name:'theyTime',
						visible:'${session.gridcol.theyTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.theyTime)+'</span>';
                        }
					},{
						title:'${session.lang.TheyCountText}',
						name:'theyCount',
						visible:'${session.gridcol.theyCount}'
					},{
						title:'${session.lang.TheyStatusText}',
						name:'retErrFlag',
						visible:'${session.gridcol.theyStatus}',
						format:function(r){
							if(r.retErrFlag){
					  			 return '<span class="ui-grid-tdtx">${session.lang.TimedOutText}<span style="color:red">'+r.dayCount+'</span>${session.lang.DayText}</span>';
							}else{
					  			 return '<span class="ui-grid-tdtx">${session.lang.InTransitText}<span style="color:red"></span></span>';
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
				* 在途计划报警查询
				*/
				$("#transitAlarmSubmit").click(function(){
					var param = {
							opt:'list',
							ProcuredBatch:$(transitAlarmFrom.ProcuredBatch).val(),
						}
						$('#list').grid('url','B01S011.action');
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
				<span>${sessionScope.lang.b01s011pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="transitAlarmFrom" name="transitAlarmFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ProcuredBatchText}
							</th>
							<td>
								<input name="ProcuredBatch" type="text" class="u-ipt"  maxlength="20">
							</td>
					</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="transitAlarmSubmit" >${sessionScope.lang.submitSearchText}</button>
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

