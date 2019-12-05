package br.veiculosonline.client.controller;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.pojo.Login;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.dao.IFotoAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import br.veiculosonline.database.entity.FotoAnuncio;
import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
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

    @Autowired
    IFotoAnuncioDao fotoAnuncioDao;

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

        return "redirect:/";
    }

    @GetMapping("/")
    public String index(Model model, HttpSession session) {

        model.addAttribute("filtro", new Filtro());
        return "redirect:/home";

    }

    @GetMapping("/home")
    public String home(@ModelAttribute("filtro") Filtro filtro, Model model, HttpSession session, HttpServletRequest servletRequest) throws IOException {

        List<Anuncio> anuncioList = anuncioDao.readByStatus("Ativo"); //readByStatus("Ativo");

        for (Anuncio anuncio : anuncioList) {
            if (fotoAnuncioDao.readAllByAnuncId(anuncio.getId()).size() > 0) {
                File file = new File(servletRequest.getServletContext().getRealPath("/resources/images/usuario_" + anuncio.getUsuario_id() + "/anuncio_" + anuncio.getId() + "/img1.png"));
                if (file.exists()) {

                    byte[] fileContent = FileUtils.readFileToByteArray(file);

                    String encodeString = Base64.getEncoder().encodeToString(fileContent);

                    anuncio.setFoto_capa(encodeString);
                }
            }
        }

        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);

        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("filtro", filtro);

        return "/home";
    }

    @PostMapping("/home")
    public String homePost(Model model, HttpSession session, HttpServletRequest servletRequest) throws IOException {

        List<Anuncio> anuncioList = anuncioDao.readAll();

        for (Anuncio anuncio : anuncioList) {
            if (fotoAnuncioDao.readAllByAnuncId(anuncio.getId()).size() > 0) {
                File file = new File(servletRequest.getServletContext().getRealPath("/resources/images/usuario_" + anuncio.getUsuario_id() + "/anuncio_" + anuncio.getId() + "/img1.png"));
                if (file.exists()) {

                    byte[] fileContent = FileUtils.readFileToByteArray(file);

                    String encodeString = Base64.getEncoder().encodeToString(fileContent);

                    anuncio.setFoto_capa(encodeString);
                }
            }
        }

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

