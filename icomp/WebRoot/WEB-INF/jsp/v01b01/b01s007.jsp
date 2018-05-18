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
					async:false,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.ToolSupplierText}',
						name:'toolSupplier',
						visible:'${session.gridcol.toolSupplier}'
					},{
						title:'${session.lang.ToolBrandText}',
						name:'toolBrand',
						visible:'${session.gridcol.toolBrand}'
					},{
						title:'${session.lang.ProcuredBatchText}',
						name:'procuredBatch',
						visible:'${session.gridcol.procuredBatch}'
					},{
						title:'${session.lang.ArrivalNumberText}',
						name:'',
						visible:'${session.gridcol.procuredCount}',
						format:function(r){
							if(r.realityTheyCount==""||r.realityTheyCount==null){
								return r.theyCount;
							}else{
								return r.realityTheyCount;
							}
						}
					},{
						title:'${session.lang.TheyTimeText}',
						name:'theyTime',
						visible:'${session.gridcol.theyTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate1(r.theyTime)+'</span>';
                        }
					},{
						title:'${session.lang.TheyStatusText}',
						name:'theyStatus',
						visible:'${session.gridcol.theyStatus}',
						format:function(r){
						//0未到货1已到货2质检通过3质检未通过
						if(r.theyStatus == 0 ){return '<span class="ui-grid-tdtx">${session.lang.NotArrive}</span>';}
				   else if(r.theyStatus == 1 ){return '<span class="ui-grid-tdtx">${session.lang.HasArrived}</span>';}
				   else if(r.theyStatus == 2 ){return '<span class="ui-grid-tdtx">${session.lang.QualityInspection}</span>';}
				   else if(r.theyStatus == 3 ){return '<span class="ui-grid-tdtx">${session.lang.QualityInspectionNo}</span>';}
				   return '<span class="ui-grid-tdtx"></span>';
                        }
					},{
						title:'${sessionScope.lang.RealityTheyCountText}',
						name:'realityTheyCount',
						visible:'${session.gridcol.realityTheyCount}'
					},{
						title:'${session.lang.RealityTheyTimeText}',
						name:'realityTheyTime',
						visible:'${session.gridcol.realityTheyTime}'
					},{
						title:'${session.lang.TransferPeopleText}',
						name:'transferPeople',
						visible:'${session.gridcol.unitPrice}'
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'64px',
						visible:'true',
						format:function(r,t){
						return option(r);
						}
				}],
					success:function(d){
					 if(d.status < 0){
					     artDialog(d.message,"OK");
					   }
					}
				}) ; 
			});

			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				if(r.theyStatus==0){
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.deliveryPlanID,r.version,this)}));
				}
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
			
			$(function(){
				/**
				* 在途计划查询
				*/
				$("#transitPlanSubmit").click(function(){
					var param = {
							opt:'list',
							ProcuredBatch:$(vtransitPlanFrom.ProcuredBatch).val(),
						}
						$('#list').grid('url','B01S007.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});
			});
				
			/**
			* 编辑处理
			*/
			function edit(id,version,obj){
				var param = {
					deliveryPlanID:id,
					opt:'edit',
					version:version
				}
				$.ajax({
					url:"vtransitInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
							wd_vtransitPlan(d,id,obj);
						}
					}
				});
			}
			
			//添加实际到货时间、实际到货数量
			function wd_vtransitPlan(data,id,obj){
				$('#vtransitPlanEditForm').form('reset');
				var title = '${session.lang.AddVtransitPlanTitle}';
				$('#vtransitPlanEditForm :input').removeClass('u-ipt-err');
				$('#vtransitPlanEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					$(vtransitPlanEditForm.opt).val('edit');
					// 页面赋值
					$(vtransitPlanEditForm.DivDeliveryPlanID).val(id);//到货计划ID
					$(vtransitPlanEditForm.DIVTheyStatus).val(data.data.theyStatus);//货品状态
					$(vtransitPlanEditForm.DIVOldTheyTime).val(data.data.createTime);//创建时间
					$(vtransitPlanEditForm.DIVProcuredCount).val(data.data.theyCount);//采购数量
					$(vtransitPlanEditForm.DIVRealityTheyCount).val(data.data.realityTheyCount);//实际到货数量
					$(vtransitPlanEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(vtransitPlanEditForm.DivVersion).val(data.data.version);//版本号
					$(vtransitPlanEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(vtransitPlanEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					$('#vtransitPlanEditForm').attr('action','vtransitPlanEdit.action');
					title = '${sessionScope.lang.submitEditText}';
				}
				$.dialog({
					id:'vtransitPlanEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('vtransitPlanEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#vtransitPlanEditForm').form('submit',{
								success:function(d){
								    $('#vtransitPlanEditForm :input').removeClass('u-ipt-err');
									$('#vtransitPlanEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									//插入成功
										  $.dialog.list['vtransitPlanEdit_dialog'].close();
										  $('#list').grid('load');
										  artDialog($.parseJSON(d).message,"OK");
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#vtransitPlanEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.b01s007pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="vtransitPlanFrom" name="vtransitPlanFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ProcuredBatchText}
							</th>
							<td>
								<input name="ProcuredBatch" type="text" class="u-ipt"  maxlength="20">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="transitPlanSubmit" >${sessionScope.lang.submitSearchText}</button>
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
		<div id="vtransitPlanEdit" class="f-dn">
			<form id="vtransitPlanEditForm" name="vtransitPlanEditForm" method="post">
			<input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivDeliveryPlanID" />
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DIVOldTheyTime"/>
				<input type="text" class="f-dn" name="DIVProcuredCount"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
			    <table class="m-frmtb" width="100%">
			    		<tr>
							<th width="150">
								${sessionScope.lang.RealityTheyTimeText}
							</th>
							<td>
								<input name="DIVRealityTheyTime" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
							</td>
							<th width="150">
								${sessionScope.lang.TheyStatusText}
							</th>
							<td>
							<select class="u-sel" name="DIVTheyStatus">
									<option value="1">
										${session.lang.HasArrived}
									</option>
								</select>
							</td>
						</tr>
			    </table>
			</form>
		</div>
	</body>
</html>

