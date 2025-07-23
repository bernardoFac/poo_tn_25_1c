
package ar.edu.UADE.dto;

import java.util.List;


public class LineaDTO {
    private final String nombre;
    private final int capacidadTotal;
    private final List<String> estaciones;

    public LineaDTO(String nombre, int capacidadTotal, List<String> estaciones) {
        this.nombre = nombre;
        this.capacidadTotal = capacidadTotal;
        this.estaciones = estaciones;
    }

    public String getNombre() {
        return nombre;
    }

    public int getCapacidadTotal() {
        return capacidadTotal;
    }

    public List<String> getEstaciones() {
        return estaciones;
    }
}
