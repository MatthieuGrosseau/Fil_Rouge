package bo.cinemas;

import java.sql.Time;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bo.films.Film;

@Entity
@Table(name="seances")
public class Seance {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noSeance;
	private LocalDate dateSeance;
	private Time heureSeance;
	
	@ManyToOne
	@JoinColumn(name="noSalle")
	private Salle Salle;
	
	@ManyToOne
	@JoinColumn(name="noFilm")
	private Film Film;
	
	public Seance() {}

	public int getNoSeance() {
		return noSeance;
	}

	public void setNoSeance(int noSeance) {
		this.noSeance = noSeance;
	}

	public LocalDate getDateSeance() {
		return dateSeance;
	}

	public void setDateSeance(LocalDate dateSeance) {
		this.dateSeance = dateSeance;
	}

	public Time getHeureSeance() {
		return heureSeance;
	}

	public void setHeureSeance(Time heureSeance) {
		this.heureSeance = heureSeance;
	}

	public Salle getSalle() {
		return Salle;
	}

	public void setSalle(Salle salle) {
		Salle = salle;
	}

	public Film getFilm() {
		return Film;
	}

	public void setFilm(Film film) {
		Film = film;
	}

}
