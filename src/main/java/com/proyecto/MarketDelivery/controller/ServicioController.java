package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Servicio;
import com.proyecto.MarketDelivery.service.ServicioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/servicios")
public class ServicioController {

    private final ServicioService servicioService;

    public ServicioController(ServicioService servicioService) {
        this.servicioService = servicioService;
    }

    @GetMapping
    public List<Servicio> listar() {
        return servicioService.listarServicios();
    }

    @GetMapping("/{id}")
    public Servicio obtener(@PathVariable Long id) {
        return servicioService.obtenerServicioPorId(id);
    }

    @PostMapping
    public Servicio guardar(@RequestBody Servicio servicio) {
        return servicioService.guardarServicio(servicio);
    }

    @PutMapping("/{id}")
    public Servicio actualizar(@PathVariable Long id, @RequestBody Servicio servicio) {
        return servicioService.actualizarServicio(id, servicio);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        servicioService.eliminarServicio(id);
    }
}

