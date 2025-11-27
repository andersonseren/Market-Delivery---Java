package com.proyecto.MarketDelivery.controller;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import com.proyecto.MarketDelivery.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;
import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository repo;

    @Autowired
    private UsuarioService usuarioService;

    // -----------------------------
    //  RUTAS DE AUTENTICACIÓN BÁSICA
    // -----------------------------
    @GetMapping("/")
    public String redireccionRaiz() {
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model, Authentication auth) {
        model.addAttribute("rol", auth.getAuthorities().toString());
        return "home";
    }

    // -----------------------------
    // CRUD USUARIOS (VISTAS THYMELEAF)
    // -----------------------------
    @GetMapping("/usuarios")
    public String listar(Model model) {
        model.addAttribute("usuarios", repo.findAll());
        return "usuarios";
    }

    @GetMapping("/usuarios/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "form";
    }

    @PostMapping("/usuarios/guardar")
    public String guardar(@ModelAttribute Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        repo.save(usuario);
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        model.addAttribute("usuario", repo.findById(id).orElseThrow());
        return "form";
    }

    @GetMapping("/usuarios/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        repo.deleteById(id);
        return "redirect:/usuarios";
    }

    // -----------------------------
    // PERFIL DE USUARIO AUTENTICADO
    // -----------------------------
    @GetMapping("/perfil")
    public String perfil(Model model, Authentication auth) {
        String username = auth.getName();
        Usuario usuario = repo.findByUserName(username).orElseThrow();
        model.addAttribute("usuario", usuario);
        return "form";
    }

    @PostMapping("/perfil/guardar")
    public String guardarPerfil(@ModelAttribute Usuario usuario, Authentication auth) {
        String username = auth.getName();
        Usuario actual = repo.findByUserName(username).orElseThrow();
        actual.setUserName(usuario.getUserName());
        actual.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        repo.save(actual);
        return "redirect:/home?actualizado";
    }

    // -----------------------------
    // DASHBOARDS POR ROL
    // -----------------------------
    @GetMapping("/admin/dashboard")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public String adminDashboard() {
        return "admin-dashboard";
    }

    @GetMapping("/emprendedor/dashboard")
    @PreAuthorize("hasRole('EMPRENDEDOR')")
    public String emprendedorDashboard() {
        return "emprendedor-dashboard";
    }

    @GetMapping("/cliente/dashboard")
    @PreAuthorize("hasRole('CLIENTE')")
    public String clienteDashboard() {
        return "cliente-dashboard";
    }

    // -----------------------------
    // ENDPOINTS REST PARA API (ADMIN)
    // -----------------------------
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/api/usuarios")
    @ResponseBody
    public List<Usuario> listarUsuarios() {
        return usuarioService.listarUsuarios();
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @GetMapping("/api/usuarios/{id}")
    @ResponseBody
    public Usuario obtenerUsuario(@PathVariable Long id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PostMapping("/api/usuarios")
    @ResponseBody
    public Usuario guardarUsuario(@RequestBody Usuario usuario) {
        usuario.setPassword(new BCryptPasswordEncoder().encode(usuario.getPassword()));
        return usuarioService.guardarUsuario(usuario);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @PutMapping("/api/usuarios/{id}")
    @ResponseBody
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        return usuarioService.actualizarUsuario(id, usuario);
    }

    @PreAuthorize("hasRole('ADMINISTRADOR')")
    @DeleteMapping("/api/usuarios/{id}")
    @ResponseBody
    public void eliminarUsuario(@PathVariable Long id) {
        usuarioService.eliminarUsuario(id);
    }
}
