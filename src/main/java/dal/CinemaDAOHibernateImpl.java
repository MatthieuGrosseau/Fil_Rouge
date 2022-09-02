package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bo.cinemas.Cinema;

public class CinemaDAOHibernateImpl implements CinemaDAO {
	private EntityManagerFactory emf;
	
	public CinemaDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("FilRouge");
	}
	
	@Override
	public void insert(Cinema cinema) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(cinema);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Cinema> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Cinema> resultat = em.createQuery("from Cinema", Cinema.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public Cinema selectById(int noCinema) {
		EntityManager em = emf.createEntityManager();
		Cinema resultat = em.find(Cinema.class, noCinema);
		em.close();
		return resultat;
	}

	@Override
	public void delete(Cinema cinema) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(cinema));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public void update(Cinema cinema) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.merge(cinema);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Cinema> selectByCritere(String critere) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Cinema> query = em.createQuery("SELECT c from Cinema c WHERE c.ville LIKE :critere", Cinema.class);
		query.setParameter("critere", "%" + critere + "%");
		List<Cinema> resultat = query.getResultList();
		em.close();
		return resultat;		
	}
}
