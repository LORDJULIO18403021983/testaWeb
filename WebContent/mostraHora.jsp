<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Exibe Hora pelo JSP</title>
<link rel="stylesheet" href="CSS/estilo.css">
</head>
<body>
	<a href="index.html">Página Principal</a>
	<h1>Hora do Servidor - JSP</h1>
	<%out.println(new java.util.Date()); %>
</body>
</html>