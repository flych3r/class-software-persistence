package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;

@Entity
public class Projeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "proj_id")
    private Integer id;

    private String nome;

    private Integer numero;

    @Temporal(TemporalType.DATE)
    private Calendar dataInicio;

    @Temporal(TemporalType.DATE)
    private Calendar dataFim;

    @ManyToOne
    @JoinColumn(
            name = "dep_id",
            nullable = false
    )
    private Departamento departamento;

    @OneToMany(mappedBy = "projeto")
    private List<Pesquisas> pesquisas;

    public Projeto() {
    }

    public Projeto(String nome, Integer numero, Calendar dataInicio, Calendar dataFim, Departamento departamento) {
        this.nome = nome;
        this.numero = numero;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.departamento = departamento;
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

    public Calendar getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Calendar dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Calendar getDataFim() {
        return dataFim;
    }

    public void setDataFim(Calendar dataFim) {
        this.dataFim = dataFim;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return "Projeto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", numero=" + numero +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", departamento=" + departamento +
                '}';
    }
}
