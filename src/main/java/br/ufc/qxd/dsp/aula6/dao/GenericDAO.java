package br.ufc.qxd.dsp.aula6.dao;

import br.ufc.qxd.dsp.aula6.model.Bean;

import java.util.List;

public interface GenericDAO<T extends Bean> {

    void insert(T c);

    void update(T c);

    boolean delete(T c);

    boolean delete(int id);

    T findById(int id);

    List<T> findAll();

    void closeConnection();

}
