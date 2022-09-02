<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mon compte</title>
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
		<div id="connection">
		
			<h1>Veuillez vous identifier</h1>
			<form method="post" action="${pageContext.request.contextPath }/Session">
				<input type="text" name="user" placeholder="Nom d'utilisateur" />
				<input type="password" name="pwd" placeholder="Mot de passe" />
				<input type="submit" value="Se connecter" />
			</form>
		</div>
	
	</section>

	<!-- footer -->
	<%@ include file="fragments/footerfragment.jspf" %>
	
</body>
</html>