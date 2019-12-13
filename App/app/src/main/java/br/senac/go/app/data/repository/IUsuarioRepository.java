package br.senac.go.app.data.repository;

import br.senac.go.app.data.model.Login;
import br.senac.go.app.data.model.Usuario;

public interface IUsuarioRepository {

    void getUsuario(Callback<Usuario> callback, Long id);

    void login(Callback<Usuario> callback, Login login);
}
