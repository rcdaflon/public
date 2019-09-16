package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.Chat;

public interface IChatDao {

    public void create(Chat chat);

    public List<Chat> getAllByAnuncId(Long id);
    
    public List<Chat> getAllByUserId(Long id);

    public Chat getById(Long id);

    public void delete(Chat chat);

    public void deleteAllByUserId(Long id);
    
    public void deleteAllByAnuncId(Long id);

    public void closeConnection();

}
