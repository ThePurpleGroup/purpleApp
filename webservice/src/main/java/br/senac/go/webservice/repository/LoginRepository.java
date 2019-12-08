package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Login;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginRepository  extends CrudRepository<Login, Long> {
}
