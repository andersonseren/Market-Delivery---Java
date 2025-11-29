package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Servicio;
import java.util.List;

public interface ServicioService {

    List<Servicio> listarServicios();
    Servicio obtenerServicioPorId(Long id);
    Servicio guardarServicio(Servicio servicio);
    Servicio actualizarServicio(Long id, Servicio servicio);
    void eliminarServicio(Long id);
}
