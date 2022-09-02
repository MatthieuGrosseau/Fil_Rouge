package servlets.admin.cinema;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bo.cinemas.Cinema;


@WebServlet("/admin/SupprimerCinema")
public class AdminSupprimerCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CinemaBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new CinemaBLL();
	}   
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminSupprimerCinema");
		
		// 1. Recup�ration des params
				String cId = request.getParameter("noCinema_cinema");
				System.out.println(cId);
				
				// 2. Je récupère le BO
				Cinema cinemaASupprimer = bll.selectById(Integer.parseInt(cId));
				
				// 3. Je d�clenche le traitement en BDD
				bll.delete(cinemaASupprimer);
				
				// 4. J'envoie les attributs n�cessaires � ma jsp
				request.setAttribute("message", "Le cinema d'id " + cId + " a été supprimé.");
				
				// 5. Redirection de l'utilisateur
				// request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
				response.sendRedirect("AdminAccueil");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
