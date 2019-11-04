package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import br.ufc.qxd.dsp.trabalho2.dao.EnderecoDAO;
import br.ufc.qxd.dsp.trabalho2.model.Endereco;

public class EnderecoJPADAO extends GenericJPADAO<Endereco> implements EnderecoDAO {

    public EnderecoJPADAO() {
        super(Endereco.class);
    }

}
