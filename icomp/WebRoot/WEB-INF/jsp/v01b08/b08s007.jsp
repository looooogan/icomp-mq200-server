<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
						title:'${session.lang.EquipmentNameText}',
						name:'equipmentName',
						visible:'${session.gridcol.equipmentName}'
					},{
						title:'${session.lang.EquipmentCodeText}',
						name:'equipmentCode',
						visible:'${session.gridcol.equipmentCode}'
					}<%--,{--%>
						<%--title:'${session.lang.LanguageText}',--%>
						<%--name:'languageName',--%>
						<%--visible:'${session.gridcol.languageName}'--%>
					<%--}--%>,{
						title:'${session.lang.EquipmentTypeText}',
						name:'equipmentTypeName',
						visible:'${session.gridcol.equipmentType}'
						},{
						title:'${session.lang.RFIDBindTypeText}',
						name:'rfidContainerID',
						visible:'${session.gridcol.rfidContainerID}',
						format:function(r){
							if(r.rfidContainerID ==null||r.rfidContainerID ==""){
								return '<span class="ui-grid-tdtx">${session.lang.RFIDBindTypeNoText}</span>';
						}else{
								return '<span class="ui-grid-tdtx">${session.lang.RFIDBindTypeYseText}</span>';
							}
						}
					},{
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
				
				$("#DIVEquipmentType").change(function(){
					checkType("change",$(this).val());
				});
			});
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.equipmentID,r.equipmentType,r.version,this)}));

				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.equipmentID,r.equipmentType,r.version,r.updateTime,r.updateUser,this)}}));

				if(r.rfidContainerID !=null&&r.rfidContainerID !=""&&r.equipmentType!="3"&&r.delFlag == 0) {
					<%--ary_li.push($('<li><a href="javascript:void(0)">${session.lang.UnbundText}</a></li>').click(function(){unbund(r.equipmentID,r.equipmentType,r.version,r.updateTime,r.updateUser,this)}));--%>
				}
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
			
		   /**
			* 查询处理
			*/
			function search(){
               
				var param = {
					opt:'list',
					EquipmentID:$(equipmentForm.EquipmentID).val(),            //设备ID
				}
				$('#list').grid('url','B08S007.action');                       //跳转到action               
				$('#list').grid('data',param);
				$('#list').grid('load',1);                                     //加载页面                    
				return false;
			}	
			
			/**
			* 编辑处理
			*/
			function edit(id,type,version,obj){
				var param = {
					EquipmentID:id,              //设备ID
					EquipmentType:type,              //设备ID
					opt:'edit',                //编辑
					version:version            //版本号
				}
				$.ajax({
					url:"equipmentInfo.action",  //跳转到ACTION的取得待处理工序信息方法
					type: "post",              
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_equipment(d,id,obj);  //调用添加工序方法
						}
					}
				});
			}
			 /**
			* 解绑处理
			*/
			function unbund(id,type,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserUnbundlInfo}',function(){
				    var param = {
					    opt:'unbund',   
						equipmentID:id,    //设备ID
						EquipmentType:type,
						version:version,   //版本号
						updatetime:time,   //更新时间
						updateuser:user    //更新者
					}
					$.ajax({
						url:"B08S007.action",     //跳转到action的删除方法
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status >= 0){
								$('#list').grid('load'); //页面加载
							}
							artDialog(d.message,"OK");   //打印message
						}
					});
				});
			}
			function del(id,type,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				    var param = {
					equipmentID:id,    //设备ID
					EquipmentType:type,
					version:version,   //版本号
					updatetime:time,   //更新时间
					updateuser:user    //更新者
					}
					$.ajax({
						url:"equipmentDelete.action",     //跳转到action的删除方法
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status >= 0){
								$('#list').grid('load'); //页面加载
							}
							artDialog(d.message,"OK");   //打印message
						}
					});
				});
			}
			/**event:edit、new、change
			**/
			function checkType(event,toolType){
			if(event=="change"){
				if($("#equipmentEditTable tr:last td").length>1){
					$("#equipmentEditTable tr:last th:last").remove();
					$("#equipmentEditTable tr:last td:last").remove();
				}
				if(toolType=="3"){
					var $td=$("#Base_DIVEquipmentType tr:last td:last").clone();
					var $th=$("#Base_DIVEquipmentType tr:last th:last").clone();
					$("#equipmentEditTable tr:last").append($th).append($td);
					$("#equipmentEditTable tr:last td:last select").attr("name","DIVRmEquipmentType");
				}
			}else if(event=="new"){
				if($("#equipmentEditTable tr:last td").length<2){
					var $td=$("#Base_DIVEquipmentType tr:last td:last").clone();
					var $th=$("#Base_DIVEquipmentType tr:last th:last").clone();
					$("#equipmentEditTable tr:last").append($th).append($td);
					$("#equipmentEditTable tr:last td:last select").attr("name","DIVRmEquipmentType");
				}
				$("#equipmentEditTable select[name=DIVEquipmentType] option").remove();
				$("#BaseRMEquipmentTypeList option").each(function(){
						var $op=$(this).clone();
						$("#equipmentEditTable").find("select[name=DIVEquipmentType]").append($op);
				});
			}else if(event=="edit"){
				if($("#equipmentEditTable tr:last td").length>1){
						$("#equipmentEditTable tr:last th:last").remove();
						$("#equipmentEditTable tr:last td:last").remove();
				}
				if(toolType=="3"||toolType=="4"){
					var $td=$("#Base_DIVEquipmentType tr:last td:last").clone();
					var $th=$("#Base_DIVEquipmentType tr:last th:last").clone();
					$("#equipmentEditTable tr:last").append($th).append($td);
					$("#equipmentEditTable tr:last td:last select").attr("name","DIVRmEquipmentType");
					$("#DIVEquipmentType option").remove();
					$("#BaseRMEquipmentTypeList option").each(function(){
						if($(this).val()=="3"||$(this).val()=="4"){
							var $op=$(this).clone();
							$("#DIVEquipmentType").append($op);
						}
					});
				}else if(toolType=="0"||toolType=="1"||toolType=="2"){
					if($("#equipmentEditTable tr:last td").length>1){
						$("#equipmentEditTable tr:last th:last").remove();
						$("#equipmentEditTable tr:last td:last").remove();
					}
					$("#DIVEquipmentType option").remove();
					$("#BaseRMEquipmentTypeList option").each(function(){
						if($(this).val()=="0"||$(this).val()=="1"||$(this).val()=="2"){
							var $op=$(this).clone();
							$("#DIVEquipmentType").append($op);
						}
					});
				}
			}
			}
			//添加设备
			function wd_equipment(data,id,obj){
				$('#equipmentEditForm').form('reset');
				var title = '${session.lang.equipmentAddTitle}';
				$('#equipmentEditForm :input').removeClass('u-ipt-err');
				$('#equipmentEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
	    	
				if(typeof(data) == 'object'){
				     $(equipmentEditForm.opt).val('edit');
					// 页面赋值
					$(equipmentEditForm.DivEquipmentID).val(id);
					$(equipmentEditForm.DIVLanguageCode).val(data.data.languageCode);//语言
					$(equipmentEditForm.DIVEquipmentCode).val(data.data.equipmentCode);
					$(equipmentEditForm.DIVEquipmentName).val(data.data.equipmentName);
					$(equipmentEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(equipmentEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(equipmentEditForm.DivVersion).val(data.data.version);//版本号
					$(equipmentEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					checkType("edit",data.data.equipmentType);
					if(data.data.equipmentType=="4"){
					$(equipmentEditForm.DIVEquipmentType).val("3");//设备类型
					}else{
					$(equipmentEditForm.DIVEquipmentType).val(data.data.equipmentType);//设备类型
					}
					$(equipmentEditForm.DIVRmEquipmentType).val(data.data.equipmentType);//设备类型
					if(data.data.rfidContainerID ==null||data.data.rfidContainerID ==""){
						$("input[name='RfidbindTiype'][value='0']").attr("checked",true);
						$("input[name='RfidbindTiype'][value='1']").attr("class","f-dn");
						$("#RfidbindTiype_One_text").attr("class","f-dn");
					}else{
						$("input[name='RfidbindTiype'][value='1']").attr("class","");
						$("#RfidbindTiype_One_text").attr("class","");
						$("input[name='RfidbindTiype'][value='1']").attr("checked",true);
					}
					$('input[name="RfidbindTiype"]').attr('disabled',false);//版本号
					$('#equipmentEditForm').attr('action','equipmentEdit.action');
					title = '${session.lang.equipmentEdittitle}';
				}else{
				    //新建
				    $(equipmentEditForm.DivVersion).val(0);//版本号
				    $('input[name="RfidbindTiype"]').attr('disabled',true);//版本号
				    checkType("new","3");
				    $('#equipmentEditForm').attr('action','equipmentAdd.action');
				}
				$.dialog({
					id:'equipmentEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('equipmentEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
                        callback:function(){
							$('#equipmentEditForm').form('submit',{
								success:function(d){
								    $('#equipmentEditForm :input').removeClass('u-ipt-err');
									$('#equipmentEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
						    	  if($.parseJSON(d).status >= 0){
										   var param = {
												opt:'list',
					                            EquipmentID:$(equipmentForm.EquipmentID).val(),            //设备ID
											}
											$('#list').grid('url','B08S007.action');
											$('#list').grid('data',param);
											if($(equipmentEditForm.opt).val()!='edit'){
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
											artDialog($.parseJSON(d).message,"OK");
											$.dialog.list['equipmentEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										 artDialog(setContorllBackColor($('#equipmentEditForm'),$.parseJSON(d).message),"OK");
										}
									}
								});
								return false;
							}
						}]
					});
					return false;
				}
				
									
         </script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b08s007pageTitle}</span>
				<%@ include file="../head_div.jsp"%>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="equipmentForm" name="equipmentForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.EquipmentNameText}
							</th>
							<td>
								<input name="EquipmentID" type="text" class="u-ipt"
									maxlength="36">
							</td>

						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2"
							onclick="return wd_equipment()">
							${sessionScope.lang.submitAddText}
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
		<div id="equipmentEdit" class="f-dn">
			<form id="equipmentEditForm" name="equipmentEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add" />
				<input type="text" class="f-dn" name="DivEquipmentID" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DIVDelFlag"  value="0"/>
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<table class="m-frmtb" width="100%" id="equipmentEditTable">
					<tr>
						<th width="150">
							${sessionScope.lang.EquipmentNameText}
						</th>
						<td>
							<input name="DIVEquipmentName" type="text" class="u-ipt"
								maxlength="36">
						</td>
						<th width="150">
							${sessionScope.lang.EquipmentCodeText}
						</th>
						<td>
							<input name="DIVEquipmentCode" type="text" class="u-ipt"
								maxlength="36">
						</td>
					</tr>
					<%--<tr>--%>
						<%--<th width="150">--%>
							<%--${sessionScope.lang.LanguageText}--%>
						<%--</th>--%>
						<%--<td>--%>
							<%--<select class="u-sel" name="DIVLanguageCode">--%>
								<%--<option value="">--%>
									<%----${sessionScope.lang.PleaseSelect}----%>
								<%--</option>--%>
								<%--<s:iterator value="#request.LanguageCodeList" id="languagetable">--%>
									<%--<option value="${languagetable.languageCode}">--%>
										<%--${languagetable.languageName}--%>
									<%--</option>--%>
								<%--</s:iterator>--%>
							<%--</select>--%>
						<%--</td>--%>
					<%--</tr>--%>
					<tr>
						<th width="150">
							${sessionScope.lang.EquipmentTypeText}
						</th>
						<td>
							<select class="u-sel" name="DIVEquipmentType" id="DIVEquipmentType">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
							</select>
						</td>
					<th>
					刃磨设备类型
					</th>
					<td>
						<select class="u-sel" 
							name="DIVRmEquipmentType">
							<option value="3">
								钻头
							</option>
							<option value="4">
								刀片
							</option>
						</select>
					</td>
					</tr>
				</table>
			</form>
		</div>
		<div class="f-dn" ID="Base_DIVEquipmentType">
			<select class="u-sel" id="BaseRMEquipmentTypeList"
				name="Base_DIVEquipmentType">
				<option value="3">
					刃磨设备
				</option>
				<s:iterator value="#request.EquipmentTypeList"
					id="equipmentTypeList">
					<option value="${equipmentTypeList.comListValue}">
						${equipmentTypeList.comListText}
					</option>
				</s:iterator>
			</select>
			<table>
				<tr>
					<th>刃磨设备类型
					</th>
					<td>
						<select class="u-sel" 
							name="Base_DIVRmEquipmentType">
							<option value="3">
								钻头
							</option>
							<option value="4">
								刀片
							</option>
						</select>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>


