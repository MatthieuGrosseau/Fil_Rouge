package servlets.client;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.PersonneBLL;
import bo.personnes.Personne;


@WebServlet("/ClientAccueil")
public class ClientAccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private PersonneBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new PersonneBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Je passe dans get ClientAccueil");
		
		// 1. Je recuoère le numéro du client pour afficher son contact
		
		if (request.getSession().getAttribute("user") != null) {
		System.out.println(request.getSession().getAttribute("user"));
		
		Personne personne = (Personne) request.getSession().getAttribute("user");
		if (personne != null) {
			int numero = personne.getNoPersonne();
	
			request.setAttribute("numero", numero);

		// 1. J'affiche le détail du client
		
		System.out.println(numero);
						
		Personne maPersonne = bll.selectById(numero);
		
		request.setAttribute("personne", maPersonne);
		
		request.getRequestDispatcher("/WEB-INF/jsp/client/clientAccueil.jsp").forward(request, response);
		
	}
		
}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post ClientAccueil");
	}

}
