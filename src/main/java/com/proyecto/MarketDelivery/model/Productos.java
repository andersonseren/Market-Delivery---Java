package com.ejemplo.demoproyecto.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "productos")
public class Productos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Productos")
    private Long idProducto;

    private String nombre;

    @Column(name = "Valor_Unitario")
    private Double valorUnitario;

    private String descripcion;

    @Column(name = "Stock")
    private Integer stock;

    @ManyToOne
    @JoinColumn(name = "Catalogo_Id_Catalogo")
    private Catalogo catalogo;

    @ManyToOne
    @JoinColumn(name = "Promoción_Id_Promoción")
    private Promocion promocion;

    @ManyToOne
    @JoinColumn(name = "Id_Emprendimiento")
    private Emprendimiento emprendimiento;

    @OneToMany(mappedBy = "producto")
    private List<DetalleFactura> detallesFactura;

    @OneToMany(mappedBy = "producto")
    private List<Carrito> carritos;
}
