/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.controller.filtro;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.client.validator.FiltroFormValidator;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.dao.IFotoAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
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
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author rodrigo
 */
@Controller
public class FiltroFormController {

    @Autowired
    IAnuncioDao anuncioDao;

    @Autowired
    IFotoAnuncioDao fotoAnuncioDao;

    @Autowired
    FiltroFormValidator filtroValidator;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.setValidator(filtroValidator);
    }

    @PostMapping("anuncio/filtro")
    public String filtro(@ModelAttribute("filtro") @Validated Filtro filtro, BindingResult result, Model model, HttpSession session, HttpServletRequest servletRequest) throws IOException {

        if (result.hasErrors()) {
            List<Anuncio> anuncioList = anuncioDao.readByStatus("Ativo");

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
            return "home";

        } else {

            if (session.getAttribute("email") != null) {
                List<Anuncio> anuncioList = null;
                anuncioList = anuncioDao.readByStatus("Ativo");
                if (filtro.getAno() != null && filtro.getAno() > 1980) {
                    anuncioList = anuncioDao.readByAno(filtro.getAno());
                } else if (filtro.getKilometragem() != null && filtro.getKilometragem() != 0) {
                    anuncioList = anuncioDao.readByKilometragem(filtro.getKilometragem());
                } else if (filtro.getPreco_min() != null && filtro.getPreco_max() != null) {
                    anuncioList = anuncioDao.readByPreco(filtro.getPreco_min(), filtro.getPreco_max());
                }

                model.addAttribute("anuncioList", anuncioList != null ? anuncioList : Collections.EMPTY_LIST);
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
            } else {
                return "error";
            }
            model.addAttribute("filtro", filtro);

            return "home";
        }
    }
}
