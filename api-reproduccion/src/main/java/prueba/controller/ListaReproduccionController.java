package prueba.controller;

import prueba.model.ListaReproduccion;
import prueba.service.ListaReproduccionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/lists")
public class ListaReproduccionController {
    private final ListaReproduccionService listaService;

    public ListaReproduccionController(ListaReproduccionService listaService) {
        this.listaService = listaService;
    }

    @GetMapping
    public List<ListaReproduccion> obtenerListas() {
        return listaService.obtenerListas();
    }

    @PostMapping
    public ResponseEntity<ListaReproduccion> agregarLista(@RequestBody ListaReproduccion lista) {
        return ResponseEntity.ok(listaService.guardarLista(lista));
    }

    @DeleteMapping("/{nombre}")
    public ResponseEntity<Void> eliminarLista(@PathVariable String nombre) {
        listaService.eliminarLista(nombre);
        return ResponseEntity.noContent().build();
    }
}
