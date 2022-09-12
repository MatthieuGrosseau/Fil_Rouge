<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire modif personne</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division modifier personne -->
		<div id="formulaire_update_personne">

			<form action="${pageContext.request.contextPath }/admin/ModifierPersonne" method="POST">
				<input type="hidden" value="${personne.noPersonne }" name="noPersonne" />
		

				<div>
					<label for="nom">Nom : </label>
					<input type="text" id="nom" name="nom" value="${personne.nom }" />
				</div>
				<div>
					<label for="prenom">Prenom : </label>
					<input type="text" id="prenom" name="prenom" value="${personne.prenom }" />
				</div>
				<div>
					<label for="age">Age : </label>
					<input type="number" id="age" name="age" value="${personne.age }" />
				</div>
				<div>
					<label for="adresseMail">Adresse Mail : </label>
					<input type="text" id="adresseMail" name="adresseMail" value="${personne.adresseMail }" />
				</div>
				<div>
					<label for="numeroTelephone">Numéro de Téléphone : </label>
					<input type="text" id="numeroTelephone" name="numeroTelephone" value="${personne.numeroTelephone }" />
				</div>
				<div>
					<label for="motDePasse">Mot De Passe : </label>
					<input type="text" id="motDePasse" name="motDePasse" value="${personne.motDePasse }" />
				</div>
				<div>
					<label for="adresse">Adresse : </label>
					<input type="text" id="adresse" name="adresse" value="${personne.adresse }" />
				</div>
				<div>
					<label for="cpo">Code Postal : </label>
					<input type="text" id="cpo" name="cpo" value="${personne.cpo }" />
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" id="ville" name="ville" value="${personne.ville }" />
				</div>
				<input type="submit" value="Enregistrer" />
			</form>
		
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
	
</body>
</html>