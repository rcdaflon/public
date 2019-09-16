package veiculosonline.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import veiculosonline.database.dao.IFotoAnuncioDao;
import veiculosonline.database.dao.impl.FotoAnuncioDao;
import veiculosonline.database.entity.FotoAnuncio;

public class FotoAnuncioService {

    private IFotoAnuncioDao dao = new FotoAnuncioDao();
    
    public List<FotoAnuncio> readAllByAnuncId(Long id) {
        return dao.getAllByAnuncId(id);
    }

    public FotoAnuncio readById(Long id) {
        return dao.getById(id);
    }

    public void create(FotoAnuncio fotoanuncio) {
        dao.create(fotoanuncio);
    }

    public void update(FotoAnuncio fotoanuncio) {
        dao.update(fotoanuncio);
    }

    public FotoAnuncio merge(Map<String, String> data) {
        FotoAnuncio merged = new FotoAnuncio();
        if (data != null) {
            Long id = Long.parseLong(data.get("id"));
            if (id != null) {
                FotoAnuncio fotoanuncio = dao.getById(id);
                if (fotoanuncio != null) {
                    merged.setAnuncio_id(fotoanuncio.getAnuncio_id());
                    merged.setId(fotoanuncio.getId());
                    merged.setNome(fotoanuncio.getNome());

                    String key = "nome";
                    if (data.containsKey(key)) {
                        merged.setNome(data.get(key));
                    }
                }
            }
        }
        return merged;
    }

    public void delete(Long id) {
        FotoAnuncio fotoanuncio = dao.getById(id);
        if (fotoanuncio != null) {
            dao.delete(fotoanuncio);
        }
    }

    public void deleteAllByAnuncId(Long id) {
        dao.deleteAllByAnuncId(id);
    }

    public Map<String, String> validate(FotoAnuncio fotoanuncio) {
        Map<String, String> errors = new LinkedHashMap<>();

        String campo = fotoanuncio.getNome();
        if (campo == null || campo.isEmpty()) {
            errors.put("Nome", "Campo obrigatorio!");
        } 
        return errors;
    }

}
