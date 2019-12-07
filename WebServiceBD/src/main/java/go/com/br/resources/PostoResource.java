package go.com.br.resources;

import go.com.br.model.Posto;
import go.com.br.repository.PostoRepository;
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
@RequestMapping("/posto")
public class PostoResource {

    @Autowired
    private PostoRepository postoRepository;

    @GetMapping
    public List<Posto> list(){ return postoRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Posto> findById(@PathVariable Long id) { return postoRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Posto> create(@RequestBody Posto posto, HttpServletResponse response) {
        Posto save = postoRepository.save(posto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { postoRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Posto> update(@PathVariable Long id,@RequestBody Posto posto) {
        Optional<Posto> postoBanco = postoRepository.findById(id);
        BeanUtils.copyProperties(posto, postoBanco.get());
        postoRepository.save(postoBanco.get());
        return ResponseEntity.ok(posto);
    }
}
