/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.search;

import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.client.validator.AnuncioFormValidator;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.dao.IFotoAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Rodrigo
 */
@Controller
public class SearchController {

    
    @Autowired
    IAnuncioDao anuncioDao;

    @Autowired
    IFotoAnuncioDao fotoAnuncioDao;

   

    @PostMapping("anuncio/listUser")
    public String searchUser(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Anuncio> anuncioList = null;

        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        anuncioList = anuncioDao.readAllByUserIdAndName(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))), search.getContent());
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        return "anuncio/listUser";

    }

    @PostMapping("anuncio/listAdm")
    public String searchAdm(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Anuncio> anuncioList = null;

        anuncioList = anuncioDao.readByStatusAndName("Em Avaliacao", search.getContent());

        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "anuncio/listAdm";

    }
}
