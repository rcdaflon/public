package veiculosonline.database.entity;

public class FotoAnuncio {
    
    private Long id;
    private Long anuncio_id;
    private String nome;

    public FotoAnuncio(Long id, Long anuncio_id, String nome) {
        this.id = id;
        this.anuncio_id = anuncio_id;
        this.nome = nome;
    }

    public FotoAnuncio() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAnuncio_id(Long anuncio_id) {
        this.anuncio_id = anuncio_id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public Long getAnuncio_id() {
        return anuncio_id;
    }

    public String getNome() {
        return nome;
    }
    
    
    
}
