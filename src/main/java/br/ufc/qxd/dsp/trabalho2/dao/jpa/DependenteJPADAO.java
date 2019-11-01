package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.DependenteDAO;
import jpa.JPAUtil;
import model.Dependente;
import model.Funcionario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DependenteJPADAO extends GenericJPADAO<Dependente> implements DependenteDAO {

    public DependenteJPADAO() {
        super(Dependente.class);
    }

    @Override
    public List<Dependente> findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Dependente.findByNome");
        query.setParameter(1, nome);
        return query.getResultList();
    }

}
