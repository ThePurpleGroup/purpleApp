package go.com.br.model;

import javax.persistence.*;

@Entity
@Table(name = "posto")
public class Posto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "nome")
    private String nome;

    @ManyToOne
    @JoinColumn(name = "id_preco_por_posto")
    private Preco_por_posto preco_por_posto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Preco_por_posto getPreco_por_posto() {
        return preco_por_posto;
    }

    public void setPreco_por_posto(Preco_por_posto preco_por_posto) {
        this.preco_por_posto = preco_por_posto;
    }
}
