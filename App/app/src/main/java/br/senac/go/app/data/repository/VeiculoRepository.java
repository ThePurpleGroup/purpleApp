package br.senac.go.app.data.repository;

import java.util.List;

import br.senac.go.app.data.model.Relatorio;
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

    @Override
    public void createVeiculo(final Callback<Veiculo> callback, Veiculo veiculo) {
        veiculoAPISource.createVeiculo(veiculo).enqueue(new retrofit2.Callback<Veiculo>() {
            @Override
            public void onResponse(Call<Veiculo> call, Response<Veiculo> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Veiculo> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }

    @Override
    public void getRelatorioByIdVeiculo(final Callback<Relatorio> callback, Veiculo veiculo) {
        veiculoAPISource.getRelatorioByIdVeiculo(veiculo.getId()).enqueue(new retrofit2.Callback<Relatorio>() {
            @Override
            public void onResponse(Call<Relatorio> call, Response<Relatorio> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Relatorio> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }


}
