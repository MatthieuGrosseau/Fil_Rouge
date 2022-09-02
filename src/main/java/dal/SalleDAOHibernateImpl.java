package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.cinemas.Salle;

public class SalleDAOHibernateImpl implements SalleDAO {
	private EntityManagerFactory emf;
	
	public SalleDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("FilRouge");
	}
	
	@Override
	public void insert(Salle salle) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(salle);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Salle> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Salle> resultat = em.createQuery("from Salle", Salle.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public Salle selectById(int noSalle) {
		EntityManager em = emf.createEntityManager();
		Salle resultat = em.find(Salle.class, noSalle);
		em.close();
		return resultat;
	}

	@Override
	public void delete(Salle salle) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(salle));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public void update(Salle salle) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.merge(salle);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}
