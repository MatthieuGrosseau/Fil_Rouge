package bll;

import java.util.List;

import bo.cinemas.Seance;
import dal.SeanceDAO;
import dal.SeanceDAOHibernateImpl;

public class SeanceBLL {
private SeanceDAO daoSeance;
	
	public SeanceBLL() {
		daoSeance = new SeanceDAOHibernateImpl();
	}
	
	public List<Seance> selectAll() {
		return daoSeance.selectAll();
	}
	
	public Seance selectById(int noSeance) {
		return daoSeance.selectById(noSeance);
	}
	

	public void insert(Seance seance) {
		daoSeance.insert(seance);
	}
	
	public void update(Seance seance) {
		daoSeance.update(seance);
	}
	
	public void delete(Seance seance) {
		daoSeance.delete(seance);
	}
	
	public List<Seance> selectByCritere(String critere) {
		return daoSeance.selectByCritere(critere);
	}
	
}
