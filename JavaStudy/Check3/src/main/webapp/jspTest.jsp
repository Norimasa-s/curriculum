<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
 <%@ include file="header.jsp"%>
<!-- name、idの入力エリアを作成しなさい -->
<div class ="name">
<table class="name・idarea">
	<tr>
		<th><label for="name1">name</label></th>
		<th><input type="text" name="namae" id="name1"></th>
	</tr>
	<tr align="left">
	
	<tr>
		<th><label for="id1">id</label></th>
		<th><input type="text" name="id2" id="id1"></th>
	</tr>
	<tr align="left">
</table>
</div>

 <%@ include file="footer.jsp"%>
</body>
</html>