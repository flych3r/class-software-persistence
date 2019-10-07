package br.ufc.qxd.dsp.aula7;

import br.ufc.qxd.dsp.aula7.model.Contato;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JPA {
    public static void main(String[] args) {
        EntityManagerFactory managerFactory = Persistence.createEntityManagerFactory("dev");
        EntityManager manager = managerFactory.createEntityManager();
        EntityTransaction transaction = manager.getTransaction();

        try {
            transaction.begin();
            manager.persist(new Contato("Raimundo José Antônio", "(12) 3456-7890"));
            transaction.commit();
        } catch (Exception e) {
            transaction.rollback();
            e.printStackTrace();
        } finally {
            manager.close();
        }

        System.out.println("+===============================+");
        System.out.println("FIM - JPA");
    }
}
