package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Departamento;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {
    List<Departamento> findAll();
    Departamento findDep(int numero, String nome);



}
