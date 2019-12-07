package br.senac.go.webservice.resources;

import br.senac.go.webservice.repository.AbastecimentoRepository;
import br.senac.go.webservice.repository.PostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
