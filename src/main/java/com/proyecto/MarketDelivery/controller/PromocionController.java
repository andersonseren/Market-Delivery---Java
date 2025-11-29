package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Promocion;
import com.proyecto.MarketDelivery.service.PromocionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/promociones")
public class PromocionController {

    private final PromocionService promocionService;

    public PromocionController(PromocionService promocionService) {
        this.promocionService = promocionService;
    }

    @GetMapping
    public List<Promocion> listar() {
        return promocionService.listarPromociones();
    }

    @GetMapping("/{id}")
    public Promocion obtener(@PathVariable Long id) {
        return promocionService.obtenerPromocionPorId(id);
    }

    @PostMapping
    public Promocion guardar(@RequestBody Promocion promocion) {
        return promocionService.guardarPromocion(promocion);
    }

    @PutMapping("/{id}")
    public Promocion actualizar(@PathVariable Long id, @RequestBody Promocion promocion) {
        return promocionService.actualizarPromocion(id, promocion);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        promocionService.eliminarPromocion(id);
    }
}



