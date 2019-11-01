package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.ProjetoDAO;
import jpa.JPAUtil;
import model.Pesquisador;
import model.Projeto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ProjetoJPADAO extends GenericJPADAO<Projeto> implements ProjetoDAO {

    public ProjetoJPADAO() {
        super(Projeto.class);
    }

    @Override
    public List<Projeto> findPesquisadorPorProjeto(Pesquisador pesq) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("SELECT f FROM Projeto f, Pesquisador p, Pesquisas pe"
                + " WHERE f.id_proj = pe.id_proj AND pe.id_pesq = p.id_pesq AND p.id_pesq = ?1");
        query.setParameter(1, pesq.getId());
        return query.getResultList();
    }

}
