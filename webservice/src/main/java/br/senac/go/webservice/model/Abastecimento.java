package br.senac.go.webservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;
import java.util.Objects;

@Entity
public class Abastecimento  {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private long odometro;
    private Date data_abastecimento;
    private double valor_total_combustive;
    private String nome_posto;
    private double total_litros;
    private double valor_por_combustive;
    private Integer id_veiculo;
    private String tipo_combustivel;

    public Abastecimento() {
    }

    public Abastecimento(Long id, long odometro, Date data_abastecimento, double valor_total_combustive, String nome_posto,
                         double total_litros, double valor_por_combustive, Integer id_veiculo, String tipo_combustivel) {
        this.id = id;
        this.odometro = odometro;
        this.data_abastecimento = data_abastecimento;
        this.valor_total_combustive = valor_total_combustive;
        this.nome_posto = nome_posto;
        this.total_litros = total_litros;
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

    public String getNome_posto() {
        return nome_posto;
    }

    public void setNome_posto(String nome_posto) {
        this.nome_posto = nome_posto;
    }

    public double getTotal_litros() {
        return total_litros;
    }

    public void setTotal_litros(double total_litros) {
        this.total_litros = total_litros;
    }

    public double getValor_por_combustive() {
        return valor_por_combustive;
    }

    public void setValor_por_combustive(double valor_por_combustive) {
        this.valor_por_combustive = valor_por_combustive;
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

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", odometro=" + odometro +
                ", data_abastecimento=" + data_abastecimento +
                ", valor_total_combustive=" + valor_total_combustive +
                ", nome_posto='" + nome_posto + '\'' +
                ", total_litros=" + total_litros +
                ", valor_por_combustive=" + valor_por_combustive +
                ", id_veiculo=" + id_veiculo +
                ", tipo_combustivel='" + tipo_combustivel + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abastecimento that = (Abastecimento) o;
        return odometro == that.odometro &&
                Double.compare(that.valor_total_combustive, valor_total_combustive) == 0 &&
                Double.compare(that.total_litros, total_litros) == 0 &&
                Double.compare(that.valor_por_combustive, valor_por_combustive) == 0 &&
                id.equals(that.id) &&
                data_abastecimento.equals(that.data_abastecimento) &&
                nome_posto.equals(that.nome_posto) &&
                id_veiculo.equals(that.id_veiculo) &&
                tipo_combustivel.equals(that.tipo_combustivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, odometro, data_abastecimento, valor_total_combustive, nome_posto, total_litros, valor_por_combustive, id_veiculo, tipo_combustivel);
    }
}
