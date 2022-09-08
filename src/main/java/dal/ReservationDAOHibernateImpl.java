package dal;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import bo.cinemas.Reservation;

public class ReservationDAOHibernateImpl implements ReservationDAO {
	private EntityManagerFactory emf;
	
	public ReservationDAOHibernateImpl() {
		emf = Persistence.createEntityManagerFactory("FilRouge");
	}
	
	@Override
	public void insert(Reservation reservation) {
		EntityManager em = emf.createEntityManager();
		
		// Necessaire a chaque fois qu'on realise une operation qui modifier le contenu de la bdd
		em.getTransaction().begin();
		try {
			em.persist(reservation);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}

	@Override
	public List<Reservation> selectAll() {
		EntityManager em = emf.createEntityManager();
		List<Reservation> resultat = em.createQuery("from Reservation", Reservation.class).getResultList();
		em.close();
		return resultat;
	}
	
	@Override
	public Reservation selectById(int noResa) {
		EntityManager em = emf.createEntityManager();
		Reservation resultat = em.find(Reservation.class, noResa);
		em.close();
		return resultat;
	}

	@Override
	public void delete(Reservation reservation) {
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		try {
			em.remove(em.merge(reservation));
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
		
		em.close();
	}
}

