<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8" />
		<title>Exemplo 1 - Webmail</title>
	</head>
	<body>				
		<c:choose>
			<c:when test="${not empty candidato}">				
				
				Nome: <c:out value="${candidato.nome}"></c:out>
				<br/>
				CPF: <c:out value="${candidato.cpf}"></c:out>
				<br/>			
				
				<!--
				<a><img  height="42" width="42" alt="${imageFilename}" src="${pageContext.request.contextPath}/acao/${imageFilename}"></a>
				 -->
				<img width="200px" height="auto" alt="Foto de ${candidato.nome}" src="${pageContext.request.contextPath}/${candidato.foto}"/>
				<br/>
				  <a href="${pageContext.request.contextPath}/${candidato.cv}">Download Curriculo do candidato.</a>
				
			</c:when>
			<c:otherwise>
				<p>Não foi encontrado nenhum candidato.</p>
			</c:otherwise>
		</c:choose>
		
				
	</body>
</html>