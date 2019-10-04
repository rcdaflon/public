/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.validator;

import br.veiculosonline.database.entity.Usuario;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author marcelo
 */
@Component
public class UsuarioFormValidator implements Validator {

    
    @Override
    public boolean supports(Class<?> type) {
        return Usuario.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "");
        
    }

}
