package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.PesquisadorDAO;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisador;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;

import java.util.List;

public class PesquisadorMorphiaDAO extends FuncionarioMorphiaDAO<Pesquisador> implements PesquisadorDAO {

    public PesquisadorMorphiaDAO() {
        super(Pesquisador.class);
    }

    @Override
    public List<Pesquisador> findByAtuacao(String atuacao) {
            List<Pesquisador> projs = MorphiaUtil.getDatastore().createQuery(Pesquisador.class)
                    .field("atuacao")
                    .contains(atuacao).asList();
            return projs;


    }
}
