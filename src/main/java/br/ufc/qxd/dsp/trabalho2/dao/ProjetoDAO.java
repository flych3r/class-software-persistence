package br.ufc.qxd.dsp.trabalho2.dao;

import br.ufc.qxd.dsp.trabalho2.model.Pesquisador;
import br.ufc.qxd.dsp.trabalho2.model.Projeto;

import java.util.List;

public interface ProjetoDAO extends GenericDAO<Projeto> {
    public List<Projeto> findPesquisadorPorProjeto(Pesquisador pesq);
}
