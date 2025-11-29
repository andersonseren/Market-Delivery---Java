package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Agenda;
import com.proyecto.MarketDelivery.service.AgendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/agenda")
public class AgendaController {

    private final AgendaService agendaService;

    public AgendaController(AgendaService agendaService) {
        this.agendaService = agendaService;
    }

    @GetMapping
    public List<Agenda> listar() {
        return agendaService.listarAgenda();
    }

    @GetMapping("/{id}")
    public Agenda obtener(@PathVariable Long id) {
        return agendaService.obtenerAgendaPorId(id);
    }

    @PostMapping
    public Agenda guardar(@RequestBody Agenda agenda) {
        return agendaService.guardarAgenda(agenda);
    }

    @PutMapping("/{id}")
    public Agenda actualizar(@PathVariable Long id, @RequestBody Agenda agenda) {
        return agendaService.actualizarAgenda(id, agenda);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id) {
        agendaService.eliminarAgenda(id);
    }
}
