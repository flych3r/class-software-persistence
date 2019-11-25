package br.ufc.qxd.dsp.trabalho3.dao.morphia;

import br.ufc.qxd.dsp.trabalho3.dao.FuncionarioDAO;
import br.ufc.qxd.dsp.trabalho3.model.Dependente;
import br.ufc.qxd.dsp.trabalho3.model.Funcionario;
import br.ufc.qxd.dsp.trabalho3.morphia.MorphiaUtil;

import javax.swing.*;
import java.util.Date;
import java.util.List;

public class FuncionarioMorphiaDAO<T> extends GenericMorphiaDAO<T> implements FuncionarioDAO<T> {

    public FuncionarioMorphiaDAO(Class<T> persistenceClass) {
        super(persistenceClass);
    }
        @Override
       public Funcionario findByNome(String nome, Class<T> tClass){
            Funcionario funcs = (Funcionario) MorphiaUtil.getDatastore().createQuery(tClass)
                    .field("nome")
                    .contains(nome).get();
            return funcs;

        }

    @Override
    public List<Funcionario> SalarioMaiorQ(Double salario, Class<T> tClass) {
        List<Funcionario> funcs = (List<Funcionario>) MorphiaUtil.getDatastore().createQuery(tClass)
                .field("salario")
                .greaterThanOrEq(salario).asList();
        return funcs;

    }

    @Override
    public Dependente AddDependente(){

            JLabel title = new JLabel("Cadastro Dependente");
            JTextField nome = new JTextField();
            JTextField sexo = new JTextField();
            JTextField aniversario = new JTextField();
            JTextField grau = new JTextField();
            final JComponent[] inputs = new JComponent[] {
                    title,
                    new JLabel("Nome"),
                    nome,
                    new JLabel("Sexo"),
                    sexo,
                    new JLabel("Aniversario"),
                    aniversario,
                    new JLabel("Grau"),
                    grau
            };
            JOptionPane.showMessageDialog(null, inputs, "Cadastro", JOptionPane.PLAIN_MESSAGE);
            Date c = new Date(aniversario.getText());
            Dependente d = new Dependente(nome.getText(), sexo.getText(), c, grau.getText());
            return d ;
        }
    }




