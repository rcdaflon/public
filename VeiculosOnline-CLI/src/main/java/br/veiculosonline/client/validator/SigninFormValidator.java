/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.validator;

import br.veiculosonline.client.pojo.Login;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 *
 * @author marcelo
 */
@Component
public class SigninFormValidator implements Validator {

    @Autowired
    IUsuarioDao usuarioDao;

    @Override
    public boolean supports(Class<?> type) {
        return Usuario.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Usuario usuario = (Usuario) target;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nome", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", "Campo obrigatório!");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "senha", "required", "Campo obrigatório!");

        if (usuario.getSenha().length() < 6) {
            errors.rejectValue("senha", "");
        } else {

            Usuario user_buscado = usuarioDao.readByEmail(usuario.getEmail());

            if (user_buscado == null) {
            } else {
                errors.rejectValue("email", "");
            }
        }
    }

}
