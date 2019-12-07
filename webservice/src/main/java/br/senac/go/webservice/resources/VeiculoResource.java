package br.senac.go.webservice.resources;

import br.senac.go.webservice.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
