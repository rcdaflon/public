package veiculosonline.database.dao.impl;

import veiculosonline.database.connection.ConnectionFactory;
import veiculosonline.database.dao.IUsuarioDao;
import veiculosonline.database.entity.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Rodrigo
 */
public class UsuarioDao implements IUsuarioDao {

    private final Connection conn;

    public UsuarioDao() {

        conn = ConnectionFactory.getConnection();
    }

    /**
     *
     * @param usuario
     */
    @Override
    public void create(Usuario usuario) {
        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> getAll() {

        List<Usuario> usuarioList = new ArrayList<Usuario>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM usuario");

            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                //usuario.setTelefone(rs.getString("telefone")); //outra tabela - multivalorado
                //usuario.setEndereco(rs.getString("endereco")); //outra tabela - multivalorado
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getBoolean("tipo")); 
                usuario.setConta(rs.getString("conta")); 
                usuario.setAgencia(rs.getString("agencia")); 
                usuario.setBanco(rs.getString("banco")); 
                usuario.setData_nasc(rs.getDate("data_nasc")); 
                usuario.setStatus(rs.getString("status")); 
                
                // adicionando o objeto à lista
                usuarioList.add(usuario);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usuarioList;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Usuario getById(Long id) {

        Usuario usuario = null;

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE id = ?");
            stmt.setLong(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getBoolean("tipo")); 
                usuario.setConta(rs.getString("conta")); 
                usuario.setAgencia(rs.getString("agencia")); 
                usuario.setBanco(rs.getString("banco")); 
                usuario.setData_nasc(rs.getDate("data_nasc")); 
                usuario.setStatus(rs.getString("status"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usuario;
    }

    
    /**
     *
     * @param email
     * @return
     */
    @Override
    public Usuario getByEmail(String email) {

        Usuario usuario = null;

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getBoolean("tipo")); 
                usuario.setConta(rs.getString("conta")); 
                usuario.setAgencia(rs.getString("agencia")); 
                usuario.setBanco(rs.getString("banco")); 
                usuario.setData_nasc(rs.getDate("data_nasc")); 
                usuario.setStatus(rs.getString("status"));
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return usuario;
    }   
    
    
    /**
     *
     * @param usuario
     */
    @Override
    public void update(Usuario usuario) {

        String sql = "UPDATE usuario SET nome = ?, email = ?, senha = ?, cpf = ?, conta = ?, agencia = ?, banco = ?, data_nasc = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());
            stmt.setString(4, usuario.getCpf());
            stmt.setBoolean(5, usuario.getTipo());
            stmt.setString(6, usuario.getConta());
            stmt.setString(7, usuario.getAgencia());
            stmt.setString(8, usuario.getBanco());
            stmt.setDate(9, (Date) usuario.getData_nasc());
            stmt.setString(10, usuario.getStatus());
            
            stmt.setLong(11, usuario.getId()); 

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    /**
     *
     * @param usuario
     */
    @Override
    public void delete(Usuario usuario) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, usuario.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    @Override
    public void closeConnection() {
        try {
            if (!conn.isClosed()) {
                conn.close();
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

  
   
}
