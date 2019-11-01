package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.PesquisasDAO;
import jpa.JPAUtil;
import model.Departamento;
import model.Funcionario;
import model.Pesquisas;
import model.Projeto;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PesquisasJPADAO extends GenericJPADAO<Pesquisas> implements PesquisasDAO {

    public PesquisasJPADAO() {
        super(Pesquisas.class);
    }

}
