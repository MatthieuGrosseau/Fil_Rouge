package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;


@WebServlet("/Inscription")
public class InscriptionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}   
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get inscription");
		request.getRequestDispatcher("/WEB-INF/jsp/inscription.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post inscription");
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
				String prolePersonne = request.getParameter("rolePersonne");
				String pNom = request.getParameter("nom");
				String pPrenom = request.getParameter("prenom");
				String pAge = request.getParameter("age");
				String pAdresseMail = request.getParameter("adresseMail");
				String pNumeroTelephone = request.getParameter("numeroTelephone");
				String pMotDePasse = request.getParameter("motDePasse");
				String pAdresse = request.getParameter("adresse");
				String pCpo = request.getParameter("cpo");
				String pVille = request.getParameter("ville");

				System.out.println(prolePersonne);
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
				int intprolePersonne = Integer.valueOf(prolePersonne);
				int intpAge = Integer.valueOf(pAge);
				int intpCpo = Integer.valueOf(pCpo);
				
		// 3. Creation du BO
				Personne Personne = new Personne(intprolePersonne, pNom, pPrenom, intpAge, pAdresseMail, pNumeroTelephone, pMotDePasse, pAdresse, intpCpo, pVille);
		// 4. Envoi des informations aupr�s de la base de donn�es
					try {
						bll.insert(Personne);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
		// 5. Envoi d'un message � ma jsp
					request.getSession().setAttribute("message", "L'utilisateur " + pNom +  " a bien été créé ");
							
				
		// 6. Rediriger mon utilisateur

				response.sendRedirect("Accueil");
	}

}
