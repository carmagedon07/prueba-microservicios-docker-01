package com.ProductoAPI.Producto.application.service;

import com.ProductoAPI.Producto.domain.model.Producto;
import com.ProductoAPI.Producto.infrastructure.repository.ProductoEntity;
import com.ProductoAPI.Producto.infrastructure.repository.ProductoJPARepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductoServiceImpl implements  IProductoService {

    private final ProductoJPARepository repo;

    public ProductoServiceImpl(ProductoJPARepository repo) {

        this.repo = repo;

    }


    @Override
    public Producto creaProducto(Producto producto) {

        ProductoEntity prosuctoDb =  new ProductoEntity().builder()
                .nombre(producto.getNombre())
                .precio(producto.getPrecio())
                .descripcion(producto.getDescripcion())
                .build();

        prosuctoDb = repo.save(prosuctoDb);

        producto.setId(prosuctoDb.getId());
        return producto;
    }

    @Override
    public Optional<Producto> obtenerPorId(Long id) {
        ProductoEntity ProductoById = repo.findById(id).orElse(null);
        Producto producto = new Producto();

        if(producto!=null){
            producto.setNombre(ProductoById.getNombre());
            producto.setPrecio(ProductoById.getPrecio());
            producto.setDescripcion(ProductoById.getDescripcion());
            producto.setId(id);
        }
        Optional<Producto> productoOptional = Optional.of(producto);
        return productoOptional;
    }

    @Override
    public List<Producto> Listar() {
        List<ProductoEntity> listarProductos = repo.findAll();

        if(listarProductos.size()==0){
            return null;
        }

        List<Producto> productos = new ArrayList<>();

        for (ProductoEntity productoEntity : listarProductos) {
            Producto producto = new Producto();
            producto.setId(productoEntity.getId());
            producto.setNombre(productoEntity.getNombre());
            producto.setPrecio(productoEntity.getPrecio());
            producto.setDescripcion(productoEntity.getDescripcion());
            productos.add(producto);
        }

        return productos;
    }

    @Override
    public Producto actualizar(Long id, Producto producto) {

        ProductoEntity productoEntity = repo.findById(id).get();
        if(!repo.findById(id).isPresent()){
            return null;
        }


        productoEntity.setNombre(producto.getNombre());
        productoEntity.setPrecio(producto.getPrecio());
        productoEntity.setDescripcion(producto.getDescripcion());

        repo.save(productoEntity);

        return producto;
    }

    @Override
    public void eliminar(Long id) {

        repo.deleteById(id);
    }
}
