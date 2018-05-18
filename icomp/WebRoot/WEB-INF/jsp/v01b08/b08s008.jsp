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
					//async:false,//同步
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.ProcessNameText}',
						name:'processName',
						visible:'${session.gridcol.processName}'
					},{
						title:'${session.lang.ProcessCodeText}',
						name:'processCode',
						visible:'${session.gridcol.processCode}'
					},<%--{--%>
						<%--title:'${session.lang.LanguageText}',--%>
						<%--name:'languageName',--%>
						<%--visible:'${session.gridcol.languageName}'--%>
					<%--},{--%>
						<%--title:'${session.lang.DelFlagText}',--%>
						<%--name:'delFlag',--%>
						<%--visible:'${session.gridcol.delFlag}',--%>
						<%--format:function(r){--%>
						<%--return '<span class="ui-grid-tdtx">'+(r.delFlag == '0'?'${session.lang.DataDelNo}':'${session.lang.DataDelYes}')+'</span>';--%>
						<%--}--%>
					<%--},--%>{
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.processID,r.version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.processID,r.version,r.updateTime,r.updateUser,this)}}));
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
					ProcessName:$(processForm.ProcessName).val(),                  //工序ID
				}
				$('#list').grid('url','B08S008.action');                       //跳转到action               
				$('#list').grid('data',param);
				$('#list').grid('load',1);                                     //加载页面                    
				return false;
			}	
			
		   /**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				    var param = {
					processID:id,      //工序ID
					version:version,   //版本号
					updatetime:time,   //更新时间
					updateuser:user    //更新者
					}
					$.ajax({
						url:"processDelete.action",     //跳转到action的删除方法
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

			/**
			* 编辑处理
			*/
			function edit(id,version,obj){
				var param = {
					processID:id,              //工序ID
					opt:'edit',                //编辑
					version:version            //版本号
				}
				$.ajax({
					url:"processInfo.action",  //跳转到ACTION的取得待处理工序信息方法
					type: "post",              
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
						wd_process(d,id,obj);  //调用添加工序方法
						}
					}
				});
			}
			
			//添加工序
			function wd_process(data,id,obj){
				$('#processEditForm').form('reset');
				var title = '${session.lang.processAddTitle}';
				$('#processEditForm :input').removeClass('u-ipt-err');
				$('#processEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
	    	
				if(typeof(data) == 'object'){
				    $(processEditForm.opt).val('edit');
					
					// 页面赋值
					$(processEditForm.DivProcessID).val(id);                            //processID
				    $(processEditForm.DIVLanguageCode).val(data.data.languageCode);     //语言编码
					$(processEditForm.DIVProcessCode).val(data.data.processCode);       //工序编码
					$(processEditForm.DIVProcessName).val(data.data.processName);       //工序名称
					$(processEditForm.DivUpdateTime).val(data.data.updateTime);         //更新时间
					$(processEditForm.DivVersion).val(data.data.version);               //版本号
					$(processEditForm.DivUpdateUser).val(data.data.updateUser);         //更新者
					$(processEditForm.DIVDelFlag).val(data.data.delFlag);               //删除区分
					$('#processEditForm').attr('action','processEdit.action');
					title = '${session.lang.processEditTitle}';
				}else{
				    //新建
				    $(processEditForm.DivVersion).val(0);//版本号
				    $(processEditForm.DIVDelFlag).val(0);//删除区分
				    $('#processEditForm').attr('action','processAdd.action');
				}
				$.dialog({
					id:'processEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('processEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
                        callback:function(){
							$('#processEditForm').form('submit',{
								success:function(d){
								    $('#processEditForm :input').removeClass('u-ipt-err');
									$('#processEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
						    	  if($.parseJSON(d).status >= 0){
										   var param = {
												opt:'list',
					                            ProcessID:$(processForm.ProcessID).val(),                  //工序ID
											}
											$('#list').grid('url','B08S008.action');
											$('#list').grid('data',param);
											if($(processEditForm.opt).val()!='edit'){
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
											artDialog($.parseJSON(d).message,"OK");
											$.dialog.list['processEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										 artDialog(setContorllBackColor($('#processEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b08s008pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="processForm" name="processForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ProcessNameText}
							</th>
							<td>
								<input name="ProcessName" type="text" class="u-ipt" maxlength="20">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2"  onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2" onclick="return wd_process()">
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
		<div id="processEdit" class="f-dn">
			<form id="processEditForm" name="processEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add" />
				<input type="text" class="f-dn" name="DivProcessID" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th width="150">
							${sessionScope.lang.ProcessNameText}
						</th>
						<td>
							<input name="DIVProcessName" type="text" class="u-ipt" maxlength="20">
						</td>
						<th width="150">
							${sessionScope.lang.ProcessCodeText}
						</th>
						<td>
							<input name="DIVProcessCode" type="text" class="u-ipt" maxlength="20">
						</td>
					<%--</tr>--%>
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
						<%--<th width="150">--%>
							<%--${sessionScope.lang.DelFlagText}--%>
						<%--</th>--%>
						<%--<td>--%>
							<%--<select class="u-sel" name="DIVDelFlag">--%>
								<%--<option value="">--%>
									<%----${sessionScope.lang.PleaseSelect}----%>
								<%--</option>--%>
								<%--<s:iterator value="#request.DelFlagList" id="comlist">--%>
									<%--<s:if test='%{#comlist.comListValue == #request.DelFlag}'>--%>
										<%--<option value="${comlist.comListValue}" selected>--%>
											<%--${comlist.comListText}--%>
										<%--</option>--%>
									<%--</s:if>--%>
									<%--<s:else>--%>
										<%--<option value="${comlist.comListValue}">--%>
											<%--${comlist.comListText}--%>
										<%--</option>--%>
									<%--</s:else>--%>
								<%--</s:iterator>--%>
							<%--</select>--%>
						<%--</td>--%>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>

