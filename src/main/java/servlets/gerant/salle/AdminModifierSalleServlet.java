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


@WebServlet("/gerant/ModifierSalle")
public class AdminModifierSalleServlet extends HttpServlet {
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
		System.out.println("Je passe dans get AdminModifierSalle");
		
		// 1. Recup�ration des parametres
			String saIdSalleAModifier = request.getParameter("noSalle_salle");
				
		// 2. Je transforme dans le bon type
			int IdSalleAModifier = Integer.valueOf(saIdSalleAModifier);
					
		// 3. Je r�cup�re mon contact aupr�s de ma bdd
			Salle salle = sallebll.selectById(IdSalleAModifier);
					
		// 4. Je passe le contact r�cup�r� � ma jsp
			request.setAttribute("salle", salle);
			request.setAttribute("listeCinemas", cinemabll.selectAll());
		// 5. Redirection vers la page de formulaire
			request.getRequestDispatcher("/WEB-INF/jsp/gerant/formulairemodifierSalle.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Je passe dans post AdminModifierSalle");
		
		// 1. Recup�ration des param�tres n�cessaires pour le traitement
		String sanoSalle = request.getParameter("noSalle");
		String sanoCinema = request.getParameter("noCinema");
		String saNomSalle = request.getParameter("nomSalle");
		String saCapacite = request.getParameter("capacite");

		System.out.println(sanoSalle);
		System.out.println(sanoCinema);
		System.out.println(saNomSalle);
		System.out.println(saCapacite);
		
		// 2. Je transforme dans le bon type
		
		Cinema saCinema = cinemabll.selectById(Integer.parseInt(sanoCinema));
				
				
		// 3. Mise à jour du BO
		Salle salle = sallebll.selectById(Integer.parseInt(sanoSalle));
		salle.setNomSalle(saNomSalle);
		salle.setCapacite(Integer.parseInt(saCapacite));
		salle.setCinema(saCinema);

		// 4. Envoi des informations aupr�s de la base de donn�es
			try {
				sallebll.update(salle);
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
