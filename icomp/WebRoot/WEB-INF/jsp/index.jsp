<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.icomp.entity.base.Vgrantlist"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Frameset//EN" "http://www.w3.org/TR/html4/frameset.dtd">
<html>
<head>
	<title>${sessionScope.lang.loginTitle}</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<%@ include file="common/header_common.jsp"%>
	<link href="<%=path%>/style/style.css" rel="stylesheet"
		  type="text/css">
	<script type="text/javascript">
		$(function(){

			$('body').layout({
				center__maskContents:true,
				west__size:215,
				west__minSize:215,
				west__maxSize:215,
				west__resizable:true,
				north:{
					size:'auto',
					spacing_open:0,
					closable:false,
					resizable:false
				},
				west__childOptions:{
					south__size:74,
					south__resizable:false,
					spacing_open:0
				}
			});

			$('.m-menu > dt').click(function(){
				$this = $(this);
				$dd = $('.m-menu > dd:visible');
				$dd.hide('blind',200);
				$this.next('dd').toggle('blind',200);
			});

		});
		function Internationalization(f){
			var lang = f.value;
			var value = f.attr("tag").val();
			var param = {
				language:lang,
				langValue:value
			}
			$.ajax({
				url:"editLanguage.action",
				type: "post",
				dataType:"json",
				data:param,
				success:function(d){
					if(d.status < 0){
						$(language).val('{session.local}');
						artDialog(d.message,"OK");

					}else{
						window.location.reload();
					}
				}
			});


		}
	</script>
</head>
<body>
<%--<div id="north" class="ui-layout-north">--%>
<%----%>
<%--<table width="100%"  border="0" cellpadding="0" cellspacing="0" class="bg_logo">--%>
<%--<tr>--%>
<%--<td><img src="style/<%=session.getAttribute("languageCode")%>/image/index_01.gif" ></td>--%>
<%--<td align="right"><img src="style/<%=session.getAttribute("languageCode")%>/image/index_03.gif" ></td>--%>
<%--</tr>--%>
<%--</table>--%>

<%--</div>--%>
<div id="west" class="ui-layout-west" style="width: 259px;">
	<div class="ui-layout-center" style="background:#e2e2e2;OVERFLOW:SCROLL;OVERFLOW-X:HIDDEN;">
		<div>
			<div class="bg_menu"></div>
		</div>
		<div class="g-sd2 m-nav">

			<dl class="m-menu">
				<%
					for(Vgrantlist vgrantlist:(List<Vgrantlist>)session.getAttribute("CustomerGrant")){
						if(vgrantlist.getCapabilityLevel().intValue()==1){%>
				<dt><span><%= vgrantlist.getCapabilityName()%></span></dt>
				<dd>
					<ul>
						<%for(Vgrantlist vgrant:(List<Vgrantlist>)session.getAttribute("CustomerGrant")){
							if(vgrant.getCapabilityLevel().intValue()==2
									&&vgrant.getCapCapabilityID().equals(vgrantlist.getCapabilityID())){%>
						<li><a href="<%= vgrant.getCapabilityUrl()%>" target="center"><%= vgrant.getCapabilityName()%></a></li>
						<%}
						}
						%>
					</ul>
				</dd>
				<%
						}
					}%>
			</dl>
		</div>
	</div>
	<%--<div class="ui-layout-south" style="background:#e2e2e2;">--%>
	<%--<div class="g-sd1b"></div>--%>
	<%--</div>		--%>
</div>
<iframe id="center" name="center" class="ui-layout-center" scrolling="auto" src="init.action"></iframe>
</body>
</html>