package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Pesquisador;

import java.util.List;

public interface PesquisadorDAO extends FuncionarioDAO<Pesquisador> {
    List<Pesquisador> findByAtuacao(String atuacao);
}
