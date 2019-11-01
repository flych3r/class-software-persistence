package br.ufc.qxd.dsp.trabalho2.dao;

import model.Dependente;
import model.Funcionario;

import java.util.List;

public interface FuncionarioDAO<T> extends GenericDAO<T> {

    List<Funcionario> findByNome(String nome);
    List<Funcionario> findByParteNome(String nome);
    List<Dependente> findDependentes(Funcionario func);
    Funcionario findNome(String nome) ;


    }
