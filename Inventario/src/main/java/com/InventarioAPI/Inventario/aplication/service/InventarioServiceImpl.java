package com.InventarioAPI.Inventario.aplication.service;

import com.InventarioAPI.Inventario.domain.model.Inventario;
import com.InventarioAPI.Inventario.infrastructure.client.IProductoClient;
import com.InventarioAPI.Inventario.infrastructure.repository.IInventarioJpaRepository;
import com.InventarioAPI.Inventario.infrastructure.repository.InventarioEntity;
import com.InventarioAPI.Inventario.interfaces.dto.ProductoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class InventarioServiceImpl implements  IInventarioService {

    private final IInventarioJpaRepository repo;


    private final IProductoClient client;


    public InventarioServiceImpl(IInventarioJpaRepository repo, IProductoClient client) {
        this.repo = repo;
        this.client = client;
    }

    @Override
    public Inventario actualizarCantidad(Long productoId, Integer nuevaCantidad) {

        InventarioEntity inv = repo.findById(productoId).orElse(new InventarioEntity(productoId, 0));
        inv.setCantidad(nuevaCantidad);
        inv = repo.save(inv);

        Inventario showIn = new Inventario(inv.getProductoId(), inv.getCantidad());

        return showIn;
    }

    @Override
    public Inventario consultarCantidad(Long productoId) {

        InventarioEntity inv = repo.findById(productoId).orElse(new InventarioEntity(0L, 0));

        if(inv.getProductoId()==0L){
            new RuntimeException("Inventario no encontrado");
        }

        Inventario showIn = new Inventario(inv.getProductoId(), inv.getCantidad());

        return showIn;
    }

    @Override
    public String comprarProducto(Long productoId, Integer cantidad) {
        //String productoUrl = "http://localhost:8081/api/productos/" + productoId;
        ResponseEntity<?> resp = null;
        try {
             resp = client.obtenerPorId(productoId);
        } catch (Exception e) {
            throw new RuntimeException("Producto no existe en el microservicio de productos");
        }
        InventarioEntity inv = new InventarioEntity();
        if (resp.getStatusCode().is2xxSuccessful() && resp.getBody() != null) {
            ProductoDTO body = (ProductoDTO)resp.getBody();
            inv = repo.findById(productoId).orElse(new InventarioEntity(body.getId(), cantidad));
        }


        if (inv.getCantidad() < cantidad) {
            throw new RuntimeException("Inventario insuficiente");
        }

        inv.setCantidad(inv.getCantidad() - cantidad);
        repo.save(inv);

        return "Compra exitosa. Cantidad restante: " + inv.getCantidad();
    }
}
