package br.veiculosonline.database.dao;

import java.util.List;
import br.veiculosonline.database.entity.FotoAnuncio;

public interface IFotoAnuncioDao {
    
    public void create(FotoAnuncio fotoanuncio);
    
    public List<FotoAnuncio> readAllByAnuncId(Long id);

    public FotoAnuncio readById(Long id);
    
    public Integer countByAnuncId(Long id);

    public void update(FotoAnuncio fotoanuncio);

    public void delete(FotoAnuncio fotoanuncio);
    
    public void deleteAllByAnuncId(Long id);

    public void closeConnection();

}
