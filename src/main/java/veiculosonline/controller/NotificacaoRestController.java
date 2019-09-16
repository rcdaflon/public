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
import veiculosonline.database.entity.Notificacao;
import veiculosonline.service.NotificacaoService;

/**
 *
 * @author rodrigo
 */
public class NotificacaoRestController {
     private NotificacaoService notifService = new NotificacaoService();

    @GetMapping("/anuncio/{id}/notificacoes")
    public List<Notificacao> getAllByAnuncId(@PathVariable("id") Long id) {
        return notifService.readAllByAnuncId(id);
    }
   
    @DeleteMapping("/anuncio/{id}/notificacoes")
    public void deleteAllByAnuncId(@PathVariable("id") Long id) {
        notifService.deleteAllByAnuncId(id);
    }
    
    @GetMapping("/usuario/{id}/notificacoes")
    public List<Notificacao> getAllByUserId(@PathVariable("id") Long id) {
        return notifService.readAllByUserId(id);
    }
   
    @DeleteMapping("/usuario/{id}/notificacoes")
    public void deleteAllByUserId(@PathVariable("id") Long id) {
        notifService.deleteAllByUserId(id);
    }

    @GetMapping("/notificacao/{id}")
    public Notificacao getById(@PathVariable("id") Long id) {
        return notifService.readById(id);
    }

    @DeleteMapping("/notificacao/{id}")
    public void delete(@PathVariable("id") Long id) {
        notifService.delete(id);
    }
    
    @PostMapping("/notificacao")
    public ResponseEntity post(@RequestBody Notificacao notificacao) {
        HttpHeaders httpHeaders = new HttpHeaders();
            notifService.create(notificacao);
            httpHeaders.add("Location", "/notificacao/" + notificacao.getId());
            return new ResponseEntity<>(httpHeaders, HttpStatus.CREATED);
    }
}
