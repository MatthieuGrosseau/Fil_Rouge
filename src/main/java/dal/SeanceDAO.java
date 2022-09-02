package dal;

import java.util.List;

import bo.cinemas.Seance;

public interface SeanceDAO {

	List<Seance> selectAll();

	Seance selectById(int noSeance);

	void insert(Seance seance);

	void delete(Seance seance);

	void update(Seance seance);

	List<Seance> selectByCritere(String critere);
	
	
}
