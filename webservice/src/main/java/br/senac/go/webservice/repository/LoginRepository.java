package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Login;
import org.springframework.data.repository.CrudRepository;

public interface LoginRepository  extends CrudRepository<Login, Long> {
}
