package com.InventarioAPI.Inventario.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Inventario {
    private Long productoId;
    private Integer cantidad;
}
