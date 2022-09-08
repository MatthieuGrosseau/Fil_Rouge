package servlets.client;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.ReservationBLL;
import bll.SeanceBLL;
import bo.cinemas.Reservation;
import bo.cinemas.Seance;
import bo.personnes.Personne;

@WebServlet("/Reservation")
public class ReservationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ReservationBLL bll;
	private SeanceBLL sbll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		bll = new ReservationBLL();
		sbll = new SeanceBLL();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				System.out.println("Je passe dans get Reservation");
				String idSeance = request.getParameter("noSeance_seance");
				System.out.println(idSeance);
						
				Seance maSeance = sbll.selectById(Integer.parseInt(idSeance));
				
				request.setAttribute("maSeance", maSeance);
				
				request.getRequestDispatcher("/WEB-INF/jsp/reservation.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post Reservation");
		
				String noSeance= request.getParameter("noSeance");
				String nbPlaces = request.getParameter("nbPlaces");

				System.out.println(noSeance);
				System.out.println(nbPlaces);				
				
				Seance seance = sbll.selectById(Integer.parseInt(noSeance));
				Personne personneresa = (Personne) request.getSession().getAttribute("user");
				
				// 3. Creation du BO
				Reservation reservation = new Reservation();
				reservation.setNbPlaces(Integer.parseInt(nbPlaces));
				reservation.setDateCrea(LocalDate.now());
				reservation.setSeance(seance);
				reservation.setPersonne(personneresa);
				

				// 4. Envoi des informations aupr�s de la base de donn�es
					try {
						bll.insert(reservation);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					// 5. Envoi d'un message � ma jsp
					//request.setAttribute("message", "La Salle " + saNomSalle +  " a bien été modifi� avec l'id : " + salle.getNoSalle());
					
				
				// 6. Rediriger mon utilisateur

				response.sendRedirect("Accueil");
		
		
	}
}
