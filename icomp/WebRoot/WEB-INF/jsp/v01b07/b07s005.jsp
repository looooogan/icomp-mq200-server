<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <%@ include file="../common/header_common.jsp" %>
    <style type="text/css">
        #tablediv td:nth-child(1),
        #tablediv th {
            text-align: center;
        }

        .m-frmtb {
            background: #fff;
        }

        .m-frmtb td {
            padding: 3px;
        }

        #searchForm2 table {
            margin: 20px 0 0;
        }

        #searchForm2 table td {
            padding: 5px;
        }

        #typeList li {
            text-indent: 1em;
            float: left;
            width: 33%;
            height: 32px;
            font-size: 14px;
        }

        .u-btn3 {
            font: menu;
            font-size: 14px;
            color: #272727;
            height: 32px;
            width: 102px;
            font-weight: 400;
            text-decoration: none;
            border: 1px solid #8797aa;
            border-radius: 4px;
            background-image: -webkit-linear-gradient(-90deg, #f7fbff, #edf3f8 50%, #e7edf5 1px, #e7edf5, #f2fbff);
        }

        .u-btn3:hover {
            background-image: -webkit-linear-gradient(-90deg, #fffbf6, #fee2c2 50%, #ffcf6a 1px, #ffcf6a, #fffff1);
        }

        table.gridtable {
            font-family: verdana, arial, sans-serif;
            font-size: 11px;
            color: #333333;
            border-width: 1px;
            border-color: #666666;
            border-collapse: collapse;
            width: 100%;
        }

        table.gridtable th {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #dedede;
        }

        table.gridtable td {
            border-width: 1px;
            padding: 8px;
            border-style: solid;
            border-color: #666666;
            background-color: #ffffff;
        }
    </style>
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
                async: true,
                rowno: true,
                rowEdit: true,
                //colEdit:1,
                rows:${session.rowsize},
                roll: 6,
                pager: true,
                pagerpos: 'right',
                pagercon: 'first,last,number,next,prev',
                column: [{
                    title: '材料号',
                    name: 'toolCode',
                }, {
                    title: '平均使用次数(D)',
                    name: 'avgFrequencyUse',
                }, {
                    title: '使用次数(E)',
                    name: 'usedCounts',
                }, {
                    title: '库存数量(F)',
                    name: 'stockCounts',
                }, {
                    title: '流转数量(G)',
                    name: 'activeCounts',
                }, {
                    title: '在途新刀数量(H)',
                    name: 'goingNewCounts',
                }, {
                    title: '在途旧刀数量(I)',
                    name: 'goingOldCounts',
                }, {
                    title: '在途旧刀折新数量(J)',
                    name: 'goingOldToNewCounts',
                }, {
                    title: '采购周期(G)',
                    name: 'procuresCycle',
                }, {
                    title: '建议采购数量',
                    name: 'purchaseCounts',
                }],
                success: function (d) {
                    if (undefined == d.total) {
                        $("#number1").text (0);
                    } else if (0 == d.total) {
                        $("#number1").text (1);
                    } else {
                        $("#number1").text (d.total);
                    }
                    if (d.status < 0) {
                        artDialog (d.message, "OK");
                    }
                }
            });
        });
        function folaID() {
            var param = {};
            $.ajax ({
                url: "partList1.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    var formulasHtml = '<option value="" >--${sessionScope.lang.PleaseSelect}--</option>';
                    for (var i = 0; i < d.length; i++) {
                        formulasHtml += '<option value="' + d[i].formulaMsg + '" title="' + d[i].formulaMsg + '">' + d[i].formulaName;
                        formulasHtml += '</option>';
                    }
                    $ ("#formulaID").empty ();
                    $ ("#formulaID").append (formulasHtml);
                }
            });
        }
        $ (function () {
            folaID ();
            /**
             * 建议采购计划查询
             */
            $ ("#search").click (function () {
                var partsCode = $ (searchForm.partsCode).val ();
                var DateStar = $ (searchForm.dstar).val ();
                var DateEnd = $ (searchForm.dend).val ();
                var formulaID = $ (searchForm.formulaID).val ();
                var ParamStringA = $ (searchForm.ParamStringA).val ();
                var ParamStringB = $ (searchForm.ParamStringB).val ();
                var ParamStringC = $ (searchForm.ParamStringC).val ();
                if (partsCode == '') {
                    alert ("请选择零部件");
                    return false;
                }
                if (DateStar == '' && DateEnd == '') {
                    alert ("请输入起始时间或结束时间");
                    return false;
                }
                var c = $ ("#formulaID").val ();
                if (c != "") {
                    if (ParamStringA == '') {
                        alert ("请填写实际产量");
                        return false;
                    }
                    if (ParamStringB == '') {
                        alert ("请填写计划产量");
                        return false;
                    }
                    if (ParamStringC == '') {
                        alert ("请填写采购频率");
                        return false;
                    }
                }
                var param = {
                    opt: 'list',
                    //时间段开始时间
                    DateStar: DateStar,
                    //时间段结束时间
                    DateEnd: DateEnd,
                    formulaID: formulaID,
                    ParamStringA: ParamStringA,
                    ParamStringB: ParamStringB,
                    ParamStringC: ParamStringC,
                    //零部件
                    partsCode: partsCode
                }
                $ ('#list').grid ('url', 'B07S005.action');
                $ ('#list').grid ('data', param);
                $ ('#list').grid ('load', 1);
                return false;
            });
            $ ("#msg").click (function () {
                findList ();
            });
            $ (".u-btn3").click (function () {
                var v = $ (this).val ();
                $ ("#ysws").val ($ ("#ysws").val () + v);
            });
        });
        //删除公式
        function fmolDel(d) {
            $.dialog.confirm ('${session.lang.UserDelInfo}', function () {
                var param = {
                    ID: d,
                };
                $.ajax ({
                    url: "partDel.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status >= 0) {
                            $ ('#list').grid ('load');
                        }
                        alert (d.message);
                        findList ();
                    }
                });
            });
        }
        //编辑公式
        function partInfo(d) {
            var param = {
                ID: d,
            };
            $.ajax ({
                url: "partInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status >= 0) {
                        $ ('#list').grid ('load');
                    }
                    $ (searchForm2.dsta111r).val (d.data.formulaMsg);
                    $ (searchForm2.data8).val (d.data.formulaID);
                    $ (searchForm2.dsta111s).val (d.data.formulaName);
                    $ (searchForm2.twt1).val (d.data.formulaDesc);
                    $ ('#searchForm2').attr ('action', 'partEdit.action');
                    findList ();
                }
            });
        }
        //添加公式
        function butionSave() {
            var showE = $ ('#data8').val ()
            if (showE == undefined || showE == "") {
                var datar = $ (searchForm2.dsta111r).val ();
                var datas = $ (searchForm2.dsta111s).val ();
                var twt1 = $ (searchForm2.twt1).val ();
                if (datar == '') {
                    alert ("请添加预算公式");
                    return false;
                }
                if (datas == '') {
                    alert ("请填写预算公式名称");
                    return false;
                }
                if (twt1 == '') {
                    alert ("请添加对此公式的描述");
                    return false;
                }
                if (datar != '' && datas != '' && twt1 != '') {
                    var param = {
                        datalr: $ (searchForm2.dsta111r).val (),
                        datals: $ (searchForm2.dsta111s).val (),
                        twt1: $ (searchForm2.twt1).val (),
                        async: false,
                    };
                    $.ajax ({
                        url: "partAdd.action",
                        type: "post",
                        dataType: "json",
                        data: param,
                        success: function (d) {
                            if (d.status == 1) {
                                alert ("请填写正确的公式！")
                            } else {
                                folaID ();
                                alert (d.message);
                            }
                            findList ();
//                            $(searchForm2.dsta111r).val("")
//                            $(searchForm2.dsta111s).val("")
//                            $(searchForm2.twt1).val("")
                        }
                    });
                }
            } else {
                var param = {
                    id: $ ('#data8').val (),
                    datalr: $ (searchForm2.dsta111r).val (),
                    datals: $ (searchForm2.dsta111s).val (),
                    twt1: $ (searchForm2.twt1).val (),
                    async: false,
                };
                $.ajax ({
                    url: "partEdit.action",
                    type: "post",
                    dataType: "json",
                    data: param,
                    success: function (d) {
                        if (d.status == 1) {
                            alert ("请填写正确的公式！")
                        } else {
                            alert (d.message);
                        }
                        findList ();
//                        $(searchForm2.dsta111r).val("")
//                        $(searchForm2.dsta111s).val("")
//                        $(searchForm2.twt1).val("")
//                        $(searchForm2.data8).val("")
                    }
                });
            }
        }
        //        function importEmp() {
        //            //检验导入的文件是否为Excel文件
        //            var excelPath = document.getElementById("excelPath").value;
        //            if (excelPath == null || excelPath == '') {
        //                alert("请选择要上传的Excel文件");
        //                return false;
        //            } else {
        //                var fileExtend = excelPath.substring(excelPath.lastIndexOf('.')).toLowerCase();
        //                if (fileExtend == '.xlsx') {
        //                } else {
        //                    alert("文件格式需为'.xlsx'格式");
        //                    return false;
        //                }
        //            }
        //        }
        //查询list
        function findList() {
            var param = {};
            $.ajax ({
                url: "partList.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    $.dialog ({
                        //弹出框
                        id: 'roleEdit_dialog',
                        title: '公式管理',
                        Height: '100',
                        lock: true,
                        content: document.getElementById ('procurementDiv')
                    });
                    var officList = d.formulasLists;
                    var str = ' <tr><th width="5%">序号</th><th width="25%">公式名称</th><th width="60%">公式</th><th width="10%">操作</th></tr><tr>';
                    for (var j = 0; j < officList.length; j++) {
                        str += '<tr>';
//                            str += "<td><a href='###'>" + officList[j].formulaID + "</a></td>+<td><a href='###'>" + officList[j].formulaName + "</a></td>+<td><a href='###'>" + officList[j].formulaMsg + "</a></td>+<td><a href='###'>"+'编辑删除'+"</a></td>";
                        str += "<td>" + (j + 1) + "</td>+<td>" + officList[j].formulaName + "</td>+<td>" + officList[j].formulaMsg + "</td>+<td>" + '<a href="javascript:partInfo(' + officList[j].formulaID + ')">编辑</a>&nbsp;&nbsp;<a href="javascript:fmolDel(' + officList[j].formulaID + ')">删除</a>' + "</td>";
                        str += "</tr>"
                    }
                    $ ('#tablediv').empty ();
                    $ ('#tablediv').append (str);
//                    alert($('#tablediv').html());
                }
            });
        }
        //导出
        function daoc() {
            $.dialog.confirm ('您确定要导出么？', function () {
                $ ("#partsCodeHid").val ($ (searchForm.partsCode).val ());
                $ ("#dstarHid").val ($ (searchForm.dstar).val ());
                $ ("#dendHid").val ($ (searchForm.dend).val ());
                $ ("#formulaIDHid").val ($ (searchForm.formulaID).val ());
                $ ("#ParamStringAHid").val ($ (searchForm.ParamStringA).val ());
                $ ("#ParamStringBHid").val ($ (searchForm.ParamStringB).val ());
                $ ("#ParamStringCHid").val ($ (searchForm.ParamStringC).val ());
                $ ("#hidFrom").submit ();
            });
        }
        ;
    </script>
