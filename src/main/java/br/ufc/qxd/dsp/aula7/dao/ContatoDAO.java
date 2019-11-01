package br.ufc.qxd.dsp.aula7.dao;

import br.ufc.qxd.dsp.aula7.model.Contato;

import java.util.List;

public interface ContatoDAO extends GenericDAO<Contato> {

    List<Contato> findByName(String nome);
    List<Contato> findByNamePart(String nome);

}
