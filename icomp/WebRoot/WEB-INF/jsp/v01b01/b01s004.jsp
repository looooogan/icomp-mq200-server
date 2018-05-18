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
                barid: '#bar',
                datatype: 'json',
                type:'post',
                width:'100%',
                fit:true,
                lazy:false,
                rowno:true,
                rows:${session.rowsize},
                roll:6,
                pager:true,
                pagerpos:'right',
                pagercon:'first,last,number,next,prev',
                column:[
//                        {
//                    title:'刀具类型',
//                    name:'toolType'
//                },
                    {
                    title:'材料号',
                    name:'toolCode'
                },{
                    title:'时间',
                    name:'applyTime',
                    format:function(r){
                        return '<span class="ui-grid-tdtx">'+fdate4(r.applyTime)+'</span>';
                    }
                },{
                    title:'领取数量',
                    name:'receiveNumber'
                },
                    <!-- 2017/09/8 宋健 追加↓↓↓　dazhong@YMSC -->
                    {
                        title:'换领数量',
                        name:'appliedNumber'
                    },
                    <!-- 2017/09/8 宋健 追加↑↑↑　dazhong@YMSC -->
                    <!-- 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC -->
                    {
                        title:'签收人',
                        name:'receiveUser'
                    },
                    <!-- 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC -->
                    <!-- 2017/09/8 王冉 变更↓↓↓　dazhong@YMSC -->
                    {
                        title:'申请人',
                        name:'applyUser'
                    },{
                    <!-- 2017/09/8 王冉 变更↑↑↑　dazhong@YMSC -->

                        title:'完成情况',
                        name:'processingStatus',
                        format:function(t) {
//						(0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )
                            if (t.processingStatus == 0) {
                                return '<span class="ui-grid-tdtx">	申请中</span>';
                            }else {
                                return '<span class="ui-grid-tdtx">	换领完毕</span>';
                            }

                            return '<span class="ui-grid-tdtx"></span>';
                        }
                    }
                    <!-- 2017/09/8 宋健 变更↓↓↓　dazhong@YMSC -->
//					,{
//						title:'详细',
//						name:'urlDetail',
//					width:'130px',
//					visible:'true',
//					format:function(r,t){
//						return option(r);
//					}}
                    <!-- 2017/09/8 宋健 变更↑↑↑　dazhong@YMSC -->
                ],
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
        function option(r){
            var $ul = $('<ul class="u-option"></ul>');
            var $li = $('');
            var ary_li = new Array();
            ary_li.push($('<li><a href="javascript:void(0)">明细</a></li>').click(function(){showother(r.redemptionAppliedID)}));
            $.each(ary_li,function(i,o){
                $li.after(o);
            });
            return $ul.append($li);
        }

        //详细
        function showother(r) {
            var param = {
                redemptionAppliedID: r,
            }
            $.ajax({
                url: "redemptionappliedInfo.action",
                type: "post",
                dataType: "json",
                data: param,
                success: function (d) {
                    if (d.status < 0) {
                        artDialog(d.message, "OK");
                    } else {
                        $(roleEditForm.DIVappliedNumber).val(d.data.appliedNumber);
                        $(roleEditForm.DIVreturnNumber).val(d.data.returnNumber);
                        $(roleEditForm.DIVlostNumber).val(d.data.lostNumber);
                        $(roleEditForm.DIVapplyUser).val(d.data.receiveUser);
                        var  tc = d.data.updateTime;
                        if(tc==null||undefined==tc){
                            $(roleEditForm.DIVupdateTime).val(d.data.updateTime);
                        }else {
                            var  tcs = tc.split("T");
                            var tcse = tcs[0]+" "+tcs[1];
                            $(roleEditForm.DIVupdateTime).val(tcse);
                        }


                        $.dialog({
                            id: 'tj_list_dialog',
                            title: '详细',
                            lock: true,
                            content: document.getElementById('roleEdit'),

                        });
                    }
                }
            });

        }
        $(function(){
            /**
             * 换领申请信息查询
             */
            $("#redemptionSearch").click(function(){
                var param = {
                    opt:'list',
                    ToolConsumetype:$(redemptionFrom.ToolConsumetype).val(),
                    libraryMember:$(redemptionFrom.libraryMember).val(),
                    systeCode:$(redemptionFrom.systeCode).val(),
                    status:$(redemptionFrom.status).val(),
                    applyPerson:$(redemptionFrom.applyPerson).val(),
                    DateStar:$(redemptionFrom.dstar).val(),
                    DateEnd:$(redemptionFrom.dend).val(),
                }
                $('#list').grid('url','B01S004.action');
                $('#list').grid('data',param);
                $('#list').grid('load',1);
                return false;
            });
            //导出
            $("#infoExport").click(function () {

                $.dialog.confirm('您确定要导出么？', function (){

                    $("#toolConsumetypeHid").val($(redemptionFrom.ToolConsumetype).val());
                    $("#dateStarHid").val($(redemptionFrom.dstar).val());
                    $("#dateEndHid").val($(redemptionFrom.dend).val());
                    $("#systeCodeHid").val($(redemptionFrom.systeCode).val());
                    $("#libraryMemberHid").val($(redemptionFrom.libraryMember).val());
                    $("#statusHid").val($(redemptionFrom.status).val());
                    $("#applyPersonHid").val($(redemptionFrom.applyPerson).val());

                    $("#hidFrom").submit();
                });

            });

        });
    </script>
