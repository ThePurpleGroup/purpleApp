package br.senac.go.app.data.model;

import java.io.Serializable;
import java.util.Objects;

public class Veiculo implements Serializable {

    private Long id;
    private String desc_veiculo;
    private String placa;
    private Long id_usuario;
    private String tipo_combustivel_veiculo;
    private String tipo_veiculo;

    public Veiculo() {
    }

    public Veiculo(Long id, String desc_veiculo, String placa, Long id_usuario, String tipo_combustivel_veiculo, String tipo_veiculo) {
        this.id = id;
        this.desc_veiculo = desc_veiculo;
        this.placa = placa;
        this.id_usuario = id_usuario;
        this.tipo_combustivel_veiculo = tipo_combustivel_veiculo;
        this.tipo_veiculo = tipo_veiculo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDesc_veiculo() {
        return desc_veiculo;
    }

    public void setDesc_veiculo(String desc_veiculo) {
        this.desc_veiculo = desc_veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Long getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Long id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_combustivel_veiculo() {
        return tipo_combustivel_veiculo;
    }

    public void setTipo_combustivel_veiculo(String tipo_combustivel_veiculo) {
        this.tipo_combustivel_veiculo = tipo_combustivel_veiculo;
    }

    public String getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(String tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) &&
                Objects.equals(desc_veiculo, veiculo.desc_veiculo) &&
                Objects.equals(placa, veiculo.placa) &&
                Objects.equals(id_usuario, veiculo.id_usuario) &&
                Objects.equals(tipo_combustivel_veiculo, veiculo.tipo_combustivel_veiculo) &&
                Objects.equals(tipo_veiculo, veiculo.tipo_veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc_veiculo, placa, id_usuario, tipo_combustivel_veiculo, tipo_veiculo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", desc_veiculo='" + desc_veiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", id_usuario=" + id_usuario +
                ", tipo_combustivel_veiculo='" + tipo_combustivel_veiculo + '\'' +
                ", tipo_veiculo='" + tipo_veiculo + '\'' +
                '}';
    }
}
