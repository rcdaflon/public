package br.veiculosonline.client.controller;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.pojo.Login;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    IAnuncioDao anuncioDao;

    @GetMapping("/login")
    public String auth(Model model) {

        model.addAttribute("login", new Login());

        return "login/login";
    }
    
    @GetMapping("/logout")
    public String logout(Model model, HttpSession session) {

        session.invalidate();
        
        List<Anuncio> anuncioList = anuncioDao.readAll();
        
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        
        return "redirect:/home";
    }

    @GetMapping("/")
    public String index(@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session) {

        List<Anuncio> anuncioList = anuncioDao.readByStatus("Ativo");
        
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("filtro", filtro);
        
        return "/home";
    }
    
    @GetMapping("/home")
    public String home(@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session) { 

        List<Anuncio> anuncioList = anuncioDao.readByStatus("Ativo"); //readByStatus("Ativo");
        
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("filtro", filtro);
        
        return "/home";
    }
    
    @PostMapping("/home")
    public String homePost(Model model, HttpSession session) { 

        List<Anuncio> anuncioList = anuncioDao.readAll();
        
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("filtro", new Filtro());
        
        return "/home";
    }

}

//    @GetMapping("/")
//    public String getHome(Model model) {
//        return "/home";
//    }
//
//    @GetMapping("/usuario/login")
//    public String getUserLogin(Model model) {
//        return "usuario/login";
//    }
//    
//    @GetMapping("/usuario/cadastrar")
//    public String getUserSignup(Model model) {
//        return "usuario/cadastrar";
//    }
//
//    
//    @GetMapping("/usuario/crud")
//    public String getUserList(Model model) {
//        return "usuario/crud";
//    }
//
//    @GetMapping("/usuario/editar")
//    public String getUserFormEditar(Model model) {
//        return "usuario/editar";
//    }
//    
//    @GetMapping("/anuncio/list")
//    public String getAnuncList(Model model) {
//        return "anuncio/list";
//    }
//
//    @GetMapping("/anuncio/adicionar")
//    public String getAnuncFormCadastrar(Model model) {
//        return "anuncio/formCadastrar";
//    }
//
//    @GetMapping("/anuncio/editar")
//    public String getAnuncFormEditar(Model model) {
//        return "anuncio/formEditar";
//    }
//    