</head>
<body>
<div id="hiddDiv" style="display: none">
    <form action="exportExcel01S004.action" method="post" id="hidFrom">
        <input type="hidden" name="toolConsumetype" id="toolConsumetypeHid">
        <input type="hidden" name="dateStar" id="dateStarHid">
        <input type="hidden" name="dateEnd" id="dateEndHid">
        <input type="hidden" name="systeCode" id="systeCodeHid">
        <input type="hidden" name="libraryMember" id="libraryMemberHid">
        <input type="hidden" name="status" id="statusHid">
        <input type="hidden" name="applyPerson" id="applyPersonHid">
    </form>
</div>
<div class="ui-layout-north g-ct-tt">
    <div class="g-ct-ttc">
        <span>${sessionScope.lang.b01s004pageTitle}</span>
        <%@ include file="../head_div.jsp" %>
    </div>
</div>
<div class="ui-layout-center g-ct-bd">
    <div class="ui-layout-north">
        <div class="u-ptf">
            ${sessionScope.lang.searchTitle}
        </div>
        <form id="redemptionFrom" name="redemptionFrom" method="post">
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
                            <%--<option value="a">--%>
                                <%--A--%>
                            <%--</option>--%>
                            <%--<option value="b">--%>
                                <%--B--%>
                            <%--</option>--%>
                            <%--<option value="c">--%>
                                <%--C--%>
                            <%--</option>--%>
                            <%--<option value="d">--%>
                                <%--D--%>
                            <%--</option>--%>
                            <%--<option value="e">--%>
                                <%--E--%>
                            <%--</option>--%>
                            <%--<option value="f">--%>
                                <%--F--%>
                            <%--</option>--%>
                            <%--<option value="g">--%>
                                <%--G--%>
                            <%--</option>--%>
                            <%--<option value="h">--%>
                                <%--H--%>
                            <%--</option>--%>
                            <%--<option value="i">--%>
                                <%--I--%>
                            <%--</option>--%>
                            <%--<option value="s">--%>
                                <%--S--%>
                            <%--</option>--%>

                        <%--</select>--%>
                    <%--</td>--%>
                    <th width="150">
                        材料号
                    </th>
                    <td>
                        <input name="systeCode" type="text" class="u-ipt"  maxlength="16" onkeyup="this.value=this.value.toUpperCase()">
                    </td>


                    <th width="150">
                        时间段
                    </th>
                    <td>
                        <input name="dstar" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                        <input name="dend" type="text" class="u-ipt Wdate" onclick="WdatePicker()">
                    </td>
                </tr>
                <tr>
                    <th width="150">
                        库管员
                    </th>
                    <td>
                        <input name="libraryMember" type="text" class="u-ipt"  maxlength="8">
                    </td>


                    <th>
                        状态
                        <%--(0申请中1已备货 2换领已送回 3换领未送回 4.换领完毕 )--%>
                    </th>
                    <td>
                        <select class="u-sel" name="status" maxlength="6">
                            <option value="">
                                --请选择--
                            </option>

                            <option value="0">
                                申请中
                            </option>
                            <option value="4">
                                换领完毕
                            </option>
                        </select>
                    </td>
                    <th width="150">
                        申请人
                    </th>
                    <td>
                        <input name="applyPerson" type="text" class="u-ipt"  maxlength="8">
                    </td>
                </tr>
            </table>
            <div class="g-fx1 f-fr">
                <button type="button" class="u-btn2" id="redemptionSearch" >${sessionScope.lang.submitSearchText}</button>
                <button type="button" class="u-btn2" id="infoExport">导出</button>
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
<%--明细DIV--%>
<div id="roleEdit" class="f-dn">
    <form id="roleEditForm" name="roleEditForm" method="post">
        <input type="text" class="f-dn" name="opt" value="add"/>
        <table class="m-frmtb" width="100%">

            <tr>
                <th width="150">
                    换领数量
                </th>
                <td>
                    <input name="DIVappliedNumber" type="text" class="u-ipt" maxlength="16" disabled>
                </td>
                <th width="150">
                    送回数量
                </th>

                <td>
                    <input name="DIVreturnNumber" type="text" class="u-ipt" maxlength="16" disabled>

                </td>
                <th width="150">
                    丢失数量
                </th>
                <td>
                    <input name="DIVlostNumber" type="text" class="u-ipt" maxlength="16" disabled>
                </td>
            </tr>
            <tr>
                <th width="150">
                    签收人
                </th>
                <td>
                    <input name="DIVapplyUser" type="text" class="u-ipt" maxlength="8" disabled>
                </td>

                <th width="150">
                    送回时间
                </th>
                <td>
                    <input name="DIVupdateTime" type="text" class="u-ipt" maxlength="16" >
                </td>

            </tr>
        </table>
    </form>
</div>
</html>

