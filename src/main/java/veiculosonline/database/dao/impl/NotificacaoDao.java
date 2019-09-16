package veiculosonline.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veiculosonline.database.connection.ConnectionFactory;
import veiculosonline.database.dao.INotificacaoDao;
import veiculosonline.database.entity.Notificacao;

public class NotificacaoDao implements INotificacaoDao{
    private final Connection conn;

    public NotificacaoDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void create(Notificacao notificacao) {
        String sql = "INSERT INTO notificacao (usuario_id, anuncio_id, descricao, data_hora) VALUES (?, ?, ?, NOW())";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, notificacao.getUsuario_id());
            stmt.setLong(2, notificacao.getAnuncio_id());
            stmt.setString(3, notificacao.getDescricao());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Notificacao> getAllByUserId(Long id) {

        List<Notificacao> notificacaoList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM notificacao WHERE usuario_id = ?");
            stmt.setLong(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Notificacao notificacao = new Notificacao();
                    notificacao.setUsuario_id(id);
                    notificacao.setAnuncio_id(rs.getLong("anuncio_id"));
                    notificacao.setId(rs.getLong("id"));
                    notificacao.setDescricao(rs.getString("descricao"));
                    notificacao.setData_hora(rs.getTimestamp("data_hora"));

                    // adicionando o objeto à lista
                    notificacaoList.add(notificacao);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return notificacaoList;
    }

     @Override
    public List<Notificacao> getAllByAnuncId(Long id) {

        List<Notificacao> notificacaoList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM notificacao WHERE anuncio_id = ?");
            stmt.setLong(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Notificacao notificacao = new Notificacao();
                    notificacao.setAnuncio_id(id);
                    notificacao.setUsuario_id(rs.getLong("usuario_id"));
                    notificacao.setId(rs.getLong("id"));
                    notificacao.setDescricao(rs.getString("descricao"));
                    notificacao.setData_hora(rs.getTimestamp("data_hora"));

                    // adicionando o objeto à lista
                    notificacaoList.add(notificacao);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return notificacaoList;
    }

    
    @Override
    public Notificacao getById(Long id) {

        PreparedStatement stmt;

        Notificacao notificacao = new Notificacao();

        try {
            stmt = conn.prepareStatement("SELECT * FROM notificacao WHERE id = ?");
            stmt.setLong(1, id);

            try ( ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    notificacao.setId(id);
                    notificacao.setUsuario_id(rs.getLong("usuario_id"));
                    notificacao.setAnuncio_id(rs.getLong("anuncio_id"));
                    notificacao.setDescricao(rs.getString("descricao"));
                    notificacao.setData_hora(rs.getTimestamp("data_hora"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return notificacao;
    }

    @Override
    public void delete(Notificacao notificacao) {
        String sql = "DELETE FROM notificacao WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, notificacao.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public void deleteAllByUserId(Long id) {
        String sql = "DELETE FROM notificacao WHERE usuario_id = ?";

        try {
            try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setLong(1, id);

                stmt.execute();
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    @Override
    public void deleteAllByAnuncId(Long id) {
        String sql = "DELETE FROM notificacao WHERE anuncio_id = ?";

        try {
            try ( PreparedStatement stmt = conn.prepareStatement(sql)) {
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
