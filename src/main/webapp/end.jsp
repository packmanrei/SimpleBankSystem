<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>最終ページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<p><h1 align="center">${message }</h1></p>
	<p>
		<br/>
		<a href="/" class="headerLink">トップページに戻る</a>
	</p>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>