package co.edu.iudigital.helpmeiud.dtos.requests.CasoRequestDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CasoRequestDTO {

    private LocalDateTime fechaHora;
    private Float latitud;
    private Float longitud;
    private Float altitud;
    private Boolean isVisible;
    private String detalle;
    private String urlMap;
    private String rmiMap;
    private Long delitoId; // El ID del delito asociado al caso
    private Long usuarioId; // El ID del usuario asociado al caso
}
