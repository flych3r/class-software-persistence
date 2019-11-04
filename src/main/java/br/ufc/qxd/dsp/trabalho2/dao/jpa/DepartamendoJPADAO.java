package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import br.ufc.qxd.dsp.trabalho2.dao.DepartamentoDAO;
import br.ufc.qxd.dsp.trabalho2.jpa.JPAUtil;
import br.ufc.qxd.dsp.trabalho2.model.Departamento;
import br.ufc.qxd.dsp.trabalho2.model.Funcionario;
import br.ufc.qxd.dsp.trabalho2.model.Projeto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DepartamendoJPADAO extends GenericJPADAO<Departamento> implements DepartamentoDAO {

    public DepartamendoJPADAO() {
        super(Departamento.class);
    }

    @Override
    public List<Departamento> findByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Departamento.findByNome");
        query.setParameter(1, nome);
        return query.getResultList();
    }

    @Override
    public List<Departamento> findByNumero(Integer numero) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Departamento.findByNumero");
        query.setParameter(1, numero);
        return query.getResultList();
    }

    @Override
    public List<Funcionario> findFuncionarios(Departamento dep) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT f FROM Funcionario f"
                + " WHERE f.departamento = ?1");
        query.setParameter(1, dep);
        return query.getResultList();
    }

    @Override
    public List<Projeto> findProjetos(Departamento dep) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Projeto p"
                + "  WHERE p.departamento = ?1");
        query.setParameter(1, dep);
        return query.getResultList();
    }
}
