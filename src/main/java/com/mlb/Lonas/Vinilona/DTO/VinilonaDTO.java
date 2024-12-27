package com.mlb.Lonas.Vinilona.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VinilonaDTO {

    private Long id;
    private String cor;
    private Double comprimento;
    private Double largura;
    private Integer pedido;

    @Override
    public String toString() {
        return "id : " + id +
                ", \ncor : " + cor +
                ", \ncomprimento : " + String.format("%.2f", comprimento) +
                ", \nlargura : " + String.format("%.2f", largura) +
                ", \npedido : " + pedido;
    }
}
