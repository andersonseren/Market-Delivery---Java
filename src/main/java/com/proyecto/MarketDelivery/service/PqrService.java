package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Pqr;
import java.util.List;

public interface PqrService {

    List<Pqr> listarPqr();
    Pqr obtenerPqrPorId(Long id);
    Pqr guardarPqr(Pqr pqr);
    Pqr actualizarPqr(Long id, Pqr pqr);
    void eliminarPqr(Long id);
}
