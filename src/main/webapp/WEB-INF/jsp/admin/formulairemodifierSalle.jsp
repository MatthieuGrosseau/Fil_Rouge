<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire modif salle</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division modifier salle-->
		<div id="formulaire_update_salle">

			<form action="${pageContext.request.contextPath }/admin/ModifierSalle" method="POST">
				<input type="hidden" value="${salle.noSalle }" name="noSalle" />
		
				<div>
					<label for="noCinema">Cinema : </label>
					<select name="noCinema" id="noCinema">
							<c:forEach items="${listeCinemas}" var="c">
								<option value="${c.noCinema}" ${c.noCinema == salle.cinema.noCinema ? "selected" : ""}>${c.nom}</option>
							</c:forEach>
					</select>
				</div>
				<div>
					<label for="nomSalle">Nom : </label>
					<input type="text" id="nomSalle" name="nomSalle" value="${salle.nomSalle }" />
				</div>
				<div>
					<label for="capacite">Capacit� : </label>
					<input type="text" id="capacite" name="capacite" value="${salle.capacite }" />
				</div>				
				<input type="submit" value="Enregistrer" />
			</form>
		
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
	
</body>
</html>