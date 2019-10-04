/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.chat;

import br.veiculosonline.database.dao.IChatDao;
import br.veiculosonline.database.dao.IMensagemDao;
import br.veiculosonline.database.entity.Chat;
import br.veiculosonline.database.entity.Mensagem;
import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class ChatFormController {
    
    @Autowired
    IMensagemDao msgDao;
    
    @Autowired
    IChatDao chatDao;
    
    @PostMapping("chat/{userId}/{anuncioId}")
    public String createChat(@PathVariable("anuncioId") Long anuncioId,@PathVariable("userId") Long userId, Model model) {

        List<Mensagem> msgList = null;
        Chat chat = new Chat();
        chat = chatDao.readByUserAndAnuncioId(userId, anuncioId);
        if(chat == null){
            chat.setAnuncio_id(anuncioId);
            chat.setUsuario_id(userId);
            Timestamp dataDeHoje = new Timestamp(System.currentTimeMillis());
            chat.setData_hora(dataDeHoje);
            chatDao.create(chat);
            chat = chatDao.readByUserAndAnuncioId(userId, anuncioId); //pega id gerado pelo psql
        } else {
            msgList = msgDao.readByChatId(chat.getId());
        }
        model.addAttribute("msg", msgList != null ? msgList : Collections.EMPTY_LIST);
        model.addAttribute("chat", chat != null ? chat : Collections.EMPTY_LIST);
       
        return "chat/chat";
    }
    
    @PostMapping("chat")
    public String saveMsg(@ModelAttribute("msg") Mensagem mensagem, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "chat/mensagem";

        } else {
            
            msgDao.create(mensagem);
            return "redirect:/chat/chat";
            
        }
    }
        

}
