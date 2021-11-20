<!-- JSPはWebサーバ上で動くJavaのプログラム。HTMLとJavaが合体したもの-->
<!-- JavaのファイルをHTMLで出力するためにJSPを使う -->
<!-- ↓ディグレクティブ ページの表示に関する設定をしている。-->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- languageはJSPで使用する言語の指定。-->
<!-- contentTypeはJSPページのデータ型、文字コードの指定。-->
<!-- pageEncodingはJSPページの文字コードの指定。-->


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- CSSとリンクをしている -->
<link rel="stylesheet" href="css/style.css">
<title>Insert title here</title>
</head>
<body>
<!-- <↓includeディレクティブはJSPファイルから他のJSPファイルを読み込む> -->
<!-- この場合はheader.jspファイルを読み込んでいる -->
 <%@ include file="header.jsp"%>
<!-- name、idの入力エリアを作成しなさい -->
<div class ="name">
<!-- テーブルタグで表を作っている -->
<table class="name・idarea">
<!-- <tr>が行で、<th>が項目-->
	<tr>
<!-- フォームの中でフォーム内と構成している物を紐づけているためのタグ -->
		<th><label for="name1">name</label></th>
		<th><input type="text" name="namae" id="name1"></th>
	</tr>
	
	<tr>
		<th><label for="id1">id</label></th>
		<th><input type="text" name="id2" id="id1"></th>
	</tr>
	
</table>
</div>
 <%@ include file="footer.jsp"%>
 <!-- footer.jspファイルを読み込んでいる -->
</body>
</html>