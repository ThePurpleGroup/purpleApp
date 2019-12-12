package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Abastecimento;
import br.senac.go.webservice.model.Relatorio;
import br.senac.go.webservice.model.Veiculo;
import br.senac.go.webservice.repository.AbastecimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/abastecimento")
public class AbastecimentoResource {

    @Autowired
    private final AbastecimentoRepository abastecimentoDAO;

    public AbastecimentoResource(AbastecimentoRepository abastecimentoDAO) {
        this.abastecimentoDAO = abastecimentoDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(abastecimentoDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getAbastecimentoById(@PathVariable("id") Long id){
        Optional<Abastecimento> abastecimento = abastecimentoDAO.findById(id);

        return new ResponseEntity<>(abastecimento, HttpStatus.OK);
    }
    @RequestMapping("/veiculo/{id_veiculo}")
    public ResponseEntity<?> getVeiculo(@PathVariable("id_veiculo") Long id_veiculo){
        List<Abastecimento> abastecimentoList = abastecimentoDAO.findAllBy(id_veiculo);

        return new ResponseEntity<>(abastecimentoList, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Abastecimento abastecimento){
        return new ResponseEntity<>(abastecimentoDAO.save(abastecimento), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        abastecimentoDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Abastecimento abastecimento){
        abastecimentoDAO.save(abastecimento);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
