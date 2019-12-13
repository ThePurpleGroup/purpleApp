package go.com.br.resources;

import go.com.br.model.Usuario;
import go.com.br.repository.UsuarioRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping
    public List<Usuario> list(){ return usuarioRepository.findAll();}
    @GetMapping("/{id}")
    public Optional<Usuario> findById(@PathVariable Long id) { return usuarioRepository.findById(id); }
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario, HttpServletResponse response) {
        Usuario save = usuarioRepository.save(usuario);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(save.getId()).toUri();
        return ResponseEntity.created(uri).body(save);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) { usuarioRepository.deleteById(id);}
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> update(@PathVariable Long id,@RequestBody Usuario usuario) {
        Optional<Usuario> usuarioBanco = usuarioRepository.findById(id);
        BeanUtils.copyProperties(usuario, usuarioBanco.get());
        usuarioRepository.save(usuarioBanco.get());
        return ResponseEntity.ok(usuario);
    }
}
