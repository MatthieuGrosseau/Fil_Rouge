package bll;

import java.util.List;

import bo.Jointure;
import dal.JointureDAO;
import dal.JointureDAOJdbcImpl;



public class JointureBLL {
	private JointureDAO dao;
	
	public JointureBLL() {
		dao = new JointureDAOJdbcImpl();
	}
	
	public List<Jointure> selectAll() {
		return dao.selectAll();
	}
}
