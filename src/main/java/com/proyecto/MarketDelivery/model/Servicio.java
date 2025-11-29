package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "servicios")
public class Servicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Servicios")
    private Long id;

    @Column(name = "Descripcion")
    private String descripcion;

    @Column(name = "Disponibilidad")
    private String disponibilidad;

    // Relación con agenda
    @ManyToOne
    @JoinColumn(name = "Agenda_Id_Agenda")
    private Agenda agenda;

    // Relación con catálogo
    @ManyToOne
    @JoinColumn(name = "Catalogo_Id_Catalogo")
    private Catalogo catalogo;

    // Getters y Setters -------------------------
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public String getDisponibilidad() { return disponibilidad; }
    public void setDisponibilidad(String disponibilidad) { this.disponibilidad = disponibilidad; }

    public Agenda getAgenda() { return agenda; }
    public void setAgenda(Agenda agenda) { this.agenda = agenda; }

    public Catalogo getCatalogo() { return catalogo; }
    public void setCatalogo(Catalogo catalogo) { this.catalogo = catalogo; }
}
