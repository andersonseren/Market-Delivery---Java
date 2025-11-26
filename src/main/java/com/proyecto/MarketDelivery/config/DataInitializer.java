package com.proyecto.MarketDelivery.config;

import com.proyecto.MarketDelivery.model.Rol;
import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.RolRepository;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UsuarioRepository usuarioRepository, RolRepository rolRepository) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            // Crear roles si no existen
            Rol adminRol = rolRepository.findById(1L).orElseGet(() -> {
                Rol rol = new Rol();
                rol.setNombre("ADMINISTRADOR");
                return rolRepository.save(rol);
            });

            Rol empRol = rolRepository.findById(2L).orElseGet(() -> {
                Rol rol = new Rol();
                rol.setNombre("EMPRENDEDOR");
                return rolRepository.save(rol);
            });

            Rol cliRol = rolRepository.findById(3L).orElseGet(() -> {
                Rol rol = new Rol();
                rol.setNombre("CLIENTE");
                return rolRepository.save(rol);
            });

            // Usuarios
            if (usuarioRepository.findByUserName("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUserName("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRol(adminRol);  // Relación
                usuarioRepository.save(admin);
                System.out.println("✅ Usuario ADMINISTRADOR creado");
            }

            if (usuarioRepository.findByUserName("emprendedor").isEmpty()) {
                Usuario emp = new Usuario();
                emp.setUserName("emprendedor");
                emp.setPassword(encoder.encode("emp123"));
                emp.setRol(empRol);
                usuarioRepository.save(emp);
                System.out.println("✅ Usuario EMPRENDEDOR creado");
            }

            if (usuarioRepository.findByUserName("cliente").isEmpty()) {
                Usuario cli = new Usuario();
                cli.setUserName("cliente");
                cli.setPassword(encoder.encode("cli123"));
                cli.setRol(cliRol);
                usuarioRepository.save(cli);
                System.out.println("✅ Usuario CLIENTE creado");
            }
        };
    }
}
