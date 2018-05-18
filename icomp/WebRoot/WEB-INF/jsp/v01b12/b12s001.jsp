<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="../common/header_common.jsp"%>
		<script type="text/javascript" src="<%=path%>/script/b12s001.js"></script>
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
					rowEdit:true,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.BusinessFlowText}',
						name:'businessFlowID',
						visible:'${session.gridcol.businessFlowID}'
					},{
						title:'${session.lang.BusinessFlowText}',
						name:'businessFlowName',
						visible:'${session.gridcol.businessFlowName}'
					},{
						title:'${sessionScope.lang.CapabilityNameText}',
						name:'capabilityName',
						visible:'${session.gridcol.capabilityName}'
					},{
						title:'${session.lang.UpstreamBusinessText}',
						name:'upBusinessIDName',
						visible:'${session.gridcol.upBusinessIDName}'
					},{
						title:'${session.lang.BusinessText}',
						name:'businessName',
						visible:'${session.gridcol.businessName}'
					},{
						title:'${session.lang.DownstreamBusinessText}',
						name:'downBusinessIDName',
						visible:'${session.gridcol.downBusinessIDName}'
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
					   }else{
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.businessFlowID,this)}));
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.businessFlowID,r.version,r.updateTime,r.updateUser,this)}));
			
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
						
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.RoleDelInfo}',function(){
				    var param = {
					ID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
					$.ajax({
						url:"businessDelete.action",
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							updatebusinessFlowSelect(d.data);
							if(d.status >= 0){
								$('#list').grid('load',1);  
							}
							artDialog(d.message,"OK");
						}
					});
				});
			}
			/**
				更新下拉菜单
			*/
			function updatebusinessFlowSelect(data){
				var $select=$('select[name=BusinessFlowID]');
					
				$select.empty();
				$select.append('<option value="">--${sessionScope.lang.PleaseSelect}--</option>');
				
				$.each(data,function(i,o){
					$select.append('<option value="'+this.businessFlowID+'">'+this.businessFlowName+'</option>');
				});
			}
			
			
		   /**
			* 查询处理
			*/
			function search(){
				var param = {
					opt:'list',
					BusinessFlowID:$(businessForm.BusinessFlowID).val(),       //业务流程ID
					BusinessName:$(businessForm.BusinessName).val(),       //业务流程ID
					DownstreamBusiness:$(businessForm.DownstreamBusiness).val(),       //业务流程ID
				    DelFlag:$(businessForm.DelFlag).val()//删除区分
				}
				$('#list').grid('url','B12S001.action');                       //跳转到action               
				$('#list').grid('data',param);
				$('#list').grid('load',1); 
				return false;
			}	
			
			/**
			* 编辑流程
			*/
			function edit(id,obj){
				var param = {
					ID:id,
				}
				$.ajax({
					url:"businessInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					     	artDialog(d.message,"OK");
					    }else{
							wd_addorEdit(d,id,obj);
						}
					}
				});
			}
			//新建或编辑流程
			function wd_addorEdit(data,id,obj){
				//隐藏位置的表头
				AddSub("base_table","Sub_Table","clean");
				$('#businessEditForm').form('reset');
				var title = '${session.lang.submitAddText}';
				$('#businessEditForm :input').removeClass('u-ipt-err');
				$('#businessEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	  });
				if(typeof(data) == 'object'){
					//编辑
					$(businessEditForm.DIVBusinessFlowName).val(data.data[0].businessFlowName);
					$(businessEditForm.DivBusinessFlowID).val(data.data[0].businessFlowID);
					$(businessEditForm.DivVersion).val(data.data[0].version);
					AddSub("base_table","Sub_Table","edit",data);
					$(businessEditForm.opt).val('edit');
					$('#businessEditForm').attr('action','businessEdit.action');
					title = '${session.lang.submitEditText}';
				}else{
					//新建添加
					$('#businessEditForm').attr('action','businessAdd.action');
					$(businessEditForm.DIVBusinessFlowID).removeAttr("disabled");
				}
				$.dialog({
					id:'businessEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('businessEdit'),
					button:[{
						name:'添加流程节点',
						focus:false,
						callback:function(){
						AddSub("base_table","Sub_Table","new");
						return false;
						}},{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#businessEditForm').form('submit',{
								success:function(d){
								    $('#businessEditForm :input').removeClass('u-ipt-err');
									$('#businessEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });

									if($.parseJSON(d).status >= 0){
											
											var param = {
												opt:'list',
												BusinessFlowID:$(businessForm.BusinessFlowID).val(),       //业务流程    ID
				   								DelFlag:$(businessForm.DelFlag).val()//删除区分
											}
											$('#list').grid('url','B12S001.action');
											$('#list').grid('data',param);
											if($(businessEditForm.opt).val()!='edit'){
												updatebusinessFlowSelect(d.data);
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
										 	artDialog($.parseJSON(d).message,"OK");
											$.dialog.list['businessEdit_dialog'].close();
										} else if($.parseJSON(d).status == -1){
										    artDialog(d.message,"OK");
										}else {
										    artDialog(setContorllBackColor($('#businessEditForm'),$.parseJSON(d).message),"OK");
										}
									}
								});
								return false;
							}
						}]
					});
				return false;
			}
						
			/**添加流程节点**/
			function AddSub(baseTabel,subTable,opp,data) {
				if(opp=="new"){
					//显示表头
					$("#"+subTable+" thead").show();
					$("#"+baseTabel+" tr:eq(0)").clone().appendTo("#"+subTable+" tbody");
					var i=$("#"+subTable+" tbody tr").length-1;
					$("#"+subTable+" tbody tr:last" ).find("p").html(i+1);
					$("#"+subTable+" tbody tr:last" ).find("input[name=OrderNumber]").val(i+1);
				}else if(opp=="edit"){
					//显示表头
					$("#"+subTable+" thead").show();
					$.each(data.data, function (i, v) {
					$("#"+baseTabel+" tr:eq(0)").clone().appendTo("#"+subTable+" tbody");
					$("#"+subTable+" tbody tr:last" ).find("p").html(v.orderNumber);
					$("#"+subTable+" tbody tr:last" ).find("input[name=OrderNumber]").val(v.orderNumber);
					$("#"+subTable+" tbody tr:last" ).find("select[name=DIVCurrentBusiness]").val(v.businessID);
					$("#"+subTable+" tbody tr:last" ).find("select[name=DIVCapability]").val(v.capabilityID);
					});
				}else if(opp=="clean"){
					//隐藏表头
					$("#"+subTable+" thead").hide();
					//清空列表
					$("#"+subTable+" tbody").empty();
				}
				
				
			}
			/**上游业务select
			*id为upBusinessFlowLnkID,在编辑时传入
			*/
			function findBusiness(upBusinessFlowLnkID) {
				//清空上游业务select
				$("select[name='DIVLastBusiness']").empty();
				//根据流程id求上游业务
			    var param = {
			    	opt:'find',
					businessFlowID:$(businessEditForm.DIVBusinessFlowID).val()//流程ID
				}
				$.ajax({
						type: "POST",
						url:"B12S001.action",     //跳转到action的方法
						dataType:"json",
						data:param,
						success:function(d){
						//如果上游业务列表正常获得
						if(typeof  d.listLastBusiness != "undefined"){
							//遍历上游业务列表,写入页面
							for(i=0;i<d.listLastBusiness.length;i++){
							  if(upBusinessFlowLnkID == d.listLastBusiness[i].businessFlowLnkID){
	       						      $("select[name='DIVLastBusiness']").append("<option value='"+d.listLastBusiness[i].businessFlowLnkID+"' selected>"+d.listLastBusiness[i].orderNumber+"_"+d.listLastBusiness[i].businessName+"</option>");
	       						 }else{
	       						      $("select[name='DIVLastBusiness']").append("<option value='"+d.listLastBusiness[i].businessFlowLnkID+"'>"+d.listLastBusiness[i].orderNumber+"_"+d.listLastBusiness[i].businessName+"</option>");
	       						 }
       						}
						}
					}
					});
				//无上游业务	
				if(upBusinessFlowLnkID==null){
 					$("select[name='DIVLastBusiness']").append("<option value='' selected>--${sessionScope.lang.NoLastOneText}--</option>");
				}else {
					$("select[name='DIVLastBusiness']").append("<option value=''>--${sessionScope.lang.NoLastOneText}--</option>");
				}	 
			}
		function updateBusinessFlow(d,Divname){
			//如果上游业务列表正常获得
			if(typeof  $.parseJSON(d).data != "undefined"){
			 $("select[name='"+Divname+"']").empty();
			 $("select[name='"+Divname+"']").append("<option value=''>--${sessionScope.lang.PleaseSelect}--</option>");
				//遍历上游业务列表,写入页面
				for(i=0;i<$.parseJSON(d).data.length;i++){
     				$("select[name='"+Divname+"']").append("<option value='"+$.parseJSON(d).data[i].businessFlowID+"'>"+$.parseJSON(d).data[i].businessFlowName+"</option>");
    			}
    			
			}
		}
		
		
