package servlets.gerant.seance;

import java.io.IOException;
import java.sql.Time;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;
import bll.SalleBLL;
import bll.SeanceBLL;
import bo.cinemas.Salle;
import bo.cinemas.Seance;
import bo.films.Film;


@WebServlet("/gerant/ModifierSeance")
public class AdminModifierSeanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeanceBLL seancebll;
	private SalleBLL sallebll;
	private FilmBLL filmbll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		seancebll = new SeanceBLL();
		sallebll = new SalleBLL();
		filmbll = new FilmBLL();
	}  


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminModifierSeance");
		
		// 1. Recup�ration des parametres
			String seIdSeanceAModifier = request.getParameter("noSeance_seance");
				
		// 2. Je transforme dans le bon type
			int IdSeanceAModifier = Integer.valueOf(seIdSeanceAModifier);
					
		// 3. Je r�cup�re mon contact aupr�s de ma bdd
			Seance seance = seancebll.selectById(IdSeanceAModifier);
					
		// 4. Je passe le contact r�cup�r� � ma jsp
			request.setAttribute("seance", seance);
			request.setAttribute("listeSalles", sallebll.selectAll());
			request.setAttribute("listeFilms", filmbll.selectAll());
		// 5. Redirection vers la page de formulaire
			request.getRequestDispatcher("/WEB-INF/jsp/gerant/formulairemodifierSeance.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminModifierSeance");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String senoSeance = request.getParameter("noSeance");
		String senoSalle = request.getParameter("noSalle");
		String senoFilm = request.getParameter("noFilm");
		String sedateSeance = request.getParameter("dateSeance");
		String seheureSeance = request.getParameter("heureSeance").substring(0, 5);

		System.out.println(senoSeance);
		System.out.println(senoSalle);
		System.out.println(senoFilm);
		System.out.println(sedateSeance);
		System.out.println(seheureSeance);
		
		// 2. Je transforme dans le bon type
		
		Salle seSalle = sallebll.selectById(Integer.parseInt(senoSalle));
		Film seFilm = filmbll.selectById(Integer.parseInt(senoFilm));
				
				
		// 3. Mise à jour du BO
		Seance seance = seancebll.selectById(Integer.parseInt(senoSeance));
		seance.setDateSeance(LocalDate.parse(sedateSeance));
		seance.setHeureSeance(Time.valueOf(seheureSeance+":00"));
		seance.setSalle(seSalle); 
		seance.setFilm(seFilm);

		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				seancebll.update(seance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		// 5. Envoi d'un message � ma jsp
			request.setAttribute("message", "La Seance le " + sedateSeance + " a " + seheureSeance +  " a bien été modifi� avec l'id : " + seance.getNoSeance());
			
		// 6. Rediriger mon utilisateur
			response.sendRedirect("../admin/AdminAccueil?id_salle=" + seance.getNoSeance());
	}

}
