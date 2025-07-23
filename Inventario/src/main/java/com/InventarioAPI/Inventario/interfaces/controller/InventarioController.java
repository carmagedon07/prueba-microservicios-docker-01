package com.InventarioAPI.Inventario.interfaces.controller;

import com.InventarioAPI.Inventario.aplication.service.IInventarioService;
import com.InventarioAPI.Inventario.domain.model.Inventario;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
@RequestMapping("/api/inventario")
public class InventarioController {

    private final IInventarioService servicio;

    public InventarioController(IInventarioService servicio) {
        this.servicio = servicio;
    }

    @GetMapping("/{id}")
    @Operation(summary = "visualiza el inventario ")
    public ResponseEntity<Inventario> consultar(@PathVariable Long id) {
        return ResponseEntity.ok(servicio.consultarCantidad(id));
    }

    @PatchMapping("/{id}")
    @Operation(summary = "actualizar la cantidad del inventario")
    public ResponseEntity<Inventario> actualizar(@PathVariable Long id, @RequestBody Map<String, Integer> body) {
        Integer cantidad = body.getOrDefault("cantidad", 0);
        return ResponseEntity.ok(servicio.actualizarCantidad(id, cantidad));
    }

    @PostMapping("/compra")
    @Operation(summary = "se ejecuta y se actuaiza la operacion de compra")
    public ResponseEntity<String> comprar(@RequestBody Map<String, Object> body) {
        Long productoId = Long.valueOf(body.get("productoId").toString());
        Integer cantidad = Integer.valueOf(body.get("cantidad").toString());
        return ResponseEntity.ok(servicio.comprarProducto(productoId, cantidad));
    }
}
