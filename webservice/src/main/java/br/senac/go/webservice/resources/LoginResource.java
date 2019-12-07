package br.senac.go.webservice.resources;

import br.senac.go.webservice.model.Login;
import br.senac.go.webservice.model.Posto;
import br.senac.go.webservice.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/login")
public class LoginResource {

    @Autowired
    private final LoginRepository loginDAO;

    public LoginResource(LoginRepository loginDAO) {
        this.loginDAO = loginDAO;
    }

    @GetMapping
    public ResponseEntity<?> listAll(){
        return new ResponseEntity<>(loginDAO.findAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getUsuarioById(@PathVariable("id") Long id){
        Optional<Login> login = loginDAO.findById(id);
        return new ResponseEntity<>(login, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Login login){
        return new ResponseEntity<>(loginDAO.save(login), HttpStatus.OK);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        loginDAO.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Login login){
        loginDAO.save(login);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
