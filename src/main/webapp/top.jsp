<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TOP</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 style="text-align:center">R銀行へようこそ</h1>
	<br/>
	<p>下記からご用件をお選びください</p>
	<p>
		<a href="login" class="button">ログイン</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="register" class="button">登録</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="contact" class="button">お問い合せ</a>
	</p>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>