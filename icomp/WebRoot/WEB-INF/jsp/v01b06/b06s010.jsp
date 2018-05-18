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
					//url:'init.action?opt=list',
					barid:'#bar',
					datatype:'json',
					type:'post',
					width:'100%',
					fit:true,
					lazy:false,
					async:true,
					rowno:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.DiscardeTimeText}',
						name:'discardeTime',
						visible:'${session.gridcol.discardeTime}'
					},{
						title:'${session.lang.ToolCodeText}',
						name:'toolCode',
						visible:'${session.gridcol.toolCode}'
					},{
						title:'${session.lang.ToolConsumetypeText}',
						name:'toolConsumetypeText',
						visible:'${session.gridcol.toolConsumetype}'
					},{
						title:'${session.lang.ToolCountText}',
						name:'toolCount',
						visible:'${session.gridcol.toolCount}'
					},{
						title:'${session.lang.DiscardeFlagText}',
						name:'discardeFlag',
						visible:'${session.gridcol.discardeFlag}',
						format: function(r){
						return '<span class="ui-grid-tdtx">'+(r.discardeFlag == '0'?'${session.lang.yesFlag}':'${session.lang.noFlag}')+'</span>';
						}
					},{
						title:'${session.lang.OperationText}',
						name:'',
						width:'130px',
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
				if(r.discardeFlag == '0'){
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.btnConform}</a></li>').click(function(){save(r.toolCode,r.discardeTime,this)}));
				}
				$.each(ary_li,function(i,o){
					$li.after(o);
				});
				return $ul.append($li);
			}
			
			/**
			* 保存报废确认信息
			*/
			function save(toolCode,discardeTime){
				var param = {
					ToolCode:toolCode,
					DiscardeTime:discardeTime
				}
				$.ajax({
					url:"b06S010Save.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
						if(d.status < 0){
					     artDialog(d.message,"OK");
					    }else{
							search();
						}
					}
				});
			}
			/**
			* 查询处理
			*/
			function search(){
				var param = {
					opt:'list',
					ToolCode:$(searchFrom.ToolCode).val(),
					dstar:$(searchFrom.dstar).val(),
					dend:$(searchFrom.dend).val(),
					DiscardeFlag:$(searchFrom.DiscardeFlag).val(),
					ToolConsumetype:$(searchFrom.ToolConsumetype).val()
				}
				$('#list').grid('url','B06S010.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}
		</script>
	</head>
	<body>

		<div class="ui-layout-north g-ct-tt">
			<div class="g-ct-ttc">
				<span>${sessionScope.lang.b06s010pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="searchFrom" name="searchFrom" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.ToolCodeText}
							</th>
							<td>
								<input name="ToolCode" type="text" class="u-ipt" maxlength="50">
							</td>
							<th width="150">
								${sessionScope.lang.DiscardeTimeText}
							</th>
							<td>
								<input name="dstar" type="text" class="u-ipt Wdate"
									onclick="WdatePicker()">
								~
								<input name="dend" type="text" class="u-ipt Wdate"
									onclick="WdatePicker()">
							</td>
						</tr>
						<tr>
							<th width="150">
								${sessionScope.lang.DiscardeFlagText}
							</th>
							<td>
								<select class="u-sel" name="DiscardeFlag">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<option value="0">
										${sessionScope.lang.yesFlag}
									</option>
									<option value="1">
										${sessionScope.lang.noFlag}
									</option>
								</select>
							</td>
							<th width="150">
								${sessionScope.lang.ToolConsumetypeText}
							</th>
							<td>
								<select class="u-sel" name="ToolConsumetype">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
									<s:iterator value="#request.ToolConsumeTypeList" id="comlist">
										<s:if
											test='%{#comlist.comListValue == #request.ToolConsumetype}'>
											<option value="${comlist.comListValue}">
												${comlist.comListText}
											</option>
										</s:if>
										<s:else>
											<option value="${comlist.comListValue}">
												${comlist.comListText}
											</option>
										</s:else>
									</s:iterator>
								</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="submit" class="u-btn2" onclick="return search()">
							${sessionScope.lang.submitSearchText}
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
	</body>
</html>

