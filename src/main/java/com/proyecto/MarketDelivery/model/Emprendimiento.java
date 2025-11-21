package com.ejemplo.demoproyecto.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name = "emprendimiento")

public class Emprendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "Id_Emprendimiento")
    private Long id_Emprendimiento;

    @Column (name = "Nombre_Emprendimiento")
    private String nombre;

    @Column (name = "Tipo_Emprendimiento")
    private String tipo;

    private String Descripcion;
    private String Ciudad;
    private String Direccion;
    private String Telefono;

    @OneToMany(mappedBy = "emprendimiento")
    private List<usuario> usuarios;

    @OneToMany(mappedBy = "emprendimiento")
    private List<Producto> productos;

    
}
