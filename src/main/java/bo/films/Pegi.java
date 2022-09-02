package bo.films;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pegi")
public class Pegi {
	
	@Id 
	private int codePegi;
	
	private String description;
	
	public Pegi() {}

	public int getCodePegi() {
		return codePegi;
	}

	public void setCodePegi(int codePegi) {
		this.codePegi = codePegi;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

		
}
