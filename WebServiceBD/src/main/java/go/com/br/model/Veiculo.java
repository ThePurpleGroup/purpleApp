package go.com.br.model;

import javax.persistence.*;

@Entity
@Table(name = "veiculo")
public class Veiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "desc_veiculo")
    private String desc_veiculo;

    @Column(name = "placa")
    private String placa;

    @Column(name = "data")
    private long data;

    @ManyToOne
    @JoinColumn(name = "id_tipo_combustivel")
    private Tipo_combustivel_veiculo tipo_combustivel_veiculo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDesc_veiculo() {
        return desc_veiculo;
    }

    public void setDesc_veiculo(String desc_veiculo) {
        this.desc_veiculo = desc_veiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public long getData() {
        return data;
    }

    public void setData(long data) {
        this.data = data;
    }

    public Tipo_combustivel_veiculo getTipo_combustivel_veiculo() {
        return tipo_combustivel_veiculo;
    }

    public void setTipo_combustivel_veiculo(Tipo_combustivel_veiculo tipo_combustivel_veiculo) {
        this.tipo_combustivel_veiculo = tipo_combustivel_veiculo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
