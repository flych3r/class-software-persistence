package br.ufc.qxd.dsp.trabalho2.dao;

import model.Limpeza;
import model.Pesquisador;

import java.util.List;

public interface LimpezaDAO extends FuncionarioDAO<Limpeza> {
    public List<Limpeza> findByCargo(String cargo);
    public List<Pesquisador> findByJornada(Integer num);
}

