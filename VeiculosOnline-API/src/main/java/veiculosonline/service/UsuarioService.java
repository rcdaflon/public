package veiculosonline.service;

import veiculosonline.database.entity.Usuario;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import veiculosonline.database.dao.impl.UsuarioDao;

    

public class UsuarioService {

    @Autowired
    UsuarioDao dao;

    public List<Usuario> read() {
        return dao.getAll();
    }

    public Usuario readById(Long id) {
        return dao.getById(id);
    }
    
    public Usuario readByEmail(String email) {
        return dao.getByEmail(email);
    }

    public void create(Usuario usuario) {
        dao.create(usuario);
    }

    public void update(Usuario usuario) {
        dao.update(usuario);
    }

    public Usuario merge(Map<String, String> data){
        Usuario merged = new Usuario();
        if (data != null) {
            Long id = Long.parseLong(data.get("id"));
            if (id != null) {
                Usuario usuario = dao.getById(id);
                if (usuario != null) {
                    merged.setEmail(usuario.getEmail());
                    merged.setNome(usuario.getNome());
                    merged.setSenha(usuario.getSenha());
                    merged.setAgencia(usuario.getAgencia());
                    merged.setBanco(usuario.getBanco());
                    merged.setConta(usuario.getConta());
                    merged.setCpf(usuario.getCpf());
                    merged.setId(usuario.getId());
                    merged.setData_nasc(usuario.getData_nasc());
                    merged.setStatus(usuario.getStatus());
                    merged.setTipo(usuario.getTipo());
                    String key = "nome";
                    if (data.containsKey(key)) {
                        merged.setNome(data.get(key));
                    }
                    key = "senha";
                    if (data.containsKey(key)) {
                        merged.setSenha(data.get(key));
                    }
                    key = "agencia";
                    if (data.containsKey(key)) {
                        merged.setAgencia(data.get(key));
                    }
                    key = "banco";
                    if (data.containsKey(key)) {
                        merged.setBanco(data.get(key));
                    }
                    key = "conta";
                    if (data.containsKey(key)) {
                        merged.setConta(data.get(key));
                    }
                    key = "cpf";
                    if (data.containsKey(key)) {
                        merged.setCpf(data.get(key));
                    }
                    key = "status";
                    if (data.containsKey(key)) {
                        merged.setStatus(data.get(key));
                    }
                    key = "tipo";
                    if (data.containsKey(key)) {
                        merged.setTipo(Boolean.parseBoolean(data.get(key)));
                    }
                }
            }
        }
        return merged;
    }

    public void delete(Long id) {
        Usuario usuario = dao.getById(id);
        if (usuario != null) {
            dao.delete(id);      
        }
    }

    public Map<String, String> validate(Usuario usuario) {
        Map<String, String> errors = new LinkedHashMap<>();

        String nome = usuario.getNome();
        if (nome == null || nome.isEmpty()) {
            errors.put("nome", "Campo obrigatorio!");
        } else {
            String senha = usuario.getSenha();
            if (senha == null || senha.isEmpty()) {
                errors.put("senha", "Campo obrigatório!");
            } else if(senha.length() < 6){
                errors.put("senha", "Tamanho minimo de 6 caracteres!");
            } 
        }

        return errors;
    }
   
}
