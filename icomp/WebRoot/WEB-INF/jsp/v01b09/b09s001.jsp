﻿<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
                },
                north: {
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
                async: false,
                rowno: true,
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '材料号',
                    name: 'toolCode',
                    visible: '${session.gridcol.toolCode}'
                }, {
                    title: '${session.lang.ToolNameText}',
                    name: 'toolName',
                    visible: '${session.gridcol.toolName}'
                }, {
                    title: '${session.lang.ToolSpecificationsText}',
                    name: 'toolSpecifications',
                    visible: '${session.gridcol.toolSpecifications}'
                },  //  {
                    <%--title: '${session.lang.ToolLengthText}',--%>
                    <%--name: 'toolLength',--%>
                    <%--visible: '${session.gridcol.toolLength}'--%>
                    // },
                    {
                        title: '${session.lang.ToolTypeText}',
                        name: 'toolType',
                        visible: '${session.gridcol.toolType}',
                        format: function (r) {
                            //0刀具1辅具2配套9其他
                            if (r.toolType == 0) {
                                return '<span class="ui-grid-tdtx">${session.lang.Knife}</span>';
                            }
                            else if (r.toolType == 1) {
                                return '<span class="ui-grid-tdtx">${session.lang.AssistiveTechnology}</span>';
                            }
                            else if (r.toolType == 2) {
                                return '<span class="ui-grid-tdtx">${session.lang.Matching}</span>';
                            }
                            else if (r.toolType == 9) {
                                return '<span class="ui-grid-tdtx">${session.lang.Other}</span>';
                            }
                            return '<span class="ui-grid-tdtx"></span>';
                        }
                    },
                    // 2017/08/26 宋健 变更↓↓↓　dazhong@YMSC
                    <%--{--%>
                    <%--title: '${session.lang.ToolSharpennumText}',--%>
                    <%--name: 'toolSharpennum',--%>
                    <%--visible: '${session.gridcol.toolSharpennum}'--%>
                    <%--},--%>
                    // 2017/08/26 宋健 变更↑↑↑　dazhong@YMSC
                    {
                        title: '${session.lang.ToolPicText}',
                        name: 'toolPic',
                        visible: '${session.gridcol.toolPic}',
                        format: function (r) {
                            return option(r, "ToolPicText");
                        }
                    },
                    <%--{--%>
                    <%--title:'${session.lang.LibraryCodeText}',--%>
                    <%--name:'systeCodeShow',--%>
                    <%--visible:'${session.gridcol.systeCodeShow}'--%>
                        <%--},--%>{
                        title: '${session.lang.OperationText}',
                        name: '',
                        width: '130px',
                        visible: 'true',
                        format: function (r, t) {
                            return option(r, "OperationText");
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

            /************* 选择库位码 相关代码************/
            <%--$("#selectCode").click(function(e){--%>
            <%--$.dialog({--%>
            <%--id:'codeDialog',--%>
            <%--title:'${session.lang.SelectLibraryCodeInternationalization}',--%>
            <%--lock: true,--%>
            <%--content:document.getElementById('DivSelectCode')--%>

            <%--});--%>
            <%--});--%>

            /******************************************/

            /************* 刀具类型  相关代码************/
            $("#DivToolType,#DivToolConsumetype").change(function (e) {
                var toolType = $("#toolEditFormTable select[name=DivToolType]").val();
                var toolConsumetype = $("#toolEditFormTable select[name=DivToolConsumetype]").val();
                checkToolConsumetype(toolType, toolConsumetype);
            });
            $("#DivToolType").change(function (e) {
                var toolType = $("#toolEditFormTable select[name=DivToolType]").val();
                var toolConsumetype = $("#toolEditFormTable select[name=DivToolConsumetype]").val();
                checkToolType(toolType, toolConsumetype);
                $("#DivToolConsumetype").trigger("change");
            });
            /******************************************/
        });

        /**根据刀具分类-消耗类别显示输入框**/
        function checkToolType(toolType, toolConsumetype) {
            //如果是1辅具和2配套, 消耗类别为其他
            if (toolType == "1" || toolType == "2") {
                $("#toolEditFormTable select[name=DivToolConsumetype]").empty();
                $("#Base_DivToolConsumetype option").each(function () {
                    if ($(this).val() == "9") {
                        var $op = $(this).clone();
                        $("#toolEditFormTable select[name=DivToolConsumetype]").append($op);
                    }
                });
            } else if (toolType == "") {
                $("#toolEditFormTable select[name=DivToolConsumetype]").empty();
                $("#toolEditFormTable select[name=DivToolConsumetype]").append('<option value="">--${sessionScope.lang.PleaseSelect}--</option>');
            } else {
                $("#toolEditFormTable select[name=DivToolConsumetype]").empty();
                $("#Base_DivToolConsumetype option").each(function () {
                    if ($(this).val() == "0" || $(this).val() == "1" || $(this).val() == "2") {
                        var $op = $(this).clone();
                        $("#toolEditFormTable select[name=DivToolConsumetype]").append($op);
                    }
                });
            }
        }
        /**根据刀具分类-消耗类别显示输入框**/
        function checkToolConsumetype(toolType, toolConsumetype) {
            //刀具分类和消耗类别都选择后再做操作
            if (toolType != "") {
                if (toolConsumetype != "") {
                    if (toolType == "0" && toolConsumetype == "0") {
                        //如果是0刀具-0可刃磨钻头
                        showOrHide("0-0");
                    } else if (toolType == "0") {
                        //如果是0刀具-非转头
                        showOrHide("0-1,2,9");
                    } else if (toolType == "1" || toolType == "2") {
                        //如果是1辅具和2配套
                        showOrHide("1,2");
                    }

                }

            }
        }

        /**str:
         *        0-0如果是0刀具-0可刃磨钻头:为显示"复磨标准 "、“可刃磨长度”、“刀具长度 ”,不需要“可使用次数”
         *        0-1,2,9如果是0刀具-非钻头:为显示“可使用次数”,不需要"复磨标准 "、“可刃磨长度”、“刀具长度 ”
         *        1,2如果是1辅具和2配套：不需要“可使用次数”、“周转量”
         *
         }
         **/
        function showOrHide(str, type) {
            $("#toolEditFormTable tr:gt(5)").remove();
            if ($("#toolEditFormTable tr:eq(6) td").length == 2) {
                $("#toolEditFormTable tr:eq(6) td:eq(0)").remove();
                $("#toolEditFormTable tr:eq(6) th:eq(0)").remove();
            }
            var $tab = $("#NotMustTr_table tr").clone();
            $tab.find(".hidder").each(function (i) {

                var flag = true;
                if (str == "0-0") {
                    if ($(this).attr('name') == "DivToolSharpennum") {
                        flag = false;
                    }

                } else if (str == ("0-1,2,9")) {
                    if ($(this).attr('name') == "DivToolSharpenCriterion") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolSharpenLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolLength") {
                        flag = false;
                    }
                    // 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC
//                    if ($(this).attr('name') == "DivToolGrinding") {
//                        flag = false;
//                    }
                    // 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC


                } else if (str == ("1,2")) {
                    if ($(this).attr('name') == "DivToolSharpenCriterion") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolSharpenLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolLength") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolSharpennum") {
                        flag = false;
                    }
                    if ($(this).attr('name') == "DivToolTurnover") {
                        flag = false;
                    }
                    <!-- 2017/08/26 宋健 变更↓↓↓　dazhong@YMSC -->
//                    if ($(this).attr('name') == "DivToolNumeber") {
//                        flag = false;
//                    }
//                    if ($(this).attr('name') == "DivToolGrinding") {
//                        flag = false;
//                    }
                    <!-- 2017/08/26 宋健 变更↑↑↑　dazhong@YMSC -->
                }
                if (flag) {
                    if ($("#toolEditFormTable tr:last td").length == 2) {
                        $("#toolEditFormTable ").append("<tr></tr>");
                        $("#toolEditFormTable tr:last").append($(this).parent("td").prev());
                        $("#toolEditFormTable tr:last").append($(this).parent("td"));
                    } else {
                        $("#toolEditFormTable tr:last").append($(this).parent("td").prev());
                        $("#toolEditFormTable tr:last").append($(this).parent("td"));
                    }
                }

            });
        }

        /**
         * 查询处理
         */
        function search() {
            var param = {
                opt: 'list',
                ToolCode: $(toolForm.ToolCode).val(),
                ToolName: $(toolForm.ToolName).val(),
                ToolType: $(toolForm.ToolType).val(),
                ToolSpecifications: $(toolForm.ToolSpecifications).val(),
                LibraryCode: $(toolForm.LibraryCode).val(),
                DelFlag: $(toolForm.DelFlag).val()
            };

            $('#list').grid('url', 'B09S001.action');
            $('#list').grid('data', param);
            $('#list').grid('load', 1);
            return false;
        }

        //从选择库位码页面中 选出code返回编辑页面
        function sysCode(lcid, scode, ccode) {
            var show;

            if (ccode && ccode != "") {
                show = ccode;
            }
            else {
                show = scode;
            }
            $(toolEditForm.DivLibraryCodeID).val(lcid)
            $(toolEditForm.DivSysteCodeShow).val(show);
            $.dialog.list['codeDialog'].close();
        }


        //添加刀具
        function wd_tool(data, id, obj) {
            //复制table
            $("#toolEditFormTable tr:not(tr:lt(6))").remove();
            var $tab = $("#NotMustTr_table tr").clone();
            $tab.children("td").each(function (i) {

                if ($("#toolEditFormTable tr:last td").length == 2) {
                    $("#toolEditFormTable ").append("<tr></tr>");
                    $("#toolEditFormTable tr:last").append($(this).prev());
                    $("#toolEditFormTable tr:last").append($(this));
                } else {
                    $("#toolEditFormTable tr:last").append($(this).prev());
                    $("#toolEditFormTable tr:last").append($(this));
                }
            });


            $('#toolEditForm').form('reset');
            var title = '${session.lang.toolAddTitle}';
            $('#toolEditForm :input').removeClass('u-ipt-err');
            $('#toolEditForm').find("*").each(function () {
                if ($(this).hasClass("u-sel")) {
                    $(this).removeAttr("style");
                }
            });

            if (typeof(data) == 'object') {
                $(toolEditForm.opt).val('edit');
                // 页面赋值
                checkToolType(data.data.toolType, data.data.toolConsumetype);
                checkToolConsumetype(data.data.toolType, data.data.toolConsumetype);
                $(toolEditForm.DivToolType).val(data.data.toolType);
                $(toolEditForm.DivToolConsumetype).val(data.data.toolConsumetype);
                $(toolEditForm.DivToolID).val(id);
                $(toolEditForm.DivToolCode).val(data.data.toolCode);
                $(toolEditForm.DivToolName).val(data.data.toolName);
                $(toolEditForm.DivToolPic).val(data.data.toolPic);
                //   $(toolEditForm.DivPurchasingCycle).val(data.data.purchasingCycle);//采购周期
                $(toolEditForm.DivToolNumeber).val(data.data.toolNumber);//可修磨次数
                $(toolEditForm.DivToolCutNumber).val(data.data.toolCutNumber);//刃口数
                $(toolEditForm.DivToolSpecifications).val(data.data.toolSpecifications);
                $(toolEditForm.DivToolMax).val(data.data.toolMax);
                $(toolEditForm.DivToolMin).val(data.data.toolMin);
                $(toolEditForm.DivBMin).val(data.data.beiMin);
                $(toolEditForm.DivBMax).val(data.data.beiMax);
                // 2017/11/15 王冉 追加↓↓↓　dazhong@YMSC
                $(toolEditForm.DivToolPrice).val(data.data.toolPrice);
                $(toolEditForm.DivToolAveragePrice).val(data.data.toolAveragePrice);
                $(toolEditForm.DivToolParametersType).val(data.data.toolParametersType);
                // 2017/11/15 王冉 追加↑↑↑　dazhong@YMSC
                $(toolEditForm.DivToolGrinding).val(data.data.toolGrinding);
                $(toolEditForm.DivToolDurable).val(data.data.toolDurable);
                $(toolEditForm.DivToolTurnover).val(data.data.toolTurnover);
                $(toolEditForm.DivPer10k).val(data.data.per10k);
                $(toolEditForm.DivQuotaProcessingVolume).val(data.data.quotaProcessingVolume);
                $(toolEditForm.DivSysteCodeShow).val(data.data.systeCodeShow);
                $(toolEditForm.DivLibraryCode).val(data.data.libraryCodeID);
                $(toolEditForm.DivUpdateUser).val(data.data.updateUser);//更新者
                $(toolEditForm.DivUpdateTime).val(data.data.updateTime);//更新时间
                $(toolEditForm.DivVersion).val(data.data.version);//版本号
                $(toolEditForm.DivDelFlag).val(data.data.delFlag);//删除区分
                $(toolEditForm.pice).val(data.data.toolPic);//l上传路径

                $(toolEditForm.DivToolSharpennum).val(data.data.toolSharpennum);
                $(toolEditForm.DivToolLength).val(data.data.toolLength);//刀具长度
                $(toolEditForm.DivToolSharpenCriterion).val(data.data.toolSharpenCriterion);//复磨标准
                $(toolEditForm.DivToolSharpenLength).val(data.data.toolSharpenLength);//可刃磨长度
                $('#toolEditForm').attr('action', 'toolEdit.action');
                title = '${session.lang.toolEditText}';
                $(toolEditForm.DivToolCode).attr("disabled", "");//禁用刀具编码

            } else {
                checkToolType("", "");
                $(toolEditForm.DivToolCode).removeAttr("disabled");//启用刀具编码
                $(toolEditForm.DivDelFlag).val(0);//删除区分-有效
                $(toolEditForm.DivVersion).val(0);//版本号
                $('#toolEditForm').attr('action', 'toolAdd.action');
            }
            $.dialog({
                id: 'toolEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById('toolEdit'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $('#toolEditForm').form('submit', {
                            success: function (d) {
                                $('#toolEditForm :input').removeClass('u-ipt-err');
                                $('#toolEditForm').find("*").each(function () {
                                    if ($(this).hasClass("u-sel")) {
                                        $(this).removeAttr("style");
                                    }
                                });
                                if ($.parseJSON(d).status >= 0) {
                                    //处理库位码
                                    var lcid = $(toolEditForm.DivLibraryCodeID).val();
                                    $("#" + lcid).closest("tr").remove();

                                    var param = {
                                        opt: 'list',
                                        ToolCode: $(toolForm.ToolCode).val(),
                                        ToolName: $(toolForm.ToolName).val(),
                                        ToolType: $(toolForm.ToolType).val(),
                                        ToolSpecifications: $(toolForm.ToolSpecifications).val(),
                                        LibraryCode: $(toolForm.LibraryCode).val(),
                                        DelFlag: $(toolForm.DelFlag).val()
                                    };
                                    $('#list').grid('url', 'B09S001.action');
                                    $('#list').grid('data', param);
                                    if ($(toolEditForm.opt).val() != 'edit') {
                                        $('#list').grid('load', 1);
                                    } else {
                                        $('#list').grid('load');
                                    }
                                    artDialog($.parseJSON(d).message, "OK");
                                    $.dialog.list['toolEdit_dialog'].close();
                                } else if ($.parseJSON(d).status == -1) {
                                    artDialog(d.message, "OK");
                                } else {
                                    artDialog(setContorllBackColor($('#toolEditForm'), $.parseJSON(d).message), "OK");
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
         * 操作列超链接
         */
        function option(r, title) {
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            if (title == "OperationText") {//操作
                ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click(function () {
                    edit(r.toolID, r.version, this)
                }));
                ary_li.push($('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click(function () {
                    if (r.delFlag == 0) {
                        del(r.toolID, r.version, r.updateTime, r.updateUser, this)
                    }
                }));
            }
            if(title=="ToolPicText"){
                if(r.toolPic==null|| r.toolPic==undefined|| r.toolPic==''){

                    ary_li.push($('<li>-</li>'));
                }else {
                    ary_li.push($('<li><a href="<%= path%>/upload/b09s001/' + r.toolID + "/" + r.toolPic + '"target="_blank">下载</a></li>'));
                }
            }
            <%--if (title == "ToolPicText") {//刀具图纸--%>
            <%--ary_li.push($('<li><a href="javascript:void(0)">${session.lang.BrowsePicture}</a></li>').click(function () {--%>
            <%--showImage(r)--%>
            <%--}));--%>
            <%--}--%>
            $.each(ary_li, function (i, o) {
                $li.after(o);
            });
            return $ul.append($li);
        }

        /**浏览图片**/
        <%--function showImage(r) {--%>
        <%--var title = '${session.lang.SearchPicture}';--%>
        <%--$('#showImage').empty();--%>
        <%--$('#showImage').append($("<img src ='/icomp/upload/b09s001/" + r.toolID + "/" + r.toolPic + "'/>").load(function () {--%>
        <%--adjustImgSize($(this), $(this).width, $(this).height);--%>
        <%--}));--%>
        <%--$.dialog({--%>
        <%--id: 'showImage_dialog',--%>
        <%--title: title,--%>
        <%--width: 220,--%>
        <%--lock: true,--%>
        <%--content: document.getElementById('showImage'),--%>
        <%--});--%>

        <%--return false;--%>
        <%--}--%>


        /**图片过大处理**/
        var adjustImgSize = function (img, boxWidth, boxHeight) {
            // var imgWidth=img.width();
            // var imgHeight=img.height();
            // 上面这种取得img的宽度和高度的做法有点儿bug
            // src如果由两个大小不一样的图片相互替换时，上面的写法就有问题了，换过之后的图片的宽度和高度始终取得的还是换之前图片的值。
            // 解决方法：创建一个新的图片类，并将其src属性设上。
            var tempImg = new Image();
            tempImg.src = img.attr('src');
            var imgWidth = tempImg.width;
            var imgHeight = tempImg.height;
            if (imgWidth > 800 || imgHeight > 800) {
                if ((imgWidth / imgHeight) > 1) {
                    img.width(875);
                } else {
                    img.height(875);
                }
            }
        };

        /**
         * 编辑处理
         */
        function edit(id, version, obj) {
            var param = {
                toolID: id,
                opt: 'edit',
                toolVersion: version
            }
            $.ajax({
                url: "toolInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    } else {
                        wd_tool(d, id, obj);
                    }
                }
            });
        }


        /**
         * 删除处理
         */
        function del(id, version, time, user, obj) {
            $.dialog.confirm('${session.lang.RoleDelInfo}', function () {
                var param = {
                    toolID: id,
                    version: version,
                    updatetime: time,
                    updateuser: user
                }
                $.ajax({
                    url: "toolDelete.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status >= 0) {
                            $('#list').grid('load');
                        }
                        artDialog(d.message, "OK");
                    }
                });
            });
        }

        /**文件上传js*/
        $(function () {
            $("input[type=file]").change(function () {
                $(this).parents(".uploader").find(".uplode-filename").val($(this).val());
            });
            $("input[type=file]").each(function () {
                if ($(this).val() == "") {
                    $(this).parents(".uploader").find(".uplode-filename").val("No file selected...");
                }
            });

            /**可使用次数 = 可刃磨长度/刃磨标准**/
            $('input[name=DivToolSharpennum]').focus(function () {
                var SharpenLength = $('input[name=DivToolSharpenLength]').val();
                var SharpenCriterion = $('input[name=DivToolSharpenCriterion]').val();
                var ret = parseInt(SharpenLength / SharpenCriterion);
                if (!isNaN(ret)) {
                    $(this).val(ret);
                }
            });
        });

    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>基础数据管理>刀具参数</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="toolForm" name="toolForm" method="post">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input name="ToolCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                    </td>
                    <th width="150">
                        刀具名称
                    </th>
                    <td>
                        <input name="ToolName" type="text" class="u-ipt" maxlength="40">
                    </td>
                    <th width="150">
                        刀具类别
                    </th>
                    <td>
                        <select class="u-sel" name="ToolType" maxlength="2">
                            <option value="">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.ToolTypeList" id="toolType">
                                <option value="${toolType.comListValue}">
                                        ${toolType.comListText}
                                </option>
                            </s:iterator>

                        </select>
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        ${sessionScope.lang.ToolSpecificationsText}
                    </th>
                    <td>
                        <input name="ToolSpecifications" type="text" class="u-ipt" maxlength="150">
                    </td>
                    <th width="150">
                        ${sessionScope.lang.LibraryCodeText}
                    </th>
                    <td>
                        <input name="LibraryCode" type="text" class="u-ipt" maxlength="36">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" onclick="return search()">
                    ${sessionScope.lang.submitSearchText}
                </button>
                <button type="button" class="u-btn2" onclick="return wd_tool()">
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


