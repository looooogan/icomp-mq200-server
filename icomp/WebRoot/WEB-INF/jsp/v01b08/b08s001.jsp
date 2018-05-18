<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<%@ include file="../common/header_common.jsp"%>
		<style type="text/css">
		*{ margin:0; padding:0;}
		.box{ width:200px; position:relative}
		.a, .b{ position:absolute; top:0px; left:0px;}
		/* 文本输入框 */
	.u-ipt-08001{width:180px;padding:5px;height:17px;border:1px solid #D9D9D9;border-top-color:#c0c0c0;line-height:17px;font-size:14px;color:#777;background:#fff;}
	.u-sel-08001{width:200px;padding:5px;height:30px;border:1px solid #D9D9D9;border-top-color:#c0c0c0;font-size:14px;color:#777;background:#fff;}	
		
		</style>
		<script type="text/javascript">
		jQuery(function(){
			jQuery('body').layout({
				//center__maskContents:true,
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
			jQuery('#list').grid({
				url:'B08S001.action?opt=list',
				data:{},
				datatype:'json',
				type:'post',
				width:'100%',
				fit:false,
				lazy:false,
				async:true,
				keyname:'capabilityID',
				column:[{
					title:'${session.lang.CapabilityNameText}',
					name:'capabilityName',
					visible:'${session.gridcol.capabilityName}'
				},{
					title:'${session.lang.CapabilityLevelText}',
					name:'capabilityLevel',
					visible:'${session.gridcol.capabilityLevel}'
				},{
					title:'${session.lang.BelongFlagText}',
					name:'belongFlag',
					format:function(r){
						return '<span class="ui-grid-tdtx">'+(r.belongFlag=='0'?'${session.lang.BrowserText}':'${session.lang.HandSetText}')+'</span>';
					},
					visible:'${session.gridcol.belongFlag}'
				},{
					title:'${session.lang.CapabilityTypeText}',
					name:'capabilityType',
					visible:'${session.gridcol.capabilityType}',
					format:function(r){
						return '<span class="ui-grid-tdtx">'+(r.belongFlag=='0'?r.capabilityLevel=='3'?'${session.lang.OrdinaryText}':'${session.lang.MenuText}':r.capabilityLevel=='3'?'${session.lang.AuthorizationText}':'${session.lang.MenuText}')+'</span>';
					}
				},{
					title:'${session.lang.OperationText}',
					name:'option',
					width:'138px',
					format:function(r,t){
						return option(r);
					}
				}],
				addrow:function(r,t){
					if(r.capabilityLevel == 1){
						$(t).children('td').css({backgroundColor:'#fef6e6'})
					}
				},
				rowlist:[15,20,25,30],
				rowno:true,
				tree:true,
				treecolumn:'capabilityName',
				success:function(d){
				}
			});
			
			
		});
		function option(r){
			var $ul = $('<ul class="u-option"></ul>');
			var $li = $('');
			var ary_li = new Array();
			if(r.capabilityLevel <= 2){
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.AddSubMenuText}</a></li>').click(function(){add(0,r.capabilityID)}));
			}
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.capabilityID,this)}));
			ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){del(r.capabilityID,r.version,r.updateTime,r.updateUser,this)}));
			$.each(ary_li,function(i,o){
				$li.after(o);
			});
			return $ul.append($li);
		}
		
		//编辑
		function edit(id,obj){
			$.ajax({
				url:'capabilityInfo.action?rand=' + Math.random()*10000,
				dataType:'json',
				data:{opt:'get',DivCapabilityID:id},
				success:function(d){
					if(d.status < 0){
				     	artDialog(d.message,"OK");
				    }else{
						wd_capablitiyEdit(2,d,id);
					}
				}
			});
		}
		
		//新建
		function add(opt,id){
			var param;
			if(opt == 0){//新建子项
		    	param = {
					opt:'addNode',
					DivCapabilityID:id
					}
		    }else if(opt == 1){//新建根目录
		        param = {
					opt:'addRoot',
					DIV_BelongFlag:$(capablitiyEdit.DIV_BelongFlag).val()
					}
		    }
			$.ajax({
				url:'capabilityInfo.action?rand=' + Math.random()*10000,
				dataType:'json',
				data:param,
				success:function(d){
				    if(d.status < 0){
				     	artDialog(d.message,"OK");
				    }else{
						wd_capablitiyEdit(opt,d,id);
					}
				}
			});
		}
		
		//删除
		function del(id,version,time,user,obj){
			$.dialog.confirm('${session.lang.CapabilityDelInfo}',function(){
				var param = {
					capabilityID:id,
					version:version,
					updatetime:time,
					updateuser:user
					}
				$.ajax({
					url:'capabilityDel.action?rand=' + Math.random()*10000,
					dataType:'json',
					data:param,
					success:function(d){
						if(d.status >= 0){
						    var param = {
							   n_lvevl:'',
							   nodeid:''
							}
						    $('#list').grid('data',param);
							$('#list').grid('load',1);
						}
						artDialog(d.message,"OK");
					}
				});
			});
		}

		//*************************************************
		var opType;		//判断当前页面是新建还是修改
		var codeOld;	//非重复校验输入的旧值
		//*************************************************
		//添加功能
		function wd_capablitiyEdit(opt,data,id){
		    $('#capablitiyEdit').form('reset');
		    var title;
		    $(capablitiyEdit.DIV_CapabilityLevel).removeAttr("disabled");//启用级别
		    $(capablitiyEdit.DIV_CapabilityOrder).removeAttr("disabled");//启用顺序
		    checkDIV_CapabilityID(opt,data);
		    if(opt == 0){//新建子项
		    	title = '${session.lang.AddSubMenuText}';
		    	$(capablitiyEdit.DivCapabilityID).val(data.data.capabilityID);//功能ID
		    	$(capablitiyEdit.DIV_CapabilityID).val(data.data.capabilityID);
		    	$(capablitiyEdit.opt).val('addNode');
		    	$('#capablitiyEdit').attr('action','capabilityAdd.action');
		    	$(capablitiyEdit.DIV_CapabilityLevel).val(data.data.capabilityLevel +1);
		    	$(capablitiyEdit.DivVersion).val(0);//版本号
		    	$(capablitiyEdit.DIV_DelFlag).val(0);
		    	 changeBelongFlag(id);
		    }else if(opt == 1){//新建根目录
		    	$('#capablitiyEdit').attr('action','capabilityAdd.action');
		        title = '${session.lang.AddMenuText}';
		        $(capablitiyEdit.opt).val('addRoot');
		        $(capablitiyEdit.DIV_CapabilityLevel).val(1);
		        $('#capablitiyEdit').attr('action','capabilityAdd.action');
		        $(capablitiyEdit.DivVersion).val(0);//版本号
		        $(capablitiyEdit.DIV_DelFlag).val(0);
		        changeBelongFlag(id);
		    }else if(opt == 2){//项目编辑
		        title = '${session.lang.EditMenuText}';
		        $(capablitiyEdit.DivCapabilityID).val(data.data.capabilityID);//功能ID
		        $(capablitiyEdit.DIV_CapabilityID).val(data.data.capCapabilityID);
		        $(capablitiyEdit.DIV_LanguageCode).val(data.data.languageCode);
		        $(capablitiyEdit.DIV_CapabilityName).val(data.data.capabilityName);
		        $(capablitiyEdit.DIV_CapabilityCode).val(data.data.capabilityCode);
		        $(capablitiyEdit.DIV_CapabilityLevel).val(data.data.capabilityLevel);
		        $(capablitiyEdit.DIV_CapabilityOrder).val(data.data.capabilityOrder);
		        $(capablitiyEdit.DIV_CapabilityLevel).attr("disabled","");//禁用级别
				$(capablitiyEdit.DIV_CapabilityOrder).attr("disabled","");//禁用顺序
		        $(capablitiyEdit.DIV_BelongFlag).val(data.data.belongFlag);
		        $(capablitiyEdit.DIV_CapabilityImg).val(data.data.capabilityImg);
		        $(capablitiyEdit.DIV_CapabilityUrl).val(data.data.capabilityUrl);
		        $(capablitiyEdit.DIV_MenuFlag).val(data.data.menuFlag);
		        $(capablitiyEdit.DIV_DelFlag).val(data.data.delFlag);
		        $(capablitiyEdit.DivVersion).val(data.data.version);
		        $(capablitiyEdit.DivUpdateUser).val(data.data.updateUser);
		        $(capablitiyEdit.DivUpdateTime).val(data.data.updateTime);
		        var FlowIDText="";
				 $("select[name='DIV_CapabilityID'] option:selected").each(function () {
	                FlowIDText = $(this).text() + "";
	              });
		        $(capablitiyEdit.DIV_CapabilityID_2).val(FlowIDText.trim());
		        $(capablitiyEdit.opt).val('edit');
		        $('#capablitiyEdit').attr('action','capablitiyEdit.action');
		    }
			$.dialog({
				id:'wd_capablitiyEdit_dialog',
				title:title,
				lock: true,
				content:document.getElementById('wd_capablitiyEdit'),
				button:[{
					name:'${session.lang.submitSaveText}',
					focus:true,
					callback:function(){
						$('#capablitiyEdit').form('submit',{
							success:function(d){
								var json = $.parseJSON(d);
								$('#capablitiyEdit :input').removeClass('u-ipt-err');
									$('#capablitiyEdit').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  });
									if(json.status >= 0){
										var param = {
										   n_lvevl:'',
										   nodeid:''
										}
									    $('#list').grid('data',param);
										$('#list').grid('load',1);
										artDialog($.parseJSON(d).message,"OK");
										$.dialog.list['wd_capablitiyEdit_dialog'].close();
										location.reload();
									} else if($.parseJSON(d).status == -1){
										    artDialog($.parseJSON(d).message,"OK");
									}else {
									    //控件描红
									    //弹出消息
									    
									    artDialog(setContorllBackColor($('#capablitiyEdit'),$.parseJSON(d).message),"OK");
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
			
			
		//上级功能加载	
		function checkDIV_CapabilityID(opt,data){
			$("#capablitiyEdit select[name=DIV_CapabilityID]").empty();
			if(opt == 0||opt == 2){
			$("#base_div_CapabilityID option").each(function(){
							if(this.value==data.data.capabilityID){
								var $op=$(this).clone();
								$("#capablitiyEdit select[name=DIV_CapabilityID]").append($op);
							}
						});}
			if(opt == 2){
			$("#base_div_CapabilityID option").each(function(){
							if(this.value==data.data.capCapabilityID){
								var $op=$(this).clone();
								$("#capablitiyEdit select[name=DIV_CapabilityID]").append($op);
							}
						});}
			if(opt == 1){
			$("#capablitiyEdit select[name=DIV_CapabilityID]").append("<option value=''>无</option>");
			}
			
		}
		
			function changeBelongFlag(id){
			var param;
			var optStr;
			if($(capablitiyEdit.DIV_CapabilityID).val() == ''){
				optStr='addRoot';
			}else{
				optStr='addSUB';
			}
				param = {
					opt:optStr,
					DIV_BelongFlag:$(capablitiyEdit.DIV_BelongFlag).val(),
					DivCapabilityID:id
				}
				$.ajax({
					url:"capabilityInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					async:'true',
					success:function(d){
						if(d.status < 0){
					      artDialog(d.message,"OK");
					    }else{
					      $(capablitiyEdit.DIV_CapabilityOrder).val(d.data.capabilityOrder +1);
					   }
					}
				});
			}
		</script>
	</head>
	<body>
		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b08s001pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptt">
					${sessionScope.lang.capablitiyListTitle}
				</div>
				<div class="f-fr" style="margin-bottom: 4px;">
					<a href="javascript:void(0)" onclick="add(1)" class="u-btn">${sessionScope.lang.AddMenuText}</a>
				</div>
			</div>

			<div class="ui-layout-center">
				<table id="list"></table>
			</div>
		</div>

		<div id="wd_capablitiyEdit" class="f-dn">
			<form id="capablitiyEdit" name="capablitiyEdit" method="post">
				<input type="text" class="f-dn" name="opt" value="add" />
				<input type="text" class="f-dn" name="DivCapabilityID" />
				<input type="text" class="f-dn" name="DIV_DelFlag" value="0" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
				<input type="text" class="f-dn" name="DIV_CapabilityLevel" />
				<input type="text" class="f-dn" name="DIV_CapabilityImg"  value=""/>
				<input type="text" class="f-dn" name="DIV_CapabilityOrder" />
				<table class="m-frmtb" width="100%">
					<tr>
						<th>
							${sessionScope.lang.CapCapablitiyText}
						</th>
						<td class="box">
	                        	<select class="u-sel" name="DIV_CapabilityID">
	                        	</select>
						</td>
						<th width="150">
							${sessionScope.lang.LanguageText}
						</th>
						<td>
							<select class="u-sel" name="DIV_LanguageCode">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.LanguageCodeList" id="languagetable">
									<option value="${languagetable.languageCode}">
										${languagetable.languageName}
									</option>
								</s:iterator>
							</select>
						</td>
					</tr>
					<tr>
						<th>
							${sessionScope.lang.CapabilityNameText}
						</th>
						<td>
							<input type="text" class="u-ipt" name="DIV_CapabilityName" maxlength="40"/>
						</td>
						<th>
							${sessionScope.lang.CapabilityCodeText}
						</th>
						<td>
							<input type="text" class="u-ipt" name="DIV_CapabilityCode" maxlength="36"/>
						</td>
					</tr>
					<tr>
						<th>
							${sessionScope.lang.IsMenuText}
						</th>
						<td>
							<select class="u-sel" name="DIV_MenuFlag">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.MenuFlagList" id="comlist">
									<option value="${comlist.comListValue}">
										${comlist.comListText}
									</option>
								</s:iterator>
							</select>
						</td>
					
						<th>
							${sessionScope.lang.BelongFlagText}
						</th>
						<td>
							<select class="u-sel" name="DIV_BelongFlag" onchange="return changeBelongFlag()">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.BelongFlagList" id="comlist">
									<option value="${comlist.comListValue}">
										${comlist.comListText}
									</option>
								</s:iterator>
							</select>
						</td>
						</tr>
					<tr>
						<th>
							${sessionScope.lang.CapabilityUrlText}
						</th>
						<td>
							<input type="text" class="u-ipt" name="DIV_CapabilityUrl" maxlength="40"/>
						</td>
					</tr>
				</table>
			</form>
		</div>
		<div id="base_div" class="f-dn">
		<select class="u-sel-08001" id="base_div_CapabilityID" class="f-dn">
								<option value="">
									--${sessionScope.lang.PleaseSelect}--
								</option>
								<s:iterator value="#request.CapabilityIDList" id="capability">
									<option value="${capability.capabilityID}">
										${capability.capabilityName}
									</option>
								</s:iterator>
		</select>
		</div>
	</body>
</html>

