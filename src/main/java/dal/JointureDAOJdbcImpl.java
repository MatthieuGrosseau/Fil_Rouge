package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


import bo.Jointure;
import bo.cinemas.Salle;
import bo.cinemas.Seance;
import bo.films.Film;


public class JointureDAOJdbcImpl implements JointureDAO {
private DataSource dataSource;
	

	private final String SELECT_ALL = "SELECT c.noCinemas noc, c.nom nomc, sa.nomSalle nomsa, sa.Capacite cap, se.dateSeance date, se.heureSeance heure, f.nom nomf, f.dureeFilm duree FROM cinemas c left join salles sa on sa.noCinemas=c.noCinemas left join seances se on se.noSalle=sa.noSalle left join films f on f.noFilm = se.noFilm";
	
	public JointureDAOJdbcImpl() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/admin");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Jointure> selectAll() {
		List<Jointure> resultat = new ArrayList<>();
		try {
			Connection cnx = dataSource.getConnection();
			
			// Pr�paration de la requ�te � ex�cuter
			PreparedStatement pst = cnx.prepareStatement(SELECT_ALL);
			
			// Ex�cution de la requ�te SQL
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Jointure nouvelleJointure = new Jointure();
				nouvelleJointure.setNoCinemas(rs.getInt("noc"));
				nouvelleJointure.setNom(rs.getString("nomc"));
							
				Salle salle = new Salle();
				salle.setNomSalle(rs.getString("nomsa"));
				salle.setCapacite(rs.getInt("cap"));
				
				Seance seance = new Seance();
				if(rs.getDate("date") != null) {
				seance.setDateSeance(rs.getDate("date").toLocalDate());
				seance.setHeureSeance(rs.getTime("heure"));
				}
				
				Film film = new Film();
				film.setNom(rs.getString("nomf"));
				film.setDureeFilm(rs.getInt("duree"));
				
								
				if (resultat.contains(nouvelleJointure)) {
					int i = resultat.indexOf(nouvelleJointure);
					nouvelleJointure = resultat.get(i);
					nouvelleJointure.getSalles().add(salle);
					nouvelleJointure.getSeances().add(seance);
					nouvelleJointure.getFilms().add(film);
				} else {
					nouvelleJointure.getSalles().add(salle);
					nouvelleJointure.getSeances().add(seance);
					nouvelleJointure.getFilms().add(film);
					resultat.add(nouvelleJointure);
				}
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
}
