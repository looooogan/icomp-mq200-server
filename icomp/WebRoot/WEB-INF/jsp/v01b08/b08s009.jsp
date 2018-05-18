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
						title:'${session.lang.PartsText}',
						name:'partsName',
						visible:'${session.gridcol.partsName}'
					},{
						title:'${session.lang.PartsCodeText}',
						name:'partsCode',
						visible:'${session.gridcol.partsCode}'
					},{
						title:'${session.lang.LanguageText}',
						name:'languageName',
						visible:'${session.gridcol.languageName}'
					},{
						title:'${session.lang.DelFlagText}',
						name:'delFlag',
						visible:'${session.gridcol.delFlag}',
						format:function(r){
						return '<span class="ui-grid-tdtx">'+(r.delFlag == '0'?'${session.lang.DataDelNo}':'${session.lang.DataDelYes}')+'</span>';
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.partsID,r.version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.partsID,r.version,r.updateTime,r.updateUser,this)}}));
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
					PartsName:$(partsForm.PartsName).val(),
				}
				$('#list').grid('url','B08S009.action');
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
					partsID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"partsDelete.action",
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
					partsID:id,                //零部件ID
					opt:'edit',                //编辑
					version:version            //版本号
				}
				$.ajax({
					url:"partsInfo.action",    //跳转到取得待处理零部件信息的ACTION
					type: "post",              
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_parts(d,id,obj);    //调用添加零部件方法
						}
					}
				});
			}
			
			//添加零部件
			function wd_parts(data,id,obj){
				$('#partsEditForm').form('reset');
				var title = '${session.lang.partsAddTitle}';
				$('#partsEditForm :input').removeClass('u-ipt-err');
				$('#partsEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
	    	
				if(typeof(data) == 'object'){
				    $(partsEditForm.opt).val('edit');
					
					// 页面赋值
					$(partsEditForm.DivPartsID).val(id);                              //partsID
				    $(partsEditForm.DIVLanguageCode).val(data.data.languageCode);     //语言编码
					$(partsEditForm.DIVPartsCode).val(data.data.partsCode);           //零部件编码
					$(partsEditForm.DIVPartsName).val(data.data.partsName);           //零部件名称
					$(partsEditForm.DivUpdateTime).val(data.data.updateTime);         //更新时间
					$(partsEditForm.DivVersion).val(data.data.version);               //版本号
					$(partsEditForm.DivUpdateUser).val(data.data.updateUser);         //更新者
					$(partsEditForm.DIVDelFlag).val(data.data.delFlag);               //删除区分
					$('#partsEditForm').attr('action','partsEdit.action');
					title = '${session.lang.partsEditTitle}';
				}else{
				    $(partsEditForm.DivVersion).val(0);//版本号
				    $(partsEditForm.DIVDelFlag).val(0);//删除区分
				    $('#partsEditForm').attr('action','partsAdd.action');
				}
				$.dialog({
					id:'partsEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('partsEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
                        callback:function(){
							$('#partsEditForm').form('submit',{
								success:function(d){
								    $('#partsEditForm :input').removeClass('u-ipt-err');
									$('#partsEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
										var param = {
											opt:'list',
											PartsName:$(partsForm.PartsName).val(),
										}
										$('#list').grid('url','B08S009.action');
										$('#list').grid('data',param);
										if($(partsEditForm.opt).val()!='edit'){
											$('#list').grid('load',1);
										}else{
											$('#list').grid('load');
										}
									      //成功
										  artDialog($.parseJSON(d).message,"OK");
										  //关闭	DIV
										  $.dialog.list['partsEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#partsEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b08s009pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="partsForm" name="partsForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.PartsText}
							</th>
							<td>
								<input name="PartsName" type="text" class="u-ipt" maxlength="50">
							</td>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2" onclick="return wd_parts()">
							${sessionScope.lang.submitAddText}
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
		<div id="partsEdit" class="f-dn">
			<form id="partsEditForm" name="partsEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add" />
				<input type="text" class="f-dn" name="DivPartsID" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th width="150">
							${sessionScope.lang.PartsText}
						</th>
						<td>
							<input name="DIVPartsName" type="text" class="u-ipt" maxlength="50">
						</td>
						<th width="150">
							${sessionScope.lang.PartsCodeText}
						</th>
						<td>
							<input name="DIVPartsCode" type="text" class="u-ipt" maxlength="50">
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
									<s:if
										test='%{#languagetable.languageCode == #request.DIVLanguageCode}'>
										<option value="${languagetable.languageCode}" selected>
											${languagetable.languageName}
										</option>
									</s:if>
									<s:else>
										<option value="${languagetable.languageCode}">
											${languagetable.languageName}
										</option>
									</s:else>
								</s:iterator>
							</select>
						</td>
						<th width="150">
							${sessionScope.lang.DelFlagText}
						</th>
						<td>
							<select class="u-sel" name="DIVDelFlag">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.DelFlagList" id="comlist">
									<s:if test='%{#comlist.comListValue == #request.DIVDelFlag}'>
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

