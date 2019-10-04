package br.veiculosonline.database.entity;

import java.sql.Timestamp;

public class Mensagem {
    
    private Long id;
    private Long usuario_id;
    private Long chat_id;
    private Timestamp data_hora;
    private String texto;

    public Mensagem() {
    }

    public Mensagem(Long id, Long usuario_id, Long chat_id, Timestamp data_hora, String texto) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.chat_id = chat_id;
        this.data_hora = data_hora;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public Long getChat_id() {
        return chat_id;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public String getTexto() {
        return texto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setChat_id(Long chat_id) {
        this.chat_id = chat_id;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }
    
    
    
}
