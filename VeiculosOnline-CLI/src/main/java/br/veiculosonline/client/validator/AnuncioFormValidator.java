/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.validator;

import br.veiculosonline.database.entity.Anuncio;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author rodrigo
 */
@Component
public class AnuncioFormValidator implements Validator {
    
    @Override
    public boolean supports(Class<?> type) {
        return Anuncio.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Anuncio anuncio = (Anuncio) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "laudo_veicular", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formas_pagamento", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portas", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantidade_donos", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "final_placa", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cor", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motor", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ano", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "combustivel", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kilometragem", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cambio", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marca", "");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preco", "");
        
    }
}
