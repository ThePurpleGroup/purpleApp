package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Posto;
import br.senac.go.webservice.model.Usuario;
import br.senac.go.webservice.repository.PostoRepository;
import br.senac.go.webservice.repository.PrecoPorPostoRepository;
import br.senac.go.webservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/posto")
public class PostoResource {

    @Autowired
    private final PostoRepository postoDAO;

    public PostoResource(PostoRepository postoDAO) {
        this.postoDAO = postoDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(postoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
        Optional<Posto> posto = postoDAO.findById(id);
        return new ResponseEntity<>(posto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Posto posto){
        return new ResponseEntity<>(postoDAO.save(posto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        postoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Posto posto){
        postoDAO.save(posto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
