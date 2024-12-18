package com.mlb.Lonas.Default;

public class LonaModel {
    private Long id;
    private String cor;
    private Double comprimento;
    private Double largura;
    private Integer pedido;

    public LonaModel() {
    }

    public LonaModel(Long id, String cor, Double comprimento, Double largura, Integer pedido) {
        this.id = id;
        this.cor = cor;
        this.comprimento = comprimento;
        this.largura = largura;
        this.pedido = pedido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getComprimento() {
        return comprimento;
    }

    public void setComprimento(Double comprimento) {
        this.comprimento = comprimento;
    }

    public Double getLargura() {
        return largura;
    }

    public void setLargura(Double largura) {
        this.largura = largura;
    }

    public Integer getPedido() {
        return pedido;
    }

    public void setPedido(Integer pedido) {
        this.pedido = pedido;
    }
}
