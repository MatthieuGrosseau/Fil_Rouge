package bo.films;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etats")
public class Etat {
	@Id
	private String codeEtat;
	
	private String description;
	
	public Etat() {}
	
	public String getCodeEtat() {
		return codeEtat;
	}
	
	public void setCodeEtat(String codeEtat) {
		this.codeEtat = codeEtat;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return "Etat [codeEtat=" + codeEtat + ", description=" + description + "]";
	}
	
}
