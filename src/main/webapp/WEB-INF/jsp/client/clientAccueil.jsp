<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Accueil Client</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division detail compte -->
		<div id="detail_compte">

			<h1>Détail de votre compte</h1>
	
	
			<p>Nom : ${personne.nom }</p>
			<p>Prenom : ${personne.prenom }</p>
			<p>Age : ${personne.age }</p>
			<p>Adresse Mail : ${personne.adresseMail }</p>
			<p>Numero de Telephone : ${personne.numeroTelephone }</p>
			<p>Mot de Passe : ${personne.motDePasse }</p>
			<p>Adresse : ${personne.adresse }</p>
			<p>Code Postal : ${personne.cpo }</p>
			<p>Ville : ${personne.ville }</p>
	
			<form action="${pageContext.request.contextPath }/ModifierClient" method="GET">
				<input type="hidden" value="${personne.noPersonne }" name="id" />
				<input type="submit" value="Modifier le compte" />
			</form>
	
			<form action="${pageContext.request.contextPath }/SupprimerClient" method="POST">
				<input type="hidden" value="${personne.noPersonne }" name="id" />
				<input type="submit" value="Supprimer le compte" />
			</form>
	
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
		
</body>
</html>