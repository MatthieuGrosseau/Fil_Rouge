package bo.cinemas;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bo.personnes.Personne;

@Entity
@Table(name="reservations")
public class Reservation {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noResa;
	private LocalDate dateCrea;
	private int nbPlaces;

	@ManyToOne
	@JoinColumn(name="noSeance")
	private Seance Seance;
	
	@ManyToOne
	@JoinColumn(name="noPersonne")
	private Personne Personne;
	
	@ManyToOne
	@JoinColumn(name="codeEtatResa")
	private EtatResa EtatResa;
	
	public Reservation() {}

	public int getNoResa() {
		return noResa;
	}

	public void setNoResa(int noResa) {
		this.noResa = noResa;
	}

	public LocalDate getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(LocalDate dateCrea) {
		this.dateCrea = dateCrea;
	}

	public int getNbPlaces() {
		return nbPlaces;
	}

	public void setNbPlaces(int nbPlaces) {
		this.nbPlaces = nbPlaces;
	}

	public Seance getSeance() {
		return Seance;
	}

	public void setSeance(Seance seance) {
		Seance = seance;
	}

	public Personne getPersonne() {
		return Personne;
	}

	public void setPersonne(Personne personne) {
		Personne = personne;
	}

	public EtatResa getEtatResa() {
		return EtatResa;
	}

	public void setEtatResa(EtatResa etatResa) {
		EtatResa = etatResa;
	}

	
}
