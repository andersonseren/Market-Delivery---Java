package com.proyecto.MarketDelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {

    @GetMapping("/cliente/dashboard")
    public String clientePanel() {
        return "🛒 Bienvenido al panel del CLIENTE";
    }
}
