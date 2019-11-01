package br.ufc.qxd.dsp.aula7.model;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Contato.findAll", query = "from Contato"),
        @NamedQuery(name = "Contato.findByName", query = "from Contato c where c.nome = :nome"),
})
public class Contato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    public Contato() {}

    public Contato(String nome) {
        this.nome = nome;
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

    @Override
    public String toString() {
        return "Contato{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                '}';
    }
}
