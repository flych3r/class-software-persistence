package br.ufc.qxd.dsp.aula2;

import java.io.Serializable;

public class Empregado implements Serializable {

    private String nome;
    private String endereco;
    private int cpf;
    private int numero;
    private transient boolean sexo; // atributos transient não serão serializados

    public Empregado() {
    }

    public Empregado(String nome, String endereco, int cpf, int numero, boolean sexo) {
        this.nome = nome;
        this.endereco = endereco;
        this.cpf = cpf;
        this.numero = numero;
        this.sexo = sexo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public boolean isSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    @Override
    public String toString() {
        return "Empregado{" +
                "nome='" + nome + '\'' +
                ", endereco='" + endereco + '\'' +
                ", cpf=" + cpf +
                ", numero=" + numero +
                ", sexo=" + sexo +
                '}';
    }
}
