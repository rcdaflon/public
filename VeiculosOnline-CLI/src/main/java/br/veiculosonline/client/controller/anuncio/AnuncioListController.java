/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.anuncio;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
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
public class AnuncioListController {

    @Autowired
    IAnuncioDao anuncioDao;

    @GetMapping("anuncio/listUser")
    public String getListUserSearch(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Anuncio> anuncioList = anuncioDao.readAllByUserIdAndName(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))), search.getContent());

        model.addAttribute("search", search);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);

        return "anuncio/listUser";

    }

    @GetMapping("anuncio/listAdm")
    public String getListAdmSearch(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Anuncio> anuncioList = anuncioDao.readAll();

        model.addAttribute("search", search);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);

        return "anuncio/listAdm";

    }

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

    @GetMapping("anuncio/list")
    public String getList(Model model, HttpSession session) {

        List<Anuncio> anuncioList = null;

        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));

        anuncioList = anuncioDao.readByStatus("Ativo");
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        return "anuncio/anuncio";

    }

    @GetMapping("anuncio/{id}")
    public String getById(@PathVariable("id") Long id, Model model, HttpSession session) {

        Anuncio anuncio = anuncioDao.readById(id);

        model.addAttribute("anuncio", anuncio != null ? anuncio : Collections.EMPTY_LIST);

        session.setAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        session.setAttribute("usuario_id", session.getAttribute("usuario_id"));
        model.addAttribute("anuncio_id", id);
        model.addAttribute("usuario_id", session.getAttribute("usuario_id"));
        
        
        return "anuncio/anuncio";
    }

    @PostMapping("anuncio/filtro")
    public String filtro(@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session) {

        List<Anuncio> anuncioList = null;

        if (session.getAttribute("email") != null) {
            anuncioList = anuncioDao.readByStatus("Ativo");
            if (filtro.getAno() != null && filtro.getAno() > 1900) {
                anuncioList = anuncioDao.readByAno(filtro.getAno());
            } else if (filtro.getKilometragem() != null && filtro.getKilometragem() != 0) {
                anuncioList = anuncioDao.readByKilometragem(filtro.getKilometragem());
            } else if (filtro.getPreco_min() != null && filtro.getPreco_max() != null) {
                anuncioList = anuncioDao.readByPreco(filtro.getPreco_min(), filtro.getPreco_max());
            }
        } else {
            return "error";
        }
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("filtro", filtro);

        return "home";
    }

    @GetMapping("/anuncio/editUser/{id}")
    public String editUserById(@PathVariable("id") Long id, Model model) {

        Anuncio anuncio = anuncioDao.readById(id);

        model.addAttribute("anuncio", anuncio);

        return "anuncio/editUser";
    }
    
    @GetMapping("/anuncio/editAdm/{id}")
    public String editAdmById(@PathVariable("id") Long id, Model model) {

        Anuncio anuncio = anuncioDao.readById(id);

        model.addAttribute("anuncio", anuncio);

        return "anuncio/editAdm";
    }

    @GetMapping("/anuncio/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        anuncioDao.delete(id);

        return "redirect:/anuncio/list";
    }

    @GetMapping("/anuncio/add")
    public String add(Model model) {

        model.addAttribute("anuncio", new Anuncio());

        return "anuncio/add";
    }

}
