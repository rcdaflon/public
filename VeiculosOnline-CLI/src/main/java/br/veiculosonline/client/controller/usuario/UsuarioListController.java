/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.usuario;

import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Usuario;
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
public class UsuarioListController {

    @Autowired
    IUsuarioDao usuarioDao;

    @GetMapping("usuario/list")
    public String getListSearch(@ModelAttribute("search") Search search, Model model) {

        List<Usuario> usuarioList = usuarioDao.readByName(search.getContent());

        model.addAttribute("usuarioList", usuarioList != null ? usuarioList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "usuario/list";
    }

    @PostMapping("usuario/list")
    public String search(@ModelAttribute("search") Search search, Model model) {

        List<Usuario> usuarioList = usuarioDao.readByName(search.getContent());

        model.addAttribute("usuarioList", usuarioList != null ? usuarioList : Collections.EMPTY_LIST);
        model.addAttribute("search", search);

        return "usuario/list";
    }

    @GetMapping("/usuario/editUser")
    public String edit(Model model, HttpSession session) {

        Usuario usuario = usuarioDao.readById(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))));

        model.addAttribute("usuario", usuario);

        return "usuario/editUser";
    }
    
    @GetMapping("/usuario/editAdm/{id}")
    public String editById(@PathVariable("id") Long id, Model model) {

        Usuario usuario = usuarioDao.readById(id);

        model.addAttribute("usuario", usuario);

        return "usuario/editAdm";
    }

    @GetMapping("/usuario/delete/{id}")
    public String delete(@PathVariable("id") Long id, Model model) {

        usuarioDao.delete(id);

        return "redirect:/usuario/list";
    }

    @GetMapping("/usuario/add")
    public String add(Model model) {

        model.addAttribute("usuario", new Usuario());

        return "usuario/add";
    }

}
