package bo.personnes;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personnes")
public class Personne {
	//Attributs pour la classe = bdd sql
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noPersonne;
	private int rolePersonne;
	private String nom;
	private String prenom;
	private int age;
	private String adresseMail;
	private String numeroTelephone;
	private String motDePasse;
	private String adresse;
	private int cpo;
	private String ville;
	
	//Toujours un constructeur vide
	public Personne() {}

	//Constructeur complet si utile (en general on en fait un plus tard dans l'appli si on a besoin)
	public Personne(int noPersonne, int rolePersonne, String nom, String prenom, int age, String adresseMail, String numeroTelephone,
			String motDePasse, String adresse, int cpo, String ville) {
		super();
		this.noPersonne = noPersonne;
		this.rolePersonne = rolePersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.cpo = cpo;
		this.ville = ville;
	}

	public Personne(int rolePersonne, String nom, String prenom, int age, String adresseMail, String numeroTelephone,
			String motDePasse, String adresse, int cpo, String ville) {
		super();
		this.rolePersonne = rolePersonne;
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.cpo = cpo;
		this.ville = ville;
	}
	
	public Personne(String nom, String prenom, int age, String adresseMail, String numeroTelephone,
			String motDePasse, String adresse, int cpo, String ville) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.adresseMail = adresseMail;
		this.numeroTelephone = numeroTelephone;
		this.motDePasse = motDePasse;
		this.adresse = adresse;
		this.cpo = cpo;
		this.ville = ville;
	}

	//Getter et Setter
	public int getNoPersonne() {
		return noPersonne;
	}

	public void setNoPersonne(int noPersonne) {
		this.noPersonne = noPersonne;
	}

	public int getRolePersonne() {
		return rolePersonne;
	}

	public void setRolePersonne(int rolePersonne) {
		this.rolePersonne = rolePersonne;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getNumeroTelephone() {
		return numeroTelephone;
	}

	public void setNumeroTelephone(String numeroTelephone) {
		this.numeroTelephone = numeroTelephone;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motdepasse) {
		this.motDePasse = motdepasse;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public int getCpo() {
		return cpo;
	}

	public void setCpo(int cpo) {
		this.cpo = cpo;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	//Méthode toString pour afficher dans la console
	@Override
	public String toString() {
		return "Personne [noPersonne=" + noPersonne + ", rolePersonne=" + rolePersonne + ", nom=" + nom + ", prenom="
				+ prenom + ", age=" + age + ", mail=" + adresseMail + ", telephone=" + numeroTelephone + ", mdp=" + motDePasse
				+ ", adresse=" + adresse + ", cpo=" + cpo + ", ville=" + ville + "]";
	}
	
}
