package br.ufc.qxd.dsp.aula7.dao;

import java.util.List;

public interface GenericDAO<T> {

    void save(T entity);
    void delete(T entity);
    T find(Object id);
    List<T> findAll();
    void beginTransaction();
    void commit();
    void rollBack();
    void close();

}
