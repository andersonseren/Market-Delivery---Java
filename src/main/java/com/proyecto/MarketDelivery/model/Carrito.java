package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "carrito")
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Carrito")
    private Long id;

    // Relación con productos
    @ManyToOne
    @JoinColumn(name = "Producto_Id_Producto")
    private Producto producto;

    // Relación con servicios
    @ManyToOne
    @JoinColumn(name = "Servicio_Id_Servicio")
    private Servicio servicio;

    @Column(name = "Total")
    private Double total;

    // Getters y Setters -------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
