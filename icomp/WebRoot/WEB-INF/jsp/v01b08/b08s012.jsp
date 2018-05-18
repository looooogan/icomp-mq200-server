<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp" %>
    <script type="text/javascript">
        $ (function () {
            jQuery ('body').layout ({
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
            $ ('#list').grid ({
                barid: '#bar',
                datatype: 'json',
                type: 'post',
                width: '100%',
                fit: true,
                lazy: false,
                rowno: true,
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '零部件编码',
                    name: 'partsCode'
                }, {
                    title: '零部件名称',
                    name: 'partsName'
                },
                    <!-- 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC -->
//                    {
//                    title: '零部件类型',
//                    name: 'partsType',
//                    format: function (t) {
//                        //0 一次性1合成2其他
//                        if (t.partsType == 0) {
//                            return '<span class="ui-grid-tdtx">1.4T</span>';
//                        }
//                        else if (t.partsType == 1) {
//                            return '<span class="ui-grid-tdtx">1.6L</span>';
//                        }  else if (t.partsType == 2) {
//                            return '<span class="ui-grid-tdtx">1.5L</span>';
//                        }
//                        return '<span class="ui-grid-tdtx"></span>';
//                    }
//                },
                    <!-- 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC -->
                    {
                        title: '${session.lang.OperationText}',
                        name: '',
                        width: '130px',
                        visible: 'true',
                        format: function (r, t) {
                            return option (r);
                        }
                    }],
                success: function (d) {
                    if (undefined == d.total) {
                        $ ("#number1").text (0);
                    } else if (0 == d.total) {
                        $ ("#number1").text (1);
                    } else {
                        $ ("#number1").text (d.total);
                    }
                    if (d.status < 0) {
                        artDialog (d.message, "OK");
                    }
                }
            });
        });
        /**
         * 操作列超链接
         */
        function option(r) {
            var $ul = $ ('<ul class="u-option"></ul>');
            var $li = $ ('');
            var ary_li = new Array ();
            ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitEditText}</a></li>').click (function () {
                edit (r.partsID, r.version, this)
            }));
            ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click (function () {
                if (r.delFlag == 0) {
                    del (r.partsID, r.version, r.updateTime, r.updateUser, this)
                }
            }));
            $.each (ary_li, function (i, o) {
                $li.after (o);
            });
            return $ul.append ($li);
        }
        /**
         * 查询处理
         */
        function search() {
            var param = {
                opt: 'list',
                AssemblyLineCode: $ (searchForm.AssemblyLineCode).val (),
                AssemblyLineName: $ (searchForm.AssemblyLineName).val (),
                DelFlag: $ (searchForm.DelFlag).val (),
            }
            $ ('#list').grid ('url', 'B08S012.action');
            $ ('#list').grid ('data', param);
            $ ('#list').grid ('load', 1);
            return false;
        }
        //添加零部件
        function wd_assemblyLine(data, id, obj) {
            $ ('#AssemblyLineEditForm').form ('reset');
            var title = '${session.lang.AssemblyLineAddTitle}';
            $ ('#AssemblyLineEditForm :input').removeClass ('u-ipt-err');
            $ ('#AssemblyLineEditForm').find ("*").each (function () {
                if ($ (this).hasClass ("u-sel")) {
                    $ (this).removeAttr ("style");
                }
            });
            if (typeof(data) == 'object') {
                $ (AssemblyLineEditForm.opt).val ('edit');
                // 页面赋值
                $ (AssemblyLineEditForm.DivPartsID).val (id);  //货架ID
                $ (AssemblyLineEditForm.DIVAssemblyLineCode).val (data.data.partsCode);//零部件编码
                $ (AssemblyLineEditForm.DIVAssemblyLineName).val (data.data.partsName);//零部件名称
                $ (AssemblyLineEditForm.DIVAssemblyLineType).val (data.data.partsType);//零部件类型
                $ (AssemblyLineEditForm.DivUpdateUser).val (data.data.updateUser);//更新者
                $ (AssemblyLineEditForm.DivUpdateTime).val (data.data.updateTime);//更新时间
                $ (AssemblyLineEditForm.DivVersion).val (data.data.version);//版本号
                $ (AssemblyLineEditForm.DIVDelFlag).val (data.data.delFlag);//删除区分
                title = '${session.lang.AssemblyLineEditTitle}';
                $ ('#AssemblyLineEditForm').attr ('action', 'assemblyLineEdit.action');
            } else {
                $ (AssemblyLineEditForm.DivVersion).val (0);//版本号
                $ (AssemblyLineEditForm.DIVDelFlag).val (0);//删除区分-有效
                $ ('#AssemblyLineEditForm').attr ('action', 'assemblyLineAdd.action');
            }
            $.dialog ({
                id: 'AssemblyLineEdit_dialog',
                title: title,
                lock: true,
                content: document.getElementById ('AssemblyLineEdit'),
                button: [{
                    name: '${session.lang.submitSaveText}',
                    focus: true,
                    callback: function () {
                        $ ('#AssemblyLineEditForm').form ('submit', {
                            success: function (d) {
                                $ ('#AssemblyLineEditForm :input').removeClass ('u-ipt-err');
                                $ ('#AssemblyLineEditForm').find ("*").each (function () {
                                    if ($ (this).hasClass ("u-sel")) {
                                        $ (this).removeAttr ("style");
                                    }
                                });
                                if ($.parseJSON (d).status >= 0) {
                                    //插入成功
                                    artDialog ($.parseJSON (d).message, "OK");
                                    //加载页面
                                    var param = {
                                        opt: 'list',
                                        AssemblyLineCode: $ (searchForm.AssemblyLineCode).val (),
                                        AssemblyLineName: $ (searchForm.AssemblyLineName).val (),
                                        DelFlag: $ (searchForm.DelFlag).val (),
                                    }
                                    $ ('#list').grid ('url', 'B08S012.action');
                                    $ ('#list').grid ('data', param);
                                    if ($ (AssemblyLineEditForm.opt).val () != 'edit') {
                                        $ ('#list').grid ('load', 1);
                                    } else {
                                        $ ('#list').grid ('load');
                                    }
                                    //关闭	DIV
                                    $.dialog.list['AssemblyLineEdit_dialog'].close ();
                                } else if ($.parseJSON (d).status == -1) {
                                    artDialog (d.message, "OK");
                                } else {
                                    artDialog (setContorllBackColor ($ ('#AssemblyLineEditForm'), $.parseJSON (d).message), "OK");
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
        function edit(id, version, obj) {
            var param = {
                partsID: id,                //货架ID
                opt: 'edit',                //编辑
                version: version            //版本号
            }
            $.ajax ({
                url: "assemblyLineInfo.action",    //跳转到ACTION的取得待处理库房货架信息方法
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog (d.message, "OK");
                    } else {
                        wd_assemblyLine (d, id, obj);  //调用添加工序方法
                    }
                }
            });
        }
        /**
         * 删除处理
         */
        function del(id, version, time, user, obj) {
            $.dialog.confirm ('${session.lang.UserDelInfo}', function () {
                var param = {
                    partsID: id,
                    version: version,
                    updatetime: time,
                    updateuser: user
                }
                $.ajax ({
                    url: "assemblyLineDelete.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status >= 0) {
                            $ ('#list').grid ('load');
                        }
                        artDialog (d.message, "OK");
                    }
                });
            });
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.b08s012pageTitle}</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="searchForm" name="searchForm" method="post">
            <input type="text" class="f-dn" name="DelFlag" value="0"/>
            <table width="100%" class="m-frmtb">

                <tr>
                    <th width="150">
                        零部件编码
                    </th>
                    <td>
                        <input name="partsID" type="hidden">
                        <input name="AssemblyLineCode" type="text" class="u-ipt" maxlength="36">
                    </td>
                    <th width="150">
                        零部件名称
                    </th>
                    <td>
                        <input name="AssemblyLineName" type="text" class="u-ipt" maxlength="36">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="submit" class="u-btn2" onclick="return search()">
                    ${sessionScope.lang.submitSearchText}
                </button>
                <button type="button" class="u-btn2"
                        onclick="return wd_assemblyLine()">
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
<div id="AssemblyLineEdit" class="f-dn">
    <form id="AssemblyLineEditForm" name="AssemblyLineEditForm"
          method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <input type="text" class="f-dn" name="DIVDelFlag" value="0"/>
        <input type="text" class="f-dn" name="DivVersion"/>
        <input type="text" class="f-dn" name="DivPartsID">
        <input type="text" class="f-dn" name="DivUpdateUser"/>
        <input type="text" class="f-dn" name="DivUpdateTime"/>
        <table class="m-frmtb" width="100%">
            <tr>
                <th width="150">
                    零部件编码
                </th>
                <td>
                    <input name="DIVAssemblyLineCode" type="text" class="u-ipt" maxlength="36">
                </td>
                <th width="150">
                    零部件名称
                </th>
                <td>
                    <input name="DIVAssemblyLineName" type="text" class="u-ipt" maxlength="36">
                </td>
            </tr>
            <!-- 2017/08/24 宋健 变更↓↓↓　dazhong@YMSC -->
            <%--<tr>--%>
            <%--<th width="150">--%>
            <%--零部件类型--%>
            <%--</th>--%>
            <%--<td>--%>

            <%--<select class="u-sel" name="DIVAssemblyLineType">--%>
            <%--<option value="">--${sessionScope.lang.PleaseSelect}--</option>--%>
            <%--&lt;%&ndash;<s:iterator value="#request.PartsLineList" id="ss">&ndash;%&gt;--%>
            <%--&lt;%&ndash;<s:if test='%{#ss.partsType == 0}'>&ndash;%&gt;--%>
            <%--<option value="0">--%>
            <%--1.4T--%>
            <%--</option>--%>
            <%--&lt;%&ndash;</s:if>&ndash;%&gt;--%>
            <%--&lt;%&ndash;<s:else>&ndash;%&gt;--%>
            <%--<option value="1">--%>
            <%--1.6L--%>
            <%--</option>--%>
            <%--<option value="2">--%>
            <%--1.5L--%>
            <%--</option>--%>
            <%--&lt;%&ndash;</s:else>&ndash;%&gt;--%>
            <%--&lt;%&ndash;</s:iterator>&ndash;%&gt;--%>
            <%--</select>--%>
            <%--</td>--%>
            <%--</tr>--%>
            <!-- 2017/08/24 宋健 变更↑↑↑　dazhong@YMSC -->
        </table>
    </form>
</div>
</body>
</html>

