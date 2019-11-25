package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.LimpezaDAO;
import br.ufc.qxd.dsp.trabalho3.model.Limpeza;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;

import java.util.List;

public class LimpezaMorphiaDAO extends FuncionarioMorphiaDAO<Limpeza> implements LimpezaDAO {

    public LimpezaMorphiaDAO() {
        super(Limpeza.class);
    }

    @Override
    public List<Limpeza> findByCargo(String cargo){
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .field("cargo")
                .contains(cargo).asList();
        return limps;
    }

    @Override
    public List<Limpeza> JornadaLimite(int horas) {
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .field("horas")
                .equal(horas).asList();
        return limps;
    }

    @Override
    public List<Limpeza> SupervisorList() {
        List<Limpeza> limps = MorphiaUtil.getDatastore().createQuery(Limpeza.class)
                .filter("supervisor", true).asList();
        return limps;
    }

}
