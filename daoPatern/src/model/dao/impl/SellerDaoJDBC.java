package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class SellerDaoJDBC implements SellerDao {
	
	private Connection conn;
	
	public SellerDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Seller obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteByID(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Seller findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*,department.name as 'DepNmame' FROM seller "
					+ "INNER JOIN department "
					+ "ON seller.DepartmentId = department.id "
					+ "where seller.id = ?;");
			st.setInt(1, id);
			rs = st.executeQuery();
			
			if(rs.next()) {
				Department dep = new Department(rs.getInt("DepartmentId"), rs.getString("DepNmame"));
				Seller obj = new Seller(rs.getInt("Id"),
										rs.getString("Name"),
										rs.getString("Email"),
										rs.getDate("BirthDate"),
										rs.getDouble("BaseSalary"),
										dep);
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatment(st);
			DB.closeResultSet(rs);
		}
		
	}

	@Override
	public List<Seller> findall() {
		// TODO Auto-generated method stub
		return null;
	}

}
