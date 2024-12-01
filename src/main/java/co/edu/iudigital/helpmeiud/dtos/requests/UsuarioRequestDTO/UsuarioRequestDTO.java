package co.edu.iudigital.helpmeiud.dtos.requests.UsuarioRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioRequestDTO {

    private String username;
    private String nombre;
    private String apellidos;
    private String password;
    private LocalDate fechaNacimiento;
    private Boolean enabled;
    private String image;
    private Long[] roles; // IDs de los roles asociados al usuario
}

