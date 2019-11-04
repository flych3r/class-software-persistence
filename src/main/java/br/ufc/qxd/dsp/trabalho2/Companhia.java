package br.ufc.qxd.dsp.trabalho2;


import br.ufc.qxd.dsp.trabalho2.dao.DepartamentoDAO;
import br.ufc.qxd.dsp.trabalho2.dao.PesquisadorDAO;
import br.ufc.qxd.dsp.trabalho2.dao.jpa.DepartamendoJPADAO;
import br.ufc.qxd.dsp.trabalho2.dao.jpa.PesquisadorJPADAO;
import br.ufc.qxd.dsp.trabalho2.model.Departamento;
import br.ufc.qxd.dsp.trabalho2.model.Funcionario;
import br.ufc.qxd.dsp.trabalho2.util.Menu;

import javax.persistence.PersistenceException;
import java.text.ParseException;
import java.util.Calendar;
import java.util.List;

public class Companhia {


    public static void addFuncionario() {


    }

    public static void buscar(String nome) {
        PesquisadorDAO pDAO = new PesquisadorJPADAO();

        List<Funcionario> pesqs = pDAO.findByNome(nome);

        for(Funcionario f: pesqs) {
            System.out.println(f);
        }

    }

    public static void buscar1() {
        DepartamentoDAO dDAO = new DepartamendoJPADAO();

        Departamento dep = dDAO.find(1);

            System.out.println(dep);


    }


    public static void main(String[] args) throws ParseException {
//        JPAUtil.getEntityManager();
//        JPAUtil.closeEntityManager();

         //addFuncionario();
//        buscar1();
//        buscar("xavier");

        Menu menu = new Menu();
        menu.chamaMenu();

    }

}
