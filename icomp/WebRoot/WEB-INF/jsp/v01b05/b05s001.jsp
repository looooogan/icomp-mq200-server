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
						title:'${session.lang.ProcuredBatchText}',
						name:'procuredBatch',
						visible:'${session.gridcol.procuredBatch}'
					},{
						title:'${session.lang.ToolSupplierText}',
						name:'toolSupplier',
						visible:'${session.gridcol.toolSupplier}'
					},{
						title:'${session.lang.ToolBrandText}',
						name:'toolBrand',
						visible:'${session.gridcol.toolBrand}'
					},{
						title:'${session.lang.ToolCodeText }',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.UnitPriceText }',
						name:'unitPrice',
						visible:'${session.gridcol.unitPrice}',
						format:function(r){
							var money=fmoney(r.unitPrice,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.ProcuredCountText}',
						name:'procuredCount',
						visible:'${session.gridcol.procuredCount}'
					},{
						title:'${session.lang.MoneyText}',
						name:'totalMoney',
						visible:'${session.gridcol.totalMoney}',
						format:function(r){
							var money=fmoney(r.totalMoney,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.TheyStatusText}',
						name:'theyStatus',
						visible:'${session.gridcol.theyStatus}',
						format:function(r){
						//0未到货1已到货2质检未通过3质检已通过
						if(r.theyStatus == 0){return '<span class="ui-grid-tdtx">${session.lang.NotArrive}</span>';}
					    else if(r.theyStatus == 1){return '<span class="ui-grid-tdtx">${session.lang.HasArrived}</span>';}
					    else if(r.theyStatus == 2){return '<span class="ui-grid-tdtx">${session.lang.QualityInspection}</span>';}
					    else if(r.theyStatus == 3){return '<span class="ui-grid-tdtx">${session.lang.QualityInspectionNo}</span>';}
					    return '';
						}
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'80px',
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.deliveryPlanID,r.version,this)}));
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
			
			/**
			* 待质检刀具查询处理
			*/
			function search(){
				var param = {
					opt:'list',
					ToolCode:$(purchasePlanFrom.ToolCode).val(),
				}
				$('#list').grid('url','B05S001.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	
				
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
					url:"deliveryplanInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
							wd_deliveryplan(d,id,obj);
						}
					}
				});
			}
			
			//添加实际到货时间、实际到货数量
			function wd_deliveryplan(data,id,obj){
				$('#deliveryplanEditForm').form('reset');
				var title = '${session.lang.EditProcessingToolTitle}';
				$('#deliveryplanEditForm :input').removeClass('u-ipt-err');
				$('#deliveryplanEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){

					$(deliveryplanEditForm.opt).val('edit');
					
					// 页面赋值
					$(deliveryplanEditForm.DivDeliveryPlanID).val(id);//到货计划ID
					$(deliveryplanEditForm.DIVTheyStatus).val(data.data.theyStatus);//货品状态
					$(deliveryplanEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
					$(deliveryplanEditForm.DivVersion).val(data.data.version);//版本号
					$(deliveryplanEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
					$(deliveryplanEditForm.DIVDelFlag).val(data.data.delFlag);//删除区分
					$('#deliveryplanEditForm').attr('action','deliveryplanEdit.action');
				}
				$.dialog({
					id:'deliveryplanEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('deliveryplanEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#deliveryplanEditForm').form('submit',{
								success:function(d){
								    $('#deliveryplanEditForm :input').removeClass('u-ipt-err');
									$('#deliveryplanEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if($.parseJSON(d).status >= 0){
									//插入成功
										  $.dialog.list['deliveryplanEdit_dialog'].close();
										  $('#list').grid('load');
										  artDialog($.parseJSON(d).message,"OK");
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {		
										    artDialog(setContorllBackColor($('#deliveryplanEditForm'),$.parseJSON(d).message),"OK");
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
				<span>${sessionScope.lang.CurrentPageText}：${sessionScope.lang.HomePageText} &gt;${sessionScope.lang.QualityInspectionToolsText}&gt;${sessionScope.lang.WaitQualityInspectionToolsQueryText}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="purchasePlanFrom" name="purchasePlanFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
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
		<div id="deliveryplanEdit" class="f-dn">
			<form id="deliveryplanEditForm" name="deliveryplanEditForm" method="post">
			<input type="text" class="f-dn" name="opt" value="add"/>
				<input type="text" class="f-dn" name="DivDeliveryPlanID" />
				<input type="text" class="f-dn" name="DivVersion"/>
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime"/>
			    <table class="m-frmtb" width="100%">
			    		<tr>
							<th width="150">
								${sessionScope.lang.TheyStatusText}
							</th>
							<td>
							<select class="u-sel" name="DIVTheyStatus">
									<option value="2">
										${session.lang.QualityInspection}
									</option>
									<option value="3">
										${session.lang.QualityInspectionNo}
									</option>
							</select>
							</td>
						</tr>
						
			    </table>
			</form>
		</div>
	</body>
</html>

