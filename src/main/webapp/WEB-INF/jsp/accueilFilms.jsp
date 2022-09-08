<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil Films</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division message -->
		<div id="recherche_film">
		
			<h2>Liste des Films </h2>
	
			<form action="${pageContext.request.contextPath }/AccueilFilms" method="post">
				<input type="search" name="critere" />
				<input type="submit" value="Rechercher" />
			</form>
		</div>
		
		<!-- division liste -->
		<div id="liste_cinema">
		
			<c:forEach items="${films }" var="film"> 
				<div id="films">
					<h3>Nom : ${film.nom }</h3>
					<p>Durée : ${film.dureeFilm }</p>
					<p>Pegi : ${film.pegi.codePegi } Version : ${film.filmVersion.codeVersion } Categorie : ${film.categorie.codeCategorie } Etat : ${film.etat.codeEtat }</p>
			
					<form action="${pageContext.request.contextPath }/DetailFilm" method="get">
						<input type="hidden" value="${film.noFilm }" name="id_film" />
						<input type="submit" value="Consulter" />
					</form>
				</div>
			</c:forEach>
		</div>

	</section>
		
	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
</body>
</html>