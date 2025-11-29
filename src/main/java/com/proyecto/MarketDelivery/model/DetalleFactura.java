package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "detalle_factura")
public class DetalleFactura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Detalle_Factura")
    private Long id;

    @Column(name = "Cantidad")
    private Integer cantidad;

    @Column(name = "Subtotal")
    private Double subtotal;

    // Relación con factura
    @ManyToOne
    @JoinColumn(name = "Factura_Id_Factura")
    private Factura factura;

    // Relación con producto (opcional)
    @ManyToOne
    @JoinColumn(name = "Id_Productos", nullable = true)
    private Producto producto;

    // Relación con servicio (opcional)
    @ManyToOne
    @JoinColumn(name = "Id_Servicios", nullable = true)
    private Servicio servicio;

    // Getters y Setters ------------------------------

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public Double getSubtotal() { return subtotal; }
    public void setSubtotal(Double subtotal) { this.subtotal = subtotal; }

    public Factura getFactura() { return factura; }
    public void setFactura(Factura factura) { this.factura = factura; }

    public Producto getProducto() { return producto; }
    public void setProducto(Producto producto) { this.producto = producto; }

    public Servicio getServicio() { return servicio; }
    public void setServicio(Servicio servicio) { this.servicio = servicio; }
}
