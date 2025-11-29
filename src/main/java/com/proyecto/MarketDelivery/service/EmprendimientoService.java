package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import java.util.List;

public interface EmprendimientoService {

    List<Emprendimiento> listarEmprendimientos();
    Emprendimiento obtenerEmprendimientoPorId(Long id);
    Emprendimiento guardarEmprendimiento(Emprendimiento emprendimiento);
    Emprendimiento actualizarEmprendimiento(Long id, Emprendimiento emprendimiento);
    void eliminarEmprendimiento(Long id);
}

