package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.FilmBLL;
import bo.films.Film;


@WebServlet("/DetailFilm")
public class DetailFilmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private FilmBLL bll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new FilmBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("Je passe dans get detailfilms");
				String idFilm = request.getParameter("id_film");
				System.out.println(idFilm);
						
				int id = Integer.valueOf(idFilm);
				
				Film monFilm = bll.selectById(id);
				
				request.setAttribute("film", monFilm);
				
				request.getRequestDispatcher("/WEB-INF/jsp/detailFilm.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post detailfilms");
	}

}
