<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Tabuada</title>
<link rel="stylesheet" href="CSS/estilo.css">
</head>
<body>
	<a href="index.html">Página Princioal</a>
	<h1>Tabuada</h1>
	<%
		for (int i = 0; i <= 10; i++) {
	%>
	<%=(i + " x 7 = " + (i * 7) + "<br />")%>
	<%
		}
	%>

</body>
</html>