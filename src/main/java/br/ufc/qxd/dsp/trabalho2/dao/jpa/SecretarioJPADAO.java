package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import br.ufc.qxd.dsp.trabalho2.dao.SecretarioDAO;
import br.ufc.qxd.dsp.trabalho2.model.Secretario;

public class SecretarioJPADAO extends FuncionarioJPADAO<Secretario> implements SecretarioDAO {

    public SecretarioJPADAO() {
        super(Secretario.class);
    }


}
