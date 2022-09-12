<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil Gerant</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division message -->
		<div id="message">

			<p>${message }</p>
			
		</div>	
		
		<!-- division liste cinema -->
		<div id="admin_list_cinema">

			<c:forEach var="entry" items="${mapCinemas}">
   			Numero Personne ${entry.key.noPersonne}<br>
   				<c:forEach var="info" items="${entry.value}">
       				Cinema ${info.nom}<br>
  				 </c:forEach>
		</c:forEach>
  	
		</div>

		<!-- division liste salle -->
		<div id="admin_list_salle">

			<c:forEach var="entry" items="${mapSalles}">
   			Numero Cine ${entry.key.noCinema}<br>
   				<c:forEach var="info" items="${entry.value}">
       				Salle ${info.nomSalle}
       				<form action="${pageContext.request.contextPath }/gerant/ModifierSalle" method="get">
							<input type="hidden" value="${info.noSalle }" name="noSalle_salle" />
							<input type="submit" name="modif" value="Modifier cette salle"/>
					</form>
					<form action="${pageContext.request.contextPath }/gerant/SupprimerSalle" method="get">
							<input type="hidden" value="${info.noSalle }" name="noSalle_salle" />
		   					<input type="submit" value="Delete" />
					</form>
       				
       				<br>
  				 </c:forEach>
		</c:forEach>
     			
     			<form action="${pageContext.request.contextPath }/gerant/AjouterSalle" method="get">
    				<input type="submit" value="Ajouter" />
				</form>
	
		</div>
		
		<!-- division liste seance -->
		<div id="admin_list_seance">

			<c:forEach var="entry" items="${mapSeances}">
   			Numero Salle ${entry.key.noSalle}<br>
   				<c:forEach var="info" items="${entry.value}">
       				Seance à la date du ${info.dateSeance}
       				<form action="${pageContext.request.contextPath }/gerant/ModifierSeance" method="get">
							<input type="hidden" value="${info.noSeance }" name="noSeance_seance" />
							<input type="submit" name="modif" value="Modifier cette seance"/>
					</form>
					<form action="${pageContext.request.contextPath }/gerant/SupprimerSeance" method="get">
							<input type="hidden" value="${info.noSeance }" name="noSeance_seance" />
		   					<input type="submit" value="Delete" />
					</form>
       				
       				<br>
  				 </c:forEach>
		</c:forEach>
     			
     			<form action="${pageContext.request.contextPath }/gerant/AjouterSeance" method="get">
    				<input type="submit" value="Ajouter" />
				</form>
	
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
		
</body>
</html>