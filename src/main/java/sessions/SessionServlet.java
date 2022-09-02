package sessions;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;


@WebServlet("/Session")
public class SessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Je passe dans get Session");

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse rep = (HttpServletResponse) response;
		req.getSession().removeAttribute("login");
		String message = (String) req.getSession().getAttribute("message");
		req.getSession().invalidate();
		req.getSession().setAttribute("message", message);
		rep.sendRedirect("Accueil");
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("Je passe dans post Session");
		
				
		// Recuperation des parametres
		HttpServletRequest req = (HttpServletRequest) request;
		String username = req.getParameter("user");
		String password = req.getParameter("pwd");
		System.out.println(username);
		System.out.println(password);
		
		// username et password existent et ils contiennent de l'information
		if (username != null && !username.isBlank() && password != null && !password.isBlank()) {
			
			System.out.println("Passage dans la condition 1");
			Personne personne = bll.selectByUsernameAndPassword(username, password);
			
			// username et password existent et ils matchent avec une personne
			if (personne != null) {
				System.out.println("Passage dans la condition 2");
				req.getSession().setAttribute("user", personne);
				
				System.out.println(req.getSession().getAttribute("user"));
				System.out.println("Je redirige vers accueil si la session fonctionne");
				
				// Je redirige mon utilisateur vers la page de login
				HttpServletResponse rep = (HttpServletResponse) response;
				rep.sendRedirect("Accueil");
				
				// username et password existent mais ils ne matchent avec personne
				} else {
					
				System.out.println("Je redirige vers connection si la session ne fonctionne pas");
				HttpServletResponse rep = (HttpServletResponse) response;
				
				request.getSession().setAttribute("message", "Les identifiants renseignés ne correspondent à aucun compte");
				
				rep.sendRedirect("Connection");
				
				}
			
			// username et password n'existent pas
			} else {
			
			System.out.println("Je redirige vers connection si pas d'infos");
			HttpServletResponse rep = (HttpServletResponse) response;
			
			request.getSession().setAttribute("message", "Veuillez renseigner un identifiant et un mot de passe");
			
			rep.sendRedirect("Connection");
			
			}
	}
						

		
		
	}


