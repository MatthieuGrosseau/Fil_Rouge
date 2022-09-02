package servlets.admin.seance;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.SeanceBLL;
import bo.cinemas.Seance;


@WebServlet("/admin/SupprimerSeance")
public class AdminSupprimerSeanceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeanceBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new SeanceBLL();
	}   
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminSupprimerSeance");
		
		// 1. Recup�ration des params
				String seId = request.getParameter("noSeance_seance");
				System.out.println(seId);
				
				// 2. Je récupère le BO
				Seance seanceASupprimer = bll.selectById(Integer.parseInt(seId));
				
				// 3. Je d�clenche le traitement en BDD
				bll.delete(seanceASupprimer);
				
				// 4. J'envoie les attributs n�cessaires � ma jsp
				request.setAttribute("message", "La seance d'id " + seId + " a été supprimé.");
				
				// 5. Redirection de l'utilisateur
				// request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
				response.sendRedirect("AdminAccueil");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
