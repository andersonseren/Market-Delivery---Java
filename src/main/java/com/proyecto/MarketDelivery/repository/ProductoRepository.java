package com.proyecto.MarketDelivery.repository;

import com.proyecto.MarketDelivery.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
