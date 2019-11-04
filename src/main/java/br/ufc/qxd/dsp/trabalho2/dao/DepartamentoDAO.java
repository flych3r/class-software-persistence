package br.ufc.qxd.dsp.trabalho2.dao;

import br.ufc.qxd.dsp.trabalho2.model.Departamento;
import br.ufc.qxd.dsp.trabalho2.model.Funcionario;
import br.ufc.qxd.dsp.trabalho2.model.Projeto;

import java.util.List;

public interface DepartamentoDAO extends GenericDAO<Departamento> {

    List<Departamento> findByNome(String nome);
    List<Departamento> findByNumero(Integer numero);
    List<Funcionario> findFuncionarios(Departamento dep);
    List<Projeto> findProjetos(Departamento dep);
}
