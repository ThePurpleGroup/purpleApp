package br.senac.go.webservice.resources;

import br.senac.go.webservice.repository.TipoCombustivelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tipo_combustivel")
public class TipoCombustivelResource {

    @Autowired
    private final TipoCombustivelRepository tipoCombustivelDAO;

    public TipoCombustivelResource(TipoCombustivelRepository tipoCombustivelDAO) {
        this.tipoCombustivelDAO = tipoCombustivelDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(tipoCombustivelDAO.findAll(), HttpStatus.OK);
    }

}
