<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>預け入れページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header_user.jsp"></jsp:include>
	<br/>
	<h2 align="center">金額を入力してください</h2>
	<br/>
	<form:form modelAttribute="userInput" action="/deposit_p" method="POST">
	<p>
		<form:input path="inputNum"/>
		<input type="submit" value="確定"/>
	</p>
	</form:form>
	<h3 align="center"><font color="#ff7f50">${message }</font></h3>
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>