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
						title:'${session.lang.ProcuredUserText}',
						name:'procuredUser',
					    visible:'${session.gridcol.procuredUser}'  
					},{
						title:'${session.lang.ProcuredTimeText}',
						name:'procuredTime',
					    visible:'${session.gridcol.procuredTime}' 
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
					    visible:'${session.gridcol.toolCode}' 
					},{
						title:'${session.lang.ToolNameText}',
						name:'toolName',
					    visible:'${session.gridcol.toolName}' 
					},{
						title:'${session.lang.ProcuredBatchText}',
						name:'procuredBatch',
					    visible:'${session.gridcol.procuredBatch}' 
					},{
						title:'${session.lang.ProcuredTypeText}',
						name:'procuredType',
					    visible:'${session.gridcol.procuredType}' ,
						format:function(r){
						//0新采购1外委图层2外委复磨9其他
						if(r.procuredType == 0 ){return '<span class="ui-grid-tdtx">${session.lang.NewProcured}</span>';}
				   else if(r.procuredType == 1 ){return '<span class="ui-grid-tdtx">${session.lang.ExternalLayer}</span>';}
				   else if(r.procuredType == 2 ){return '<span class="ui-grid-tdtx">${session.lang.ExternalGrinding}</span>';}
				   else if(r.procuredType == 9 ){return '<span class="ui-grid-tdtx">${session.lang.Other}</span>';} 
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.ProcuredCountText}',
						name:'procuredCount',
					    visible:'${session.gridcol.procuredCount}' 
					},{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
					    visible:'${session.gridcol.unitPrice}' 
					},{
						title:'${session.lang.ProcuredPayingText}',
						name:'procuredPaying',
					    visible:'${session.gridcol.procuredPaying}' ,
						format:function(r){
						//0是1否9其他
						if(r.procuredPaying == 0 ){return '<span class="ui-grid-tdtx">${session.lang.IsText}</span>';}
				   else if(r.procuredPaying == 1 ){return '<span class="ui-grid-tdtx">${session.lang.NoText}</span>';}
				   else if(r.procuredPaying == 9 ){return '<span class="ui-grid-tdtx">${session.lang.Other}</span>';} 
				   return '<span class="ui-grid-tdtx"></span>';
                        }
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
					ProcuredUser:$(procuredForm.ProcuredUser).val(),           //采购者
					//时间段开始时间 
					DateStar:$(procuredForm.dstar).val(),
					//时间段结束时间
					DateEnd:$(procuredForm.dend).val()
				}
				$('#list').grid('url','B07S006.action');                       //跳转到action               
				$('#list').grid('data',param);
				$('#list').grid('load',1);                                     //加载页面                    
				return false;
			}	
			
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${session.lang.b07s006pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="procuredForm" name="procuredForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ProcuredUserText}
							</th>
							<td>
								<input name="ProcuredUser" type="text" class="u-ipt" maxlength="16">
							</td>
							<th width="150">
								${sessionScope.lang.TimeText}
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								--
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
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