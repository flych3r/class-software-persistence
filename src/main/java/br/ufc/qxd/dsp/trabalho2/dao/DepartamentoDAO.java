package br.ufc.qxd.dsp.trabalho2.dao;

import model.Departamento;
import model.Funcionario;
import model.Projeto;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {

    List<Departamento> findByNome(String nome);
    List<Departamento> findByNumero(Integer numero);
    List<Funcionario> findFuncionarios(Departamento dep);
    List<Projeto> findProjetos(Departamento dep);
}
