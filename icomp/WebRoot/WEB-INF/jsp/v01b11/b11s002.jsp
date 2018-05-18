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
					//async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.AgencyText}',
						name:'agencyName',
						visible:'${session.gridcol.agencyName}'
					},{
						title:'${session.lang.DepartmentText}',
						name:'departmentName',
						visible:'${session.gridcol.departmentName}'
					},{
						title:'${session.lang.LanguageText}',
						name:'languageName',
						visible:'${session.gridcol.languageName}'
					},{
						title:'${session.lang.DepartmentTelText}',
						name:'departmentTel',
						visible:'${session.gridcol.departmentTel}'
					},{
						title:'${session.lang.DepartmentHeadText}',
						name:'departmentHead',
						visible:'${session.gridcol.departmentHead}'
					},{
						title:'${session.lang.DepartmentHeadMobileText}',
						name:'departmentHeadMobile',
						visible:'${session.gridcol.departmentHeadMobile}'
					},{
						title:'${session.lang.HeadTelText}',
						name:'departmentHeadTel',
						visible:'${session.gridcol.departmentHeadTel}'
					},{
						title:'${session.lang.DepartmentFoundedTimeText}',
						name:'departmentCdate',
						visible:'${session.gridcol.departmentCdate}'
					},{
						title:'${session.lang.DepartmentDescriptionText}',
						name:'departmentDescription',
						visible:'${session.gridcol.departmentDescription}'
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
			});
			
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.departmentID,r.Version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.departmentDelFlag == 0){del(r.departmentID,r.departmentVersion,r.departmentUpdateTime,r.departmentUpdateUser,this)}}));
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
					AgencyID:$(departmentForm.AgencyID).val(),
					DepartmentID:$(departmentForm.DepartmentID).val(),
					DelFlag:$(departmentForm.DelFlag).val()
				}
				$('#list').grid('url','B11S002.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	
			
			/**
			* 取得机构下的部门
			*/
			function changeAgency(i,f){
				var param;
				if(i == 1){
					param = {
						AgencyID:$(departmentForm.AgencyID).val()
					}
				}else{
					param = {
						AgencyID:$(departmentEditForm.DivAgencyID).val()
					}
				}
				$.ajax({
					url:"changeAgency.action",
					type: "post",
					dataType:"json",
					data:param,
					async:'true',
					success:function(d){
						if(d.status < 0){
					     	 $(departmentForm.DepartmentID).find('option').remove();
					     	 $(departmentForm.DepartmentID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					    }else{
					     if(i == 1){//查询条件
					     	 $(departmentForm.DepartmentID).find('option').remove();
					     	 $(departmentForm.DepartmentID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					     	  $.each(d.data,function(key,val){
						  	  	 $(departmentForm.DepartmentID).append("<option value='"+val.departmentID+"'>"+val.departmentName+"</option>");
						  	  });
					     }else{//编辑DIV
					     	 $(departmentEditForm.DivDepartmentID).find('option').remove();
					     	 
					     	 $(departmentEditForm.DivDepartmentID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					     	 $.each(d.data,function(key,val){
						  	  	 $(departmentEditForm.DivDepartmentID).append("<option value='"+val.departmentID+"'>"+val.departmentName+"</option>");
						  	  });
						  	  if(f != undefined){
						  	  $(departmentEditForm.DivDepartmentID).val(f);//职务设定
						  	  }
					     }
					   }
					}
				});
			}
						
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.DepartmentDelInfo}',function(){
				    var param = {
					departmentID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"departmentDelete.action",
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
			* 编辑处理
			*/
			function edit(id,version,obj){
				var param = {
					departmentID:id,
					opt:'edit',
					version:version
				}
				$.ajax({
					url:"departmentInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_department(d,id,obj);
						}
					}
				});
			}
			function fomatDate(str){
				var DateL=str.substr(0,4)+"-"+str.substr(4,2)+"-"+str.substr(6,2);
				return DateL;
			}
			//添加部门
			function wd_department(data,id,obj){
				$("textarea[name='DIVDepartmentDescription']").parent('td').next('td').html('');
				$('#departmentEditForm').form('reset');
				var title = '${session.lang.departmentAddTitle}';
				$('#departmentEditForm :input').removeClass('u-ipt-err');
				$('#departmentEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					//编辑
					$(departmentEditForm.opt).val('edit');
					// 页面赋值
					$(departmentEditForm.DivDepartmentID).val(id);//ID
					$(departmentEditForm.DIVLanguageCode).val(data.data.agencyLanguageCode);//语言
					$(departmentEditForm.DivAgencyID).val(data.data.departmentAgencyID);//机构	
					changeAgency(2,data.data.departmentID);//部门设定		
					$(departmentEditForm.DIVDepartmentCode).val(data.data.departmentCode);//部门编码
					$(departmentEditForm.DIVDepartmentName).val(data.data.departmentName);//部门名称
					$(departmentEditForm.DIVDepartmentTel).val(data.data.departmentTel);//部门电话
					$(departmentEditForm.DIVDepartmentHead).val(data.data.departmentHead);//部门负责人
					$(departmentEditForm.DIVDepartmentHeadMobile).val(data.data.departmentHeadMobile);//部门负责人手机				
					$(departmentEditForm.DIVDepartmentHeadTel).val(data.data.departmentHeadTel);//部门负责人电话
					
					$(departmentEditForm.DIVDepartmentCdate).val(fomatDate(data.data.departmentCdate));//部门创立时间
					$(departmentEditForm.DIVDepartmentDescription).val(data.data.departmentDescription);//部门描述										
					$(departmentEditForm.DivUpdateTime).val(data.data.departmentUpdateTime);//更新时间
					$(departmentEditForm.DivVersion).val(data.data.departmentVersion);//版本号
					$(departmentEditForm.DivUpdateUser).val(data.data.departmentUpdateUser);//更新者
					$(departmentEditForm.DIVDelFlag).val(data.data.departmentDelFlag);//删除区分
					$('#departmentEditForm').attr('action','departmentEdit.action');
					title = '${session.lang.departmentEditTitle}';
					$(departmentEditForm.DIVDepartmentName).attr("disabled","");//禁用部门名
				}else{
					//新建
				    $(departmentEditForm.DIVDepartmentName).removeAttr("disabled");//启用部门名
				    $(departmentEditForm.DIVDelFlag).val(0);//删除区分-有效
				    $(departmentEditForm.DivVersion).val(0);//版本号
					$('#departmentEditForm').attr('action','departmentAdd.action');
				}
				$.dialog({
					id:'departmentEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('departmentEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#departmentEditForm').form('submit',{
								success:function(d){
								    $('#departmentEditForm :input').removeClass('u-ipt-err');
									$('#departmentEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
										   var param = {
												opt:'list',
												AgencyID:$(departmentForm.AgencyID).val(),
												DepartmentID:$(departmentForm.DepartmentID).val()
											}
											$('#list').grid('url','B11S002.action');
											$('#list').grid('data',param);
											if($(departmentEditForm.opt).val()!='edit'){
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
											artDialog($.parseJSON(d).message,"OK");
											$.dialog.list['departmentEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										    
										    artDialog(setContorllBackColor($('#departmentEditForm'),$.parseJSON(d).message),"OK");
										}
									}
								});
								return false;
							}
						}]
					});
					return false;
				}
								//验证“备注”长度
			$("textarea[name='DIVDepartmentDescription']").live('keydown',function(){
				if($(this).val().length>99){
					this.value=this.value.substr(0,99);
					$(this).parent('td').next('td').html('最多输入100字');
				}else{
					$(this).parent('td').next('td').html('');
				}
			});
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span> 当前页:首页 > 用户管理模块> 部门管理</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="departmentForm" name="departmentForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.AgencyText}
							</th>
							<td>
								<select class="u-sel" name="AgencyID" onchange="return changeAgency(1)">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.AgencyList" id="agency">
										<s:if test='%{#agency.agencyID == #request.AgencyID}'>
											<option value="${agency.agencyID}" selected>
												${agency.agencyName}
											</option>
										</s:if>
										<s:else>
											<option value="${agency.agencyID}">
												${agency.agencyName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentText}
							</th>
							<td>
								<select class="u-sel" name="DepartmentID">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.DepartmentList" id="department">
										<s:if
											test='%{#department.departmentID == #request.DepartmentID}'>
											<option value="${department.departmentID}" selected>
												${department.departmentName}
											</option>
										</s:if>
										<s:else>
											<option value="${department.departmentID}">
												${department.departmentName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.DelFlagText}
							</th>
							<td>
								<select class="u-sel" name="DelFlag">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.DelFlagList" id="comlist">
										<s:if test='%{#comlist.comListValue == #request.DelFlag}'>
											<option value="${comlist.comListValue}" selected="selected">
												${comlist.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlist.comListValue}">
												${comlist.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" onclick="return wd_department()">${sessionScope.lang.submitAddText}</button>
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
		<div id="departmentEdit" class="f-dn">
			<form id="departmentEditForm" name="departmentEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivDepartmentID"/>
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
			    <table class="m-frmtb" width="100%">
						<tr>
							<th width="150">
								${sessionScope.lang.AgencyText}
							</th>
							<td>
							    <select class="u-sel" name="DivAgencyID">
								    <option value="">--${sessionScope.lang.PleaseSelect}--</option>
								    <s:iterator value="#request.AgencyList" id="agency">
									    <option value="${agency.agencyID}">${agency.agencyName}</option>
								    </s:iterator>
							    </select>
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentText}
							</th>
							<td>
								<input name="DIVDepartmentName" type="text" class="u-ipt" maxlength="50">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.LanguageText}
							</th>
							<td>
								<select class="u-sel" name="DIVLanguageCode">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.LanguageCodeList" id="languagetable">
								   <option value="${languagetable.languageCode}">${languagetable.languageName}</option>
								</s:iterator>
							</select>
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentTelText}
							</th>
							<td>
								<input name="DIVDepartmentTel" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.DepartmentHeadText}
							</th>
							<td>
								<input name="DIVDepartmentHead" type="text" class="u-ipt" maxlength="36">
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentHeadMobileText}
							</th>
							<td>
								<input name="DIVDepartmentHeadMobile" type="text" class="u-ipt" maxlength="16">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.HeadTelText}
							</th>
							<td>
								<input name="DIVDepartmentHeadTel" type="text" class="u-ipt" maxlength="36">
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentFoundedTimeText}
							</th>
							<td>
								<input name="DIVDepartmentCdate" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
						<tr>
							<th width="150" >
								${sessionScope.lang.DepartmentDescriptionText}
							</th>
							<td colspan="2" >
								<textarea rows="1" style="width: 100%;height: 28px;"  name="DIVDepartmentDescription" ></textarea>
							</td>
							<td>
								<span></span>
							</td>
						</tr>
			    </table>
			</form>
		</div>
	</body>
</html>

