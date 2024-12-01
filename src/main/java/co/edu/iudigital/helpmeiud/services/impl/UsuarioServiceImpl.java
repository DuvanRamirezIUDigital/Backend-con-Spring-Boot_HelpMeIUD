package co.edu.iudigital.helpmeiud.services.impl;

import co.edu.iudigital.helpmeiud.models.Usuario;
import co.edu.iudigital.helpmeiud.repositories.IUsuarioRepository;
import co.edu.iudigital.helpmeiud.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

    @Autowired
    private IUsuarioRepository usuarioRepository;

    @Override
    public Usuario crearUsuario(Usuario usuario) {
        // Lógica adicional de validación si es necesario
        return usuarioRepository.save(usuario);
    }

    @Override
    public Usuario obtenerUsuarioPorId(Long id) {
        // Lógica para obtener el usuario por ID
        return usuarioRepository.findById(id).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    @Override
    public Usuario actualizarUsuario(Long id, Usuario usuario) {
        // Buscar el usuario actual en la base de datos
        Usuario usuarioExistente = usuarioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        // Actualizar los datos del usuario con los valores proporcionados
        usuarioExistente.setUsername(usuario.getUsername() != null ? usuario.getUsername() : usuarioExistente.getUsername());
        usuarioExistente.setNombre(usuario.getNombre() != null ? usuario.getNombre() : usuarioExistente.getNombre());
        usuarioExistente.setApellidos(usuario.getApellidos() != null ? usuario.getApellidos() : usuarioExistente.getApellidos());
        usuarioExistente.setPassword(usuario.getPassword() != null ? usuario.getPassword() : usuarioExistente.getPassword());
        usuarioExistente.setFechaNacimiento(usuario.getFechaNacimiento() != null ? usuario.getFechaNacimiento() : usuarioExistente.getFechaNacimiento());
        usuarioExistente.setEnabled(usuario.getEnabled() != null ? usuario.getEnabled() : usuarioExistente.getEnabled());
        usuarioExistente.setImage(usuario.getImage() != null ? usuario.getImage() : usuarioExistente.getImage());

        // Guardar el usuario actualizado
        return usuarioRepository.save(usuarioExistente);
    }

    @Override
    public void borrarUsuario(Long id) {
        // Buscar y eliminar el usuario por ID
        usuarioRepository.deleteById(id);
    }
}
