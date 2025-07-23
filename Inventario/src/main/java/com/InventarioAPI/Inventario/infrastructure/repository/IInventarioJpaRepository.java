package com.InventarioAPI.Inventario.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IInventarioJpaRepository extends JpaRepository<InventarioEntity,Long> {
}