<!-- 新建编辑页面 -->
<div id="toolEdit" class="f-dn">
    <form id="toolEditForm" name="toolEditForm" method="post" enctype="multipart/form-data">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DivToolID"/>
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivUpdateUser"/>
        <input type="text" class="f-dn" name="DivUpdateTime"/>


        <table class="m-frmtb" width="100%" id="toolEditFormTable">
            <tr>
                <th width="150">
                    刀具分类
                </th>
                <td>
                    <select class="u-sel" name="DivToolType" id="DivToolType" maxlength="2">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.ToolTypeList" id="toolType">
                            <option value="${toolType.comListValue}">
                                    ${toolType.comListText}
                            </option>
                        </s:iterator>
                    </select>
                </td>
                <th width="150">
                    消耗类别
                </th>
                <td>
                    <select class="u-sel" name="DivToolConsumetype" id="DivToolConsumetype" maxlength="2">
                        <option value="">
                            --${sessionScope.lang.PleaseSelect}--
                        </option>
                        <s:iterator value="#request.ToolConsumeTypeList" id="toolType">
                            <option value="${toolType.comListValue}">
                                    ${toolType.comListText}
                            </option>
                        </s:iterator>
                    </select>
                </td>
            </tr>

            <tr>
                <th width="150">
                    材料号
                </th>
                <td>
                    <input name="DivToolCode" type="text" class="u-ipt" maxlength="16" onkeyup="this.value=this.value.toUpperCase()" >
                </td>
                <th width="150">
                    刀具名称
                </th>
                <td>
                    <input name="DivToolName" type="text" class="u-ipt" maxlength="40">
                </td>
            </tr>
            <tr>
                <th width="150">
                    刃口数<%--每盒数量--%>
                </th>
                <td>
                    <input name="DivToolCutNumber" type="text" class="u-ipt" maxlength="4">
                </td>
                <th width="150">
                    规格型号
                </th>
                <td>
                    <input name="DivToolSpecifications" type="text" class="u-ipt" maxlength="80">
                </td>
            </tr>

            <tr>
                <th width="150">
                    <%--供应商--%> 库存最大值
                </th>
                <td>
                    <%--<input name="DivToolSupplier" type="text" class="u-ipt" maxlength="200">--%>
                    <input name="DivToolMax" type="text" class="u-ipt" maxlength="10">
                </td>

                <th width="150">
                    <%--品牌--%>库存最小值
                </th>
                <td>
                    <%--<input name="DivToolBrand" type="text" class="u-ipt" maxlength="200">--%>
                    <input name="DivToolMin" type="text" class="u-ipt" maxlength="8">
                </td>
            </tr>
            <tr>
                <th width="150">
                    <%--供应商--%> 备最大值
                </th>
                <td>
                    <input name="DivBMax" type="text" class="u-ipt" maxlength="10">
                </td>
                <th width="150">
                    <%--品牌--%>备最小值
                </th>
                <td>
                    <input name="DivBMin" type="text" class="u-ipt" maxlength="8">
                </td>
            </tr>

            <tr>
                <th width="150">
                    库位码
                </th>
                <td>
                    <input name="DivLibraryCode" type="text" class="u-ipt" maxlength="16">
                </td>

                <th width="150">
                    刀具图纸<%-- 图纸--%>
                </th>
                <td>
                    <div class="uploader orange">
                        <input type="text" class="uplode-filename" name="pice" />
                        <input type="button" name="file" class="uplode-button"
                               value="${sessionScope.lang.SelectingText}"/>
                        <input type="file" name="upload" size=/>
                    </div>
                </td>
            </tr>
        </table>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    刀具单价
                </th>
                <td>
                    <input name="DivToolPrice" type="text" class="u-ipt" maxlength="10">
                    <p id="DivToolPrice"></p>
                </td>
                <th width="150">
                    平均修磨单价
                </th>
                <td>
                    <input name="DivToolAveragePrice" type="text" class="u-ipt" maxlength="10">
                    <p id="DivToolAveragePrice"></p>
                </td>
            </tr>
            <tr>
                <th width="150">
                    刀具用途类型
                </th>
                <td>
                    <select name="DivToolParametersType"  class="u-sel hidder" maxlength="2">
                        <s:if test="%{#DivToolParametersType = 0}">
                            <option value="0" selected="selected">刀片/钻头/复合刀具/热套类</option>
                            <option value="1">一体刀</option>
                            <option value="2">筒刀</option>
                            <option value="3">专机</option>
                            <option value="9">其他</option>
                        </s:if>
                        <s:elseif test="%{#DivToolParametersType = 1}">
                            <option value="0">刀片/钻头/复合刀具/热套类</option>
                            <option value="1" selected="selected">一体刀</option>
                            <option value="2">筒刀</option>
                            <option value="3">专机</option>
                            <option value="9">其他</option>
                        </s:elseif>
                        <s:elseif test="%{#DivToolParametersType = 2}">
                            <option value="0">刀片/钻头/复合刀具/热套类</option>
                            <option value="1">一体刀</option>
                            <option value="2" selected="selected">筒刀</option>
                            <option value="3">专机</option>
                            <option value="9">其他</option>
                        </s:elseif>
                        <s:elseif test="%{#DivToolParametersType = 3}">
                            <option value="0">刀片/钻头/复合刀具/热套类</option>
                            <option value="1">一体刀</option>
                            <option value="2">筒刀</option>
                            <option value="3" selected="selected">专机</option>
                            <option value="9">其他</option>
                        </s:elseif>
                        <s:elseif test="%{#DivToolParametersType = 9}">
                            <option value="0">刀片/钻头/复合刀具/热套类</option>
                            <option value="1">一体刀</option>
                            <option value="2">筒刀</option>
                            <option value="3">专机</option>
                            <option value="9" selected="selected">其他</option>
                        </s:elseif>
                    </select>
                    <p id="DivToolParametersType"></p>
                </td>
            </tr>

        </table>
    </form>
