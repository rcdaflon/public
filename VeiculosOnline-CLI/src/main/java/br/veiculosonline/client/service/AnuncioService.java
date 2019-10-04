/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.veiculosonline.client.service;

import br.veiculosonline.database.dao.IAnuncioDao;
import br.veiculosonline.database.entity.Anuncio;

/**
 *
 * @author marcelo
 */
public class AnuncioService {

    IAnuncioDao anuncioDao;

    public Anuncio merge(Anuncio anunc) {
        Anuncio merged = new Anuncio();
        if (anunc != null) {
            Long id = anunc.getId();
            if (id != null) {
                Anuncio anuncio = anuncioDao.readById(id);
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

                    if (!anuncio.getTitulo().isEmpty() && anuncio.getTitulo() != null) {
                        merged.setTitulo(anuncio.getTitulo());
                    }
                    if (!anuncio.getDescricao().isEmpty() && anuncio.getDescricao() != null) {
                        merged.setDescricao(anuncio.getDescricao());
                    }
                    if (!anuncio.getLaudo_veicular().isEmpty() && anuncio.getLaudo_veicular() != null) {
                        merged.setLaudo_veicular(anuncio.getLaudo_veicular());
                    }
                    if (!anuncio.getFormas_pagamento().isEmpty() && anuncio.getFormas_pagamento() != null) {
                        merged.setFormas_pagamento(anuncio.getFormas_pagamento());
                    }
                    if (!anuncio.getStatus().isEmpty() && anuncio.getStatus() != null) {
                        merged.setStatus(anuncio.getStatus());
                    }
                    if (anuncio.getPortas() != 0 && anuncio.getPortas() != null) {
                        merged.setPortas(anuncio.getPortas());
                    }
                    if (anuncio.getQuantidade_donos() != 0 && anuncio.getQuantidade_donos() != null) {
                        merged.setQuantidade_donos(anuncio.getQuantidade_donos());
                    }
                    if (!anuncio.getFinal_placa().isEmpty() && anuncio.getFinal_placa() != null) {
                        merged.setFinal_placa(anuncio.getFinal_placa());
                    }
                    if (!anuncio.getCor().isEmpty() && anuncio.getCor() != null) {
                        merged.setCor(anuncio.getCor());
                    }
                    if (!anuncio.getMotor().isEmpty() && anuncio.getMotor() != null) {
                        merged.setMotor(anuncio.getMotor());
                    }
                    if (anuncio.getAno() > 1800 && anuncio.getAno() != null) {
                        merged.setAno(anuncio.getAno());
                    }
                    if (!anuncio.getCombustivel().isEmpty() && anuncio.getCombustivel() != null) {
                        merged.setCombustivel(anuncio.getCombustivel());
                    }
                    if (anuncio.getKilometragem() != 0 && anuncio.getKilometragem() != null) {
                        merged.setKilometragem(anuncio.getKilometragem());
                    }
                    if (!anuncio.getCambio().isEmpty() && anuncio.getCambio() != null) {
                        merged.setCambio(anuncio.getCambio());
                    }
                    if (!anuncio.getModelo().isEmpty() && anuncio.getModelo() != null) {
                        merged.setModelo(anuncio.getModelo());
                    }
                    if (!anuncio.getMarca().isEmpty() && anuncio.getMarca() != null) {
                        merged.setMarca(anuncio.getMarca());
                    }
                    if (anuncio.getData_hora_criacao() != null) {
                        merged.setData_hora_criacao(anuncio.getData_hora_criacao());
                    }
                    if (anuncio.getData_hora_compra() != null) {
                        merged.setData_hora_compra(anuncio.getData_hora_compra());
                    }
                    if (anuncio.getTaxa_compra() != null) {
                        merged.setTaxa_compra(anuncio.getTaxa_compra());
                    }
                    if (!anuncio.getModelo().isEmpty() && anuncio.getModelo() != null) {
                        merged.setModelo(anuncio.getModelo());
                    }

                }
            }
        }
        return merged;
    }
}
