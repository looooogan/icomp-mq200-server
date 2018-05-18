<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
				column:[
//						{
//					title:'刀具类型',
//					name:'expandSpace1'
//
//				},
					{
					title:'材料号',
					name:'toolCode'
				}, {
					title:'评估类型',
				 	name:'valType'

				}, {
					title:'订单序号',
					name:'poItem'

				},{
					title:'操作时间',
					name:'outInDate'
				},{
					title:'数量',
					name:'storageNum'
				},{
					title:'操作者',
					name:'libraryUser'
				},{
					title:'上传状态',
					name:'stateSt',
					format:function(t) {
//						上传状态（0 未上传 1 已上传 2 上传失败）
						if (t.stateSt == 0) {
							return '<span class="ui-grid-tdtx">	未上传</span>';
						}else if(t.stateSt == 1){
							return '<span class="ui-grid-tdtx">	已上传</span>';
						}else if(t.stateSt == 2){
							return '<span class="ui-grid-tdtx">	上传失败</span>';
						}else{
							return '<span class="ui-grid-tdtx">	手动处理</span>';
						}
					}
				},{
					title:'上传类型：入库、出库',
					name:'moveType',
					format:function(t) {
//						上传类型：101入库、201出库
						if (t.moveType == 101) {
							return '<span class="ui-grid-tdtx">	有订单入库</span>';
						}else if(t.moveType == 501){
							return '<span class="ui-grid-tdtx">	无订单入库</span>';
						}else{
							return '<span class="ui-grid-tdtx">	出库</span>';
						}

						return '<span class="ui-grid-tdtx"></span>';
					}
				},{
					title:'上传信息',
					name:'stateTs'
				},{
						title: '${session.lang.OperationText}',
						name: '',
						width: '130px',
						visible: 'true',
						format: function (r, t) {
							return option (r);
						}
					}
				],
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

		$(function(){
			/**
			 * 库存状况查询
			 */
			$("#inventoryStatusSubmit").click(function(){
				var param = {
					opt:'list',
					//ToolType :$(inventoryStatusFrom.ToolType).val(),
					ToolCode:$(inventoryStatusFrom.toolCode).val(),
					dstar    :$(inventoryStatusFrom.dstar).val(),
					dend     :$(inventoryStatusFrom.dend).val(),
					UserName :$(inventoryStatusFrom.UserName).val(),
					stateSt  :$(inventoryStatusFrom.stateSt).val(),
					moveType  :$(inventoryStatusFrom.moveType).val(),
					//stateSt:$(inventoryStatusFrom.stateSt).val(),
					sapID  :"",

				}
				$('#list').grid('url','B01S013.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});

			//导出
			$("#infoExport").click(function () {
				$.dialog.confirm('您确定要导出么？', function (){

					$("#toolTypeHid").val($(inventoryStatusFrom.ToolType).val()); //材料号
					$("#systeCodeHid").val($(inventoryStatusFrom.SysteCode).val()); //补领原因
					$("#dstarHid").val($(inventoryStatusFrom.dstar).val()); //开始时间
					$("#dendsHid").val($(inventoryStatusFrom.dend).val()); //结束时间
					$("#userNameHid").val($(inventoryStatusFrom.UserName).val()); //领用部门
					$("#stateStHid").val($(inventoryStatusFrom.stateSt).val()); //经办人

					$("#hidFrom").submit();
				});

			});


		});

		/**
		 * 操作列超链接
		 */
		function option(r) {
			var $ul = $ ('<ul class="u-option"></ul>');
			var $li = $ ('');
			var ary_li = new Array ();
			ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click (function () {
				edit (r.sapID, this,r.stateSt)
			}));
			<%--ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitDetailText}</a></li>').click (function () {--%>
			<%--detail (r.customerID, r.customerVersion, this)--%>
			<%--}));--%>
			$.each (ary_li, function (i, o) {
				$li.after (o);
			});
			return $ul.append ($li);
		}

		/**
		 * 编辑处理
		 */
		function edit(id, obj,state) {
		    if(state == 1 || state == 3){
                alert("该订单已上传,不可编辑");
                return;
            }
			var param = {
				sapID: id,
				opt: 'edit'
			}
			$.ajax ({
				url: "B01S013.action",
				type: "post",
				dataType: "json",
				data: param,
				success: function (d) {
//					if (d.status < 0) {
//						artDialog (d.message, "OK");
//					} else {

						wd_user (d, id, obj,state);
//					}
				}
			});
		}

		//添加用户
		function wd_user(data, id, obj,state) {
			$ ('#sapEditForm').form ('reset');
			var title = 'SAP上传编辑';
//			$ ('#sapEditForm :input').removeClass ('u-ipt-err');
//			$ ('#sapEditForm').find ("*").each (function () {
//				if ($ (this).hasClass ("u-sel")) {
//					$ (this).removeAttr ("style");
//				}
//			});


			//$ (sapEditForm.DivState).val (state);
//			$ (userEditForm.DivUserName).removeAttr ("disabled");//禁用用户名修改
//			$ ("#editDivUserPass").hide ();
//			$ ("input[name=DivUserPass]").show ();//禁用密码修改修改
			$ (sapEditForm.DivSapID).val (id);//sapID
			$ ('#sapEditForm').attr ('action', 'sapEdit.action');

			$.dialog ({
				id: 'sapEdit_dialog',
				title: title,
				lock: true,
				content: document.getElementById ('sapEdit'),
				button: [{
					name: '${session.lang.submitSaveText}',
					focus: true,
					callback: function () {
						$ ('#sapEditForm').form ('submit', {
							success: function (d) {
								$ ('#sapEditForm :input').removeClass ('u-ipt-err');
								$ ('#sapEditForm').find ("*").each (function () {
									if ($ (this).hasClass ("u-sel")) {
										$ (this).removeAttr ("style");
									}
								});
								if ($.parseJSON (d).status >= 0) {
									var param = {
										opt:'list',
										//ToolType :$(inventoryStatusFrom.ToolType).val(),
										ToolCode:$(inventoryStatusFrom.toolCode).val(),
										dstar    :$(inventoryStatusFrom.dstar).val(),
										dend     :$(inventoryStatusFrom.dend).val(),
										UserName :$(inventoryStatusFrom.UserName).val(),
										stateSt  :$(inventoryStatusFrom.stateSt).val(),
										moveType  :$(inventoryStatusFrom.moveType).val(),
										//stateSt:$(inventoryStatusFrom.stateSt).val(),
										sapID  :"",
									}
									$ ('#list').grid ('url', 'B01S013.action');
									$ ('#list').grid ('data', param);
									if ($ (sapEditForm.opt).val () != 'edit') {
										$ ('#list').grid ('load', 1);
									} else {
										$ ('#list').grid ('load');
									}
									artDialog ($.parseJSON (d).message, "OK");
									$.dialog.list['sapEdit_dialog'].close ();
								} else if ($.parseJSON (d).status == -1) {
									artDialog (d.message, "OK");
								} else {
									//if($.parseJSON(d).errtype){
									//  var o=getObject($.parseJSON(d).contoll);
									//  o.addClass('u-ipt-err');//发生错误控件描红
									//  artDialog($.parseJSON(d).message,"OK");
									//  o.foucs();
									//}else{
									//artDialog($.parseJSON(d).message,"OK");
									//控件描红
									//弹出消息
									artDialog (setContorllBackColor ($ ('#sapEditForm'), $.parseJSON (d).message), "OK");
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
	<form action="exportExcel01S013.action" method="post" id="hidFrom">
		<input type="hidden" name="toolType"      id="toolTypeHid">
		<input type="hidden" name="systeCode"   id="systeCodeHi">
		<input type="hidden" name="dstar"       	id="dstarHid">
		<input type="hidden" name="dends"    	     id="dendsHid">
		<input type="hidden" name="userName"    id="userNameHid">
		<input type="hidden" name="stateSt"   	  id="stateStHid">
	</form>
</div>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页:首页 > 库存信息> SAP上传模块</span>
		<%@ include file="../head_div.jsp" %>
	</div>
</div>
<div class="ui-layout-center g-ct-bd">
	<div class="ui-layout-north">
		<div class="u-ptf">
			${sessionScope.lang.searchTitle}
		</div>
		<form id="inventoryStatusFrom" name="inventoryStatusFrom" method="post">
			<table width="100%" class="m-frmtb">
				<tr>
					<%--<th width="150">--%>
						<%--刀具类型--%>
					<%--</th>--%>
					<%--<td>--%>
						<%--<select class="u-sel" name="ToolType">--%>
							<%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>

							<%--<option value="A">A</option>--%>
							<%--<option value="B">B</option>--%>
							<%--<option value="C">C</option>--%>
							<%--<option value="D">D</option>--%>
							<%--<option value="E">E</option>--%>
							<%--<option value="F">F</option>--%>
							<%--<option value="G">G</option>--%>
							<%--<option value="H">H</option>--%>
							<%--<option value="I">I</option>--%>
						<%--</select>--%>
					<%--</td>--%>
					<th width="150">
						材料号
					</th>
					<td>
						<input name="toolCode" type="text" class="u-ipt" maxlength="10" onkeyup="this.value=this.value.toUpperCase()">
					</td>
					<th width="150">
						时间段
					</th>
					<td style="white-space: nowrap">
						<input name="dstar" type="text" class="u-ipt Wdate"
							   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
						<input name="dend" type="text" class="u-ipt Wdate"
							   onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">
					</td>
				</tr>
				<tr>
					<th width="150">
						操作者
					</th>
					<td>
						<input name="UserName" type="text" class="u-ipt" maxlength="20">
					</td>
					<th>
						上传类型
					</th>
					<td>
						<select class="u-sel" name="moveType" maxlength="6">
							<option value="">--请选择--</option>

							<option value="101">有订单入库</option>
							<option value="501">无订单入库</option>
							<option value="201">出库</option>

						</select>
					</td>
					<th>
						上传状态选择
					</th>
					<td>
						<select class="u-sel" name="stateSt" maxlength="6">
							<option value="">--请选择--</option>

							<option value="0">未上传</option>

							<option value="1">已上传</option>

							<option value="2">上传失败</option>

							<option value="3">手动处理</option>

						</select>
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="inventoryStatusSubmit" >${sessionScope.lang.submitSearchText}</button>
				<%--<button type="button" class="u-btn2" id="shagnchuan" >上传</button>
                <button type="button" class="u-btn2" id="infoExport" >导出</button>--%>
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
<div id="sapEdit" class="f-dn">
	<form id="sapEditForm" name="sapEditForm" method="post">
		<input type="text" class="f-dn" name="opt" value="edit"/>
		<input type="text" class="f-dn" name="DivSapID"/>
		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					上传状态
				</th>
				<td>
					<select class="u-sel" name="DivState"">
						<option value="3">手动处理</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

