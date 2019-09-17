package br.ufc.qxd.dsp.atividade1.dao;

import br.ufc.qxd.dsp.atividade1.entity.Endereco;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class EnderecoDAO {

    public void create(Session session, Endereco endereco) {
        session.beginTransaction();
        session.save(endereco);
        session.getTransaction().commit();
    }

    public void delete(Session session, Long id) {
        Endereco endereco = (Endereco) session.find(Endereco.class, id);

        session.beginTransaction();
        session.delete(endereco);
        session.getTransaction().commit();
    }

    public Endereco search(Session session, Long id) {
        Endereco endereco = (Endereco) session.find(Endereco.class, id);

        return endereco;
    }

    public void update(Session session, Endereco endereco) {
        session.beginTransaction();
        session.saveOrUpdate(endereco);
        session.getTransaction().commit();
    }

    public List read(Session session) {
        Query q = session.createQuery("select _c from endereco _c");

        List enderecos = q.list();

        return enderecos;
    }


}
