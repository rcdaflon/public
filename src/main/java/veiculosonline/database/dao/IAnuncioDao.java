/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.Anuncio;

/**
 *
 * @author rodrigo
 */
public interface IAnuncioDao {

    public void create(Anuncio anuncio);

    public List<Anuncio> getAll();
    
    public List<Anuncio> getAllByUserId(Long id);

    public Anuncio getById(Long id);

    public void update(Anuncio anuncio);

    public void delete(Anuncio anuncio);
    
    public void deleteAllByUserId(Long id);

    public void closeConnection();

}
