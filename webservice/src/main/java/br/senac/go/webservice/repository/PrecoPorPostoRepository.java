package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.PrecoPorPosto;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecoPorPostoRepository extends CrudRepository<PrecoPorPosto, Long> {
}
