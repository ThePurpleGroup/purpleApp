package br.senac.go.app.data.repository;

import java.util.List;

import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.model.Veiculo;

public interface IVeiculoRepository {

    void getVeiculosUsuario (Callback<List<Veiculo>> callback, Usuario usuario);






}
