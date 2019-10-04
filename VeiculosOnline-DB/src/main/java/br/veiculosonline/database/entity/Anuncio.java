package br.veiculosonline.database.entity;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import org.springframework.format.number.money.MonetaryAmountFormatter;

public class Anuncio {
    
    private Long id;
    private Long usuario_id;
    private Double nota;
    private String titulo;
    private String descricao;
    private String laudo_veicular;
    private String formas_pagamento;
    private String status;
    private Integer portas;
    private Integer quantidade_donos;
    private String final_placa;
    private String cor;
    private String motor;
    private Integer ano;
    private String combustivel;
    private Integer kilometragem;
    private String cambio;
    private String modelo;
    private String marca;
    private BigDecimal preco;
    private Timestamp data_hora_criacao;
    private Timestamp data_hora_compra;
    private Double taxa_compra;
    private Long protocolo_compra;
    
    private List<FotoAnuncio> fotos = new ArrayList<>();

    public Anuncio() {
    }

    public Anuncio(Long id, Long usuario_id, Double nota, String titulo, String descricao, String laudo_veicular, String formas_pagamento, String status, Integer portas, Integer quantidade_donos, String final_placa, String cor, String motor, Integer ano, String combustivel, Integer kilometragem, String cambio, String modelo, String marca, BigDecimal preco, Timestamp data_hora_criacao, Timestamp data_hora_compra, Double taxa_compra, Long protocolo_compra) {
        this.id = id;
        this.usuario_id = usuario_id;
        this.nota = nota;
        this.titulo = titulo;
        this.descricao = descricao;
        this.laudo_veicular = laudo_veicular;
        this.formas_pagamento = formas_pagamento;
        this.status = status;
        this.portas = portas;
        this.quantidade_donos = quantidade_donos;
        this.final_placa = final_placa;
        this.cor = cor;
        this.motor = motor;
        this.ano = ano;
        this.combustivel = combustivel;
        this.kilometragem = kilometragem;
        this.cambio = cambio;
        this.modelo = modelo;
        this.marca = marca;
        this.preco = preco;
        this.data_hora_criacao = data_hora_criacao;
        this.data_hora_compra = data_hora_compra;
        this.taxa_compra = taxa_compra;
        this.protocolo_compra = protocolo_compra;
    }

    public void setFotos(List<FotoAnuncio> fotos) {
        this.fotos = fotos;
    }

    public List<FotoAnuncio> getFotos() {
        return fotos;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setUsuario_id(Long usuario_id) {
        this.usuario_id = usuario_id;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setLaudo_veicular(String laudo_veicular) {
        this.laudo_veicular = laudo_veicular;
    }

    public void setFormas_pagamento(String formas_pagamento) {
        this.formas_pagamento = formas_pagamento;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPortas(Integer portas) {
        this.portas = portas;
    }

    public void setQuantidade_donos(Integer quantidade_donos) {
        this.quantidade_donos = quantidade_donos;
    }

    public void setFinal_placa(String final_placa) {
        this.final_placa = final_placa;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public void setKilometragem(Integer kilometragem) {
        this.kilometragem = kilometragem;
    }

    public void setCambio(String cambio) {
        this.cambio = cambio;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    public void setData_hora_criacao(Timestamp data_hora_criacao) {
        this.data_hora_criacao = data_hora_criacao;
    }

    public void setData_hora_compra(Timestamp data_hora_compra) {
        this.data_hora_compra = data_hora_compra;
    }

    public void setTaxa_compra(Double taxa_compra) {
        this.taxa_compra = taxa_compra;
    }

    public void setProtocolo_compra(Long protocolo_compra) {
        this.protocolo_compra = protocolo_compra;
    }

    public Long getId() {
        return id;
    }

    public Long getUsuario_id() {
        return usuario_id;
    }

    public Double getNota() {
        return nota;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLaudo_veicular() {
        return laudo_veicular;
    }

    public String getFormas_pagamento() {
        return formas_pagamento;
    }

    public String getStatus() {
        return status;
    }

    public Integer getPortas() {
        return portas;
    }

    public Integer getQuantidade_donos() {
        return quantidade_donos;
    }

    public String getFinal_placa() {
        return final_placa;
    }

    public String getCor() {
        return cor;
    }

    public String getMotor() {
        return motor;
    }

    public Integer getAno() {
        return ano;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public Integer getKilometragem() {
        return kilometragem;
    }

    public String getCambio() {
        return cambio;
    }

    public String getModelo() {
        return modelo;
    }

    public String getMarca() {
        return marca;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public Timestamp getData_hora_criacao() {
        return data_hora_criacao;
    }

    public Timestamp getData_hora_compra() {
        return data_hora_compra;
    }
    
    public Double getTaxa_compra() {
        return taxa_compra;
    }

    public Long getProtocolo_compra() {
        return protocolo_compra;
    }
    
    
    
}
