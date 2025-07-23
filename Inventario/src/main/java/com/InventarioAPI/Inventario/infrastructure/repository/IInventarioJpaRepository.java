package com.InventarioAPI.Inventario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IInventarioJpaRepository extends JpaRepository<InventarioEntity,Long> {

    @Query(value = "SELECT * FROM inventario ", nativeQuery = true)
    List<Object[]> encontrarCantidadPorProductoId();

    @Modifying
    @Transactional
    @Query(value = "UPDATE inventario SET cantidad = :cantidad WHERE producto_id = :id", nativeQuery = true)
    void actualizarCantidad(@Param("id") Long id, @Param("cantidad") Integer cantidad);
}
