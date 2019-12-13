package br.senac.go.app.data.repository.source;

import java.util.List;

import br.senac.go.app.data.model.Abastecimento;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface AbastecimentoAPISource {

    @GET("/abastecimento/veiculo/{id}")
    Call<List<Abastecimento>> getAbastecimentosByIdVeiculo(@Path("id") Long id);

}
