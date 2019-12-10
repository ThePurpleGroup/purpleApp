package br.senac.go.webservice.model;

import javax.persistence.Entity;

@Entity
public class Veiculo extends AbstractEntity {

    private String desc_veiculo;
    private String placa;
    private Integer id_usuario;
    private String tipo_combustivel;
    private String tipo_veiculo;

    public Veiculo() {
    }

    public Veiculo(String desc_veiculo, String placa, Integer id_usuario, String tipo_combustivel, String tipo_veiculo) {
        this.desc_veiculo = desc_veiculo;
        this.placa = placa;
        this.id_usuario = id_usuario;
        this.tipo_combustivel = tipo_combustivel;
        this.tipo_veiculo = tipo_veiculo;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String gettipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public String getTipo_veiculo() {
        return tipo_veiculo;
    }

    public void setTipo_veiculo(String tipo_veiculo) {
        this.tipo_veiculo = tipo_veiculo;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "desc_veiculo='" + desc_veiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", id_usuario=" + id_usuario +
                ", tipo_combustivel=" + tipo_combustivel +
                ", tipo_veiculo='" + tipo_veiculo + '\'' +
                '}';
    }
}
