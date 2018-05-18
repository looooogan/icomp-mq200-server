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
						title:'${session.lang.LanguageCodeText}',
						name:'languageCode',
						visible:'${session.gridcol.languageCode}'
					},{
						title:'${session.lang.LanguageValueText}',
						name:'languageValue',
						visible:'${session.gridcol.languageValue}'
					},{
						title:'${session.lang.LanguageText}',
						name:'languageName',
						visible:'${session.gridcol.languageName}'
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
				if(r.delFlag>0){
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.EnableText}</a></li>').click(function(){startUsing(r.languageCode,r.version,this)}));
				}else{
				ary_li.push($('<li>${session.lang.AlreadyEnableText}</li>'));
				}
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.languageCode,r.version,this)}));
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
					LanguageCode:$(LanguageForm.LanguageCode).val(),
				}
				$('#list').grid('url','B08S003.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	
			
			
			/**
			* 编辑处理
			*/
			function edit(id,version,obj){
				var param = {
					languageCode:id,
					opt:'edit',
					version:version
				}
				$.ajax({
					url:"languageTableInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_language(d,id,obj);
						}
					}
				});
			}
			
			/**
			* 启用语言信息
			*/
			function startUsing(id,version,obj){
				var param = {
					languageCode:id,
					opt:'edit',
					version:version
				}
				$.ajax({
					url:"languageTableInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(data){
						if(data.status < 0){
					    	artDialog(data.message,"OK");
					    }else{
					    	$('#languageEditForm').form('reset');
								var title = '${session.lang.AddLanguageTitle}';
								$('#languageEditForm :input').removeClass('u-ipt-err');
								$('#languageEditForm').find("*").each(function () { 
					    		  if($(this).hasClass("u-sel")){
					    			$(this).removeAttr("style");
					    		  }
					    	  });
							$(languageEditForm.DivLanguageCode).val(id);//语言编码
							$(languageEditForm.DIVLanguageValue).val(data.data.languageValue);//语言值			
							$(languageEditForm.DIVLanguageName).val(data.data.languageName);//语言名称
							$(languageEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
							$(languageEditForm.DivVersion).val(data.data.version);//版本号
							$(languageEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
							$(languageEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
							$('#languageEditForm').attr('action','languageStartUse.action');
							$('#languageEditForm').form('submit',{
								success:function(d){
								    $('#languageEditForm :input').removeClass('u-ipt-err');
									$('#languageEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									artDialog($.parseJSON(d).message,"OK");
												$('#list').grid('load');
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#languageEditForm'),$.parseJSON(d).message),"OK");
										}
									}
								});
						}
					}
				});

			}
			
			/**
			* 添加语言
			*/
			function wd_language(data,id,obj){
				$('#languageEditForm').form('reset');
				var title = '${sessionScope.lang.languageAddText}';
				$('#languageEditForm :input').removeClass('u-ipt-err');
				$('#languageEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					//编辑
					$(languageEditForm.opt).val('edit');
					// 页面赋值
					$(languageEditForm.DivLanguageCode).val(id);//语言编码
					$(languageEditForm.DIVLanguageValue).val(data.data.languageValue);//语言值			
					$(languageEditForm.DIVLanguageName).val(data.data.languageName);//语言名称
					$(languageEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(languageEditForm.DivVersion).val(data.data.version);//版本号
					$(languageEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(languageEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					$(languageEditForm.DivLanguageCode).attr("readOnly","true");//禁止编辑语言编码
					$('#languageEditForm').attr('action','languageTableEdit.action');
					title = '${sessionScope.lang.languageEditText}';
				}else{
					//新建
				    $(languageEditForm.DivVersion).val(0);//版本号
					$('#languageEditForm').attr('action','languageTableAdd.action');
				}
				$.dialog({
					id:'languageEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('languageEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#languageEditForm').form('submit',{
								success:function(d){
								    $('#languageEditForm :input').removeClass('u-ipt-err');
									$('#languageEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									//插入成功
										artDialog($.parseJSON(d).message,"OK");
										$('#list').grid('load');
										$.dialog.list['languageEdit_dialog'].close();
									} else if($.parseJSON(d).status == -1){
										artDialog(d.message,"OK");
									}else {	
										artDialog(setContorllBackColor($('#languageEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b08s003pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="LanguageForm" name="LanguageForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.LanguageText}
							</th>
							<td>
                              <select class="u-sel" name="LanguageCode">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.LanguageCodeList" id="languagetable">
								   <option value="${languagetable.languageCode}">${languagetable.languageName}</option>
								</s:iterator>
							</select>
						   </td>
					   </tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" onclick="return wd_language()">${sessionScope.lang.submitAddText}</button>
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
		<div id="languageEdit" class="f-dn">
			<form id="languageEditForm" name="languageEditForm" method="post">
			    <input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
			    <table class="m-frmtb" width="100%">
						<tr>
							<th width="150">
								${sessionScope.lang.LanguageCodeText}
							</th>
							<td>
								<input name="DivLanguageCode" type="text" class="u-ipt" maxlength="2">
							</td>
							<th width="150">
								${sessionScope.lang.LanguageValueText}
							</th>
                            <td>
								<input name="DIVLanguageValue" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.LanguageNameText}
							</th>
							<td>
								<input name="DIVLanguageName" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
			    </table>
			</form>
		</div>
	</body>
</html>

