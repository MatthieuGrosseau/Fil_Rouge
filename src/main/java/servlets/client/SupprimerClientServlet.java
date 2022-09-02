package servlets.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bll.PersonneBLL;

@WebServlet("/SupprimerClient")
public class SupprimerClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}   
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post SupprimerClient");	
		
		// 1. Recup�ration des params
				String pId = request.getParameter("id");
				System.out.println(pId);
				
			// 2. Transformer dans le type appropri�
				int id = Integer.valueOf(pId);
				
			// 3. Je d�clenche le traitement en BDD
				bll.deleteById(id);
				
			// 4. J'envoie les attributs n�cessaires � ma jsp
				request.getSession().setAttribute("message", "Le compte a bien été supprimé ");
				
			// 5. Redirection de l'utilisateur
				response.sendRedirect("Session");
		
	}
}
