<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Inscription</title>
<link rel="stylesheet" href="css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="fragments/headerfragment.jspf" %>
	
	<!-- main -->
	<section id="main">

		<!-- division formulaire inscription -->
		<div id="formulaire_inscription">
		
			<form action="${pageContext.request.contextPath }//Inscription" method="POST">
				<input type="hidden" value="3" name="rolePersonne" />
		
				<div>
					<label for="nom">Nom : </label>
					<input type="text" id="nom" name="nom" placeholder="Ins�rer votre nom" />
				</div>
				<div>
					<label for="prenom">Prenom : </label>
					<input type="text" id="prenom" name="prenom" placeholder="Ins�rer votre prenom" />
				</div>
				<div>
					<label for="age">Age : </label>
					<input type="number" id="age" name="age" placeholder="Ins�rer votre age" />
				</div>
				<div>
					<label for="adresseMail">Adresse Mail : </label>
					<input type="text" id="adresseMail" name="adresseMail" placeholder="Ins�rer votre adresse mail" />
				</div>
				<div>
					<label for="numeroTelephone">Num�ro de T�l�phone : </label>
					<input type="text" id="numeroTelephone" name="numeroTelephone" placeholder="Ins�rer votre num�ro de T�l�phone" />
				</div>
				<div>
					<label for="motDePasse">Mot De Passe : </label>
					<input type="text" id="motDePasse" name="motDePasse" placeholder="Ins�rer votre mot de passe" />
				</div>
				<div>
					<label for="adresse">Adresse : </label>
					<input type="text" id="adresse" name="adresse" placeholder="Ins�rer votre ville" />
				</div>
				<div>
					<label for="cpo">Code Postal : </label>
					<input type="text" id="cpo" name="cpo" placeholder="Ins�rer votre code postal" />
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" id="ville" name="ville" placeholder="Ins�rer votre ville" />
				</div>
				
				<input type="submit" value="Enregistrer" />
			</form>
	
		</div>
	
	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
</body>
</html>