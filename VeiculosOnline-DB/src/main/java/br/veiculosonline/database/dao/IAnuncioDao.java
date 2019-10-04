/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.database.dao;

import java.util.List;
import br.veiculosonline.database.entity.Anuncio;
import java.math.BigDecimal;

/**
 *
 * @author rodrigo
 */
public interface IAnuncioDao {

    public void create(Anuncio anuncio);

    public List<Anuncio> readAll();
    
    public List<Anuncio> readAllByUserId(Long id);
    
    public List<Anuncio> readAllByUserIdAndName(Long id, String titulo);

    public Integer readTotalCountByUserId(Long id);
    
    public Anuncio readById(Long id);
    
    public List<Anuncio> readAllByTitulo(String titulo);
    
    public List<Anuncio> readByAno(Integer ano);
    
    public List<Anuncio> readByKilometragem(Integer kilometragem);
    
    public List<Anuncio> readByPreco(BigDecimal preco_min, BigDecimal preco_max);
    
    public List<Anuncio> readByStatus(String status);
    
    public List<Anuncio> readByStatusAndName(String status, String titulo);

    public void update(Anuncio anuncio);
    
    public void updateByAdm(Anuncio anuncio);
    

    public void delete(Long id);
    
    public void deleteAllByUserId(Long id);

    public void closeConnection();

}
