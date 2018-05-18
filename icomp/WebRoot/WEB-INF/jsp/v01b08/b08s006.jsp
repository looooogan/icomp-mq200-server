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
					roll:7,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.HandSetCodeText}',
						name:'handSetCode',
						visible:'${session.gridcol.handSetCode}'
					},{
						title:'${session.lang.HandSetNameText}',
						name:'handSetName',
						visible:'${session.gridcol.handSetName}'
					},{
						title:'${session.lang.DepartmentText}',
						name:'departmentName',
						visible:'${session.gridcol.departmentName}'
					},{
						title:'${session.lang.HandSetStautsText}',
						name:'handSetStauts',
						visible:'${session.gridcol.handSetStauts}',
						format:function(r){
						//手持机状态：0停用1启用
						if(r.handSetStauts == 0 ){return '<span class="ui-grid-tdtx">${session.lang.DisableText}</span>';}
				   else if(r.handSetStauts == 1 ){return '<span class="ui-grid-tdtx">${session.lang.EnableText}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.IsRegistrationText}',
						name:'isRegistration',
						visible:'${session.gridcol.isRegistration}',
						format:function(r){
						//是否注册：0注册1未注册
						if(r.isRegistration == 0 ){return '<span class="ui-grid-tdtx">${session.lang.RegistrationText}</span>';}
				   else if(r.isRegistration == 1 ){return '<span class="ui-grid-tdtx">${session.lang.NotRegisteredText}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${session.lang.LoginStautsText}',
						name:'loginStauts',
						visible:'${session.gridcol.loginStauts}',
						format:function(r){
						//手持机状态：0登陆1未登录
						if(r.loginStauts == 0 ){return '<span class="ui-grid-tdtx">${session.lang.LoginText}</span>';}
					   	else if(r.loginStauts == 1 ){return '<span class="ui-grid-tdtx">${session.lang.NotLoggedInText}</span>';}
					   	return '<span class="ui-grid-tdtx"></span>';
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
			});
			
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.handSetID,r.version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.handSetID,r.version,r.updateTime,r.updateUser,this)}}));
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
					HandSetCode:$(handSetForm.HandSetCode).val(),
					HandSetName:$(handSetForm.HandSetName).val(),
				}
				$('#list').grid('url','B08S006.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	

			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				    var param = {
					handSetID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"handSetDelete.action",
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
					handSetID:id,              //手持机ID
					opt:'edit',                //编辑
					version:version            //版本号
				}
				$.ajax({
					url:"handSetInfo.action",  //跳转到取得待处理手持机信息的ACTION
					type: "post",              
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_handSet(d,id,obj);  //调用添加手持机方法
						}
					}
				});
			}
			
			//添加手持机
			function wd_handSet(data,id,obj){
				$('#handSetEditForm').form('reset');
				var title = '${session.lang.handSetAddText}';
				$('#handSetEditForm :input').removeClass('u-ipt-err');
				$('#handSetEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
	    	
				if(typeof(data) == 'object'){
				    $(handSetEditForm.opt).val('edit');
					
					// 页面赋值
					$(handSetEditForm.DivHandSetID).val(id);                            //handSetID
					$(handSetEditForm.DIVDepartment).val(data.data.departmentID);       //部门ID
					$(handSetEditForm.DIVHandSetCode).val(data.data.handSetCode);       //手持机编码
					$(handSetEditForm.DIVHandSetName).val(data.data.handSetName);       //手持机名称
					$(handSetEditForm.DIVHandSetStauts).val(data.data.handSetStauts);   //手持机状态
					$(handSetEditForm.DIVIsRegistration).val(data.data.isRegistration); //是否注册
					$(handSetEditForm.DIVLoginStauts).val(data.data.loginStauts);       //登录状态
					$(handSetEditForm.DivUpdateTime).val(data.data.updateTime);         //更新时间
					$(handSetEditForm.DivVersion).val(data.data.version);               //版本号
					$(handSetEditForm.DivUpdateUser).val(data.data.updateUser);         //更新者
					$(handSetEditForm.DIVDelFlag).val(data.data.delFlag);               //删除区分
					$('#handSetEditForm').attr('action','handSetEdit.action');
					title = '${session.lang.handSetEditText}';
					$(handSetEditForm.DIVHandSetCode).attr("disabled","");//禁用手持机编码
				}else{
				    //新建
				    $(handSetEditForm.DIVHandSetCode).removeAttr("disabled");//启用手持机编码
				    $(handSetEditForm.DivVersion).val(0);//版本号
				    $('#handSetEditForm').attr('action','handSetAdd.action');
				}
				$.dialog({
					id:'handSetEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('handSetEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
                        callback:function(){
							$('#handSetEditForm').form('submit',{
								success:function(d){
								    $('#handSetEditForm :input').removeClass('u-ipt-err');
									$('#handSetEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									      //插入成功
										  artDialog($.parseJSON(d).message,"OK");
										  //加载页面
										  $('#list').grid('load');
										  //关闭	DIV
										  $.dialog.list['handSetEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#handSetEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b08s006pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="handSetForm" name="handSetForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.HandSetCodeText}
							</th>
							<td>
								<input name="HandSetCode" type="text" class="u-ipt" maxlength="36">
							</td>
							<th width="150">
								${session.lang.HandSetNameText}
							</th>
							<td>
								<input name="HandSetName" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2" onclick="return wd_handSet()">
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
		<div id="handSetEdit" class="f-dn">
			<form id="handSetEditForm" name="handSetEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add" />
				<input type="text" class="f-dn" name="DivHandSetID" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DIVDelFlag" value="0" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th width="150">
							${sessionScope.lang.DepartmentText}
						</th>
						<td>
							<select class="u-sel" name="DIVDepartment" >
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.VdepartmentList" id="Vdepartment">
									<option value="${Vdepartment.departmentID}" selected>
										${Vdepartment.departmentName}
									</option>
								</s:iterator>
							</select>
						</td>
						<th width="150">
							${sessionScope.lang.HandSetCodeText}
						</th>
						<td>
							<input name="DIVHandSetCode" type="text" class="u-ipt" maxlength="36"> 
						</td>
						</tr>
					<tr>
					    <th width="150">
							${sessionScope.lang.HandSetNameText}
						</th>
						<td>
							<input name="DIVHandSetName" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							${sessionScope.lang.HandSetStautsText}
						</th>
						<td>
							<select class="u-sel" name="DIVHandSetStauts">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.HandSetStautsList" id="comlist">
									<s:if test='%{#comlist.comListValue == #request.HandSetStauts}'>
										<option value="${comlist.comListValue}" selected>
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
					<tr>
					    <th width="150">
							${sessionScope.lang.IsRegistrationText}
						</th>
						<td>
							<select class="u-sel" name="DIVIsRegistration">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.IsRegistrationList" id="comlist">
									<s:if
										test='%{#comlist.comListValue == #request.IsRegistration}'>
										<option value="${comlist.comListValue}" selected>
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
						<th width="150">
							${sessionScope.lang.LoginStautsText}
						</th>
						<td>
							<select class="u-sel" name="DIVLoginStauts">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.LoginStautsList" id="comlist">
									<s:if test='%{#comlist.comListValue == #requestLoginStauts}'>
										<option value="${comlist.comListValue}" selected>
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
			</form>
		</div>
	</body>
</html>

