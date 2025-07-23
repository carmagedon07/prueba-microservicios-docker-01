package com.ProductoAPI.Producto.infrastructure.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "Productos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoEntity {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Double precio;
    private String descripcion;

}
