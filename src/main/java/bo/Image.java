package bo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="images")
public class Image {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int codeImage;
	
	private String lienImage;
	private String description;
	
	public Image() {}
	
	public int getCodeImage() {
		return codeImage;
	}
	public void setCodeImage(int codeImage) {
		this.codeImage = codeImage;
	}
	public String getLienImage() {
		return lienImage;
	}
	public void setLienImage(String lienImage) {
		this.lienImage = lienImage;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
