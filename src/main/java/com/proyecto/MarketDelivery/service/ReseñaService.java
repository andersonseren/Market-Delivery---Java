package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Reseña;
import java.util.List;

public interface ReseñaService {

    List<Reseña> listarReseñas();
    Reseña obtenerResenaPorId(Long id);
    Reseña guardarReseña(Reseña reseña);
    Reseña actualizarReseña(Long id, Reseña reseña);
    void eliminarReseña(Long id);
}



