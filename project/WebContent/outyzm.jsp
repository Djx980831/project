<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>验证码</title>
<script language="javascript">
	function myReload() {
		document.getElementById("CreateCheckCode").src = document
				.getElementById("CreateCheckCode").src
				+ "?nocache=" + new Date().getTime();
	}
</script>
</head>

<body>
	<form action="Check.jsp" method="post">
		<input name="checkCode" type="text" id="checkCode" title="验证码区分大小写"
			size="8" ,maxlength="4" />
		<img src="PictureCheckCode" id="CreateCheckCode" align="middle"> 
		<a href="" onclick="myReload()">换一个</a> 
	</form>
</body>
</html>
