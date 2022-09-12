package servlets.gerant;

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
import bll.SalleBLL;
import bll.SeanceBLL;
import bo.cinemas.Cinema;
import bo.cinemas.Salle;
import bo.cinemas.Seance;
import bo.personnes.Personne;


@WebServlet("/gerant/GerantAccueil")
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
		System.out.println("Je passe dans get GerantAccueil");
		
		Personne personne = (Personne) request.getSession().getAttribute("user");
		if (personne != null) {
			int numero = personne.getNoPersonne();
	
			request.setAttribute("numero", numero);
		
		List<Cinema> cinemas = bllCinema.selectAll();	
			
		List<Cinema> filteredListCinema = new ArrayList<>();
		        
		        // itération dans la liste
		        for (Cinema currentCinema: cinemas)
		        {
		            // filtre les valeurs qui correspondent au gerant selectionne
		        	if (currentCinema.getPersonne().getNoPersonne() == numero) {
		                filteredListCinema.add(currentCinema);
		            }
		        	
		        }
	 
		        Map<Personne, List<Cinema>> mapCinemas = filteredListCinema.stream()
		                .collect(Collectors.groupingBy(Cinema::getPersonne));
		        
		List<Salle> salles = bllSalle.selectAll();	
				
		List<Salle> filteredListSalle = new ArrayList<>();
				        
				 // itération dans la liste
				 for (Salle currentSalle: salles)
				 {
				     // filtre les valeurs qui correspondent au gerant selectionne
				     if (currentSalle.getCinema().getPersonne().getNoPersonne() == numero) {
				         filteredListSalle.add(currentSalle);
				     }
				        	
				  }
			 
				  Map<Cinema, List<Salle>> mapSalles = filteredListSalle.stream()
				        .collect(Collectors.groupingBy(Salle::getCinema));
				        
				        
		List<Seance> seances = bllSeance.selectAll();	
						
		List<Seance> filteredListSeance = new ArrayList<>();
						        
				// itération dans la liste
				for (Seance currentSeance: seances)
				{
					// filtre les valeurs qui correspondent au gerant selectionne
					if (currentSeance.getSalle().getCinema().getPersonne().getNoPersonne() == numero) {
						filteredListSeance.add(currentSeance);
					}
						        	
				}
					 
				Map<Salle, List<Seance>> mapSeances = filteredListSeance.stream()
					.collect(Collectors.groupingBy(Seance::getSalle));
			
			
		request.setAttribute("mapCinemas", mapCinemas);
		request.setAttribute("mapSalles", mapSalles);
		request.setAttribute("mapSeances", mapSeances);
		request.getRequestDispatcher("/WEB-INF/jsp/gerant/gerantAccueil.jsp").forward(request, response);
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
