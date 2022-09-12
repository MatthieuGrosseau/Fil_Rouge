package servlets.admin.personnes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;



@WebServlet("/admin/AjouterPersonne")
public class AdminAjouterPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL personnebll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		personnebll = new PersonneBLL();
	}   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminAjouterPersonne");
		
		request.getRequestDispatcher("/WEB-INF/jsp/admin/formulaireajoutPersonne.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminAjouterPersonne");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String rolePersonne = request.getParameter("rolePersonne");
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		String age = request.getParameter("age");
		String adresseMail = request.getParameter("adresseMail");
		String numeroTelephone = request.getParameter("numeroTelephone");
		String motDePasse = request.getParameter("motDePasse");
		String adresse = request.getParameter("adresse");
		String cpo = request.getParameter("cpo");
		String ville = request.getParameter("ville");
		
		// 2. Creation du BO
		Personne personne = new Personne();
		personne.setRolePersonne(Integer.parseInt(rolePersonne));
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAge(Integer.parseInt(age));
		personne.setAdresseMail(adresseMail);
		personne.setNumeroTelephone(numeroTelephone);
		personne.setMotDePasse(motDePasse);
		personne.setAdresse(adresse);
		personne.setCpo(Integer.parseInt(cpo));
		personne.setVille(ville);
		// 3. Envoi des informations aupr�s de la base de donn�es
			try {
				personnebll.insert(personne);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 4. Envoi d'un message � ma jsp
			request.setAttribute("message", "La personne " + nom +  " a bien été modifi� avec l'id : " + personne.getNoPersonne());
			
		
		// 5. Rediriger mon utilisateur

		response.sendRedirect("AdminAccueil?id_personne=" + personne.getNoPersonne());
	}

}
