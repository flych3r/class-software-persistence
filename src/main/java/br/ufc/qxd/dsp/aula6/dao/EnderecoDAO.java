package br.ufc.qxd.dsp.aula6.dao;

import br.ufc.qxd.dsp.aula6.model.Endereco;

import java.util.List;

public interface EnderecoDAO extends GenericDAO<Endereco> {
	
	public List<Endereco> findByClientId(int id);
}
