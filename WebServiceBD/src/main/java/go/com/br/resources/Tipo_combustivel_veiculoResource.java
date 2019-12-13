package go.com.br.resources;

import go.com.br.model.Tipo_combustivel_veiculo;
import go.com.br.repository.Tipo_combustivel_veiculoRepository;
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
@RequestMapping("/tipoCombustivelVeiculo")
public class Tipo_combustivel_veiculoResource {

    @Autowired
    private Tipo_combustivel_veiculoRepository tipo_combustivel_veiculoRepository;

    @GetMapping
    public List<Tipo_combustivel_veiculo> list(){ return tipo_combustivel_veiculoRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Tipo_combustivel_veiculo> findById(@PathVariable Long id) { return tipo_combustivel_veiculoRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Tipo_combustivel_veiculo> create(@RequestBody Tipo_combustivel_veiculo tipo_combustivel_veiculo, HttpServletResponse response) {
        Tipo_combustivel_veiculo save = tipo_combustivel_veiculoRepository.save(tipo_combustivel_veiculo);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { tipo_combustivel_veiculoRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Tipo_combustivel_veiculo> update(@PathVariable Long id,@RequestBody Tipo_combustivel_veiculo tipo_combustivel_veiculo) {
        Optional<Tipo_combustivel_veiculo> tipoCombustivelVeiculoBanco = tipo_combustivel_veiculoRepository.findById(id);
        BeanUtils.copyProperties(tipo_combustivel_veiculo, tipoCombustivelVeiculoBanco.get());
        tipo_combustivel_veiculoRepository.save(tipoCombustivelVeiculoBanco.get());
        return ResponseEntity.ok(tipo_combustivel_veiculo);
    }
}
