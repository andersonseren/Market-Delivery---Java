package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.DetalleFactura;
import java.util.List;

public interface DetalleFacturaService {

    List<DetalleFactura> listarDetalles();
    DetalleFactura obtenerDetallePorId(Long id);
    DetalleFactura guardarDetalle(DetalleFactura detalleFactura);
    DetalleFactura actualizarDetalle(Long id, DetalleFactura detalleFactura);
    void eliminarDetalle(Long id);
}

