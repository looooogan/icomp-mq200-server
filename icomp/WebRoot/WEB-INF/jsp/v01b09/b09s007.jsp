<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp"%>
	<!-- 2017/09/16 宋健 变更↓↓↓　dazhong@YMSC -->
	<style>
		.t1{ border:1px solid #8797aa; }
		td input{
			border:none;
			width:100%;
		}
	</style>
	<script type="text/javascript">
		var no = 1;
		var n = 1;
		var t = 1;
		var tt = 0;
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
					title:'厂家',
					width:'150px',
					name:'merchantsID'
				},{
					title:'日期',
					width:'100px',
					name:'manufactureDate',
					format: function (r) {
						return '<span class="ui-grid-tdtx">' + fdate1(r.manufactureDate) + '</span>';
					}
				},{
					title:'出门单号',
					width:'80px',
					name:'outDoorNom'
				},{
					title:'申请人',
					width:'83px',
					name:'approver'
				},{
					title:'邮寄人',
					width:'100px',
					name:'sendUser'
				},{
					title:'操作',
					name:'',
					width:'60px',
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
		function option(r){
			var $ul = $('<ul class="u-option"></ul>');
			var $li = $('');
			var ary_li = new Array();
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.outDoorNom, r.repairState,'',this)}));
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){delAll(r.outDoorNom,'all')}));
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}

		//编辑 调出编辑div
		function  edit(id,re,version,obj){
			$("btnEdit").show();
			var param = {
				outDoorNum:id,
				outre:re,
				opt:'find',
				version:version
			}
			$.ajax({
				url:"outInfo.action",
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

		$(function(){
			/**
			 * （厂外）修复通知单查询
			 */

			$("#searchSubmit").click(function(){
				var param = {
					opt:'list',
					outDoorNom:$(searchForm.noticeNo).val(),
					grindingName:$(searchForm.grindingName).val(),
					approver:$(searchForm.approver).val(),
					sendUser:$(searchForm.sendUser).val(),
					dateStar:$(searchForm.dstar).val()
				}
				$('#list').grid('url','B09S007.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});

			//导出
			$("#export").click(function () {
				$.dialog.confirm('您确定要导出么？', function () {
					$("#noticeNoHid").val($(searchForm.noticeNo).val());
					$("#dateStarHid").val($(searchForm.dstar).val());
					$("#dateEndHid").val($(searchForm.dend).val());
					$("#outstatusHid").val($(searchForm.outstatus).val());
					$("#grindingNameHid").val($(searchForm.grindingName).val());
					$("#operatorHid").val($(searchForm.operator).val());
					$("#numberGrindingHid").val($(printEditForm.DIVnumberGrinding).val());
					$("#materialNumHid").val($(printEditForm.materialNum).val());
					$("#dateHid").val($("input[name='date']").val());
					$("#hidFrom").submit();
				});

			});

			$("#btn1").click(function(){
				var v = $("#addOrEdit").val();
				if(v == "0"){
					$("#outDoorNumH").val("");
					// 新建
					no ++;
					var html = "";
					html +=  '<tr>';
					html +=	 '<td class="t1" align="center">';
					html +=	 no;
					html +=	 '</td>';
					html +=	 '<td class="t1"><input type="text" id="materialNum'+no+'" name="materialNum"/></td>';
					html +=	 '<td class="t1"><input type="text" id="name'+no+'"/></td>';
					html +=	 '<td class="t1"><input type="text" id="desc'+no+'"/></td>';
					html +=	 '<td class="t1"><input type="text" id="manageNo'+no+'" name="manageNo"/></td>';
					html +=	 '<td class="t1"><input type="text" id="num'+no+'"/></td>';
					html +=	 '<td class="t1"></td>';
					html +=	 '<td class="t1"></td>';
					html +=	 '<td class="t1"><input type="text" id="note'+no+'"/></td>';
					html +=	 '<td class="t1" align="center"><a onclick="return add(this,no)">保存</a></td>';
					html +=	 '</tr>';
					$("#addTable").append(html);
				}else{
					$("#editDiv").removeAttr("style");
					n = parseInt($("#listSize").val());
					if(n >= 10){
						$("#editDiv").attr("style","height: 300px;overflow-y:scroll;");
					}
					if(tt == 0){
						tt = n;
					}
					tt++;
					// 编辑
					var html = "";
					html +=  '<tr>';
					html +=	 '<td class="t1" align="center">';
					html +=	 tt ;
					html +=	 '</td>';
					html +=	 '<td class="t1" align="center"><input type="text" id="materialNum'+tt+'" name="materialNum"/></td>';
					html +=	 '<td class="t1"><input type="text" id="name'+tt+'"/></td>';
					html +=	 '<td class="t1"><input type="text" id="desc'+tt+'"/></td>';
					html +=	 '<td class="t1"><input type="text" id="manageNo'+tt+'"/></td>';
					html +=	 '<td class="t1"><input type="text" id="num'+tt+'"/></td>';
					html +=	 '<td class="t1"></td>';
					html +=	 '<td class="t1"></td>';
					html +=	 '<td class="t1"><input type="text" id="note'+tt+'"/></td>';
					html +=	 '<td class="t1" align="center"><a onclick="return add(this,tt)">保存</a></td>';
					html +=	 '</tr>';
					$("#newTable").append(html);
				}
			});

		});

		/*
		 新建div
		 */
		function wd_user(data,id,obj){

			var hHead = "";
			hHead += '<thead>';
			hHead += '<tr>';
			hHead += '<th align="center">序号</th>';
			hHead += '<th align="center">材料号</th>';
			hHead += '<th align="center">名称</th>';
			hHead += '<th align="center">描述</th>';
			hHead += '<th align="center">刀具管理号</th>';
			hHead += '<th align="center">发出数量</th>';
			hHead += '<th align="center">累计返厂数量</th>';
			hHead += '<th align="center">最后返厂数量</th>';
			hHead += '<th align="center">备注</th>';
			hHead += '<th align="center">操作</th>';
			hHead += '</tr>';
			hHead += '</thead>';

			$('#roleEditForm').form('reset');
			var title = '新建通知单';
			$('#roleEditForm :input').removeClass('u-ipt-err');
			$('#roleEditForm').find("*").each(function () {
				if($(this).hasClass("u-sel")){
					$(this).removeAttr("style");
				}
			});
			if(typeof(data) == 'object'){
				$("#newTable").html("");
				var detailList = new Array();
				detailList = data.data;
				if(detailList.length >= 10){
					$("#editDiv").attr("style","height: 300px;overflow-y:scroll;");
					$("#editDiv").attr("class","g-fx1 f-fr");
				}else{
					$("#editDiv").removeAttr("style");
					$("#editDiv").removeAttr("class");
				}
				$("#outDoorNumH").val(detailList[0].outDoorNom);

				$(roleEditForm.no).val(detailList[0].outDoorNom);

				$("#no").attr("disabled","disabled");
				$(roleEditForm.merchants).val(detailList[0].merchants);
				$(roleEditForm.approver).val(detailList[0].approver);
				$(roleEditForm.sendUser).val(detailList[0].sendUser);
				$(roleEditForm.date).val(fdate5(detailList[0].manufactureDate));
				$(roleEditForm.merchants).val(detailList[0].merchantsID);

				$("#listSize").val(detailList.length);
				var html = '';
				for(var i = 0;i<detailList.length;i++){
					html += '<tr>';
					html += '<td class="t1" align="center">';
					html += (i+1);
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += '<input type="text" value="'+detailList[i].materialNum+'" name="materialNum" disabled="disabled"/>';
					html += '</td>';
					html += '<td class="t1">';
					html += '<input id="toolName'+detailList[i].outsideFactoryID+'" type="text" value="'+detailList[i].toolName+'"/>';
					html += '</td>';
					html += '<td class="t1">';
					html += '<input id="descr'+detailList[i].outsideFactoryID+'" type="text" value="'+detailList[i].descr+'"/>';
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += '<input type="text" value="'+detailList[i].laserCode+'" name="manageNo" disabled="disabled"/>';
					html += '</td>';
					html += '<td class="t1">';
					html += '<input id="numberGrinding'+detailList[i].outsideFactoryID+'" type="text" value="'+detailList[i].numberGrinding+'"/><input id="hNumberGrinding'+detailList[i].outsideFactoryID+'" type="hidden" value="'+detailList[i].numberGrinding+'"/>';
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].receiveNumber;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].lastBackNum;
					html += '</td>';
					html += '<td class="t1">';
					html += '<input id="note'+detailList[i].outsideFactoryID+'" type="text" value="'+detailList[i].note+'"/>';
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += "<a class='modify' onclick='return modify(\""+detailList[i].outsideFactoryID+"\",\""+detailList[i].numberGrinding+"\",\""+detailList[i].toolType+"\",\""+detailList[i].materialNum+"\",\""+detailList[i].laserCode+"\")'>修改</a>/<a onclick='return del(\""+detailList[i].outsideFactoryID+"\",\""+detailList[i].numberGrinding+"\",\""+detailList[i].toolType+"\",\""+detailList[i].materialNum+"\",\""+detailList[i].laserCode+"\")'>删除</a>";
					html += '</td>';
					html += '</tr>';
				}
				$("#newTable").append(hHead);
				$("#newTable").append(html);

				title = '编辑厂外修磨通知单';

				$("#addOrEdit").val("1");
				$("#export").show();
				$("#editDiv").show();
				$("#addTable").hide();
				$("#btnEdit").show();
				tt = 0;
			}else{
				$("#export").hide();
				$("#editDiv").hide();
				$("#addTable").show();
				$("#btnEdit").hide();
				no =  1;
				$("#addTable").html("");

				var hHtml = "";
				hHtml +=  '<tr>';
				hHtml +=	 '<td class="t1" align="center">';
				hHtml +=	 1;
				hHtml +=	 '</td>';
				hHtml +=	 '<td class="t1"><input type="text" id="materialNum'+no+'" name="materialNum"/></td>';
				hHtml +=	 '<td class="t1"><input type="text" id="name'+no+'"/></td>';
				hHtml +=	 '<td class="t1"><input type="text" id="desc'+no+'"/></td>';
				hHtml +=	 '<td class="t1"><input type="text" id="manageNo'+no+'" name="manageNo"/></td>';
				hHtml +=	 '<td class="t1"><input type="text" id="num'+no+'"/></td>';
				hHtml +=	 '<td class="t1"></td>';
				hHtml +=	 '<td class="t1"></td>';
				hHtml +=	 '<td class="t1"><input type="text" id="note'+no+'"/></td>';
				hHtml +=	 '<td class="t1" align="center"><a onclick="return add(this,no)">保存</a></td>';
				hHtml +=	 '</tr>';
				$("#addTable").append(hHead);
				$("#addTable").append(hHtml);
				title = '新建通知单';
				$("#no").removeAttr("disabled");
				$("#addOrEdit").val("0");
				$('#roleEditForm').attr('action','outFactoryAdd.action');
			}
			$.dialog({
				id:'roleEdit_dialog',
				title:title,
				lock: true,
				content:document.getElementById('roleEdit'),
				close:function(){
					$("#newTable").empty();
					$("#addTable").empty();
				},
			});
			return false;
		}

		function add(obj,id){

			if($("#no").val() == ""){
				alert("请输入单号");
				return;
			}
			if($("#merchants").val() == ""){
				alert("请选择厂家");
				return;
			}
			if($("#date").val() == ""){
				alert("请选择日期");
				return;
			}
			if($("#approver").val() == ""){
				alert("请输入申请人");
				return;
			}
			if($("#sendUser").val() == ""){
				alert("请输入邮寄人");
				return;
			}

//			alert(input.eq(0).val());
			var length = $(obj).parent().parent().parent().find(".modify").length;
			var tr = $(obj).closest('tr'),
			input = tr.find('input');

			if(input.eq(0).val() == ""){
				if(input.eq(2).val() == ""){
					alert("请输入描述");
					return;
				}
			}

			if(input.eq(3).val() != "" && input.eq(3).val() != null){
				var str = input.eq(3).val().replace("（","(").replace("）",")");
				input.eq(3).val(str);
			}

			// 2017/09/18 宋健 追加↓↓↓　dazhong@YMSC
//			if($("#addOrEdit").val() == "1"){
//				var sum = 0;
//				$("input[name='materialNum']").each(function(){
//					if(input.eq(0).val() == $(this).val()){
//						sum ++;
//					}
//				});
//				if(sum > 0){
//					alert("材料号不能相同");
//					return;
//				}
//
//			}else{
//				if(input.eq(3).val() == ""){  // 刀具管理号为空时
//					var materialNum = input.eq(0).val();
//					alert(materialNum);
//					var count = 0;
//					var numCount = 0;
//					// 刀具管理号遍历
//					$("input[name='manageNo']").each(function(){
//						alert(111);
//
//						var tr = $(this).closest('tr'), input = tr.find('input');
//						alert($(this).val());
//						alert(input.eq(0).val());
//						// 刀具管理号为空
//						if(($(this).val() == "") && (input.eq(0).val() != "")){
//							if(materialNum == input.eq(0).val()){
//								count ++;
//							}
//						}
//					});
//					alert(count);
//					// 当前行的材料号
//					var materialNum = input.eq(0).val();
//					if(count >= 2){
//						// 材料号遍历
//						$("input[name='materialNum']").each(function(){
//							if($(this).val() == materialNum){
//								numCount ++;
//							}
//						});
//					}
//					if(numCount >= 2){
//						alert("材料号不能相同");
//						return;
//					}
//				}
//			}
			var flg = true;
			var o={};
			var materialNums = "";
			$("input[name='materialNum']").each(function(){
				if($(this).parent().next().next().next().children().val() == "" ||
						$(this).parent().next().next().next().children().val() == null){
				    if($(this).val() != ""){
                        materialNums += $(this).val() + ",";
                    }

				}

			});

			if(materialNums != ""){
				materialNums = materialNums.substring(0,materialNums.length-1);
				var materialNumsArr = materialNums.split(",");
				for(var i = 0;i < materialNumsArr.length;i++){
					if(!(o[materialNumsArr[i]])){
						o[materialNumsArr[i]] = true;
					}else{

						flg = false;
						break;
					}
				}
				if(flg == false){
					alert("不可添加重复的非单品材料号，请编辑发出数量");
					return;
				}
			}

			// 2017/09/18 宋健 追加↑↑↑　dazhong@YMSC

			if(input.eq(4).val() == ""){
				alert("请输入发出数量");
				return;
			}
			if(input.eq(3).val() != ""){
				if(input.eq(4).val() != "1"){
					alert("发出数量只能为1");
					return;
				}
			}
			var param = {
				opt:'add',
				no:$("#no").val(),  // 单号
				merchants:$("#merchants").val(),  // 厂家
				date:$("#date").val(),  // 日期
				approver:$("#approver").val(),  // 申请人
				sendUser:$("#sendUser").val(),  // 邮寄人
				materialNum:input.eq(0).val(),  // 材料号
				name:input.eq(1).val(),  // 名称
				manageNo:input.eq(3).val(),  // 刀具管理号
				note:input.eq(5).val(),  // 备注
				desc:input.eq(2).val(),  // 描述
				num:input.eq(4).val(),  // 发出数量
				length:length
			}
			$.ajax({
				url:"outFactoryAdd.action",
				type: "post",
				data:param,
				dataType:"json",
				success:function(d){
					if(d.status < 0){
						artDialog(d.message,"OK");
					}else{
						//var outDoor = $("#outDoorNumH").val();
						var outDoorNum = $("#no").val();
//						if(outDoor == ""){
//							outDoorNum = $("#no").val();
////                            $.dialog.list['roleEdit_dialog'].close();
////							$('#list').grid('load');
//						}

						var param = {
							outDoorNum:outDoorNum,
							opt:'find'
						}
						$.ajax({
							url:"outInfo.action",
							type: "post",
							data:param,
							dataType:"json",
							success:function(d){
								if(d.status < 0){
									artDialog(d.message,"OK");
								}else{
									// TODO
									$.dialog.list['roleEdit_dialog'].close();
									$('#list').grid('load');
									wd_user(d,'','');
								}
								artDialog("操作成功!","OK");
							}
						});
					}
				}
			});

		};

		/* 修改出厂单详细 */
		function editOutInfo(){
			var param = {
				opt:"editOutInfo",
				outDoorNom:$("#no").val(),
				merchants:$("#merchants").val(),
				date:$("#date").val(),
				approver:$("#approver").val(),
				sendUser:$("#sendUser").val()
			}
			$.ajax({
				url:"outFactoryEdit.action",
				type: "post",
				data:param,
				dataType:"json",
				success:function(d){
					var res = d.message;
					var param = {
						outDoorNum:$("#no").val(),
						opt:'find'
					}
					$.ajax({
						url:"outInfo.action",
						type: "post",
						data:param,
						dataType:"json",
						success:function(d){
							if(d.status < 0){
								artDialog(d.message,"OK");
							}else{
								wd_user(d,'','');
							}
							artDialog(res,"OK");
						}
					});
				}
			});
		}

		/* 修改出厂单详细 */
		function modify(outsideFactoryID,numberGrinding,toolType,materialNum,laserCode){
			var param = {
				opt:"editOutDesc",
				outId:outsideFactoryID,
				toolName:$("#toolName"+outsideFactoryID).val(),
				descr:$("#descr"+outsideFactoryID).val(),
				numberGrinding:$("#numberGrinding"+outsideFactoryID).val(),
				hNumberGrinding:$("#hNumberGrinding"+outsideFactoryID).val(),
				note:$("#note"+outsideFactoryID).val(),
				toolType:toolType,
				materialNum:materialNum,
				laserCode:laserCode
			}
			$.ajax({
				url:"outFactoryEdit.action",
				type: "post",
				data:param,
				dataType:"json",
				success:function(d){
					var res = d.message;
					var param = {
						outDoorNum:$("#no").val(),
						opt:'find'
					}
					$.ajax({
						url:"outInfo.action",
						type: "post",
						data:param,
						dataType:"json",
						success:function(d){
							if(d.status < 0){
								artDialog(d.message,"OK");
							}else{
								wd_user(d,'','');
							}
							artDialog(res,"OK");
						}
					});
				}
			});
		}

		/* 删除 */
		function del(outsideFactoryID,numberGrinding,toolType,materialNum,laserCode){
			$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				var param = {
					outId:outsideFactoryID,
					numberGrinding:numberGrinding,
					toolType:toolType,
					materialNum:materialNum,
					laserCode:laserCode,
					opt:'item'
				}
				$.ajax({
					url:"outFactoryDel.action",
					type: "post",
					data:param,
					dataType:"json",
					success:function(d){
//						if(d.status >= 0){
//							$.dialog.list['roleEdit_dialog'].close();
//							$('#list').grid('load');
//						}
//						artDialog(d.message,"OK");
						var param = {
							outDoorNum:$("#no").val(),
							opt:'find'
						}
						$.ajax({
							url:"outInfo.action",
							type: "post",
							data:param,
							dataType:"json",
							success:function(d){
								if(d.status < 0){
									$.dialog.list['roleEdit_dialog'].close();
									$('#list').grid('load');
//									artDialog(d.message,"OK");
								}else{
									wd_user(d,'','');
								}
							}
						});
					}
				});
			});
		}

		/* 删除 */
		function delAll(outDoorNum,flag){
			$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				var param = {
					outDoorNum:outDoorNum,
					opt:flag
				}
				$.ajax({
					url:"outFactoryDel.action",
					type: "post",
					data:param,
					dataType:"json",
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
<div id="hiddDiv" style="display: none">
	<form action="exportExcel.action" method="post" id="hidFrom">
		<input type="hidden" name="noticeNo"  	 id="noticeNoHid">
		<input type="hidden" name="dateStar"     id="dateStarHid">
		<input type="hidden" name="dateEnd"  	 id="dateEndHid">
		<input type="hidden" name="dateHid"  	 id="dateHid">
		<input type="hidden" name="outstatus"    id="outstatusHid">
		<input type="hidden" name="grindingName" id="grindingNameHid">
		<input type="hidden" name="operator"	 id="operatorHid">
		<input type="hidden" name="numberGrinding"	 id="numberGrindingHid">
		<input type="hidden" name="outDoorNum"	 id="outDoorNumH">
	</form>
	<form action="exportExcelPrint09s007.action" method="post" id="hidPrintFrom">
		<input type="hidden" name="noticeNo"  	 id="noticeNoPrintHid">
		<input type="hidden" name="dateStar"     id="dateStarPrintHid">
		<input type="hidden" name="dateEnd"  	 id="dateEndPrintHid">
		<input type="hidden" name="outstatus"    id="outstatusPrintHid">
		<input type="hidden" name="grindingName" id="grindingNamePrintHid">
		<input type="hidden" name="operator"	 id="operatorPrintHid">
		<input type="hidden" name="numberGrinding"	 id="numberGrindingPrintHid">
		<input type="hidden" name="outReason"	 id="outReasonPrintHid">
	</form>
</div>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页：首页>刃磨涂层管理>出厂修磨查询</span>
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
						单号
					</th>
					<td>
						<input name="noticeNo" type="text" class="u-ipt" maxlength="20">
					</td>
					<th width="150">
						厂家
					</th>
					<td>
						<select class="u-sel"  name="grindingName" >
							<option value="">
								--请选择--
							</option>merchantsName
							<s:iterator value="#request.MerchantsesList" id="m">
								<option value="${m.merchantsID}">${m.merchantsName}</option>
							</s:iterator>
						</select>
					</td>
					<th width="100">
						日期
					</th>
					<td>
						<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
					</td>
				</tr>
				<tr>
					<th width="100">
						申请人
					</th>
					<td>
						<input name="approver" type="text" class="u-ipt" maxlength="8">
					</td>
					<th width="100">
						邮寄人
					</th>
					<td>
						<input name="sendUser" type="text" class="u-ipt" maxlength="50">
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
				<button type="button" class="u-btn2" onclick="return wd_user()">${sessionScope.lang.submitAddText}</button>
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
<%--导出通知单DIV--%>
<div id="printEdit" class="f-dn">
	<form id="printEditForm" name="printEditForm" method="post">
		<input type="text" class="f-dn" name="opt" value="add"/>
		<input name="DIVmaterialNums" type="hidden">
		<input name="DIVid" type="hidden">
		<input name="DIVnumberGrindings" type="hidden">
		<input name="DIVtypes" type="hidden">


		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					出门原因
				</th>
				<td>
					<select class="u-sel" name="outReason">
						<option value="涂层">涂层</option>
						<option value="修磨">修磨</option>
						<option value="返厂修理">返厂修理</option>
						<option value="返厂索赔">返厂索赔</option>
						<option value="借用返回">借用返回</option>
					</select>
				</td>
			</tr>
		</table>
	</form>
</div>
<%--新建通知单DIV--%>
<div id="roleEdit" class="f-dn">
	<form id="roleEditForm" name="roleEditForm" method="post">
		<input type="text" class="f-dn" name="opt" value="add"/>
		<input name="DIVmaterialNums" type="hidden">
		<input name="DIVid" type="hidden">
		<input name="DIVnumberGrindings" type="hidden">
		<input name="DIVtypes" type="hidden">

		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					单号
				</th>
				<td>
					<input id="no" type="text" class="u-ipt"/>
					<input id="outNo" type="hidden" class="u-ipt"/>
					<input name="orderNum" type="hidden" class="u-ipt"/>
				</td>
				<th width="150">
					厂家
				</th>
				<td>
					<select class="u-sel"  id="merchants" >
						<option value="">
							--请选择--
						</option>merchantsName
						<s:iterator value="#request.MerchantsesList" id="m">
							<option value="${m.merchantsID}">${m.merchantsName}</option>
						</s:iterator>
					</select>
				</td>
				<th width="100">
					日期
				</th>
				<td>
					<input id="date" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
				</td>
			</tr>
			<tr>
				<th width="100">
					申请人
				</th>
				<td>
					<input id="approver" type="text" class="u-ipt" maxlength="8">
				</td>
				<th width="100">
					邮寄人
				</th>
				<td>
					<input id="sendUser" type="text" class="u-ipt" maxlength="50">
				</td>
			</tr>
		</table>
		<div>
			<button type="button" class="u-btn2" id="btnEdit" style="float:left;" onclick="editOutInfo()">修改</button>
		</div>
		<div class="g-fx1 f-fr">
			<button type="button" class="u-btn2" id="btn1">添加</button>
			<button type="button" class="u-btn2" id="export">导出</button>
		</div>
		<br>
		<br>
		<div id="editDiv">
			<table class="m-frmtb" width="100%" id="newTable">
			</table>
		</div>
		<table class="m-frmtb" width="100%" id="addTable" style="display: none;">
		</table>
		<input type="hidden" name="addOrEdit" id="addOrEdit">
		<input type="hidden" name="listSize" id="listSize">
	</form>
</div>
</body>
<!-- 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC -->
</html>