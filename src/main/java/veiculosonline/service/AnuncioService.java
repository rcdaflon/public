package veiculosonline.service;

import java.sql.Timestamp;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import veiculosonline.database.dao.IAnuncioDao;
import veiculosonline.database.dao.impl.AnuncioDao;
import veiculosonline.database.entity.Anuncio;

public class AnuncioService {

    private IAnuncioDao dao = new AnuncioDao();

    public List<Anuncio> read() {
        return dao.getAll();
    }

    public Anuncio readById(Long id) {
        return dao.getById(id);
    }
    
    public List<Anuncio> readAllByUserId(Long id) {
        return dao.getAllByUserId(id);
    }

    public void create(Anuncio anuncio) {
        dao.create(anuncio);
    }

    public void update(Anuncio anuncio) {
        dao.update(anuncio);
    }

    public Anuncio merge(Map<String, String> data) {
        Anuncio merged = new Anuncio();
        if (data != null) {
            Long id = Long.parseLong(data.get("id"));
            if (id != null) {
                Anuncio anuncio = dao.getById(id);
                if (anuncio != null) {
                    merged.setUsuario_id(anuncio.getUsuario_id());
                    merged.setId(anuncio.getId());
                    merged.setNota(anuncio.getNota());
                    merged.setTitulo(anuncio.getTitulo());
                    merged.setDescricao(anuncio.getDescricao());
                    merged.setLaudo_veicular(anuncio.getLaudo_veicular());
                    merged.setFormas_pagamento(anuncio.getFormas_pagamento());
                    merged.setStatus(anuncio.getStatus());
                    merged.setPortas(anuncio.getPortas());
                    merged.setQuantidade_donos(anuncio.getQuantidade_donos());
                    merged.setFinal_placa(anuncio.getFinal_placa());
                    merged.setCor(anuncio.getCor());
                    merged.setMotor(anuncio.getMotor());
                    merged.setAno(anuncio.getAno());
                    merged.setCombustivel(anuncio.getCombustivel());
                    merged.setKilometragem(anuncio.getKilometragem());
                    merged.setCambio(anuncio.getCambio());
                    merged.setModelo(anuncio.getModelo());
                    merged.setMarca(anuncio.getMarca());
                    merged.setPreco(anuncio.getPreco());
                    merged.setData_hora_criacao(anuncio.getData_hora_criacao());
                    merged.setData_hora_compra(anuncio.getData_hora_compra());
                    merged.setTaxa_compra(anuncio.getTaxa_compra());
                    merged.setProtocolo_compra(anuncio.getProtocolo_compra());

                    String key = "titulo";
                    if (data.containsKey(key)) {
                        merged.setTitulo(data.get(key));
                    }
                    key = "descricao";
                    if (data.containsKey(key)) {
                        merged.setDescricao(data.get(key));
                    }
                    key = "laudo_veicular";
                    if (data.containsKey(key)) {
                        merged.setLaudo_veicular(data.get(key));
                    }
                    key = "formas_pagamento";
                    if (data.containsKey(key)) {
                        merged.setFormas_pagamento(data.get(key));
                    }
                    key = "status";
                    if (data.containsKey(key)) {
                        merged.setStatus(data.get(key));
                    }
                    key = "portas";
                    if (data.containsKey(key)) {
                        merged.setPortas(Integer.parseInt(data.get(key)));
                    }
                    key = "quantidade_donos";
                    if (data.containsKey(key)) {
                        merged.setQuantidade_donos(Integer.parseInt(data.get(key)));
                    }
                    key = "final_placa";
                    if (data.containsKey(key)) {
                        merged.setFinal_placa(data.get(key));
                    }
                    key = "cor";
                    if (data.containsKey(key)) {
                        merged.setCor(data.get(key));
                    }
                    key = "motor";
                    if (data.containsKey(key)) {
                        merged.setMotor(data.get(key));
                    }
                    key = "ano";
                    if (data.containsKey(key)) {
                        merged.setAno(Integer.parseInt(data.get(key)));
                    }
                    key = "combustivel";
                    if (data.containsKey(key)) {
                        merged.setCombustivel(data.get(key));
                    }
                    key = "kilometragem";
                    if (data.containsKey(key)) {
                        merged.setKilometragem(Integer.parseInt(data.get(key)));
                    }
                    key = "cambio";
                    if (data.containsKey(key)) {
                        merged.setCambio(data.get(key));
                    }
                    key = "modelo";
                    if (data.containsKey(key)) {
                        merged.setModelo(data.get(key));
                    }
                    key = "marca";
                    if (data.containsKey(key)) {
                        merged.setMarca(data.get(key));
                    }
                    key = "data_hora_criacao";
                    if (data.containsKey(key)) {
                        merged.setData_hora_criacao(Timestamp.valueOf(data.get(key)));
                    }
                    key = "data_hora_compra";
                    if (data.containsKey(key)) {
                        merged.setData_hora_compra(Timestamp.valueOf(data.get(key)));
                    }
                    key = "taxa_compra";
                    if (data.containsKey(key)) {
                        merged.setTaxa_compra(Double.parseDouble(data.get(key)));
                    }
                    key = "protocolo_compra";
                    if (data.containsKey(key)) {
                        merged.setProtocolo_compra(Long.parseLong(data.get(key)));
                    }

                }
            }
        }
        return merged;
    }

    public void delete(Long id) {
        Anuncio anuncio = dao.getById(id);
        if (anuncio != null) {
            dao.delete(anuncio);
        }
    }
    
    public void deleteAllByUserId(Long id) {
        dao.deleteAllByUserId(id);
    }

    public Map<String, String> validate(Anuncio anuncio) {
        Map<String, String> errors = new LinkedHashMap<>();

        String campo = anuncio.getTitulo();
        if (campo == null || campo.isEmpty()) {
            errors.put("Título", "Campo obrigatorio!");
        } else {
            campo = anuncio.getDescricao();
            if (campo == null || campo.isEmpty()) {
                errors.put("Descricao", "Campo obrigatório!");
            } else {
                campo = anuncio.getLaudo_veicular();
                if (campo == null || campo.isEmpty()) {
                    errors.put("Laudo Veicular", "Campo obrigatório!");
                } else {
                    campo = anuncio.getFormas_pagamento();
                    if (campo == null || campo.isEmpty()) {
                        errors.put("Formas de Pagamento", "Campo obrigatório!");
                    } else {
                        int portas = anuncio.getPortas();
                        if (portas <= 0) {
                            errors.put("Portas", "Campo obrigatório! Deve ser maior ou igual a 1");
                        } else {
                            int quantidade_donos = anuncio.getQuantidade_donos();
                            if (quantidade_donos <= 0) {
                                errors.put("Quantidade de Donos", "Campo obrigatório! Deve ser maior ou igual a 1");
                            } else {
                                campo = anuncio.getFinal_placa();
                                if (campo == null || campo.isEmpty()) {
                                    errors.put("Final Placa", "Campo obrigatório!");
                                } else {
                                    campo = anuncio.getCor();
                                    if (campo == null || campo.isEmpty()) {
                                        errors.put("Cor", "Campo obrigatório!");
                                    } else {
                                        campo = anuncio.getMotor();
                                        if (campo == null || campo.isEmpty()) {
                                            errors.put("Motor", "Campo obrigatório!");
                                        } else {
                                            int ano = anuncio.getAno();
                                            if (ano <= 1900) {
                                                errors.put("Ano", "Campo obrigatório!");
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }

                }
            }
        }
        return errors;
    }
}
