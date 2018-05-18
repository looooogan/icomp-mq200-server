<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
				<!-- 2017/09/16 王冉 变更↓↓↓　dazhong@YMSC -->
				column:[{
					title:'筒刀材料号',
					name:'synthesisParametersCode'
				},{
					<!-- 2017/09/16 王冉 变更↑↑↑　dazhong@YMSC -->
					title:'筒刀编号',
					name:'laserIdentificationCode'
				},{
					title:'拆解人',
					name:'splitUser'
				},{
					title:'拆解日期',
					name:'splitTime'
				},{
					title:'装配人',
					name:'installUser'
				},{
					title:'装配日期',
					name:'installTime'
				},{
					title:'操作',
					name:'',
					visible:'true',
					format:function(r,t){
						return option(r);
					}
				}],
				success:function(d){
					if (undefined == d.total) {
						$ ("#number1").text (0);
					} else if (0 == d.total) {
						$ ("#number1").text (1);
					} else {
						$ ("#number1").text (d.total);
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
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDetailText}</a></li>').click(function(){detail(r.synthesisParametersCode,r.rfId,r.splitTime,r)}));
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}
		/**
		 * 编辑用户详细处理
		 */
		function detail(synthesisParametersCode, rfId, splitTime,obj) {
			var param = {
				opt: 'detail',
				synthesisParametersCode: synthesisParametersCode,
				rfId:rfId,
				splitTime:splitTime
			}
			$.ajax ({
				url: "tdDetail.action",
				type: "post",
				dataType: "json",
				data: param,
				success: function (d) {
					wd_detail (d, obj);
				}
			});
		}

		/**
		 * 详细信息
		 */
		function wd_detail(data, obj) {
			$ ('#detailForm').form ('reset');
			var title = '详细';
			// 页面赋值
			if (typeof  data.data != "undefined") {
				$ (detailForm.synthesisParametersCode).val (obj.synthesisParametersCode);// 筒刀材料号
				$ (detailForm.laserIdentificationCode).val (obj.laserIdentificationCode);// 筒刀编号
				$ (detailForm.splitUser).val (obj.splitUser);// 拆解人
				$ (detailForm.splitTime).val (obj.splitTime);// 拆解日期
				$ (detailForm.installUser).val (obj.installUser);// 装配人
				$ (detailForm.installTime).val (obj.installTime);// 装配日期

				// 列表
				var detailList = new Array();
				$("#newTable tbody").remove();
				var html = "";
				detailList = data.data;
				for(var i = 0;i<detailList.length;i++){
					html += '<tr>';
					html += '<td class="t1" align="center">';
					html += (i+1);
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].toolCode;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].toolCount;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].grindingSum;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].thickness;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += detailList[i].angle;
					html += '</td>';
					html += '</tr>';
				}
				$("#newTable").append(html);
			}
			$.dialog ({
				id: 'userDetail_dialog',
				title: title,
				lock: true,
				content: document.getElementById ('detail')
			});
			return false;
		}

		/**
		 * 统计信息
		 */
		function wd_total(data, obj) {
			$ ('#totalForm').form ('reset');
			var title = '统计';
			// 页面赋值
			if (typeof  data.data != "undefined") {
				// 列表
				var totallList = new Array();
				$("#totalTable tbody").remove();
				var html = "";
				totallList = data.data;
				for(var i = 0;i<totallList.length;i++){
					html += '<tr>';
					html += '<td class="t1" align="center">';
					html += (i+1);
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += totallList[i].toolCode;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += totallList[i].hxSum;
					html += '</td>';
					html += '<td class="t1" align="center">';
					html += totallList[i].hxCount;
					html += '</td>';
					html += '</tr>';
				}
				$("#totalTable").append(html);
			}
			$.dialog ({
				id: 'userDetail_dialog',
				title: title,
				lock: true,
				content: document.getElementById ('total')
			});
			return false;
		}

		$(function(){
			/**
			 * 快速查询
			 */
			$("#searchSubmit").click(function(d){
				var param = {
					opt:'list',
					ToolCode:$(searchForm.ToolCode).val(),
					LaserIdentificationCode:$(searchForm.LaserIdentificationCode).val(),
					SplitUser:$(searchForm.SplitUser).val(),
					SplitTimeStar:$(searchForm.SplitTimeStar).val(),
					SplitTimeEnd:$(searchForm.SplitTimeEnd).val(),
					InstallUser:$(searchForm.InstallUser).val(),
					InstallTimeStar:$(searchForm.InstallTimeStar).val(),
					InstallTimeEnd:$(searchForm.InstallTimeEnd).val()
				}
				$('#list').grid('url','B03S007.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});

			$("#searchTotal").click(function(){
				var param = {
					opt: 'total',
					ToolCode:$(searchForm.ToolCode).val(),
					LaserIdentificationCode:$(searchForm.LaserIdentificationCode).val(),
					SplitUser:$(searchForm.SplitUser).val(),
					SplitTimeStar:$(searchForm.SplitTimeStar).val(),
					SplitTimeEnd:$(searchForm.SplitTimeEnd).val(),
					InstallUser:$(searchForm.InstallUser).val(),
					InstallTimeStar:$(searchForm.InstallTimeStar).val(),
					InstallTimeEnd:$(searchForm.InstallTimeEnd).val()
				}
				$.ajax ({
					url: "tdDetail.action",
					type: "post",
					dataType: "json",
					data: param,
					success: function (d) {
						wd_total (d);
					}
				});
			});
		});
	</script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页：首页>刃磨及涂层管理>组合刀拆装记录查询</span>
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
						筒刀材料号
					</th>
					<td>
						<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
					</td>
					<th width="150">
						筒刀编号
					</th>
					<td>
						<input name="LaserIdentificationCode" type="text" class="u-ipt" maxlength="50">
					</td>
					<th width="150">
						拆解人
					</th>
					<td>
						<input name="SplitUser" type="text" class="u-ipt" maxlength="50">
					</td>
				</tr>
				<tr>
					<th width="150">
						拆解日期
					</th>
					<td>
						<input name="SplitTimeStar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
						<input name="SplitTimeEnd" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
					</td>
					<th width="150">
						装配人
					</th>
					<td>
						<input name="InstallUser" type="text" class="u-ipt" maxlength="50">
					</td>
					<th width="150">
						装配日期
					</th>
					<td>
						<input name="InstallTimeStar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
						<input name="InstallTimeEnd" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
					</td>
				</tr>
			</table>
			<div class="g-fx1 f-fr">
				<button type="button" class="u-btn2" id="searchSubmit" >${sessionScope.lang.submitSearchText}</button>
				<button type="button" class="u-btn2" id="searchTotal" >统计</button>
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
<div id="detail" class="f-dn">
	<form id="detailForm" name="detailForm" method="post">
		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					筒刀材料号
				</th>
				<td>
					<input name="synthesisParametersCode" type="text" class="u-ipt" disabled/>
				</td>
				<th width="150">
					筒刀编号
				</th>
				<td>
					<input name="laserIdentificationCode" type="text" class="u-ipt" disabled/>
				</td>
			</tr>
			<tr>
				<th width="150">
					拆解人
				</th>
				<td>
					<input name="splitUser" type="text" class="u-ipt" disabled/>
				</td>
				<th width="150">
					拆解日期
				</th>
				<td>
					<input name="splitTime" type="text" class="u-ipt" disabled/>
				</td>
			</tr>
			<tr>
				<th width="150">
					装配人
				</th>
				<td>
					<input name="installUser" type="text" class="u-ipt" disabled/>
				</td>
				<th width="150">
					装配日期
				</th>
				<td>
					<input name="installTime" type="text" class="u-ipt" disabled/>
				</td>
			</tr>
		</table>
		<table class="m-frmtb" width="100%" id="newTable">
			<thead>
			<tr>
				<th align="center">序号</th>
				<th align="center">材料号</th>
				<th align="center">数量</th>
				<th align="center">修磨次数</th>
				<th align="center">厚度</th>
				<th align="center">角度</th>
			</tr>
			</thead>
		</table>
	</form>
</div>

<div id="total" class="f-dn" style="width: 350px;">
	<form id="totalForm" name="totalForm" method="post">
		<table class="m-frmtb" width="100%" id="totalTable">
			<thead>
			<tr>
				<th align="center">序号</th>
				<th align="center">材料号</th>
				<th align="center">换新数量</th>
				<th align="center">换新次数</th>
			</tr>
			</thead>
		</table>
	</form>
</div>
<!-- 2017/09/16 宋健 变更↑↑↑　dazhong@YMSC -->
</body>
</html>

