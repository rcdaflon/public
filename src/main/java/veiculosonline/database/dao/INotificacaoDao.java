/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculosonline.database.dao;

import java.util.List;
import veiculosonline.database.entity.Notificacao;

/**
 *
 * @author rodrigo
 */
public interface INotificacaoDao {
    public void create(Notificacao notificacao);

    public List<Notificacao> getAllByAnuncId(Long id);

    public List<Notificacao> getAllByUserId(Long id);

    public Notificacao getById(Long id);

    public void delete(Notificacao notificacao);

    public void deleteAllByUserId(Long id);

    public void deleteAllByAnuncId(Long id);

    public void closeConnection();
}
