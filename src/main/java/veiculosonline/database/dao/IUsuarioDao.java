package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.Usuario;

/**
 *
 * @author Rodrigo
 */
public interface IUsuarioDao {
    
    public void create(Usuario usuario);
    
    public List<Usuario> getAll();
    
    public Usuario getById(Long id);
    
    public Usuario getByEmail(String email);
    
    public void update(Usuario usuario);
    
    public void delete(Usuario usuario);
    
    public void closeConnection();
    
}
