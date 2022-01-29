<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登録ページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">お客様情報を入力してください</h1>
	<form:form modelAttribute="User" action="/register_p" method="POST">
		<table border="1" class="textTable">
			<tr>
				<td align="center">お名前</td>
				<th><form:input path="name"/></th>
			</tr>
			<tr>
				<td align="center">電話番号</td>
				<th><form:input path="phone"/></th>
			</tr>
			<tr>
				<td align="center">メールアドレス</td>
				<th><form:input path="email"/></th>
			</tr>
			<tr>
				<td align="center">ログインID</td>
				<th><form:input path="loginId"/></th>
			</tr>
			<tr>
				<td align="center">ログインパスワード</td>
				<th><form:input path="loginPass"/>
			</tr>
		</table>
		<div class="errorMessage"><p>${message }</p></div>
		<p><input type="submit" value="登録"/></p>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>