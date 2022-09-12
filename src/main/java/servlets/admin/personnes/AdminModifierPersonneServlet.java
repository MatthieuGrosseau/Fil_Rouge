package servlets.admin.personnes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;


@WebServlet("/admin/ModifierPersonne")
public class AdminModifierPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL personnebll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		personnebll = new PersonneBLL();
	}  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminModifierPersonne");
		
		// 1. Recup�ration des parametres
			String IdPersonneAModifier = request.getParameter("noPersonne_personne");
	
		// 3. Je r�cup�re mon contact aupr�s de ma bdd
			Personne personneAModifier = personnebll.selectById(Integer.parseInt(IdPersonneAModifier));
					
		// 4. Je passe le contact r�cup�r� � ma jsp
			request.setAttribute("personne", personneAModifier);
		// 5. Redirection vers la page de formulaire
			request.getRequestDispatcher("/WEB-INF/jsp/admin/formulairemodifierPersonne.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminModifierPersonne");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String noPersonne = request.getParameter("noPersonne");
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
		Personne personne = personnebll.selectById(Integer.parseInt(noPersonne));
		personne.setNom(nom);
		personne.setPrenom(prenom);
		personne.setAge(Integer.parseInt(age));
		personne.setAdresseMail(adresseMail);
		personne.setNumeroTelephone(numeroTelephone);
		personne.setMotDePasse(motDePasse);
		personne.setAdresse(adresse);
		personne.setCpo(Integer.parseInt(cpo));
		personne.setVille(ville);

		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				personnebll.update(personne);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// 5. Envoi d'un message � ma jsp
			request.setAttribute("message", "La personne " + nom +  " a bien été modifi� avec l'id : " + personne.getNoPersonne());
			
		// 6. Rediriger mon utilisateur
			response.sendRedirect("AdminAccueil?id_personne=" + personne.getNoPersonne());
	}

}
