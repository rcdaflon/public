/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.validator;

import br.veiculosonline.client.pojo.Filtro;
import br.veiculosonline.database.dao.IAnuncioDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 *
 * @author rodrigo
 */
@Component
public class FiltroFormValidator implements Validator {

    @Autowired
    IAnuncioDao anuncioDao;

    @Override
    public boolean supports(Class<?> type) {
        return Filtro.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Filtro filtro = (Filtro) target;
        
        if (filtro.getTitulo() != null || !filtro.getTitulo().isEmpty()) {
            if (anuncioDao.readAllByTitulo(filtro.getTitulo()) == null) {
                errors.rejectValue("not_found", "");
            }
        }
        if (filtro.getAno() != null) {
            if (filtro.getAno() < 1980 || filtro.getAno() > 2020) {
                errors.rejectValue("ano", "");
            } else if (anuncioDao.readByAno(filtro.getAno()) == null) {
                errors.rejectValue("not_found", "");
            }
        }
        if (filtro.getKilometragem() != null) {
            if (filtro.getKilometragem() < 0) {
                errors.rejectValue("kilometragem", "");
            } else if (anuncioDao.readByKilometragem(filtro.getKilometragem()) == null) {
                errors.rejectValue("not_found", "");
            }
        }
        if (filtro.getPreco_min() != null && filtro.getPreco_max() != null) {
            if (filtro.getPreco_min().intValue() <= 0) {
                errors.rejectValue("preco_min", "");
            } else if (anuncioDao.readByPreco(filtro.getPreco_min(), filtro.getPreco_max()) == null) {
                errors.rejectValue("not_found", "");
            }
        }

    }
}
