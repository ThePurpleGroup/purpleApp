package br.senac.go.app.data.repository;

import java.util.List;

import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.source.UsuarioAPISource;
import br.senac.go.app.data.repository.source.VeiculoAPISource;
import retrofit2.Call;
import retrofit2.Response;

public class VeiculoRepository implements IVeiculoRepository {

    private VeiculoAPISource veiculoAPISource;

    public VeiculoRepository(VeiculoAPISource veiculoAPISource) {
        this.veiculoAPISource = veiculoAPISource;
    }

    @Override
    public void getVeiculosUsuario(final Callback<List<Veiculo>> callback, Usuario usuario) {
        veiculoAPISource.getVeiculosUsuario(usuario.getId()).enqueue(new retrofit2.Callback<List<Veiculo>>() {
            @Override
            public void onResponse(Call<List<Veiculo>> call, Response<List<Veiculo>> response) {

                callback.onResult(response.body());

            }
            @Override
            public void onFailure(Call<List<Veiculo>> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }


}
