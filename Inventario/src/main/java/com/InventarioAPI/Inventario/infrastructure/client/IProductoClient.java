package com.InventarioAPI.Inventario.infrastructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "producto-service", url = "http://localhost:8081")
public interface IProductoClient {
    @GetMapping("/api/productos/{id}")
    ResponseEntity<?> obtenerPorId(@PathVariable Long id);
}

