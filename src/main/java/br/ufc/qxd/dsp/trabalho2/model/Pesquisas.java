package br.ufc.qxd.dsp.trabalho2.model;

import javax.persistence.*;

@Entity
public class Pesquisas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pesq_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "proj_id")
    private Projeto projeto;

    @ManyToOne
    @JoinColumn(name = "func_id")
    private Pesquisador pesquisador;

    private Integer horas;

    public Pesquisas(Projeto projeto, Pesquisador pesquisador, Integer horas) {
        this.projeto = projeto;
        this.pesquisador = pesquisador;
        this.horas = horas;
    }

    public Pesquisas() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Pesquisador getPesquisador() {
        return pesquisador;
    }

    public void setPesquisador(Pesquisador pesquisador) {
        this.pesquisador = pesquisador;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }

    @Override
    public String toString() {
        return "Pesquisas{" +
                "id=" + id +
                ", projeto=" + projeto +
                ", pesquisador=" + pesquisador +
                ", horas=" + horas +
                '}';
    }
}
