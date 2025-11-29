package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Factura;
import java.util.List;

public interface FacturaService {

    List<Factura> listarFacturas();
    Factura obtenerFacturaPorId(Long id);
    Factura guardarFactura(Factura factura);
    Factura actualizarFactura(Long id, Factura factura);
    void eliminarFactura(Long id);
}

