package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bll.SeanceBLL;
import bo.cinemas.Cinema;
import bo.cinemas.Seance;
import bo.films.Film;


@WebServlet("/SelectionCinema")
public class SelectionCinemaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private SeanceBLL bll;
	private CinemaBLL cinebll;
	
	@Override
	public void init() throws ServletException {
		bll = new SeanceBLL();
		cinebll = new CinemaBLL();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get selectionCinema");
		
		List<Cinema> mesCinemas = cinebll.selectAll();
		
		request.setAttribute("cinemas", mesCinemas);		
		
		request.getRequestDispatcher("/WEB-INF/jsp/selectionCinema.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post selectionCinema");
		
		List<Cinema> mesCinemas = cinebll.selectAll();
		
		request.setAttribute("cinemas", mesCinemas);
		
		String noCinema = request.getParameter("noCinema");
		
		System.out.println(noCinema);
		
		List<Seance> seances = bll.selectAll();

		 // Création de la liste filtré à laquelle on va ajouter les éléments
	    List<Seance> filteredList = new ArrayList<>();
	        
	        // itération dans la liste
	        for (Seance currentSeance: seances)
	        {
	            // filtre les valeurs qui correspondent au cinema selectionne
	        	if (currentSeance.getSalle().getCinema().getNoCinema() == Integer.parseInt(noCinema)) {
	                filteredList.add(currentSeance);
	            }
	        	
	        }
 
	        Map<Film, List<Seance>> map = filteredList.stream()
	                .collect(Collectors.groupingBy(Seance::getFilm));
	        
	        //  filteredList.sort(null);;
	 
	      // methode sort ajouter un comparator sur les 2 films
	        
	        System.out.println(filteredList);	
		
		request.setAttribute("seances", filteredList);
		request.setAttribute("map", map);
		request.getRequestDispatcher("/WEB-INF/jsp/selectionCinema.jsp").forward(request, response);
	}
	
}


