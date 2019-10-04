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
import org.springframework.validation.Validator;


/**
 *
 * @author Rodrigo
 */
@Component
public class LoginFormValidator implements Validator {

    @Autowired
    IUsuarioDao usuarioDao;
    
    @Override
    public boolean supports(Class<?> type) {
        return Login.class.equals(type);
    }

    @Override
    public void validate(Object target, Errors errors) {

        Login login = (Login) target;
        
        Usuario usuario = null;

        if (login.getEmail() == null || login.getEmail().isEmpty()) {

            errors.rejectValue("email", "");

        } else if (login.getSenha() == null || login.getSenha().isEmpty()) {

            errors.rejectValue("senha", "");

        } else {
            
            usuario = usuarioDao.readByUserEmailAndSenha(login.getEmail(), login.getSenha());

            if (usuario == null) {
                errors.rejectValue("msg", "");
            }
        }
    }
}
