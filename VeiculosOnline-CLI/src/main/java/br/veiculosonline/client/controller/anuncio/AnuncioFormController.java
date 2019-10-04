/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.anuncio;

import br.veiculosonline.client.service.AnuncioService;
import br.veiculosonline.client.validator.AnuncioFormValidator;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class AnuncioFormController {

    @Autowired
    AnuncioFormValidator anuncioValidator;

    @Autowired
    IAnuncioDao anuncioDao;
    
    AnuncioService anuncioService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(anuncioValidator);
    }

    @PostMapping("/anuncio/editUser")
    public String saveUser(@ModelAttribute("anuncio") @Validated Anuncio anuncio, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "anuncio/editUser";

        } else {
            anuncioDao.update(anuncio);

            return "redirect:/anuncio/listUser";
        }
    }
    
    @PostMapping("/anuncio/editAdm")
    public String saveAdm(@ModelAttribute("anuncio") Anuncio anuncio, BindingResult result, Model model) {

        if (result.hasErrors()) {

            return "anuncio/editAdm";

        } else {
            
            anuncioDao.updateByAdm(anuncio);

            return "redirect:/anuncio/listAdm";
        }
    }
    
    @PostMapping("/anuncio/add")
    public String addAnuncio(@ModelAttribute("anuncio") @Validated Anuncio anuncio, BindingResult result, Model model, HttpSession session) {
        if (result.hasErrors()) {

            return "anuncio/add";

        } else {
            
            anuncio.setUsuario_id(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))));
            anuncioDao.create(anuncio);

            return "redirect:/anuncio/list";
        }
    }
    
    

}
