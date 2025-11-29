package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Carrito;
import java.util.List;

public interface CarritoService {

    List<Carrito> listarCarritos();
    Carrito obtenerCarritoPorId(Long id);
    Carrito guardarCarrito(Carrito carrito);
    Carrito actualizarCarrito(Long id, Carrito carrito);
    void eliminarCarrito(Long id);
}
