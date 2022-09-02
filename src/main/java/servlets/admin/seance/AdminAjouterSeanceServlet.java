package servlets.admin.seance;

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



@WebServlet("/admin/AjouterSeance")
public class AdminAjouterSeanceServlet extends HttpServlet {
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
		System.out.println("Je passe dans get AdminAjouterSeance");
		request.setAttribute("listeSalles", sallebll.selectAll());
		request.setAttribute("listeFilms", filmbll.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/admin/formulaireajoutSeance.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminAjouterSeance");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String senoSalle = request.getParameter("noSalle");
		String senoFilm = request.getParameter("noFilm");
		String sedateSeance = request.getParameter("dateSeance");
		String seheureSeance = request.getParameter("heureSeance");

		System.out.println(senoSalle);
		System.out.println(senoFilm);
		System.out.println(sedateSeance);
		System.out.println(seheureSeance);
		
		// 2. Je transforme dans le bon type
		
		
		Salle seSalle = sallebll.selectById(Integer.parseInt(senoSalle));
		Film seFilm = filmbll.selectById(Integer.parseInt(senoFilm));
		
		// 3. Creation du BO
		Seance seance = new Seance();
		seance.setDateSeance(LocalDate.parse(sedateSeance));
		seance.setHeureSeance(Time.valueOf(seheureSeance+":00"));
		seance.setSalle(seSalle); 
		seance.setFilm(seFilm);
		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				seancebll.insert(seance);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 5. Envoi d'un message � ma jsp
			request.setAttribute("message", "La Seance le " + sedateSeance + " a " + seheureSeance +  " a bien été modifi� avec l'id : " + seance.getNoSeance());
			
		
		// 6. Rediriger mon utilisateur

		response.sendRedirect("AdminAccueil?id_salle=" + seance.getNoSeance());
	}

}
