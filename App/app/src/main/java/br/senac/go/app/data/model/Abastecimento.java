package br.senac.go.app.data.model;

import java.util.Date;
import java.util.Objects;

public class Abastecimento {

    private Long id;
    private Date dataAbastecimento;
    private Double valorTotal;
    private Double valorLitro;
    private String tipoCombustivel;

    public Abastecimento() {
    }

    public Abastecimento(Long id, Date dataAbastecimento, Double valorTotal, Double valorLitro, String tipoCombustivel) {
        this.id = id;
        this.dataAbastecimento = dataAbastecimento;
        this.valorTotal = valorTotal;
        this.valorLitro = valorLitro;
        this.tipoCombustivel = tipoCombustivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataAbastecimento() {
        return dataAbastecimento;
    }

    public void setDataAbastecimento(Date dataAbastecimento) {
        this.dataAbastecimento = dataAbastecimento;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getValorLitro() {
        return valorLitro;
    }

    public void setValorLitro(Double valorLitro) {
        this.valorLitro = valorLitro;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Abastecimento that = (Abastecimento) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(dataAbastecimento, that.dataAbastecimento) &&
                Objects.equals(valorTotal, that.valorTotal) &&
                Objects.equals(valorLitro, that.valorLitro) &&
                Objects.equals(tipoCombustivel, that.tipoCombustivel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, dataAbastecimento, valorTotal, valorLitro, tipoCombustivel);
    }

    @Override
    public String toString() {
        return "Abastecimento{" +
                "id=" + id +
                ", dataAbastecimento=" + dataAbastecimento +
                ", valorTotal=" + valorTotal +
                ", valorLitro=" + valorLitro +
                ", tipoCombustivel='" + tipoCombustivel + '\'' +
                '}';
    }
}
