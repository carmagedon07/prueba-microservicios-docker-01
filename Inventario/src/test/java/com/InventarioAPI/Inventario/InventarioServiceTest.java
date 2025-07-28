package com.InventarioAPI.Inventario;

import com.InventarioAPI.Inventario.aplication.service.IInventarioService;
import com.InventarioAPI.Inventario.aplication.service.InventarioServiceImpl;
import com.InventarioAPI.Inventario.infrastructure.client.IProductoClient;
import com.InventarioAPI.Inventario.infrastructure.repository.IInventarioJpaRepository;
import com.InventarioAPI.Inventario.infrastructure.repository.InventarioEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.util.Optional;
import java.util.Map;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class InventarioServiceTest {

    private IInventarioJpaRepository repo;
    private IProductoClient client;
    private IInventarioService service;

    @BeforeEach
    void setUp() {
        repo = mock(IInventarioJpaRepository.class);
        client = mock(IProductoClient.class);
        service = new InventarioServiceImpl(repo, client);
    }

    @Test
    void testCompraExitosa() {
       /* Long productoId = 1L;
        Integer cantidad = 5;

        // Mock respuesta del cliente
        Map<String, Object> producto = new HashMap<>();
        producto.put("id", productoId);
        ResponseEntity<Map<String, Object>> response = ResponseEntity.ok(producto);
        when(client.obtenerPorId(productoId)).thenReturn(ResponseEntity.ok(new HashMap<>()));

        // Mock inventario
        InventarioEntity inventarioExistente = new InventarioEntity(productoId, 10);
        when(repo.findById(productoId)).thenReturn(Optional.of(inventarioExistente));

        // Ejecutar prueba
        String resultado = service.comprarProducto(productoId, cantidad);

        assertEquals("Compra exitosa. Cantidad restante: 5", resultado);
        verify(repo).save(Mockito.argThat(inv -> inv.getCantidad() == 5));*/
    }

    @Test
    void testCompraConInventarioInsuficiente() {
        /*Long productoId = 2L;
        Integer cantidad = 10;

        Map<String, Object> producto = new HashMap<>();
        producto.put("id", productoId);
        ResponseEntity<?> response = ResponseEntity.ok(producto);
        when(client.obtenerPorId(productoId)).thenReturn(ResponseEntity.ok(new HashMap<>()));

        InventarioEntity inventarioExistente = new InventarioEntity(productoId, 3);
        when(repo.findById(productoId)).thenReturn(Optional.of(inventarioExistente));

        RuntimeException ex = assertThrows(RuntimeException.class, () -> {
            service.comprarProducto(productoId, cantidad);
        });

        assertEquals("Inventario insuficiente", ex.getMessage());*/
    }
}
