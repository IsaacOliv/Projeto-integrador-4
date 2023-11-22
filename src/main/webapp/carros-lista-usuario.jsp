<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <title>Document</title>'
    
    <style>
        body{
            background-image: url("https://lumiere-a.akamaihd.net/v1/images/open-uri20150608-27674-1eblt9q_d27f8dc6.jpeg?region=0%2C0%2C1580%2C880");
            background-size: cover;
        }
           
    </style>
    
    
</head>
<body>
    <!-- <div> -->
        <nav class="navbar navbar-expand-lg navbar-light" style="background-color: rgba(255, 255, 255, 0.05);">
            <div class="container-fluid">
              <a class="navbar-brand">Katchau</a>
              <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
              </button>
              <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Voltar</a>
                  </li>
                  <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.html">Voltar tambem mas em outro botao</a>
                  </li>
                </ul>
              </div>
            </div>
            <form class="d-flex me-3">
                <!-- <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"> -->
                <button class="btn btn-outline-success" type="submit">login</button>
              </form>
          </nav>
    <!-- </div> -->

<div class="container">
    <div class="row">
	    <c:forEach items="${Carros}" var="carro">
	    	<div class="col-md-3 mb-2">
	            <div class="card mx-auto" style="width: 18rem;">
	                <img src="..." class="card-img-top" alt="imagem?">
	                <div class="card-body">
	                <h5 class="card-title">${carro.marca}</h5>
	                <p class="card-text">${carro.descricao}</p>
	                <p>${carro.valor}</p>
	                <a href="carroViewFind?carroId=${ carro.id }" class="btn btn-primary">Ver mais</a>
	                </div>
	            </div>
	        </div>		
		</c:forEach>
    </div>
</div>

<!-- Footer -->
<footer class="text-center text-lg-start bg-body-tertiary text-muted fixed-bottom">
    <!-- Copyright -->
    <div class="text-center p-4" style="background-color: rgba(255, 255, 255, 0.05);">

    </div>
    <!-- Copyright -->
  </footer>
  <!-- Footer -->

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</body>
</html>