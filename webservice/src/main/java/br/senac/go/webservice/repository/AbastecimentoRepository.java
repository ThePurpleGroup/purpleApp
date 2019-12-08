package br.senac.go.webservice.repository;


import br.senac.go.webservice.model.Abastecimento;
import br.senac.go.webservice.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbastecimentoRepository extends CrudRepository<Abastecimento, Long> {

    @Query(value = "SELECT * FROM abastecimento WHERE id_veiculo = ?1",
            nativeQuery = true)
    List<Abastecimento> findAllBy(Long id_veiculo);

}
