package co.edu.iudigital.helpmeiud.services;

import co.edu.iudigital.helpmeiud.models.Usuario;

public interface IUsuarioService {

    // Crear un usuario
    Usuario crearUsuario(Usuario usuario);

    // Obtener usuario por id
    Usuario obtenerUsuarioPorId(Long id);

    // Actualizar usuario
    Usuario actualizarUsuario(Long id, Usuario usuario);

    // Borrar usuario
    void borrarUsuario(Long id);
}
