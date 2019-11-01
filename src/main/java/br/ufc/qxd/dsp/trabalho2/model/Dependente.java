package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@NamedQueries({
        @NamedQuery(name="Dependente.findByNome",
                query="from Dependente d where d.nome = ?1"),
})
public class Dependente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fam_id")
    private Integer id;

    private String nome;

    private String sexo;

    @Temporal(TemporalType.DATE)
    private Calendar aniversario;

    private String grau;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(
            name = "func_id",
            nullable = false
    )
    private Funcionario funcionario;

    public Dependente() {
    }

    public Dependente(String nome, String sexo, Calendar aniversario, String grau, Funcionario funcionario) {
        this.nome = nome;
        this.sexo = sexo;
        this.aniversario = aniversario;
        this.grau = grau;
        this.funcionario = funcionario;
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

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    @Override
    public String toString() {
        return "Dependente{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sexo='" + sexo + '\'' +
                ", aniversario=" + aniversario +
                ", grau='" + grau + '\'' +
                ", funcionario=" + funcionario.getNome() +
                '}';
    }
}
