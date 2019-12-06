package br.senac.go.webservice.resources;

import br.senac.go.webservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private final UsuarioRepository usuarioDAO;

    public UsuarioResource(UsuarioRepository usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }
    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(usuarioDAO.findAll(), HttpStatus.OK);
    }
}