package com.proyecto.MarketDelivery.service;

import com.proyecto.MarketDelivery.model.Usuario;
import com.proyecto.MarketDelivery.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        return usuarioRepository.findById(id).orElse(null);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuarioActualizado) {
        Usuario usuario = usuarioRepository.findById(id).orElse(null);
        if (usuario == null) return null;

        usuario.setUserName(usuarioActualizado.getUserName());
        usuario.setPassword(usuarioActualizado.getPassword());
        usuario.setNombre1(usuarioActualizado.getNombre1());
        usuario.setNombre2(usuarioActualizado.getNombre2());
        usuario.setApellido1(usuarioActualizado.getApellido1());
        usuario.setApellido2(usuarioActualizado.getApellido2());
        usuario.setCedula(usuarioActualizado.getCedula());
        usuario.setEmail(usuarioActualizado.getEmail());
        usuario.setDireccion(usuarioActualizado.getDireccion());
        usuario.setRol(usuarioActualizado.getRol());
        usuario.setCarrito(usuarioActualizado.getCarrito());
        usuario.setEmprendimiento(usuarioActualizado.getEmprendimiento());

        return usuarioRepository.save(usuario);
    }

    @Override
    public void eliminarUsuario(Long id) {
        usuarioRepository.deleteById(id);
    }
}
