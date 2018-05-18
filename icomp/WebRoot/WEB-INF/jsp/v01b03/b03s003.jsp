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
					name:'merchantsType',
					format:function(t){
						<%-- 0修磨1涂层 --%>
						if(t.merchantsType == 0 ){return '<span class="ui-grid-tdtx">修磨</span>';}
						else if(t.merchantsType == 1 ){return '<span class="ui-grid-tdtx">涂层</span>';}
						return '<span class="ui-grid-tdtx"></span>';
					}
				},{
					title:'联系人',
					name:'innerName'
				},{
					title:'电话',
					name:'merchantsTel'
				},{
					title:'地址',
					name:'merchantsAddrss'
				},{
					title:'操作',
					name:'',
					width:'130px',
					visible:'true',
					format:function(r,t){
						return option(r);
					}
				}
				],
				success:function(d) {
					if (undefined == d.total) {
						$("#number1").text(0);
					} else if (0 == d.total) {
						$("#number1").text(1);
					} else {
						$("#number1").text(d.total);
					}
					if (d.status < 0) {
						artDialog(d.message, "OK");
					}
				}
			}) ;
		});
		/**
		 * 操作列超链接
		 **/
		function option(r){
			var $ul = $('<ul class="u-option"></ul>');
			var $li = $('');
			var ary_li = new Array();
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.merchantsID,'',this)}));
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.merchantsID,this)}));
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}

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
				$('#list').grid('url','B03S003.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});
			//导出
			$("#infoExport").click(function () {
				$.dialog.confirm('您确定要导出么？', function (){

					$("#merchantsColdHid").val($(searchForm.merchantsCold).val());
					$("#merchantsNameHid").val($(searchForm.merchantsName).val());
					$("#innerNameHid").val($(searchForm.innerName).val());
					$("#hidFrom").submit();
				});

			});
		});


		/*
		编辑
		 */
		function detail(id,version,obj){


			var param = {
				userID:id,
				opt:'detail',
				version:version
			}
			$.ajax({
				url:"merchantsInfo.action",
				type: "post",
				dataType:"json",
				data:param,
				success:function(d){
					wd_userdetail(d,id);
				}
			});
		}
		function edit(id,version,obj){


			var param = {
				merchantsID:id,
				opt:'find',
				version:version
			}
			$.ajax({
				url:"merchantsEdit.action",
				type: "post",
				data:param,
				dataType:"json",
				success:function(d){
					if(d.status < 0){
						artDialog(d.message,"OK");
					}else{
						wd_user(d,id,obj);
					}
				}
			});
		}

		/**
		 * 删除处理
		 */
		function del(id,obj){
			$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				var param = {
					merchantsID:id,
					async:false,
									}
				$.ajax({
					url:"merchantsDelete.action",
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
		 * 添加
		 * @param data
		 * @param id
		 * @param obj
         * @returns {boolean}
         */
		function wd_user(data,id,obj){
			$('#roleEditForm').form('reset');
			var title = '新建修磨商家';
			$('#roleEditForm :input').removeClass('u-ipt-err');
			$('#roleEditForm').find("*").each(function () {
				if($(this).hasClass("u-sel")){
					$(this).removeAttr("style");
				}
			});

			if(typeof(data) == 'object'){

				$(roleEditForm.opt).val('edit');
				$('#roleEditForm').attr('action','merchantsEdit.action');
				// 页面赋值
				$(roleEditForm.DIVmerchantsCode).val(data.data.merchantsCold);//	厂家编码
				$(roleEditForm.DIVmerchantsName).val(data.data.merchantsName);//厂家名称
				$(roleEditForm.DIVmerchantsType).val(data.data.merchantsType);//厂家类型
				$(roleEditForm.DIVmerchantsUser).val(data.data.innerName);//联系人
				$(roleEditForm.DIVmerchantsTel).val(data.data.merchantsTel);//联系电话
				$(roleEditForm.DIVmerchantsAdd).val(data.data.merchantsAddrss);//地址
				$(roleEditForm.DIVmerchantsID).val(id);//

				title = '编辑修磨商家信息';

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
						$(roleEditForm.DIVmerchantsCode).removeAttr("disabled");//启用机构
						$(roleEditForm.DIVmerchantsName).removeAttr("disabled");//启用部门
						$(roleEditForm.DIVmerchantsType).removeAttr("disabled");//启用部门

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
									$('#list').grid('url','B03S003.action');
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
		<div id="hiddDiv" style="display: none">
			<form action="exportExcel03S003.action" method="post" id="hidFrom">
				<input type="hidden" name="merchantsCold" id="merchantsColdHid">
				<input type="hidden" name="merchantsName" id="merchantsNameHid">
				<input type="hidden" name="innerName"     id="innerNameHid">

			</form>
		</div>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>当前页：首页>刃磨及涂层管理>厂外修磨商家</span>
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
								<input name="innerName" type="text" class="u-ipt" maxlength="8">
							</td>
						</tr>
					</table>

					<br/>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>

						<button type="button" class="u-btn2" id="infoNews" onclick="return wd_user()">新建</button>
						<button type="button" class="u-btn2" id="infoExport">导出</button>


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
		<%--新建厂家DIV--%>
		<div id="roleEdit" class="f-dn">
			<form id="roleEditForm" name="roleEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
				<input type="text" class="f-dn" name="DIVmerchantsID" />
				<table class="m-frmtb" width="100%">

					<tr>
						<th width="150">
							厂家编码
						</th>
						<td>
							<input name="DIVmerchantsCode" type="text" class="u-ipt" maxlength="20">
						</td>
						<th width="150">
							厂家名称
						</th>
						<td>
							<input name="DIVmerchantsName" type="text" class="u-ipt" maxlength="32">


						</td>
						<th width="150">
							厂家类型 <%-- 0修磨1涂层 --%>
						</th>
						<td>
							<select class="u-sel" name="DIVmerchantsType">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
									<option value="0">修磨</option>
									<option value="1">涂层</option>

							</select>
						</td>
					</tr>
					<tr>
						<th width="150">
							厂家联系人
						</th>
						<td>
							<input name="DIVmerchantsUser" type="text" class="u-ipt" maxlength="8">
						</td>

						<th width="150">
							厂家电话
						</th>
						<td>
							<input name="DIVmerchantsTel" type="text" class="u-ipt" maxlength="12">
						</td>
						<th width="150">
							厂家地址
						</th>
						<td>
							<input name="DIVmerchantsAdd" type="text" class="u-ipt" maxlength="50">

						</td>

					</tr>
				</table>
			</form>
		</div>

</body>
</html>

