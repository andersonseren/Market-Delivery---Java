package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Catalogo;
import java.util.List;

public interface CatalogoService {

    List<Catalogo> listarCatalogos();
    Catalogo obtenerCatalogoPorId(Long id);
    Catalogo guardarCatalogo(Catalogo catalogo);
    Catalogo actualizarCatalogo(Long id, Catalogo catalogo);
    void eliminarCatalogo(Long id);
}
