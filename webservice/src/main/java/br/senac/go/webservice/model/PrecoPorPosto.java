package br.senac.go.webservice.model;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class PrecoPorPosto extends AbstractEntity {

    private double valor;
    private Date data;
    private String tipo_combustivel;

    public PrecoPorPosto(double valor, Date data, String tipo_combustivel) {
        this.valor = valor;
        this.data = data;
        this.tipo_combustivel = tipo_combustivel;
    }

    public PrecoPorPosto() {
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(String tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    @Override
    public String toString() {
        return "PrecoPorPosto{" +
                "valor=" + valor +
                ", data=" + data +
                ", tipo_combustivel=" + tipo_combustivel +
                '}';
    }
}
