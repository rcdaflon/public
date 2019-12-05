package br.veiculosonline.database.dao;

import br.veiculosonline.database.entity.Usuario;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public interface IUsuarioDao {
    
    public void create(Usuario usuario);
    
    public List<Usuario> readAll();
    
    public Usuario readById(Long id);
    
    public Usuario readByEmail(String email);
    
    public List<Usuario> readByName(String nome);
    
    public Usuario readByUserEmailAndSenha(String email, String senha);
    
    public void update(Usuario usuario);
    
    public void updateAdm(Usuario usuario);
    
    public void delete(Long id);

    
}
