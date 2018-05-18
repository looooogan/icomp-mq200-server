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
					async:true,
					rowno:true,
					rowEdit:true,
					//colEdit:1,
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
						title:'${session.lang.ProcuredCountText}',
						name:'procuredCount',
						visible:'${session.gridcol.procuredCount}'
					},{
						title:'${session.lang.UnitPriceText}',
						name:'unitPrice',
						visible:'${session.gridcol.unitPrice}',
						format:function(r){
							var money=fmoney(r.unitPrice,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.AmountMoneyText}',
						name:'amountMoney',
						visible:'${session.gridcol.amountMoney}',
						format:function(r){
							var money=fmoney(r.amountMoney,2);
							return '<span class="ui-grid-tdtx">'+money+'</span>';
                        }
					},{
						title:'${session.lang.CreateUserText}',
						name:'createUser',
						visible:'${session.gridcol.createUser}'
					},{
						title:'${session.lang.CreateTimeText}',
						name:'createTime',
						visible:'${session.gridcol.createTime}',
						format:function(r){
							return '<span class="ui-grid-tdtx">'+fdate(r.createTime)+'</span>';
                        }
					},{
						title:'${session.lang.ProcuredUserText}',
						name:'procuredUser',
						visible:'${session.gridcol.procuredUser}'
					},{
						title:'${session.lang.ProcuredTimeText}',
						name:'procuredTime',
						visible:'${session.gridcol.procuredTime}'
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
				* 采购计划查询
				*/
				$("#purchasePlanSubmit").click(function(){
					var param = {
							opt:'list',
							ProcuredBatch:$(purchasePlanFrom.ProcuredBatch).val(),
						}
						$('#list').grid('url','B01S008.action');
						$('#list').grid('data',param);
						$('#list').grid('load',1);
						return false;
					});

				
				});
			


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
	doRowspan(countArr,showRow,1);

}
		
function getHtml(col){
	  var textArr = new Array();
	  var colIndex = 0;
	  $('#list tbody tr').each(function(){ 
	  		$('td', this).filter(':visible').each(function() { 
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
				<span>${sessionScope.lang.b01s008pageTitle}</span>
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
								${sessionScope.lang.ProcuredBatchText}
							</th>
							<td>
								<input name="ProcuredBatch" type="text" class="u-ipt"  maxlength="20">
							</td>
						</tr>
					</table>
					<div class="g-fx1 f-fr">
						<button type="button" class="u-btn2" id="purchasePlanSubmit" >${sessionScope.lang.submitSearchText}</button>
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

