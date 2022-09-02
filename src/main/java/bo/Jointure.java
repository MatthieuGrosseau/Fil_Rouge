package bo;

import java.util.ArrayList;
import java.util.List;

import bo.cinemas.Salle;
import bo.cinemas.Seance;
import bo.films.Film;

public class Jointure {
	private int noCinemas;
	private String nom;
	private List<Salle> salles = new ArrayList<>();
	private List<Seance> seances = new ArrayList<>();
	private List<Film> films = new ArrayList<>();
	
	public Jointure() {}
	
	public int getNoCinemas() {
		return noCinemas;
	}

	public void setNoCinemas(int noCinemas) {
		this.noCinemas = noCinemas;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	public List<Film> getFilms() {
		return films;
	}

	public void setFilms(List<Film> films) {
		this.films = films;
	}

	@Override
	public boolean equals(Object o) {
		Jointure other = (Jointure) o;
		return other.getNoCinemas() == noCinemas;
	}
}
