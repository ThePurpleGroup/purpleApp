package go.com.br.resources;

import go.com.br.model.Veiculo;
import go.com.br.repository.VeiculoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @GetMapping
    public List<Veiculo> list(){ return veiculoRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Veiculo> findById(@PathVariable Long id) { return veiculoRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Veiculo> create(@RequestBody Veiculo veiculo, HttpServletResponse response) {
        Veiculo save = veiculoRepository.save(veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { veiculoRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Veiculo> update(@PathVariable Long id,@RequestBody Veiculo veiculo) {
        Optional<Veiculo> veiculoBanco = veiculoRepository.findById(id);
        BeanUtils.copyProperties(veiculo, veiculoBanco.get());
        veiculoRepository.save(veiculoBanco.get());
        return ResponseEntity.ok(veiculo);
    }
}
