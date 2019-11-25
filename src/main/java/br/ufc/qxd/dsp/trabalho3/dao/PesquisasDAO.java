package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Pesquisador;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisas;
import br.ufc.qxd.dsp.trabalho3.model.Projeto;

import java.util.List;

public interface PesquisasDAO extends GenericDAO<Pesquisas> {
    List<Pesquisas> findByHoras(int horas);
    List<Pesquisas> findByProjeto(Projeto p);
    List<Pesquisas> findByPesquisador(Pesquisador p);

}
