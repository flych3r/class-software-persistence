package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Cliente;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClienteDAO {

    public void create(Session session, Cliente cliente) {
        session.beginTransaction();
        session.save(cliente);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Cliente cliente = (Cliente) session.find(Cliente.class, id);

        session.beginTransaction();
        session.delete(cliente);
        session.getTransaction().commit();
    }

    public Cliente search(Session session, Long id) {
        Cliente cliente = (Cliente) session.find(Cliente.class, id);

        return cliente;
    }

    public void update(Session session, Cliente cliente) {
        session.beginTransaction();
        session.saveOrUpdate(cliente);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from cliente _c");

        List clientes = q.list();

        return clientes;
    }

}
