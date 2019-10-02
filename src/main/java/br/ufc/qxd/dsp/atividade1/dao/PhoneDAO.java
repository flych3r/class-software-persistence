package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Phone;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PhoneDAO {

    public void create(Session session, Phone phone) {
        session.beginTransaction();
        session.save(phone);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Phone phone = (Phone) session.find(Phone.class, id);

        session.beginTransaction();
        session.delete(phone);
        session.getTransaction().commit();
    }

    public Phone search(Session session, Long id) {
        Phone phone = (Phone) session.find(Phone.class, id);

        return phone;
    }

    public void update(Session session, Phone phone) {
        session.beginTransaction();
        session.saveOrUpdate(phone);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from telefone _c");

        List telefones = q.list();

        return telefones;
    }

}
