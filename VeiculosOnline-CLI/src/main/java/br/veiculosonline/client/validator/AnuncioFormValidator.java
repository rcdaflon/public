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

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "titulo", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "descricao", "required", "Campo obrigatório!");
        //ValidationUtils.rejectIfEmptyOrWhitespace(errors, "laudo_veicular", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "formas_pagamento", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "portas", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "quantidade_donos", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "final_placa", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cor", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "motor", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "ano", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "combustivel", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "kilometragem", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "cambio", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "modelo", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marca", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "preco", "required", "Campo obrigatório!");
        
    }
}
