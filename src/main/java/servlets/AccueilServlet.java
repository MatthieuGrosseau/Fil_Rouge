package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bo.cinemas.Cinema;



@WebServlet("/Accueil")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CinemaBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new CinemaBLL();
	}   

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get accueil");
		
		List<Cinema> mesCinemas = bll.selectAll();
		
		request.setAttribute("cinemas", mesCinemas);

		request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
		
		request.getSession().removeAttribute("message");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post accueil");
				
		String critere = request.getParameter("critere");
		
		System.out.println(critere);
		
		List<Cinema> mesCinemas = bll.selectByCritere(critere);
		
		request.setAttribute("cinemas", mesCinemas);

		
		request.getRequestDispatcher("/WEB-INF/jsp/accueil.jsp").forward(request, response);
	}
}
