package br.senac.go.app.data.repository;

import java.util.List;

import br.senac.go.app.data.model.Relatorio;
import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.model.Veiculo;

public interface IVeiculoRepository {

    void getVeiculosUsuario (Callback<List<Veiculo>> callback, Usuario usuario);

    void createVeiculo (Callback<Veiculo> callback, Veiculo veiculo);

    void getRelatorioByIdVeiculo (Callback<Relatorio> callback, Veiculo veiculo);

}
