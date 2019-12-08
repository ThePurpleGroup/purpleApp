package br.senac.go.webservice.repository;


import br.senac.go.webservice.model.Abastecimento;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbastecimentoRepository extends CrudRepository<Abastecimento, Long> {
}
