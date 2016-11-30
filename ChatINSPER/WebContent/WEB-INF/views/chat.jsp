<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title>Tela de chat</title>
</head>
<body>
	<div id="m"></div>
	<div class="container">
	<form action="adicionaMensagem" method='post' class="form-inline">
	<textarea name="mensagem" rows="1" cols="80"></textarea>
	<input type="submit" value="Enviar"><br>
	<a href="telaDeMenu">Clique aqui</a> para sair da sala.
	</form>
	</div>
	<script>
	(function worker() {
		  $.ajax({
		    url: 'mensagensJquery', 
		    success: function(data) {
		      $('#m').html(data);
		    },
		    complete: function() {
		      // Schedule the next request when the current one's complete
		      setTimeout(worker, 5000);
		    }
		  });
		})();
	</script>
</body>
</html>