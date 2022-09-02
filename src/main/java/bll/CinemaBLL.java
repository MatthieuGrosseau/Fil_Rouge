package bll;

import java.util.List;

import bo.cinemas.Cinema;
import dal.CinemaDAO;
import dal.CinemaDAOHibernateImpl;

public class CinemaBLL {
	private CinemaDAO daoCinema;
	
	public CinemaBLL() {
		daoCinema = new CinemaDAOHibernateImpl();
	}
	
	public List<Cinema> selectAll() {
		return daoCinema.selectAll();
	}
	
	public Cinema selectById(int noCinema) {
		return daoCinema.selectById(noCinema);
	}
	

	public void insert(Cinema cinema) {
		daoCinema.insert(cinema);
	}
	
	public void update(Cinema cinema) {
		daoCinema.update(cinema);
	}
	
	public void delete(Cinema cinema) {
		daoCinema.delete(cinema);
	}

	public List<Cinema> selectByCritere(String critere) {
		return daoCinema.selectByCritere(critere);
	}
		
	
}
