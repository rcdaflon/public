/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.pojo;

import java.math.BigDecimal;

/**
 *
 * @author Rodrigo
 */
public class Filtro {
    
    private Integer ano;
    private Integer kilometragem;
    private String titulo;
    private BigDecimal preco_min;
    private BigDecimal preco_max;
    private String not_found;

    public Filtro() {
    }

    public Filtro(Integer ano, Integer kilometragem, String titulo, BigDecimal preco_min, BigDecimal preco_max, String not_found) {
        this.ano = ano;
        this.kilometragem = kilometragem;
        this.titulo = titulo;
        this.preco_min = preco_min;
        this.preco_max = preco_max;
        this.not_found = not_found;
    }

    public String getNot_found() {
        return not_found;
    }

    public void setNot_found(String not_found) {
        this.not_found = not_found;
    }
    
    public Integer getAno() {
        return ano;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public String getTitulo() {
        return titulo;
    }

    public BigDecimal getPreco_min() {
        return preco_min;
    }

    public BigDecimal getPreco_max() {
        return preco_max;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setPreco_min(BigDecimal preco_min) {
        this.preco_min = preco_min;
    }

    public void setPreco_max(BigDecimal preco_max) {
        this.preco_max = preco_max;
    }
    
    
    
}
