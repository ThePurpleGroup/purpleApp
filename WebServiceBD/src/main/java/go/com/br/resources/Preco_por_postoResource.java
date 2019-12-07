package go.com.br.resources;

import go.com.br.model.Preco_por_posto;
import go.com.br.repository.Preco_por_postoRepository;
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
@RequestMapping("/preco")
public class Preco_por_postoResource {

    @Autowired
    private Preco_por_postoRepository preco_por_postoRepository;

    @GetMapping
    public List<Preco_por_posto> list(){ return preco_por_postoRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Preco_por_posto> findById(@PathVariable Long id) { return preco_por_postoRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Preco_por_posto> create(@RequestBody Preco_por_posto preco_por_posto, HttpServletResponse response) {
        Preco_por_posto save = preco_por_postoRepository.save(preco_por_posto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { preco_por_postoRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Preco_por_posto> update(@PathVariable Long id,@RequestBody Preco_por_posto preco_por_posto) {
        Optional<Preco_por_posto> precoPorPostoBanco = preco_por_postoRepository.findById(id);
        BeanUtils.copyProperties(preco_por_posto, precoPorPostoBanco.get());
        preco_por_postoRepository.save(precoPorPostoBanco.get());
        return ResponseEntity.ok(preco_por_posto);
    }
}
