package servlets.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;

/**
 * Servlet implementation class ModifierClientServlet
 */
@WebServlet("/ModifierClient")
public class ModifierClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get ModifierClient");
		
		// 1. Recup�ration des parametres
			String pId = request.getParameter("id");
				
		// 2. Je transforme dans le bon type
			int Id = Integer.valueOf(pId);
					
		// 3. Je r�cup�re mon contact aupr�s de ma bdd
			Personne personne = bll.selectById(Id);
					
		// 4. Je passe le contact r�cup�r� � ma jsp
			request.setAttribute("personne", personne);
			
		// 5. Redirection vers la page de formulaire
			request.getRequestDispatcher("/WEB-INF/jsp/client/formulaireClient.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post ModifierClient");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
			String pnoPersonne = request.getParameter("noPersonne");
			String pNom = request.getParameter("nom");
			String pPrenom = request.getParameter("prenom");
			String pAge = request.getParameter("age");
			String pAdresseMail = request.getParameter("adresseMail");
			String pNumeroTelephone = request.getParameter("numeroTelephone");
			String pMotDePasse = request.getParameter("motDePasse");
			String pAdresse = request.getParameter("adresse");
			String pCpo = request.getParameter("cpo");
			String pVille = request.getParameter("ville");

			System.out.println(pnoPersonne);
			System.out.println(pNom);
			System.out.println(pPrenom);
			System.out.println(pAge);
			System.out.println(pAdresseMail);
			System.out.println(pNumeroTelephone);
			System.out.println(pMotDePasse);
			System.out.println(pAdresse);
			System.out.println(pCpo);
			System.out.println(pVille);
				
		// 2. Je transforme dans le bon type
				int intpAge = Integer.valueOf(pAge);
				int intpCpo = Integer.valueOf(pCpo);
				int role = 3;
				
				
		// 3. Creation du BO
				Personne personne = new Personne(role, pNom, pPrenom, intpAge, pAdresseMail, pNumeroTelephone, pMotDePasse, pAdresse, intpCpo, pVille);
				int id = Integer.valueOf(pnoPersonne);
		

			// 3bis. Affectation de l'identifiant au contact
			
				personne.setNoPersonne(id);
			
		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				bll.update(personne);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// 5. Envoi d'un message � ma jsp
			
			request.getSession().setAttribute("message", "Le compte " + pNom +  " a bien été modifié ");
			
		// 6. Rediriger mon utilisateur
			response.sendRedirect("Accueil");
	}
}