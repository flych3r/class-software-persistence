package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Pesquisador.findByAtuacao",
                query="from Pesquisador f where f.atuacao = ?1"),
})
public class Pesquisador extends Funcionario {

    private String atuacao;

    @OneToMany(mappedBy = "pesquisador")
    private List<Pesquisas> pesquisas;

    public Pesquisador() {
    }

    public Pesquisador(String nome, String sexo, Calendar aniversario, Double salario,
                       Departamento departamento, List<Dependente> dependentes, Endereco endereco, String atuacao) {
        super(nome, sexo, aniversario, salario, departamento, dependentes, endereco);
        this.atuacao = atuacao;
    }

    public String getAtuacao() {
        return atuacao;
    }

    public void setAtuacao(String atuacao) {
        this.atuacao = atuacao;
    }

    @Override
    public String toString() {
        return "Pesquisador{" +
                super.toString() +
                "atuacao='" + atuacao + '\'' +
                '}';
    }
}
