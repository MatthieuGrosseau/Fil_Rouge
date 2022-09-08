<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division message -->
		<div id="message">
	
			<p>${message }</p>
	
		</div>

		<!-- division recherche -->
		<div id="recherche_cinema">

			<h2>Liste des Cinemas </h2>
	
			<form action="${pageContext.request.contextPath }/Accueil" method="post">
				<input type="search" name="critere" placeholder="rechercher par Ville" />
				<input type="submit" value="Rechercher" />
			</form>
	
		</div>
		
		<!-- division liste -->
		<div id="liste_cinema">
	
			<c:forEach items="${cinemas }" var="cinema"> 
				<div id="cinemas">
					<div id="cinema_infos">
						<h3>${cinema.nom }</h3>
						<p>${cinema.numeroTelephone }</p>
						<p>${cinema.adresse } ${cinema.cpo } ${cinema.ville }</p>
						
					<form action="${pageContext.request.contextPath }/SelectionCinema" method="post">
						<input type="hidden" value="${cinema.noCinema }" name="noCinema" />
						<input type="submit" value="Consulter" />
					</form>
					</div>
			 		<div id="cinema_id">
            			<img
              	 			src="images/Projecteur.jpg"
               				alt="Projecteur cinema"
               				height="50px"
            			/>
            		</div>
				</div>			
			</c:forEach>
		</div>

	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
</body>
</html>