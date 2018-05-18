<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
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
                barid:'#bar',
                datatype:'json',
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
                    title: '订单号',
                    name: 'toolsOrdeNO'
                },
//                    {
//                    title: '刀具类型',
//                    name: 'storageType'
//
//                },
                    {
                    title: '材料号',
                    name: 'toolCode'

                },
                    {
                    title: '库存状态',
                    name: 'storageState',
                    format: function (r) {
                        if (r.storageState == 0){return '<span class="ui-grid-tdtx">新刀</span>';}

                    }
                },
                    {
                    title: '库管员',
                    name: 'createUser'

                }, {
                    title: '入库数量',
                    name: 'storageNum'
                }, {
                    title: '入库时间',
                    name: 'createTime',
                    format: function (r) {
                        return '<span class="ui-grid-tdtx">' + fdate4(r.createTime) + '</span>';
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


        $(function () {
            /**
             * 入库信息查询
             */
            $("#toolLibrarySubmit").click(function () {
                var param = {
                    opt: 'list',
                    //ToolConsumetype: $(toolStorageFrom.ToolConsumetype).val(),
                    DateStar: $(toolStorageFrom.dstar).val(),
                    DateEnd: $(toolStorageFrom.dend).val(),
                    UserName: $(toolStorageFrom.UserName).val(),
                    SysteCode: $(toolStorageFrom.SysteCode).val(),
                    KnifeInventory: $(toolStorageFrom.KnifeInventory).val(),
                    ProcuredBatch: $(toolStorageFrom.ProcuredBatch).val(),
                }
                $('#list').grid('url', 'B01S001.action');
                $('#list').grid('data', param);
                $('#list').grid('load', 1);
                return false;
            });


            //导出
            $("#toolLibraryOut").click(function () {

                $.dialog.confirm('您确定要导出么？', function (){

                    //$("#toolConsumetypeHid").val($(toolStorageFrom.ToolConsumetype).val());
                    $("#dateStarHid").val($(toolStorageFrom.dstar).val());
                    $("#dateEndHid").val($(toolStorageFrom.dend).val());
                    $("#systeCodeHid").val($(toolStorageFrom.SysteCode).val());
                    $("#knifeInventoryHid").val($(toolStorageFrom.KnifeInventory).val());
                    $("#procuredBatchHid").val($(toolStorageFrom.ProcuredBatch).val());
                    $("#userNameHid").val($(toolStorageFrom.UserName).val());

                    $("#hidFrom").submit();
                });

            });
        });


//        function click1(){
//                $("#bg,.loading").fadeIn();
//            var param = {}
//                $.ajax({
//                    url:"show.action",
//                    type:"post",
//                    dataType:"json",
//                    data: param ,
//                    success:function(d){
//                        $("#bg,.loading").fadeOut();
//                    }
//                })
//        };
    </script>
    <style type="text/css">
        #bg{ display: none; position: absolute; top: 0%; left: 0%; width: 100%; height: 100%; background-color: black; z-index:1001; -moz-opacity: 0.2; opacity:.2; filter: alpha(opacity=70);}
        .loading{display: none; position: absolute; top: 50%; left: 50%; z-index:1002; }
    </style>
</head>
<body >
        <div id="hiddDiv" style="display: none">
            <form action="exportExcel01S001.action" method="post" id="hidFrom">
            <input  type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
            <input type="hidden" name="dateStar" id="dateStarHid">
            <input type="hidden" name="dateEnd" id="dateEndHid">
            <input type="hidden" name="systeCode" id="systeCodeHid">
            <input type="hidden" name="userName" id="userNameHid">
            <input type="hidden" name="knifeInventory" id="knifeInventoryHid">
            <input type="hidden" name="procuredBatch" id="procuredBatchHid">
            </form>
        </div>



        <div class="ui-layout-north g-ct-tt">
            <div class="g-ct-ttc">
                <span>${sessionScope.lang.b01s001pageTitle}</span>
                <%@ include file="../head_div.jsp" %>
            </div>
        </div>
        <div class="ui-layout-center g-ct-bd">
            <div class="ui-layout-north">
                <div class="u-ptf">
                    ${sessionScope.lang.searchTitle}
                </div>
                <form id="toolStorageFrom" name="toolStorageFrom" method="post">
                    <table width="100%" class="m-frmtb">
                        <tr>
                            <%--<th>--%>
                                <%--刀具类型--%>
                            <%--</th>--%>
                            <%--<td>--%>
                                <%--<select class="u-sel" name="ToolConsumetype" maxlength="6">--%>
                                    <%--<option value="">--%>
                                        <%----请选择----%>
                                    <%--</option>--%>

                                    <%--<option value="A">--%>
                                        <%--A--%>
                                    <%--</option>--%>

                                    <%--<option value="B">--%>
                                        <%--B--%>
                                    <%--</option>--%>

                                    <%--<option value="C">--%>
                                        <%--C--%>
                                    <%--</option>--%>

                                    <%--<option value="D">--%>
                                        <%--D--%>
                                    <%--</option>--%>

                                    <%--<option value="E">--%>
                                        <%--E--%>
                                    <%--</option>--%>

                                    <%--<option value="F">--%>
                                        <%--F--%>
                                    <%--</option>--%>

                                    <%--<option value="G">--%>
                                      <%--G--%>
                                    <%--</option>--%>

                                    <%--<option value="H">--%>
                                        <%--H--%>
                                    <%--</option>--%>

                                    <%--<option value="I">--%>
                                       <%--I--%>
                                    <%--</option>--%>

                                    <%--<option value="S">--%>
                                        <%--S--%>
                                    <%--</option>--%>




                                <%--</select>--%>
                            <%--</td>--%>
                            <th>
                                材料号
                            </th>
                            <td>
                                <input name="SysteCode" type="text" class="u-ipt" maxlength="10" onkeyup="this.value=this.value.toUpperCase()">
                            </td>
                            <th>
                                库存状态
                            </th>
                            <td>
                                <select class="u-sel" name="KnifeInventory" maxlength="6">
                                    <option value="">
                                        --请选择--
                                    </option>

                                    <option value="0">
                                        新刀
                                    </option>

                                    <option value="1">
                                        外修
                                    </option>

                                    <option value="2">
                                        报废回库
                                    </option>


                                </select>
                            </td>

                        </tr>
                        <tr>
                            <th>
                                订单号
                            </th>
                            <td>
                                <input name="ProcuredBatch" type="text" class="u-ipt" maxlength="20">
                            </td>
                            <th>
                                入库时间段
                            </th>
                            <td style="white-space: nowrap">
                                <%--<input name="dstar" type="text" class="u-ipt Wdate"--%>
                                       <%--onclick="WdatePicker({dateFmt:'yyyy-MM-dd HH:mm:ss'})">--%>
                                <input name="dstar" type="text" class="u-ipt Wdate"
                                       onclick="WdatePicker()">
                                <input name="dend" type="text" class="u-ipt Wdate"
                                       onclick="WdatePicker()">
                            </td>
                            <th>
                                库管员
                            </th>
                            <td>
                                <input name="UserName" type="text" class="u-ipt" maxlength="20">
                            </td>

                    </table>
                    <div class="g-fx1 f-fr"><%--onclick="click1()"--%>
                        <button type="button" class="u-btn2" id="toolLibrarySubmit" >查询</button>
                        <%--<div class="loading"><img src="images/loading.gif">加载中。。。</div>--%>
                        <%--<button type="button" class="u-btn2" id="toolLibraryOut">导出</button>--%>

                    </div>
                </form>
                <div class="f-cb"></div>


                <div class="u-ptt">
                    <div style="float:left;">${sessionScope.lang.searchList}</div>
                    <div style="float:right;">
                      共：<span id="number1"></span>  &nbsp;条
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

