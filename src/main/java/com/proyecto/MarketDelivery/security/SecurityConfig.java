package com.proyecto.MarketDelivery.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                // Recursos públicos
                .requestMatchers("/login", "/css/**", "/js/**", "/img/**").permitAll()

                // Endpoints protegidos por rol
                .requestMatchers("/admin/**").hasRole("ADMINISTRADOR")
                .requestMatchers("/emprendedor/**").hasRole("EMPRENDEDOR")
                .requestMatchers("/cliente/**").hasRole("CLIENTE")

                // Cualquier usuario autenticado puede acceder al home y perfil
                .requestMatchers("/home", "/perfil/**").authenticated()

                // Todo lo demás requiere autenticación
                .anyRequest().authenticated()
            )

            // Formulario de login
            .formLogin(form -> form
                .loginPage("/login")                // página personalizada
                .defaultSuccessUrl("/home", true)   // redirige al home tras login
                .permitAll()
            )

            // Logout
            .logout(logout -> logout
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            )

            // Manejo de excepciones
            .exceptionHandling(exception -> exception
                .accessDeniedPage("/access-denied")
            )

            // Gestión de sesión
            .sessionManagement(session -> session
                .invalidSessionUrl("/login?expired")
                .maximumSessions(1)
                .expiredUrl("/login?expired")
            );

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
