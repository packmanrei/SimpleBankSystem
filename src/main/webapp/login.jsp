<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログインページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">ログインIDとパスワードを入力してください</h1>
	<br/>
	<form:form modelAttribute="User" action="/login_p" method="POST">
		<table border="1" class="textTable">
				<tr><td align="center">ログインID<form:errors path="loginId"/></td><th><form:input path="loginId"/></th></tr>
				<tr><td align="center">ログインパスワード<form:errors path="loginPass"/></td><th><form:input path="loginPass"/></th></tr>
		</table>
		<div class="errorMessage"><p>${message }</p></div>
		<p><input type="submit" value="ログイン"/></p>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>