package br.senac.go.webservice.model;

import java.util.Objects;

public class Relatorio {


    private  String postoMaisCaro;
    private  String postoMaisBarato;
    private  double mediaConsumo;

    public Relatorio() {
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

    public double getMediaConsumo() {
        return mediaConsumo;
    }

    public void setMediaConsumo(double mediaConsumo) {
        this.mediaConsumo = mediaConsumo;
    }

    @Override
    public String toString() {
        return "Relatorio{" +
                "postoMaisCaro='" + postoMaisCaro + '\'' +
                ", postoMaisBarato='" + postoMaisBarato + '\'' +
                ", mediaConsumo='" + mediaConsumo + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Relatorio relatorio = (Relatorio) o;
        return Objects.equals(postoMaisCaro, relatorio.postoMaisCaro) &&
                Objects.equals(postoMaisBarato, relatorio.postoMaisBarato) &&
                Objects.equals(mediaConsumo, relatorio.mediaConsumo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(postoMaisCaro, postoMaisBarato, mediaConsumo);
    }
}
