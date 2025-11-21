package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Busca un usuario por su nombre de usuario
    Optional<Usuario> findByUserName(String userName);

    // Verifica si ya existe un usuario con ese nombre
    boolean existsByUserName(String userName);
}
