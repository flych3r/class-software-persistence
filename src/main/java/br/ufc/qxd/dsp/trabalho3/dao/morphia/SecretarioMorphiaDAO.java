package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.SecretarioDAO;
import br.ufc.qxd.dsp.trabalho3.model.Secretario;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;

import java.util.List;

public class SecretarioMorphiaDAO extends FuncionarioMorphiaDAO<Secretario> implements SecretarioDAO {

    public SecretarioMorphiaDAO() {
        super(Secretario.class);
    }


    @Override
    public List<Secretario> findByEscolaridade(String escolaridade) {
            List<Secretario> secs = MorphiaUtil.getDatastore().createQuery(Secretario.class)
                    .field("escolaridade")
                    .equal(escolaridade).asList();
            return secs;

        }

}
