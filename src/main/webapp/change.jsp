<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変更ページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header_user.jsp"></jsp:include>
	<h1 align="center">${message }</h1>
	<br/>
	<form:form modelAttribute="User" action="/change" method="POST">
		<p>
			<form:input path="${type }"/>
			<input type="submit" name="${button }" value="変更する"/>
		</p>
	</form:form>
	<div class="errorMessage"><p>${errorMessage }</p></div>
</body>
</html>