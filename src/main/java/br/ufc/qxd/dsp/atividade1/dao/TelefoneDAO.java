package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Telefone;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class TelefoneDAO {

    public void create(Session session, Telefone telefone) {
        session.beginTransaction();
        session.save(telefone);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Telefone telefone = (Telefone) session.find(Telefone.class, id);

        session.beginTransaction();
        session.delete(telefone);
        session.getTransaction().commit();
    }

    public Telefone search(Session session, Long id) {
        Telefone telefone = (Telefone) session.find(Telefone.class, id);

        return telefone;
    }

    public void update(Session session, Telefone telefone) {
        session.beginTransaction();
        session.saveOrUpdate(telefone);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from telefone _c");

        List telefones = q.list();

        return telefones;
    }

}
