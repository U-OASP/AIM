<%@page import="com.rds.code.utils.syspath.ConfigPath"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>业务模块首页</title>

<%
	String basepath = ConfigPath.getAppURL(request);
%>
<style type="text/css">
</style>
<link href="<%=basepath %>extjs/resources/css/ext-all.css" rel="stylesheet" />
<link href="<%=basepath %>extjs/resources/css/icon.css" rel="stylesheet" />

<script type="text/javascript">
	var basepath = '<%=basepath%>';
	
	var menuid = '${menuid}';
	var userid = '${userid}';
	var username = '${username}';
	
	var  queryString = "userid="+userid+"&username="+username;
</script>

<script type="text/javascript" language="javascript">   

	function iFrameHeight() {
		var ifm = document.getElementById("iframepage");
		var subWeb = document.frames ? document.frames["iframepage"].document
				: ifm.contentDocument;
		if (ifm != null && subWeb != null) {
			ifm.height = subWeb.body.scrollHeight;
			ifm.width = subWeb.body.scrollWidth;
		}
	}
</script>
<script type="text/javascript" src="<%=basepath %>extjs/bootstrap.js"></script>
<script type="text/javascript" src="<%=basepath %>extjs/locale/ext-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basepath %>resource/IndexApp.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basepath %>resource/init.js" charset="utf-8"></script>
</head>
<body>
</body>
</html>