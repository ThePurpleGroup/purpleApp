package br.senac.go.webservice.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Abastecimento extends AbstractEntity {

    private long odometro;
    private Date data_abastecimento;
    private double valor_total_combustive;
    private double total_litros;
    private Integer id_veiculo;
    private String tipo_combustivel;
    private Integer id_posto;

    public Abastecimento() {
    }

    public Abastecimento(long odometro, Date data_abastecimento, double valor_total_combustive, double total_litros, Integer id_veiculo, String tipo_combustivel, Integer id_posto) {
        this.odometro = odometro;
        this.data_abastecimento = data_abastecimento;
        this.valor_total_combustive = valor_total_combustive;
        this.total_litros = total_litros;
        this.id_veiculo = id_veiculo;
        this.tipo_combustivel = tipo_combustivel;
        this.id_posto = id_posto;
    }

    public long getOdometro() {
        return odometro;
    }

    public void setOdometro(long odometro) {
        this.odometro = odometro;
    }

    public Date getData_abastecimento() {
        return data_abastecimento;
    }

    public void setData_abastecimento(Date data_abastecimento) {
        this.data_abastecimento = data_abastecimento;
    }

    public double getValor_total_combustive() {
        return valor_total_combustive;
    }

    public void setValor_total_combustive(double valor_total_combustive) {
        this.valor_total_combustive = valor_total_combustive;
    }

    public double getTotal_litros() {
        return total_litros;
    }

    public void setTotal_litros(double total_litros) {
        this.total_litros = total_litros;
    }

    public Integer getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Integer id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Integer getId_posto() {
        return id_posto;
    }

    public void setId_posto(Integer id_posto) {
        this.id_posto = id_posto;
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "odometro=" + odometro +
                ", data_abastecimento=" + data_abastecimento +
                ", valor_total_combustive=" + valor_total_combustive +
                ", total_litros=" + total_litros +
                ", id_veiculo=" + id_veiculo +
                ", tipo_combustivel='" + tipo_combustivel + '\'' +
                ", id_posto=" + id_posto +
                '}';
    }
}
