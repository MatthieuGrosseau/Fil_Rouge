package servlets.admin.personnes;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;


@WebServlet("/admin/SupprimerPersonne")
public class AdminSupprimerPersonneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}   
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminSupprimerPersonne");
		
		// 1. Recup�ration des params
				String Id = request.getParameter("noPersonne_personne");
				System.out.println(Id);
				
				// 3. Je d�clenche le traitement en BDD
				bll.deleteById(Integer.parseInt(Id));
				
				// 4. J'envoie les attributs n�cessaires � ma jsp
				request.setAttribute("message", "La personne d'id " + Id + " a été supprimé.");
				
				// 5. Redirection de l'utilisateur
				// request.getRequestDispatcher("/WEB-INF/accueil.jsp").forward(request, response);
				response.sendRedirect("AdminAccueil");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
