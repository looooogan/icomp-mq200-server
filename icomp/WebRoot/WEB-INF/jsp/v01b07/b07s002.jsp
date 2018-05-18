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
                column: [
//                        {
//                    title: '刀具类型',
//                    name: 'toolConsumetype'
//                },
                    {
                    title: '预警类型',
                    name: 'expandSpace3',
                    format: function (r) {
                        if (r.expandSpace3 == 0) {
                            return '<span class="ui-grid-tdtx">新刀库</span>';
                        }
                        else {
                            return '<span class="ui-grid-tdtx">备刀库</span>'
                        }
                    }
                }, {
                    title: '材料号',
                    name: 'toolCode'
                }, {
                    title: '当前库存数量',
                    name: 'knifelnventoryNumber'
                }, {
                    title: '预警线数量',
                    name: 'expandSpace4'
                }, {
                    title: '差额数量',
                    name: 'cstandard',
                    format: function (r) {
                        if (r.cstandard < 0) {
                            return '<span class="ui-grid-tdtx" style="color: red;font-weight:bold;">'+r.cstandard+'</span>';
                        }
                        else {
                            return '<span class="ui-grid-tdtx">'+r.cstandard+'</span>'
                        }
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
            /**
             * （合成刀具状态）车间刀具状态查询
             */
            $ ("#searchSubmit").click (function () {
                search ();
            });
        });
        /**
         * 库存异常报警查询
         */
        function search() {
            var param = {
                opt: 'list',
                pVentoryType:$("#pVentoryType").val(),
            }
            $ ('#list').grid ('url', 'B07S002.action');
            $ ('#list').grid ('data', param);
            $ ('#list').grid ('load', 1);
            return false;
        }
    </script>
</head>
<body>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>当前页:首页 > 预警模块管理 > 库存异常报警</span>
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
                    <th width="100">
                        优先查询
                    </th>
                    <td>
                        <select class="u-sel" name="pVentoryType" id="pVentoryType">
                            <option value="0" selected="selected">新刀库</option >
                            <option value="1">备刀库</option>
                        </select>
                    </td>
                </tr>
            </table>
            <br/>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="searchSubmit">${sessionScope.lang.submitSearchText}</button>
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
</body>
</html>

