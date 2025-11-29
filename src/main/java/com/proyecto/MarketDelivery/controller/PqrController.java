package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Pqr;
import com.proyecto.MarketDelivery.service.PqrService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pqr")
public class PqrController {

    private final PqrService pqrService;

    public PqrController(PqrService pqrService) {
        this.pqrService = pqrService;
    }

    @GetMapping
    public List<Pqr> listar() {
        return pqrService.listarPqr();
    }

    @GetMapping("/{id}")
    public Pqr obtener(@PathVariable Long id) {
        return pqrService.obtenerPqrPorId(id);
    }

    @PostMapping
    public Pqr guardar(@RequestBody Pqr pqr) {
        return pqrService.guardarPqr(pqr);
    }

    @PutMapping("/{id}")
    public Pqr actualizar(@PathVariable Long id, @RequestBody Pqr pqr) {
        return pqrService.actualizarPqr(id, pqr);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        pqrService.eliminarPqr(id);
    }
}
