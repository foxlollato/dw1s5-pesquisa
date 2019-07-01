<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8" />
		<title>Administrador</title>
	</head>
	<body>
		<p>Administrador</p>
		<c:out value="${usuario.nome}"></c:out>
		<br/>
		<form action="${pageContext.request.contextPath}/acao/exibeCandidato" method="post">			
			
			<label for="cpf">
				CPF do Candidato:
			</label>
			<input type="text" name="cpf" id="cpf" required="required" />
					
			<input type="submit" name="botao" value="Buscar" />
		</form>		
		<br/>	
		<a href="logout">Sair da aplicação</a>
</html>