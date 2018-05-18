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
            <!-- 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC -->
            $("#DivCreateType").change(function(){
                var v = $("input[name='DivSynthesisCutterNumber[0]']").val();
                var type = $("#DivCreateType").val();
                $("#DivSynthesisCount").val("1");
                var html = '';
                html += '<thead style="display: table-header-group;">';
                html += '<tr>';
                html += '<th width="120">位置号</th>';
                html += '<th>位置类型</th>';
                html += '<th>刀具编码</th>';
                html += '<th>替换刀具编码</th>';
                html += '</tr>';
                html += '</thead>';
                html += '<tbody>';
                html += '<tr>';
                html += '<th>';
                html += '<input name="DivSynthesisCutterNumber[0]" type="text" class="f-dn" value="0">';
                html += '<p>0</p>';
                html += '</th>';
                html += '<td>';
                html += '<select class="u-sel" name="DivCutterType[0]" id="DivCutterTypeId">';
                html += '<option value="0">刀具</option>';
                html += '<option value="1">辅具</option>';
                html += '</select>';
                html += '</td>';
                html += '<td>';
                html += '<input name="DivToolCode[0]" type="text" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td>';
                html += '<input name="DivTempToolCode[0]" type="text" class="u-ipt" maxlength="45">';
                html += '<input name="replaceCode[0]" type="hidden" class="u-ipt" maxlength="45">';
                html += '</td>';
                html += '<td></td>';
                html += '</tr>';
                html += '</tbody>';
                $("#synthesisEditTable").html(html);
                if( type == "4" ){
                    $("div .aui_buttons button:first").hide();
                }else{
                    $("div .aui_buttons button:first").show();
                }
//				else{
//					var html = '';
//					html += '<thead style="display: table-header-group;">';
//					html += '<tr>';
//					html += '<th width="120">位置号</th>';
//					html += '<th>位置类型</th>';
//					html += '<th>刀具编码</th>';
//					html += '<th>替换刀具编码</th>';
//					html += '</tr>';
//					html += '</thead>';
//					html += '<tbody>';
//					html += '<tr>';
//					html += '<th>';
//					html += '<input name="DivSynthesisCutterNumber[0]" type="text" class="f-dn" value="0">';
//					html += '<p>0</p>';
//					html += '</th>';
//					html += '<td>';
//					html += '<select class="u-sel" name="DivCutterType[0]" id="DivCutterTypeId">';
//					html += '<option value="1">辅具</option>';
//					html += '</select>';
//					html += '</td>';
//					html += '<td>';
//					html += '<input name="DivToolCode[0]" type="text" class="u-ipt" maxlength="45">';
//					html += '</td>';
//					html += '<td>';
//					html += '<input name="DivTempToolCode[0]" type="text" class="u-ipt" maxlength="45">';
//					html += '</td>';
//					html += '<td></td>';
//					html += '</tr>';
//					html += '</tbody>';
//					$("#synthesisEditTable").html(html);
//
//					$("div .aui_buttons button:first").show();
//				}
            });
            <!-- 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC -->
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
                    title:'${session.lang.SynthesisParametersCodeText}',
                    name:'synthesisParametersCode',
                    visible:'${session.gridcol.synthesisParametersCode}'
                },{
                    title:'${session.lang.SynthesisCountText}',
                    name:'synthesisCount',
                },{
                    title:'${session.lang.CreateTypeText}',
                    name:'createType',
                    format:function(r){
                        if(r.createType=='0'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE0Test}</span>';
                        }else if(r.createType=='1'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE1Test}</span>';
                        }else if(r.createType=='2'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE2Test}</span>';
                        }else if(r.createType=='3'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE3Test}</span>';
                        }
                        <!-- 2017/08/23 宋健 变更↓↓↓　dazhong@YMSC -->
                        else if(r.createType=='4'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE4Test}</span>';
                        }else if(r.createType=='5'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE5Test}</span>';
                        }else if(r.createType=='6'){
                            return '<span class="ui-grid-tdtx">${session.lang.CREATETYPE6Test}</span>';
                        }
                        <!-- 2017/08/23 宋健 变更↑↑↑　dazhong@YMSC -->
                    }
                },
                    <!-- 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC -->
                    <%--{--%>
                    <%--title:'${session.lang.QuotaProcessingVolumeText}',--%>
                    <%--name:'quotaProcessingVolume',--%>
                    <%--},--%>
                    <!-- 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC -->
                    {
                        title:'${session.lang.ToolPicText}',
                        name:'toolPic',
                        visible:'${session.gridcol.toolPic}',
                        format:function(r){
                            return option(r,"ToolPicText");
                        }
                    },{
                        title:'${session.lang.OperationText}',
                        name:'-',
                        width:'130px',
                        visible:'true',
                        format:function(r,t){
                            return option(r,"OperationText");
                        }
                    }],
                success:function(d){
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }

                    if(d.status < 0){
                        artDialog(d.message,"OK");
                    }
                }
            }) ;
        });

        /**
         * 操作列超链接
         */
        function option(r,title){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if(title=="OperationText"){
                ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function(){edit(r.synthesisParametersCode,r.synthesisParametersID,r.version,this)}));
                ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function(){if(r.delFlag == 0){del(r.synthesisParametersCode,r.synthesisParametersID,r.version,r.updateTime,r.updateUser,this)}}));
            }
            if(title=="ToolPicText"){
                if(r.toolPic==null|| r.toolPic==undefined|| r.toolPic==''){

                    ary_li.push($('<li></li>'));
                }else {
                    ary_li.push($('<li><a href="<%= path%>/upload/b09s002/' + r.synthesisParametersID + "/" + r.toolPic + '"target="_blank">下载</a></li>'));
                }


            }
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**浏览图片**/
        function showImage(r){

            var title = '${session.lang.SearchPicture}';
            $('#showImage').empty();
            if(r.toolPic==null|| r.toolPic==undefined){

                $('#showImage').append($('wu'));
            }else{

                $('#showImage').append($('<a href="downloads.action?filenames='+r.synthesisParametersID+"/"+r.toolPic+'"></a>'));
            }
            <%--$('#showImage').append($("<a herf ='<%= path%>/icomp/upload/b09s002/"+r.synthesisParametersID+"/"+r.toolPic+"'/>"));--%>
            $.dialog({
                id:'showImage_dialog',
                title:title,
                lock: true,
                content:document.getElementById('showImage'),
                button:[]
            });
            return false;
        }
        /**图片过大处理**/
        var adjustImgSize = function(img, boxWidth, boxHeight) {
            // var imgWidth=img.width();
            // var imgHeight=img.height();
            // 上面这种取得img的宽度和高度的做法有点儿bug
            // src如果由两个大小不一样的图片相互替换时，上面的写法就有问题了，换过之后的图片的宽度和高度始终取得的还是换之前图片的值。
            // 解决方法：创建一个新的图片类，并将其src属性设上。
            var tempImg = new Image();
            tempImg.src = img.attr('src');
            var imgWidth=tempImg.width;
            var imgHeight=tempImg.height;
            if(imgWidth>800||imgHeight>800){
                if((imgWidth/imgHeight)>1){
                    img.width(875);
                }else{
                    img.height(875);
                }
            }
        };
        /**
         * 查询处理
         */
        function search(){
            var param = {
                opt:'list',
                SynthesisParametersCode:$(synthesisForm.SynthesisParametersCode).val(),
                DelFlag:$(synthesisForm.DelFlag).val()
            }
            $('#list').grid('url','B09S002.action');
            $('#list').grid('data',param);
            $('#list').grid('load',1);
            return false;
        }
        /**
         * 删除处理
         */
        function del(code,id,version,time,user,obj){
            $.dialog.confirm('${session.lang.RoleDelInfo}',function(){
                var param = {
                    SynthesisParametersCode:code,
                    version:version,
                    updatetime:time,
                    updateuser:user
                }
                $.ajax({
                    url:"synthesisDelete.action",
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
        /**
         * 编辑处理
         */
        function edit(code,id,version,obj){
            var param = {
                synthesisParametersCode:code,
                synthesisParametersID:id,
                version:version
            }
            $.ajax({
                url:"synthesisInfo.action",
                type: "post",
                dataType:"json",
                data:param,
                success:function(data){
                    console.log(data);
                    if(data.status < 0){
                        artDialog(data.message,"OK");
                    }else{
                        wd_synthesisEdit(data,id,obj);
                    }
                }
            });
        }


        /**新建或编辑**/
        function wd_synthesisEdit(data,id,obj){
            $('#synthesisEditForm').form('reset');
            var title = '${session.lang.synthesisAddTitle}';
            $('#synthesisEditForm :input').removeClass('u-ipt-err');
            $('#synthesisEditForm').find("*").each(function () {
                if($(this).hasClass("u-sel")){
                    $(this).removeAttr("style");
                }
            });
            if(typeof(data) == 'object'){//编辑
                EdittrClumName(data) ;
                $(synthesisEditForm.opt).val('edit');
                $(synthesisEditForm.DivSynthesisParametersID).val(id);//合成刀具参数ID
                $(synthesisEditForm.DivEquipmentName).val(data.data.equipmentID);//设备ID
                $(synthesisEditForm.DivPartsName).val(data.data.partsID);//零部件ID
                $(synthesisEditForm.DivCreateType).val(data.data.createType);//组成类型
                $(synthesisEditForm.DivQuotaProcessingVolume).val(data.data.quotaProcessingVolume);//定额加工量
                $(synthesisEditForm.DivSynthesisParametersCode).val(data.data.synthesisParametersCode);//合成刀具编码
                $(synthesisEditForm.DivDelFlag).val(data.data.delFlag);//删除区分
                $(synthesisEditForm.DivVersion).val(data.data.version);//版本号
                $(synthesisEditForm.pice).val(data.data.toolPic);//版本号
                $(synthesisEditForm.DivSynthesisParametersCode).attr("disabled","");//禁用合成刀具编码
                //$("input[type='file']").attr("class","f-dn");//刀具图纸隐藏

                $('#synthesisEditForm').attr('action','synthesisEdit.action');
                title = '${session.lang.synthesisEditText}';
            }else{//新建
                //隐藏刀具位置的表头
                $('#synthesisEditTable thead').hide();
                //清空刀具位置的内容
                $("#synthesisEditTable tbody").empty();
                $("#DivCreateType").change();
                //启用合成刀具编码
                $(synthesisEditForm.DivSynthesisParametersCode).removeAttr("disabled");
                //初始化位置数
                $("#DivSynthesisCount").val(1);
                //初始化版本号
                $(synthesisEditForm.DivVersion).val(0);
                //添加form请求
                $('#synthesisEditForm').attr('action','synthesisAdd.action');
            }

            $.dialog({
                id:'synthesisEdit_dialog',
                title:title,
                lock: true,
                content:document.getElementById('synthesisEdit'),
                button:[{
                    name:'${session.lang.submitAddsubText}',
                    focus:false,
                    callback:function(){
                        AddtrClum();
                        return false;

                    }},{
                    name:'${session.lang.submitSaveText}',
                    focus:false,
                    callback:function(){
                        $('#synthesisEditForm').form('submit',{
                            success:function(d){
                                $('#synthesisEditForm :input').removeClass('u-ipt-err');
                                $('#synthesisEditForm').find("*").each(function () {
                                    if($(this).hasClass("u-sel")){
                                        $(this).removeAttr("style");
                                    }
                                });
                                if($.parseJSON(d).status >= 0){
                                    var param = {
                                        opt:'list',
                                        SynthesisParametersCode:$(synthesisForm.SynthesisParametersCode).val(),
                                        DelFlag:$(synthesisForm.DelFlag).val()
                                    }
                                    $('#list').grid('url','B09S002.action');
                                    $('#list').grid('data',param);
                                    if($(synthesisEditForm.opt).val()!='edit'){
                                        $('#list').grid('load',1);
                                    }else{
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message,"OK");
                                    $.dialog.list['synthesisEdit_dialog'].close();
                                } else if($.parseJSON(d).status == -1){
                                    artDialog(d.message,"OK");
                                }else {
                                    artDialog(setContorllBackColor($('#synthesisEditForm'),$.parseJSON(d).message),"OK");
                                }
                            }
                        });
                        return false;
                    }
                }]
            });
            <!-- 2017/09/4 宋健 追加↓↓↓　dazhong@YMSC -->

            var html = "";
            if(data.data.cutterType == "0"){
                html += '<option value="0" selected>刀具</option>';
                html += '<option value="1">辅具</option>';
            }else{
                html += '<option value="0">刀具</option>';
                html += '<option value="1" selected>辅具</option>';
            }
            if(data.data.createType == "4"){
                $("div .aui_buttons button:first").hide();
            }
            $("#DivCutterType").html(html);

            <!-- 2017/09/4 宋健 追加↑↑↑　dazhong@YMSC -->

            return false;
        }

        /**添加合成刀位置**/
        function AddtrClum() {
            <!-- 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC -->
            var v = $("select[name='DivCreateType']").val();
            <!-- 2017/08/22 宋健 追加↑↑↑　dazhong@YMSC -->
            //显示位置的表头
            $('#synthesisEditTable thead').show();
            var a = $("#DivSynthesisCount").val();
            $("#LocationForClone tr:eq(0)").clone().appendTo("#synthesisEditTable tbody");
            if($("#synthesisEditTable tbody tr").length==1){
                $("#synthesisEditTable tbody tr:last").each(function () {
                    $(this).find("input[name='DivSynthesisCutterNumber']").attr("value",a);
                    //合成刀具位置0一定是辅具
//                    $(this).find("select[name='DivCutterType']").attr("name","DivCutterType["+a+"]").attr("id","DivCutterTypeId");
                    $(this).find("select[name='DivCutterType']").attr("name","DivCutterType["+a+"]");
                    $("#synthesisEditTable tbody tr:last").find("select[name='DivCutterType["+a+"]']").find("option").each(function(){
                        //合成刀具位置0是辅具,其他是刀具
                        <!-- 2017/10/18 王冉 变更↓↓↓　dazhong@YMSC -->
                        if($(this).val()!="0" && $(this).val()!="1"){
                            <!-- 2017/10/18 王冉 变更↑↑↑　dazhong@YMSC -->
                            $(this).remove();
                        }
                    });
                    $(this).find("p").html(a);
                    $(this).find("input[name='DivToolCode']").attr("name","DivToolCode["+a+"]");
                    $(this).find("input[name='DivTempToolCode']").attr("name","DivTempToolCode["+a+"]");
                    $(this).find("input[name='replaceCode']").attr("name","replaceCode["+a+"]");
                    $(this).find("input[name='DivSynthesisCutterNumber']").attr("name","DivSynthesisCutterNumber["+a+"]");
                });
            }else{
                $("#synthesisEditTable tbody tr:last").each(function () {
                    $(this).find("input[name='DivSynthesisCutterNumber']").attr("value",a);
                    //合成刀具位置0一定是辅具
                    $(this).find("select[name='DivCutterType']").attr("name","DivCutterType["+a+"]");
                    $("#synthesisEditTable tbody tr:last").find("select[name='DivCutterType["+a+"]']").find("option").each(function(){
                        //合成刀具位置0是辅具,其他是刀具
                        <!-- 2017/10/18 王冉 变更↓↓↓　dazhong@YMSC -->
                        if($(this).val()!="0" && $(this).val()!="1"){
                            <!-- 2017/10/18 王冉 变更↑↑↑　dazhong@YMSC -->
                            $(this).remove();
                        }
                    });
                    $(this).find("p").html(a);
                    $(this).find("input[name='DivToolCode']").attr("name","DivToolCode["+a+"]");
                    $(this).find("input[name='DivTempToolCode']").attr("name","DivTempToolCode["+a+"]");
                    $(this).find("input[name='replaceCode']").attr("name","replaceCode["+a+"]");
                    $(this).find("input[name='DivSynthesisCutterNumber']").attr("name","DivSynthesisCutterNumber["+a+"]");
                });
            }
            a++;
            $("#DivSynthesisCount").val(a);

            <!-- 2017/08/22 宋健 追加↓↓↓　dazhong@YMSC -->
            if(v == "4"){
                var html = "";
                html += '<select class="u-sel" name="DivCutterType[0]" id="DivCutterTypeId">';
                html += '<option value="0">刀具</option>';
                html += '<option value="1">辅具</option>';
                html += '</select>';
                $("div .aui_buttons button:first").hide();
            }
            $("#DivCutterTypeId").html(html);

            <!-- 2017/08/22 宋健 追加↑↑↑　dazhong@YMSC -->
        }

        /**编辑-刀具位置信息初始化**/
        function EdittrClumName(data) {
            //隐藏刀具信息标题头
            $('#synthesisEditTable thead').hide();
            //清空刀具位置
            $("#synthesisEditTable tbody").empty();
            //加载刀具位置
            var SynthesisCount=0;
            $.each(data.LocationList,function(i,location){
                $('#synthesisEditTable thead').show();
                $("#LocationForClone tr:eq(0)").clone(true).appendTo("#synthesisEditTable tbody");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivSynthesisCutterNumber']").attr("value", location.synthesisCutterNumber);
                $("#synthesisEditTable tbody tr:eq("+i+") th").find("p").html(location.synthesisCutterNumber);
                //位置类型
				console.log(location.cutterType +' : '+ location.toolCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='DivCutterType'] option[value='"+location.cutterType+"']").attr("selected", true);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='DivCutterType']").attr("name","DivCutterType["+i+"]");
//                $("#synthesisEditTable tbody tr:eq("+i+")").find("select[name='DivCutterType']").attr("name","DivCutterType["+i+"]").attr("id","DivCutterType");
                //刀具编码
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivToolCode']").attr("value", location.toolCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivToolCode']").attr("name","DivToolCode["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivTempToolCode']").attr("value", location.tempToolCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivTempToolCode']").attr("name","DivTempToolCode["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCode']").attr("value", location.tempToolCode);
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='replaceCode']").attr("name","replaceCode["+i+"]");
                $("#synthesisEditTable tbody tr:eq("+i+")").find("input[name='DivSynthesisCutterNumber']").attr("name","DivSynthesisCutterNumber["+i+"]");
                SynthesisCount++;

            });
            $("#DivSynthesisCount").val(SynthesisCount);//初始化位置数
        }

        /**文件上传js*/
        $(function(){
            $("input[type=file]").change(function(){$(this).parents(".uploader").find(".uplode-filename").val($(this).val());});
            $("input[type=file]").each(function(){
                if($(this).val()==""){$(this).parents(".uploader").find(".uplode-filename").val("No file selected...");}
            });
        });
	</script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
	<div class="g-ct-ttc">
		<span>当前页>首页>基础数据管理>合成刀具参数</span>
		<%@ include file="../head_div.jsp" %>
	</div>
</div>
<div class="ui-layout-center g-ct-bd">
	<div class="ui-layout-north">
		<div class="u-ptf">
			${sessionScope.lang.searchTitle}
		</div>
		<form id="synthesisForm" name="synthesisForm">
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
				<button type="button" class="u-btn2" onclick="return search()">
					${sessionScope.lang.submitSearchText}
				</button>
				<button type="button" class="u-btn2"
						onclick="return wd_synthesisEdit()">
					${sessionScope.lang.submitAddText}
				</button>
			</div>
		</form>
		<div class="f-cb"></div>

		<div class="u-ptt">
			<div style="float:left;">${sessionScope.lang.searchList}</div>
			<div style="float:right;">
				共：<span id="number1"></span> &nbsp;条
			</div>
			<div style="clear:both;"></div>
		</div>
	</div>
	<div class="ui-layout-center">
		<table id="list"></table>
		<div id="bar"></div>
	</div>
</div>

<div id="synthesisEdit" class="f-dn">

	<form id="synthesisEditForm" name="synthesisEditForm" method="post"
		  enctype="multipart/form-data">
		<input name="DivVersion" type="text" class="f-dn">
		<input name="DivSynthesisParametersID" type="text" class="f-dn">
		<input id="DivSynthesisCount" name="DivSynthesisCount" type="text"
			   class="f-dn" value="0">

		<table class="m-frmtb" width="100%">
			<tr>
				<th width="150">
					${sessionScope.lang.CreateTypeText}
				</th>
				<td>
					<select class="u-sel" name="DivCreateType" id="DivCreateType">
						<s:iterator value="#request.CreateType" id="CreateTypeEntity">
							<option value="${CreateTypeEntity.comListValue}" selected>
									${CreateTypeEntity.comListText}
							</option>
						</s:iterator>
					</select>
				</td>
				<!-- 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC -->
				<%--<th width="150">--%>
				<%--${sessionScope.lang.QuotaProcessingVolumeText}--%>
				<%--</th>--%>
				<%--<td>--%>
				<%--<input name="DivQuotaProcessingVolume" type="text" class="u-ipt" maxlength="11">--%>
				<%--</td>--%>
				<th width="150">
					${sessionScope.lang.SynthesisParametersCodeText}
				</th>
				<td>
					<input name="DivSynthesisParametersCode" type="text"
						   class="u-ipt" maxlength="50">
				</td>
			</tr>
			<tr>
				<th width="150">
					${sessionScope.lang.ToolPicText}
				</th>
				<td>
					<div class="uploader orange">
						<input type="text" class="uplode-filename" readonly name="pice"/>
						<input type="button" name="file" class="uplode-button"
							   value="${sessionScope.lang.SelectingText}" />
						<input type="file" name="upload" size="30" />
					</div>
				</td>
			</tr>
			<!-- 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC -->
		</table>
		<br>
		<div style="overflow:auto; max-height:300px;">
			<table id="synthesisEditTable" class="m-frmtb" >
				<thead>
				<tr >
					<th width="120">
						${sessionScope.lang.SynthesisCutterNumberText}
					</th>
					<th>
						${sessionScope.lang.CutterTypeText}
					</th>
					<th>
						${sessionScope.lang.ToolCodeText}
					</th>
					<th>
						${sessionScope.lang.TempToolCodeText}
					</th>
				</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
		</div>
	</form>
	<table id="LocationForClone" class="f-dn">
		<tr>
			<th>
				<input name="DivSynthesisCutterNumber" type="text" class="f-dn">
				<P></P>
			</th>
			<td>
				<select class="u-sel" name="DivCutterType">
					<s:iterator value="#request.CutterType" id="comlistCutterType">
						<option value="${comlistCutterType.comListValue}">
								${comlistCutterType.comListText}
						</option>
					</s:iterator>
				</select>
			</td>
			<td>
				<input name="DivToolCode" type="text" class="u-ipt" maxlength="45">
			</td>
			<td>
				<input name="DivTempToolCode" type="text" class="u-ipt" maxlength="45">
				<input name="replaceCode" type="hidden" class="u-ipt" maxlength="45">
			</td>
			<td>
		</tr>
	</table>
</div>
<div id="showImage" class="f-dn">
</div>
</body>
</html>

