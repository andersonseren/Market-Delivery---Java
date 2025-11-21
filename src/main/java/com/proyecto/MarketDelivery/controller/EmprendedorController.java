package com.proyecto.MarketDelivery.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmprendedorController {

    @GetMapping("/emprendedor/dashboard")
    public String emprendedorPanel() {
        return "💼 Bienvenido al panel del EMPRENDEDOR";
    }
}
