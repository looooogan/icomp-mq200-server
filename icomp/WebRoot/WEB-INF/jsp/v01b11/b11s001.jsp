<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.icomp.entity.base.Capability"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="../common/header_common.jsp"%>
		<script type="text/javascript">
			var code;
			/**树节点**/
			var zNodes =[
				<%
				for(Capability ca:(List<Capability>)request.getAttribute("GruanList")){
				%>{ id:<%=ca.getzTreeId()%>, pId:<%= ca.getzTreeParentId()%>,value:'<%=ca.getCapabilityID()%>', name:'<%=ca.getCapabilityName()%>'},<%
				}%>
				{ id:1, pId:0, name:"${session.lang.BrowserText}", nocheck:true},
				{ id:2, pId:0, name:"${session.lang.HandSetText}", nocheck:true},
				{ id:9, pId:0, name:"${session.lang.CommonText}", nocheck:true}
			];
			
			/**树的加载**/
			$(function(){
				$.fn.zTree.init($("#treeDemo"), setting, zNodes);
				setCheck();
			});
			
			function showCode(str) {
				if (!code) code = $("#code");
				code.empty();
				code.append("<li>"+str+"</li>");
			}
			
			/**节点筛选条件**/	
			function filter(node) {
			    return (node.level >0);
			}
			/**树的基本设置**/			
			var setting = {
				check: {
					enable: true
				},
				view: {
					showIcon: false
				},
				data: {
					simpleData: {
						enable: true
					}
				}
			};
			function setCheck() {
				setting.check.chkboxType = { "Y" : "ps", "N" : "ps" };
			}
			
			/** 查询处理**/
			function search(){
			var zTree = $.fn.zTree.getZTreeObj("treeDemo"),
			nodes = zTree.getSelectedNodes();
			zTree.checkAllNodes(false);
			var param = {
					PositionID:$(capablitiyGrunt.PositionID).val(),
					opt:'get'
				}
				$.ajax({
					url:'B11S001.action?rand=' + Math.random()*10000,
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status > 0){
						  	artDialog(d.message,"OK");
					    }else{
					    	nodes = zTree.getNodes();
					    	var nodes = zTree.getNodesByFilter(filter); // 查找节点集合
					    	for (var i=0, l=nodes.length; i<l; i++) {
					    		for (var j=0, n=d.rows.length; j<n; j++) {
						    		if(nodes[i].value==d.rows[j].capabilityID){
										zTree.checkNode(nodes[i], true, false, true);
						    		}
					    		}
					    	}
						}
					}
				});
				
			}
						/**
			* 保存处理
			*/
			function saveGruant(){
				var zTree = $.fn.zTree.getZTreeObj("treeDemo");
				var checkedNodes = zTree.getCheckedNodes(true);
			    var count=checkedNodes.length;
			    var ids=new Array();
			    for(var i=0;i<count;i=i+1){
			        ids.push(checkedNodes[i].value);
			    }
			    ids=ids.join(",");
			    var param ={
			   		PositionID:$(capablitiyGrunt.PositionID).val(),
					capabilityID:ids
			    };
				$.ajax({
					url:'gruantSave.action?rand=' + Math.random()*10000,
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
					    	zTree.checkAllNodes(false);
					    	var nodes = zTree.getNodesByFilter(filter); // 查找节点集合
					    	for (var i=0, l=nodes.length; i<l; i++) {
					    		for (var j=0, n=d.rows.length; j<n; j++) {
						    		if(nodes[i].value==d.rows[j].capabilityID){
										zTree.checkNode(nodes[i], true, false, true);
						    		}
					    		}
					    	}
						  artDialog(d.message,"OK");
						}
					}
				});
				return false;
			}
			/**
			* 取得机构下的部门
			*/
			function selAgency(){
				var param = {
					AgencyID:$(capablitiyGrunt.AgencyID).val()
				};
				$.ajax({
					url:'selAgency.action?rand=' + Math.random()*10000,
					type: "post",
					dataType:"json",
					data:param,
					async:'true',
					success:function(d){
						if(d.status < 0){
					     $(capablitiyGrunt.DepartmentID).find('option').remove();
					     	 $(capablitiyGrunt.PositionID).find('option').remove();
					     	 $(capablitiyGrunt.DepartmentID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					     	 $(capablitiyGrunt.PositionID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					    }else{
					     	 $(capablitiyGrunt.DepartmentID).find('option').remove();
					     	 $(capablitiyGrunt.PositionID).find('option').remove();
					     	 $(capablitiyGrunt.DepartmentID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					     	 $(capablitiyGrunt.PositionID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					     	  $.each(d.data,function(key,val){
						  	  	 $(capablitiyGrunt.DepartmentID).append("<option value='"+val.departmentID+"'>"+val.departmentName+"</option>");
						  	  });
					   }
					}
				});
			}

			
			/**
			* 取得部门下的职务
			*/
			function selDepartment(){
				var param = {
						DepartmentID:$(capablitiyGrunt.DepartmentID).val(),
						AgencyID:$(capablitiyGrunt.AgencyID).val()
					};
				$.ajax({
					url:'selDepartment.action?rand=' + Math.random()*10000,
					type: "post",
					dataType:"json",
					data:param,
					async:'true',
					success:function(d){
						if(d.status < 0){
					      $(capablitiyGrunt.PositionID).find('option').remove();
				     	  $(capablitiyGrunt.PositionID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
					    }else{
				     	  $(capablitiyGrunt.PositionID).find('option').remove();
				     	  $(capablitiyGrunt.PositionID).append("<option value=''>--"+'${sessionScope.lang.PleaseSelect}'+"--</option>");
				     	  $.each(d.data,function(key,val){
					  	  	 $(capablitiyGrunt.PositionID).append("<option value='"+val.positionID+"'>"+val.positionName+"</option>");
					  	  });
					  }
					}
				});
			}
			function changeCheck(id,pid,level,checked){
				if(checked){
				  if(level >1){
				  	$(":checkbox[id='rid_"+ pid +"']").attr('checked',true);
				  	changeCheck(pid,$(":checkbox[id='rid_"+ pid +"']").attr('tag'),level -1,true);
				  }	
				}else{
				  if(level <3){
				    $(":checkbox[tag='"+ id +"']").attr('checked',false);
				    $.each($(":checkbox[tag='"+ id +"']"),function(key,val){
				       changeCheck($(this).val(),$(this).attr('tag'),level + 1,false);
				    });
				  }
				}
			}

		</script>
	</head>
	<body>
		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>当前页:首页 > 用户管理模块> 权限管理</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="capablitiyGrunt" name="capablitiyGrunt" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.AgencyText}
							</th>
							<td>
								<select class="u-sel" name="AgencyID"
									onchange="return selAgency()">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.AgencyList" id="agency">
										<s:if test='%{#agency.agencyID == #request.AgencyID}'>
											<option value="${agency.agencyID}" selected>
												${agency.agencyName}
											</option>
										</s:if>
										<s:else>
											<option value="${agency.agencyID}">
												${agency.agencyName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.DepartmentText}
							</th>
							<td>
								<select class="u-sel" name="DepartmentID"
									onchange="return selDepartment()">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.DepartmentList" id="department">
										<s:if
											test='%{#department.departmentID == #request.DepartmentID}'>
											<option value="${department.departmentID}" selected>
												${department.departmentName}
											</option>
										</s:if>
										<s:else>
											<option value="${department.departmentID}">
												${department.departmentName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>

							<th width="150">
								${sessionScope.lang.PositionText}
							</th>
							<td>
								<select class="u-sel" name="PositionID">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.PositionList" id="position">
										<s:if test='%{#position.positionID == #request.PositionID}'>
											<option value="${position.positionID}" selected>
												${position.positionName}
											</option>
										</s:if>
										<s:else>
											<option value="${position.positionID}">
												${position.positionName}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
						</button>
						<button type="button" class="u-btn2" onclick="return saveGruant()">
							${sessionScope.lang.submitSaveText}
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
		<div class="zTreeDemoBackground left">
			<table width="100%" class="m-frmtb">
				<tr>
					<td>
						<ul id="treeDemo" class="ztree"></ul>
					</td>
				</tr>
			</table>
		</div>
	</body>
</html>

