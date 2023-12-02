<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Atualizar dados do Usuario</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>
	<nav class="navbar bg-dark border-bottom border-body"
		data-bs-theme="dark">
		<div class="container">
			<a class="navbar-brand" href="index.html">Navbar</a> <a
				class="btn btn-outline-secondary me-2" href="CreateAndFind">Lista
				de Usuarios</a>
			<button class="btn btn-outline-secondary" type="button">Cadastrar</button>
			<div>
				<form action="CreateAndFind" method="GET" class="d-flex"
					role="search">
					<input class="form-control me-2" name="pesquisa" type="search"
						placeholder="" aria-label="Search">
					<button class="btn btn-outline-success" type="submit">Buscar</button>
				</form>
			</div>
		</div>
	</nav>

	<div class="container">
		<h2 class="mt-4">Atualizar usuario:</h2>
		<hr>
		<form action="ClienteUpdate" method="POST">
			<input type="hidden" name="id" value="${cliente.id}">
			<div class="mb-3">
				<label for="nome" class="form-label">Nome</label> <input type="text"
					class="form-control" name="nome" id="nome"
					placeholder="digite seu nome:" value="${cliente.nome}">
			</div>
			<div class="mb-3">
				<label for="nascimento" class="form-label">Data de
					Nascimento</label> <input class="form-control" type="date"
					name="dataNascimento" id="nascimento"
					value="${cliente.dataNascimento}"></input>
			</div>
			<div class="mb-3">
				<label for="login" class="form-label">Login</label> <input
					class="form-control" type="text" name="login" id="login"
					value="${cliente.login}">
			</div>
			<div class="mb-3">
				<label for="senha" class="form-label">Senha</label> <input
					class="form-control" type="text" name="senha" id="senha"></input>
			</div>
			<button type="reset" class="btn btn-secondary">Limpar
				formulario</button>
			<button type="submit" class="btn btn-success">Salvar</button>
		</form>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>