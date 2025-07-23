package com.InventarioAPI.Inventario.aplication.service;

import com.InventarioAPI.Inventario.domain.model.Inventario;

public interface IInventarioService {
    Inventario actualizarCantidad(Long productoId, Integer nuevaCantidad);
    Inventario consultarCantidad(Long productoId);
    String comprarProducto(Long productoId, Integer cantidad);


}
