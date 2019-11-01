package br.ufc.qxd.dsp.trabalho2.dao.jpa;

import dao.SecretarioDAO;
import jpa.JPAUtil;
import model.Funcionario;
import model.Secretario;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class SecretarioJPADAO extends FuncionarioJPADAO<Secretario> implements SecretarioDAO {

    public SecretarioJPADAO() {
        super(Secretario.class);
    }


}
