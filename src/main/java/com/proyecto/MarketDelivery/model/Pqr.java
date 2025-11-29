package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "pqr")
public class Pqr {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_PQR")
    private Long id;

    @Column(name = "Fecha")
    private String fecha;

    @Column(name = "Tipo_Peticion")
    private String tipoPeticion;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Titulo_PQR")
    private String titulo;

    // Relación con usuario
    @ManyToOne
    @JoinColumn(name = "Usuario_Id_Usuario")
    private Usuario usuario;

    // Getters y Setters -------------------------------

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTipoPeticion() {
        return tipoPeticion;
    }

    public void setTipoPeticion(String tipoPeticion) {
        this.tipoPeticion = tipoPeticion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
