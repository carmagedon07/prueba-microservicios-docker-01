package com.ProductoAPI.Producto.application.service;

import com.ProductoAPI.Producto.domain.model.Producto;

import java.util.List;
import java.util.Optional;

public interface IProductoService {

    Producto creaProducto(Producto producto);
    Optional<Producto> obtenerPorId(Long id);
    List<Producto> Listar();
    Producto actualizar(Long id, Producto producto);
    void eliminar(Long id);

}
