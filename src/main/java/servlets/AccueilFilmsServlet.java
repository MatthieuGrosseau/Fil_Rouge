package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;
import bo.films.Film;


@WebServlet("/AccueilFilms")
public class AccueilFilmsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new FilmBLL();
	}   


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get accueilfilms");
		List<Film> mesFilms = bll.selectAll();
		
		request.setAttribute("films", mesFilms);

		request.getRequestDispatcher("/WEB-INF/jsp/accueilFilms.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post accueilFilms");
		String critere = request.getParameter("critere");
		
		List<Film> mesfilms = bll.selectByCritere(critere);
		
		request.setAttribute("films", mesfilms);

		
		request.getRequestDispatcher("/WEB-INF/jsp/accueilFilms.jsp").forward(request, response);
	}

}
