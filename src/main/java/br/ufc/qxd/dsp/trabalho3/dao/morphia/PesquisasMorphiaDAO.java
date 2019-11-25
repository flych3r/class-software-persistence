package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.PesquisasDAO;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisador;
import br.ufc.qxd.dsp.trabalho3.model.Pesquisas;
import br.ufc.qxd.dsp.trabalho3.model.Projeto;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;

import java.util.List;

public class PesquisasMorphiaDAO extends GenericMorphiaDAO<Pesquisas> implements PesquisasDAO {

    public PesquisasMorphiaDAO() {
        super(Pesquisas.class);
    }

    @Override
    public List<Pesquisas> findByHoras(int horas) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("horas")
                .equal(horas).asList();
        return pesqs;
    }
    @Override
    public List<Pesquisas> findByProjeto(Projeto p) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("projeto")
                .equal(p).asList();
        return pesqs;
    }
    @Override
    public List<Pesquisas> findByPesquisador(Pesquisador p) {
        List<Pesquisas> pesqs= MorphiaUtil.getDatastore().createQuery(Pesquisas.class)
                .field("pesquisador")
                .equal(p).asList();
        return pesqs;
    }


}
