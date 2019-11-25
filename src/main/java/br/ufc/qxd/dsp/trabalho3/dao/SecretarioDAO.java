package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Secretario;

import java.util.List;

public interface SecretarioDAO extends FuncionarioDAO<Secretario> {
    List<Secretario> findByEscolaridade(String escolaridade);
}
