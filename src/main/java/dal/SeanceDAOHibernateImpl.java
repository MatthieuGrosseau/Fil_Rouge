package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import bo.cinemas.Seance;

public class SeanceDAOHibernateImpl implements SeanceDAO {
	private EntityManagerFactory emf;
	
	public SeanceDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("FilRouge");
	}
	
	@Override
	public void insert(Seance seance) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(seance);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Seance> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Seance> resultat = em.createQuery("from Seance", Seance.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public Seance selectById(int noSeance) {
		EntityManager em = emf.createEntityManager();
		Seance resultat = em.find(Seance.class, noSeance);
		em.close();
		return resultat;
	}

	@Override
	public void delete(Seance Seance) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(Seance));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public void update(Seance Seance) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.merge(Seance);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
	
	@Override
	public List<Seance> selectByCritere(String critere) {
		EntityManager em = emf.createEntityManager();
		TypedQuery<Seance> query = em.createQuery("SELECT DISTINCT s FROM Seance as s JOIN s.salle sa JOIN sa.cinema c", Seance.class);
		List<Seance> resultat = query.getResultList();
		em.close();
		return resultat;		
	}
	
}
