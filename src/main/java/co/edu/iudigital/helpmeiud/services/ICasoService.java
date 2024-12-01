package co.edu.iudigital.helpmeiud.services;

import co.edu.iudigital.helpmeiud.models.Caso;

import java.util.List;

public interface ICasoService {

    // Reportar o registrar un caso
    Caso reportarCaso(Caso caso);

    // Consultar un caso por id
    Caso consultarCasoPorId(Long id);

    // Consultar todos los casos visibles
    List<Caso> consultarCasosVisibles();

    // Consultar todos los casos
    List<Caso> consultarTodosLosCasos();

    // Inhabilitar un caso
    Caso inhabilitarCaso(Long id);
}
