package com.ProductoAPI.Producto.interfaces.controller;

import com.ProductoAPI.Producto.application.service.IProductoService;
import com.ProductoAPI.Producto.domain.model.Producto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")

public class ProductoController {

    private final IProductoService servicio;

    public ProductoController(IProductoService servicio) {
        this.servicio = servicio;
    }

    @PostMapping
    @Operation(summary = "Se crea el producto")
    public ResponseEntity<Producto> crear(@RequestBody Producto producto) {
        Producto creado = servicio.creaProducto(producto);
        return ResponseEntity.status(201).body(creado);
    }

    @GetMapping
    @Operation(summary = "Se lista los productos que se encuentra guardados en la base de datos")
    public ResponseEntity<List<Producto>> listar() {
        return ResponseEntity.ok(servicio.Listar());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Se busca el producto por el id")
    public ResponseEntity<?> obtenerPorId(@PathVariable Long id) {
        Optional<Producto> producto = servicio.obtenerPorId(id);
        return producto
                .map(ResponseEntity::ok)
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));

    }

    @PutMapping("/{id}")
    @Operation(summary = "actualiza el producto ")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Producto producto) {
        try {
            Producto actualizado = servicio.actualizar(id, producto);
            return ResponseEntity.ok(actualizado);
        } catch (Exception e) {
            return ResponseEntity.status(404).body("No se pudo actualizar: " + e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Se elimina el producto por el id")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
        servicio.eliminar(id);
        return ResponseEntity.noContent().build();
    }
}