/***************************************合并单元格   *********************************/
/*
*  合并单元格   
*/
function _w_table_rowspan(maxColnum){
	//设定分组标准列
	var textArr = getHtml(1);
		//总行的数量
	var count1 = $('#list tbody tr').length;
	//相邻相同的数量 
	var countArr1 = findCount(textArr);
	//显示的数量
	var showRow1 = rowCount(countArr1);
	//合并第一列
	doRowspan(countArr1,showRow1,2);
	
	//总行的数量
	var count2 = $('#list tbody tr').length;
	//相邻相同的数量 
	var countArr2 = findCount(textArr);
	//显示的数量
	var showRow2 = rowCount(countArr2);
	//合并第一列
	doRowspan(countArr2,showRow2,7);
}
		
function getHtml(col1,col2){
	  var textArr = new Array();
	  var colIndex = 0;
	  $('#list tbody tr').each(function(){ 
	  		$('td', this).each(function() { 
				//找到主要合并的列
	  			if($(this).index() == col1){ 
		  			//要合并的列加上rowsqan属性
	  				textArr[colIndex] = $(this).text();
	  				colIndex++;
	  			}
	  		});
	  });
	  return textArr;
}
		
//合并操作
function doRowspan(countArr,showRow,col){
	  var count = 0; //行数
	  var indexCount = 0; //rowspan的下标
	  var showRowIndex = 0;
	  $('#list tbody tr').each(function(){//行
  			if((count+1) == showRow[showRowIndex]){
  				//显示列数 
		  		$('td', this).filter(':visible').each(function() {  //列
				  //要合并的列数 
		  			if($(this).index() == col){
	  						$(this).attr("rowspan",countArr[indexCount]);
			  				showRowIndex++;
				  		}
		  		});
		  		//rowspan的下标
		  		indexCount++;
		  		//showRowIndex-=1;//如果只合并单列  取消此运算 ;增加列要减去相应的列数 （2列为减1，3列为减2，3列为减2...) 
  			}else{
				  //要隐藏列数 
		  		$('td', this).filter(':visible').each(function() {  //列
		  			if($(this).index() == col ){
	  						$(this).hide();
				  		}
		  		});	
 				}
  		
  		count++;
	  });
}
		
