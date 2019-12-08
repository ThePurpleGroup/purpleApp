package br.senac.go.app.data.repository.source;

import br.senac.go.app.data.model.Usuario;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface UsuarioAPISource {

    @GET("/usuario/{id}")
    Call<Usuario> getUsuario(@Path("id") int id);

//    @POST("/usuario")
//    Call<Usuario> createUsuario(@Body Usuario usuario);

}
