package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Dependente;
import br.ufc.qxd.dsp.trabalho3.model.Funcionario;

import java.util.List;

public interface FuncionarioDAO<T> extends GenericDAO<T> {
    Funcionario findByNome(String nome, Class<T> tClass);
    List<Funcionario> SalarioMaiorQ(Double salario, Class<T> tClass);
    Dependente AddDependente();
}
