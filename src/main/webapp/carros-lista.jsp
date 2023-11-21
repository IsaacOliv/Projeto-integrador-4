<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
	  <div class="container-fluid">
	    <a class="navbar-brand" href="#">Navbar</a>
	    <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	      <span class="navbar-toggler-icon"></span>
	    </button>
	    <div class="collapse navbar-collapse" id="navbarSupportedContent">
	      <ul class="navbar-nav me-auto mb-2 mb-lg-0">
	        <li class="nav-item">
	          <a class="nav-link active" aria-current="page" href="index-carros.html">Home</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" href="CarroCreateAndFind">Lista de Carros</a>
	        </li>
	        
	      </ul>
	      <form action="CarroCreateAndFind" method="GET" class="d-flex">
	        <input name="pesquisa" class="form-control me-2" type="search" placeholder="Digite a marca ou modelo" aria-label="Search">
	        <button class="btn btn-outline-success" type="submit">Buscar</button>
	      </form>
	    </div>
	  </div>
	</nav>

<div class="container mt-4" >
		<div class="row">
			<div class="col-md-7">
				<hr>
				<h3>Carros cadastrados</h3>
				<hr>
				<table class="table">
				  <thead>
				    <tr>
				      <th scope="col">#</th>
				      <th scope="col">Marca</th>
				      <th scope="col">Modelo</th>
				      <th scope="col">Ano de fabricacao</th>
				      <th scope="col">Ano do modelo</th>
				      <th scope="col">Valor</th>
				      <th scope="col">Descricao</th>
				      <th scope="col">Ações</th>
				      
				    </tr>
				  </thead>
				  <tbody>
					  <c:forEach items="${Carros}" var="carro">
					    <tr>
					      <th scope="col">${carro.id}</th>
					      <td>${carro.marca}</td>
					      <td>${carro.modelo}</td>
					      <td>${carro.anoFabricacao}</td>
					      <td>${carro.anoModelo}</td>
					      <td>${carro.valor}</td>
					      <td>${carro.descricao}</td>
					      <td>
						      <div class="row">
						      	<a class="btn btn-danger" href="CarroDelete?carroId=${ carro.id }">Deletar</a>
						      	<a class="btn btn-primary mt-2" href="CarroUpdate?carroId=${ carro.id }">Editar</a>
						      </div>					 
					      </td>
					    </tr>
					   </c:forEach>
				  </tbody>
				</table>
				</div>
		</div>	
		</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>