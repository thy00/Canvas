<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>登录</title>
	<link rel="stylesheet" href="../../../style/login.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<div class="login">
		<div class="header">
			<h1>
				<a href="#">登录</a>
			</h1>
			<button></button>
		</div>
		<form action="/login.do" method="post">
			<div class="name">
				<input type="text" id="name" name="username">
				<p></p>
			</div>
			<div class="pwd">
				<input type="password" id="pwd" name="password">
				<p></p>
			</div>
			<div class="btn-red">
				<input type="submit" value="登录" id="login-btn">
			</div>
		</form>
	</div>
</body>
</html>