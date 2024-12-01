package co.edu.iudigital.helpmeiud.controllers;

import co.edu.iudigital.helpmeiud.models.Delito;
import co.edu.iudigital.helpmeiud.services.IDelitoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delitos")
public class DelitoController {

    @Autowired
    private IDelitoService delitoService;

    @PostMapping
    public ResponseEntity<Delito> guardarDelito(@RequestBody Delito delito) { //TODO: USAR DTOS
        Delito delitoResponse = delitoService.crearDelito(delito);
        return ResponseEntity.status(HttpStatus.CREATED).body(delitoResponse);
    }

    @GetMapping
    public ResponseEntity<List<Delito>> consultarTodos() { //TODO: USAR DTOS
        List<Delito> delito = delitoService.obtenerDelito();
        return ResponseEntity.ok(delito);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Delito> consultarPorId(@PathVariable Long id) { //TODO: USAR DTOS
        Delito delito = delitoService.obtenerDelitoPorID(id);
        return ResponseEntity.ok(delito);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Delito> actualizarPorId(@RequestBody Delito delito, @PathVariable Long id) { //TODO: USAR DTOS
        Delito delitoBD = delitoService.actualizarDelitoPorId(id, delito);
        return ResponseEntity.status(HttpStatus.CREATED).body(delitoBD);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Delito> borrarPorId(@PathVariable Long id) {
        delitoService.borrarDelitoPorId(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    }

}
