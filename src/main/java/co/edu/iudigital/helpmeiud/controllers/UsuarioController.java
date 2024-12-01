package co.edu.iudigital.helpmeiud.controllers;

import co.edu.iudigital.helpmeiud.dtos.requests.UsuarioRequestDTO.UsuarioRequestDTO;
import co.edu.iudigital.helpmeiud.models.Usuario;
import co.edu.iudigital.helpmeiud.services.IUsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    private IUsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> crearUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO) {
        // Convertir el DTO a la entidad Usuario
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDTO.getUsername());
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellidos(usuarioRequestDTO.getApellidos());
        usuario.setPassword(usuarioRequestDTO.getPassword());
        usuario.setFechaNacimiento(usuarioRequestDTO.getFechaNacimiento());
        usuario.setEnabled(usuarioRequestDTO.getEnabled());
        usuario.setImage(usuarioRequestDTO.getImage());

        // Asumir que los roles se asignan por sus IDs
        // List<Role> roles = roleService.obtenerRolesPorIds(usuarioRequestDTO.getRoles());
        // usuario.setRoles(roles);

        Usuario usuarioResponse = usuarioService.crearUsuario(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> consultarUsuarioPorId(@PathVariable Long id) {
        Usuario usuario = usuarioService.obtenerUsuarioPorId(id);
        return ResponseEntity.ok(usuario);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Usuario> actualizarUsuario(@RequestBody UsuarioRequestDTO usuarioRequestDTO, @PathVariable Long id) {
        Usuario usuario = new Usuario();
        usuario.setUsername(usuarioRequestDTO.getUsername());
        usuario.setNombre(usuarioRequestDTO.getNombre());
        usuario.setApellidos(usuarioRequestDTO.getApellidos());
        usuario.setPassword(usuarioRequestDTO.getPassword());
        usuario.setFechaNacimiento(usuarioRequestDTO.getFechaNacimiento());
        usuario.setEnabled(usuarioRequestDTO.getEnabled());
        usuario.setImage(usuarioRequestDTO.getImage());

        // Asignación de roles por sus IDs
        // List<Role> roles = roleService.obtenerRolesPorIds(usuarioRequestDTO.getRoles());
        // usuario.setRoles(roles);

        Usuario usuarioResponse = usuarioService.actualizarUsuario(id, usuario);
        return ResponseEntity.status(HttpStatus.OK).body(usuarioResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> borrarUsuario(@PathVariable Long id) {
        usuarioService.borrarUsuario(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
