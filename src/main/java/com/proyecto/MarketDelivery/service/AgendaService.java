package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Agenda;
import java.util.List;

public interface AgendaService {

    List<Agenda> listarAgenda();
    Agenda obtenerAgendaPorId(Long id);
    Agenda guardarAgenda(Agenda agenda);
    Agenda actualizarAgenda(Long id, Agenda agenda);
    void eliminarAgenda(Long id);
}
