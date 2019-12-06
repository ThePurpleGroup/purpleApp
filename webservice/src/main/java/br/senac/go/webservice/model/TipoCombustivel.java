package br.senac.go.webservice.model;

public class TipoCombustivel extends AbstractEntity {

    private int cod;
    private String descricao;

    public TipoCombustivel() {
    }

    public TipoCombustivel(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public String toString() {
        return "TipoCombustivel{" +
                "cod=" + cod +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