</div>

<!-- 用于复制页面  -->
<div class="f-dn">
    <select class="u-sel" id="Base_DivToolConsumetype">
        <s:iterator value="#request.ToolConsumeTypeList" id="toolType">
            <option value="${toolType.comListValue}">
                    ${toolType.comListText}
            </option>
        </s:iterator>
    </select>
    <table id="NotMustTr_table">
        <tr>
            <th width="150" class="NotMustTr2">
                可使用次数
            </th>
            <td class="NotMustTr2">
                <input name="DivToolSharpennum" type="text" class="u-ipt hidder" maxlength="5">
            </td>

            <th width="150" >
                复磨标准
            </th>
            <td>
                <input name="DivToolSharpenCriterion" type="text" class="u-ipt hidder" maxlength="10">
                <p id="DivToolSharpenCriterion"></p>
            </td>
        </tr>
        <tr>
            <th width="150">
                可刃磨长度
            </th>
            <td>
                <input name="DivToolSharpenLength" type="text" class="u-ipt hidder" maxlength="5">
                <p id="DivToolSharpenLength"></p>
            </td>

            <th width="150">
                可刃磨次数
            </th>
            <td>
                <input name="DivToolNumeber" type="text" class="u-ipt hidder" maxlength="5">
                <p id="DivToolNumeber"></p>
            </td>
        </tr>
        <tr>
            <th width="150" >
                修磨类别
            </th>
            <td >
                <select name="DivToolGrinding"  class="u-sel hidder" maxlength="2">
                    <s:if test="%{#DivToolGrinding = 1}">
                        <option value="0" selected="selected">厂内修磨</option>
                        <option value="1">厂外修磨</option>
                        <option value="2">厂外涂层</option>
                    </s:if>
                    <s:elseif test="%{#DivToolGrinding = 0}">
                        <option value="0">厂内修磨</option>
                        <option value="1" selected="selected">厂外修磨</option>
                        <option value="2">厂外涂层</option>
                    </s:elseif>
                    <s:elseif test="%{#DivToolGrinding = 2}">
                        <option value="0">厂内修磨</option>
                        <option value="2" selected="selected">厂外涂层</option>
                        <option value="1">厂外修磨</option>
                    </s:elseif>
                    <s:else>
                        <option value="0" selected="selected">厂内修磨</option>
                        <option value="1" >厂外修磨</option>
                        <option value="2" >厂外涂层</option>
                    </s:else>
                </select>
                <p id="DivToolGrinding"></p>
            </td>
            <th width="150">
                刀具长度
            </th>
            <td>
                <input name="DivToolLength" type="text" class="u-ipt" maxlength="8">
                <p id="DivToolLength"></p>
            </td>
        </tr>
    </table>
</div>
<div id="showImage" class="f-dn">
</div>

</body>
</html>

