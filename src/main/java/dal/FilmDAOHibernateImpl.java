package dal;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

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
		EntityManager em = emf.createEntityManager();
		TypedQuery<Film> query = em.createQuery("SELECT f from Film f WHERE f.nom LIKE :critere", Film.class);
		query.setParameter("critere", "%" + critere + "%");
		List<Film> resultat = query.getResultList();
		em.close();
		return resultat;		
	}

		
}
