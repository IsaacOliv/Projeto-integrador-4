<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listagem de usuarios</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" 
integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-dark border-bottom border-body" data-bs-theme="dark">
		<div class="container">
    		<a class="navbar-brand" href="index.html">Navbar</a>
    		<a href="CreateAndFind" class="btn btn-outline-secondary me-2" type="button">Lista de Usuarios</a>
    		<a href="index.html" class="btn btn-outline-secondary" type="button">Cadastrar</a>
  		<div>
    	<form action="CreateAndFind" method="GET" class="d-flex" role="search">
      		<input class="form-control me-2" name="pesquisa" type="search" placeholder="" aria-label="Search">
      		<button class="btn btn-outline-success" type="submit">Buscar</button>
    	</form>
  		</div>
    	</div>
	</nav>
	
	<div class="container">
		<h2 class="mt-4">Usuarios cadastrados</h2>
		<hr>
		<table class="table table-dark table-striped">
		  <thead>
		    <tr>
		      <th scope="col">#</th>
		      <th scope="col">Nome</th>
		      <th scope="col">Data de Nascimento</th>
		      <th scope="col">Ativo</th>
		      <th></th>
		    </tr>
		  </thead>
		  <tbody>
		    <c:forEach items="${clientes}" var="cliente">
		      <tr>
		        <th scope="row">${cliente.id}</th>
		        <td>${cliente.nome}</td>
		        <td>${cliente.dataNascimento}</td>
		        <td>${cliente.ativo}</td>
		        <td>
		          <div class="btn-group" role="group" aria-label="Basic mixed styles example">
		            <a href="ClienteUpdate?clienteId=${cliente.id}" class="btn btn-warning">Editar</a>
		            <a href="ClienteDestroy?clienteId=${cliente.id}" type="button" class="btn btn-danger">Excluir</a>
		          </div>
		        </td>
		      </tr>
		
		    </c:forEach>  
		    </tbody>
		</table>
		
	</div>
	<!-- cdn js bootstrap --> 
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" 
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>