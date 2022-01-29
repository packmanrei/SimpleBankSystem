<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>送金ページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header_user.jsp"></jsp:include>
	<br/>
	<h2 align="center">送り先の情報を入力してください</h2>
	<form:form modelAttribute="Transfer" action="/transfer_p" method="POST">
		<table border="1" class="textTable">
			
			<tr>
				<td align="center">電話番号</td>
				<th><form:input path="phone"/></th>
			</tr>
			<tr>
				<td align="center">ログインID</td>
				<th><form:input path="loginId"/></th>
			</tr>
			<tr>
				<td align="center">金額</td>
				<th><form:input path="amount"/></th>
			</tr>
		</table>
		<div class="errorMessage"><p>${errorMessage }</p></div>
		<p><input type="submit" value="確定"/></p>
	</form:form>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>