package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Carrito;
import com.proyecto.MarketDelivery.service.CarritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/carrito")
public class CarritoController {

    private final CarritoService carritoService;

    public CarritoController(CarritoService carritoService) {
        this.carritoService = carritoService;
    }

    @GetMapping
    public List<Carrito> listar() {
        return carritoService.listarCarritos();
    }

    @GetMapping("/{id}")
    public Carrito obtener(@PathVariable Long id) {
        return carritoService.obtenerCarritoPorId(id);
    }

    @PostMapping
    public Carrito guardar(@RequestBody Carrito carrito) {
        return carritoService.guardarCarrito(carrito);
    }

    @PutMapping("/{id}")
    public Carrito actualizar(@PathVariable Long id, @RequestBody Carrito carrito) {
        return carritoService.actualizarCarrito(id, carrito);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
    }
}
