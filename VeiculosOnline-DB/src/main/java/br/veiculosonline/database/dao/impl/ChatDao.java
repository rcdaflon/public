package br.veiculosonline.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.veiculosonline.database.connection.ConnectionFactory;
import br.veiculosonline.database.dao.IChatDao;
import br.veiculosonline.database.entity.Chat;

@Repository
public class ChatDao implements IChatDao {

    private final Connection conn;

    public ChatDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void create(Chat chat) {
        String sql = "INSERT INTO chat (usuario_id, anuncio_id, data_hora) VALUES (?, ?, NOW())";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, chat.getUsuario_id());
            stmt.setLong(2, chat.getAnuncio_id());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Chat> readAllByUserId(Long id) {

        List<Chat> chatList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM chat WHERE usuario_id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Chat chat = new Chat();
                    chat.setUsuario_id(id);
                    chat.setAnuncio_id(rs.getLong("anuncio_id"));
                    chat.setId(rs.getLong("id"));
                    chat.setData_hora(rs.getTimestamp("data_hora"));

                    // adicionando o objeto à lista
                    chatList.add(chat);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return chatList;
    }

    @Override
    public List<Chat> readAllByAnuncId(Long id) {

        List<Chat> chatList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM chat WHERE anuncio_id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Chat chat = new Chat();
                    chat.setAnuncio_id(id);
                    chat.setUsuario_id(rs.getLong("usuario_id"));
                    chat.setId(rs.getLong("id"));
                    chat.setData_hora(rs.getTimestamp("data_hora"));

                    // adicionando o objeto à lista
                    chatList.add(chat);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return chatList;
    }

    @Override
    public Chat readById(Long id) {

        PreparedStatement stmt;

        Chat chat = new Chat();

        try {
            stmt = conn.prepareStatement("SELECT * FROM chat WHERE id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    chat.setId(id);
                    chat.setUsuario_id(rs.getLong("usuario_id"));
                    chat.setAnuncio_id(rs.getLong("anuncio_id"));
                    chat.setData_hora(rs.getTimestamp("data_hora"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return chat;
    }

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM chat WHERE id = ?";

        if (id != null) {
            try {
                PreparedStatement stmt = conn.prepareStatement(sql);
                stmt.setLong(1, id);

                stmt.execute();
                stmt.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    @Override
    public void deleteAllByUserId(Long id) {
        String sql = "DELETE FROM chat WHERE usuario_id = ?";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);

                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllByAnuncId(Long id) {
        String sql = "DELETE FROM chat WHERE anuncio_id = ?";

        try {
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);

                stmt.execute();
            }
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

    @Override
    public Chat readByUserAndAnuncioId(Long usuario_id, Long anuncio_id) {
        PreparedStatement stmt;

        Chat chat = new Chat();

        try {
            stmt = conn.prepareStatement("SELECT * FROM chat WHERE usuario_id = ? AND anuncio_id = ?");
            stmt.setLong(1, usuario_id);
            stmt.setLong(2, anuncio_id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    chat.setId(rs.getLong("id"));
                    chat.setUsuario_id(usuario_id);
                    chat.setAnuncio_id(anuncio_id);
                    chat.setData_hora(rs.getTimestamp("data_hora"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return chat;
    }

}
