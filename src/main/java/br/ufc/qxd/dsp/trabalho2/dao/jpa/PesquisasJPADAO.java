package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import br.ufc.qxd.dsp.trabalho2.dao.PesquisasDAO;
import br.ufc.qxd.dsp.trabalho2.model.Pesquisas;

public class PesquisasJPADAO extends GenericJPADAO<Pesquisas> implements PesquisasDAO {

    public PesquisasJPADAO() {
        super(Pesquisas.class);
    }

}
