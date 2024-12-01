package co.edu.iudigital.helpmeiud.services;

import co.edu.iudigital.helpmeiud.models.Delito;

import java.util.List;

public interface IDelitoService {

    // TODO: CAMBIAR TIPO OBJECT POR ENTETY O POR DTO Y COLOCAR EXCEPTIONS

    // crear
    Delito crearDelito(Delito delito);

    // consultar todos
    List<Delito> obtenerDelito();

    // consultar por id
    Delito obtenerDelitoPorID(Long id);

    // modificar por id
    Delito actualizarDelitoPorId(Long id, Delito delito);

    // borrar por id
    void borrarDelitoPorId(Long id);
}
