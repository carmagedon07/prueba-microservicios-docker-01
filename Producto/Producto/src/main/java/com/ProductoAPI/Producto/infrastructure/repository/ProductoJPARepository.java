package com.ProductoAPI.Producto.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoJPARepository extends JpaRepository<ProductoEntity,Long> {
}
