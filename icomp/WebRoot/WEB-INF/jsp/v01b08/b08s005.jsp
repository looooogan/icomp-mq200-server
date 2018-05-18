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
						title:'${session.lang.LanguageText}',
						name:'languageName',
						visible:'${session.gridcol.languageName}'
					},{
						title:'${session.lang.ComListTypeText}',
						name:'comListType',
						visible:'${session.gridcol.comListType}'
					},{
						title:'${session.lang.ComListValueText}',
						name:'comListValue',
						visible:'${session.gridcol.comListValue}'
					},{
						title:'${session.lang.ComListText}',
						name:'comListText',
						visible:'${session.gridcol.comListText}'
					},{
						title:'${session.lang.ComListMsText}',
						name:'comListMs',
						visible:'${session.gridcol.comListText}'
					},{
						title:'${session.lang.EditFlagText}',
						name:'editFlag',
						visible:'${session.gridcol.editFlag}',
						format:function(r){
						//是否可以修改：0 是，1 否
						if(r.editFlag == 0 ){return '<span class="ui-grid-tdtx">${session.lang.IsText}</span>';}
				   else if(r.editFlag == 1 ){return '<span class="ui-grid-tdtx">${session.lang.NoText}</span>';}
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.comlistID,r.version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.comlistID,r.version,r.updateTime,r.updateUser,this)}}));
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
					ComListText:$(comListForm.ComListText).val(),
				}
				$('#list').grid('url','B08S005.action');
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
					comlistID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"comlistDelete.action",
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
					comlistID:id,
					opt:'edit',
					version:version
				}
				$.ajax({
					url:"comlistInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_comlist(d,id,obj);
						}
					}
				});
			}
						
			//添加区分定义
			function wd_comlist(data,id,obj){
				$('#comlistEditForm').form('reset');
				var title = '${session.lang.comlistAddText}'
				$('#comlistEditForm :input').removeClass('u-ipt-err');
				$('#comlistEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
	    	
				if(typeof(data) == 'object'){
				    $(comlistEditForm.opt).val('edit');
					
					// 页面赋值
					$(comlistEditForm.DivComlistID).val(id);//ComlistID
					$(comlistEditForm.DIVLanguageCode).val(data.data.languageCode);
					$(comlistEditForm.DIVComListType).val(data.data.comListType);//
					$(comlistEditForm.DIVComListValue).val(data.data.comListValue);
					$(comlistEditForm.DIVComListText).val(data.data.comListText);
					$(comlistEditForm.DIVComListMs).val(data.data.comListMs);//职务名称
					$(comlistEditForm.DIVEditFlag).val(data.data.editFlag);//职务编码
					$(comlistEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(comlistEditForm.DivVersion).val(data.data.version);//版本号
					$(comlistEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(comlistEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					$('#comlistEditForm').attr('action','comlistEdit.action');
					title = '${session.lang.comlistEditText}';
				}else{
					//新建
				    $(comlistEditForm.DivVersion).val(0);//版本号
				    $('#comlistEditForm').attr('action','comlistAdd.action');
				}
				$.dialog({
					id:'comlistEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('comlistEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
                        callback:function(){
							$('#comlistEditForm').form('submit',{
								success:function(d){
								    $('#comlistEditForm :input').removeClass('u-ipt-err');
									$('#comlistEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									//插入成功
										  $('#list').grid('load');
										  $.dialog.list['comlistEdit_dialog'].close();
										  artDialog($.parseJSON(d).message,"OK");
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#comlistEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b08s005pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="comListForm" name="comListForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ComListText}
							</th>
							<td>
								<input name="ComListText" type="text" class="u-ipt" maxlength="35">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" onclick="return wd_comlist()">${sessionScope.lang.submitAddText}</button>
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
		
		<div id="comlistEdit" class="f-dn">
		<form id="comlistEditForm" name="comlistEditForm" method="post">
		        <input type="text" class="f-dn" name="opt" value="add"/>
		        <input type="text" class="f-dn" name="DivComlistID"/>
		        <input type="text" class="f-dn" name="DIVDelFlag" value="0"/>
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
			    <table class="m-frmtb" width="100%">
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
								${sessionScope.lang.ComListTypeText}
							</th>
							<td>
								<input name="DIVComListType" type="text" class="u-ipt" maxlength="36">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.ComListValueText}
							</th>
							<td>
								<input name="DIVComListValue" type="text" class="u-ipt" maxlength="36">
							</td>
							<th width="150">
								${sessionScope.lang.ComListText}
							</th>
							<td>
								<input name="DIVComListText" type="text" class="u-ipt"  maxlength="36">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.ComListMsText}
							</th>
							<td>
								<input name="DIVComListMs" type="text" class="u-ipt" maxlength="50">
							</td>
							<th width="150">
								${sessionScope.lang.EditFlagText}
							</th>
							<td>
								<select class="u-sel" name="DIVEditFlag">
								    <option value="">--${sessionScope.lang.PleaseSelect}--</option>
								    <s:iterator value="#request.EditFlagList" id="comlist">
										<s:if test='%{#comlist.comListValue == #request.EditFlag}'>
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

