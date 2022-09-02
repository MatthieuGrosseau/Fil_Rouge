package dal;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.films.Film;

public class FilmDAOHibernateImpl implements FilmDAO{
	private EntityManagerFactory emf;
	
	public FilmDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("FilRouge");
	}
	
	@Override
	public List<Film> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Film> resultat = em.createQuery("from Film", Film.class).getResultList();
		em.close();
		return resultat;
	}

	@Override
	public Film selectById(int noFilm) {
		EntityManager em = emf.createEntityManager();
		Film resultat = em.find(Film.class, noFilm);
		em.close();
		return resultat;
	}

	@Override
	public List<Film> selectByCritere(String critere) {
		// TODO Auto-generated method stub
		return null;
	}

		
}
