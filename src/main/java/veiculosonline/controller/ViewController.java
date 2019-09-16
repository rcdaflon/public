package veiculosonline.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {
    
    @GetMapping("/home")
    public String getHome(Model model) {
        return "/home";
    }


     @GetMapping("/usuario/login")
    public String getUserLogin(Model model) {
        return "usuario/login";
    }

    
    @GetMapping("/usuario/list")
    public String getUserList(Model model) {
        return "usuario/list";
    }

    @GetMapping("/usuario/adicionar")
    public String getUserFormCadastrar(Model model) {
        return "usuario/formCadastrar";
    }

    @GetMapping("/usuario/editar")
    public String getUserFormEditar(Model model) {
        return "usuario/formEditar";
    }
    
    @GetMapping("/anuncio/list")
    public String getAnuncList(Model model) {
        return "anuncio/list";
    }

    @GetMapping("/anuncio/adicionar")
    public String getAnuncFormCadastrar(Model model) {
        return "anuncio/formCadastrar";
    }

    @GetMapping("/anuncio/editar")
    public String getAnuncFormEditar(Model model) {
        return "anuncio/formEditar";
    }
    
}
