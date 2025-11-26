package com.proyecto.MarketDelivery.model;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id_Usuario")
    private Long id;

    @Column(unique = true, nullable = false)
    private String userName;

    @Column(nullable = false)
    private String password;

    @Column(name = "Nombre1_usuario")
    private String nombre1;

    @Column(name = "Nombre2_usuario")
    private String nombre2;

    @Column(name = "Apellido1_usuario")
    private String apellido1;

    @Column(name = "Apellido2_usuario")
    private String apellido2;

    @Column(name = "Cedula_usuario")
    private String cedula;

    @Column(name = "Email_usuario")
    private String email;

    @Column(name = "Direccion_usuario")
    private String direccion;

    // Relación con Rol (fusionado del modelo complejo)
    @ManyToOne
    @JoinColumn(name = "Rol_Id_Rol")
    private Rol rol;

    // Relación con Carrito
    @OneToOne
    @JoinColumn(name = "Carrito_Id_Carrito")
    private Carrito carrito;

    // Relación con Emprendimiento
    @ManyToOne
    @JoinColumn(name = "Id_Emprendimiento")
    private Emprendimiento emprendimiento;

    // Getters y Setters (agrega todos manualmente o usa Lombok)
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getNombre1() { return nombre1; }
    public void setNombre1(String nombre1) { this.nombre1 = nombre1; }

    public String getNombre2() { return nombre2; }
    public void setNombre2(String nombre2) { this.nombre2 = nombre2; }

    public String getApellido1() { return apellido1; }
    public void setApellido1(String apellido1) { this.apellido1 = apellido1; }

    public String getApellido2() { return apellido2; }
    public void setApellido2(String apellido2) { this.apellido2 = apellido2; }

    public String getCedula() { return cedula; }
    public void setCedula(String cedula) { this.cedula = cedula; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getDireccion() { return direccion; }
    public void setDireccion(String direccion) { this.direccion = direccion; }

    public Rol getRol() { return rol; }
    public void setRol(Rol rol) { this.rol = rol; }

    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }

    public Emprendimiento getEmprendimiento() { return emprendimiento; }
    public void setEmprendimiento(Emprendimiento emprendimiento) { this.emprendimiento = emprendimiento; }
}

