package bo.cinemas;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import bo.Image;
import bo.personnes.Personne;

@Entity
@Table(name="cinemas")
public class Cinema {

	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noCinema;
	
	private String nom;
	private String numeroTelephone;
	private String adresse;
	private String cpo;
	private String ville;
	
	@ManyToOne
	@JoinColumn(name="noPersonne")
	private Personne Personne;
	
	@ManyToOne
	@JoinColumn(name="codeImage")
	private Image Image;
	
	@OneToMany
	private List<Salle> salles;
	
	public Cinema() {}

	public int getNoCinema() {
		return noCinema;
	}

	public void setNoCinema(int noCinema) {
		this.noCinema = noCinema;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCpo() {
		return cpo;
	}

	public void setCpo(String cpo) {
		this.cpo = cpo;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Personne getPersonne() {
		return Personne;
	}

	public void setPersonne(Personne personne) {
		Personne = personne;
	}

	public Image getImage() {
		return Image;
	}

	public void setImage(Image image) {
		Image = image;
	}

	public List<Salle> getSalles() {
		return salles;
	}

	public void setSalles(List<Salle> salles) {
		this.salles = salles;
	}
	
	

}
