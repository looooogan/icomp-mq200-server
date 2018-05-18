<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="../common/header_common.jsp" %>
	<script type="text/javascript">
		$(function () {
			jQuery('body').layout({
				center__childOptions: {
					north__resizable: false,
					spacing_open: 0
				},
				north: {
					size: 'auto',
					spacing_open: 0,
					closable: false,
					resizable: false
				}
			});

			$('#list').grid({
				barid: '#bar',
				datatype: 'json',
				type: 'post',
				width: '100%',
				fit: true,
				lazy: false,
				async: false,
				rowno: true,
				rows:${session.rowsize},
				roll: 6,
				pager: true,
				pagerpos: 'right',
				pagercon: 'first,last,number,next,prev',
				column: [{
					title: '单品ID',
					name: 'knifeInventoryCode'

				},{
					title: '材料号',
					name: 'toolID'
				},{
					title: '刃磨次数',
					name: 'expandSpace3'
				},{
					title: '加工件数',
					name: 'expandSpace2'
				},{
					title: '操作流程',
					name: 'businessFlowLnkID'
				},{
					title: '操作时间',
					name: 'createTime',
					format: function (r) {
						return '<span class="ui-grid-tdtx">' + fdate4(r.createTime) + '</span>';
					}
				}, {
					title: '操作者',
					name: 'createUser'
				}],
				success: function (d) {
					if(undefined== d.total){
						$("#number1").text(0);
					}else if(0== d.total){
						$("#number1").text(1);
					} else {
						$("#number1").text(d.total);
					}
					if (d.status < 0) {
						artDialog(d.message, "OK");
					}
				}
			});
		});

		$(function () {

			/**
			 * 出库信息查询
			 */
			$("#toolLibrarySubmit").click(function () {
				var s = $("#libraryCode").val();

				if(s!=""&&s!= undefined){
					var param = {
						opt: 'list',
						libraryCode: $(toolLibraryFrom.libraryCode).val(),

					}
					$('#list').grid('url', 'B09S003.action');
					$('#list').grid('data', param);
					$('#list').grid('load', 1);
					return false;

				}else {
					artDialog("请输入单品ID", "OK");
//					$.dialog.confirm("","OK");
//
				}

			});




		});

	</script>


</head>
<body>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页>首页>基础数据管理>刀具生命周期</span>
		<%@ include file="../head_div.jsp" %>
	</div>
</div>
<div class="ui-layout-center g-ct-bd">
	<div class="ui-layout-north">
		<div class="u-ptf">
			${sessionScope.lang.searchTitle}

		</div>
		<form id="toolLibraryFrom" name="toolLibraryFrom" method="post">
			<table width="100%" class="m-frmtb">
				<tr>

					<th width="100">
						单品ID
					</th>
					<td>
						<input name="libraryCode" id="libraryCode" type="text" class="u-ipt" maxlength="16">
					</td>
				</tr>


			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="toolLibrarySubmit" onclick="return yanzheng()">查询</button>
				<%--<button type="button" class="u-btn2" id="toolLibraryOut">导出</button>--%>
			</div>


		</form>
		<div class="f-cb"></div>
		<div class="u-ptt">
			<div style="float:left;">${sessionScope.lang.searchList}</div>
			<div style="float:right;">
				共: <span id="number1"></span> &nbsp;条
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

