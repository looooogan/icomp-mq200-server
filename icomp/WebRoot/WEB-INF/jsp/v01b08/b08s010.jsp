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
					rowEdit:true, //合并单元格为true
					rows:12,//本页面12条数据分页
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
					column:[{
						title:'${session.lang.Year}',
						name:'productionYear',
					},{
						title:'${sessionScope.lang.AssemblyLineNameText}',
						name:'assemblyLineName',
					},{
						title:'${session.lang.Quarter}',
						name:'productionQuarter',
					},{
						title:'${session.lang.Month}',
						name:'productionMonth',
					},{
						title:'${session.lang.PlannedOutput}',
						name:'production',
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
				ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.productionYear,r.assemblyLineID,r.version,this)}));
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
					ProductionYear:$(searchForm.ProductionYear).val(),
					AssemblyLineID:$(searchForm.AssemblyLineID).val(),
				}
				$('#list').grid('url','B08S010.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}	
			/**
			* 新建处理
			*/
			function add_ProductionDesign(data,year,assemblyLineID,obj){
				$('#ProductionDesignEditForm').form('reset');
				var title = '${session.lang.submitAddText}';
				$('#ProductionDesignEditForm :input').removeClass('u-ipt-err');
				$('#ProductionDesignEditForm').find("*").each(function () { 
	    		  if($(this).hasClass("u-sel")){
	    			$(this).removeAttr("style");
	    		  }
	    	    });
	    	    if(typeof(data) == 'object'){
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_1).val(data.rows[0].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_2).val(data.rows[1].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_3).val(data.rows[2].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_4).val(data.rows[3].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_5).val(data.rows[4].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_6).val(data.rows[5].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_7).val(data.rows[6].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_8).val(data.rows[7].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_9).val(data.rows[8].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_10).val(data.rows[9].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_11).val(data.rows[10].production);//年
	    	   		$(ProductionDesignEditForm.DivAssemblyLineAmount_12).val(data.rows[11].production);//年
	    
	    	   		$(ProductionDesignEditForm.ProductionYear).val(data.rows[1].productionYear);//年
	    	   		$(ProductionDesignEditForm.DivUpdateUser).val(data.rows[1].updateUser);//更新者
					$(ProductionDesignEditForm.DivUpdateTime).val(data.rows[1].updateTime);//更新时间
					$(ProductionDesignEditForm.DivVersion).val(data.rows[1].version);//版本号
					$(ProductionDesignEditForm.DivDelFlag).val(data.rows[1].delFlag);//删除区分
					$('#ProductionDesignEditForm').attr('action','productionDesignEdit.action'); 
	    	    }else{
					$(ProductionDesignEditForm.DivDelFlag).val(0);//删除区分
					$(ProductionDesignEditForm.DivVersion).val(0);//版本号
					$('#ProductionDesignEditForm').attr('action','productionDesignAdd.action'); 
				}
				$.dialog({
					id:'ProductionDesignEdit_dialog',
					title:title,
					lock: true,
					content:document.getElementById('ProductionDesignEdit'),
					button:[{
						name:'${session.lang.submitSaveText}',
						focus:true,
						callback:function(){
							$('#ProductionDesignEditForm').form('submit',{
								success:function(d){
									$('#ProductionDesignEditForm :input').removeClass('u-ipt-err');
									$('#ProductionDesignEditForm').find("*").each(function () { 
						    		  if($(this).hasClass("u-sel")){
						    			$(this).removeAttr("style");
						    		  }
						    	  	});	
										if($.parseJSON(d).status >= 0){
										  //新建成功
										  artDialog($.parseJSON(d).message,"OK");
										 	search('list');
												$('#list').grid('load',1);
										 	 //关闭	DIV
										 	 $.dialog.list['ProductionDesignEdit_dialog'].close();
										}else {
										    artDialog(setContorllBackColor($('#ProductionDesignEditForm'),$.parseJSON(d).message),"OK");
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
			* 编辑处理
			*/
			function edit(year,assemblyLineID,version,obj){
				var param = {
					Year:year,
					AssemblyLineID:assemblyLineID,
					opt:'edit',
					Version:version
				}
				$.ajax({
					url:"productionDesignInfo.action",
					type: "post",
					dataType:"json",
					data:param,
					success:function(d){
 						if(d.status < 0){
					    	artDialog(d.message,"OK");
					    }else{
							add_ProductionDesign(d,year,assemblyLineID,obj);
						}
					}
				});
			}
/***************************************合并单元格   ******************rowEdit:true, //合并单元格开关***************/
			/*
			 * 合并单元格   
			 * parts：rowSapn 参照合并列索引
			*/
			function _w_table_rowspan(rowSpan){
				//合并显示状态的第1列
				var textArr = getHtml(2);//根据年分组
				var count = $('#list tbody tr').length;//总行的数量
				var countArr = findCount(textArr);//相邻相同的数量 
				var showRow = rowCount(countArr);//显示的数量
				doRowspan(countArr,showRow,1);//合并零部件名称
				doRowspan(countArr,showRow,2);//合并零部件名称
				doRowspan(countArr,showRow,6);//合并操作列
				
				var textArr1 = getHtml(3);//根据季度分组
				var count1 = $('#list tbody tr').length;//总行的数量
				var countArr1 = findCount(textArr1);//相邻相同的数量 
				var showRow1 = rowCount(countArr1);//显示的数量
				doRowspan(countArr1,showRow1,3);//合并零部件名称
			}
			
			function doFirstRowSpan(RowNum){
				var firsttd = "";
				var currenttd = "";
				var SpanNum =  0;
				var Obj  = $('#list tbody tr td:nth-child('+RowNum+')');
				//获取总行的数量
				Obj.each(function(i){
					if(i==0){
						firsttd = $(this);
						SpanNum = 1;
				   	}else{		
				   		currenttd = $(this);
						if(firsttd.text()==currenttd.text()){
					   		SpanNum++;
					   		currenttd.hide(); //remove();
					  		firsttd.attr("rowSpan",SpanNum);
					    }else{
					     	firsttd = $(this);
					     	SpanNum = 1;
					    }
				   }
			  }); 
			}
					
		
function getHtml(col){
	  var textArr = new Array();
	  var colIndex = 0;
	  $('#list tbody tr').each(function(){ 
	  		$('td', this).each(function() { 
				//找到主要合并的列
	  			if($(this).index() == col){ 
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
			<span>${sessionScope.lang.b08s010pageTitle}</span>
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
								${session.lang.Year}
							</th>
							<td>
							<select class="u-sel" name="ProductionYear">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
								<s:iterator value="#request.yearList" id="year">
									<option value="${year.productionYear}" >
										${year.productionYear}
									</option>
								</s:iterator>
							</select>
							</td>
							<th width="150">
								${sessionScope.lang.AssemblyLineNameText}
							</th>
							<td>
							<select class="u-sel" name="AssemblyLineID">
									<option value="">
										--${sessionScope.lang.PleaseSelect}--
									</option>
								<s:iterator value="#request.listAssemblyline" id="AssemblyLine">
									<option value="${AssemblyLine.assemblyLineID}" >
										${AssemblyLine.assemblyLineName}
									</option>
								</s:iterator>
							</select>
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" onclick="return search('list')">${sessionScope.lang.submitSearchText}</button>
					    <button type="button" class="u-btn2" onclick="return add_ProductionDesign()">${sessionScope.lang.submitAddText}</button>
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
		<div id="ProductionDesignEdit" class="f-dn">
			<form id="ProductionDesignEditForm" name="ProductionDesignEditForm"
				method="post">
				<input type="text" class="f-dn" name="opt" />
				<input type="text" class="f-dn" name="DivVersion" />
				<input type="text" class="f-dn" name="DivDelFlag" />
				<input type="text" class="f-dn" name="DivUpdateUser" />
				<input type="text" class="f-dn" name="DivUpdateTime" />
					<table  class="m-frmtb">
						<tr>
							<th width="80">
								${sessionScope.lang.AssemblyLineNameText}
							</th>
							<th width="80">
								${session.lang.Year}
							</th>
							<th width="80">
								${session.lang.Quarter}
							</th>
							<th width="80">
								${session.lang.Month}
							</th>
							<th >
								${session.lang.PlannedOutput}
							</th>
						</tr>
						<tbody >
							<tr>
								<td rowspan="12">
									<select class="u-sel" name="AssemblyLineID">
									<s:iterator value="#request.listAssemblyline" id="AssemblyLine">
										<option value="${AssemblyLine.assemblyLineID}" selected>
											${AssemblyLine.assemblyLineName}
										</option>
									</s:iterator>
								</select>
								</td>
								<td rowspan="12" >
									<input name="ProductionYear" type="text"  maxlength="4" class="u-ipt" >
								</td>
								<td rowspan="3">
									${session.lang.FirstQuarter}
								</td>
								<td>
									${session.lang.January}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_1" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.February}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_2" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.March}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_3" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td rowspan="3">
									${session.lang.SecondQuarter}
								</td>
								<td>
									${session.lang.April}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_4" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.May}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_5" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.June}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_6" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td rowspan="3">
									${session.lang.ThirdQuarter}
								</td>
								<td>
									${session.lang.July}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_7" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.August}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_8" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.September}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_9" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td rowspan="3">
									${session.lang.FourthQuarter}
								</td>
								<td>
									${session.lang.October}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_10" class="u-ipt" maxlength="11"   >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.November}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_11" class="u-ipt" maxlength="11"  >
								</td>
							</tr>
							<tr>
								<td>
									${session.lang.December}
								</td>
								<td>
								<input name="DivAssemblyLineAmount_12" class="u-ipt" maxlength="11" >
								</td>
							</tr>
						</tbody>
					</table>
			</form>
		</div>
	</body>
</html>

