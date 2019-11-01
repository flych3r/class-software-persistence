package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@NamedQueries({
        @NamedQuery(name="Funcionario.findByNome",
                query="from Funcionario f where f.nome = ?1"),
})
public abstract class Funcionario {


    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "func_id")
    private Integer id;

    private String nome;

    private String sexo;

    @Temporal(TemporalType.DATE)
    private Calendar aniversario;

    private Double salario;

    @ManyToOne
    @JoinColumn(
            name = "dep_id",
            nullable = false
    )
    private Departamento departamento;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "funcionario"
    )
    private List<Dependente> dependentes = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "end_id",
            nullable = false
    )
    private Endereco endereco;

    public Funcionario() {
    }

    public Funcionario(String nome, String sexo, Calendar aniversario, Double salario,
                       Departamento departamento, List<Dependente> dependentes, Endereco endereco) {
        this.nome = nome;
        this.sexo = sexo;
        this.aniversario = aniversario;
        this.salario = salario;
        this.departamento = departamento;
        this.dependentes = dependentes;
        this.endereco = endereco;
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

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Calendar getAniversario() {
        return aniversario;
    }

    public void setAniversario(Calendar aniversario) {
        this.aniversario = aniversario;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Dependente> getDependentes() {
        return dependentes;
    }

    public void setDependentes(List<Dependente> dependentes) {
        this.dependentes = dependentes;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", aniversario=" + aniversario.getTime() +
                ", salario=" + salario +
                ", departamento=" + departamento +
                ", dependentes=" + dependentes +
                ", endereco=" + endereco +
                '}';
    }
}
