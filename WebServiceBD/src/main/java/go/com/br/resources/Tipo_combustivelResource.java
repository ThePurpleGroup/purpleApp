package go.com.br.resources;

import go.com.br.model.Tipo_combustivel;
import go.com.br.repository.Tipo_combustivelRepository;
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
@RequestMapping("/tipoCombustivel")
public class Tipo_combustivelResource {

    @Autowired
    private Tipo_combustivelRepository tipo_combustivelRepository;

    @GetMapping
    public List<Tipo_combustivel> list(){ return tipo_combustivelRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Tipo_combustivel> findById(@PathVariable Long id) { return tipo_combustivelRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Tipo_combustivel> create(@RequestBody Tipo_combustivel tipo_combustivel, HttpServletResponse response) {
        Tipo_combustivel save = tipo_combustivelRepository.save(tipo_combustivel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { tipo_combustivelRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Tipo_combustivel> update(@PathVariable Long id,@RequestBody Tipo_combustivel tipo_combustivel) {
        Optional<Tipo_combustivel> tipoCombustivelBanco = tipo_combustivelRepository.findById(id);
        BeanUtils.copyProperties(tipo_combustivel, tipoCombustivelBanco.get());
        tipo_combustivelRepository.save(tipoCombustivelBanco.get());
        return ResponseEntity.ok(tipo_combustivel);
    }
}
