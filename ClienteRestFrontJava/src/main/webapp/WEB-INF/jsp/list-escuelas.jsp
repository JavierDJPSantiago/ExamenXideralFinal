<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Lista de Escuelas</title>
	
	<!-- referencia a nuestra hoja de estilo -->

	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/css/style.css" />

</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>Escuelas del pais</h2>
		</div>
	</div>
	
	<div id="container">
	
		<div id="content">
		
			<!-- poner nuevo boton: Agregar Escuela -->
		
			<input type="button" value="Agregar Escuela"
				   onclick="window.location.href='mostrarFormularioParaAgregar'; return false;"
				   class="add-button"
			/>
		
			<!-- agregar nuestra tabla html aquí -->
		
			<table>
				<tr>
					<th>Nombre</th>
					<th>Tipo de escuela</th>
					<th>Correo</th>
					<th>Actualizar</th>
				</tr>
				
				<!-- recorrer e imprimir nuestras escuelas -->
				<c:forEach var="tempEscuela" items="${escuelas}">
				
					<!-- construya un enlace de "actualización" con la identificación de las escuelas -->
					<c:url var="updateLink" value="/escuela/mostrarFormularioParaActualizar">
						<c:param name="escuelaId" value="${tempEscuela.id}" />
					</c:url>					

					<!-- construya un enlace "eliminar" con la identificación de las escuelas -->
					<c:url var="deleteLink" value="/escuela/borrarEscuela">
						<c:param name="escuelaId" value="${tempEscuela.id}" />
					</c:url>					
					
					<tr>
						<td> ${tempEscuela.nombre} </td>
						<td> ${tempEscuela.tescuela} </td>
						<td> ${tempEscuela.correo} </td>
						
						<td>
							<!-- mostrar el enlace de actualización -->
							<a href="${updateLink}">Actualizar</a>
							|
							<a href="${deleteLink}"
							   onclick="if (!(confirm('¿Quieres eliminar esta Escuela?'))) return false">Borrar</a>
						</td>
						
					</tr>
				
				</c:forEach>
						
			</table>
				
		</div>
	
	</div>
	

</body>

</html>









