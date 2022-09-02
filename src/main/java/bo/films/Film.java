package bo.films;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import bo.Image;

@Entity
@Table(name="films")
public class Film {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noFilm;
	
	private String nom;
	private String description;
	private int dureeFilm;
	
	private LocalDate dateCrea;
	private LocalDate dateModif;
	
	
	@ManyToOne
	@JoinColumn(name="codePegi")
	private Pegi pegi;
	
	@ManyToOne
	@JoinColumn(name="codeVersion")
	private FilmVersion FilmVersion;
	
	@ManyToOne
	@JoinColumn(name="codeCategorie")
	private Categorie categorie;
	
	@ManyToOne
	@JoinColumn(name="codeEtat")
	private Etat Etat;
	
	@ManyToOne
	@JoinColumn(name="codeImage")
	private Image Image;
	
	public Film() {}

	public int getNoFilm() {
		return noFilm;
	}

	public void setNoFilm(int noFilm) {
		this.noFilm = noFilm;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getDureeFilm() {
		return dureeFilm;
	}

	public void setDureeFilm(int dureeFilm) {
		this.dureeFilm = dureeFilm;
	}

	public Pegi getPegi() {
		return pegi;
	}

	public void setPegi(Pegi pegi) {
		this.pegi = pegi;
	}

	public FilmVersion getFilmVersion() {
		return FilmVersion;
	}

	public void setFilmVersion(FilmVersion filmversion) {
		FilmVersion = filmversion;
	}

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public Etat getEtat() {
		return Etat;
	}

	public void setEtat(Etat etat) {
		Etat = etat;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	public LocalDate getDateCrea() {
		return dateCrea;
	}

	public void setDateCrea(LocalDate dateCrea) {
		this.dateCrea = dateCrea;
	}

	public LocalDate getDateModif() {
		return dateModif;
	}

	public void setDateModif(LocalDate dateModif) {
		this.dateModif = dateModif;
	}
	
}
