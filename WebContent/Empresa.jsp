<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="model.Empresa"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="css/bootstrap.css" rel="stylesheet">
<link href="css/bootstrap-theme.css" rel="stylesheet">
<title>empresa</title>
</head>
<body>
	<div class="container">
	<div class="jumbotron">
		<div class="panel panel-success">
			<%
				Empresa empresa = (Empresa) request.getAttribute("empresa");
			%>
			<div class="panel-heading">
				Id:${empresa.id }]</div>
			<div class="panel-body">
				Nome:${empresa.nome }<br> 
				cnpj:${empresa.cnpj }<br> 
				Conjunto:${empresa.conjunto }<br>
				
			</div>
		</div>
		</div>
	</div>
</body>
</html>