<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
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
				column:[{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.CheckUserText}',
						name:'checkUser',
						visible:'${session.gridcol.checkUser}'
					},{
						title:'${session.lang.CheckTimeText}',
						name:'checkTime',
						visible:'${session.gridcol.checkTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.checkTime)+'</span>';
                        }
					},{
						title:'${session.lang.LibraryCountText}',
						name:'libraryCount',
						visible:'${session.gridcol.libraryCount}'
					},{
						title:'${session.lang.RealLibraryCountText}',
						name:'realLibraryCount',
						visible:'${session.gridcol.realLibraryCount}'
					},{
						title:'${session.lang.InventoryResultsText}',
						name:'inventoryResults',
						visible:'${session.gridcol.inventoryResults}',
						format:function(r){
							
							if(r.checkTime=='undefined' || r.checkTime== null){
								return '';
							}
							//当应在库数量等于实际在库数量时，计算库存结果：盘平
							if(r.libraryCount==r.realLibraryCount){
							return '<span class="ui-grid-tdtx">'+ '${session.lang.InventoryBalanceText}'+'</span>';}
							//当应在库数量小于实际在库数量时，计算库存结果：盘盈
					   		else if(r.libraryCount < r.realLibraryCount){
					   		return '<span class="ui-grid-tdtx">'+'${session.lang.InventoryProfitText}'+'</span>';}
					   		//当应在库数量大于实际在库数量时，计算库存结果：盘亏
					   		else{
					   		return '<span class="ui-grid-tdtx">'+'${session.lang.InventoryLossText}'+'</span>';
					   		}
							return '';
						}
					},{
						title:'${session.lang.InventoryStatusText}',
						name:'inventoryStatus',
						visible:'${session.gridcol.inventoryStatus}',
						format:function(r){
							return inventoryStatusFormat(r);
						}
					},{
						title:'${session.lang.RemoveUserText}',
						name:'removeUser',
						visible:'${session.gridcol.removeUser}'
					}],
					success:function(d){
						 if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});


			
			$(function(){
				/**
				* 盘点记录查询
				*/
				$("#stockingSubmit").click(function(){
					dstarStr=$('input[name="dstar"]').val();
					dendStr=$('input[name="dend"]').val();
					var param = {
							opt:'list',
							ToolCode:$(stockingForm.ToolCode).val(),
							CheckUser:$(stockingForm.CheckUser).val(),
							DateStar:$(stockingForm.dstar).val(),
							DateEnd:$(stockingForm.dend).val(),
							InventoryStatus:$(stockingForm.InventoryStatus).val(),
						}
						$('#list').grid('url','B01S014.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});


				});
					
			$(function(){
			//获取第一天
				var myDate = new Date();
			    var year = myDate.getFullYear();
			    var month = myDate.getMonth()+1;
			    if (month<10){
			        month = "0"+month;
			    }
			    var firstDay = year+"-"+month+"-01";
			   
			
			//获取最后一天
			    myDate = new Date(year,month,0);
			    var lastDay = year+"-"+month+"-"+myDate.getDate();
			 $("#startDate").val(firstDay); 
			 $("#endDate").val(lastDay);

			});
			
			var dstarStr=$('input[name="dstar"]').val();
			var dendStr=$('input[name="dend"]').val();
			
			function inventoryStatusFormat(r){
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				//dstarStr操作开始时间
				var dstar1 = dstarStr.replace(/-/g,"");
				//dendStr操作结束时间
				var dend1 = dendStr.replace(/-/g,"");
				//盘点时间
				if(r.checkTime=='undefined' || r.checkTime== null){
					ary_li.push('<li>${session.lang.NotCountingText}</li>');
				}else{
					ary_li.push('<li>${session.lang.HasBeenCountingText}</li>');
				}
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
					
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b01s014pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="stockingForm" name="stockingForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="40">
							</td>
							<th width="150">
								${session.lang.CheckUserText}
							</th>
							<td>
								<input name="CheckUser" type="text" class="u-ipt" maxlength="16">
							</td>
						</tr>
						<tr>
							<th width="150">
								${session.lang.CheckTimeText}
							</th>
							<td>
								<input name="dstar" id="startDate" type="text" class="u-ipt Wdate" onclick="WdatePicker()" >
								<input name="dend" id="endDate" type="text" class="u-ipt Wdate" onclick="WdatePicker()" >
							</td>
							
							<th width="150">
								${session.lang.InventoryStatusText}
							</th>
							<td>
								<select class="u-sel" name="InventoryStatus">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									
										<option value="0">
											${session.lang.HasBeenCountingText}
										</option>
									
										<option value="1">
											${session.lang.NotCountingText}
										</option>
                                 </select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="stockingSubmit" >${sessionScope.lang.submitSearchText}</button>
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
	</body>
</html>

