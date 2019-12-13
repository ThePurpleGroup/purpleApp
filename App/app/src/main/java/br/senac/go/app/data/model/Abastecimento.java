package br.senac.go.app.data.model;

import java.util.Date;
import java.util.Objects;

public class Abastecimento {

    private Long id;
    private Long odometro;
    private Date data_abastecimento;
    private String nome_posto;
    private Double total_litros;
    private Double valor_total_combustive;
    private Double valor_por_combustive;
    private Long id_veiculo;
    private String tipo_combustivel;

    public Abastecimento() {
    }

    public Abastecimento(Long id, Long odometro, Date data_abastecimento, String nome_posto, Double total_litros, Double valor_total_combustive, Double valor_por_combustive, Long id_veiculo, String tipo_combustivel) {
        this.id = id;
        this.odometro = odometro;
        this.data_abastecimento = data_abastecimento;
        this.nome_posto = nome_posto;
        this.total_litros = total_litros;
        this.valor_total_combustive = valor_total_combustive;
        this.valor_por_combustive = valor_por_combustive;
        this.id_veiculo = id_veiculo;
        this.tipo_combustivel = tipo_combustivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getOdometro() {
        return odometro;
    }

    public void setOdometro(Long odometro) {
        this.odometro = odometro;
    }

    public Date getData_abastecimento() {
        return data_abastecimento;
    }

    public void setData_abastecimento(Date data_abastecimento) {
        this.data_abastecimento = data_abastecimento;
    }

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public Double getTotal_litros() {
        return total_litros;
    }

    public void setTotal_litros(Double total_litros) {
        this.total_litros = total_litros;
    }

    public Double getValor_total_combustive() {
        return valor_total_combustive;
    }

    public void setValor_total_combustive(Double valor_total_combustive) {
        this.valor_total_combustive = valor_total_combustive;
    }

    public Double getValor_por_combustive() {
        return valor_por_combustive;
    }

    public void setValor_por_combustive(Double valor_por_combustive) {
        this.valor_por_combustive = valor_por_combustive;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abastecimento that = (Abastecimento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(odometro, that.odometro) &&
                Objects.equals(data_abastecimento, that.data_abastecimento) &&
                Objects.equals(nome_posto, that.nome_posto) &&
                Objects.equals(total_litros, that.total_litros) &&
                Objects.equals(valor_total_combustive, that.valor_total_combustive) &&
                Objects.equals(valor_por_combustive, that.valor_por_combustive) &&
                Objects.equals(id_veiculo, that.id_veiculo) &&
                Objects.equals(tipo_combustivel, that.tipo_combustivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, odometro, data_abastecimento, nome_posto, total_litros, valor_total_combustive, valor_por_combustive, id_veiculo, tipo_combustivel);
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", odometro=" + odometro +
                ", data_abastecimento=" + data_abastecimento +
                ", nome_posto='" + nome_posto + '\'' +
                ", total_litros=" + total_litros +
                ", valor_total_combustive=" + valor_total_combustive +
                ", valor_por_combustive=" + valor_por_combustive +
                ", id_veiculo=" + id_veiculo +
                ", tipo_combustivel='" + tipo_combustivel + '\'' +
                '}';
    }
}
