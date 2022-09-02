package bll;

import java.util.List;

import bo.films.Film;
import dal.FilmDAO;
import dal.FilmDAOHibernateImpl;

public class FilmBLL {
private FilmDAO daoFilm;
	
	public FilmBLL() {
		daoFilm = new FilmDAOHibernateImpl();
	}
	
	public List<Film> selectAll() {
		return daoFilm.selectAll();
	}
	
	public Film selectById(int id) {
		return daoFilm.selectById(id);
	}
	
	public List<Film> selectByCritere(String critere) {
		return daoFilm.selectByCritere(critere);
	}
		
	
}
