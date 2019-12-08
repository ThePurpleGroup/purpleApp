package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Posto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostoRepository  extends  CrudRepository<Posto, Long>{
}
