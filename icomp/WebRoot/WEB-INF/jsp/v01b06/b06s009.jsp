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
				column:[
//						{
//					title:'刀具类型',
//					name:'toolType'
//				},
					{
					title:'材料号',
					name:'toolCode'
				},{
					title:'单次/元',
					name:'unitPrice'
				},{
					title:'消耗次数',
					name:'userNumber'
				},{
					title:'摊销成本(人民币)/万元',
					name:'amortizationRMB'
				}],
				<%--{--%>
				<%--title:'${session.lang.ConsumptionCostsText}',--%>
				<%--name:'price',--%>
				<%--visible:'${session.gridcol.totalAmount}',--%>
				<%--format:function(r){--%>
				<%--if(r.processAmount>0 ){--%>
				<%--return '<span class="ui-grid-tdtx">'+(r.price/r.processAmount).toFixed(2)+'</span>';--%>
				<%--}else{--%>
				<%--return '<span class="ui-grid-tdtx">${session.lang.NoCompleteOutputComponentsHaveConsumed}'+r.price.toFixed(2)+'</span>';--%>
				<%--}--%>
				<%--}--%>

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
		 * 数值验证
		 **/

//			function validate(){
//				var reg = new RegExp("^[0-9]*$");
//				var syi = document.getElementById("yield").value;
//				if(!reg.test(syi)){
//					alert("fffffffffffff");
//					return false;
//				}
//
//			}

		$(function(){


			/**
			 * 数值验证
			 **/
//				$("#yield").blur(function(){
//					var reg = new RegExp("^[0-9]*$");
//					var syi =$("#yield").val();
//					if (!reg.test(syi)){
//						alert("5555555");
//						return false;
//					}
//				})



			/**
			 * 成本摊销
			 */
			$("#submitSearch").click(function(){

				var reg = new RegExp("^[0-9]*$");
				var syi =$("#yield").val();
				if (reg.test(syi)){
					var param = {
						opt:'list',
						//toolConsumetype:$(searchForm.ToolConsumetype).val(),
						systeCode:$(searchForm.systeCode).val(),
						dstar:$(searchForm.dstar).val(),
						dend:$(searchForm.dend).val(),
						yield:$(searchForm.Yield).val(),
						spareParts:$(searchForm.spareParts).val(),
						type:$(searchForm.type).val(),
					}
					$('#list').grid('url','B06S009.action');
					$('#list').grid('data',param);
					$('#list').grid('load',1);
					return false;

				}else{
					alert("产量请填写数字");
				}
			});

			$("#type").change(function () {
				if($(this).val() == '1'){
					$("#th_lines").hide();
					$("#lines").hide();
					$("#th_spareParts").hide();
					$("#spareParts").hide();
				}else{
					$("#th_lines").show();
					$("#lines").show();
					$("#th_spareParts").show();
					$("#spareParts").show();
				}

			})
			/**
			 * 生产线下拉选
			 */
			$ ("#lines").change (function () {
				$("#spareParts").empty();
				var param = {
					AssemblyLineID: $ ("#lines").val () //生产线ID
				}
				$.ajax ({
					type: "POST",
					url: "getPartsById.action",
					data: param,
					success:function (data) {
						var obj = eval('(' + data + ')');
						var toption_next = "";
						if(obj.length == 0){
							toption_next += "<option value=''>--请选择--</option>";
						}else{
							for(var i = 0,l=obj.length;i<l;i++){
								toption_next += "<option value='"+obj[i].partsID+"'>"+obj[i].partsName+"</option>";
							}
						}

						$("#spareParts").append(toption_next);

					}
				});
			});
			//导出
			$("#infoExport").click(function () {
				$.dialog.confirm('您确定要导出么？', function (){

					//$("#toolConsumetypeHid").val($(searchForm.ToolConsumetype).val());
					$("#systeCodeHid").val($(searchForm.systeCode).val());
					$("#dateStarHid").val($(searchForm.dstar).val());
					$("#dateEndHid").val($(searchForm.dend).val());
					$("#yieldHid").val($(searchForm.Yield).val());
					$("#sparePartsHid").val($(searchForm.spareParts).val());


					$("#hidFrom").submit();
				});

			});

		});
	</script>
</head>
<body>
<div id="hiddDiv" style="display: none">
	<form action="exportExcel06S009.action" method="post" id="hidFrom">
		<input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
		<input type="hidden" name="systeCode" id="systeCodeHid">
		<input type="hidden" name="dateStar"        id="dateStarHid">
		<input type="hidden" name="dateEnd"    		id="dateEndHid">
		<input type="hidden" name="yield"		 id="yieldHid">
		<input type="hidden" name="spareParts"		 id="sparePartsHid">
	</form>
</div>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.DecisionAnalysisText}&gt;${sessionScope.lang.AmortizedCostText}</span>
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
					<%--<th>--%>
						<%--刀具类型--%>
					<%--</th>--%>
					<%--<td>--%>
						<%--<select class="u-sel" name="ToolConsumetype" maxlength="16">--%>
							<%--<option value="">--%>
								<%----请选择----%>
							<%--</option>--%>

							<%--<option value="A">--%>
								<%--A--%>
							<%--</option>--%>

							<%--<option value="B">--%>
								<%--B--%>
							<%--</option>--%>

							<%--<option value="C">--%>
								<%--C--%>
							<%--</option>--%>

							<%--<option value="D">--%>
								<%--D--%>
							<%--</option>--%>

							<%--<option value="E">--%>
								<%--E--%>
							<%--</option>--%>
							<%--<option value="F">--%>
								<%--F--%>
							<%--</option>--%>
							<%--<option value="G">--%>
								<%--G--%>
							<%--</option>--%>
							<%--<option value="H">--%>
								<%--H--%>
							<%--</option>--%>
							<%--<option value="I">--%>
								<%--I--%>
							<%--</option>--%>

							<%--<option value="S">--%>
								<%--S--%>
							<%--</option>--%>

						<%--</select>--%>
					<%--</td>--%>
					<th width="150">
						材料号
					</th>
					<td>
						<input name="systeCode" type="text" class="u-ipt" maxlength="50">
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
					<th width="150">
						摊销方式
					</th>
					<td>
						<select class="u-sel" id="type" name="type" maxlength="16">
							<option value="0">加工摊销</option>
							<option value="1">出入库摊销</option>
						</select>
					</td>


					<!-- 2017/07/03 宋健 追加↓↓↓　dazhong@YMSC -->
					<th width="100" id="th_lines">
						生产线
					</th>
					<td>
						<select class="u-sel" id="lines" name="lines" maxlength="16">
							<option value="">整机</option>
							<s:iterator value="#request.AssemblyLineList" id="al">
								<option value="${al.assemblyLineID}">${al.assemblyLineName}</option>
							</s:iterator>

						</select>
					</td>
					<!-- 2017/07/03 宋健 追加↑↑↑　dazhong@YMSC -->

					<th id="th_spareParts">
						零部件
					</th>
					<td>
						<select class="u-sel" id="spareParts" name="spareParts" maxlength="16">
							<option value="">--${sessionScope.lang.PleaseSelect}--</option>
							<%--<s:iterator value="#request.PartsList" id="parts">--%>
							<%--<option value="${parts.partsID}">${parts.partsName}</option>--%>
							<%--</s:iterator>--%>

						</select>
					</td>
				</tr>
				<tr>
					<th width="150">
						产量（必填）
					</th>
					<td>
						<input name="Yield" type="text" class="u-ipt" maxlength="50" id="yield" >
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="submit" class="u-btn2" id="submitSearch"  >${sessionScope.lang.submitSearchText}</button>
				<button type="button" class="u-btn2" id="infoExport" >导出</button>
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
</body>
</html>

