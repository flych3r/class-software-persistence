package br.ufc.qxd.dsp.aula9.dao;

import br.ufc.qxd.dsp.aula9.model.User;

import java.util.List;


public interface UserDAO {

	public void insert(User user);
	
	public void update(User user);
	
	public void delete(User user);
	
	public void delete(Object id);
	
	public User find(Object id);
	
	public List<User> findAll();
	
	public void close();
}
