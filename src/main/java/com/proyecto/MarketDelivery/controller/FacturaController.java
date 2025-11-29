package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Factura;
import com.proyecto.MarketDelivery.service.FacturaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
public class FacturaController {

    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }

    @GetMapping
    public List<Factura> listar() {
        return facturaService.listarFacturas();
    }

    @GetMapping("/{id}")
    public Factura obtener(@PathVariable Long id) {
        return facturaService.obtenerFacturaPorId(id);
    }

    @PostMapping
    public Factura guardar(@RequestBody Factura factura) {
        return facturaService.guardarFactura(factura);
    }

    @PutMapping("/{id}")
    public Factura actualizar(@PathVariable Long id, @RequestBody Factura factura) {
        return facturaService.actualizarFactura(id, factura);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        facturaService.eliminarFactura(id);
    }
}
