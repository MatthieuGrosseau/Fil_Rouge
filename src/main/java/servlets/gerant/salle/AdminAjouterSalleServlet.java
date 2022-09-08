package servlets.gerant.salle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bll.CinemaBLL;
import bll.SalleBLL;
import bo.cinemas.Cinema;
import bo.cinemas.Salle;



@WebServlet("/gerant/AjouterSalle")
public class AdminAjouterSalleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CinemaBLL cinemabll;
	private SalleBLL sallebll;
	
	@Override
	public void init() throws ServletException {
		super.init();
		cinemabll = new CinemaBLL();
		sallebll = new SalleBLL();
	}   
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans get AdminAjouterSalle");
		request.setAttribute("listeCinemas", cinemabll.selectAll());
		request.getRequestDispatcher("/WEB-INF/jsp/gerant/formulaireajoutSalle.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminAjouterSalle");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String sanoCinema = request.getParameter("noCinema");
		String saNomSalle = request.getParameter("nomSalle");
		String saCapacite = request.getParameter("capacite");

		System.out.println(sanoCinema);
		System.out.println(saNomSalle);
		System.out.println(saCapacite);
		
		// 2. Je transforme dans le bon type
		
		
		Cinema saCinema = cinemabll.selectById(Integer.parseInt(sanoCinema));
		
		// 3. Creation du BO
		Salle salle = new Salle();
		salle.setNomSalle(saNomSalle);
		salle.setCapacite(Integer.parseInt(saCapacite));
		salle.setCinema(saCinema);
		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				sallebll.insert(salle);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			// 5. Envoi d'un message � ma jsp
			request.setAttribute("message", "La Salle " + saNomSalle +  " a bien été modifi� avec l'id : " + salle.getNoSalle());
			
		
		// 6. Rediriger mon utilisateur

		response.sendRedirect("../admin/AdminAccueil?id_salle=" + salle.getNoSalle());
	}

}
