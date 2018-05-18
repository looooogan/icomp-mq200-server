<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp" %>
    <script type="text/javascript">
        $(function () {
            jQuery('body').layout({
                center__childOptions: {
                    north__resizable: false,
                    spacing_open: 0
                }, north: {
                    size: 'auto',
                    spacing_open: 0,
                    closable: false,
                    resizable: false
                }
            });

            $('#list').grid({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                //async:false,
                rowno: true,
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '材料号',
                    name: 'toolCode'
                }, {
                    title: '操作人',
                    name: 'createUser'
                }, {
                    title: '时间段',
                    name: 'createTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate1(r.createTime) + '</span>';
                    }
                }, {
                    title: '备注',
                    name: 'noteFile'
                }, {
                    title: '操作',
                    name: '',
                    width: '130px',
                    visible: 'true',
                    format: function (r, t) {
                        return option(r);
                    }
                }],
                success: function (d) {
                    if(undefined== d.total){
                        $("#number1").text(0);
                    }else if(0== d.total){
                        $("#number1").text(1);
                    } else {
                        $("#number1").text(d.total);
                    }

                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    }
                }
            });
        });

        /**
         * 操作列超链接
         */
        function option(r) {
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            ary_li.push($('<li><a href="javascript:void(0)">详细</a></li>').click(function () {edit(r.optimizationID, '', this)}));
            ary_li.push($('<li><a href="javascript:void(0)">删除</a></li>').click(function () {if (r.delFlag == 0) {del(r.optimizationID, this)}}));
            $.each(ary_li, function (i, o) {
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**
         * 查询处理
         */
        function search() {
            var param = {
                opt: 'list',
                toolCode: $(optimizationForm.toolCode).val(),//材料号
                dstar: $(optimizationForm.dstar).val(),//开始时间
                dend: $(optimizationForm.dend).val(),//结束时间
                recipient: $(optimizationForm.recipient).val(),//操作人
                note: $(optimizationForm.note).val(),//备注
            }
            $('#list').grid('url', 'B09S006.action');
            $('#list').grid('data', param);
            $('#list').grid('load', 1);
            return false;
        }

        function  tye(id){
            if(id==1){
                var a1 = $("#upload1").val();
                var filename = (a1.match(/[^\\]+$/));
                if(a1==""||a1==undefined){
                   $(upLoForm.name1) .val("name1");

                }else {
                    $(upLoForm.name1) .val(filename);
                }

            }
            if(id==2){
                var a2 = $("#upload2").val();
                var filename = (a2.match(/[^\\]+$/))
                $("#name2") .val("");
                if(a2==""||a2==undefined){
                    $(upLoForm.name2) .val("name2");
                } else {
                    $(upLoForm.name2) .val(filename);
                }

            }
            if(id==3){
                var a3 = $("#upload3").val();
                var filename = (a3.match(/[^\\]+$/))
                if(a3==""||a3==undefined){
                    $(upLoForm.name3) .val("name3");
                }else {
                    $(upLoForm.name3) .val(filename);
                }

            }
            if(id==4){
                var a4 = $("#upload4").val();
                var filename = (a4.match(/[^\\]+$/))
                if(a4==""||a4==undefined){
                    $(upLoForm.name4) .val("name4");
                }else {
                    $(upLoForm.name4) .val(filename);
                }

            }



        }
        /**
         * 删除处理
         */
        function del(id,obj){
            $.dialog.confirm('${session.lang.RoleDelInfo}',function(){
                var param = {
                    optimizationID:id,

                }
                $.ajax({
                    url:"potimizationDel.action",
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
        function edit(id, version, obj) {
            var param = {
                optimizationID: id,
                opt: 'edit',
                version: version

            }

            $.ajax({
                url: "optimizationInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    } else {
                        wd_libraryCode(d, id, obj);
                    }
                }
            });
        }
        function wd_libraryCode(data, id, obj) {
            $('#upLoForm').form('reset');
            var title = '优化新建';
            $('#upLoForm:input').removeClass('u-ipt-err');
            $('#upLoForm').find("*").each(function () {
                if ($(this).hasClass("u-sel")) {
                    $(this).removeAttr("style");
                }
            });
            if (typeof(data) == 'object') {
                //编辑
                $(upLoForm.opt).val('edit');
                // 页面赋值
                $(upLoForm.DivOptimizationID).val(id);//主键
                $(upLoForm.DivToolCode).val(data.data.toolCode);//材料号
                $(upLoForm.DivNote).val(data.data.Note);//备注

                var text = '';

                if (data.data.applicationFileName != ''&&data.data.applicationFileName   !=null) {
                    text =data.data.expandSpace1 + '<a href="downloads.action?filenames='+data.data.applicationFileName+'">下载</a>'; //申请表
                } else {
                    text =  '<input name="upload1" type="file" class="u-ipt"   id="upload1" maxlength="36"  onchange="return tye(1)"/>';
                }
                $("#appTable").empty();
                $("#name1").val("");
                $("#uploda1") .val("");
                $("#appTable").append(text);

                if (data.data.technicalFileName !=''&& data.data.technicalFileName !=null){

                    text = data.data.expandSpace2 +'<a href="downloads.action?filenames='+data.data.technicalFileName+'">下载</a>';//技术方案
                }else {
                    text =  '<input name="upload2" type="file" class="u-ipt"   id="upload2" maxlength="36"  onchange="return tye(2)"/>';

                }
                $("#DivTechnical").empty();
                $("#name2").val("");
                $("#uploda2") .val("");
                $("#DivTechnical").append(text);

                if (data.data.experimentalFileName !=null&& data.data.experimentalFileName !=''){
                    text = data.data.expandSpace3 +'<a href="downloads.action?filenames='+data.data.experimentalFileName+'">下载</a>';//实验通知单
                }else {
                    text =  '<input name="upload3" type="file" class="u-ipt"   id="upload3" maxlength="36"  onchange="return tye(3)"/>';
                }
                $("#DivExperimentalnotice").empty();
                $("#name3").val("");
                $("#uploda3") .val("");
                $("#DivExperimentalnotice").append(text);

                if (data.data.reportFileName !=''&& data.data.reportFileName !=null){

                    text = data.data.expandSpace4 +'<a href="downloads.action?filenames='+data.data.reportFileName+'">下载</a>';//实验报告
                }else {
                    text =  '<input name="upload4" type="file" class="u-ipt"   id="upload4" maxlength="36"  onchange="return tye(4)"/>';
                }
                $("#DivExperimentreport").empty();
                $("#name4").val("");
                $("#uploda4") .val("");
                $("#DivExperimentreport").append(text);

                $(upLoForm.DivNote).val(data.data.noteFile);//备注

                $('#upLoForm').attr('action','optimizationEdit.action');
                title = '刀具优化详情';
            }else{

                var  text1 = '<input name="upload1" type="file" class="u-ipt"   id="upload1" maxlength="36"  onchange="return tye(1)"/>';
                $("#appTable").empty();
                $("#name1").val("");
                $("#uploda1") .val("");
                $("#appTable").append(text1);


                var  text2 = '<input name="upload2" type="file" class="u-ipt"   id="upload2" maxlength="36" onchange="return tye(2)" />';
                $("#DivTechnical").empty();
                $("#name2").val("");
                $("#uploda2") .val("");
                $("#DivTechnical").append(text2);

                var  text3 = '<input name="upload3" type="file" class="u-ipt"  id="upload3" maxlength="36"  onchange="return tye(3)"/>';
                $("#DivExperimentalnotice").empty();
                $("#name3").val("");
                $("#uploda3") .val("");
                $("#DivExperimentalnotice").append(text3);

                var  text4 = '<input name="upload4" type="file" class="u-ipt" id="upload4"  maxlength="36"  onchange="return tye(4)"/>';
                $("#DivExperimentreport").empty();
                $("#name4").val("");
                $("#uploda4") .val("");
                $("#DivExperimentreport").append(text4);
                $('#upLoForm').attr('action', 'optimizationAdd.action');
            }
            $.dialog({
                id: 'printEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById('libraryCodeEdit'),
                button: [{
                    name: '保存',
                    focus: true,
                    callback: function () {
                        $('#upLoForm').form('submit', {

                            success: function (d) {

                                $('#upLoForm:input').removeClass('u-ipt-err');
                                $('#upLoForm').find("*").each(function () {
                                    if ($(this).hasClass("u-sel")) {
                                        $(this).removeAttr("style");
                                    }
                                });

                                if ($.parseJSON(d).status >= 0) {
                                    var param = {
                                        opt: 'list',
                                        PageName: $(upLoForm.PageName).val()
                                    }
                                    $('#list').grid('url', 'B09S006.action');
                                    $('#list').grid('data', param);
                                    if ($(upLoForm.opt).val() != 'edit') {
                                        $('#list').grid('load', 1);
                                    } else {
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message, "OK");
                                    $.dialog.list['printEdit_dialog'].close();

        } else if ($.parseJSON(d).status == -1) {
            artDialog($.parseJSON(d).message, "OK");
        } else {
            artDialog(setContorllBackColor($('#printEditForm'), $.parseJSON(d).message), "OK");
        }
        }
        });
        return false;
        }
        }]
        });
        return false;
        }

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页:首页>基础数据管理>刀具优化</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="optimizationForm" name="libraryCodeForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input name="toolCode" type="text" class="u-ipt" maxlength="36" onkeyup="this.value=this.value.toUpperCase()">
                    </td>
                    <th width="100">
                        出库时间段
                    </th>
                    <td style="white-space: nowrap">
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        操作人
                    </th>
                    <td>
                        <input name="recipient" type="text" class="u-ipt" maxlength="36">
                    </td>
                    <th width="150">
                        备注
                    </th>
                    <td>
                        <input name="note" type="text" class="u-ipt" maxlength="36">
                    </td>

                </tr>
            </table>
            <div class="g-fx1 f-fr">

                <button type="submit" class="u-btn2" onclick="return search()">${sessionScope.lang.submitSearchText}</button>
                <button type="submit" class="u-btn2" onclick="return wd_libraryCode()">新建</button>

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
<div id="libraryCodeEdit" class="f-dn">
    <form id="upLoForm" name="upLoForm" method="post" enctype="multipart/form-data">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivOptimizationID"/>
        <input type="text" class="f-dn" name="DIVDelFlag" value="0"/>
        <input type="hidden" class="f-dn" name="name1" id="name1"/>
        <input type="hidden" class="f-dn" name="name2"  id="name2"/>
        <input type="hidden" class="f-dn" name="name3"  id="name3"/>
        <input type="hidden" class="f-dn" name="name4"  id="name4"/>

        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    材料号
                </th>
                <td>
                    <input name="DivToolCode" type="text" class="u-ipt" maxlength="36" onkeyup="this.value=this.value.toUpperCase()">
                </td>
            </tr>
            <tr>
                <th width="150">
                    申请表
                </th>
                <td id="appTable" >
                </td>
            </tr>
            <tr>
                <th width="150">
                    技术方案
                </th>
                <td id="DivTechnical">
                </td>
            </tr>
            <tr>
                <th width="150">
                    实验通知单
                </th>
                <td id="DivExperimentalnotice">
                </td>
            </tr>
            <tr>
                <th width="150">
                    实验报告
                </th>
                <td id="DivExperimentreport">
                </td>
            </tr>
            <tr>
                <th width="150">
                    备注
                </th>
                <td>
                    <input name="DivNote" type="text" class="u-ipt" maxlength="36">
                </td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>

<%--/**--%>
<%--* 删除处理--%>
<%--*/--%>
<%--function del(id,version,time,user,obj){--%>
<%--$.dialog.confirm('${session.lang.UserDelInfo}',function(){--%>
<%--var param = {--%>
<%--libraryCodeID:id,--%>
<%--version:version,--%>
<%--updatetime:time,--%>
<%--updateuser:user--%>
<%--}--%>
<%--$.ajax({--%>
<%--url:"libraryCodeDelete.action",--%>
<%--type: "post",--%>
<%--dataType:"json",--%>
<%--data:param,--%>
<%--success:function(d){--%>
<%--if(d.status >= 0){--%>
<%--$('#list').grid('load');--%>
<%--}--%>
<%--artDialog(d.message,"OK");--%>
<%--}--%>
<%--});--%>
<%--});--%>
<%--}--%>

