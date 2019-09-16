package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.FotoAnuncio;

public interface IFotoAnuncioDao {
    
    public void create(FotoAnuncio fotoanuncio);
    
    public List<FotoAnuncio> getAllByAnuncId(Long id);

    public FotoAnuncio getById(Long id);

    public void update(FotoAnuncio fotoanuncio);

    public void delete(FotoAnuncio fotoanuncio);
    
    public void deleteAllByAnuncId(Long id);

    public void closeConnection();

}
