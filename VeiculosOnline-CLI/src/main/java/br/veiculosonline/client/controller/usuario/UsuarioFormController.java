/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.usuario;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.validator.UsuarioFormValidator;
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
 * @author marcelo
 */
@Controller
public class UsuarioFormController {

    @Autowired
    UsuarioFormValidator userValidator;

    @Autowired
    IUsuarioDao userDao;

    @Autowired
    IAnuncioDao anuncioDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(userValidator);
    }

    @PostMapping("/usuario/editAdm")
    public String saveAdm(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            
            return "usuario/edit";

        } else {

            userDao.updateAdm(usuario);

            return "redirect:/usuario/list";
        }
    }
    
    @PostMapping("/usuario/edit")
    public String save(@ModelAttribute("usuario") @Validated Usuario usuario, BindingResult result, Model model) {

        if (result.hasErrors()) {
            
            return "usuario/edit";

        } else {

            userDao.update(usuario);

            return "redirect:/home";
        }
    }

}
