<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire modif cinema</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division modifier cinema -->
		<div id="formulaire_update_cinema">

			<form action="${pageContext.request.contextPath }/admin/ModifierCinema" method="POST">
				<input type="hidden" value="${cinema.noCinema }" name="noCinema" />
		
				<div>
					<label for="noPersonne">Personne : </label>
					<select name="noPersonne" id="noPersonne">
							<c:forEach items="${listePersonnes}" var="p">
								<option value="${p.noPersonne}" ${p.noPersonne == cinema.personne.noPersonne ? "selected" : ""}>${p.nom}</option>
							</c:forEach>
					</select>
				</div>
				<div>
					<label for="nom">Nom : </label>
					<input type="text" id="nom" name="nom" value="${cinema.nom }" />
				</div>
				<div>
					<label for="telephone">Telephone : </label>
					<input type="text" id="telephone" name="telephone" value="${cinema.numeroTelephone }" />
				</div>
				<div>
					<label for="adresse">Adresse : </label>
					<input type="text" id="adresse" name="adresse" value="${cinema.adresse }" />
				</div>
				<div>
					<label for="cpo">Code Postal : </label>
					<input type="text" id="cpo" name="cpo" value="${cinema.cpo }" />
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" id="ville" name="ville" value="${cinema.ville }" />
				</div>
				<input type="submit" value="Enregistrer" />
			</form>
		
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
	
</body>
</html>