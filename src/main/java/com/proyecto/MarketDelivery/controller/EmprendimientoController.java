package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Emprendimiento;
import com.proyecto.MarketDelivery.service.EmprendimientoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/emprendimientos")
public class EmprendimientoController {

    private final EmprendimientoService emprendimientoService;

    public EmprendimientoController(EmprendimientoService emprendimientoService) {
        this.emprendimientoService = emprendimientoService;
    }

    @GetMapping
    public List<Emprendimiento> listar() {
        return emprendimientoService.listarEmprendimientos();
    }

    @GetMapping("/{id}")
    public Emprendimiento obtener(@PathVariable Long id) {
        return emprendimientoService.obtenerEmprendimientoPorId(id);
    }

    @PostMapping
    public Emprendimiento guardar(@RequestBody Emprendimiento emprendimiento) {
        return emprendimientoService.guardarEmprendimiento(emprendimiento);
    }

    @PutMapping("/{id}")
    public Emprendimiento actualizar(@PathVariable Long id, @RequestBody Emprendimiento emprendimiento) {
        return emprendimientoService.actualizarEmprendimiento(id, emprendimiento);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        emprendimientoService.eliminarEmprendimiento(id);
    }
}

