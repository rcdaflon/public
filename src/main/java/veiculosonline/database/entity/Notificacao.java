package veiculosonline.database.entity;

import java.sql.Timestamp;

public class Notificacao {
    
    private Long id;
    private Long usuario_id;
    private Long anuncio_id;
    private Timestamp data_hora;
    private String descricao;

    public Notificacao() {
    }

    public Notificacao(Long id, Long usuario_id, Long anuncio_id, Timestamp data_hora, String descricao) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.anuncio_id = anuncio_id;
        this.data_hora = data_hora;
        this.descricao = descricao;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setAnuncio_id(Long anuncio_id) {
        this.anuncio_id = anuncio_id;
    }

    public void setData_hora(Timestamp data_hora) {
        this.data_hora = data_hora;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public Long getAnuncio_id() {
        return anuncio_id;
    }

    public Timestamp getData_hora() {
        return data_hora;
    }

    public String getDescricao() {
        return descricao;
    }
    
    
    
}
