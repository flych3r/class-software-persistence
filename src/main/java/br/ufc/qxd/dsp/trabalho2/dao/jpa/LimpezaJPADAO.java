package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import br.ufc.qxd.dsp.trabalho2.dao.LimpezaDAO;
import br.ufc.qxd.dsp.trabalho2.jpa.JPAUtil;
import br.ufc.qxd.dsp.trabalho2.model.Limpeza;
import br.ufc.qxd.dsp.trabalho2.model.Pesquisador;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class LimpezaJPADAO extends FuncionarioJPADAO<Limpeza> implements LimpezaDAO {

    public LimpezaJPADAO() {
        super(Limpeza.class);
    }

    @Override
    public List<Pesquisador> findByJornada(Integer num) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Limpeza p"
                + "  WHERE p.jornada = ?1");
        query.setParameter(1, num);
        return query.getResultList();
    }



    @Override
    public List<Limpeza> findByCargo(String cargo) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Limpeza p"
                + "  WHERE p.cargo = ?1");
        query.setParameter(1, cargo);
        return query.getResultList();
    }
}
