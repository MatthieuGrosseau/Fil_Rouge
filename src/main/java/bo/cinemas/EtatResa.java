package bo.cinemas;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="etat_resa")
public class EtatResa {
	
	@Id
	private String codeEtatResa;
	private String description;
	
	public EtatResa() {}

	public String getCodeEtatResa() {
		return codeEtatResa;
	}

	public void setCodeEtatResa(String codeEtatResa) {
		this.codeEtatResa = codeEtatResa;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	
}
