<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
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
						title:'${session.lang.ToolShelfCodeText}',
						name:'toolShelfCode',
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'130px',
						visible:'true',
						format:function(r){
						return option(r);
						}
				}],
					success:function(d){
					if(d.status < 0){
							artDialog(d.message,"OK");
						}
					}
				}) ; 
				}) ; 
			
			/**
			 * 操作列超链接
			 */
			function option(r){ 
				var $ul = $('<ul class="u-option"></ul>');
				var $li = $('');
				var ary_li = new Array();
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.toolShelfID,r.version,r.updateTime,r.updateUser,this)}}));
				
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
				
			/**
			* 查询处理
			*/
			function search(optText){
				var param = {
					opt:optText,
					ToolShelfCode:$(searchForm.ToolShelfCode).val(),
					DelFlag:$(searchForm.DelFlag).val(),					
				}
				$('#list').grid('url','B08S014.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	
			/**
			* 新建处理
			*/
			function add_toolShelf(data,id,obj){
				$('#ToolShelfEditForm').form('reset');
				var title = '${session.lang.submitAddText}';
				$('#ToolShelfEditForm :input').removeClass('u-ipt-err');
				$('#ToolShelfEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	    });
				$(ToolShelfEditForm.DIVDelFlag).val(0);//版本号
				$(ToolShelfEditForm.DivVersion).val(0);//版本号
				$('#ToolShelfEditForm').attr('action','toolshelfAdd.action'); 
				$.dialog({
					id:'ToolShelfEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('ToolShelfEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#ToolShelfEditForm').form('submit',{
								success:function(d){
									$('#ToolShelfEditForm :input').removeClass('u-ipt-err');
									$('#ToolShelfEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  	});	
										if($.parseJSON(d).status >= 0){
										  //插入成功
										  artDialog($.parseJSON(d).message,"OK");
										 	search('list');
											if($(ToolShelfEditForm.opt).val()!='edit'){
												$('#list').grid('load',1);
											}else{
												$('#list').grid('load');
											}
										 	 //关闭	DIV
										 	 $.dialog.list['ToolShelfEdit_dialog'].close();
										}else if($.parseJSON(d).status == -1){
											artDialog(d.message,"OK");
										}else {
										    artDialog(setContorllBackColor($('#ToolShelfEditForm'),$.parseJSON(d).message),"OK");
										}
								}
							});
							return false;
						}
					}]
				});
				return false;
			}
			
			/**
			* 删除处理
			*/
			function del(id,version,time,user,obj){
				$.dialog.confirm('${session.lang.UserDelInfo}',function(){
				    var param = {
					toolshelfID:id,
					}
					$.ajax({
						url:"toolshelfDelete.action",
						type: "post",
						dataType:"json",
						data:param,
						success:function(d){
							if(d.status >= 0){
								$('#list').grid('load');
							}
							artDialog(d.message,"OK");
						}
					});
				});
			}		
		</script>
	</head>
	<body>
		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
			<span>${sessionScope.lang.b08s014pageTitle}</span>
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
								${sessionScope.lang.ToolShelfCodeText}
							</th>
							<td>
								<input name="ToolShelfCode" type="text" class="u-sel" maxlength="5">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search('list')">${sessionScope.lang.submitSearchText}</button>
					    <button type="button" class="u-btn2" onclick="return add_toolShelf()">${sessionScope.lang.submitAddText}</button>
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
		<div id="ToolShelfEdit" class="f-dn">
			<form id="ToolShelfEditForm" name="ToolShelfEditForm"
				method="post">
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th width="150">
							${sessionScope.lang.ToolShelfCodeText}
						</th>
						<td>
							<input name="DivToolShelfCode" type="text" class="u-sel" maxlength="5">
						</td>
					</tr>
				</table>
			</form>
		</div>
	</body>
</html>

