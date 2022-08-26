<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
	<title>Guardar Escuela</title>

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css">

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/agregar-escuela-estilo.css">
</head>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Escuelas del pais</h2>
		</div>
	</div>

	<div id="container">
		<h3>Guardar Escuela</h3>
	
		<form:form action="guardarEscuela" modelAttribute="escuela" method="POST">

			<!-- necesita asociar estos datos con la identificación de la escuela-->
			<form:hidden path="id" />
					
			<table>
				<tbody>
					<tr>
						<td><label>Nombre:</label></td>
						<td><form:input path="nombre" /></td>
					</tr>
				
					<tr>
						<td><label>Tipo de escuela:</label></td>
						<td><form:input path="tescuela" /></td>
					</tr>

					<tr>
						<td><label>Correo:</label></td>
						<td><form:input path="correo" /></td>
					</tr>

					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Guardar" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>
	
		<div style="clear; both;"></div>
		
		<p>
			<a href="${pageContext.request.contextPath}/escuela/list">Regresar a la lista</a>
		</p>
	
	</div>

</body>

</html>










