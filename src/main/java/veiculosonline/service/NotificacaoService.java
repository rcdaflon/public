/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculosonline.service;

import java.util.List;
import veiculosonline.database.dao.INotificacaoDao;
import veiculosonline.database.dao.impl.NotificacaoDao;
import veiculosonline.database.entity.Notificacao;

/**
 *
 * @author rodrigo
 */
public class NotificacaoService {
     private INotificacaoDao dao = new NotificacaoDao();
    
    public List<Notificacao> readAllByAnuncId(Long id) {
        return dao.getAllByAnuncId(id);
    }
    
    public List<Notificacao> readAllByUserId(Long id) {
        return dao.getAllByUserId(id);
    }

    public Notificacao readById(Long id) {
        return dao.getById(id);
    }

    public void create(Notificacao notificacao) {
        dao.create(notificacao);
    }
    
    public void delete(Long id) {
        Notificacao notificacao = dao.getById(id);
        if (notificacao != null) {
            dao.delete(notificacao);
        }
    }

    public void deleteAllByUserId(Long id) {
        dao.deleteAllByUserId(id);
    }
    
    public void deleteAllByAnuncId(Long id) {
        dao.deleteAllByAnuncId(id);
    }

}
