package bll;

import java.util.List;

import bo.personnes.Personne;
import dal.PersonneDAO;
import dal.PersonneDAOJdbcImpl;


public class PersonneBLL {
private PersonneDAO daoPersonne;
	
	public PersonneBLL() {
		daoPersonne = new PersonneDAOJdbcImpl();
	}
	
	public List<Personne> selectAll() {
		return daoPersonne.selectAll();
	}
	
	public Personne selectById(int id) {
		return daoPersonne.selectById(id);
	}
	

	public void insert(Personne personne) throws Exception {
		verifierContraintes(personne);
		daoPersonne.insert(personne);
	}
	
	public void update(Personne personne) throws Exception {
		verifierContraintes(personne);
		daoPersonne.update(personne);
	}
	
	public void deleteById(int noPersonne) {
		daoPersonne.deleteById(noPersonne);
	}

	public List<Personne> selectByCritere(String critere) {
		return daoPersonne.selectByCritere(critere);
	}
	
	public Personne selectByUsernameAndPassword(String adresseMail, String motDePasse) {
		return daoPersonne.selectByUserAndPassword(adresseMail, motDePasse);
	}
	
	private void verifierContraintes(Personne personne) throws Exception {

		if (personne.getRolePersonne() > 3) {
			throw new Exception("La contrainte sur le gérant n'est pas respectée");
		}
		
	}

			
}
