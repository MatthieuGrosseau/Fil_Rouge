<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil Admin</title>
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

			<fieldset class="Liste des cinemas">
	      	<legend>Liste des cinema</legend>
				<div class="tableau">		              
		   			<table>	                
            			<thead>          	           
            				<tr>         	             
			            		<th>nom</th>
			            		<th>telephone</th>
			            		<th>adresse</th>
			            		<th>code postal</th>
			            		<th>ville</th>
			            		<th>consulter</th>
			            		<th>supprimer</th>
 							</tr>
 						</thead>
 				
            			<tbody>
              				<c:forEach items="${cinemas }" var="currentCinema">
              				<tr>
		              			<td>${currentCinema.nom }</td>
								<td>${currentCinema.numeroTelephone }</td>
								<td>${currentCinema.adresse }</td>
								<td>${currentCinema.cpo }</td>
								<td>${currentCinema.ville }</td>
								<td><form action="${pageContext.request.contextPath }/admin/ModifierCinema" method="get">
										<input type="hidden" value="${currentCinema.noCinema }" name="noCinema_cinema" />
										<input type="submit" name="modif" value="Modifier ce cinema"/>
								</form></td>
								<td><form action="${pageContext.request.contextPath }/admin/SupprimerCinema" method="get">
										<input type="hidden" value="${currentCinema.noCinema }" name="noCinema_cinema" />
		   								<input type="submit" value="Delete" />
								</form></td>

						
                			</tr>
                			</c:forEach>
            			</tbody>
          			</table>
     			</div>
     			
     			<form action="${pageContext.request.contextPath }/admin/AjouterCinema" method="get">
    				<input type="submit" value="Ajouter" />
				</form>
			</fieldset>
	
		</div>

		<!-- division liste salle -->
		<div id="admin_list_salle">

			<fieldset class="Liste des salles">
	      	<legend>Liste des salles</legend>
				<div class="tableau">		              
		   			<table>	                
            			<thead>          	           
            				<tr>         	             
			            		<th>nom Salle</th>
			            		<th>nom Cinema</th>
			            		<th>capacité</th>
			            		<th>consulter</th>
			            		<th>supprimer</th>
 							</tr>
 						</thead>
 				
            			<tbody>
              				<c:forEach items="${salles }" var="currentSalle">
              				<tr>
		              			<td>${currentSalle.nomSalle }</td>
								<td>${currentSalle.cinema.nom }</td>
								<td>${currentSalle.capacite }</td>
								<td><form action="${pageContext.request.contextPath }/admin/ModifierSalle" method="get">
										<input type="hidden" value="${currentSalle.noSalle }" name="noSalle_salle" />
										<input type="submit" name="modif" value="Modifier cette salle"/>
								</form></td>
								<td><form action="${pageContext.request.contextPath }/admin/SupprimerSalle" method="get">
										<input type="hidden" value="${currentSalle.noSalle }" name="noSalle_salle" />
		   								<input type="submit" value="Delete" />
								</form></td>

						
                			</tr>
                			</c:forEach>
            			</tbody>
          			</table>
     			</div>
     			
     			<form action="${pageContext.request.contextPath }/admin/AjouterSalle" method="get">
    				<input type="submit" value="Ajouter" />
				</form>
			</fieldset>
	
		</div>
		
		<!-- division liste seance -->
		<div id="admin_list_seance">

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
			            		<th>consulter</th>
			            		<th>supprimer</th>
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
								<td><form action="${pageContext.request.contextPath }/admin/ModifierSeance" method="get">
										<input type="hidden" value="${currentSeance.noSeance }" name="noSeance_seance" />
										<input type="submit" name="modif" value="Modifier cette seance"/>
								</form></td>
								<td><form action="${pageContext.request.contextPath }/admin/SupprimerSeance" method="get">
										<input type="hidden" value="${currentSeance.noSeance }" name="noSeance_seance" />
		   								<input type="submit" value="Delete" />
								</form></td>

						
                			</tr>
                			</c:forEach>
            			</tbody>
          			</table>
     			</div>
     			
     			<form action="${pageContext.request.contextPath }/admin/AjouterSeance" method="get">
    				<input type="submit" value="Ajouter" />
				</form>
			</fieldset>
	
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
		
</body>
</html>