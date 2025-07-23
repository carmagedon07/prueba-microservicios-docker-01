package com.ProductoAPI.Producto.interfaces.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ProductoDTO {
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;
}
