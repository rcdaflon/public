/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.anuncio;

import br.veiculosonline.client.pojo.Search;
import br.veiculosonline.client.validator.AnuncioFormValidator;
import br.veiculosonline.client.validator.FiltroFormValidator;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.dao.IFotoAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import br.veiculosonline.database.entity.FotoAnuncio;
import java.util.Collections;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Base64;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author marcelo
 */
@Controller
public class AnuncioListController {

    private static final String NOT_FOUND_IMG = "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";

    

    @Autowired
    IAnuncioDao anuncioDao;

    @Autowired
    IFotoAnuncioDao fotoAnuncioDao;

    @GetMapping("anuncio/listUser")
    public String getListUserSearch(@ModelAttribute("search") Search search, Model model, HttpSession session) {

        List<Anuncio> anuncioList = anuncioDao.readAllByUserIdAndName(Long.parseLong(String.valueOf(session.getAttribute("usuario_id"))), search.getContent());

        model.addAttribute("search", search);
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);

        return "anuncio/listUser";

    }

    @GetMapping("anuncio/listAdm")
    public String getListAdmSearch(Model model, HttpSession session) {

        List<Anuncio> anuncioList = anuncioDao.readAll();

        model.addAttribute("search", new Search());
        model.addAttribute("usuario_tipo", session.getAttribute("usuario_tipo"));
        model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);

        return "anuncio/listAdm";

    }

    @GetMapping("anuncio/{id}")
    public String getById(@PathVariable("id") Long id, Model model, HttpSession session, HttpServletRequest servletRequest) throws IOException {

        Anuncio anuncio = anuncioDao.readById(id);

        model.addAttribute("anuncio", anuncio);

        List<FotoAnuncio> fotosList = fotoAnuncioDao.readAllByAnuncId(id);
        List<String> fotos = new ArrayList<>();
        
        int i = 0;
        for (FotoAnuncio foto : fotosList) {
            i++;

            File file = new File(servletRequest.getServletContext().getRealPath("/resources/images/usuario_" + anuncio.getUsuario_id() + "/anuncio_" + id + "/img" + i + ".png"));

            if (file.exists()) {

                byte[] fileContent = FileUtils.readFileToByteArray(file);

                String encodeString = Base64.getEncoder().encodeToString(fileContent);

                fotos.add(encodeString);
                //model.addAttribute("base64Image", encodeString);
            } else {
                fotos.add(NOT_FOUND_IMG);
                //model.addAttribute("base64Image", NOT_FOUND_IMG);
            }
        }
        model.addAttribute("fotosList", fotos != null ? fotos : Collections.EMPTY_LIST);

        return "anuncio/anuncio";
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
    public String delete(@PathVariable("id") Long id, Model model, HttpServletRequest servletRequest) {


        Integer i = fotoAnuncioDao.countByAnuncId(id);
        for(int j = 0; j < i; j++){
            File file = new File(servletRequest.getServletContext().getRealPath("/resources/images/usuario_" + anuncioDao.readById(id).getUsuario_id() + "/anuncio_" + id + "/img" + i + ".png"));
            file.delete();
        }
        anuncioDao.delete(id);
        return "redirect:/anuncio/listUser";
    }

    @GetMapping("/anuncio/add")
    public String add(Model model) {

        model.addAttribute("anuncio", new Anuncio());

        return "anuncio/add";
    }

}
