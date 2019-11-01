package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.Entity;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
public class Secretario extends Funcionario {

    private String escolaridade;

    public Secretario() {
    }

    public Secretario(String nome, String sexo, Calendar aniversario, Double salario,
                      Departamento departamento, List<Dependente> dependentes, Endereco endereco, String escolaridade) {

        super(nome, sexo, aniversario, salario, departamento, dependentes, endereco);
        this.escolaridade = escolaridade;
    }

    public String getEscolaridade() {
        return escolaridade;
    }

    public void setEscolaridade(String escolaridade) {
        this.escolaridade = escolaridade;
    }

    @Override
    public String toString() {
        return "Secretario{" +
                super.toString() +
                "escolaridade='" + escolaridade + '\'' +
                '}';
    }
}
