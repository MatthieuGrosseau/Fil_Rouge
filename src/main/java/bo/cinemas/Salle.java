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



@Entity
@Table(name="salles")
public class Salle {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int noSalle;
	
	private String nomSalle;
	private int capacite;
	
	
	@ManyToOne
	@JoinColumn(name="noCinema")
	private Cinema Cinema;
	
	@OneToMany
	private List<Seance> seances;
			
	public Salle() {}

	public int getNoSalle() {
		return noSalle;
	}

	public void setNoSalle(int noSalle) {
		this.noSalle = noSalle;
	}

	public String getNomSalle() {
		return nomSalle;
	}

	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public Cinema getCinema() {
		return Cinema;
	}

	public void setCinema(Cinema cinema) {
		Cinema = cinema;
	}

	public List<Seance> getSeances() {
		return seances;
	}

	public void setSeances(List<Seance> seances) {
		this.seances = seances;
	}

	
}
