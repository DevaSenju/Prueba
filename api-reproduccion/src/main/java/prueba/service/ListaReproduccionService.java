package prueba.service;

import org.springframework.stereotype.Service;
import prueba.model.ListaReproduccion;
import prueba.repository.ListaReproduccionRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ListaReproduccionService {
    private final ListaReproduccionRepository listaRepository;

    public ListaReproduccionService(ListaReproduccionRepository listaRepository) {
        this.listaRepository = listaRepository;
    }

    public List<ListaReproduccion> obtenerListas() {
        return listaRepository.findAll();
    }

    public Optional<ListaReproduccion> obtenerListaPorNombre(String nombre) {
        return listaRepository.findById(nombre);
    }

    public ListaReproduccion guardarLista(ListaReproduccion lista) {
        return listaRepository.save(lista);
    }

    public void eliminarLista(String nombre) {
        listaRepository.deleteById(nombre);
    }
}
