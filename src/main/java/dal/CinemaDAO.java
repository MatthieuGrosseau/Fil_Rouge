package dal;

import java.util.List;

import bo.cinemas.Cinema;

public interface CinemaDAO {

	List<Cinema> selectAll();

	Cinema selectById(int noCinema);

	void insert(Cinema cinema);

	void delete(Cinema cinema);

	void update(Cinema cinema);

	List<Cinema> selectByCritere(String critere);

}
