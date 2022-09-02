package servlets.admin.cinema;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bll.PersonneBLL;
import bo.cinemas.Cinema;
import bo.personnes.Personne;


@WebServlet("/admin/ModifierCinema")
public class AdminModifierCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CinemaBLL cinemabll;
	private PersonneBLL personnebll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		cinemabll = new CinemaBLL();
		personnebll = new PersonneBLL();
	}  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminModifierCinema");
		
		// 1. Recup�ration des parametres
			String pIdCinemaAModifier = request.getParameter("noCinema_cinema");
				
		// 2. Je transforme dans le bon type
			int IdCinemaAModifier = Integer.valueOf(pIdCinemaAModifier);
					
		// 3. Je r�cup�re mon contact aupr�s de ma bdd
			Cinema cinema = cinemabll.selectById(IdCinemaAModifier);
					
		// 4. Je passe le contact r�cup�r� � ma jsp
			request.setAttribute("cinema", cinema);
			request.setAttribute("listePersonnes", personnebll.selectAll());
		// 5. Redirection vers la page de formulaire
			request.getRequestDispatcher("/WEB-INF/jsp/admin/formulairemodifierCinema.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminModifierCinema");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String cnoCinema = request.getParameter("noCinema");
		String cnoPersonne = request.getParameter("noPersonne");
		String cNom = request.getParameter("nom");
		String cTelephone = request.getParameter("telephone");
		String cAdresse = request.getParameter("adresse");
		String cCpo = request.getParameter("cpo");
		String cVille = request.getParameter("ville");

		System.out.println(cnoPersonne);
		System.out.println(cNom);
		System.out.println(cTelephone);
		System.out.println(cAdresse);
		System.out.println(cCpo);
		System.out.println(cVille);
		
		// 2. Je transforme dans le bon type
		
		Personne cpersonne = personnebll.selectById(Integer.parseInt(cnoPersonne));
				
				
		// 3. Mise à jour du BO
		Cinema cinema = cinemabll.selectById(Integer.parseInt(cnoCinema));
		cinema.setNom(cNom);
		cinema.setNumeroTelephone(cTelephone);
		cinema.setAdresse(cAdresse);
		cinema.setCpo(cCpo);
		cinema.setVille(cVille);
		cinema.setPersonne(cpersonne);

		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				cinemabll.update(cinema);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// 5. Envoi d'un message � ma jsp
			request.setAttribute("message", "Le Cinema " + cNom +  " a bien été modifi� avec l'id : " + cinema.getNoCinema());
			
		// 6. Rediriger mon utilisateur
			response.sendRedirect("AdminAccueil?id_cinema=" + cinema.getNoCinema());
	}

}
