package go.com.br.repository;

import go.com.br.model.Posto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostoRepository extends JpaRepository<Posto, Long> {
}
