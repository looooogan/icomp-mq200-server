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
					barid: '#bar',
					datatype: 'json',
					type:'post',
					width:'100%',
					fit:true,
					lazy:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'材料号',
						name:'toolCode'
					},{
						title:'时间段',
						name:'authorizedTime',
					format: function (r) {
						return '<span class="ui-grid-tdtx">' + fdate4(r.authorizedTime) + '</span>';
					}
					},{
						title:'授权人',
						name:'authorizationUser'
					},{
						title:'原因',
						name:'authorizedReason',
////					授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
					format:function(r) {
						if (r.authorizedReason == 0) {return '<span class="ui-grid-tdtx">断刀</span>';}
						else if (r.authorizedReason == 1) {return '<span class="ui-grid-tdtx">丢失</span>';}
						else if (r.authorizedReason == 2) {return '<span class="ui-grid-tdtx">补领</span>';}
						else if (r.authorizedReason == 3) {return '<span class="ui-grid-tdtx">到寿</span>';}
						else if (r.authorizedReason == 4) {return '<span class="ui-grid-tdtx">卸下后安上</span>';}
						else if (r.authorizedReason == 5) {return '<span class="ui-grid-tdtx">重复换装</span>';}
						else if (r.authorizedReason == 6) {return '<span class="ui-grid-tdtx">重复复磨</span>';}
						else if (r.authorizedReason == 7) {return '<span class="ui-grid-tdtx">重复初始化设备</span>';}
						else if (r.authorizedReason == 8) {return '<span class="ui-grid-tdtx">库存盘点</span>';}
						else if (r.authorizedReason == 9) {return '<span class="ui-grid-tdtx">出库报废</span>';}
						else if (r.authorizedReason == 11) {return '<span class="ui-grid-tdtx">刀具报废</span>';}
						else if (r.authorizedReason == 12) {return '<span class="ui-grid-tdtx">刀具分拣</span>';}
						//2017/08/14 王冉 追加↓↓↓　dazhong@YMSC
						else if (r.authorizedReason == 13) {return '<span class="ui-grid-tdtx">重复组装拆分</span>';}
						//2017/08/14 王冉 追加↑↑↑　dazhong@YMSC
						else{return '<span class="ui-grid-tdtx">其他</span>';}
						return '<span class="ui-grid-tdtx"></span>';
					}
					},{
						title:'刀具当前状态',
						name:'businessCode',
				//	刀具状态（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其它）
//					format:function(r){
//						if (r.toolReason == 0) {return '<span class="ui-grid-tdtx">单品刀</span>';}
//						else if (r.toolReason == 1) {return '<span class="ui-grid-tdtx">合成刀</span>';}
//						else if (r.toolReason == 2) {return '<span class="ui-grid-tdtx">其他</span>';}
//
//
//						return '<span class="ui-grid-tdtx"></span>';
//					}
					},{
						title:'操作流程内容',
						name:'businessCode'
					}, {
						title:'操作者',
						name:'operator'
					},{
						title:'情况简述',
						name:'note'

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
					},

			}) ;
			});

			$(function(){
				/**
				* 库存异常报警查询 改 （授权记录查询）
				*/
				$("#knifeinventorySubmit").click(function(){
					var param = {
							opt:'list',
						authorizedReason:$(knifeinventoryForm.authorizedReason).val(),
						systeCode:$(knifeinventoryForm.systeCode).val(),
						dstar:$(knifeinventoryForm.dstar).val(),
						dend:$(knifeinventoryForm.dend).val(),
						authorizationName:$(knifeinventoryForm.authorizationName).val(),
						OperationConten:$(knifeinventoryForm.OperationConten).val(),
						SituationBrief:$(knifeinventoryForm.SituationBrief).val(),

						}
						$('#list').grid('url','B01S012.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});

				//导出
				$("#authorizedOut").click(function () {

					$.dialog.confirm('您确定要导出么？', function (){
						$("#authorizedReasonHid").val($(knifeinventoryForm.authorizedReason).val());
						$("#dateStarHid").val($(knifeinventoryForm.dstar).val());
						$("#dateEndHid").val($(knifeinventoryForm.dend).val());
						$("#systeCodeHid").val($(knifeinventoryForm.systeCode).val());
						$("#operationContenHid").val($(knifeinventoryForm.OperationConten).val());
						$("#authorizationNameHid").val($(knifeinventoryForm.authorizationName).val());
						$("#situationBriefHid").val($(knifeinventoryForm.SituationBrief).val());

						$("#hidFrom").submit();
					});

				});
			});

		</script>
	</head>
	<body>
	<div id="hiddDiv" style="display: none">
		<form action="exportExcel01S012.action" method="post" id="hidFrom">
			<input type="hidden" name="authorizedReason" id="authorizedReasonHid">
			<input type="hidden" name="dateStar"         id="dateStarHid">
			<input type="hidden" name="dateEnd"          id="dateEndHid">
			<input type="hidden" name="systeCode"        id="systeCodeHid">
			<input type="hidden" name="operationConten"  id="operationContenHid">
			<input type="hidden" name="authorizationName"id="authorizationNameHid">
			<input type="hidden" name="situationBrief"   id="situationBriefHid">
		</form>
	</div>
		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>当前页：首页>库存信息>授权记录查询</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="knifeinventoryForm" name="knifeinventoryForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th>
								原因
								<%--授权原因（0断刀,1丢刀,2补领,3到寿,4卸下后安上,5重复换装,6重复复磨,7重复初始化设备,8库存盘点,9出库报废，10其他）--%>
							</th>
							<td>
								<select class="u-sel" name="authorizedReason" maxlength="16">
									<option value="">
										--请选择--
									</option>

									<option value="0">
										断刀
									</option>

									<option value="1">
										丢刀
									</option>

									<option value="2">
										补领
									</option>

									<option value="3">
										到寿
									</option>
									<option value="4">
										卸下后安上
									</option>
									<option value="5">
										重复换装
									</option>
									<option value="6">
										重复复磨
									</option>
									<option value="7">
										重复初始化设备
									</option>
									<option value="8">
										库存盘点
									</option>
									<option value="9">
										出库报废
									</option>
									<option value="11">
										刀具报废
									</option>
									<option value="12">
										刀具分拣
									</option>

								</select>
							</td>
							<th width="150">
								材料号
							</th>
							<td>
								<input name="systeCode" type="text" class="u-ipt"  maxlength="16">
							</td>
							<th width="150">
								时间段
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
						</tr>
						<tr>
							<th width="100">
							授权人
						</th>
							<td>
								<input name="authorizationName" type="text" class="u-ipt"  maxlength="16">
							</td>
							<th width="100">
								操作流程内容
							</th>
							<td>
								<select class="u-sel" name="OperationConten" maxlength="16">
									<option value="">--${sessionScope.lang.PleaseSelect}--</option>
									<option value="C01S001">新刀入库</option>
									<option value="C01S003">换领出库</option>
									<option value="C01S004">补领出库</option>
									<option value="C01S005">刀具报废</option>
									<option value="C01S010">刀具换装</option>
									<option value="C01S011">设备安上</option>
									<option value="C01S013">设备卸下</option>
									<option value="C01S014">刀具分拣</option>
									<option value="C01S016">回库处理</option>
									<option value="C01S018">刀具修磨</option>
									<option value="C01S019">刀具绑定</option>
									<option value="C01S020">回厂入库</option>
									<option value="C01S024">快速查询</option>
									<option value="C01S027">刀具送回</option>
									<option value="C03S001">初始化</option>
									<option value="C04S001">库房盘点</option>

								</select>
							</td>
							<th width="100">
								情况简述(模糊查询)
							</th>
							<td>
								<input name="SituationBrief" type="text" class="u-ipt"  maxlength="16">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="knifeinventorySubmit" >${sessionScope.lang.submitSearchText}</button>
						<button type="button" class="u-btn2" id="authorizedOut">导出</button></div>
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
	</body>
</html>

