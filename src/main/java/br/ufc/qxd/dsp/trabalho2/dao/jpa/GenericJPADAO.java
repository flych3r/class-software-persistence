package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.GenericDAO;
import jpa.JPAUtil;

import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class GenericJPADAO<T> implements GenericDAO<T> {

    private Class<T> persistenceClass;

    public GenericJPADAO(Class<T> persistenceClass) {
        this.persistenceClass = persistenceClass;
    }

    @Override
    public void save(Object entity) {
        JPAUtil.getEntityManager().merge(entity);
    }

    @Override
    public void delete(Object entity) {
        JPAUtil.getEntityManager().remove(JPAUtil.getEntityManager().merge(entity));
    }

    @Override
    public T find(Object id) {
        return JPAUtil.getEntityManager().find(persistenceClass, id);
    }

    @Override
    public List findAll() {
        CriteriaQuery<T> cq = JPAUtil.getEntityManager().getCriteriaBuilder().createQuery(persistenceClass);
        cq.from(persistenceClass);
        return JPAUtil.getEntityManager().createQuery(cq).getResultList();
    }

    @Override
    public void beginTransaction() {
        JPAUtil.beginTransaction();
    }

    @Override
    public void commit() {
        JPAUtil.commit();
    }

    @Override
    public void rollBack() {
        JPAUtil.rollback();
    }

    @Override
    public void close() {
        JPAUtil.closeEntityManager();
    }
}
