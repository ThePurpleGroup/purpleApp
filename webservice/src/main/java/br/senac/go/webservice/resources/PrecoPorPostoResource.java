package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.PrecoPorPosto;
import br.senac.go.webservice.model.Usuario;
import br.senac.go.webservice.model.Veiculo;
import br.senac.go.webservice.repository.PrecoPorPostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/preco_por_posto")
public class PrecoPorPostoResource {

    @Autowired
    private final PrecoPorPostoRepository precoPorPostoDAO;

    public PrecoPorPostoResource(PrecoPorPostoRepository precoPorPostoDAO) {
        this.precoPorPostoDAO = precoPorPostoDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(precoPorPostoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
        Optional<PrecoPorPosto> precoPorPosto = precoPorPostoDAO.findById(id);
        return new ResponseEntity<>(precoPorPosto, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody PrecoPorPosto precoPorPosto){
        return new ResponseEntity<>(precoPorPostoDAO.save(precoPorPosto), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        precoPorPostoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody PrecoPorPosto precoPorPosto){
        precoPorPostoDAO.save(precoPorPosto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
