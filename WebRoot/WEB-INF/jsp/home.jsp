<%@page import="com.rds.code.utils.syspath.ConfigPath"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>首页</title>

<%
	String basepath = ConfigPath.getAppURL(request);
%>
<style type="text/css">
</style>
<link href="<%=basepath %>extjs/resources/css/ext-all.css" rel="stylesheet" />
<link href="<%=basepath %>extjs/resources/css/icon.css" rel="stylesheet" />

<style type="text/css">
	.background{
		background-color:#EE7600;
	}
</style>


<script type="text/javascript">
	var basepath = '<%=basepath%>';
	
	var anchor_height = "40%";
	
	var username = '${username}';
	var userid = '${userid}';
	
	var role = 2;//'${userinfo.UM_user_role}';
	
	var h_rl = true;
	var h_gg = true;
	var h_yw = true;
	var h_gj = true;
	var h_tj = true;
	//领导
	if(role=='1'){
		h_rl = true;
		h_gg = false;
		h_yw = false;
		h_gj = false;
		h_tj = false;
	}else if(role=="2"){
		anchor_height = "20%";
		h_rl = false;
		h_gg = false;
		h_yw = false;
		h_gj = false;
		h_tj = true;
	}else if(role=="3"){
		anchor_height = "40%";
		h_rl = false;
		h_gg = true;
		h_yw = false;
		h_gj = true;
		h_tj = true;
	}
	/*排版模拟参数*/
	var data = {20:'早',21:'中',22:'早中'}

	/*导航设置*/
	var navs = [{
		title:"监控平台",
		src:"assets/icons/1_48x48.png",
		padding:'0 20 0 0',
		
		callback:function(){
			/**配置执行Activex名称*/
			try{
				var exeName = 'UniteFramework.Infrastructure.Shell.exe sysadmin 123456 86.12.79.1';
				Execute(exeName);
			}catch(e){
				console.log(e);
			}
			
		}
	},{
		title:"U-OASP后台管理",
		src:"assets/icons/4_48x48.png",
		padding:'0 20 0 0',
		callback:function(){
			/**修改itsm地址*/
			var url = "http://86.12.79.2:9080/cas/login";
			//window.location.href=url+params;
			
			openDialog(url+params);
		}
	}/*,{
		title:"运维配置工具",
		src:"assets/icons/4_48x48.png",
		padding:'0 20 0 0',
		url:'http://www.sina.com'
	},{
		title:"CMDB配置工具",
		src:"assets/icons/3_48x48.png",
		padding:'',
		url:'http://www.sina.com'
	}*/];
	
	/*外调系统参数*/
	var params = "?username="+username+"&userid="+userid;
	
	function openDialog(url){
		window.open (url,'newwindow','height='+ (screen.availHeight-50) +',width='+ (screen.availWidth - 10) +',top=0,left=0,toolbar=no,menubar=no,scrollbars=no, resizable=no,location=no, status=no') 
	}
</script>

<script type="text/javascript" src="<%=basepath %>extjs/bootstrap.js"></script>
<script type="text/javascript" src="<%=basepath %>extjs/locale/ext-lang-zh_CN.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basepath %>resource/HomeApp.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basepath %>resource/init.js" charset="utf-8"></script>
<script type="text/javascript" src="<%=basepath %>resource/util/QualityInterval.js" charset="utf-8"></script>
</head>
<body>
</body>
</html>