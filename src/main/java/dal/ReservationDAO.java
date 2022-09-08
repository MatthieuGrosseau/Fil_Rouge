package dal;

import java.util.List;

import bo.cinemas.Reservation;

public interface ReservationDAO {

	List<Reservation> selectAll();

	Reservation selectById(int noResa);

	void insert(Reservation reservation);

	void delete(Reservation reservation);

	

}
