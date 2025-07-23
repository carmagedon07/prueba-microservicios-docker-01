package com.ProductoAPI.Producto.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProductoJPARepository extends JpaRepository<ProductoEntity,Long> {

    @Query(value = "SELECT cantidad FROM inventario WHERE producto_id = :id", nativeQuery = true)
    Integer encontrarCantidadPorProductoId(@Param("id") Long productoId);
}
