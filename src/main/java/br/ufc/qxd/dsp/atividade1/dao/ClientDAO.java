package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Client;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class ClientDAO {

    public void create(Session session, Client client) {
        session.beginTransaction();
        session.save(client);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Client client = (Client) session.find(Client.class, id);

        session.beginTransaction();
        session.delete(client);
        session.getTransaction().commit();
    }

    public Client search(Session session, Long id) {
        Client client = (Client) session.find(Client.class, id);

        return client;
    }

    public void update(Session session, Client client) {
        session.beginTransaction();
        session.saveOrUpdate(client);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from cliente _c");

        List clientes = q.list();

        return clientes;
    }

}
