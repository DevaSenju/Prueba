package prueba.service;

import org.springframework.stereotype.Service;
import prueba.model.Cancion;
import prueba.repository.CancionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CancionService {
    private final CancionRepository cancionRepository;

    public CancionService(CancionRepository cancionRepository) {
        this.cancionRepository = cancionRepository;
    }

    public List<Cancion> obtenerTodasLasCanciones() {
        return cancionRepository.findAll();
    }

    public Optional<Cancion> obtenerCancionPorId(Long id) {
        return cancionRepository.findById(id);
    }

    public Cancion guardarCancion(Cancion cancion) {
        return cancionRepository.save(cancion);
    }

    public void eliminarCancion(Long id) {
        cancionRepository.deleteById(id);
    }
}
