<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="../common/header_common.jsp"%>
		<script type="text/javascript">
		var	 flag=true;
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

					type:'post',
					width:'100%',
					fit:true,
					lazy:false,
					async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'订单号',
						name:'toolsOrdeNO'
					},
//					{
//						title:'刀具类型',
//						name:'toolType'
//
//					},
					{
						title:'材料号',
						name:'toolCode',

					},{
						title:'需求号',
						name:'procuredBatch'

					},{
						title:'采购日期',
						name:'procuredTime',
					format:function(r){
						return '<span class="ui-grid-tdtx">'+fdate1(r.procuredTime)+'</span>';
					}

					},{
						title:'采购单价',
						name:'unitPrice'

					},{
						title:'采购人',
						name:'procuredUser'

					},{
						title:'采购数量',
						name:'toolID'
					},{
						title:'入库数量',
						name:'expandSpace1'

					},{
						title:'是否入库',
						name:'procuredInto',
					format:function(t){

						if(t.procuredInto == 0 ){return '<span class="ui-grid-tdtx">否</span>';}
						else {return '<span class="ui-grid-tdtx">是</span>';}
						return '<span class="ui-grid-tdtx"></span>';
					}

					},{
						title:'供应商',
						name:'supplier'
					<%--},--%>
					<%--{--%>
						<%--title:'${session.lang.OperationText}',--%>
						<%--name:'',--%>
						<%--width:'130px',--%>
						<%--visible:'true',--%>
						<%--format:function(r,t){--%>
						<%--return '<a href="javascript:void(0)" class="editDiv">${session.lang.OrderGenerationText}</a>';--%>
						<%--}--%>
				}],
					success:function(d){
						if(d.status < 0&& flag){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});
			$(function(){
			/**
			* 采购订单
			*/
			$("#search").click(function(){
			flag=true;
				var param = {
					opt:'list',
					//时间段开始时间 
					DateStar:$(searchSibmitFrom.dstar).val(),
					//时间段结束时间
					DateEnd:$(searchSibmitFrom.dend).val(),
					//刀具编码 
					ToolCode:$(searchSibmitFrom.toolCode).val(),
					procuredBatch:$(searchSibmitFrom.procuredBatch).val(),
					toolsOrdeNO:$(searchSibmitFrom.toolsOrdeNO).val(),
					//toolType:$(searchSibmitFrom.toolType).val(),
					supplier:$(searchSibmitFrom.supplier).val(),

				}
				$('#list').grid('url','B07S004.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			});		

			/**
			 * 操作列编辑-订单生成
			 */	
			<%--$(".editDiv").live("click",function(){--%>
				<%--$('#procurementDiv .ErroSpan').text('');--%>
				<%--$("#theyTime").val('');--%>
				<%--var $this = $(this);--%>
				<%--//找到前一列的值采购ID--%>
					<%--var toolProcuredID = $(this).parent("td").siblings("td").eq(0).text();--%>
					<%--//到货数量(总数)--%>
					<%--var tempCount  = $(this).parent("td").siblings("td").eq(7).text();--%>
					<%--//未到货量赋值--%>
					<%--$("#theyCount").val($(this).parent("td").siblings("td").eq(7).text());--%>
					<%--//提出时间--%>
					<%--var toolProcuredTime=$(this).parent("td").siblings("td").eq(11).text();--%>
					<%--//弹出框--%>
							<%--$.dialog({--%>
								<%--id:'roleEdit_dialog',--%>
								<%--title:'${session.lang.OrderGenerationText}',--%>
								<%--content:document.getElementById('procurementDiv'),--%>
								<%--button:[{--%>
									<%--name:'${session.lang.submitSaveText}',--%>
									<%--callback:function(){--%>
										<%--$('#procurementDiv .ErroSpan').text('');--%>
										<%--var flag=false;--%>
										<%--//预计到货时间--%>
										<%--var theyTime = $("#theyTime").val();--%>
										<%--//请填写到货时间--%>
										<%--if(theyTime.length < 1){--%>
											<%--$('#theyTimeSpanText').text('${session.lang.PleaseFillInTheArrivalTime}');--%>
											<%--flag=true;--%>
										<%--}else{--%>
											<%--theyTime =fdate2(theyTime);--%>
											<%--var toolProcuredTime_fdate2 =fdate2(toolProcuredTime);--%>
											<%--if(toolProcuredTime_fdate2*1>theyTime*1){--%>
												<%--$('#theyTimeSpanText').text("${session.lang.E676}");--%>
												<%--flag=true;--%>
											<%--}--%>
										<%--}--%>
										<%--//预计到货数量--%>
										<%--var theyCount = $("#theyCount").val();--%>
										<%--//请填写到货数量--%>
										<%--if(theyCount =='' || theyCount == null ){--%>
											<%--$('#theyCountSpanText').text('${session.lang.PleaseFillInTheNumberOfArrival}');--%>
											<%--flag=true;--%>
										<%--}--%>
										<%--//请填写到货数量--%>
										<%--if(theyCount*1>tempCount*1){--%>
											<%--$('#theyCountSpanText').text("${session.lang.E678}");--%>
											<%--flag=true;--%>
										<%--}--%>
										<%--if(flag){--%>
											<%--return false;--%>
										<%--}--%>
										<%----%>
									<%--/**--%>
									  <%--*订单生成提交--%>
									  <%--*/--%>
										<%--var param = {--%>
												<%--TempCount:tempCount,//到货数量(总数)--%>
												<%--ToolProcuredID:toolProcuredID,//采购ID--%>
												<%--TheyTime:theyTime,//预计到货时间 --%>
												<%--TheyCount:theyCount,//预计到货数量--%>
											<%--}--%>
										<%--$this.removeAttr("class");--%>
										<%--$this.text("${session.lang.GenerationText}");--%>
										<%--$.ajax({--%>
											<%--url:"deliveryPlanAdd.action",--%>
											<%--type: "post",--%>
											<%--dataType:"json",--%>
											<%--data:param,--%>
											<%--success:function(d){--%>
												<%--if(d.status < 0){--%>
												 <%--$this.attr("class","editDiv");--%>
													<%--$this.text("${session.lang.OrderGenerationText}");--%>
											     <%--artDialog(d.message,"OK");--%>
												<%--}else{--%>
												<%--flag=false;--%>
											        <%--artDialog(d.message,"OK");--%>
											     	<%--$('#list').grid('load',1);--%>
												<%--}--%>
										<%--}--%>
										<%--});--%>
										<%----%>
										<%----%>
									<%--}--%>
								<%--}]--%>
							<%--});--%>
				<%--});--%>
			<%----%>
	});
		function newAdd(data,id,obj){
			$('#roleEditForm').form('reset');
			var title = '新建订单';
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

				title = '${session.lang.EditRoleTitle}';

			}else{
				$(roleEditForm.DIV_AgencyID).removeAttr("disabled");//启用机构
				$(roleEditForm.DIV_DepartmentID).removeAttr("disabled");//启用部门
				$(roleEditForm.DIV_DelFlag).val(0);//删除区分-有效
				$(roleEditForm.DivVersion).val(0);//版本号
				$('#roleEditForm').attr('action','deliveryPlannewAdd.action');
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
					;
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
									$('#list').grid('url','B07S004.action');
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
				<span>${sessionScope.lang.b07s004pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="searchSibmitFrom" name="searchSibmitFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th >
								订单号
							</th>
							<td>
								<input name="toolsOrdeNO" type="text" class="u-ipt" maxlength="50">
							</td>
							<%--<th >--%>
								<%--刀具类型--%>
							<%--</th>--%>
							<%--<td>--%>
								<%--<select class="u-sel" name="toolType" maxlength="16">--%>
									<%--<option value="">--%>
										<%----请选择----%>
									<%--</option>--%>

									<%--<option value="a">--%>
										<%--A--%>
									<%--</option>--%>

									<%--<option value="b">--%>
										<%--B--%>
									<%--</option>--%>

									<%--<option value="c">--%>
										<%--C--%>
									<%--</option>--%>

									<%--<option value="d">--%>
										<%--D--%>
									<%--</option>--%>

									<%--<option value="e">--%>
										<%--E--%>
									<%--</option>--%>

									<%--<option value="f">--%>
										<%--F--%>
									<%--</option>--%>
									<%--<option value="g">--%>
										<%--G--%>
									<%--</option>--%>
									<%--<option value="h">--%>
										<%--H--%>
									<%--</option>--%>
									<%--<option value="e">--%>
										<%--I--%>
									<%--</option>--%>
									<%--<option value="s">--%>
										<%--S--%>
									<%--</option>--%>

								<%--</select>--%>
							<%--</td>--%>
							<th >
								材料号
							</th>
							<td>
								<input name="toolCode" type="text" class="u-ipt" maxlength="50" onkeyup="this.value=this.value.toUpperCase()">
							</td>
							<td>
							</tr>
						<tr>
							<th >
								采购时间
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
								-
								<input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
							<th >
								需求号
							</th>
							<td>
								<input name="procuredBatch" type="text" class="u-ipt" maxlength="20">
							</td>
							<th >
								供应商
							</th>
							<td>
								<input name="supplier" type="text" class="u-ipt" maxlength="20">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" id="search" class="u-btn2">
							${sessionScope.lang.submitSearchText}
						</button>
						<%--<button type="button" id="infoNews" class="u-btn2"  onclick="return newAdd()">--%>
							<%--新建--%>
						<%--</button>--%>
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
		<%--<div id="procurementDiv" class="f-dn">--%>
			<%--<table width="100%" class="m-frmtb">--%>
				<%--<tr>--%>
					<%--<th width="150">--%>
						<%--${session.lang.TheyCountText}--%>
					<%--</th>--%>
					<%--<td style="white-space: nowrap">--%>
						<%--<input name="theyCount" id="theyCount" type="text" class="u-ipt" maxlength="11">--%>
						<%--<span id="theyCountSpanText" style="color: red" class="ErroSpan" > </span>	--%>
					<%--</td>--%>
					<%--<th width="150">--%>
						<%--${session.lang.TheyTimeText}--%>
					<%--</th>--%>
					<%--<td style="white-space: nowrap">--%>
						<%--<input name="theyTime" id="theyTime" type="text" class="u-ipt Wdate" onclick="WdatePicker()">--%>
						<%--<span id="theyTimeSpanText" style="color: red" class="ErroSpan" > </span>	--%>
					<%--</td>--%>
				<%--</tr>--%>
			<%--</table>--%>
		<%--</div>--%>
		<%--新建厂家DIV--%>
		<div id="roleEdit" class="f-dn">
			<form id="roleEditForm" name="roleEditForm" method="post">
				<input type="text" class="f-dn" name="opt" value="add"/>
				<table class="m-frmtb" width="100%">

					<tr>
						<th width="150">
							订单号
						</th>
						<td>
							<input name="DIVtoolsOrdeNO" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							刀具类型
						</th>
						<td>

							<select class="u-sel" name="ToolConsumetype" maxlength="16">
								<option value="">
									--请选择--
								</option>
								<option value="0">
									A
								</option>
								<option value="1">
									B
								</option>
								<option value="2">
									C
								</option>
								<option value="3">
									D
								</option>
								<option value="4">
									E
								</option>
								<option value="5">
									F
								</option>
								<option value="6">
									G
								</option>
								<option value="7">
									H
								</option>
								<option value="8">
									I
								</option>
								<option value="9">
									J
								</option>
							</select>
						</td>
						<th width="150">
							材料号
						</th>
						<td>
							<%--<select class="u-sel" name="DIVmerchantsType">--%>
								<%--<option value="">--%>
									<%----${sessionScope.lang.PleaseSelect}----%>
								<%--</option>--%>
								<%--<s:iterator value="#request.DepartmentList" id="department">--%>
									<%--<option value="xxx">dddd</option>--%>
								<%--</s:iterator>--%>
							</select>
							<input name="DIVtoolCode" type="text" class="u-ipt" maxlength="36" onkeyup="this.value=this.value.toUpperCase()">
						</td>
					</tr>
					<tr>
						<th width="150">
							采购时间
						</th>
						<td>
							<input name="DIVprocuredTime" type="text" class="u-ipt Wdate" onclick="WdatePicker()" maxlength="36">
						</td>

						<th width="150">
							采购批次
						</th>
						<td>
							<input name="DIVprocuredBatch" type="text" class="u-ipt" maxlength="36">
						</td>
						<th width="150">
							采购单价
						</th>
						<td>
							<input name="DIVunitPrice" type="text" class="u-ipt" maxlength="50" >

						</td>
					</tr>
					<tr>
						<th width="150">
							采购人
						</th>
						<td>
							<input name="DIVprocuredUser" type="text" class="u-ipt" maxlength="50" >

						</td>
						<th width="150">
							是否入库
						</th>
						<td>
							<select class="u-sel" name="DIVprocuredInto">
							<option value="">
							--${sessionScope.lang.PleaseSelect}--
							</option>
							<option value = "0">是</option>
				            <option value = "1">否</option>

						</select>
						</td>

						<th width="150">
							供应商1
						</th>
						<td>
							<input name="DIVsupplier" type="text" class="u-ipt" maxlength="50" >
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>

