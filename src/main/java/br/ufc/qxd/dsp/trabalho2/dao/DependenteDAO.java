package br.ufc.qxd.dsp.trabalho2.dao;

import br.ufc.qxd.dsp.trabalho2.model.Dependente;

import java.util.List;

public interface DependenteDAO extends GenericDAO<Dependente> {
    List<Dependente> findByNome(String nome);
}
