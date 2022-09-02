package bo.films;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categories")
public class Categorie {
	
	@Id
	private String codeCategorie;
	
	private String description;
	
	public Categorie() {}

	public String getCodeCategorie() {
		return codeCategorie;
	}

	public void setCodeCategorie(String codeCategorie) {
		this.codeCategorie = codeCategorie;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Categorie [codeCategorie=" + codeCategorie + ", description=" + description + "]";
	}
			
}
