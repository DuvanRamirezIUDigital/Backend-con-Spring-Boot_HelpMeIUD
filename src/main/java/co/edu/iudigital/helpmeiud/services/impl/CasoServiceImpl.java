package co.edu.iudigital.helpmeiud.services.impl;

import co.edu.iudigital.helpmeiud.models.Caso;
import co.edu.iudigital.helpmeiud.repositories.ICasoRepository;
import co.edu.iudigital.helpmeiud.services.ICasoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CasoServiceImpl implements ICasoService {

    @Autowired
    private ICasoRepository casoRepository;

    @Override
    public Caso reportarCaso(Caso caso) {
        // Validar y procesar el caso antes de guardarlo
        return casoRepository.save(caso);
    }

    @Override
    public Caso consultarCasoPorId(Long id) {
        Optional<Caso> casoOpt = casoRepository.findById(id);
        return casoOpt.orElseThrow(() -> new RuntimeException("Caso no encontrado"));
    }

    @Override
    public List<Caso> consultarCasosVisibles() {
        // Consultar casos con isVisible = true
        return casoRepository.findByIsVisible(true);
    }

    @Override
    public List<Caso> consultarTodosLosCasos() {
        // Consultar todos los casos
        return casoRepository.findAll();
    }

    @Override
    public Caso inhabilitarCaso(Long id) {
        Caso caso = consultarCasoPorId(id);
        caso.setIsVisible(false);
        return casoRepository.save(caso);
    }
}
