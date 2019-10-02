package br.ufc.qxd.dsp.aula6.dao.jdbc;

import br.ufc.qxd.dsp.aula6.connection.ConnectionFactory;
import br.ufc.qxd.dsp.aula6.dao.GenericDAO;
import br.ufc.qxd.dsp.aula6.model.Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public abstract class GenericJDBCDAO <T extends Bean> implements GenericDAO<T> {
	
	protected Connection connection;
	protected String tableName;
	
	public GenericJDBCDAO(String tableName) {
		this.connection = ConnectionFactory.getConnection();
		this.tableName = tableName;
	}
	
	protected abstract T fromResultSet(ResultSet rs) throws SQLException;
	protected abstract PreparedStatement prepareToInsert(T t) throws SQLException;
	
	@Override
	public void insert(T c) {
		try {
			PreparedStatement stmt = this.prepareToInsert(c);
			stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next()) c.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(T c) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean delete(T c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public T findById() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public List<T> findAll() {
		try {		
			List<T> l = new ArrayList<T>();
			String sql = "select * from " + tableName;
			PreparedStatement stmt;
			stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				l.add(this.fromResultSet(rs));
			}
			return l;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void closeConnection() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
