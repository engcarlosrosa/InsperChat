<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">   
<table frame="box" class="table table-hover">
		<tr>
			<th>Data</th>
			<th>Usuario</th>
			<th>Mensagem</th>
			<%System.out.println("vai"); %>
		</tr>
		<c:forEach items="${messages}" var="message" >
		<tr>
			<td>
			<fmt:formatDate value="${message.data.time}" pattern="dd/MM HH:mm:ss"/>
			</td>
			<td>${message.usuario}</td>
			
			<td>${message.mensagem}</td>
		</tr>	
		</c:forEach>
	</table>
	</div>
</body>
</html>