</head>
<body>
<div id="hiddDiv" style="display: none">

    <form action="exportExcel07S005.action" method="post" id="hidFrom">
        <input type="hidden" name="partsCode" id="partsCodeHid">
        <input type="hidden" name="dstar" id="dstarHid">
        <input type="hidden" name="dend" id="dendHid">
        <input type="hidden" name="formulaID" id="formulaIDHid">
        <input type="hidden" name="ParamStringA" id="ParamStringAHid">
        <input type="hidden" name="ParamStringB" id="ParamStringBHid">
        <input type="hidden" name="ParamStringC" id="ParamStringCHid">
    </form>
</div>

<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${session.lang.b07s005pageTitle}</span>
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
                        零部件
                    </th>
                    <td width="350">
                        <select class="u-sel" name="partsCode">
                            <option value="" selected="selected">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <s:iterator value="#request.partsList" id="parts">
                                <option value="${parts.partsID}">
                                        ${parts.partsName}
                                </option>
                            </s:iterator>
                        </select>
                    </td>

                    <th width="150">
                        起始时间
                    </th>
                    <td width="350">
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>
                    <th width="150">
                        结束时间
                    </th>
                    <td width="350">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>
                </tr>

                <tr>
                    <th width="150">
                        实际产量（A）
                    </th>
                    <td>
                        <input name="ParamStringA" type="text" class="u-ipt">
                    </td>
                    <th width="150">
                        计划产量（B）
                    </th>
                    <td>
                        <input name="ParamStringB" type="text" class="u-ipt">
                    </td>
                    <th width="150">
                        采购频率（C）
                    </th>
                    <td>
                        <select class="u-sel" name="ParamStringC">
                            <option value="" selected="selected">
                                --${sessionScope.lang.PleaseSelect}--
                            </option>
                            <option value="0.5">2周</option>
                            <option value="1">4周</option>
                            <option value="2">8周</option>
                            <option value="3">12周</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <th>
                        计算公式
                    </th>
                    <td width="350">
                        <select class="u-sel" name="formulaID" id="formulaID">
                            <%--<s:iterator value="#request.formulasList" id="formu">--%>
                            <%--<option value="${formu.formulaID}">--%>
                            <%--${formu.formulaName}--%>
                            <%--</option>--%>
                            <%--</s:iterator>--%>

                        </select>
                        <button type="button" class="u-btn2" id="msg">公式管理</button>
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="submit" class="u-btn2" id="search">${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" onclick="return daoc();">导出</button>
            </div>
        </form>
        <%--<form name="form1" action="excelDown.action" method="post" enctype="multipart/form-data">--%>
        <%--<table width="100%" class="m-frmtb">--%>
        <%--<tr>--%>
        <%--<th width="190">--%>
        <%--刀具需求单导入--%>
        <%--</th>--%>
        <%--<td width="150">--%>
        <%--<input type="file" class="u-ipt" id="excelPath" name="file"/>${state}--%>
        <%--</td>--%>
        <%--<td width="105" style=" float: left;">--%>
        <%--<div class="g-fx1 f-fr">--%>
        <%--<button type="submit" class="u-btn2" id="excelPath1" name="submit"--%>
        <%--onclick="return importEmp();">导入--%>
        <%--</button>--%>
        <%--</div>--%>
        <%--</td>--%>
        <%--</tr>--%>
        <%--</table>--%>

        <%--</form>--%>

        <div class="f-cb"></div>

        <div class="u-ptt">
            ${sessionScope.lang.searchList}

        </div>
        <div style="float:right;">
            共：<span id="number1"></span> &nbsp;条
        </div>
             <div style="clear:both;"></div>
    </div>
    <div class="ui-layout-center">
        <table id="list"></table>
        <div id="bar"></div>
    </div>
</div>


<%--弹出DIV--%>

<div id="procurementDiv" class="f-dn">
    <div class="ui-layout-center g-ct-bd">

        <div class="ui-layout-north">

            <table width="100%">
                <tr width="100%">
                    <td width="50%">
                        <ul id="typeList">
                            <li>A：实际产量</li>
                            <li>B：计划产量</li>
                            <li>C：采购频率</li>
                            <li>D：平均使用次数</li>
                            <li>E：使用次数</li>
                            <li>F：库存数量</li>
                            <li>G：流转数量</li>
                            <li>H：在途新刀数量</li>
                            <li>I：在途旧刀数量</li>
                            <li>J：在途旧刀折新数量</li>
                        </ul>
                    </td>
                    <td width="50%">

                        <table width="100%" class="m-frmtb">
                            <tr>
                                <td>
                                    <button type="button" class="u-btn3" value="A">A</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="B">B</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="C">C</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="D">D</button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="button" class="u-btn3" value="E">E</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="F">F</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="G">G</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="H">H</button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="button" class="u-btn3" value="I">I</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="J">J</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="+">+</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="-">-</button>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <button type="button" class="u-btn3" value="*">*</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="/">/</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value="(">(</button>
                                </td>
                                <td>
                                    <button type="button" class="u-btn3" value=")">)</button>
                                </td>
                            </tr>
                        </table>
                    </td>
                </tr>
            </table>


            <form id="searchForm2" name="searchForm2" method="post">
                <table width="100%">
                    <tr width="100%">
                        <th width="10%">
                            预算公式：
                        </th>
                        <td width="70%">
                            <input name="dsta111r" type="text" class="u-ipt" id="ysws" style="width: 99%">
                        </td>
                        <td>
                            <input type="hidden" name="data8" id="data8">
                            <button type="button" class="u-btn2" style=" float: right;" id="save"
                                    onclick=" return butionSave();">保存
                            </button>
                        </td>
                    </tr>
                    <tr width="100%">
                        <th width="10%">
                            公式名称：
                        </th>
                        <td width="70%">
                            <input name="dsta111s" type="text" class="u-ipt" id="yswss" style="width: 50%">
                        </td>
                    </tr>
                    <tr width="100%">
                        <th width="10%">
                            描述：
                        </th>
                        <td width="70%">
                            <textarea name="twt1" id="yswtt" rows="5" style="width: 100%"></textarea>
                        </td>
                    </tr>
                </table>

            </form>
        </div>
        <div class="f-cb"></div>
    </div>

    <div style=" padding-bottom: 25px;">
        <div class="u-ptt">
            ${sessionScope.lang.searchList}
        </div>

        <div style=" height:200px;overflow:auto">
            <table class="gridtable" id="tablediv"></table>
        </div>
    </div>
</div>


</body>
</html>

