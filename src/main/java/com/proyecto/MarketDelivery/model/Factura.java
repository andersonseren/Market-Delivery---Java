package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "factura")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Factura")
    private Long id;

    @Column(name = "Fecha_Factura")
    private String fechaFactura;

    // Relación con Usuario
    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario")
    private Usuario usuario;

    // Relación con Carrito
    @ManyToOne
    @JoinColumn(name = "Carrito_Id_Carrito")
    private Carrito carrito;

    // Getters y Setters ----------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFechaFactura() {
        return fechaFactura;
    }

    public void setFechaFactura(String fechaFactura) {
        this.fechaFactura = fechaFactura;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
