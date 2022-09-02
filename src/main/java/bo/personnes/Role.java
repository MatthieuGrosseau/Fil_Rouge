package bo.personnes;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	
	@Id
	private int rolePersonne;
	private String description;
	
	public Role() {}

	public int getRolePersonne() {
		return rolePersonne;
	}

	public void setRolePersonne(int rolePersonne) {
		this.rolePersonne = rolePersonne;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}	
	
	
			
}
