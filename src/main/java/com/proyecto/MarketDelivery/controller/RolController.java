package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Rol;
import com.proyecto.MarketDelivery.service.RolService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
public class RolController {

    private final RolService rolService;

    public RolController(RolService rolService) {
        this.rolService = rolService;
    }

    @GetMapping
    public List<Rol> listar() {
        return rolService.listarRoles();
    }

    @GetMapping("/{id}")
    public Rol obtener(@PathVariable Long id) {
        return rolService.obtenerRolPorId(id);
    }

    @PostMapping
    public Rol guardar(@RequestBody Rol rol) {
        return rolService.guardarRol(rol);
    }

    @PutMapping("/{id}")
    public Rol actualizar(@PathVariable Long id, @RequestBody Rol rol) {
        return rolService.actualizarRol(id, rol);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        rolService.eliminarRol(id);
    }
}
