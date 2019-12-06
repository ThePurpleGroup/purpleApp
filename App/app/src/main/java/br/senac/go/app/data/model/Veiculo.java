package br.senac.go.app.data.model;

import java.util.Objects;

public class Veiculo {

    private Long id;
    private String descricao;
    private String Placa;
    private String Tipo;

    public Veiculo() {
    }

    public Veiculo(Long id, String descricao, String placa, String tipo) {
        this.id = id;
        this.descricao = descricao;
        Placa = placa;
        Tipo = tipo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", Placa='" + Placa + '\'' +
                ", Tipo='" + Tipo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) &&
                Objects.equals(descricao, veiculo.descricao) &&
                Objects.equals(Placa, veiculo.Placa) &&
                Objects.equals(Tipo, veiculo.Tipo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, Placa, Tipo);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String placa) {
        Placa = placa;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
