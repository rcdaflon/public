package br.veiculosonline.database.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;
import br.veiculosonline.database.connection.ConnectionFactory;
import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;
import java.math.BigDecimal;

@Repository
public class AnuncioDao implements IAnuncioDao {

    private final Connection conn;

    public AnuncioDao() {
        conn = ConnectionFactory.getConnection();
    }

    @Override
    public void create(Anuncio anuncio) {
        String sql = "INSERT INTO anuncio (usuario_id, titulo, descricao, formas_pagamento, portas, quantidade_donos, final_placa, cor, motor, ano, combustivel, kilometragem, cambio, modelo, marca, preco, data_hora_criacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, NOW())";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setLong(1, anuncio.getUsuario_id());
            stmt.setString(2, anuncio.getTitulo());
            stmt.setString(3, anuncio.getDescricao());
            //stmt.setString(4, anuncio.getLaudo_veicular());
            stmt.setString(4, anuncio.getFormas_pagamento());
            stmt.setInt(5, anuncio.getPortas());
            stmt.setInt(6, anuncio.getQuantidade_donos());
            stmt.setString(7, anuncio.getFinal_placa());
            stmt.setString(8, anuncio.getCor());
            stmt.setString(9, anuncio.getMotor());
            stmt.setInt(10, anuncio.getAno());
            stmt.setString(11, anuncio.getCombustivel());
            stmt.setInt(12, anuncio.getKilometragem());
            stmt.setString(13, anuncio.getCambio());
            stmt.setString(14, anuncio.getModelo());
            stmt.setString(15, anuncio.getMarca());
            stmt.setObject(16, anuncio.getPreco());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    @Override
    public List<Anuncio> readAll() {

        List<Anuncio> anuncioList = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.getConnection();

            stmt = conn.prepareStatement("SELECT * FROM anuncio  ORDER BY nota DESC");

            rs = stmt.executeQuery();

            while (rs.next()) {

                Anuncio anuncio = new Anuncio();
                anuncio.setUsuario_id(rs.getLong("usuario_id"));
                anuncio.setId(rs.getLong("id"));
                anuncio.setNota(rs.getDouble("nota"));
                anuncio.setTitulo(rs.getString("titulo"));
                anuncio.setDescricao(rs.getString("descricao"));
                anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                anuncio.setStatus(rs.getString("status"));
                anuncio.setPortas(rs.getInt("portas"));
                anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                anuncio.setFinal_placa(rs.getString("final_placa"));
                anuncio.setCor(rs.getString("cor"));
                anuncio.setMotor(rs.getString("motor"));
                anuncio.setAno(rs.getInt("ano"));
                anuncio.setCombustivel(rs.getString("combustivel"));
                anuncio.setKilometragem(rs.getInt("kilometragem"));
                anuncio.setCambio(rs.getString("cambio"));
                anuncio.setModelo(rs.getString("modelo"));
                anuncio.setMarca(rs.getString("marca"));
                anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                // adicionando o objeto à lista
                anuncioList.add(anuncio);
            }

            rs.close();
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readAllByUserId(Long id) {

        List<Anuncio> anuncioList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE usuario_id = ?  ORDER BY nota DESC");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(id);
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    // adicionando o objeto à lista
                    anuncioList.add(anuncio);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public Anuncio readById(Long id) {

        PreparedStatement stmt;

        Anuncio anuncio = new Anuncio();

        try {
            stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE id = ?");
            stmt.setLong(1, id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {

                    anuncio.setUsuario_id(id);
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncio;
    }

    @Override
    public void update(Anuncio anuncio) {

        String sql = "UPDATE anuncio SET titulo = ?, descricao = ?, laudo_veicular = ?, formas_pagamento = ?, portas = ?, quantidade_donos = ?, final_placa = ?, cor = ?, motor = ?, ano = ?, combustivel = ?, kilometragem = ?, cambio = ?, modelo = ?, marca = ?, preco = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, anuncio.getTitulo());
            stmt.setString(2, anuncio.getDescricao());
            stmt.setString(3, anuncio.getLaudo_veicular());
            stmt.setString(4, anuncio.getFormas_pagamento());
            stmt.setInt(5, anuncio.getPortas());
            stmt.setInt(6, anuncio.getQuantidade_donos());
            stmt.setString(7, anuncio.getFinal_placa());
            stmt.setString(8, anuncio.getCor());
            stmt.setString(9, anuncio.getMotor());
            stmt.setInt(10, anuncio.getAno());
            stmt.setString(11, anuncio.getCombustivel());
            stmt.setInt(12, anuncio.getKilometragem());
            stmt.setString(13, anuncio.getCambio());
            stmt.setString(14, anuncio.getModelo());
            stmt.setString(15, anuncio.getMarca());
            stmt.setObject(16, anuncio.getPreco());
            
            stmt.setLong(17, anuncio.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    @Override
    public void updateByAdm(Anuncio anuncio) {

        String sql = "UPDATE anuncio SET status = ?, nota = ?, taxa_compra = ? WHERE id = ?";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            
            stmt.setString(1, anuncio.getStatus());
            stmt.setDouble(2, anuncio.getNota());
            stmt.setDouble(3, anuncio.getTaxa_compra());

            stmt.setLong(4, anuncio.getId());

            stmt.execute();
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
    
    

    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM anuncio WHERE id = ?";

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
    public void deleteAllByUserId(Long id) {
        String sql = "DELETE FROM anuncio WHERE usuario_id = ?";

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
    public List<Anuncio> readAllByTitulo(String titulo) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (titulo != null && !titulo.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE titulo ILIKE ? ORDER BY nota DESC");
                stmt.setString(1, '%' + titulo + '%');
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio ORDER BY nota DESC");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    /**
     *
     * @param id
     * @return
     */
    @Override
    public Integer readTotalCountByUserId(Long id) {
        PreparedStatement stmt = null;

        Integer retorno = null;

        try {
            stmt = conn.prepareStatement("SELECT COUNT(*) FROM anuncio WHERE usuario_id = ?");
            stmt.setLong(1, id);
        } catch (SQLException ex) {
        }

        try {
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    retorno = rs.getInt("count");
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return retorno;
    }

    @Override
    public List<Anuncio> readByAno(Integer ano) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (ano != null && ano != 0) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' AND ano > ? ORDER BY nota DESC");
                stmt.setInt(1, ano);
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' ORDER BY nota DESC");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readByKilometragem(Integer kilometragem) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (kilometragem != null && kilometragem != 0) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' AND kilometragem < ? ORDER BY nota DESC");
                stmt.setInt(1, kilometragem);
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' ORDER BY nota DESC");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readByPreco(BigDecimal preco_min, BigDecimal preco_max) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (preco_min != null && preco_max != null && preco_max.compareTo(preco_min) == 1) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' AND preco BETWEEN ? AND ? ORDER BY nota DESC");
                stmt.setBigDecimal(1, preco_min);
                stmt.setBigDecimal(2, preco_max);
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status = 'Ativo' ORDER BY nota DESC");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readByStatus(String status) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (status != null && !status.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status ILIKE ? ORDER BY nota DESC");
                stmt.setString(1, status);
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio ORDER BY nota DESC");
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readByStatusAndName(String status, String titulo) {
        PreparedStatement stmt;

        List<Anuncio> anuncioList = new ArrayList<>();

        try {

            if (titulo != null && !titulo.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status ILIKE ? AND titulo ILIKE ?");
                stmt.setString(1, '%' + status + '%');
                stmt.setString(2, '%' + titulo + '%');
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE status ILIKE ?");
                stmt.setString(1, '%' + status + '%');
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(rs.getLong("usuario_id"));
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    anuncioList.add(anuncio);

                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }

    @Override
    public List<Anuncio> readAllByUserIdAndName(Long id, String titulo) {
        List<Anuncio> anuncioList = new ArrayList<>();

        PreparedStatement stmt;

        try {
            if (titulo != null && !titulo.isEmpty()) {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE usuario_id = ? AND titulo ILIKE ?");
                stmt.setLong(1, id);
                stmt.setString(2, '%' + titulo + '%');
            } else {
                stmt = conn.prepareStatement("SELECT * FROM anuncio WHERE usuario_id = ?");
                stmt.setLong(1, id);
            }

            try (ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {

                    Anuncio anuncio = new Anuncio();
                    anuncio.setUsuario_id(id);
                    anuncio.setId(rs.getLong("id"));
                    anuncio.setNota(rs.getDouble("nota"));
                    anuncio.setTitulo(rs.getString("titulo"));
                    anuncio.setDescricao(rs.getString("descricao"));
                    anuncio.setLaudo_veicular(rs.getString("laudo_veicular"));
                    anuncio.setFormas_pagamento(rs.getString("formas_pagamento"));
                    anuncio.setStatus(rs.getString("status"));
                    anuncio.setPortas(rs.getInt("portas"));
                    anuncio.setQuantidade_donos(rs.getInt("quantidade_donos"));
                    anuncio.setFinal_placa(rs.getString("final_placa"));
                    anuncio.setCor(rs.getString("cor"));
                    anuncio.setMotor(rs.getString("motor"));
                    anuncio.setAno(rs.getInt("ano"));
                    anuncio.setCombustivel(rs.getString("combustivel"));
                    anuncio.setKilometragem(rs.getInt("kilometragem"));
                    anuncio.setCambio(rs.getString("cambio"));
                    anuncio.setModelo(rs.getString("modelo"));
                    anuncio.setMarca(rs.getString("marca"));
                    anuncio.setPreco((BigDecimal) rs.getObject("preco"));
                    anuncio.setData_hora_criacao(rs.getTimestamp("data_hora_criacao"));
                    anuncio.setData_hora_compra(rs.getTimestamp("data_hora_compra"));
                    anuncio.setTaxa_compra(rs.getDouble("taxa_compra"));
                    anuncio.setProtocolo_compra(rs.getLong("protocolo_compra"));

                    // adicionando o objeto à lista
                    anuncioList.add(anuncio);
                }
            }
            stmt.close();

        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return anuncioList;
    }
}
