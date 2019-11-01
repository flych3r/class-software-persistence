package br.ufc.qxd.dsp.trabalho2.dao;

import model.Pesquisador;
import model.Projeto;

import java.util.List;

public interface PesquisadorDAO extends FuncionarioDAO<Pesquisador> {
    public List<Pesquisador> findByAtuacao(String atuacao);
    public List<Projeto> findProjetoByNome(String nome);
}
