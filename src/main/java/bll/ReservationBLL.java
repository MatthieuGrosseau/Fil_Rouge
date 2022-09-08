package bll;

import java.util.List;

import bo.cinemas.Reservation;
import dal.ReservationDAO;
import dal.ReservationDAOHibernateImpl;

public class ReservationBLL {
private ReservationDAO daoReservation;
	
	public ReservationBLL() {
		daoReservation = new ReservationDAOHibernateImpl();
	}
	
	public List<Reservation> selectAll() {
		return daoReservation.selectAll();
	}
	
	public Reservation selectById(int noResa) {
		return daoReservation.selectById(noResa);
	}
	

	public void insert(Reservation reservation) {
		daoReservation.insert(reservation);
	}
		
	public void delete(Reservation reservation) {
		daoReservation.delete(reservation);
	}
}
