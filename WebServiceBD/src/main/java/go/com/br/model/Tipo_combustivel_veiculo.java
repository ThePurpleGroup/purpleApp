package go.com.br.model;

import javax.persistence.*;

@Entity
@Table(name = "tipo_combustivel_veiculo")
public class Tipo_combustivel_veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "cod")
    private long cod;

    @Column(name = "descricao")
    private long descricao;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCod() {
        return cod;
    }

    public void setCod(long cod) {
        this.cod = cod;
    }

    public long getDescricao() {
        return descricao;
    }

    public void setDescricao(long descricao) {
        this.descricao = descricao;
    }
}
