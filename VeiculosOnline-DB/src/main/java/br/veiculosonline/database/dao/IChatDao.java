package br.veiculosonline.database.dao;

import java.util.List;
import br.veiculosonline.database.entity.Chat;

public interface IChatDao {

    public void create(Chat chat);

    public List<Chat> readAllByAnuncId(Long id);
    
    public List<Chat> readAllByUserId(Long id);

    public Chat readById(Long id);
    
    public Chat readByUserAndAnuncioId(Long usuario_id, Long anuncio_id);

    public void delete(Long id);

    public void deleteAllByUserId(Long id);
    
    public void deleteAllByAnuncId(Long id);

    public void closeConnection();

}
