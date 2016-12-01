<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
  <head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<style>
.thumb-dropdown .dropdown-menu > li {
    position: relative;
}
.thumb-dropdown .dropdown-menu > li > a .thumbnail {
    position: absolute; 
    left: 100%;
    top: -10px;
    display: none;    
    width: 350px;
    height: auto;
    margin-left: 5px;
}
.thumb-dropdown .dropdown-menu > li > a:hover .thumbnail  {
    display: block;    
}
.scrollbar {
    width: 431px;
    height: 1000px;
    overflow-y: scroll;
}
</style>
  </head>
                <div class="panel-body">
                <div class="scrollbar">
                    <ul class="chat">
                   
                    
   

                    <c:forEach items="${messages}" var="message" >
                    <c:if test="${userSession == message.usuario}">
                        <li class="left clearfix"><span class="chat-img pull-left">
                            <img src="http://placehold.it/50/55C1E7/fff&amp;text=U" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <strong class="primary-font">${message.usuario}</strong> <small class="pull-right text-muted">
                                        
                                        <span class="glyphicon glyphicon-time"></span><fmt:formatDate value="${message.data.time}" pattern="dd/MM HH:mm:ss"/></small>
                                </div>
                                <p>
                                   ${message.mensagem}</p>
                            </div>
                        </li>
                  
			</c:if>
			<c:if test="${userSession != message.usuario}">
			 <li class="right clearfix"><span class="chat-img pull-right">
                            <img src="http://placehold.it/50/FA6F57/fff&amp;text=ME" alt="User Avatar" class="img-circle">
                        </span>
                            <div class="chat-body clearfix">
                                <div class="header">
                                    <small class=" text-muted"><span class="glyphicon glyphicon-time"></span><fmt:formatDate value="${message.data.time}" pattern="dd/MM HH:mm:ss"/></small>
                                    <strong class="pull-right primary-font">${message.usuario}</strong>
                                </div>
                                <p>${message.mensagem}</p>
                            </div>
                        </li>
			</c:if>
		</c:forEach>
		</ul>
		</div>
	</div>
    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
  </body>
</html>