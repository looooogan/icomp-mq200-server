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
						title:'容器名称',
						name:'containerCarrierName'
						<%--format:function(r){--%>
						<%--if(r.itemType == 0 ){return '<span class="ui-grid-tdtx">${session.lang.HandSetText}</span>';}--%>
				   <%--else if(r.itemType == 1 ){return '<span class="ui-grid-tdtx">${session.lang.PlatformText}</span>';}--%>
				   <%--else if(r.itemType == 2 ){return '<span class="ui-grid-tdtx">${session.lang.PrintingProjectText}</span>';}--%>
					<%--return '<span class="ui-grid-tdtx"></span>';--%>
                        <%--}--%>
					},{
						title:'容器类别',
						name:'containerCarrierType',
					//0.一次性报废 2.待分拣容器 3.厂内待刃磨 4.厂外待刃磨 5.刃磨完毕 6.刃磨报废 7.待涂层 8.库房报废 9.其他
					format:function(r){
					if(r.containerCarrierType == 0 ){return '<span class="ui-grid-tdtx">备用刀</span>';}
					if(r.containerCarrierType ==1 ){return '<span class="ui-grid-tdtx">一次性报废</span>';}
					else if(r.containerCarrierType == 2 ){return '<span class="ui-grid-tdtx">待分拣容器</span>';}
					else if(r.containerCarrierType == 3 ){return '<span class="ui-grid-tdtx">厂内待刃磨</span>';}
					else if(r.containerCarrierType == 4){return '<span class="ui-grid-tdtx">厂外待刃磨</span>';}
					else if(r.containerCarrierType == 5 ){return '<span class="ui-grid-tdtx">刃磨完毕</span>';}
					else if(r.containerCarrierType == 6 ){return '<span class="ui-grid-tdtx">刃磨报废</span>';}
					else if(r.containerCarrierType == 7 ){return '<span class="ui-grid-tdtx">待涂层</span>';}
					else if(r.containerCarrierType == 8 ){return '<span class="ui-grid-tdtx">库房报废</span>';}
					else if(r.containerCarrierType == 9 ){return '<span class="ui-grid-tdtx">其他</span>';}
					return '<span class="ui-grid-tdtx"></span>';
					}
					},{
						title:'负责人',
						name:'person'
					},{
						title:'是否绑定',
						name:'rfidContainerID',
					format:function(r){
						if(r.rfidContainerID == 0){return '<span class="ui-grid-tdtx">否</span>';}
						else {return '<span class="ui-grid-tdtx">是</span>';}
						return '<span class="ui-grid-tdtx"></span>';
					}
					},{
						title:'${session.lang.OperationText}',
						name:'-',
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.containerCarrierID,'',this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.containerCarrierID,'',r.updateTime,r.updateUser,this)}));
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
					containerCarrierType:$(printForm.containerCarrierType).val(),
					person:$(printForm.person).val()
				}
				$('#list').grid('url','B09S004.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}
			
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.RoleDelInfo}',function(){
				    var param = {
					ID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"printItemDelete.action",
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
					containerCarrierID:id,

				}
				$.ajax({
					url:"printItemInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					     artDialog(d.message,"OK");
					    }else{
						wd_printEdit(d,id,obj);
						}
					}
				});
			}
			
			//打印项目添加
			function wd_printEdit(data,id,obj){
				$('#printEditForm').form('reset');
				var title = '新建容器管理';
				$('#printEditForm :input').removeClass('u-ipt-err');
				$('#printEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					$(printEditForm.opt).val('edit');
					$(printEditForm.containerCarrierID).val(id);
					$(printEditForm.DivCarrietCode).val(data.data.containerCarrierCode);
					$(printEditForm.DivCarrietName).val(data.data.containerCarrierName);
					$(printEditForm.DivCarrietType).val(data.data.containerCarrierType);
					$(printEditForm.DivCarrietRFID).val(data.data.rfidContainerID);
					$(printEditForm.DivPerson).val(data.data.person);
					$(printEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(printEditForm.DivVersion).val(data.data.version);//版本号
					$(printEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(printEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分


					//编辑
					$('#printEditForm').attr('action','printItemEdit.action');
					title = '编辑容器管理';
				}else{
					//添加
				 	$(printEditForm.DivVersion).val(0);//版本号
					$('#printEditForm').attr('action','printItemAdd.action');
				}
			$.dialog({
					id:'printEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('printEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#printEditForm').form('submit',{
								success:function(d){
								    $('#printEditForm :input').removeClass('u-ipt-err');
									$('#printEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
										   var param = {
												opt:'list',
												PageName:$(printEditForm.PageName).val()
											}
											$('#list').grid('url','B09S004.action');
											$('#list').grid('data',param);
											if($(printEditForm.opt).val()!='edit'){
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
											artDialog($.parseJSON(d).message,"OK");
											$.dialog.list['printEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										    artDialog(setContorllBackColor($('#printEditForm'),$.parseJSON(d).message),"OK");
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
				<span>当前页>首页>基础数据管理>容器管理</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="printForm" name="printForm" method="post">
				
					<input type="text" class="f-dn" name="containerCarrierID" />
					<table width="100%" class="m-frmtb">
						<tr>

							<th width="150">
								容器类别
							</th>
							<td>
								<select class="u-sel" name="containerCarrierType" maxlength="2">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<option value="0">
										--备用刀库--
									</option>
									<option value="1">
										--一次性报废--
									</option>
									<option value="2">
										--待分拣容器--
									</option>
									<option value="3">
										--厂内待刃磨--
									</option>
									<option value="4">
										--厂外待刃磨--
									</option>
									<option value="5">
										--刃磨完毕--
									</option>
									<option value="6">
										--刃磨报废--
									</option>
									<option value="7">
										--待涂层--
									</option>
									<option value="8">
										--库房报废--
									</option>
									<option value="9">
										--其他--
									</option>
								</select>
							</td>
							<th width="150">
								负责人
							</th>

							<td>
								<input name="person" type="text" class="u-ipt" maxlength="16">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" onclick="return wd_printEdit()" >${sessionScope.lang.submitAddText}</button>
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
		<div id="printEdit" class="f-dn">
			<form id="printEditForm" name="printEditForm" method="post">
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
				<input type="text" class="f-dn" name="containerCarrierID" />
				<input type="text" class="f-dn" name="DIVDelFlag" />
			    <table class="m-frmtb" width="100%">
						<tr>
							<th width="150">容器编码</th>
							<td>
								<input name="DivCarrietCode" type="text" class="u-ipt" maxlength="36">

							</td>
							<th width="150">容器名称</th>
							<td>
							<input name="DivCarrietName" type="text" class="u-ipt" maxlength="30">
							</td>
						</tr>
						<tr>
							<th width="150">容器类别</th>
							<td>
								<select class="u-sel" name="DivCarrietType" maxlength="2">
									option value="">
									--${sessionScope.lang.PleaseSelect}--
									</option>
									<option value="0">--备用刀--</option>
									<option value="1">--一次性报废--</option>
									<option value="2">--待分拣容器--</option>
									<option value="3">--厂内待刃磨--</option>
									<option value="4">--厂外待刃磨--</option>
									<option value="5">--刃磨完毕--</option>
									<option value="6">--刃磨报废--</option>
									<option value="7">--待涂层--</option>
									<option value="8">--库房报废--</option>
									<option value="9">--其他--</option>
								</select>
							</td>
							<th width="150">
								负责人
							</th>
							<td>
								<input name="DivPerson" type="text" class="u-ipt" maxlength="8">
							</td>
						</tr>
			    </table>
			</form>
		</div>
	</body>
</html>

