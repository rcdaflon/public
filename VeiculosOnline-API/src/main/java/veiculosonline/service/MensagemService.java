/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package veiculosonline.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import veiculosonline.database.dao.IMensagemDao;
import veiculosonline.database.dao.impl.MensagemDao;
import veiculosonline.database.entity.Mensagem;

/**
 *
 * @author rodrigo
 */
public class MensagemService {
    
    @Autowired
    IMensagemDao dao;
    
    public List<Mensagem> readAllByChatId(Long id) {
        return dao.getAllByChatId(id);
    }

    public Mensagem readById(Long id) {
        return dao.getById(id);
    }

    public void create(Mensagem mensagem) {
        dao.create(mensagem);
    }
    
    public void delete(Long id) {
        Mensagem mensagem = dao.getById(id);
        if (mensagem != null) {
            dao.delete(mensagem);
        }
    }

    public void deleteAllByUserId(Long id) {
        dao.deleteAllByUserId(id);
    }
    
    public void deleteAllByChatId(Long id) {
        dao.deleteAllByChatId(id);
    }

}
