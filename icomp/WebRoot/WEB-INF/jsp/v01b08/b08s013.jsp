﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp"%>
	<script type="text/javascript">
		// 2017/08/21 宋健 追加↓↓↓　dazhong@YMSC
		var m = 0;
		var n = 0;
		var s = 0;
		var partHtml = "";
		var synthesisParametersHtml = "";
		$(document).ready(function(){
			// 零部件html
			partHtml += "<select class='u-sel' name='Parts'>";
			partHtml += "<option value=''>--${sessionScope.lang.PleaseSelect}--</option>";
			<c:forEach items="${PartsList}" var="parts">
			partHtml += '<option value="${parts.partsID}">${parts.partsName}</option>';
			</c:forEach>
			partHtml += "</select>";

			// 合成刀具html
			synthesisParametersHtml += "<select class='u-sel' name='SynthesisParameters'>";
			synthesisParametersHtml += "<option value=''>--${sessionScope.lang.PleaseSelect}--</option>";
			<c:forEach items="${SynthesisParametersList}" var="synthesisParameters">
			synthesisParametersHtml += '<option value="${synthesisParameters.synthesisParametersID}">${synthesisParameters.synthesisParametersCode}</option>';
			</c:forEach>
			synthesisParametersHtml += "</select>";

			// 设备名称(复选框)
			var eqCode = "";
			<c:forEach items="${EquipmentList}" var="list">
			eqCode += '<input type="checkbox" name="eqCode" value="${list.equipmentID}"/>' + '<font style="margin-left:3px;margin-right:3px;">'+'${list.equipmentName}'+'</font></br>';
			</c:forEach>
			$("#equip").html(eqCode);

			// 轴编号(复选框)
			var axleCode = "";
			<c:forEach items="${AxleLineList}" var="list">
			axleCode += '<input type="checkbox" name="axleCode" value="${list.axleID}"/>' + '<font style="margin-left:3px;margin-right:3px;">'+'${list.axleCode}'+'</font>';
			</c:forEach>
			$("#axle").html(axleCode);

			$("#button1").click(function () {
				s += 1;
				var html = "";
				html +=	 '<tr name="newTr">';
				html +=	 '<th width="150">${sessionScope.lang.SynthesisParametersText}</th>';
				html +=	 '<td>';
				html +=	 '<div id="SynthesisParameters'+s+'" class="selectbox" style="z-index: 10">';
				html +=  '</div>';
				html +=  '</td>';
				html +=  '<th width="150">${sessionScope.lang.ToolDurableText}</th>';
				html +=  '<td>';
				html +=  '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
				html += '<button onclick="removeTr(this)" class="aui_state_highlight" type="button" style="margin-left: 4px;padding: 3px;">移除</button>';
				html +=	 '</td>';
				html +=	 '</tr>';
				$("#table1").append(html);
				$("#SynthesisParameters"+s).append(synthesisParametersHtml);

			});

			$("#button2").click(function(){
				m += 1;
				n += 1;
				var newDiv = "newDiv" + m;
				var newTab = "newTab" + m;
				var newButton = "nb" + n;
				var html = "";
				html +=  '<div id="'+newDiv+'" name="newDiv">';
				html +=  '<table class="m-frmtb" width="100%" id="'+newTab+'">';
				html +=  '<tr>';
				html +=  '<th width="150">零部件名称</th>';
				html +=	 '<td>';
				html +=	 '<div id="s_Parts'+m+'" name="s_Parts" class="selectbox" style="z-index: 10">';
				html +=	 '</div>';
				html +=	 '</td>';
				html +=	 '<td width="150"><button  onclick="removeTable(this)" class="aui_state_highlight" type="button" style="padding: 3px;">移除零部件</button></td>';
				html +=	 '</tr>';
				html +=	 '<tr>';
				html +=	 '<th width="150">${sessionScope.lang.SynthesisParametersText}</th>';
				html +=	 '<td style="width: 190px;">';
				html +=	 '<div id="s_SynthesisParameters'+m+'" name="s_SynthesisParameters" class="selectbox" style="z-index: 10">';
				html +=  '</div>';
				html +=  '</td>';
				html +=  '<th width="150">${sessionScope.lang.ToolDurableText}</th>';
				html +=  '<td>';
				html +=  '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
				html +=  '<button id="'+newButton+'" onclick="return newAdd('+m+')" class="aui_state_highlight" type="button" style="padding: 3px;margin-left: 4px;" >添加</button>';
				html +=	 '</td>';
				html +=	 '</tr>';
				html +=  '</table>';
				$("#div1").append(html);
				$("#s_Parts"+m).append(partHtml);
				$("#s_SynthesisParameters"+m).append(synthesisParametersHtml);

			});

			$("#test").click(function(){
				var v = $("#hEdit").val();
				if(v == "edit"){
					var param = {
						DivOplinkID:$(OplinkEditForm.DivOplinkID).val(),
						DivProcess:$("select[name='DivProcess']").val(),
						DivEquipment:$(OplinkEditForm.DivEquipment).val(),
						DivAssemblyLine:$("select[name='DivAssemblyLine']").val(),
						SynthesisParameters: $("select[name='SynthesisParameters']").val(),
						Parts:$("select[name='Parts']").val(),
						DivAxle: $(OplinkEditForm.DivAxle).val(),
						DivToolDurable:$(OplinkEditForm.DivToolDurable).val()
					}
					$.ajax({
						url:"oplinkEdit.action",
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status == 0){
								$.dialog.list['OplinkEdit_dialog'].close();
								artDialog(d.message,"OK");
								$('#list').grid('load');
							}else{
								wd_oplink(d,id,obj);
							}
						}
					});
				}else{
					// 设备名称
					var eq = document.getElementsByName("eqCode");
					// 轴编号
					var axle = document.getElementsByName("axleCode");

					// 得到checkbox数组
					var eqStr = "";
					var axleStr = "";
					// 取得所选择的设备名称
					for(var i= 0;i<eq.length;i++){
						if(eq[i].checked){
							eqStr += eq[i].value + ",";
						}
					}

					// 取得所选择的轴编号
					for(var i= 0;i<axle.length;i++){
						if(axle[i].checked){
							axleStr += axle[i].value + ",";
						}
					}

					if($("select[name='DivAssemblyLine']").val()==""){
						alert("请选择生产线");
						return;
					}else if($("select[name='DivProcess']").val()==""){
						alert("请选择工序");
						return;
					}else if(eqStr == ""){
						alert("请选择设备名称");
						return;
					}else if(axleStr == ""){
						alert("请选择轴编号");
						return;
					}
					var partFlag = false;
					var synthesisParametersFlag = false;
					var toolDurableFlag = false;
					var str = "";
					var parts = "";
					$("select[name='Parts']").each(function(){
						if($(this).val() == ""){
							partFlag = true;
							$(this).attr("style","border-color:red");
						}else{
							parts += $(this).val()+",";
							$(this).removeAttr("style");
						}
					});
					$("select[name='SynthesisParameters']").each(function(){
						if($(this).val() == ""){
							synthesisParametersFlag = true;
							$(this).attr("style","border-color:red");
						}else{
							str += $(this).parent().parent().parent().parent().find(".u-sel").val() +
									";" + $(this).val() +
									";"+ $(this).parent().parent().next().next().find(".u-ipt").val() + ",";
							$(this).removeAttr("style");
						}
					});
					$("input[name='DivToolDurable']").each(function(){
						if($(this).val() == ""){
							toolDurableFlag = true;
							$(this).attr("style","border-color:red");
						}else{
							$(this).removeAttr("style");
						}
					});
					if(partFlag){
						return;
					}
					if(synthesisParametersFlag){
						return;
					}
					if(toolDurableFlag){
						return;
					}
					str = str.substr(0,str.length-1);
					parts = parts.substr(0,str.length-1);
					var param = {
						parts:parts,
						processID:$("select[name='DivProcess']").val(),
						assemblyLineID:$("select[name='DivAssemblyLine']").val(),
						equipmentID:eqStr,
						axleID:axleStr,
						str:str
					}
					$.ajax({
						url:"oplinkAdd.action",
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status == 0){
								$.dialog.list['OplinkEdit_dialog'].close();
								artDialog(d.message,"OK");
							}else{
								wd_oplink(d,id,obj);
							}
						}
					});
				}

			});
			// 2017/08/21 宋健 追加↑↑↑　dazhong@YMSC
			//绑定keyup click-工艺名称 模糊查询
			$("#s_Parts input:eq(0)").bind('keyup click',function(){
				add2ul($(this).val(),"s_Parts","DivParts",event.type);
			});
			// 绑定keyup click-设备名称  模糊查询
			$("#s_DivEquipment input:eq(0)").bind('keyup click',function(){
				add2ul($(this).val(),"s_DivEquipment","Equipment",event.type);
			});
			// 绑定keyup click-合成刀具   模糊查询
			$("#s_SynthesisParameters input:eq(0)").bind('keyup click',function(event){
				add2ul($(this).val(),"s_SynthesisParameters","DivSynthesisParameters",event.type);
			});
			/**
			 * 模糊查询
			 */
			function add2ul(input,divID,baseName,eventType){
				$("#"+divID+"").find("li").remove();
				if(eventType.indexOf("keyup")>-1){
					$("#"+divID+" input:eq(1)").val("");
				}
				$("select[name='"+baseName+"'] option").each(function(){
					if($(this).text().indexOf(input)>-1){
						$("#"+divID+" div ul").append("<li  id='"+$(this).val()+"'>"+$(this).text()+"</li>");
					}
				});
				$("#"+divID+"").jQSelect({});
			}
		});
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
					title:'流水线',
					name:'assemblyLineName',
					visible:'${session.gridcol.assemblyLineName}'
				},{
					title:'${session.lang.ProcessText}',
					name:'processName',
					visible:'${session.gridcol.processName}'
				},{
					title:'${session.lang.EquipmentText}',
					name:'equipmentName',
					visible:'${session.gridcol.equipmentName}'
				},{
					title:'${session.lang.SynthesisParametersText}',
					name:'synthesisParametersCode',
					visible:'${session.gridcol.synthesisParametersCode}'
				},{
					title:'${sessionScope.lang.ToolDurableText}',
					name:'toolDurable',
					visible:'${session.gridcol.toolDurable}'
				},{
					title:'${session.lang.PartsText}',
					name:'partsName',
					visible:'${session.gridcol.partsName}'
				},{
					title:'轴名称',
					name:'axleName',

				}, {
					title:'${session.lang.OperationText}',
					name:'',
					width:'130px',
					visible:'true',
					format:function(r,t){
						return option(r);
					}
				}],
				success:function(d){
					if(undefined== d.total){
						$("#number1").text(0);
					}else if(0== d.total){
						$("#number1").text(1);
					} else {
						$("#number1").text(d.total);
					}

					if(d.status < 0){
						artDialog(d.message,"OK");
					}
				}
			}) ;


			$("#s_DivEquipment").jQSelect({});
			$("#s_Parts").jQSelect({});
			$("#s_SynthesisParameters").jQSelect({});
		});

		/**
		 * 操作列超链接
		 */
		function option(r){
			var $ul = $('<ul class="u-option"></ul>');
			var $li = $('');
			var ary_li = new Array();
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.oplinkID,this)}));
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.oplinkID,this)}));
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}

		/**
		 * 编辑处理
		 */
		function edit(id,obj){

			var param = {
				oplinkID:id

			}
			$.ajax({
				url:"oplinkInfo.action",
				type: "post",
				dataType:"json",
				data:param,
				success:function(d){
					if(d.status < 0){
						artDialog(d.message,"OK");
					}else{
						wd_oplink(d,id,obj);
					}
				}
			});
		}


		function S_editInit(id,baseSelect,S_DivId){
			$("select[name="+baseSelect+"] option").each(function(){
				if($(this).val().indexOf(id)>-1){
					$("#"+S_DivId+" input:eq(0)").val($(this).text().trim());
				}
			});
			$("#"+S_DivId+" input:eq(1)").val(id);
		}
		//添加(编辑)关联
		function wd_oplink(data,id,obj){

			$("div[name='newDiv']").remove();
			$("tr[name='newTr']").remove();

			$('#OplinkEditForm').form('reset');
			var title = '${session.lang.AddOplinkTitle}';
			$('#OplinkEditForm :input').removeClass('u-ipt-err');
			$('#OplinkEditForm').find("*").each(function () {
				if($(this).hasClass("u-sel")){
					$(this).removeAttr("style");
				}
			});
			if(typeof(data) == 'object'){
				$(OplinkEditForm.opt).val('edit');
				// 页面赋值
				$(OplinkEditForm.DivOplinkID).val(id);//角色ID
				$(OplinkEditForm.DivAssemblyLine).val(data.data.assemblyLineID);//机构
				$(OplinkEditForm.DivProcess).val(data.data.processID);
				$(OplinkEditForm.DivSynthesisParameters).val(data.data.synthesisParametersID);
				S_editInit(data.data.partsID,'DivParts','s_Parts');
				S_editInit(data.data.equipmentID,'Equipment','s_DivEquipment');
				S_editInit(data.data.synthesisParametersID,'DivSynthesisParameters','s_SynthesisParameters');
				$(OplinkEditForm.DivEquipment).val(data.data.equipmentID);
				$("select[name='DivAxle']").val(data.data.equipmentID);
				$("select[name='Parts']").val(data.data.partsID);
				$("select[name='SynthesisParameters']").val(data.data.synthesisParametersID);
				$(OplinkEditForm.DivToolDurable).val(data.data.toolDurable);
				$('#OplinkEditForm').attr('action','oplinkEdit.action');
				$(OplinkEditForm.DivAxle).val(data.data.axleID);//机构

				title = '${session.lang.EditOplinkTitle}';

				<!-- 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC -->
				$("#equip").attr("style","display:none");
				$("#axle").attr("style","display:none");
				$("#s_DivEquipment").attr("style","display:block");
				$("#DivAxle").attr("style","display:block");
				$("#div1").attr("style","height:60px;");
				$("#button1").hide();
				$("#button2").hide();
				$("#hEdit").val("edit");
				<!-- 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC -->

			}else{
				<!-- 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC -->
				$("#equip").attr("style","display:block;width: 275px;height: 125px;overflow-y:scroll;padding: 5px;");
				$("#axle").attr("style","display:block;width: 144px;height: 125px;padding: 5px;");
				$("#s_DivEquipment").attr("style","display:none");
				$("#DivAxle").attr("style","display:none");
				$("#div1").attr("style","height: 200px;overflow-y:scroll;");
				$("#button1").show();
				$("#button2").show();
				$("#hEdit").val("add");
				<!-- 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC -->
				$(OplinkEditForm.DivVersion).val(0);//版本号
				$('#OplinkEditForm').attr('action','oplinkAdd.action');
			}
			$.dialog({
				id:'OplinkEdit_dialog',
				title:title,
				lock: true,
				content:document.getElementById('OplinkEdit'),
				<%--button:[{--%>
				<%--name:'${session.lang.submitSaveText}',--%>
				<%--focus:true,--%>
				<%--callback:function(){--%>
				<%--$('#OplinkEditForm').form('submit',{--%>
				<%--success:function(d){--%>
				<%--$('#OplinkEditForm :input').removeClass('u-ipt-err');--%>
				<%--$('#OplinkEditForm').find("*").each(function () {--%>
				<%--if($(this).hasClass("u-sel")){--%>
				<%--$(this).removeAttr("style");--%>
				<%--}--%>
				<%--});--%>
				<%--if($.parseJSON(d).status >= 0){--%>
				<%--var param = {--%>
				<%--opt:'list',--%>
				<%--AssemblyLineID:$(searchForm.AssemblyLine).val(),--%>
				<%--ProcessID:$(searchForm.Process).val(),--%>
				<%--SynthesisParametersID:$(searchForm.SynthesisParameters).val(),--%>
				<%--PartsID:$(searchForm.DivParts).val(),--%>
				<%--EquipmentID:$(searchForm.Equipment).val(),--%>
				<%--LastProcess:$(searchForm.LastProcess).val(),--%>
				<%--axleID:$(searchForm.axleID).val()--%>
				<%--}--%>
				<%--$('#list').grid('url','B08S013.action');--%>
				<%--$('#list').grid('data',param);--%>
				<%--if($(OplinkEditForm.opt).val()!='edit'){--%>
				<%--$('#list').grid('load',1);--%>
				<%--}else{--%>
				<%--$('#list').grid('load');--%>
				<%--}--%>
				<%--artDialog($.parseJSON(d).message,"OK");--%>
				<%--$.dialog.list['OplinkEdit_dialog'].close();--%>
				<%--} else if($.parseJSON(d).status == -1){--%>
				<%--artDialog(d.message,"OK");--%>
				<%--}else {--%>
				<%--artDialog(setContorllBackColor($('#OplinkEditForm'),$.parseJSON(d).message),"OK");--%>
				<%--}--%>
				<%--}--%>
				<%--});--%>
				<%--return false;--%>
				<%--}--%>
				<%--}]--%>
			});
			return false;
		}

		/**
		 * 删除处理
		 */
		function del(id,obj){
			$.dialog.confirm('${session.lang.RoleDelInfo}',function(){
				var param = {
					oplinkID:id
				}
				$.ajax({
					url:"oplinkDelete.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status >= 0){
							$('#list').grid('load');
						}
						artDialog(d.message,"OK");
					}
				});
			});
		}
		/**
		 * 查询处理
		 */
		function search(){
			var param = {
				opt:'list',
				AssemblyLineID:$(searchForm.AssemblyLine).val(),
				ProcessID:$(searchForm.Process).val(),
				SynthesisParametersID:$(searchForm.SynthesisParameters).val(),
				PartsID:$(searchForm.DivParts).val(),
				EquipmentID:$(searchForm.Equipment).val(),
				LastProcess:$(searchForm.LastProcess).val(),


			}
			$('#list').grid('url','B08S013.action');
			$('#list').grid('data',param);
			$('#list').grid('load',1);
			return false;
		}
		// 2017/08/21 宋健 追加↓↓↓　dazhong@YMSC
		function newAdd(m){
			n += 1;
			var html = "";
			html +=  '<tr>';
			html +=  '<th width="150">${sessionScope.lang.SynthesisParametersText}</th>';
			html +=	 '<td>';
			html +=	 '<div id="SynthesisParameter'+n+'" name="SynthesisParameters" class="selectbox" style="z-index: 10">';
			html +=	 '</div>';
			html +=	 '</td>';
			html +=	 '<th width="150">${sessionScope.lang.ToolDurableText}</th>';
			html +=	 '<td>';
			html +=	 '<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">';
			html += '<button onclick="removeTr(this)" class="aui_state_highlight" type="button" style="margin-left: 4px;padding: 3px;">移除</button>';
			html +=	 '</td>';
			html +=	 '</tr>';
			$("#newTab"+m).append(html);
			$("#SynthesisParameter"+n).append(synthesisParametersHtml);
		}

		function getParent (el, parentTag) {
			do {
				el = el.parentNode;
			} while (el && el.tagName !== parentTag);
			return el;
		}

		/**
		 * 移除当前Tr
		 * @param el
		 */
		function removeTr (el) {
			el = getParent(el, 'TR');
			var rowIndex = el.rowIndex;
			el = getParent(el, 'TABLE');
			el.deleteRow(rowIndex);
		}

		/**
		 * 移除当前Table
		 * @param el
		 */
		function removeTable (el) {
			el = getParent(el, 'TABLE');
			el.remove();
		}
		// 2017/08/21 宋健 追加↑↑↑　dazhong@YMSC
		//	联动
		$(function(){
			$("#procedures").val("");
			$("#Equipment").val("");

			<%--$("#productionLines").change(function(){--%>

			<%--//$("#procedures").val("");--%>
			<%--//$("#Equipment").val("");--%>

			<%--param={--%>
			<%--//					productionLineID: $("#productionLines").val(),--%>
			<%--//					procedureID: $("#procedures").val(),--%>
			<%--//					axisNumberID: $("#axisNumbers").val(),--%>
			<%--//					equipmentID: $("#Equipment").val(),--%>
			<%--}--%>

			<%--$.ajax({--%>
			<%--url: "prossAndBuss.action",--%>
			<%--type: "post",--%>
			<%--dataType: "json",--%>
			<%--data: param,--%>
			<%--success: function (d) {--%>

			<%--if (d.status < 0) {--%>
			<%--$(searchForm.Process).find('option').remove();--%>
			<%--$(searchForm.Process).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--} else {--%>

			<%--$(searchForm.Process).find('option').remove();--%>
			<%--$(searchForm.Process).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--$.each(d.data, function (key, val) {--%>
			<%--$(searchForm.Process).append("<option value='" + val.processID + "'>" + val.processName + "</option>");--%>
			<%--})--%>


			<%--}--%>
			<%--}--%>
			<%--})--%>
			<%--})--%>
		});

		$(function () {
			<%--$("#procedures").change(function () {--%>
			<%--//$("#equipments").val("");--%>

			<%--param = {--%>
			<%--//					productionLineID: $("#productionLines").val(),--%>
			<%--//					procedureID: $("#procedures").val(),--%>
			<%--//					axisNumberID: $("#axisNumbers").val(),--%>
			<%--//					equipmentID: $("#Equipment").val(),--%>
			<%--}--%>
			<%--$.ajax({--%>
			<%--url: "prossAndBuss1.action",--%>
			<%--type: "post",--%>
			<%--dataType: "json",--%>
			<%--data: param,--%>
			<%--success: function (d) {--%>

			<%--if (d.status < 0) {--%>
			<%--$(searchForm.Equipment).find('option').remove();--%>
			<%--$(searchForm.Equipment).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--} else {--%>

			<%--$(searchForm.Equipment).find('option').remove();--%>
			<%--$(searchForm.Equipment).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--$.each(d.data, function (key, val) {--%>
			<%--$(searchForm.Equipment).append("<option value='" + val.equipmentID + "'>" + val.equipmentName + "</option>");--%>
			<%--})--%>


			<%--}--%>
			<%--}--%>

			<%--});--%>


			<%--});--%>

		});
		$(function () {
			<%--$("#Equipment").change(function () {--%>
			<%--//$("#models").val("");--%>
			<%--param = {--%>
			<%--//					productionLineID: $("#productionLines").val(),--%>
			<%--//					procedureID: $("#procedures").val(),--%>
			<%--//					axisNumberID: $("#axisNumbers").val(),--%>
			<%--//					equipmentID: $("#Equipment").val(),--%>
			<%--}--%>
			<%--$.ajax({--%>
			<%--url: "prossAndBuss8.action",--%>
			<%--type: "post",--%>
			<%--dataType: "json",--%>
			<%--data: param,--%>
			<%--success: function (d) {--%>

			<%--if (d.status < 0) {--%>
			<%--$(searchForm.DivParts).find('option').remove();--%>
			<%--$(searchForm.DivParts).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--} else {--%>

			<%--$(searchForm.DivParts).find('option').remove();--%>
			<%--$(searchForm.DivParts).append("<option value=''>--" + '${sessionScope.lang.PleaseSelect}' + "--</option>");--%>
			<%--$.each(d.data, function (key, val) {--%>
			<%--$(searchForm.models).append("<option value='" + val.partsID + "'>" + val.partsName + "</option>");--%>
			<%--})--%>


			<%--}--%>
			<%--}--%>

			<%--});--%>


			<%--});--%>

		});







	</script>
