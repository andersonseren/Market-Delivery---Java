package com.proyecto.MarketDelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin/dashboard")
    public String adminPanel() {
        return "🔒 Bienvenido al panel del ADMINISTRADOR";
    }
}
