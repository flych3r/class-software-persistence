package br.ufc.qxd.dsp.trabalho2.dao;

import br.ufc.qxd.dsp.trabalho2.model.Dependente;
import br.ufc.qxd.dsp.trabalho2.model.Funcionario;

import java.util.List;

public interface FuncionarioDAO<T> extends GenericDAO<T> {

    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByParteNome(String nome);
    List<Dependente> findDependentes(Funcionario func);
    Funcionario findNome(String nome) ;


    }
