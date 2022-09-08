<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire modif seance</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division modifier seance-->
		<div id="formulaire_update_seance">

			<form action="${pageContext.request.contextPath }/gerant/ModifierSeance" method="POST">
				<input type="hidden" value="${seance.noSeance }" name="noSeance" />
		
				<div>
					<label for="noSalle">Salle : </label>
					<select name="noSalle" id="noSalle">
							<c:forEach items="${listeSalles}" var="sa">
								<option value="${sa.noSalle}" ${sa.noSalle == seance.salle.noSalle ? "selected" : ""}>${sa.nomSalle}</option>
							</c:forEach>
					</select>
				</div>
				<div>
					<label for="noFilm">Film : </label>
					<select name="noFilm" id="noFilm">
							<c:forEach items="${listeFilms}" var="f">
								<option value="${f.noFilm}" ${f.noFilm == seance.film.noFilm ? "selected" : ""}>${f.nom}</option>
							</c:forEach>
					</select>
				</div>
				<div>
					<label for="dateSeance">Date : </label>
					<input type="date" id="dateSeance" name="dateSeance" value="${seance.dateSeance }" />
				</div>
				<div>
					<label for="heureSeance">Heure : </label>
					<input type="time" id="heureSeance" name="heureSeance" value="${seance.heureSeance }" />
				</div>				
				<input type="submit" value="Enregistrer" />
			</form>
		
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
	
</body>
</html>