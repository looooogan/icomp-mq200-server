<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
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
                async: false,
                rowno: true,
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '需求号',
                    width: '8%',
                    name: 'demandCode'
                }, {
                    title: '材料号',
                    width: '5%',
                    name: 'materialNr'
                }, {
                    title: '订货名称',
                    width: '12%',
                    name: 'bestellBezeichnung'
                }, {
                    title: '数量',
                    name: 'menge'
                }, {
                    title: '单价',
                    name: 'unitPreis',
                }, {
                    title: '供货商',
                    width: '12%',
                    name: 'lieferant'
                }, {
                    title: '使用点',
                    name: 'einsAtzort'
                }, {
                    title: '供货周期（月）',
                    width: '8%',
                    name: 'liefertermin'
                }, {
                    title: '是否到货',
                    width: '8%',
                    name: 'delFlag',
                    format: function (t) {
                        if (t.delFlag == 0) {
                            return '<span class="ui-grid-tdtx">未到货</span>';
                        } else {
                            return '<span class="ui-grid-tdtx">已到货</span>';
                        }
                        return '<span class="ui-grid-tdtx"></span>';
                    }
                }, {
                    title: '备注',
                    width: '10%',
                    name: 'notes'
                }, {
                    title: '录入日期',
                    width: '8%',
                    name: 'typingDate',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate1 (r.typingDate) + '</span>';
                    }
                }, {
                    title: '操作',
                    name: '',
                    width: '5%',
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
            ary_li.push ($ ('<li><a href="javascript:void(0)">${session.lang.submitDelText}</a></li>').click (function () {
                del (r.demandCode, r.materialNr, this);
            }));
            $.each (ary_li, function (i, o) {
                $li.after (o);
            });
            return $ul.append ($li);
        }
        /**
         * 删除处理
         */
        function del(demandCode, materialNr, obj) {
            $.dialog.confirm ('${session.lang.UserDelInfo}', function () {
                var param = {
                    demandCode: demandCode,
                    materialNr: materialNr
                }
                $.ajax ({
                    url: "werDelete.action",
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
        function selist() {
            var param = {
                opt: 'list',
            }
            $ ('#list').grid ('url', 'B07S001.action');
            $ ('#list').grid ('data', param);
            $ ('#list').grid ('load', 1);
            return false;
        }
        function importEmp() {
            //检验导入的文件是否为Excel文件
            var excelPath = document.getElementById ("excelPath").value;
            if (excelPath == null || excelPath == '') {
                alert ("请选择要上传的Excel文件");
                return false;
            } else {
                var fileExtend = excelPath.substring (excelPath.lastIndexOf ('.')).toLowerCase ();
                if (fileExtend == '.xlsx') {
                } else {
                    alert ("文件格式需为'.xlsx'格式");
                    return false;
                }
            }
        }
    </script>


</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页>首页>采购计划>EBM需求单导入</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}

        </div>

        <form name="form1" action="excelDown.action" method="post" enctype="multipart/form-data">
            <table width="100%" class="m-frmtb">
                <tr>
                    <th width="190">
                        刀具需求单导入
                    </th>
                    <td width="150">
                        <input type="file" class="u-ipt" id="excelPath" name="file"/>${state}
                    </td>
                    <td width="105" style=" float: left;">
                        <div class="g-fx1 f-fr">

                        </div>
                    </td>
                    <td>
                        <div class="g-fx1 f-fr">
                            <button type="submit" class="u-btn2" id="excelPath1" name="submit" onclick="return importEmp();">导入

                            </button>
                            <button type="button" class="u-btn2" id="toolLibrarySubmit" onclick="return selist()">查询</button>
                            <%--<button type="button" class="u-btn2" id="toolLibraryOut">导出</button>--%>
                        </div>
                    </td>


                </tr>
            </table>

        </form>

        <div class="f-cb"></div>
        <div class="u-ptt">
            <div style="float:left;">${sessionScope.lang.searchList}</div>
            <div style="float:right;">
                共: <span id="number1"></span> &nbsp;条
            </div>
            <div style="clear:both;"></div>
        </div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>
</body>
</html>

