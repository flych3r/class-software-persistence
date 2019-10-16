package br.ufc.qxd.dsp.aula7.dao.jpa;

import br.ufc.qxd.dsp.aula7.dao.ContatoDAO;
import br.ufc.qxd.dsp.aula7.model.Contato;

public class ContatoJPADAO extends GenericJPADAO<Contato> implements ContatoDAO {

    public ContatoJPADAO() {
        super(Contato.class);
    }

}
