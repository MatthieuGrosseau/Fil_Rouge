package bo.films;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="film_versions")
public class FilmVersion {
	
	@Id
	private String codeVersion;
	
	private String description;
	
	public FilmVersion() {}

	public String getCodeVersion() {
		return codeVersion;
	}

	public void setCodeVersion(String codeVersion) {
		this.codeVersion = codeVersion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "FilmVersion [codeVersion=" + codeVersion + ", description=" + description + "]";
	}
		
}
