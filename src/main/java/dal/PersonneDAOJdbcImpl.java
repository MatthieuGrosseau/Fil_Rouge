package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import bo.personnes.Personne;


public class PersonneDAOJdbcImpl implements PersonneDAO{
private DataSource dataSource;
	

	private final String SELECT_ALL = "SELECT * FROM personnes";
	private final String SELECT_BY_ID = "SELECT * FROM personnes WHERE noPersonne=?";
	private final String INSERT = "INSERT INTO personnes (rolePersonne, nom, prenom, age, adresseMail, numeroTelephone, motDePasse, adresse, cpo, ville) "
			+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private final String DELETE_BY_ID = "DELETE FROM personnes WHERE noPersonne=?";
	private final String UPDATE = "UPDATE personnes SET "
			+ "rolePersonne=? , nom=? , prenom=? , age=? , adresseMail=? , numeroTelephone=? , motDePasse=? , adresse=? , cpo=? , ville=? "
			+ "WHERE noPersonne=?";
	private final String SELECT_BY_CRITERE = "SELECT * FROM personnes WHERE nom LIKE ? OR prenom LIKE ? OR rolePersonne LIKE ?";
	private final String SELECT_BY_USER_AND_PWD = "SELECT * FROM personnes WHERE adresseMail = ? AND motDePasse = ?";
	
	public PersonneDAOJdbcImpl() {
		Context context;
		try {
			context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/admin");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Personne> selectAll() {
		List<Personne> resultat = new ArrayList<>();
		
		try {
			Connection cnx = dataSource.getConnection();
			PreparedStatement pst = cnx.prepareStatement(SELECT_ALL);
			ResultSet rs = pst.executeQuery();
			
			while(rs.next()) {
				Personne nouveauPersonne = new Personne();

				nouveauPersonne.setNoPersonne(rs.getInt("noPersonne"));
				nouveauPersonne.setRolePersonne(rs.getInt("RolePersonne"));
				nouveauPersonne.setNom(rs.getString("nom"));
				nouveauPersonne.setPrenom(rs.getString("prenom"));
				nouveauPersonne.setAge(rs.getInt("age"));
				nouveauPersonne.setAdresseMail(rs.getString("adresseMail"));
				nouveauPersonne.setNumeroTelephone(rs.getString("numeroTelephone"));
				nouveauPersonne.setMotDePasse(rs.getString("motDePasse"));
				nouveauPersonne.setAdresse(rs.getString("adresse"));
				nouveauPersonne.setCpo(rs.getInt("cpo"));
				nouveauPersonne.setVille(rs.getString("ville"));
				
				
				resultat.add(nouveauPersonne);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Personne selectById(int noPersonne) {
		Personne resultat = null;
		try {
			Connection cnx = dataSource.getConnection();
			
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_ID);
			pst.setInt(1, noPersonne);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				resultat = new Personne();
				resultat.setNoPersonne(rs.getInt("noPersonne"));
				resultat.setRolePersonne(rs.getInt("RolePersonne"));
				resultat.setNom(rs.getString("nom"));
				resultat.setPrenom(rs.getString("prenom"));
				resultat.setAge(rs.getInt("age"));
				resultat.setAdresseMail(rs.getString("adresseMail"));
				resultat.setNumeroTelephone(rs.getString("numeroTelephone"));
				resultat.setMotDePasse(rs.getString("motDePasse"));
				resultat.setAdresse(rs.getString("adresse"));
				resultat.setCpo(rs.getInt("cpo"));
				resultat.setVille(rs.getString("ville"));
			}
			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public void insert(Personne personne) {
		try {
			Connection cnx = dataSource.getConnection();
			PreparedStatement pst = cnx.prepareStatement(INSERT, PreparedStatement.RETURN_GENERATED_KEYS);
			pst.setInt(1, personne.getRolePersonne());
			pst.setString(2, personne.getNom());
			pst.setString(3, personne.getPrenom());
			pst.setInt(4, personne.getAge());
			pst.setString(5, personne.getAdresseMail());
			pst.setString(6, personne.getNumeroTelephone());
			pst.setString(7, personne.getMotDePasse());
			pst.setString(8, personne.getAdresse());
			pst.setInt(9, personne.getCpo());
			pst.setString(10, personne.getVille());
			

			pst.executeUpdate();
			
			ResultSet rs = pst.getGeneratedKeys();
			
			if (rs.next()) {
				personne.setNoPersonne(rs.getInt(1));
			}
			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Personne personne) {
		try {
			Connection cnx = dataSource.getConnection();
			PreparedStatement pst = cnx.prepareStatement(UPDATE);
			pst.setInt(1, personne.getRolePersonne());
			pst.setString(2, personne.getNom());
			pst.setString(3, personne.getPrenom());
			pst.setInt(4, personne.getAge());
			pst.setString(5, personne.getAdresseMail());
			pst.setString(6, personne.getNumeroTelephone());
			pst.setString(7, personne.getMotDePasse());
			pst.setString(8, personne.getAdresse());
			pst.setInt(9, personne.getCpo());
			pst.setString(10, personne.getVille());
			pst.setInt(11, personne.getNoPersonne());
			pst.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteById(int noPersonne) {
		try {
			Connection cnx = dataSource.getConnection();
			PreparedStatement pst = cnx.prepareStatement(DELETE_BY_ID);
			pst.setInt(1, noPersonne);
			pst.executeUpdate();
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Personne> selectByCritere(String critere) {
		List<Personne> resultat = new ArrayList<>();
		try {
			Connection cnx = dataSource.getConnection();
			
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_CRITERE);
			pst.setString(1, "%" + critere + "%");
			pst.setString(2, "%" + critere + "%");
			pst.setString(3, "%" + critere + "%");
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Personne nouveauPersonne = new Personne();
				nouveauPersonne.setNoPersonne(rs.getInt("noPersonne"));
				nouveauPersonne.setRolePersonne(rs.getInt("RolePersonne"));
				nouveauPersonne.setNom(rs.getString("nom"));
				nouveauPersonne.setPrenom(rs.getString("prenom"));
				nouveauPersonne.setAge(rs.getInt("age"));
				nouveauPersonne.setAdresseMail(rs.getString("adresseMail"));
				nouveauPersonne.setNumeroTelephone(rs.getString("numeroTelephone"));
				nouveauPersonne.setMotDePasse(rs.getString("motDePasse"));
				nouveauPersonne.setAdresse(rs.getString("adresse"));
				nouveauPersonne.setCpo(rs.getInt("cpo"));
				nouveauPersonne.setVille(rs.getString("ville"));
				resultat.add(nouveauPersonne);
			}
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}

	@Override
	public Personne selectByUserAndPassword(String adresseMail, String motDePasse) {
		Personne resultat = null;
		try {
			Connection cnx = dataSource.getConnection();
			
			PreparedStatement pst = cnx.prepareStatement(SELECT_BY_USER_AND_PWD);
			pst.setString(1, adresseMail);
			pst.setString(2, motDePasse);
			
			ResultSet rs = pst.executeQuery();
			
			if (rs.next()) {
				resultat = new Personne();
				resultat.setNoPersonne(rs.getInt("noPersonne"));
				resultat.setRolePersonne(rs.getInt("rolePersonne"));
				resultat.setNom(rs.getString("nom"));
				resultat.setPrenom(rs.getString("prenom"));				
				resultat.setAdresseMail(rs.getString("adresseMail"));
				resultat.setMotDePasse(rs.getString("motDePasse"));
			}
			
			cnx.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return resultat;
	}
	
}
