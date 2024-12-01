package co.edu.iudigital.helpmeiud.dtos.requests.DelitoRequestDTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class DelitoRequestDTO {

    private Long id;
    private String nombre;
    private String descripcion;

    // Constructor para crear una instancia del DTO con los datos del delito
    public DelitoRequestDTO(Long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
}
