package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Veiculo;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;

@Repository
public interface VeiculoRepository   extends CrudRepository<Veiculo, Long> {

    @Query(value = "SELECT * FROM veiculo WHERE id_usuario = ?1",
            nativeQuery = true)
    List<Veiculo> findAllBy(Long id_usuario);

}
