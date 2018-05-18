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
					rowEdit:true,
					rows:${session.rowsize},
					roll:6,
					pager:true,
					pagerpos:'right',
					pagercon:'first,last,number,next,prev',
				column:[{
						title:'${session.lang.synthesisParametersNumber}',
						name:'SynthesisParametersNumber',
						visible:'${session.gridcol.synthesisParametersNumber}',
						format:function(r){
						var str=r.synthesisParametersCode+','+r.synthesisParametersNumber;
						return '<span class="ui-grid-tdtx">'+str+'</span>';
						}
					},{
						title:'${session.lang.SynthesisParametersCodeText}',
						name:'synthesisParametersCode',
						visible:'${session.gridcol.synthesisParametersCode}'
					},{
						title:'${session.lang.LoadStateText}',
						name:'loadState',
						visible:'${session.gridcol.loadState}'
						
					}],
					success:function(d){
						 if(d.status < 0){
						     artDialog(d.message,"OK");
						   }
					}
				}) ; 
			});
			
			/**
			* 查询处理
			*/
			function search(){
				var param = {
					opt:'list',
					SynthesisParametersCode:$(quickForm.SynthesisParametersCode).val(),
				}
				$('#list').grid('url','B02S006.action');
				$('#list').grid('data',param);
				$('#list').grid('load',1);
				return false;
			}		
    
					/***************************************合并单元格   *********************************/
/*
*  合并单元格   
*/
function _w_table_rowspan(maxColnum){
//******首要合并列为第一列************
	//获取第一列的内容
	var textArr = getHtml(1);
	//总行的数量
	var count = $('#list tbody tr').length;
	//相邻相同的数量 
	var countArr = findCount(textArr);
	//显示的数量
	var showRow = rowCount(countArr);
	//合并第一列
	doRowspan(countArr,showRow,2);

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
				<span>${sessionScope.lang.b02s006pageTitle}</span>
				<%@ include file="../head_div.jsp" %>
			</div>
		</div>
		<div class="ui-layout-center g-ct-bd">
			<div class="ui-layout-north">
				<div class="u-ptf">
					${sessionScope.lang.searchTitle}
				</div>
				<form id="quickForm" name="quickForm" method="post">
					<table width="100%" class="m-frmtb">
						<tr>
							<th width="150">
								${sessionScope.lang.SynthesisParametersCodeText}
							</th>
							<td>
								<input name="SynthesisParametersCode" type="text" class="u-ipt" maxlength="50">
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
	</body>
</html>

