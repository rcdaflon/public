package br.veiculosonline.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.veiculosonline.database.connection.ConnectionFactory;
import br.veiculosonline.database.dao.IMensagemDao;
import br.veiculosonline.database.entity.Mensagem;

@Repository
public class MensagemDao implements IMensagemDao {

    private final Connection conn;

    public MensagemDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void create(Mensagem mensagem) {
        String sql = "INSERT INTO mensagem (usuario_id, chat_id, texto, data_hora) VALUES (?, ?, ?, NOW())";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, mensagem.getUsuario_id());
            stmt.setLong(2, mensagem.getChat_id());
            stmt.setString(3, mensagem.getTexto());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

//    @Override
//    public List<Mensagem> readByUserId(Long id) {
//
//        List<Mensagem> mensagemList = new ArrayList<>();
//
//        PreparedStatement stmt;
//
//        try {
//            stmt = conn.prepareStatement("SELECT * FROM mensagem WHERE usuario_id = ?");
//            stmt.setLong(1, id);
//
//            try (ResultSet rs = stmt.executeQuery()) {
//                while (rs.next()) {
//
//                    Mensagem mensagem = new Mensagem();
//                    mensagem.setUsuario_id(id);
//                    mensagem.setChat_id(rs.getLong("chat_id"));
//                    mensagem.setId(rs.getLong("id"));
//                    mensagem.setTexto(rs.getString("texto"));
//                    mensagem.setData_hora(rs.getTimestamp("data_hora"));
//
//                    // adicionando o objeto à lista
//                    mensagemList.add(mensagem);
//                }
//            }
//            stmt.close();
//
//        } catch (SQLException ex) {
//            System.out.println(ex);
//        }
//
//        return mensagemList;
//    }

    @Override
    public List<Mensagem> readByChatId(Long id) {

        List<Mensagem> mensagemList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            if(id != null){
            stmt = conn.prepareStatement("SELECT * FROM mensagem WHERE chat_id = ?");
            stmt.setLong(1, id);
            }
             stmt = conn.prepareStatement("SELECT");
            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Mensagem mensagem = new Mensagem();
                    mensagem.setChat_id(id);
                    mensagem.setUsuario_id(rs.getLong("usuario_id"));
                    mensagem.setId(rs.getLong("id"));
                    mensagem.setTexto(rs.getString("texo"));
                    mensagem.setData_hora(rs.getTimestamp("data_hora"));

                    // adicionando o objeto à lista
                    mensagemList.add(mensagem);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return mensagemList;
    }

    @Override
    public Mensagem readById(Long id) {

        PreparedStatement stmt;

        Mensagem mensagem = new Mensagem();

        try {
            stmt = conn.prepareStatement("SELECT * FROM mensagem WHERE id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    mensagem.setId(id);
                    mensagem.setUsuario_id(rs.getLong("usuario_id"));
                    mensagem.setChat_id(rs.getLong("chat_id"));
                    mensagem.setData_hora(rs.getTimestamp("data_hora"));
                    mensagem.setTexto(rs.getString("texto"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return mensagem;
    }

    @Override
    public void delete(Mensagem mensagem) {
        String sql = "DELETE FROM mensagem WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, mensagem.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void deleteAllByUserId(Long id) {
        String sql = "DELETE FROM mensagem WHERE usuario_id = ?";

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
    public void deleteByChatId(Long id) {
        String sql = "DELETE FROM mensagem WHERE chat_id = ?";

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

}
