package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
public class Limpeza extends Funcionario {

    private String cargo;

    private Integer jornada;

    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "supervisor_id")
    private Funcionario supervisor;

    @OneToMany(mappedBy = "supervisor")
    private Set<Limpeza> subordinados;

    public Limpeza() {
    }

    public Limpeza(String nome, String sexo, Calendar aniversario, Double salario,
                   Departamento departamento, List<Dependente> dependentes, Endereco endereco,
                   String cargo, Integer jornada, Funcionario supervisor, Set<Limpeza> subordinados) {
        super(nome, sexo, aniversario, salario, departamento, dependentes, endereco);
        this.cargo = cargo;
        this.jornada = jornada;
        this.supervisor = supervisor;
        this.subordinados = subordinados;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Integer getJornada() {
        return jornada;
    }

    public void setJornada(Integer jornada) {
        this.jornada = jornada;
    }

    public Funcionario getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(Funcionario supervisor) {
        this.supervisor = supervisor;
    }

    public Set<Limpeza> getSubordinados() {
        return subordinados;
    }

    public void setSubordinados(Set<Limpeza> subordinados) {
        this.subordinados = subordinados;
    }

    @Override
    public String toString() {
        return "Limpeza{" +
                super.toString() +
                "cargo='" + cargo + '\'' +
                ", jornada=" + jornada +
                ", supervisor=" + supervisor +
                ", subordinados=" + subordinados +
                '}';
    }
}
