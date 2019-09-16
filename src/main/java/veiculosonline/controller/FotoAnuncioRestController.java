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
import veiculosonline.database.entity.FotoAnuncio;
import veiculosonline.service.FotoAnuncioService;

public class FotoAnuncioRestController {

    private FotoAnuncioService fotoanuncService = new FotoAnuncioService();

    @GetMapping("/anuncio/{id}/fotos")
    public List<FotoAnuncio> getAllByAnuncId(@PathVariable("id") Long id) {
        return fotoanuncService.readAllByAnuncId(id);
    }
   
    @DeleteMapping("/anuncio/{id}/fotos")
    public void deleteAllByAnuncId(@PathVariable("id") Long id) {
        fotoanuncService.deleteAllByAnuncId(id);
    }

    @GetMapping("/anuncio/foto/{id}")
    public FotoAnuncio getById(@PathVariable("id") Long id) {
        return fotoanuncService.readById(id);
    }

    @DeleteMapping("/anuncio/foto/{id}")
    public void delete(@PathVariable("id") Long id) {
        fotoanuncService.delete(id);
    }
    
    @PutMapping("/anuncio/foto/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody FotoAnuncio fotoanuncio) {
        fotoanuncio.setId(id);
        Map<String, String> errors = fotoanuncService.validate(fotoanuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            fotoanuncService.update(fotoanuncio);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }

    @PatchMapping("/anuncio/foto/{id}")
    public ResponseEntity patch(@PathVariable("id") Long id, @RequestBody Map<String, String> body) throws ParseException {
        body.put("id", id.toString());
        FotoAnuncio fotoanuncio = fotoanuncService.merge(body);
        Map<String, String> errors = fotoanuncService.validate(fotoanuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            fotoanuncService.update(fotoanuncio);
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.ACCEPTED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
    @PostMapping("/anuncio/fotos")
    public ResponseEntity post(@RequestBody FotoAnuncio fotoanuncio) {
        Map<String, String> errors = fotoanuncService.validate(fotoanuncio);
        HttpHeaders httpHeaders = new HttpHeaders();
        if (errors.isEmpty()) {
            fotoanuncService.create(fotoanuncio);
            httpHeaders.add("Location", "/anuncio/fotos/" + fotoanuncio.getId());
            return new ResponseEntity<>(null, httpHeaders, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(errors, httpHeaders, HttpStatus.NOT_ACCEPTABLE);
        }
    }
    
}
