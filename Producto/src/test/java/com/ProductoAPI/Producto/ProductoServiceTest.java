package com.ProductoAPI.Producto;

import com.ProductoAPI.Producto.application.service.ProductoServiceImpl;
import com.ProductoAPI.Producto.domain.model.Producto;
import com.ProductoAPI.Producto.infrastructure.repository.ProductoEntity;
import com.ProductoAPI.Producto.infrastructure.repository.ProductoJPARepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

public class ProductoServiceTest {
    private ProductoJPARepository repo;
    private ProductoServiceImpl service;

    @BeforeEach
    void setUp() {
        repo = mock(ProductoJPARepository.class);
        service = new ProductoServiceImpl(repo);
    }

    @Test
    void testCrearProducto() {
        ProductoEntity producto = new ProductoEntity(1L, "Café", 10000.0, "Café premium");
        when(repo.save(producto)).thenReturn(producto);

        Producto p = new Producto(1L, "Café", 10000.0, "Café premium");

        Producto resultado = service.creaProducto(p);

        assertEquals("Café", resultado.getNombre());
        verify(repo).save(producto);
    }

    @Test
    void testObtenerProductoPorId() {
        Long id = 1L;
        ProductoEntity productoEntity = new ProductoEntity(id, "Chocolate", 8000.0, "Chocolate orgánico");

        when(repo.findById(id)).thenReturn(Optional.of(productoEntity));

        Producto resultado = service.obtenerPorId(id).get();

        assertNotNull(resultado);
        assertEquals("Chocolate", resultado.getNombre());
        verify(repo).findById(id);
    }

}
