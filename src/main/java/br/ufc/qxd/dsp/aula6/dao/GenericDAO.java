package br.ufc.qxd.dsp.aula6.dao;

import br.ufc.qxd.dsp.aula6.model.Bean;

import java.util.List;

public interface GenericDAO <T extends Bean> {
	
	public void insert(T c);
	public void update(T c);
	public boolean delete(T c);
	public boolean delete(int id);
	public T findById();
	public List<T> findAll();
	public void closeConnection();

}
