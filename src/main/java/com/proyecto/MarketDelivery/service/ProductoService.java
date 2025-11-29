package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Producto;
import java.util.List;

public interface ProductoService {

    List<Producto> listarProductos();
    Producto obtenerProductoPorId(Long id);
    Producto guardarProducto(Producto producto);
    Producto actualizarProducto(Long id, Producto producto);
    void eliminarProducto(Long id);
}

