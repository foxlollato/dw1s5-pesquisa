<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="pt-BR">
	<head>
		<meta charset="UTF-8" />
		<title>Cadastro de Curriculo</title>
	</head>
	<body>
		<form action="${pageContext.request.contextPath}/acao/cadastrar" method="post" enctype="multipart/form-data">
			<label for="nome">
				Nome:
			</label>
			<input type="text" name="nome" id="nome" required="required" />
			
			<label for="cpf">
				CPF:
			</label>
			<input type="text" name="cpf" id="cpf" required="required" />
			<br/>
			<label for="foto">
				Anexar Foto:
			</label>
			<input type="file" accept="image/*" name="foto" id="foto" />
			<br/>
			<label for="cv">
				Anexar Curriculo:
			</label>
			<input type="file" accept=".pdf" name="cv" id="cv" />   				
			<br/>			
			<input type="submit" name="botao" value="Cadastrar" />
		</form>		
	</body>
</html>