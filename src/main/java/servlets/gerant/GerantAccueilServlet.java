package servlets.gerant;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bll.SalleBLL;
import bll.SeanceBLL;


@WebServlet("/gerant/gerantAccueil")
public class GerantAccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CinemaBLL bllCinema;
	private SalleBLL bllSalle;
	private SeanceBLL bllSeance;
	
	@Override
	public void init() throws ServletException {
		bllCinema = new CinemaBLL();
		bllSalle = new SalleBLL();
		bllSeance = new SeanceBLL();
	}   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminAccueil");
		
		request.setAttribute("cinemas", bllCinema.selectAll());
		request.setAttribute("salles", bllSalle.selectAll());
		request.setAttribute("seances", bllSeance.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/admin/adminAccueil.jsp").forward(request, response);
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
