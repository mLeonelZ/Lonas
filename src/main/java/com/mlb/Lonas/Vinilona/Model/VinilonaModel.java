package com.mlb.Lonas.Vinilona.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tb_vinilona")
@NoArgsConstructor
@AllArgsConstructor
@Data // Getters e Setters

public class VinilonaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String cor;
    private Double comprimento;
    private Double largura;
    private Integer pedido;


}
