package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Rol;
import java.util.List;

public interface RolService {

    List<Rol> listarRoles();
    Rol obtenerRolPorId(Long id);
    Rol guardarRol(Rol rol);
    Rol actualizarRol(Long id, Rol rol);
    void eliminarRol(Long id);
}

