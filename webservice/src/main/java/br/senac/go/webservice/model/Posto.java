package br.senac.go.webservice.model;

import javax.persistence.Entity;

@Entity
public class Posto extends AbstractEntity {

    private String nome;
    private Integer id_preco_por_posto;

    public Posto() {
    }

    public Posto(String nome, Integer id_preco_por_posto) {
        this.nome = nome;
        this.id_preco_por_posto = id_preco_por_posto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getId_preco_por_posto() {
        return id_preco_por_posto;
    }

    public void setId_preco_por_posto(Integer id_preco_por_posto) {
        this.id_preco_por_posto = id_preco_por_posto;
    }

    @Override
    public String toString() {
        return "Posto{" +
                "nome='" + nome + '\'' +
                ", id_preco_por_posto=" + id_preco_por_posto +
                '}';
    }
}
