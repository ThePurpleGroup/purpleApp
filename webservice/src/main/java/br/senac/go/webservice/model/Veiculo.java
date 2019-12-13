package br.senac.go.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Veiculo  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Long id;
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

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getTipo_combustivel() {
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Veiculo veiculo = (Veiculo) o;
        return Objects.equals(id, veiculo.id) &&
                Objects.equals(desc_veiculo, veiculo.desc_veiculo) &&
                Objects.equals(placa, veiculo.placa) &&
                Objects.equals(id_usuario, veiculo.id_usuario) &&
                Objects.equals(tipo_combustivel, veiculo.tipo_combustivel) &&
                Objects.equals(tipo_veiculo, veiculo.tipo_veiculo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, desc_veiculo, placa, id_usuario, tipo_combustivel, tipo_veiculo);
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "id=" + id +
                ", desc_veiculo='" + desc_veiculo + '\'' +
                ", placa='" + placa + '\'' +
                ", id_usuario=" + id_usuario +
                ", tipo_combustivel='" + tipo_combustivel + '\'' +
                ", tipo_veiculo='" + tipo_veiculo + '\'' +
                '}';
    }
}
