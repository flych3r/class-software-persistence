package br.ufc.qxd.dsp.aula6.dao;

import br.ufc.qxd.dsp.aula6.model.Telefone;

import java.util.List;

public interface TelefoneDAO extends GenericDAO<Telefone> {
	
	public List<Telefone> findByClientId(int id);
}
