/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.service;

import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author marcelo
 */
public class UsuarioService {
    
    @Autowired
    IUsuarioDao userDao;
    
    public Usuario merge(Usuario user){
        Usuario merged = new Usuario();
        if (user != null) {
            Long id = user.getId();
            if (id != null) {
                Usuario usuario = userDao.readById(id);
                if (usuario != null) {
                    merged.setEmail(usuario.getEmail());
                    merged.setNome(usuario.getNome());
                    merged.setSenha(usuario.getSenha());
                    merged.setAgencia(usuario.getAgencia());
                    merged.setBanco(usuario.getBanco());
                    merged.setConta(usuario.getConta());
                    merged.setCpf(usuario.getCpf());
                    merged.setId(usuario.getId());
                    merged.setData_nasc(usuario.getData_nasc());
                    merged.setStatus(usuario.getStatus());
                    merged.setTipo(usuario.getTipo());
                    if (!user.getNome().isEmpty() && user.getNome() != null) {
                        merged.setNome(user.getNome());
                    }
                    if (!user.getSenha().isEmpty() && user.getNome() != null) {
                        merged.setNome(user.getSenha());
                    }
                    if (!user.getAgencia().isEmpty() && user.getNome() != null) {
                        merged.setAgencia(user.getAgencia());
                    }
                    if (!user.getBanco().isEmpty() && user.getNome() != null) {
                        merged.setBanco(user.getBanco());
                    }
                    if (!user.getConta().isEmpty() && user.getNome() != null) {
                        merged.setConta(user.getConta());
                    }
                    if (!user.getCpf().isEmpty() && user.getNome() != null) {
                        merged.setCpf(user.getCpf());
                    }
                    if (!user.getStatus().isEmpty() && user.getNome() != null) {
                        merged.setStatus(user.getStatus());
                    }
                    if (!user.getTipo().isEmpty() && user.getTipo() != null) {
                        merged.setTipo(user.getTipo());
                    }
                }
            }
        }
        return merged;
    }
}
