package br.ufc.qxd.dsp.aula7.dao.jpa;

import br.ufc.qxd.dsp.aula7.dao.ContatoDAO;
import br.ufc.qxd.dsp.aula7.jpa.JPAUtil;
import br.ufc.qxd.dsp.aula7.model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class ContatoJPADAO extends GenericJPADAO<Contato> implements ContatoDAO {

    public ContatoJPADAO() {
        super(Contato.class);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contato> findByName(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createNamedQuery("Contato.findByName");
        query.setParameter("nome", nome);
        return query.getResultList();
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<Contato> findByNamePart(String nome) {
        EntityManager em = JPAUtil.getEntityManager();
        Query query = em.createQuery("select c from Contato c where c.nome like :nome");
        query.setParameter("nome", nome+"%");
        return query.getResultList();
    }
}
