package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements  DepartmentDao{
	
	private Connection conn = null;
	
	public DepartmentDaoJDBC(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void insert(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Department obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department findByid(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = conn.prepareStatement("Select id, Name from department where id = ?");
			st.setInt(1, id);
			rs = st.executeQuery();
			rs.next();
			int _id = rs.getInt("id");
			String _name = rs.getString("Name");
			Department department = new Department(rs.getInt(1),rs.getString(2));
			return department;
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
		}finally{
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
				
		
	}

	@Override
	public List<Department> findAll() {
		Statement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery("Select id, Name from department Order by Name");
			List<Department> listDepartment = new ArrayList<>();
			
			while (rs.next()) {
				Department department = new Department(rs.getInt(1), rs.getString(2));
				listDepartment.add(department);
			}
			return listDepartment;
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}

}
