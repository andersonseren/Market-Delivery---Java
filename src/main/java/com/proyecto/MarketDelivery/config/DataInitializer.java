package com.proyecto.MarketDelivery.config;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class DataInitializer {

    @Bean
    public CommandLineRunner initDatabase(UsuarioRepository usuarioRepository) {
        return args -> {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

            // 👑 ADMINISTRADOR
            if (usuarioRepository.findByUserName("admin").isEmpty()) {
                Usuario admin = new Usuario();
                admin.setUserName("admin");
                admin.setPassword(encoder.encode("admin123"));
                admin.setRol("ADMINISTRADOR");
                usuarioRepository.save(admin);
                System.out.println("✅ Usuario ADMINISTRADOR creado: admin / admin123");
            }

            // 💼 EMPRENDEDOR
            if (usuarioRepository.findByUserName("emprendedor").isEmpty()) {
                Usuario emp = new Usuario();
                emp.setUserName("emprendedor");
                emp.setPassword(encoder.encode("emp123"));
                emp.setRol("EMPRENDEDOR");
                usuarioRepository.save(emp);
                System.out.println("✅ Usuario EMPRENDEDOR creado: emprendedor / emp123");
            }

            // 🛒 CLIENTE
            if (usuarioRepository.findByUserName("cliente").isEmpty()) {
                Usuario cli = new Usuario();
                cli.setUserName("cliente");
                cli.setPassword(encoder.encode("cli123"));
                cli.setRol("CLIENTE");
                usuarioRepository.save(cli);
                System.out.println("✅ Usuario CLIENTE creado: cliente / cli123");
            }
        };
    }
}
