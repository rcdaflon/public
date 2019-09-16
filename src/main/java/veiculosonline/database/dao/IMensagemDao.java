package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.Mensagem;

public interface IMensagemDao {

    public void create(Mensagem mensagem);

    public List<Mensagem> getAllByChatId(Long id);

    public List<Mensagem> getAllByUserId(Long id);

    public Mensagem getById(Long id);

    public void delete(Mensagem mensagem);

    public void deleteAllByUserId(Long id);

    public void deleteAllByChatId(Long id);

    public void closeConnection();

}
