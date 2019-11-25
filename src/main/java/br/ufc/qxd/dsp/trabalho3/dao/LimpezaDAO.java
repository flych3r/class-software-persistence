package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Limpeza;

import java.util.List;

public interface LimpezaDAO extends FuncionarioDAO<Limpeza> {
     List<Limpeza> findByCargo(String cargo);
     List<Limpeza> JornadaLimite(int horas);
     List<Limpeza> SupervisorList();
}

