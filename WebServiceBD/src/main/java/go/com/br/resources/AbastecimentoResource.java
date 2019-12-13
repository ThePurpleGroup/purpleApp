package go.com.br.resources;

import go.com.br.model.Abastecimento;
import go.com.br.repository.AbastecimentoRepository;
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
@RequestMapping("/abastecimento")
public class AbastecimentoResource {

    @Autowired
    private AbastecimentoRepository abastecimentoRepository;

    @GetMapping
    public List<Abastecimento> list(){ return abastecimentoRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Abastecimento> findById(@PathVariable Long id) { return abastecimentoRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Abastecimento> create(@RequestBody Abastecimento abastecimento, HttpServletResponse response) {
        Abastecimento save = abastecimentoRepository.save(abastecimento);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { abastecimentoRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Abastecimento> update(@PathVariable Long id,@RequestBody Abastecimento abastecimento) {
        Optional<Abastecimento> abastecimentoBanco = abastecimentoRepository.findById(id);
        BeanUtils.copyProperties(abastecimento, abastecimentoBanco.get());
        abastecimentoRepository.save(abastecimentoBanco.get());
        return ResponseEntity.ok(abastecimento);
    }
}
