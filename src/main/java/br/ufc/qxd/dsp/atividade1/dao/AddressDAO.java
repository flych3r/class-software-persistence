package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class AddressDAO {

    public void create(Session session, Address address) {
        session.beginTransaction();
        session.save(address);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Address address = (Address) session.find(Address.class, id);

        session.beginTransaction();
        session.delete(address);
        session.getTransaction().commit();
    }

    public Address search(Session session, Long id) {
        Address address = (Address) session.find(Address.class, id);

        return address;
    }

    public void update(Session session, Address address) {
        session.beginTransaction();
        session.saveOrUpdate(address);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from endereco _c");

        List enderecos = q.list();

        return enderecos;
    }


}