/**
 * 求要合并的行数
 * paras：要合并内容的数组
 * return：要合并的第一行的行数
 */ 
function findCount(arr){ 
	//要合并的行
	var arr1 = new Array();
	/**
	 *要合并的行
	 */
	var h = 0;
	 a:	for (var i = 0; i < arr.length; i++) {
			var count = 0;
			for (var j = i; j < arr.length; j++) {
				if (arr[i] == arr[j]) {
					count++;
					if(j == arr.length-1){
						arr1[h] = count; 
						break a;
					}
				}else if (j >= i) {
					i = j-1;
					break;
				}
			}
			arr1[h] = count;
			h++;
		}
	return  arr1;
}

	/**
	 *要合并的行数(显示)
	 */
function rowCount(arr){
	// 要合并的行数（那几个合并,返回的数组）
	var reArr = new Array();
		
	for (var i = 0; i < arr.length; i++) {
		h = 0;
		for (var j = 0; j < i ; j++) {
			h += (arr[j]+1);
		}
		if (i == 0) {
			reArr[i] = 1;
		}else {
			reArr[i] = h-(i-1);
		}
	}
	return  reArr;
}

/***************************************合并单元格   *********************************/
		
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b12s001pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="businessForm" name="businessForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.BusinessFlowText}
							</th>
							<td>
								<select class="u-sel" name="BusinessFlowID"
									onchange="return findBusiness()">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.BusinessFlowList"
										id="businessFlowE">
										<s:if
											test='%{#request.businessFlowE == #request.BusinessFlowID}'>
											<option value="${businessFlowE.businessFlowID}" selected>
												${businessFlowE.businessFlowName}
											</option>
										</s:if>
										<s:else>
											<option value="${businessFlowE.businessFlowID}">
												${businessFlowE.businessFlowName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${session.lang.BusinessText}
							</th>
							<td>
							<input type="text" class="u-sel"  name="BusinessName" maxlength="50"/>
							</td>
							<th width="150">
								${session.lang.DownstreamBusinessText}
							</th>
							<td>
							<input type="text" class="u-sel"  name="DownstreamBusiness" maxlength="50"/>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2"
							onclick="return wd_addorEdit()">
							${sessionScope.lang.submitAddText}
						</button>
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
		<div id="businessEdit" class="f-dn">
			<form id="businessEditForm" name="businessEditForm" method="post">
				<input type="text" class="f-dn" name="DivBusinessFlowID" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<input type="text" class="f-dn" name="DIVDelFlag" />
				<input type="text" class="f-dn" name="opt" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th width="150">
							${sessionScope.lang.BusinessFlowText}
						</th>
						<td>
							<input class="u-sel" type="text" name="DIVBusinessFlowName" maxlength="10">
						</td>
					</tr>
				</table>
				<div style="overflow:auto; max-height:300px;">
				<table id="Sub_Table"  class="m-frmtb" width="100%" >
					<thead>
							<tr >
							<th width="120">
								顺序号
							</th>
							<th width="150">
								${sessionScope.lang.BusinessText}
							</th>
							<th width="150">
								${sessionScope.lang.CapabilityNameText}
			
							</th>
							</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				</div>
			</form>
		</div>
		<div id="base_div" class="f-dn">
			<table id ="base_table">
				<tr>
					<th>
						<input name="OrderNumber" type="text" class="f-dn">
						<P></P>
					</th>
						<td>
							<select class="u-sel" name="DIVCurrentBusiness">
								<s:iterator value="#request.listBusiness" id="Business">
									<option value="${Business.businessID}" >
										${Business.businessName}
									</option>
								</s:iterator>
							</select>
						</td>
						<td>
							<select class="u-sel" name="DIVCapability">
								<s:iterator value="#request.listCapability" id="Capability">
									<option value="${Capability.capabilityID}" >
										${Capability.capabilityName}
									</option>
								</s:iterator>
							</select>
						</td>
				</tr>
			</table>
		</div>
	</body>
</html>

