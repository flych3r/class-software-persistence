package br.ufc.qxd.dsp.trabalho3.dao;

import br.ufc.qxd.dsp.trabalho3.model.Departamento;
import br.ufc.qxd.dsp.trabalho3.model.Projeto;

import java.util.List;

public interface ProjetoDAO extends GenericDAO<Projeto> {
    List<Projeto> findByNomeList(String nome);
    Projeto findByNome(String nome);

    List<Departamento> findByNumeroDep(int numero);


}
