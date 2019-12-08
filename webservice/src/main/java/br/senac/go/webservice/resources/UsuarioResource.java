package br.senac.go.webservice.resources;


import br.senac.go.webservice.model.Usuario;
import br.senac.go.webservice.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
        Optional<Usuario> usuario = usuarioDAO.findById(id);
        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario usuario){
        return new ResponseEntity<>(usuarioDAO.save(usuario), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        usuarioDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario usuario){
        usuarioDAO.save(usuario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}