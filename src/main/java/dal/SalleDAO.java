package dal;

import java.util.List;

import bo.cinemas.Salle;

public interface SalleDAO {

	List<Salle> selectAll();

	Salle selectById(int noSalle);

	void insert(Salle salle);

	void delete(Salle salle);

	void update(Salle salle);
}
