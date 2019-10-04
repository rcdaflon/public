/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.login;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.pojo.Login;
import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.client.validator.LoginFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Usuario;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class LoginFormController {

    @Autowired
    LoginFormValidator loginFormValidator;

    @Autowired
    IUsuarioDao usuarioDao;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(loginFormValidator);
    }

    @GetMapping("login/login")
    public String login(Model model) {
        model.addAttribute("login", new Login());

        return "login/login";
    }

    @PostMapping("/login/verify")
    public String verify(@ModelAttribute("login") @Validated Login login, BindingResult result, Model model, HttpSession session) {

        if (result.hasErrors()) {

            return "login/login";

        } else {

            session.setAttribute("email", login.getEmail());
            Usuario user = usuarioDao.readByEmail(login.getEmail());
            session.setAttribute("usuario_id", String.valueOf(user.getId()));
            session.setAttribute("usuario_tipo", user.getTipo());
            model.addAttribute("usuario_tipo", user.getTipo());
            if ("USR".equals(user.getTipo())) {
                return "redirect:/home";
            } else {
                model.addAttribute("msg", "Veiculos Online - Dashboard");
                return "dashboard";
            }

        }
    }

}
