package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Reseña;
import com.proyecto.MarketDelivery.service.ReseñaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reseñas")
public class ReseñaController {

    private final ReseñaService reseñaService;

    public ReseñaController(ReseñaService reseñaService) {
        this.reseñaService = reseñaService;
    }

    @GetMapping
    public List<Reseña> listar() {
        return reseñaService.listarReseñas();
    }

    @GetMapping("/{id}")
    public Reseña obtener(@PathVariable Long id) {
        return reseñaService.obtenerResenaPorId(id);
    }

    @PostMapping
    public Reseña guardar(@RequestBody Reseña resena) {
        return reseñaService.guardarReseña(resena);
    }

    @PutMapping("/{id}")
    public Reseña actualizar(@PathVariable Long id, @RequestBody Reseña resena) {
        return reseñaService.actualizarReseña(id, resena);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        reseñaService.eliminarReseña(id);
    }
}
