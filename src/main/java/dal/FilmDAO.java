package dal;

import java.util.List;

import bo.films.Film;

public interface FilmDAO {
	
	List<Film> selectAll();

	Film selectById(int noFilm);

	List<Film> selectByCritere(String critere);
}
