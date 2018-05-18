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
						title:'${session.lang.LanguageText}',
						name:'languageName',
						visible:'${session.gridcol.languageName}'
					},{
						title:'${session.lang.SystemLogMsgText}',
						name:'systemLogMsg',
						width:'50%',
						visible:'${session.gridcol.systemLogMsg}'
					},{
						title:'${session.lang.SystemLogFlagText}',
						name:'systemLogFlag',
						visible:'${session.gridcol.systemLogFlag}',
						format:function(r){
						//日志分类:0手持机1智能管理平台2系统日志
						if(r.systemLogFlag == 0 ){return '<span class="ui-grid-tdtx">${session.lang.HandSetText}</span>';}
				   else if(r.systemLogFlag == 1 ){return '<span class="ui-grid-tdtx">${session.lang.IntelligentManagementPlatform}</span>';}
				   else if(r.systemLogFlag == 2 ){return '<span class="ui-grid-tdtx">${session.lang.SystemLog}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.SystemLogLevelText}',
						name:'systemLogLevel',
						visible:'${session.gridcol.systemLogLevel}',
						format:function(r){
						//日志级别:0正常1警告2错误9其他
						if(r.systemLogLevel == 0 ){return '<span class="ui-grid-tdtx">${session.lang.Normal}</span>';}
				   else if(r.systemLogLevel == 1 ){return '<span class="ui-grid-tdtx">${session.lang.Warning}</span>';}
				   else if(r.systemLogLevel == 2 ){return '<span class="ui-grid-tdtx">${session.lang.Error}</span>';}
				   else if(r.systemLogLevel == 9 ){return '<span class="ui-grid-tdtx">${session.lang.Other}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.SystemLogDateText}',
						name:'systemLogDate',
						visible:'${session.gridcol.systemLogDate}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.systemLogDate)+'</span>';
                        }
					},{
						title:'${session.lang.SystemLogUserText}',
						name:'systemLogUser',
						visible:'${session.gridcol.systemLogUser}'
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
					SystemLogUser:$(systemlogForm.SystemLogUser).val(),
					DateStar:$(systemlogForm.dstar).val(),
					DateEnd:$(systemlogForm.dend).val(),
				}
				$('#list').grid('url','B10S002.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}



    
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${session.lang.b10s002pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="systemlogForm" name="systemlogForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.SystemLogUserText}
							</th>
							<td>
								<input name="SystemLogUser" type="text" class="u-ipt" maxlength="16">
							</td>
							<th width="150">
								${sessionScope.lang.SystemLogDateText}
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">
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

