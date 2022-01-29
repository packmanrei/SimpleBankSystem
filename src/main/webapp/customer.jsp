<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お客様情報確認・変更ページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header_user.jsp"></jsp:include>
	<h2 align="center">お客様情報</h2>
	<form:form modelAttribute="User" action="/customer_p" mthod="POST">
		<table border="1" class="textTable">
			<tr>
				<td align= "center">お名前</td>
				<th align="center">${User.name }</th>
				<th><input type="submit" name="changeName" value="変更"/></th>
			</tr>
			<tr>
				<td align= "center">電話番号</td>
				<th align="center">${User.phone }</th>
				<th><input type="submit" name="changePhone" value="変更"/></th>
			</tr>
			<tr>
				<td align= "center">メールアドレス</td>
				<th align="center">${User.email }</th>
				<th><input type="submit" name="changeEmail" value="変更"/></th>
			</tr>
			<tr>
				<td align= "center">ログインID</td>
				<th align="center">${User.loginId }</th>
				<th><input type="submit" name="changeLoginId" value="変更"/></th>
			</tr>
			<tr>
				<td align= "center">ログインパスワード</td>
				<th align="center">${User.loginPass }</th>
				<th><input type="submit" name="changeLoginPass" value="変更"/></th>
			</tr>
		</table>
		<p>
			<input type="submit" name="done" value="確認"/>
		</p>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>