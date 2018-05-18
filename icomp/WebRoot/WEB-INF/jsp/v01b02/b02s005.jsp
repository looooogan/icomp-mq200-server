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
						title:'${session.lang.KnifeManText}',
						name:'knifeMan',
						visible:'${session.gridcol.knifeMan}'
					},{
						title:'${session.lang.OperationTimeText}',
						name:'operationTime',
						visible:'${session.gridcol.operationTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate1(r.operationTime)+'</span>';
                        }
					},{
						title:'${session.lang.TheToolNumberText}',
						name:'totalCount'
					},{
						title:'${session.lang.UnqualifiedDischargeText}',
						name:'states'
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
					KnifeMan:$(workloadForm.KnifeMan).val(),
					DateStar:$(workloadForm.dstar).val(),
					DateEnd:$(workloadForm.dend).val(),
				}
				$('#list').grid('url','B02S005.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}			
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b02s005pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="workloadForm" name="workloadForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.KnifeManText}
							</th>
							<td>
								<input name="KnifeMan" type="text" class="u-ipt" maxlength="36">
							</td>
						    <th width="150">
								${sessionScope.lang.OperationTimeText}
							</th>
							<td  style="white-space: nowrap">
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
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

