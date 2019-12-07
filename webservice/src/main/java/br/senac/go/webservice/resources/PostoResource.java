package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Posto;
import br.senac.go.webservice.repository.PostoRepository;
import br.senac.go.webservice.repository.PrecoPorPostoRepository;
import br.senac.go.webservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
