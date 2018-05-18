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
						title:'${session.lang.ComplexText}',
						name:'complexName',
						visible:'${session.gridcol.complexName}'
					},{
						title:'${session.lang.DepotText}',
						name:'depotName',
						visible:'${session.gridcol.depotName}'
					},{
						title:'${session.lang.ShelfText}',
						name:'shelfName',
						visible:'${session.gridcol.shelfName}'
					},{
						title:'${session.lang.LayerText}',
						name:'layerName',
						visible:'${session.gridcol.layerName}'
					},{
						title:'${session.lang.StackText}',
						name:'stackName',
						visible:'${session.gridcol.stackName}'
					},{
						title:'${session.lang.LibraryCodeText}',
						name:'systeCodeShow',
						visible:'${session.gridcol.systeCodeShow}'
					},{
						title:'${session.lang.remark}',
						name:'remark',
						visible:'${session.gridcol.remark}'
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
			
			
			/******************* 选择库位码 相关代码*********************/
				$("#selectCode").click(function(e){
					$.dialog({
							id:'codeDialog',
							title:'${session.lang.SelectLibraryCodeInternationalization}',
							lock: true,
							content:document.getElementById('DivSelectCode')

						});
				});
				
			/****************************************/
			});
			//从选择库位码页面中 选出code返回编辑页面
			function sysCode(lcid,scode,ccode){
				var show ;
				
				if(ccode && ccode!=""){
					show = ccode;
				}
				else{
					show = scode;
				}
				$(stackEditForm.DivLibraryCodeID).val(lcid)
				$(stackEditForm.DivSysteCodeShow).val(show);
				$.dialog.list['codeDialog'].close();
			}
			
			//验证“备注”长度
			$("textarea[name='DIVRemark']").live('keydown',function(){
				if($(this).val().length>199){
					this.value=this.value.substr(0,199)
					$(this).next('span').html('${session.lang.E684}');
				}else{
					$(this).next('span').html('');
				}
			});
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.stackID,r.version,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.stackID,r.version,r.updateTime,r.updateUser,this)}}));
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
					Complex:$(stackForm.Complex).val(),
					Depot:$(stackForm.Depot).val(),
					Shelf:$(stackForm.Shelf).val(),					
				}
				$('#list').grid('url','B08S011.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	


			//添加库房货架
			function wd_stack(data,id,obj){
				$('#stackEditForm').form('reset');
				var title = '${session.lang.AddStackTitle}';
				$('#stackEditForm :input').removeClass('u-ipt-err');
				$('#stackEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					$(stackEditForm.opt).val('edit');
					
				    // 页面赋值
					$(stackEditForm.DivStackID).val(id);  //货架ID
					$(stackEditForm.DivLibraryCodeID).val(data.data.libraryCodeID);//库位码ID
					$(stackEditForm.DIVComplex).val(data.data.complex);//厂区
					$(stackEditForm.DIVDepot).val(data.data.depot);//库房号
					$(stackEditForm.DIVShelf).val(data.data.shelf);//货架		
					$(stackEditForm.DIVLayer).val(data.data.layer);//层		
					$(stackEditForm.DIVStack).val(data.data.stack);//货位		
					$(stackEditForm.DivSysteCodeShow).val(data.data.systeCodeShow);//库位码
					$(stackEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(stackEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(stackEditForm.DivVersion).val(data.data.version);//版本号
					$(stackEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					title = '${session.lang.EditStackTitle}';
					$('#stackEditForm').attr('action','stackEdit.action');
				}else{
				    $(stackEditForm.DivVersion).val(0);//版本号
					$('#stackEditForm').attr('action','stackAdd.action'); 
				}
				$.dialog({
					id:'stackEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('stackEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#stackEditForm').form('submit',{
								success:function(d){
									$('#stackEditForm :input').removeClass('u-ipt-err');
									$('#stackEditForm').find("*").each(function () { 
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
										  $.dialog.list['stackEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										    artDialog(setContorllBackColor($('#stackEditForm'),$.parseJSON(d).message),"OK");
										}
								}
							});
							return false;
						}
					}]
				});
				return false;
			}

			/**
			* 编辑处理
			*/
			function edit(id,version,obj){
				var param = {
					stackID:id,                //货架ID
					opt:'edit',                //编辑
					version:version            //版本号
				}
				$.ajax({
					url:"stackInfo.action",    //跳转到ACTION的取得待处理库房货架信息方法
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
							wd_stack(d,id,obj);  //调用添加工序方法
						}
					}
				});
			}
			
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				    var param = {
					stackID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"stackDelete.action",
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
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>当前页>首页>基础数据管理>库房货架配置</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="stackForm" name="stackForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ComplexText}
							</th>
							<td>
							 <select class="u-sel" name="Complex">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.ComplexList" id="Complexcomlist">
										<s:if test='%{#Complexcomlist.comListValue == #request.Complex}'>
											<option value="${Complexcomlist.comListValue}" selected>
												${Complexcomlist.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${Complexcomlist.comListValue}">
												${Complexcomlist.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.DepotText}
							</th>
							<td>
							 <select class="u-sel" name="Depot">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.DepotList" id="comlistDepot">
										<s:if test='%{#comlistDepot.comListValue == #request.Depot}'>
											<option value="${comlistDepot.comListValue}" selected>
												${comlistDepot.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistDepot.comListValue}">
												${comlistDepot.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.ShelfText}
							</th>
							<td>
							 <select class="u-sel" name="Shelf">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.ShelfList" id="comlistShelf">
										<s:if test='%{#comlistShelf.comListValue == #request.Shelf}'>
											<option value="${comlistShelf.comListValue}" selected>
												${comlistShelf.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistShelf.comListValue}">
												${comlistShelf.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
					    <button type="button" class="u-btn2" onclick="return wd_stack()">${sessionScope.lang.submitAddText}</button>
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
		<div id="stackEdit" class="f-dn">
			<form id="stackEditForm" name="stackEditForm" method="post">
			    <input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivStackID"/>
				<!--<input type="text" class="f-dn" name="DivLibraryCodeID"/>-->
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
				<input type="text" class="f-dn"  name="DivLibraryCodeID" />
			    <table class="m-frmtb" width="100%">
						<tr>
							<th width="150">
								${sessionScope.lang.ComplexText}
							</th>
							<td>
								 <select class="u-sel" name="DIVComplex">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.ComplexList" id="Complexcomlist">
										<s:if test='%{#Complexcomlist.comListValue == #request.DIVComplex}'>
											<option value="${Complexcomlist.comListValue}" selected>
												${Complexcomlist.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${Complexcomlist.comListValue}">
												${Complexcomlist.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.DepotText}
							</th>
							<td>
								 <select class="u-sel" name="DIVDepot">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.DepotList" id="comlistDepot">
										<s:if test='%{#comlistDepot.comListValue == #request.DIVDepot}'>
											<option value="${comlistDepot.comListValue}" selected>
												${comlistDepot.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistDepot.comListValue}">
												${comlistDepot.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.ShelfText}
							</th>
							<td>
							 <select class="u-sel" name="DIVShelf">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.ShelfList" id="comlistShelf">
										<s:if test='%{#comlistShelf.comListValue == #request.DIVShelf}'>
											<option value="${comlistShelf.comListValue}" selected>
												${comlistShelf.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistShelf.comListValue}">
												${comlistShelf.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.LayerText}
							</th>
							<td>
								<select class="u-sel" name="DIVLayer">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.LayerList" id="comlistLayer">
										<s:if test='%{#comlistLayer.comListValue == #request.DIVLayer}'>
											<option value="${comlistLayer.comListValue}" selected>
												${comlistLayer.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistLayer.comListValue}">
												${comlistLayer.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.StackText}
							</th>
							<td>
								<select class="u-sel" name="DIVStack">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.StackList" id="comlistStack">
										<s:if test='%{#comlistStack.comListValue == #request.DIVStack}'>
											<option value="${comlistStack.comListValue}" selected>
												${comlistStack.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlistStack.comListValue}">
												${comlistStack.comListText}
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
										<s:if test='%{#comlist.comListValue == #request.DelFlag}'>
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
								${sessionScope.lang.LibraryCodeText}
							</th>
							<td>
								<input name="DivSysteCodeShow" type="text" class="u-ipt" id="selectCode" readonly="readonly">
							</td>
							<th width="150">
								${sessionScope.lang.remark}
							</th>
							<td>
								<textarea rows="1" class="u-ipt" name="DIVRemark" ></textarea>
								<span></span>
							</td>
							
					   </tr>						
			    </table>
			</form>
		</div>
		
		<div id='DivSelectCode' class="f-dn" style="overflow:auto; width:400px; max-height:300px;">
			<table class="m-frmtb" width="100%">
				<tr>
					<th>${sessionScope.lang.LibraryCodeIdText}</th>
					<th>${sessionScope.lang.LibraryCodeText}</th>
					<th>${sessionScope.lang.OperationText}</th>
				</tr>
				<s:iterator value="#request.LibraryCodeList" id="libraryCode">
					<tr>
						<td>${ libraryCode.libraryCodeID }</td>
						<td>${ libraryCode.systeCodeShow }</td>
						<td><a href="javascript:void(0)" id="${ libraryCode.libraryCodeID }" onclick="sysCode('${libraryCode.libraryCodeID}','${ libraryCode.systeCode }','${ libraryCode.customerCode }');">选择</a></td>
					</tr>
				</s:iterator>
			
			</table>
		</div>
	</body>
</html>

