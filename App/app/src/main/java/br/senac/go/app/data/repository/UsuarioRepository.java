package br.senac.go.app.data.repository;

import br.senac.go.app.data.model.Login;
import br.senac.go.app.data.model.Usuario;
import br.senac.go.app.data.repository.source.UsuarioAPISource;
import retrofit2.Call;
import retrofit2.Response;

public class UsuarioRepository implements IUsuarioRepository{

    private UsuarioAPISource usuarioAPISource;

    public UsuarioRepository(UsuarioAPISource usuarioAPISource) {
        this.usuarioAPISource = usuarioAPISource;
    }

    @Override
    public void getUsuario(final Callback<Usuario> callback, Long id) {
        usuarioAPISource.getUsuario(id).enqueue(new retrofit2.Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }

    @Override
    public void login(final Callback<Usuario> callback, Login login) {
        usuarioAPISource.login(login).enqueue(new retrofit2.Callback<Usuario>() {
            @Override
            public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                callback.onResult(response.body());
            }

            @Override
            public void onFailure(Call<Usuario> call, Throwable t) {
                callback.onEmpty();
            }
        });
    }
}
