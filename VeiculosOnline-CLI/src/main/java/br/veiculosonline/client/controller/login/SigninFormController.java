/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.login;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.validator.SigninFormValidator;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Anuncio;
import br.veiculosonline.database.entity.Usuario;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Rodrigo
 */
@Controller
public class SigninFormController {
    
    @Autowired
    SigninFormValidator signinValidator;

    @Autowired
    IUsuarioDao userDao;

    @Autowired
    IAnuncioDao anuncioDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(signinValidator);
    }
    
    @PostMapping("/usuario/add")
    public String addUsuario(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {
            return "usuario/add";
        } else {

            userDao.create(usuario);
            List<Anuncio> anuncioList = anuncioDao.readAll();
            model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
            model.addAttribute("filtro", new Filtro());
            model.addAttribute("usuario_tipo", usuario.getTipo());
            usuario = userDao.readByEmail(usuario.getEmail());
            
            session.setAttribute("usuario_tipo", usuario.getTipo());
            session.setAttribute("email", usuario.getEmail());
            session.setAttribute("usuario_id", usuario.getId());

            return "redirect:/home";
        }
    }
    
}
