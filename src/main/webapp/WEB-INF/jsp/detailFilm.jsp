<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Detail Film</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>
	
	<!-- main -->
	<section id="main">

		<!-- division détail film -->
		<div id="detail_film">

			<h1>Détail du Film</h1>	
	
			<p>Nom : ${film.nom }</p>
			<p>Durée : ${film.dureeFilm }</p>
			<p>Description : ${film.description }</p>
			<p>Pegi : ${film.pegi.codePegi }</p>
			<p>Version : ${film.filmVersion.codeVersion }</p>
			<p>Categorie : ${film.categorie.codeCategorie }</p>
			<p>Etat : ${film.etat.codeEtat }</p>
	
		</div>
	
	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
	
</body>
</html>