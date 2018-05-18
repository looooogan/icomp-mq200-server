<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp"%>
	<style>
		.t1{ border:1px solid #8797aa; }
	</style>
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

			// 2017/08/21 宋健 变更↓↓↓　dazhong@YMSC
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
					title:'通知单号',
					width:'180px',
					name:'orderNum'
				},{
					title:'修磨厂家名称',
					width:'150px',
					name:'merchantsID'
				},{
					title:'材料号',
					width:'80px',
					name:'materialNum'
				},{
					title:'入库日期',
					width:'95px',
					name:'updateTime',
					format: function (r) {
						return '<span class="ui-grid-tdtx">' + fdate1(r.updateTime) + '</span>';
					}
				},{
					title:'回厂数量',
					width:'80px',
					name:'backFactoryNumber'
				},{
					title:'修复类型',
					width:'80px',
					name:'grindingType',
					format: function (r) {
						if(r.grindingType == '0'){
							return '<span class="ui-grid-tdtx">厂外涂层</span>';
						}
						return '<span class="ui-grid-tdtx">厂外复磨</span>';
					}
				},{
					title:'激光码',
					name:'laserCode'
				},{
					title:'刀具类型',
					width:'80px',
					name:'toolType',
					format: function (r) {
						if(r.toolType == 0){
							return '<span class="ui-grid-tdtx">钻头</span>';
						}
						return '<span class="ui-grid-tdtx">刀片</span>';
					}
				},{
					title:'出门单号',
					width:'80px',
					name:'outDoorNom'
				},{
					title:'审批人',
					width:'62px',
					name:'approver'
				},{
					title:'操作',
					name:'详细',
					width:'48px',
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
			// 2017/08/21 宋健 变更↑↑↑　dazhong@YMSC
		});
		function option(r){
			var $ul = $('<ul class="u-option"></ul>');
			var $li = $('');
			var ary_li = new Array();
			ary_li.push($('<li><a href="javascript:void(0)">详细</a></li>').click(function(){edit(r.orderNum, r.repairState,'',this)}));
			<%--ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.merchantsID,this)}));--%>
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}

		//编辑 调出编辑div
		function  edit(id,re,version,obj){
			var param = {
				orderNum:id,
				outre:re,
				opt:'detail',
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

		//			function  outTimetype(){
		//				var  aa= $("#DIVtype").val();
		//				if (aa==0){
		//					$("#outTimeF").show();
		//					$("#outTimeF1").hide();
		//				}else{
		//					$("#outTimeF").show();
		//					$("#outTimeF1").show();
		//				}
		//			}







		$(function(){
			/**
			 * （厂外）修复通知单查询
			 */

			$("#searchSubmit").click(function(){
				var param = {
					opt:'list',
					noticeNo:$(searchForm.noticeNo).val(),
					// 2017/08/25 宋健 变更↓↓↓　dazhong@YMSC
//					outstatus:$(searchForm.outstatus).val(),
					// 2017/08/25 宋健 变更↑↑↑　dazhong@YMSC
					grindingName:$(searchForm.grindingName).val(),
					materialNum:$(searchForm.materialNum).val(),
					outDoorNom:$(searchForm.outDoorNom).val(),
					dateStar:$(searchForm.dstar).val(),
					dateEnd:$(searchForm.dend).val(),
				}
				$('#list').grid('url','B09S008.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});

			//导出
			$("#outstatusOut").click(function () {
				$.dialog.confirm('您确定要导出么？', function () {
					$("#noticeNoHid").val($(searchForm.noticeNo).val());
					$("#dateStarHid").val($(searchForm.dstar).val());
					$("#dateEndHid").val($(searchForm.dend).val());
					$("#outstatusHid").val($(searchForm.outstatus).val());
					$("#grindingNameHid").val($(searchForm.grindingName).val());
					$("#operatorHid").val($(searchForm.operator).val());
					$("#numberGrindingHid").val($(printEditForm.DIVnumberGrinding).val());
					$("#materialNumHid").val($(printEditForm.materialNum).val());
					$("#hidFrom").submit();
				});

			});

			/* 			//导出打印版
			 $("#outstatusOutPrint").click(function () {
			 $.dialog.confirm('您确定要导出么？', function () {
			 $("#noticeNoPrintHid").val($(searchForm.noticeNo).val());
			 $("#dateStarPrintHid").val($(searchForm.dstar).val());
			 $("#dateEndPrintHid").val($(searchForm.dend).val());
			 $("#outstatusPrintHid").val($(searchForm.outstatus).val());
			 $("#grindingNamePrintHid").val($(searchForm.grindingName).val());
			 $("#operatorPrintHid").val($(searchForm.operator).val());
			 $("#numberGrindingPrintHid").val($(roleEditForm.DIVnumberGrinding).val());
			 $("#materialNumPrintHid").val($(roleEditForm.materialNum).val());
			 $("#hidPrintFrom").submit();
			 });

			 }); */
		});
		/*
		 出门原因
		 */
		function wd_print(data,id,obj){
			$('#printEditForm').form('reset');
			var title = '选择出门原因';
			$('#printEditForm :input').removeClass('u-ipt-err');
			$('#printEditForm').find("*").each(function () {
				if($(this).hasClass("u-sel")){
					$(this).removeAttr("style");
				}
			});
			$('#printEditForm').attr('action','outFactoryAdd.action');
			$.dialog({
				id:'roleEdit_dialog',
				title:title,
				lock: true,
				content:document.getElementById('printEdit'),
				button:[{
					name:'确定',
					focus:true,
					callback:function(){
						$("#noticeNoPrintHid").val($(searchForm.noticeNo).val());
						$("#dateStarPrintHid").val($(searchForm.dstar).val());
						$("#dateEndPrintHid").val($(searchForm.dend).val());
						$("#outstatusPrintHid").val($(searchForm.outstatus).val());
						$("#grindingNamePrintHid").val($(searchForm.grindingName).val());
						$("#operatorPrintHid").val($(searchForm.operator).val());
						$("#numberGrindingPrintHid").val($(printEditForm.DIVnumberGrinding).val());
						$("#materialNumPrintHid").val($(printEditForm.materialNum).val());
						$("#outReasonPrintHid").val($(printEditForm.outReason).val());
						$.dialog.list['roleEdit_dialog'].close();
						$('#hidPrintFrom').form('submit',{
							//此方法貌似走不到
							success:function(d){
								alert (d);
								artDialog("导出成功！","OK");
							}
						});

						//$("#hidPrintFrom").submit();
						return false;
					}
				}]
			});
			return false;
		}

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
				var detailList = new Array();
				detailList = data.data;
				var html = '';
				for(var i = 0;i<detailList.length;i++){
					html += '<tr>';
					html += '<td class="t1" align="center">';
					html += detailList[i].toolID;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].materialNum;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].backFactoryNumber;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += fdate(detailList[i].createTime);
					html += '</td>';
					html += '</tr>';
				}
				$("#newTable").append(html);
				$(roleEditForm.opt).val('edit');

				// 页面赋值

				$(roleEditForm.DIVid).val(data.data.outsideFactoryID);//id
				$(roleEditForm.DIVorderNums).val(data.data.orderNum);//订单号
				$(roleEditForm.DIVorderNum).val(data.data.orderNum);//订单号

				$(roleEditForm.DIVmaterialNum).val(data.data.materialNum);//材料号
				$(roleEditForm.DIVmaterialNums).val(data.data.materialNum);//材料号

				$(roleEditForm.DIVmerchantsID).val(data.data.merchantsID);//商家名称
				$(roleEditForm.DIVmerchantsID).val(data.data.merchantsID);//


				$(roleEditForm.DIVnumberGrinding).val(data.data.numberGrinding);//修磨数量
				$(roleEditForm.DIVnumberGrindings).val(data.data.numberGrinding);//修磨数量

				$(roleEditForm.DIVgrindingType).val(data.data.grindingType);//修磨类型


				$(roleEditForm.DIVtype).val(data.data.repairState);//修磨状态
				$(roleEditForm.DIVtypes).val(data.data.repairState);//修磨状态

				$(roleEditForm.DIVmanufactureDate).val(data.data.manufactureDate);//出厂时间




				$(roleEditForm.DIVapprover).val(data.data.approver);//审批人


				$(roleEditForm.DIVnote).val(data.data.note);//备注
				$('#roleEditForm').attr('action','outFactoryEdit.action');

				$(roleEditForm.DIVmaterialNum).attr("disabled","true");
				$(roleEditForm.DIVnumberGrinding).attr("disabled","true");


				title = '详细';

			}else{

				$('#roleEditForm').attr('action','outFactoryAdd.action');
			}
			$.dialog({
				id:'roleEdit_dialog',
				title:title,
				lock: true,
				content:document.getElementById('roleEdit')
//				button:[{
//					name:'保存',
//					focus:true,
//					callback:function(){
//						$(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
//						$(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
//						$('#roleEditForm').form('submit',{
//							success:function(d){
//								$('#roleEditForm :input').removeClass('u-ipt-err');
//								$('#roleEditForm').find("*").each(function () {
//									if($(this).hasClass("u-sel")){
//										$(this).removeAttr("style");
//									}
//								});
//								if($.parseJSON(d).status >= 0){
//									var param = {
////											opt:'list',
////											AgencyID:$(roleForm.AgencyID).val(),
////											DepartmentID:$(roleForm.DepartmentID).val(),
////											PositionID:$(roleForm.PositionID).val(),
////											DelFlag:$(roleForm.DelFlag).val()
//									}
//									$('#list').grid('url','B09S008.action');
//									$('#list').grid('data',param);
//
//									if($(roleEditForm.opt).val()!='edit'){
//										$('#list').grid('load',1);
//									}else{
//										$('#list').grid('load');
//									}
//									artDialog($.parseJSON(d).message,"OK");
//									$.dialog.list['roleEdit_dialog'].close();
//								} else if($.parseJSON(d).status == -1){
//									artDialog(d.message,"OK");
//								}else {
//									artDialog(setContorllBackColor($('#roleEditForm'),$.parseJSON(d).message),"OK");
//								}
//							}
//						});
//						return false;
//					}
//				}]
			});
			return false;
		}

	</script>
</head>
<body>
<div id="hiddDiv" style="display: none">
	<form action="exportExcel03S002.action" method="post" id="hidFrom">
		<input type="hidden" name="noticeNo"  	 id="noticeNoHid">
		<input type="hidden" name="dateStar"     id="dateStarHid">
		<input type="hidden" name="dateEnd"  	 id="dateEndHid">
		<input type="hidden" name="outstatus"    id="outstatusHid">
		<input type="hidden" name="grindingName" id="grindingNameHid">
		<input type="hidden" name="operator"	 id="operatorHid">
		<input type="hidden" name="numberGrinding"	 id="numberGrindingHid">
		<input type="hidden" name="materialNum"	 id="materialNumHid">
	</form>
	<form action="exportExcelPrint03S002.action" method="post" id="hidPrintFrom">
		<input type="hidden" name="noticeNo"  	 id="noticeNoPrintHid">
		<input type="hidden" name="dateStar"     id="dateStarPrintHid">
		<input type="hidden" name="dateEnd"  	 id="dateEndPrintHid">
		<input type="hidden" name="outstatus"    id="outstatusPrintHid">
		<input type="hidden" name="grindingName" id="grindingNamePrintHid">
		<input type="hidden" name="operator"	 id="operatorPrintHid">
		<input type="hidden" name="numberGrinding"	 id="numberGrindingPrintHid">
		<input type="hidden" name="outReason"	 id="outReasonPrintHid">
		<input type="hidden" name="materialNum"	 id="materialNumPrintHid">
	</form>
</div>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页：首页>基础数据管理>回厂入库查询</span>
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
						通知单号
					</th>
					<td>
						<input name="noticeNo" type="text" class="u-ipt" maxlength="20">
					</td>
					<%--<th width="150">--%>
					<%--状态--%>
					<%--</th>--%>
					<%--<td>--%>

					<%--<select class="u-sel"  name="outstatus" >--%>
					<%--<option value="">--%>
					<%----请选择----%>
					<%--</option>--%>
					<%--<option value="0">待出厂</option>--%>
					<%--<option value="1">已出厂</option>--%>
					<%--<option value="2">已送回</option>--%>
					<%--</select>--%>
					<%--</td>--%>
					<th width="150">
						修磨厂家名称
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
				</tr>
				<tr>
					<th width="100">
						时间段
					</th>
					<td>
						<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
						<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
					</td>
					<th width="100">
						材料号
					</th>
					<td>
						<input name="materialNum" type="text" class="u-ipt" maxlength="8">
					</td>
					<th width="100">
						出门单号
					</th>
					<td>
						<input name="outDoorNom" type="text" class="u-ipt" maxlength="50">
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
				<%--<button type="button" class="u-btn2" id="outstatusOut">导出</button>--%>
				<%--<button type="button" class="u-btn2" id="outstatusOutPrint"  onclick="return wd_print()">打印</button>--%>
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


		<table class="m-frmtb" width="100%" id="newTable">
			<tr>
				<th width="150" align="center">
					刀具ID
				</th>
				<th width="150" align="center">
					材料号
				</th>
				<th width="150" align="center">
					回厂数量
				</th>
				<th width="150" align="center">
					回厂时间
				</th>
			</tr>
		</table>
	</form>
</div>
</body>
</html>

