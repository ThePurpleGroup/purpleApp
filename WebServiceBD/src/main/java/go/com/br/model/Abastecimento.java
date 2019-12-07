package go.com.br.model;

import javax.persistence.*;

@Entity
@Table(name = "abastecimento")
public class Abastecimento<mail> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "data_abastecimento")
    private String data_abastecimento;

    @Column(name = "valor_total_combustive")
    private Double valor_total_combustive;

    @Column(name = "total_por_litros")
    private Double total_por_litros;

    @ManyToOne
    @JoinColumn(name = "id_veiculo")
    private Veiculo veiculo;

    @ManyToOne
    @JoinColumn(name = "id_tipo_combustivel")
    private Tipo_combustivel tipo_combustivel;

    @ManyToOne
    @JoinColumn(name = "id_posto")
    private Posto posto;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData_abastecimento() {
        return data_abastecimento;
    }

    public void setData_abastecimento(String data_abastecimento) {
        this.data_abastecimento = data_abastecimento;
    }

    public Double getValor_total_combustive() {
        return valor_total_combustive;
    }

    public void setValor_total_combustive(Double valor_total_combustive) {
        this.valor_total_combustive = valor_total_combustive;
    }

    public Double getTotal_por_litros() {
        return total_por_litros;
    }

    public void setTotal_por_litros(Double total_por_litros) {
        this.total_por_litros = total_por_litros;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public Tipo_combustivel getTipo_combustivel() {
        return tipo_combustivel;
    }

    public void setTipo_combustivel(Tipo_combustivel tipo_combustivel) {
        this.tipo_combustivel = tipo_combustivel;
    }

    public Posto getPosto() {
        return posto;
    }

    public void setPosto(Posto posto) {
        this.posto = posto;
    }
}
