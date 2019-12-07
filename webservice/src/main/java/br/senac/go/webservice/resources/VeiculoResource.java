package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Usuario;
import br.senac.go.webservice.model.Veiculo;
import br.senac.go.webservice.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/veiculo")
public class VeiculoResource {

    @Autowired
    private final VeiculoRepository veiculoDAO;

    public VeiculoResource(VeiculoRepository veiculoDAO) {
        this.veiculoDAO = veiculoDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(veiculoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getVeiculoById(@PathVariable("id") Long id){
        Optional<Veiculo> veiculo = veiculoDAO.findById(id);
        return new ResponseEntity<>(veiculo, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Veiculo veiculo){
        return new ResponseEntity<>(veiculoDAO.save(veiculo), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        veiculoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Veiculo veiculo){
        veiculoDAO.save(veiculo);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
