/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.database.enumerator;

/**
 *
 * @author Marcelo
 */
public enum ETipo {
    
    BASIC("FALSE"),
    ADMIN("TRUE");
    
    private String str;
    
    ETipo(String str){
        this.str = str;
    }
    
    public String get(){
        return str;
    }
    
}