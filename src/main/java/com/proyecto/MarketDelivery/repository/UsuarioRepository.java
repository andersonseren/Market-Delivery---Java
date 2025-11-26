package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    // Del primer controlador
    Optional<Usuario> findByUserName(String userName);
    boolean existsByUserName(String userName);
}

