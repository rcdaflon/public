/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.database.dao.impl;

import br.veiculosonline.database.connection.ConnectionFactory;
import br.veiculosonline.database.dao.IUsuarioDao;
import br.veiculosonline.database.entity.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Rodrigo
 */
@Repository
public class UsuarioDao implements IUsuarioDao {

    /**
     *
     * @param Rodrigo
     */
    private final Connection conn;
    
    public UsuarioDao() {
        conn = ConnectionFactory.getConnection();
    }
    
    @Override
    public void create(Usuario usuario) {

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        try {
            conn = ConnectionFactory.getConnection();
            conn.setAutoCommit(false);

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getEmail());
            stmt.setString(3, usuario.getSenha());

            stmt.execute();

            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();

            try {
                conn.rollback();
            } catch (SQLException ex) {
            }

        } finally {

            sql = "SELECT last_value FROM usuario_id_seq;";

            try {
                stmt = conn.prepareStatement(sql);
                rs = stmt.executeQuery();

                if (rs.next()) {
                    usuario.setId(rs.getLong("last_value"));
                }

                rs.close();
                stmt.close();

            } catch (SQLException ex) {
                System.out.println(ex);
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }
    }

    /**
     *
     * @return
     */
    @Override
    public List<Usuario> readAll() {

        List<Usuario> usuarioList = new ArrayList<Usuario>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM usuario");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setConta(rs.getString("conta"));
                usuario.setAgencia(rs.getString("agencia"));
                usuario.setBanco(rs.getString("banco"));
                usuario.setStatus(rs.getString("status"));

                // adicionando o objeto Ã  lista
                usuarioList.add(usuario);
            }

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return usuarioList;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Usuario readById(Long id) {

        Usuario usuario = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE id = ?");
            stmt.setLong(1, id);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setConta(rs.getString("conta"));
                usuario.setAgencia(rs.getString("agencia"));
                usuario.setBanco(rs.getString("banco"));
                usuario.setStatus(rs.getString("status"));
            }

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return usuario;
    }

    /**
     *
     * @param email
     * @return
     */
    @Override
    public Usuario readByEmail(String email) {

        Usuario usuario = null;
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ?");
            stmt.setString(1, email);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setConta(rs.getString("conta"));
                usuario.setAgencia(rs.getString("agencia"));
                usuario.setBanco(rs.getString("banco"));
                usuario.setStatus(rs.getString("status"));
            }

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return usuario;
    }

    /**
     *
     * @param usuario
     */
    @Override
    public void update(Usuario usuario) {

        String sql = "UPDATE usuario SET nome = ?, senha = ?, telefone = ?, endereco = ?, cpf = ?, tipo = ?, status = ?, banco = ?, agencia = ?, conta = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, usuario.getNome());
            stmt.setString(2, usuario.getSenha());
            stmt.setString(3, usuario.getTelefone());
            stmt.setString(4, usuario.getEndereco());
            stmt.setString(5, usuario.getCpf());
            stmt.setString(6, usuario.getTipo());
            stmt.setString(7, usuario.getStatus());
            stmt.setString(8, usuario.getBanco());
            stmt.setString(9, usuario.getAgencia());
            stmt.setString(10, usuario.getConta());

            stmt.setLong(11, usuario.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        
    }
    
    @Override
    public void updateAdm(Usuario usuario) {

        String sql = "UPDATE usuario SET tipo = ?, status = ?, banco = ?, agencia = ?, conta = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            
            stmt.setString(1, usuario.getTipo());
            stmt.setString(2, usuario.getStatus());
            stmt.setString(3, usuario.getBanco());
            stmt.setString(4, usuario.getAgencia());
            stmt.setString(5, usuario.getConta());

            stmt.setLong(6, usuario.getId());

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
    public void delete(Long id) {

        String sql = "DELETE FROM usuario WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, id);

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Usuario> readByName(String nome) {

        List<Usuario> userList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            if (nome != null && !nome.isEmpty()) {

                stmt = conn.prepareStatement("SELECT * FROM usuario WHERE nome ILIKE ?");
                stmt.setString(1, '%' + nome + '%');

            } else {
                stmt = conn.prepareStatement("SELECT * FROM usuario");
            }

            rs = stmt.executeQuery();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setConta(rs.getString("conta"));
                usuario.setAgencia(rs.getString("agencia"));
                usuario.setBanco(rs.getString("banco"));
                usuario.setStatus(rs.getString("status"));

                userList.add(usuario);
            }

        } catch (SQLException ex) {

            ex.printStackTrace();
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return userList;

    }

    @Override
    public Usuario readByUserEmailAndSenha(String email, String senha) {
        Usuario usuario = null;

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM usuario WHERE email = ? AND senha = ?");
            stmt.setString(1, email);
            stmt.setString(2, senha);

            rs = stmt.executeQuery();

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                usuario.setTelefone(rs.getString("telefone"));
                usuario.setEndereco(rs.getString("endereco"));
                usuario.setCpf(rs.getString("cpf"));
                usuario.setTipo(rs.getString("tipo"));
                usuario.setConta(rs.getString("conta"));
                usuario.setAgencia(rs.getString("agencia"));
                usuario.setBanco(rs.getString("banco"));
                usuario.setStatus(rs.getString("status"));
            }

        } catch (SQLException ex) {
        } finally {

            try {
                if (!rs.isClosed()) {
                    rs.close();
                }

            } catch (SQLException ex) {
            }

            try {
                if (!stmt.isClosed()) {
                    stmt.close();
                }
            } catch (SQLException ex) {
            }

            try {
                if (!conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
            }
        }

        return usuario;

    }

}
