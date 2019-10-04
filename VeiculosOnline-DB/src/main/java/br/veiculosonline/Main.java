/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline;

import br.veiculosonline.database.dao.impl.UsuarioDao;
import br.veiculosonline.database.entity.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Main {

    public static void main(String[] args) throws SQLException {

        UsuarioDao usuarioDao = new UsuarioDao();
          
        List<Usuario> usuarioList = usuarioDao.readAll();

        for (Usuario usuario : usuarioList) {
            System.out.println(usuario);
        }
        
        //------------------------------
        
        Usuario usuario = usuarioDao.readById(1L);
        usuario.setNome("Rodrigo");        
        usuarioDao.update(usuario);

        Usuario usuarioUpdated = usuarioDao.readById(usuario.getId());
        System.out.println(usuarioUpdated);

    }
    
}