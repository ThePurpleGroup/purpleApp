package br.senac.go.webservice.repository;

import br.senac.go.webservice.model.Veiculo;
import org.springframework.data.repository.CrudRepository;

public interface VeiculoRepository  extends CrudRepository<Veiculo, Long> {
}
