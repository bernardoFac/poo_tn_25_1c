// src/main/java/ar/edu/UADE/controlador/LineaController.java
package ar.edu.UADE.controlador;

import ar.edu.UADE.dto.LineaDTO;
import ar.edu.UADE.modelo.LineaSubte;
import ar.edu.UADE.modelo.SistemaSubte;
import ar.edu.UADE.modelo.Estacion;
import ar.edu.UADE.excepciones.LineaException;

import java.util.List;
import java.util.stream.Collectors;

public class LineaController {
	private final SistemaSubte fachada;

	public LineaController() {
		this.fachada = SistemaSubte.getInstance();
	}


	public LineaDTO consultarLinea(String nombreLinea) throws LineaException {
		LineaSubte linea = fachada.obtenerLinea(nombreLinea);  // :contentReference[oaicite:0]{index=0}
		int capacidad   = linea.getCapacidadTotal();           // :contentReference[oaicite:1]{index=1}
		List<String> estaciones = linea.getEstaciones().stream()
				.map(Estacion::getNombre)                          // :contentReference[oaicite:2]{index=2}
				.collect(Collectors.toList());
		return new LineaDTO(linea.getNombre(), capacidad, estaciones);
	}
}
