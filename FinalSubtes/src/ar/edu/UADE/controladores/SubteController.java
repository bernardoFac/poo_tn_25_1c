package ar.edu.UADE.controladores;

import java.util.List;
import java.util.stream.Collectors;

import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.modelo.*;

public class SubteController {

    public static record DatosLinea(String nombre,
                                    int capacidadTotal,
                                    List<String> estaciones) {}

    private final SistemaSubte sistema = SistemaSubte.getInstance();   // modelo

    public DatosLinea consultarLinea(String nombre) throws LineaException {
        LineaSubte linea = sistema.obtenerLinea(nombre);          // wrapper público
        return new DatosLinea(
                linea.getNombre(),
                linea.getCapacidadTotal(),
                linea.getEstaciones()
                        .stream()
                        .map(Estacion::getNombre)
                        .collect(Collectors.toList()));
    }
}
