package br.senac.go.app.data.repository;

import java.util.List;

import br.senac.go.app.data.model.Abastecimento;
import br.senac.go.app.data.model.Veiculo;
import br.senac.go.app.data.repository.source.AbastecimentoAPISource;
import retrofit2.Call;
import retrofit2.Response;

public class AbastecimentoRepository implements IAbastecimentoRepository {

    private AbastecimentoAPISource abastecimentoAPISource;

    public AbastecimentoRepository(AbastecimentoAPISource abastecimentoAPISource) {
        this.abastecimentoAPISource = abastecimentoAPISource;
    }

    @Override
    public void getAbastecimentosByIdVeiculo(final Callback<List<Abastecimento>> callback, Veiculo veiculo) {
        abastecimentoAPISource.getAbastecimentosByIdVeiculo(veiculo.getId()).enqueue(new retrofit2.Callback<List<Abastecimento>>() {
            @Override
            public void onResponse(Call<List<Abastecimento>> call, Response<List<Abastecimento>> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<List<Abastecimento>> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }
}
