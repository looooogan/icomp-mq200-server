<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="org.apache.taglibs.standard.tag.common.core.ForEachSupport"%>
<%@page import="com.icomp.entity.base.Toolalarmparam"%>
<%@page import="com.sun.corba.se.impl.util.Version"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
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
			});
			
			function wd_language(){
				// 页面赋值
				$('#ToolAlarmForm').form('submit',{
					success:function(d){
						if($.parseJSON(d).status >= 0){
						//插入成功
							artDialog($.parseJSON(d).message,"OK");
							$('#list').grid('load');
							$.dialog.list['languageEdit_dialog'].close();
						} else if($.parseJSON(d).status == -1){
							artDialog(d.message,"OK");
						}else {	
							  artDialog(setContorllBackColor($('#displayEditForm'),$.parseJSON(d).message),"OK");
						}
						}
					});
				}
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b08s004pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
<% 
        @SuppressWarnings("unchecked")
		List<Toolalarmparam> list= (List<Toolalarmparam>)request.getAttribute("ToolAlarmList");
		String value0="";
		String value1="";
		String value2="";
		String DivVersion="";
		for(Toolalarmparam entity:list){
			if(entity.getToolAlarmType().equals("0")){
			value0=entity.getToolAlarmRatio().toString();
			DivVersion=entity.getVersion().toString();
			}
			if(entity.getToolAlarmType().equals("1")){
			value1=entity.getToolAlarmRatio().toString();
			} 
			if(entity.getToolAlarmType().equals("2")){
			value2=entity.getToolAlarmRatio().toString();
			}
		}

 %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchList}
				</div>
				<form id="ToolAlarmForm"  action="toolAlarmEdit.action" method="post">
					<input name="DivVersion" type="text" class="f-dn" value ="<%=DivVersion %>">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.TransitPlanningAlarmText}
							</th>
							<td>
								<input name="TransitPlanningAlarm" type="text" class="u-ipt" value ="<%=value1 %>" maxlength="6">
								${sessionScope.lang.DayText}
							</td>
							<th width="150">
								${sessionScope.lang.InventoryAlarmText}
							</th>
							<td>
									<input name="InventoryAlarm" type="text" class="u-ipt" value ="<%=value0 %>" maxlength="6">
								${sessionScope.lang.PercentText}
							</td>
						</tr>	
						<tr>						
							<th width="150">
								${sessionScope.lang.AbnormalAlarmText}
							</th>
							<td>
									<input name="AbnormalAlarm" type="text" class="u-ipt" value ="<%=value2%>" maxlength="6">
								${sessionScope.lang.PercentText}
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return wd_language()">${sessionScope.lang.submitSaveText}</button>
					</div>
				</form>
				<div class="f-cb"></div>
			</div>
			<div class="ui-layout-center">
				<table id="list"></table>
				<div id="bar"></div>
			</div>
		</div>
	</body>
</html>

