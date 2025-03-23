package prueba.service; // "service" es un subpaquete de "prueba"

import org.springframework.stereotype.Service;

@Service
public class service {
    public String getMessage() {
        return "Mensaje desde el servicio";
    }
}