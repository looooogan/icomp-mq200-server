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
					name:'systeCode'
				},{
					title:'刃磨时间',
					name:'noticeTime',
					format:function(r){
						return '<span class="ui-grid-tdtx">'+fdate(r.noticeTime)+'</span>';
					}
				},
					<!-- 2017/09/1 宋健 变更↓↓↓　dazhong@YMSC -->
//					{
//						title:'刃磨设备编号',
//						name:'equipmentCode'
//					},
					<!-- 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC -->
					{
						title:'刃磨数量',
						name:'noticeCount'
					},{
						title:'刃磨后状态',
						name:'repairedBecause',
						format:function(t){
							//0 正常1报废
							if(t.repairedBecause == 0 ){return '<span class="ui-grid-tdtx">正常</span>';}
							else if(t.repairedBecause == 1 ){return '<span class="ui-grid-tdtx">报废</span>';}
							return '<span class="ui-grid-tdtx"></span>';
						}
					},{
						title:'操作者',
						name:'repairID'
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

		$(function(){
			/**
			 * （厂内）刃磨记录查询
			 */
			$("#searchSubmit").click(function(){

				var param = {
					opt:'list',
					//ToolConsumetype:$(searchForm.ToolConsumetype).val(),
					systeCode:$(searchForm.systeCode).val(),
					grindingCode:$(searchForm.grindingCode).val(),//刃磨设备编码
					DateStar:$(searchForm.dstar).val(),
					DateEnd:$(searchForm.dend).val(),
					grindingStatus:$(searchForm.grindingStatus).val(),//刃磨后状态
					operator:$(searchForm.operator).val(),//操作者


				}
				$('#list').grid('url','B03S001.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});

			//导出
			$("#infoExport").click(function () {
				$.dialog.confirm('您确定要导出么？', function (){

					//$("#toolConsumetypeHid").val($(searchForm.ToolConsumetype).val());
					$("#dateStarHid").val($(searchForm.dstar).val());
					$("#dateEndHid").val($(searchForm.dend).val());
					$("#systeCodeHid").val($(searchForm.systeCode).val());
					$("#grindingStatusHid").val($(searchForm.grindingStatus).val());
					$("#grindingCodeHid").val($(searchForm.grindingCode).val());

					$("#operatorHid").val($(searchForm.operator).val());

					$("#hidFrom").submit();
				});

			});

		});
	</script>
</head>
<body>
<div id="hiddDiv" style="display: none">
	<form action="exportExcel03S001.action" method="post" id="hidFrom">

		<input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
		<input type="hidden" name="dateStar"        id="dateStarHid">
		<input type="hidden" name="dateEnd"    		id="dateEndHid">
		<input type="hidden" name="systeCode"		 id="systeCodeHid">
		<input type="hidden" name="grindingStatus"	 id="grindingStatusHid">
		<input type="hidden" name="operator" 		id="operatorHid">
		<input type="hidden" name="grindingCode" 		id="grindingCodeHid">

	</form>
</div>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页：首页>刃磨及涂层管理>厂内刃磨记录查询</span>
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
					<th width="100">
						材料号
					</th>
					<td>
						<input name="systeCode" type="text" class="u-ipt" maxlength="50">
					</td>
					<th width="100">
						时间段
					</th>
					<td>
						<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
						<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
					</td>
					<!-- 2017/09/1 宋健 变更↓↓↓　dazhong@YMSC -->
					<%--<th width="100">--%>
					<%--刃磨设备编码--%>
					<%--</th>--%>
					<%--<td>--%>
					<%--<input name="grindingCode" type="text" class="u-ipt" maxlength="50">--%>
					<%--</td>--%>
				</tr>
				<tr>

					<th>
						刃磨后状态
					</th>
					<td>
						<select class="u-sel" name="grindingStatus" maxlength="16">
							<option value="">
								--请选择--
							</option>
							<option value="0">正常</option>
							<option value="1">报废</option>

						</select>
					</td>
					<th width="100">
						操作者
					</th>
					<td>
						<input name="operator" type="text" class="u-ipt" maxlength="50">
					</td>

				</tr>
				<!-- 2017/09/1 宋健 变更↑↑↑　dazhong@YMSC -->
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="searchSubmit">查询</button>

				<button type="button" class="u-btn2" id="infoExport">导出</button>
			</div>
		</form>
		<div class="f-cb"></div>

		<div class="u-ptt">
			<div style="float:left;">${sessionScope.lang.searchList}</div>
			<div style="float:right;">
				共：<span id="number1"></span>&nbsp;条
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

