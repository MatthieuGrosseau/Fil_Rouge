<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Formulaire Add personne</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/main.css" />
</head>
<body>
	<!-- header -->
	<%@ include file="../fragments/headerfragment.jspf" %>

	<!-- main -->
	<section id="main">

		<!-- division formulaire add -->
		<div id="formulaire_add_personne">

			<form action="${pageContext.request.contextPath }/admin/AjouterPersonne" method="POST">
							
				<div>
					<label for="rolePersonne"> Role Personne : </label>
					<select name="rolePersonne" id="rolePersonne">
							<option value="1">Admin</option>
							<option value="2">Gerant</option>
							<option value="3">Client</option>
					</select>
				</div>
				<div>
					<label for="nom">Nom : </label>
					<input type="text" id="nom" name="nom" placeholder="Insérer votre nom" />
				</div>
				<div>
					<label for="prenom">Prenom : </label>
					<input type="text" id="prenom" name="prenom" placeholder="Insérer votre prenom" />
				</div>
				<div>
					<label for="age">Age : </label>
					<input type="number" id="age" name="age" placeholder="Insérer votre age" />
				</div>
				<div>
					<label for="adresseMail">Adresse Mail : </label>
					<input type="text" id="adresseMail" name="adresseMail" placeholder="Insérer votre adresse mail" />
				</div>
				<div>
					<label for="numeroTelephone">Numéro de Téléphone : </label>
					<input type="text" id="numeroTelephone" name="numeroTelephone" placeholder="Insérer votre numéro de Téléphone" />
				</div>
				<div>
					<label for="motDePasse">Mot De Passe : </label>
					<input type="text" id="motDePasse" name="motDePasse" placeholder="Insérer votre mot de passe" />
				</div>
				<div>
					<label for="adresse">Adresse : </label>
					<input type="text" id="adresse" name="adresse" placeholder="Insérer votre ville" />
				</div>
				<div>
					<label for="cpo">Code Postal : </label>
					<input type="text" id="cpo" name="cpo" placeholder="Insérer votre code postal" />
				</div>
				<div>
					<label for="ville">Ville : </label>
					<input type="text" id="ville" name="ville" placeholder="Insérer votre ville" />
				</div>
				<input type="submit" value="Enregistrer" />
			</form>
		
		</div>

	</section>

	<!-- footer -->
	<%@ include file="../fragments/footerfragment.jspf" %>
	
</body>
</html>