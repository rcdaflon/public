package veiculosonline.controller;

import java.text.ParseException;
import java.util.List;
import java.util.Map;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import veiculosonline.database.entity.Anuncio;
import veiculosonline.service.AnuncioService;

public class AnuncioRestController {
    
    private AnuncioService anuncService = new AnuncioService();

    @GetMapping("/anuncioList")
    public List<Anuncio> get() {
        return anuncService.read();
    }

    @GetMapping("/anuncio/{id}")
    public Anuncio getById(@PathVariable("id") Long id) {
        return anuncService.readById(id);
    }  
//        HttpHeaders httpHeaders = new HttpHeaders();
//        if (usuario != null) {
//            return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.ACCEPTED);
//        } else {
//            return new ResponseEntity<>(usuario, httpHeaders, HttpStatus.NOT_FOUND);
//        }
    
    @GetMapping("/usuario/{id}/anuncios")
    public List<Anuncio> getAllByUserId(@PathVariable("id") Long id) {
        return anuncService.readAllByUserId(id);
    }

    @PostMapping("/anuncio")
    public ResponseEntity post(@RequestBody Anuncio anuncio) {
        Map<String, String> errors = anuncService.validate(anuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            anuncService.create(anuncio);
            httpHeaders.add("Location", "/anuncio/" + anuncio.getId());
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @DeleteMapping("/anuncio/{id}")
    public void delete(@PathVariable("id") Long id) {
        anuncService.delete(id);
    }

    @PutMapping("/anuncio/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Anuncio anuncio) {
        anuncio.setId(id);
        Map<String, String> errors = anuncService.validate(anuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            anuncService.update(anuncio);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/anuncio/{id}")
    public ResponseEntity patch(@PathVariable("id") Long id, @RequestBody Map<String, String> body) throws ParseException {
        body.put("id", id.toString());
        Anuncio anuncio = anuncService.merge(body);
        Map<String, String> errors = anuncService.validate(anuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            anuncService.update(anuncio);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

}
