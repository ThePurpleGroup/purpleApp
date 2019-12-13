package go.com.br.model;

import javax.persistence.*;

@Entity
@Table(name = "preco_por_posto")
public class Preco_por_posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "valor")
    private Double valor;

    @Column(name = "data")
    private String data;

    @ManyToOne
    @JoinColumn(name = "id_tipo_combustivel")
    private Tipo_combustivel tipo_combustivel;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Tipo_combustivel getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(Tipo_combustivel tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }
}