</head>
<body>
<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>${sessionScope.lang.b08s013pageTitle}</span>
		<%@ include file="../head_div.jsp" %>
	</div>
</div>
<div class="ui-layout-center g-ct-bd">
	<div class="ui-layout-north">
		<div class="u-ptf">
			检索
		</div>
		<form id="searchForm" name="searchForm" method="post">
			<table width="100%" class="m-frmtb">
				<tr>
					<th width="150">
						${sessionScope.lang.AssemblyLineText}
					</th>
					<td>
						<select class="u-sel" name="AssemblyLine" id="productionLines">
							<option value="">
								--${sessionScope.lang.PleaseSelect}--
							</option>
							<s:iterator value="#request.AssemblyLineList" id="assemblyLine">
								<s:if
										test='%{#assemblyLine.assemblyLineID == #request.AssemblyLine}'>
									<option value="${assemblyLine.assemblyLineID}" selected>
											${assemblyLine.assemblyLineName}
									</option>
								</s:if>
								<s:else>
									<option value="${assemblyLine.assemblyLineID}">
											${assemblyLine.assemblyLineName}
									</option>
								</s:else>
							</s:iterator>
						</select>
					</td>
					<th width="150">
						${sessionScope.lang.ProcessText}
					</th>
					<td>
						<select class="u-sel" name="Process" id="procedures">
							<option value="">
								--${sessionScope.lang.PleaseSelect}--
							</option>
							<s:iterator value="#request.ProcessList" id="process">
								<s:if test='%{#process.processID == #request.Process}'>
									<option value="${process.processID}" selected>
											${process.processName}
									</option>
								</s:if>
								<s:else>
									<option value="${process.processID}">
											${process.processName}
									</option>
								</s:else>
							</s:iterator>
						</select>
					</td>
					<th width="150">
						${sessionScope.lang.EquipmentText}
					</th>
					<td>
						<select class="u-sel" name="Equipment" id="Equipment">
							<option value="">
								--${sessionScope.lang.PleaseSelect}--
							</option>
							<s:iterator value="#request.EquipmentList" id="equipment">
								<s:if test='%{#equipment.equipmentID == #request.Equipment}'>
									<option value="${equipment.equipmentID}" selected>
											${equipment.equipmentName}
									</option>
								</s:if>
								<s:else>
									<option value="${equipment.equipmentID}">
											${equipment.equipmentName}
									</option>
								</s:else>
							</s:iterator>
						</select>
					</td>
				</tr>
				<tr>
					<th width="150">
						${sessionScope.lang.PartsText}
					</th>
					<td>
						<select class="u-sel" name="DivParts" id="models">
							<option value="">--${sessionScope.lang.PleaseSelect}--</option>
							<s:iterator value="#request.PartsList" id="parts">
								<option value="${parts.partsID}">${parts.partsName}</option>
							</s:iterator>
						</select>
					</td>
					<th width="150">
						${sessionScope.lang.SynthesisParametersText}
					</th>
					<td>
						<input name="SynthesisParameters" type="text" class="u-ipt" maxlength="50">
					</td>

				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="submit" class="u-btn2" onclick="return search()">
					${sessionScope.lang.submitSearchText}
				</button>
				<%--<button type="button" class="u-btn2" onclick="return wd_oplink()">--%>
				<%--${sessionScope.lang.submitAddText}--%>
				<%--</button>--%>
				<button type="button" class="u-btn2" onclick="return wd_oplink()">
					新建
				</button>
			</div>
		</form>
		<div class="f-cb"></div>

		<div class="u-ptt">
			<div style="float:left;">${sessionScope.lang.searchList}</div>
			<div style="float:right;">
				共：<span id="number1"></span> &nbsp;条
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	<div class="ui-layout-center">
		<table id="list"></table>
		<div id="bar"></div>
	</div>
