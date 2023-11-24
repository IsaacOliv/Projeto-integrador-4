<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Atualizar carro</title>
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

<div class="container mt-4">
		<div class="row">
			<div class="col-md-7">
				<hr>
				<h3>Update de carros</h3>
				<hr>
				<form action="CarroUpdate" method="POST">
				<input type="hidden" name="id" value="${ carro.id }">
				  <div class="mb-2">
				    <label for="exampleInputEmail1"class="form-label">Marca</label>
				    <input value="${carro.marca }" type="text" class="form-control" name="marca"  id="exampleInputEmail1" aria-describedby="emailHelp" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1" class="form-label">Modelo</label>
				    <input value="${carro.modelo }" type="text" class="form-control" name="modelo"  id="exampleInputPassword1" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Ano de fabricaçäo</label>
				    <input value="${carro.anoFabricacao }" type="number" maxlength="4" class="form-control" name="anoFabricacao" id="exampleInputPassword1" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Ano do modelo</label>
				    <input value="${carro.anoModelo }" type="number" maxlength="4" class="form-control" name="anoModelo" id="exampleInputPassword1" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Valor</label>
				    <input value="${carro.valor }" type="number" class="form-control" name="valor" id="exampleInputPassword1" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Descriçäo</label>
				    <input value="${carro.descricao }" type="text" class="form-control" name="descricao" id="exampleInputPassword1" disabled>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Link da nova imagem</label>
				    <input type="text" value="${carro.fotoCarro }" class="form-control" name="fotoCarro" id="exampleInputPassword1" disabled>
				  </div>
				   <div class="mb-2">
				    <a href="${carro.fotoCarro }" target="_blank">Imagem antiga</a>
				  </div>
				  <div class="mb-2">
				    <label for="exampleInputPassword1"  class="form-label">Interesse</label>
				    
				    
				    <select class="form-control" name="interesse">
				    	 <c:choose>
					        <c:when test="${carro.interesse == 0}">
					            <option value="0" selected>False</option>
					            <option value="1">True</option>
					        </c:when>
					        <c:when test="${carro.interesse == 1}">
					            <option value="0">False</option>
					            <option value="1" selected>True</option>
					        </c:when>
					    </c:choose>
					</select>
				  </div>
					<div class="mt-3">
							
					  <button type="submit" class="btn btn-success">Atualizar Carro</button>
					  
					  <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#modal-interesse">
					    Ver cliente interessado 
					  </button>
					  
					</div>
				</form>
			</div>		
		</div>
	</div>
	
	
	
	
	
	
	


<!-- Modal -->
  <div class="modal fade" id="modal-interesse" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">Cliente interessado</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">
        <c:forEach var="interesseCliente" items="${carro.interessesClientes}">
                    <div class="mb-3">
	            <label for="exampleFormControlInput1" class="form-label">Nome</label>
	            <input class="form-control" id="exampleFormControlInput1" value="${interesseCliente.nomeCliente}" name="nomeCliente" disabled>
	          </div>
	          <div class="mb-3">
	            <label for="exampleFormControlInput1" class="form-label">Telefone</label>
	            <input class="form-control" id="exampleFormControlInput1" name="telefoneCliente" value="${interesseCliente.telefoneCliente}" disabled>
	          </div>
         </c:forEach>
          
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Fechar</button>
        </div>
      </div>
    </div>
  </div>
	
	
	
	
	
	
	
	
	
	
	
	
	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>