/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.chat;

import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.database.dao.IAnuncioDao;
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

/**
 *
 * @author marcelo
 */
@Controller
public class ChatListController {

    @Autowired
    IUsuarioDao usuarioDao;

    @Autowired
    IAnuncioDao anuncioDao;

    @Autowired
    IMensagemDao msgDao;

    @Autowired
    IChatDao chatDao;

    @GetMapping("chat/{userId}/{anuncioId}")
    public String getChat(@PathVariable("anuncioId") Long anuncioId, @PathVariable("userId") Long userId, @ModelAttribute("chat") Chat chat, Model model, HttpSession session) {

        List<Mensagem> msgList = null;
        List<Chat> chatList = chatDao.readAllByUserId(userId);
        if (session.getAttribute("email") != null) {
            chat = chatDao.readByUserAndAnuncioId(userId, anuncioId);
            if (chat == null) {
                chat.setAnuncio_id(anuncioId);
                chat.setUsuario_id(userId);
                chatDao.create(chat);
            }

            chat = chatDao.readByUserAndAnuncioId(userId, anuncioId);
            msgList = msgDao.readByChatId(chat.getId());

            model.addAttribute("interessado_id", userId);
            model.addAttribute("chat", chat != null ? chat : Collections.EMPTY_LIST);
            model.addAttribute("msgList", msgList != null ? msgList : Collections.EMPTY_LIST);

            return "chat/chat";
        } else {
            return "error";
        }
    }

    @GetMapping("chat/list")
    public String getUserChatList(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Chat> chatList = chatDao.readAllByUserId(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))));

        model.addAttribute("chatList", chatList != null ? chatList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "chat/list";
    }

    @GetMapping("chat/{id}")
    public String getChat(@PathVariable("id") Long id, @ModelAttribute("search") Search search, Model model, HttpSession session) {

        if (session.getAttribute("email") != null) {
            Chat chat = chatDao.readById(id);
            List<Mensagem> msgList = msgDao.readByChatId(id);

            model.addAttribute("chat", chat != null ? chat : Collections.EMPTY_LIST);
            model.addAttribute("msgList", msgList != null ? msgList : Collections.EMPTY_LIST);
            model.addAttribute("usuario_id", session.getAttribute("usuario_id"));

            return "chat/chat";
        } else {
            return "error";
        }
    }

    @GetMapping("chat/delete/{id}")
    public String deleteChat(@PathVariable("id") Long id, Model model) {

        chatDao.delete(id);

        return "redirect:chat/list";
    }

}
