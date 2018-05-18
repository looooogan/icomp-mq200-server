<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
				column:[ {
						title:'修磨厂家编码',
						name:'merchantsCold'
					},{
						title:'修磨厂家名称',
						name:'merchantsName'
					},{
						title:'厂家类型',
						name:'merchantsType'
					},{
						title:'联系人',
						name:'innerName'
					},{
						title:'电话',
						name:'merchantsTel'
					},{
						title:'地址',
						name:'approver'
					}],
					success:function(d){
						if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});

			$(function(){
				/**
				*厂外修磨商家查询
				*/
				$("#searchSubmit").click(function(){
					var param = {
							opt:'list',
						merchantsCold:$(searchForm.merchantsCold).val(),
						merchantsName:$(searchForm.merchantsName).val(),
						innerName:$(searchForm.innerName).val(),

						}
						$('#list').grid('url','B03S006.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});
				});

			/*
			 新建div
			 */
			function wd_user(data,id,obj){

				$('#roleEditForm').form('reset');
				var title = '新建通知单';
				$('#roleEditForm :input').removeClass('u-ipt-err');
				$('#roleEditForm').find("*").each(function () {
					if($(this).hasClass("u-sel")){
						$(this).removeAttr("style");
					}
				});
				if(typeof(data) == 'object'){
					$(roleEditForm.opt).val('edit');

					// 页面赋值
					$(roleEditForm.DivPositionID).val(id);//角色ID
					$(roleEditForm.DIV_AgencyID).val(data.data.agencyID);//机构

					$('#roleEditForm').attr('action','merchantsEdit.action');
					title = '${session.lang.EditRoleTitle}';

				}else{
					$(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
					$(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
					$(roleEditForm.DIV_DelFlag).val(0);//删除区分-有效
					$(roleEditForm.DivVersion).val(0);//版本号
					$('#roleEditForm').attr('action','merchantsAdd.action');
				}
				$.dialog({
					id:'roleEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('roleEdit'),
					button:[{
						name:'保存',
						focus:true,
						callback:function(){
							$(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
							$(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
							$('#roleEditForm').form('submit',{
								success:function(d){
									$('#roleEditForm :input').removeClass('u-ipt-err');
									$('#roleEditForm').find("*").each(function () {
										if($(this).hasClass("u-sel")){
											$(this).removeAttr("style");
										}
									});
									if($.parseJSON(d).status >= 0){
										var param = {
											opt:'list',
//											AgencyID:$(roleForm.AgencyID).val(),
//											DepartmentID:$(roleForm.DepartmentID).val(),
//											PositionID:$(roleForm.PositionID).val(),
//											DelFlag:$(roleForm.DelFlag).val()
										}
										$('#list').grid('url','B03S006.action');
										$('#list').grid('data',param);
										if($(roleEditForm.opt).val()!='edit'){
											$('#list').grid('load',1);
										}else{
											$('#list').grid('load');
										}
										artDialog($.parseJSON(d).message,"OK");
										$.dialog.list['roleEdit_dialog'].close();
									} else if($.parseJSON(d).status == -1){
										artDialog(d.message,"OK");
									}else {
										//if($.parseJSON(d).errtype){
										//  var o=getObject($.parseJSON(d).contoll);
										//  o.addClass('u-ipt-err');//发生错误控件描红
										//  artDialog($.parseJSON(d).message,"OK");
										//  o.foucs();
										//}else{
										//artDialog($.parseJSON(d).message,"OK");
										//控件描红
										//弹出消息

										artDialog(setContorllBackColor($('#roleEditForm'),$.parseJSON(d).message),"OK");
										//}
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
				<span>当前页：首页>刃磨及涂层管理>厂外修磨通知查询</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="searchForm" name="searchForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								厂家编码
							</th>
							<td>
								<input name="merchantsCold" type="text" class="u-ipt" maxlength="20">
							</td>

							<th width="150">
								修磨厂家名称
							</th>
							<td>
								<input name="merchantsName" type="text" class="u-ipt" maxlength="20">

						<th width="100">
							联系人
						</th>
						<td>
							<input name="innerName" type="text" class="u-ipt" maxlength="50">
						</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>

					<button type="button" class="u-btn2" id="infoNews" onclick="return wd_user()" >新建</button>
					<button type="button" class="u-btn2" id="infoExport">导出</button>


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
		<%--新建厂家DIV--%>
		<div id="roleEdit" class="f-dn">
			<form id="roleEditForm" name="roleEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add"/>
				<table class="m-frmtb" width="100%">

					<tr>
						<th width="150">
							厂家编码
						</th>
						<td>
							<input name="DIVmerchantsCode" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							厂家名称
						</th>
						<td>
							<input name="DIVmerchantsName" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							厂家类型
						</th>
						<td>
							<select class="u-sel" name="DIVmerchantsType">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.DepartmentList" id="department">
									<option value="xxx">dddd</option>
								</s:iterator>
							</select>
						</td>
						</tr>
					<tr>
						<th width="150">
							厂家联系人
						</th>
						<td>
							<input name="DIVmerchantsUser" type="text" class="u-ipt" maxlength="36">
						</td>

						<th width="150">
							厂家电话
						</th>
						<td>
							<input name="DIVmerchantsTel" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							厂家地址
						</th>
						<td>
							<input name="DIVmerchantsAdd" type="text" class="u-ipt Wdate" onclick="WdatePicker()" maxlength="50" >

						</td>

					</tr>
				</table>
			</form>
		</div>
	</body>
</html>

