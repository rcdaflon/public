package veiculosonline.controller;

import java.text.ParseException;
import br.veiculosonline.database.entity.Usuario;
import veiculosonline.service.UsuarioService;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import br.veiculosonline.database.dao.IUsuarioDao;

@CrossOrigin
@RestController
public class UsuarioRestController {

    @Autowired
    IUsuarioDao userService;
    
    //private UsuarioService userService = new UsuarioService();

    @GetMapping("/usuario")
    public List<Usuario> get() {
        return userService.getAll();
    }

    @GetMapping("/usuario/{id}")
    public Usuario getById(@PathVariable("id") Long id) {
        return userService.getById(id);
    } 
    
    @GetMapping("/usuario/email/{email}")
    public Usuario getByEmail(@PathVariable("email") String email) {
        return userService.getByEmail(email);
    } 
//        HttpHeaders httpHeaders = new HttpHeaders();
//        if (usuario != null) {
//            return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.ACCEPTED);
//        } else {
//            return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.NOT_FOUND);
//        }
    

    @PostMapping("/usuario")
    public ResponseEntity post(@RequestBody Usuario usuario) {
        UsuarioService uService = new UsuarioService();
        Map<String, String> errors = uService.validate(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            userService.create(usuario);
            httpHeaders.add("Location", "/usuario/" + usuario.getId());
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/usuario/{id}")
    public void delete(@PathVariable("id") Long id) {
        userService.delete(id);
    }

    @PutMapping("/usuario/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        UsuarioService uService = new UsuarioService();
        Map<String, String> errors = uService.validate(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            userService.update(usuario);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity patch(@PathVariable("id") Long id, @RequestBody Map<String, String> body) throws ParseException {
        body.put("id", id.toString());
        UsuarioService uService = new UsuarioService();
        Usuario usuario = uService.merge(body);
        Map<String, String> errors = uService.validate(usuario);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            userService.update(usuario);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
