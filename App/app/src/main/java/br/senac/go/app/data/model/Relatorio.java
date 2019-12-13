package br.senac.go.app.data.model;

import java.util.Objects;

public class Relatorio {

    private Long id_veiculo;
    private String postoMaisCaro;
    private String postoMaisBarato;
    private Double mediaConsumo;

    public Relatorio() {
    }

    public Relatorio(Long id_veiculo, String postoMaisCaro, String postoMaisBarato, Double mediaConsumo) {
        this.id_veiculo = id_veiculo;
        this.postoMaisCaro = postoMaisCaro;
        this.postoMaisBarato = postoMaisBarato;
        this.mediaConsumo = mediaConsumo;
    }

    public Long getId_veiculo() {
        return id_veiculo;
    }

    public void setId_veiculo(Long id_veiculo) {
        this.id_veiculo = id_veiculo;
    }

    public String getPostoMaisCaro() {
        return postoMaisCaro;
    }

    public void setPostoMaisCaro(String postoMaisCaro) {
        this.postoMaisCaro = postoMaisCaro;
    }

    public String getPostoMaisBarato() {
        return postoMaisBarato;
    }

    public void setPostoMaisBarato(String postoMaisBarato) {
        this.postoMaisBarato = postoMaisBarato;
    }

    public Double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(Double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relatorio relatorio = (Relatorio) o;
        return Objects.equals(id_veiculo, relatorio.id_veiculo) &&
                Objects.equals(postoMaisCaro, relatorio.postoMaisCaro) &&
                Objects.equals(postoMaisBarato, relatorio.postoMaisBarato) &&
                Objects.equals(mediaConsumo, relatorio.mediaConsumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_veiculo, postoMaisCaro, postoMaisBarato, mediaConsumo);
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "id_veiculo=" + id_veiculo +
                ", postoMaisCaro='" + postoMaisCaro + '\'' +
                ", postoMaisBarato='" + postoMaisBarato + '\'' +
                ", mediaConsumo=" + mediaConsumo +
                '}';
    }
}
