package com.InventarioAPI.Inventario.infrastructure.repository;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "inventario")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventarioEntity {

    @Id
    @Column(name = "producto_id")
    private Long productoId;
    @Column(name = "cantidad")
    private Integer cantidad;
}
