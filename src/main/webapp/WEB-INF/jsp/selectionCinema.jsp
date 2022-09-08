<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Selection Cinema</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>
	
	<!-- main -->
	<section id="main">

		<!-- division recherche par cinéma -->
		<div id="recherche_cinema">
	

			<h2>Liste des Films pour votre Cinema </h2>
	
			<form action="${pageContext.request.contextPath }/SelectionCinema" method="post">
					<label for="noCinema">Cinema : </label>
					<select name="noCinema" id="noCinema">
						<c:forEach items="${cinemas}" var="c">
							<option value="${c.noCinema}" ${c.noCinema == salle.cinema.noCinema ? "selected" : ""}>${c.nom}</option>
						</c:forEach>
					</select>
				<input type="submit" value="Rechercher" />
			</form>
	
		</div>
		
		<!-- division liste seance -->
		<div id="cinema_list_seance">

			<fieldset class="Liste des seances">
	      	<legend>Liste des seances</legend>
				<div class="tableau">		              
		   			<table>	                
            			<thead>          	           
            				<tr>         	             
			            		<th>date</th>
			            		<th>heure</th>
			            		<th>film</th>
			            		<th>salle</th>
			            		<th>cinema</th>
			            		<th>réserver</th>
 							</tr>
 						</thead>
 				
            			<tbody>
              				<c:forEach items="${seances }" var="currentSeance">
              				<tr>
		              			<td>${currentSeance.dateSeance }</td>
								<td>${currentSeance.heureSeance }</td>
								<td>${currentSeance.film.nom }</td>
								<td>${currentSeance.salle.nomSalle }</td>
								<td>${currentSeance.salle.cinema.nom }</td>
								<td><form action="${pageContext.request.contextPath }/Reservation" method="get">
										<input type="hidden" value="${currentSeance.noSeance }" name="noSeance_seance" />
										<input type="submit" name="reservation" value="Reserver cette seance"/>
								</form></td>


						
                			</tr>
                			</c:forEach>
            			</tbody>
          			</table>
     			</div>
			</fieldset>
	
		</div>
	
		<c:forEach var="entry" items="${map}">
   			Film numéro ${entry.key.noFilm}<br>
   				<c:forEach var="info" items="${entry.value}">
       				Seance à la date du ${info.dateSeance}<br>
  				 </c:forEach>
		</c:forEach>
	
	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
</body>
</html>