package br.senac.go.webservice.resources;

import br.senac.go.webservice.repository.PrecoPorPostoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
