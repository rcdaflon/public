package br.veiculosonline.database.dao;

import java.util.List;
import br.veiculosonline.database.entity.Mensagem;

public interface IMensagemDao {

    public void create(Mensagem mensagem);

    public List<Mensagem> readByChatId(Long id);

    //public List<Mensagem> readByUserId(Long id);

    public Mensagem readById(Long id);

    public void delete(Mensagem mensagem);

    public void deleteAllByUserId(Long id);

    public void deleteByChatId(Long id);

    public void closeConnection();

}
