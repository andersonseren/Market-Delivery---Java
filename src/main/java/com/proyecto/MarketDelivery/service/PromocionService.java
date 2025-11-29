package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Promocion;
import java.util.List;

public interface PromocionService {

    List<Promocion> listarPromociones();
    Promocion obtenerPromocionPorId(Long id);
    Promocion guardarPromocion(Promocion promocion);
    Promocion actualizarPromocion(Long id, Promocion promocion);
    void eliminarPromocion(Long id);
}
