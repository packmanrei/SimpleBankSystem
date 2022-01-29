<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メインページ</title>
<link rel="stylesheet" type="text/css" href="resources/style.css">
</head>
<body>
	<div class="r"><h1>R銀行</h1></div>
	<h2>ようこそ&nbsp;<font color="#696969">${User.name }</font>&nbsp;様</h2>
	<hr/>
	<br/><br/><br/>
	<h2 align="center">ご希望の用件を選択してください</h2>
	<br/>
	<p>
		<a href="deposit" class="button">預け入れ</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="withdraw" class="button">引き出し</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="transfer" class="button">送金</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<br/><br/>
		<a href="customer" class="button">お客様情報の確認・変更</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<a href="logout" class="button">ログアウト</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	</p>
	<br/>
	<h3 align="center"><font color="#ff7f50">${message }</font></h3>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>