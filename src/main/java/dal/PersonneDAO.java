package dal;

import java.util.List;

import bo.personnes.Personne;

public interface PersonneDAO {

	List<Personne> selectAll();

	Personne selectById(int noPersonne);

	void insert(Personne personne);

	void deleteById(int NoPersonne);

	void update(Personne personne);

	List<Personne> selectByCritere(String critere);

	Personne selectByUserAndPassword(String adresseMail, String motDePasse);
	
}
