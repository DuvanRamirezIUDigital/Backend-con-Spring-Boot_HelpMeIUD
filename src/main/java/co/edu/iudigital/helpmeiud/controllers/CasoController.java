package co.edu.iudigital.helpmeiud.controllers;

import co.edu.iudigital.helpmeiud.models.Caso;
import co.edu.iudigital.helpmeiud.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/casos")
public class CasoController {

    @Autowired
    private ICasoService casoService;

    // Endpoint para reportar o registrar un caso
    @PostMapping
    public ResponseEntity<Caso> reportarCaso(@RequestBody Caso caso) {
        Caso casoResponse = casoService.reportarCaso(caso);
        return ResponseEntity.status(HttpStatus.CREATED).body(casoResponse);
    }

    // Endpoint para consultar un caso por ID
    @GetMapping("/{id}")
    public ResponseEntity<Caso> consultarCasoPorId(@PathVariable Long id) {
        Caso caso = casoService.consultarCasoPorId(id);
        return ResponseEntity.ok(caso);
    }

    // Endpoint para consultar todos los casos visibles
    @GetMapping("/visibles")
    public ResponseEntity<List<Caso>> consultarCasosVisibles() {
        List<Caso> casos = casoService.consultarCasosVisibles();
        return ResponseEntity.ok(casos);
    }

    // Endpoint para consultar todos los casos
    @GetMapping
    public ResponseEntity<List<Caso>> consultarTodosLosCasos() {
        List<Caso> casos = casoService.consultarTodosLosCasos();
        return ResponseEntity.ok(casos);
    }

    // Endpoint para inhabilitar un caso
    @PutMapping("/{id}/inhabilitar")
    public ResponseEntity<Caso> inhabilitarCaso(@PathVariable Long id) {
        Caso casoInhabilitado = casoService.inhabilitarCaso(id);
        return ResponseEntity.status(HttpStatus.OK).body(casoInhabilitado);
    }
}
