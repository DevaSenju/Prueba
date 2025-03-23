package prueba.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import prueba.model.Cancion;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/canciones")
public class CancionController {

    private List<Cancion> canciones = new ArrayList<>();

    @PostMapping
    public ResponseEntity<String> agregarCancion(@RequestBody Cancion cancion) {
        canciones.add(cancion);
        return ResponseEntity.ok("Canción guardada correctamente");
    }

    @GetMapping
    public List<Cancion> obtenerCanciones() {
        return canciones;
    }
}
