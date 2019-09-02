<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Cadastrar usuários</title>
</head>

<body>
	<div>
		<a href="cadastrar.jsp">Adicionar usuário</a>
		<a href="list">Ver Lista de usuários</a>
	</div>
	<div>
		<c:if test="${user != null}">
			<form action="update" method="post">
		</c:if>
		<c:if test="${user == null}">
			<form action="insert" method="post">
		</c:if>
		<table cellpadding="5">
			<h2>Adicionar novo Usuário</h2>
			<tr>
				<th>Nome:</th>
				<td><input type="text" name="nome" size="45" value="<c:out value='${user.name}' />" /></td>
			</tr>
			<tr>
				<th>Idade:</th>
				<td><input type="text" name="idade" size="2" value="<c:out value='${user.idade}' />" /></td>
			</tr>

			<tr>
				<th>Email:</th>
				<td><input type="email" name="email" size="45" value="<c:out value='${user.email}' />" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Save" /></td>
			</tr>
		</table>
		</form>
	</div>
</body>

</html>