/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculosonline.controller;

import java.util.List;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import veiculosonline.database.entity.Mensagem;
import veiculosonline.service.MensagemService;

/**
 *
 * @author rodrigo
 */
public class MensagemRestController {
     private MensagemService msgService = new MensagemService();

    @GetMapping("/chat/{id}/mensagens")
    public List<Mensagem> getAllByChatId(@PathVariable("id") Long id) {
        return msgService.readAllByChatId(id);
    }
   
    @DeleteMapping("/chat/{id}/mensagens")
    public void deleteAllByChatId(@PathVariable("id") Long id) {
        msgService.deleteAllByChatId(id);
    }

    @GetMapping("/mensagem/{id}")
    public Mensagem getById(@PathVariable("id") Long id) {
        return msgService.readById(id);
    }

    @DeleteMapping("/mensagem/{id}")
    public void delete(@PathVariable("id") Long id) {
        msgService.delete(id);
    }
    
    @PostMapping("/mensagem")
    public ResponseEntity post(@RequestBody Mensagem mensagem) {
        HttpHeaders httpHeaders = new HttpHeaders();
            msgService.create(mensagem);
            httpHeaders.add("Location", "/mensagem/" + mensagem.getId());
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
}
