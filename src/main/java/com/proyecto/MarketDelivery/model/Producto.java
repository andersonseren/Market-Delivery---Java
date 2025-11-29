package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Productos")
    private Long id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Valor_Unitario")
    private Double valorUnitario;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Stock")
    private Integer stock;

    // Relación con catálogo
    @ManyToOne
    @JoinColumn(name = "Catalogo_Id_Catalogo")
    private Catalogo catalogo;

    // Relación con promoción
    @ManyToOne
    @JoinColumn(name = "Promocion_Id_Promocion")
    private Promocion promocion;

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public Double getValorUnitario() { return valorUnitario; }
    public void setValorUnitario(Double valorUnitario) { this.valorUnitario = valorUnitario; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getStock() { return stock; }
    public void setStock(Integer stock) { this.stock = stock; }

    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }

    public Promocion getPromocion() { return promocion; }
    public void setPromocion(Promocion promocion) { this.promocion = promocion; }
}
