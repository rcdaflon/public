/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.pojo;

/**
 *
 * @author rodrigo
 */
public class Login {
    
    private String email;
    private String senha;
    private String tipo;
    private String msg = "";
    
    public Login() {
    }
    
    public Login(String email, String senha, String tipo, String msg) {
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
        this.msg = msg;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "Login{" + "email=" + email + ", senha=" + senha + ", msg=" + msg + '}';
    }
}

