package veiculosonline.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import veiculosonline.database.connection.ConnectionFactory;
import veiculosonline.database.dao.IFotoAnuncioDao;
import veiculosonline.database.entity.FotoAnuncio;

public class FotoAnuncioDao implements IFotoAnuncioDao{
     private final Connection conn;

    public FotoAnuncioDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void create(FotoAnuncio fotoanuncio) {
        String sql = "INSERT INTO foto_anuncio (anuncio_id, nome) VALUES (?, ?)";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setLong(1, fotoanuncio.getAnuncio_id());
            stmt.setString(2, fotoanuncio.getNome());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<FotoAnuncio> getAllByAnuncId(Long id) {

        List<FotoAnuncio> fotoanuncioList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM foto_anuncio WHERE anuncio_id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    FotoAnuncio fotoanuncio = new FotoAnuncio();
                    fotoanuncio.setAnuncio_id(id);
                    fotoanuncio.setId(rs.getLong("id"));
                    fotoanuncio.setNome(rs.getString("nome"));

                    // adicionando o objeto à lista
                    fotoanuncioList.add(fotoanuncio);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return fotoanuncioList;
    }

    @Override
    public FotoAnuncio getById(Long id) {

        PreparedStatement stmt;

        FotoAnuncio fotoanuncio = new FotoAnuncio();

        try {
            stmt = conn.prepareStatement("SELECT * FROM foto_anuncio WHERE id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    fotoanuncio.setAnuncio_id(id);
                    fotoanuncio.setId(rs.getLong("id"));
                    fotoanuncio.setNome(rs.getString("nome"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return fotoanuncio;
    }

    @Override
    public void update(FotoAnuncio fotoanuncio) {

        String sql = "UPDATE foto_anuncio SET nome = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, fotoanuncio.getNome());

            stmt.setLong(17, fotoanuncio.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public void delete(FotoAnuncio fotoanuncio) {
        String sql = "DELETE FROM foto_anuncio WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setLong(1, fotoanuncio.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void deleteAllByAnuncId(Long id) {
         String sql = "DELETE FROM foto_anuncio WHERE anuncio_id = ?";

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
