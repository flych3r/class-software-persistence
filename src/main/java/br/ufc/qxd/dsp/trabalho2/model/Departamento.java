package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@NamedQueries({
        @NamedQuery(name="Departamento.findByNome",
                query="from Departamento d where d.nome = ?1"),
        @NamedQuery(name="Departamento.findByNumero",
                query="from Departamento d where d.numero = ?1")
})
public class Departamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dep_id")
    private Integer id;

    private String nome;
    private Integer numero;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "departamento"
    )
    private List<Projeto> projetos = new ArrayList<>();

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "departamento"
    )
    private List<Funcionario> funcionarios = new ArrayList<>();

    public Departamento() {
    }

    public Departamento(String nome, Integer numero, List<Projeto> projetos, List<Funcionario> funcionarios) {
        this.nome = nome;
        this.numero = numero;
        this.projetos = projetos;
        this.funcionarios = funcionarios;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public List<Projeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<Projeto> projetos) {
        this.projetos = projetos;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(List<Funcionario> funcionarios) {
        this.funcionarios = funcionarios;
    }

    @Override
    public String toString() {
        return "Departamento{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                '}';
    }
}
