package servlets.gerant.salle;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.SalleBLL;
import bo.cinemas.Salle;


@WebServlet("/gerant/SupprimerSalle")
public class AdminSupprimerSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SalleBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new SalleBLL();
	}   
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminSupprimerSalle");
		
		// 1. Recup�ration des params
				String saId = request.getParameter("noSalle_salle");
				System.out.println(saId);
				
				// 2. Je récupère le BO
				Salle salleASupprimer = bll.selectById(Integer.parseInt(saId));
				
				// 3. Je d�clenche le traitement en BDD
				bll.delete(salleASupprimer);
				
				// 4. J'envoie les attributs n�cessaires � ma jsp
				request.setAttribute("message", "Le cinema d'id " + saId + " a été supprimé.");
				
				// 5. Redirection de l'utilisateur
				// request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
				response.sendRedirect("../admin/AdminAccueil");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
