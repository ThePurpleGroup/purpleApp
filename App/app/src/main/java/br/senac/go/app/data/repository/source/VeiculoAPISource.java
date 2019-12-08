package br.senac.go.app.data.repository.source;

import java.util.List;

import br.senac.go.app.data.model.Veiculo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface VeiculoAPISource {

    @GET("/veiculo/user/{id}")
    Call<List<Veiculo>> getVeiculosUsuario(@Path("id") Long id);



}
