<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>お問合せページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<h1 align="center">メールアドレスとお問い合わせ内容を入力してください</h1>
	<br/>
	<form:form modelAttribute="Contact" action="/contact_p" method="POST">
		<table border="1" class="textTable">
			<tr>
				<td align="center">メールアドレス</td>
				<th><form:input path="email"/></th>
			</tr>
			<tr>
				<td align="center">お問合せ内容</td>
				<th><form:textarea path="message"/>
			</tr>
		</table>
		<div class="errorMessage"><p>${message }</p></div>
		<p><input type="submit" value="送信"/></p>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>