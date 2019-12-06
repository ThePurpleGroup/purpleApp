package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

}
