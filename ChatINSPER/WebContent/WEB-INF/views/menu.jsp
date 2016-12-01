<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!DOCTYPE html>
<html lang="en">
  <head>
    <!-- Required meta tags always come first -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">

    <!-- Bootstrap CSS -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" href="css/design2.css">
  </head>
  <body>
<nav class="navbar navbar-default" role="navigation">
  <div class="container">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#dropdown-thumbnail-preview">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="telaDeMenu">Seja bem vindo, ${usuarioLogado}!</a>
    </div>

    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="dropdown-thumbnail-preview">
      <ul class="nav navbar-nav">
        <li class="active"><a href="telaChat">Sala de chat</a></li>
        <li class="dropdown thumb-dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Favoritos <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li role="presentation" class="dropdown-header">Online</li>
            <li>
                <a href="#">
                    Usuario A                                
                    <div class="thumbnail">
                        <img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/1.jpg">
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    Usuario B                                
                    <div class="thumbnail">
                        <img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/2.jpg">
                    </div>
                </a>
            </li>
            <li>
                <a href="#">
                    Usuario C                             
                    <div class="thumbnail">
                        <img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/3.jpg">
                    </div>
                </a>
            </li>
            <li class="divider"></li>
            <li role="presentation" class="dropdown-header">Offline</li>
            <li>
                <a href="#">
                    (3/6)                                
                    <div class="thumbnail">
                        <img class="img-responsive" src="http://krowdly.co/snippets/thumbnails/4.jpg">
                        <div class="caption">
                            <p>Usuario D</p>
                            <p>Usuario E</p>
                            <p>Usuario F</p>
                        </div>
                    </div>
                </a>
            </li>
          </ul>
        </li>
      </ul>
      <form class="navbar-form navbar-left" role="search">
        <div class="form-group">
          <input type="text" class="form-control" placeholder="Contato">
        </div>
        <button type="submit" class="btn btn-default">Pesquisar</button>
      </form>
      <ul class="nav navbar-nav navbar-right">

        <li class="dropdown">
          <a href="#" class="dropdown-toggle" data-toggle="dropdown">Sistema <span class="caret"></span></a>
          <ul class="dropdown-menu" role="menu">
            <li><a href="#">Editar Perfil</a></li>
            <li><a href="#">Criar Novo Usuario</a></li>
            <li><a href="#">Historico</a></li>
            <li class="divider"></li>
            <li><a href="logout">Sair do sistema</a></li>
          </ul>
        </li>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>

    <p></p>
    <img src="getImage?login=${usuarioLogado}" /><br>
    
    <!-- jQuery first, then Tether, then Bootstrap JS. -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js" integrity="sha384-3ceskX3iaEnIogmQchP8opvBy3Mi7Ce34nWjpBIwVTHfGYWQS9jwHDVRnpKKHJg7" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/tether/1.3.7/js/tether.min.js" integrity="sha384-XTs3FgkjiBgo8qjEjBk0tGmf3wPrWtA6coPfQDfFEY8AnYJwjalXCiosYRBIBZX8" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-alpha.5/js/bootstrap.min.js" integrity="sha384-BLiI7JTZm+JWlgKa0M0kGRpJbF2J8q+qreVrKBC47e3K6BW78kGLrCkeRX6I9RoK" crossorigin="anonymous"></script>
  </body>
</html>