</div>
<%--编辑--%>
<div id="OplinkEdit" class="f-dn">
	<form id="OplinkEditForm" name="OplinkEditForm" method="post">
		<input type="text" class="f-dn" name="opt" value="add"/>
		<input type="hidden" id="hEdit"/>
		<input type="text" class="f-dn" name="DivOplinkID" />
		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					生产线名称
				</th>
				<td>

					<select class="u-sel" name="DivAssemblyLine">
						<option value="">
							--${sessionScope.lang.PleaseSelect}--
						</option>
						<s:iterator value="#request.AssemblyLineList" id="assemblyLine">
							<option value="${assemblyLine.assemblyLineID}">
									${assemblyLine.assemblyLineName}
							</option>
						</s:iterator>
					</select>
				</td>
				<th width="150">
					${sessionScope.lang.ProcessText}
				</th>
				<td>
					<select class="u-sel" name="DivProcess">
						<option value="">
							--${sessionScope.lang.PleaseSelect}--
						</option>
						<s:iterator value="#request.ProcessList" id="process">
							<option value="${process.processID}">
									${process.processName}
							</option>
						</s:iterator>
					</select>
				</td>
			</tr>
			<tr>
				<th width="150" id="eqTd">
					${sessionScope.lang.EquipmentText}
				</th>
				<td>
					<div id="s_DivEquipment" style='display: none;'>
						<select class="u-sel" name="DivEquipment"  >
							<option value="">
								--请选择--
							</option>
							<s:iterator value="#request.EquipmentList" id="equi">
								<option value="${equi.equipmentID}">
										${equi.equipmentName}
								</option>
							</s:iterator>
						</select>
					</div>
					<input type="hidden" name="DivEquipments"  class="listVal" />
					<!-- 2017/07/03 宋健 变更↓↓↓　dazhong@YMSC -->
					<div id="equip" style="width: 275px;height: 125px;overflow-y:scroll;padding: 5px;"></div>
					<!-- 2017/07/03 宋健 变更↑↑↑　dazhong@YMSC -->
				</td>
				<th width="150" id="axTd">
					轴编号
				</th>
				<td>
					<div id="DivAxle" style='display: none;'>
						<select class="u-sel" name="DivAxle"  >
							<option value="">
								--请选择--
							</option>
							<s:iterator value="#request.AxleLineList" id="axle">
								<option value="${axle.axleID}">
										${axle.axleCode}
								</option>
							</s:iterator>
						</select>
					</div>
					<input type="hidden" name="DivAxles"  class="listVal" />
					<!-- 2017/07/03 宋健 变更↓↓↓　dazhong@YMSC -->
					<div id="axle" style="width: 144px;height: 125px;padding: 5px;"></div>
					<!-- 2017/07/03 宋健 变更↑↑↑　dazhong@YMSC -->
				</td>
			</tr>
		</table>
		<div>
			<button id="button2" class="aui_state_highlight" type="button" style="padding: 3px;">添加零部件</button>
		</div>
		<div style="height: 200px;overflow-y:scroll;" id="div1">
			<table class="m-frmtb" width="100%" id="table1">
				<tr>
					<th width="150">
						零部件名称
					</th>
					<td>
						<div id="s_Parts" name="s_Parts" class="selectbox" style='z-index: 10'>
							<select class="u-sel" name="Parts">
								<option value="">--${sessionScope.lang.PleaseSelect}--</option>
								<s:iterator value="#request.PartsList" id="parts">
									<option value="${parts.partsID}">${parts.partsName}</option>
								</s:iterator>
							</select>
						</div>
					</td>
				</tr>
				<tr>
					<th width="150">
						${sessionScope.lang.SynthesisParametersText}
					</th>
					<td>
						<div id="s_SynthesisParameters" class="selectbox" style='z-index: 10'>
							<select class="u-sel" name="SynthesisParameters">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.SynthesisParametersList"
											id="synthesisParameters">
									<option value="${synthesisParameters.synthesisParametersID}">
											${synthesisParameters.synthesisParametersCode}
									</option>
								</s:iterator>
							</select>
						</div>
					</td>
					<th width="150">
						${sessionScope.lang.ToolDurableText}
					</th>
					<td>
						<input name="DivToolDurable" type="text" class="u-ipt" maxlength="11">
						<button id="button1" class="aui_state_highlight" type="button" style="padding: 3px;">添加</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<div class="aui_buttons">
		<button id="test" class="aui_state_highlight">保存</button>
	</div>
</div>
<div id="base" style="display: none;">
	<select class="u-sel" name="DivSynthesisParameters">
		<option value="">
			--${sessionScope.lang.PleaseSelect}--
		</option>
		<s:iterator value="#request.SynthesisParametersList"
					id="synthesisParameters">
			<option value="${synthesisParameters.synthesisParametersID}">
					${synthesisParameters.synthesisParametersCode}
			</option>
		</s:iterator>
	</select>
</div>
</body>
</html>

