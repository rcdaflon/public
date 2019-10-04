/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.mensagem;

import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.database.dao.IChatDao;
import br.veiculosonline.database.dao.IMensagemDao;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Chat;
import br.veiculosonline.database.entity.Mensagem;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class MensagemListController {
    
    @Autowired
    IMensagemDao msgDao;

    @GetMapping("mensagem/{chatId}")
    public String getMsgByChatId(@PathVariable("chatId") Long chatId, @ModelAttribute("chat") Search search, Model model, HttpSession session) {

        List<Mensagem> msgList = msgDao.readByChatId(chatId);

        model.addAttribute("msgList", msgList != null ? msgList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "chat/chat";
    }

}
