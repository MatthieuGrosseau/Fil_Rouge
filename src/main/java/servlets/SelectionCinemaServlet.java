package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.SeanceBLL;
import bo.cinemas.Seance;


@WebServlet("/SelectionCinema")
public class SelectionCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeanceBLL bll;
	
	@Override
	public void init() throws ServletException {
		bll = new SeanceBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get selectionCinema");
		
		String noCinema = request.getParameter("noCinema");
		
		System.out.println(noCinema);
		
		List<Seance> seances = bll.selectAll();
		
		for (int i = 0; i < seances.size() ; i++) {
			if (seances[i].salle.cinema.noCinema == noCinema) {
		}
		
		
		request.setAttribute("seances", seances);
		request.getRequestDispatcher("/WEB-INF/jsp/selectionCinema.jsp").forward(request, response);
	}
}


