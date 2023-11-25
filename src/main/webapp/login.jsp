<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container" style="margin-top: 6em">
		<h3 class="text-center mb-2">Login</h3>
		<% if (request.getParameter("error") != null) { %>
        <p class="col-md-6 offset-3" style="color: red;">Credenciais invalidas. Tente novamente.</p>
    	<% } %>
    	<form action="loginServelet" method="get">
    	
    	<div class="row">
			<div class="col-md-6 offset-3">
				<div class="form-floating mb-3">
  					<input type="text" class="form-control" id="login" name="login" placeholder="usuario">
  					<label for="floatingInput">usuario</label>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 offset-3">
				<div class="form-floating">
  					<input type="text" class="form-control" id="senha" name="senha" placeholder="senha">
  					<label for="floatingPassword">senha</label>
				</div>
			</div>
		</div>
		
		<div class="row">
			<div class="col-md-6 offset-3 text-center mt-3">
				<button class="btn btn-success" type="submit">Entrar</button>
			</div>
		</div>
		
    	</form>
		<div class="row">
			<div class="col-md-6 offset-3 text-center mt-3">
				<a href="index.html">Cadastre-se</a>
			</div>
		</div>
	</div>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>