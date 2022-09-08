<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Reservation</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>
	
	<!-- main -->
	<section id="main">

		<!-- division détail seance -->
		<div id="detail_seance">

			<h1>Détail de votre Seance</h1>	
	
			<p>Nom du film : ${maSeance.film.nom }</p>
			<p>Date : ${maSeance.dateSeance }</p>
			<p>Heure : ${maSeance.heureSeance }</p>
			<p>Salle : ${maSeance.salle.nomSalle }</p>
			<p>Cinema : ${maSeance.salle.cinema.nom }</p>
		</div>


		<!-- division formulaire reservation -->
		<div id="formulaire_reservation">
		
			<form action="${pageContext.request.contextPath }/Reservation" method="POST">
				<input type="hidden" value="${maSeance.noSeance }" name="noSeance" />
		
				<div>
					<label for="nbPlaces">Nombre de places : </label>
					<input type="number" id="nbPlaces" name="nbPlaces" placeholder="Combien de places?" />
				</div>
								
				<input type="submit" value="Enregistrer" />
			</form>
	
		</div>
	
	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
</body>
</html>