package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.PesquisadorDAO;
import jpa.JPAUtil;
import model.*;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PesquisadorJPADAO extends FuncionarioJPADAO<Pesquisador> implements PesquisadorDAO {

    public PesquisadorJPADAO() {
        super(Pesquisador.class);
    }



    @Override
    public List<Pesquisador> findByAtuacao(String atuacao) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Pesquisador.findByAtuacao");
        query.setParameter(1, atuacao);
        return query.getResultList();
    }



    @Override
    public List<Projeto> findProjetoByNome(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT p FROM Projeto p"
                + "  WHERE p.nome = ?1");
        query.setParameter(1, nome);
        return query.getResultList();
    }

}


