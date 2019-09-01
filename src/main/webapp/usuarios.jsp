<%@ page contentType="text/html;charset=UTF-8" language="java" %> <%@
taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<body>
	<div>Lista</div>

	<table>
		<tr>
			<th>Nome</th>
			<th>Idade</th>
			<th>Sexo</th>
		</tr>

		<c:forEach var="usuario" items="${Usuarios}">
			<li>${usuario.nome}</li>
			<li>&{usuarios.idade}</li>

		</c:forEach>
	</table>

</body>
</html>