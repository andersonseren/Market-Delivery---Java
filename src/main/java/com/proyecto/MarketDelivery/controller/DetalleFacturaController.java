package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.DetalleFactura;
import com.proyecto.MarketDelivery.service.DetalleFacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detalles-factura")
public class DetalleFacturaController {

    private final DetalleFacturaService detalleFacturaService;

    public DetalleFacturaController(DetalleFacturaService detalleFacturaService) {
        this.detalleFacturaService = detalleFacturaService;
    }

    @GetMapping
    public List<DetalleFactura> listar() {
        return detalleFacturaService.listarDetalles();
    }

    @GetMapping("/{id}")
    public DetalleFactura obtener(@PathVariable Long id) {
        return detalleFacturaService.obtenerDetallePorId(id);
    }

    @PostMapping
    public DetalleFactura guardar(@RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.guardarDetalle(detalleFactura);
    }

    @PutMapping("/{id}")
    public DetalleFactura actualizar(@PathVariable Long id, @RequestBody DetalleFactura detalleFactura) {
        return detalleFacturaService.actualizarDetalle(id, detalleFactura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        detalleFacturaService.eliminarDetalle(id);
    }
}
