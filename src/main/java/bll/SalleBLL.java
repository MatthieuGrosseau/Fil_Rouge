package bll;

import java.util.List;

import bo.cinemas.Salle;
import dal.SalleDAO;
import dal.SalleDAOHibernateImpl;

public class SalleBLL {
private SalleDAO daoSalle;
	
	public SalleBLL() {
		daoSalle = new SalleDAOHibernateImpl();
	}
	
	public List<Salle> selectAll() {
		return daoSalle.selectAll();
	}
	
	public Salle selectById(int noSalle) {
		return daoSalle.selectById(noSalle);
	}
	

	public void insert(Salle salle) {
		daoSalle.insert(salle);
	}
	
	public void update(Salle salle) {
		daoSalle.update(salle);
	}
	
	public void delete(Salle salle) {
		daoSalle.delete(salle);
	}

}
