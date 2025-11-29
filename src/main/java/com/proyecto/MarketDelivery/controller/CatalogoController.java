package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Catalogo;
import com.proyecto.MarketDelivery.service.CatalogoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/catalogos")
public class CatalogoController {

    private final CatalogoService catalogoService;

    public CatalogoController(CatalogoService catalogoService) {
        this.catalogoService = catalogoService;
    }

    @GetMapping
    public List<Catalogo> listar() {
        return catalogoService.listarCatalogos();
    }

    @GetMapping("/{id}")
    public Catalogo obtener(@PathVariable Long id) {
        return catalogoService.obtenerCatalogoPorId(id);
    }

    @PostMapping
    public Catalogo guardar(@RequestBody Catalogo catalogo) {
        return catalogoService.guardarCatalogo(catalogo);
    }

    @PutMapping("/{id}")
    public Catalogo actualizar(@PathVariable Long id, @RequestBody Catalogo catalogo) {
        return catalogoService.actualizarCatalogo(id, catalogo);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        catalogoService.eliminarCatalogo(id);
    }
}
