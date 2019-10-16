package br.ufc.qxd.dsp.aula7;

import br.ufc.qxd.dsp.aula7.dao.ContatoDAO;
import br.ufc.qxd.dsp.aula7.dao.jpa.ContatoJPADAO;
import br.ufc.qxd.dsp.aula7.model.Contato;

import javax.persistence.*;
import java.util.List;

public class JPA {

    public static void insertDAO() {
        ContatoDAO cDAO = new ContatoJPADAO();
        try {
            cDAO.beginTransaction();
            cDAO.save(new Contato("Ronaldo", "999"));
            cDAO.save(new Contato("Mary", "100"));
            cDAO.save(new Contato("Junior", "333"));
            cDAO.commit();
        } catch (IllegalStateException | PersistenceException e) {
            cDAO.rollBack();
        } finally {
            cDAO.close();
        }
        System.out.println("+++++++++++++++++++++++++++++");
    }

    public static void deleteDAO() {
        ContatoDAO cDAO = new ContatoJPADAO();
        try {
            cDAO.beginTransaction();
            Contato c = cDAO.find(1);
            cDAO.delete(c);
            cDAO.close();
            cDAO.commit();
            System.out.println(c);
        } catch (IllegalStateException | PersistenceException e) {
            cDAO.rollBack();
        } finally {
            cDAO.close();
        }
        System.out.println("----------------------------");
    }

    public static void searchDAO() {
        ContatoDAO cDAO = new ContatoJPADAO();
        List<Contato> contatos = cDAO.findAll();
        cDAO.close();

        for(Contato c: contatos)
            System.out.println(c);

        System.out.println("****************************");
    }

    public static void main(String[] args) {

//        insertDAO();
//        deleteDAO();
        searchDAO();

        System.out.println("+===============================+");
        System.out.println("FIM - JPA");
    }
}
