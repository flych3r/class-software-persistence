package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.DepartamentoDAO;
import br.ufc.qxd.dsp.trabalho3.model.Departamento;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;
import org.mongodb.morphia.query.Query;

import java.util.List;

public class DepartamentoMorphiaDAO extends GenericMorphiaDAO<Departamento> implements DepartamentoDAO {

    public DepartamentoMorphiaDAO() {
        super(Departamento.class);
    }
    @Override
    public List<Departamento> findAll() {
        List<Departamento> deps = MorphiaUtil.getDatastore().createQuery(Departamento.class).asList();
        return deps;
    }
    @Override
    public Departamento findDep(int numero, String nome) {
        Query<Departamento> dep = MorphiaUtil.getDatastore().createQuery(Departamento.class)
                .field("nome").contains(nome)
                .filter("numero" , numero);
        return dep.get();

    }


}
