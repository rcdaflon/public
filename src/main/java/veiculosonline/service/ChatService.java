package veiculosonline.service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
import veiculosonline.database.dao.IChatDao;
import veiculosonline.database.dao.impl.ChatDao;
import veiculosonline.database.entity.Chat;

public class ChatService {
    private IChatDao dao = new ChatDao();
    
    public List<Chat> readAllByAnuncId(Long id) {
        return dao.getAllByAnuncId(id);
    }

    public List<Chat> readAllByUserId(Long id) {
        return dao.getAllByUserId(id);
    }
    
    public Chat readById(Long id) {
        return dao.getById(id);
    }

    public void create(Chat fotoanuncio) {
        dao.create(fotoanuncio);
    }
    
    public void delete(Long id) {
        Chat chat = dao.getById(id);
        if (chat != null) {
            dao.delete(chat);
        }
    }

    public void deleteAllByUserId(Long id) {
        dao.deleteAllByUserId(id);
    }
    
    public void deleteAllByAnuncId(Long id) {
        dao.deleteAllByAnuncId(id);
    }

    

}
