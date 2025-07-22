package ar.edu.UADE.controladores;

import ar.edu.UADE.modelo.*;
import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.vista.ConsultaLineaGUI;

import javax.swing.SwingUtilities;
import java.util.List;
import java.util.stream.Collectors;


public class Principal {

	public static class DatosLinea {
		private final String nombre;
		private final int capacidadTotal;
		private final List<String> estaciones;
		public DatosLinea(String nombre, int capacidadTotal, List<String> estaciones) {
			this.nombre = nombre;
			this.capacidadTotal = capacidadTotal;
			this.estaciones = estaciones;
		}
		public String getNombre() { return nombre; }
		public int getCapacidadTotal() { return capacidadTotal; }
		public List<String> getEstaciones() { return estaciones; }
	}
	private final SistemaSubte sistema; // fachada (Modelo)

	public Principal(SistemaSubte sistema) {
		this.sistema = sistema;
	}

	public DatosLinea consultarLinea(String nombreLinea) throws LineaException {
		LineaSubte linea = sistema.obtenerLinea(nombreLinea);
		int capacidad   = linea.getCapacidadTotal();
		List<String> estaciones = linea.getEstaciones().stream()
				.map(Estacion::getNombre)
				.collect(Collectors.toList());
		return new DatosLinea(linea.getNombre(), capacidad, estaciones);
	}

	public static void main(String[] args) {
		SistemaSubte sistema = SistemaSubte.getInstance();
		cargarDatosDemo(sistema);
		Principal controlador = new Principal(sistema);
		SwingUtilities.invokeLater(() -> new ConsultaLineaGUI(controlador).setVisible(true));
	}

	private static void cargarDatosDemo(SistemaSubte s) {
		s.crearLineaSubte("Linea D");
		s.crearLineaSubte("Linea H");
		s.crearEstacion("Catedral",       90);
		s.crearEstacion("Santa Fe",      100);
		s.crearEstacion("Congreso",      110);
		s.crearEstacion("Plaza de Mayo", 120);
		try {
			for (int i = 0; i < 3; i++) s.agregarVagonAleman("Linea D");
			s.agregarVagonArgentino("Linea H");
			s.agregarEstacionLinea("Plaza de Mayo", "Linea D");
			s.agregarEstacionLinea("Congreso",      "Linea D");
			s.agregarEstacionLinea("Santa Fe",      "Linea D");
			s.agregarEstacionLinea("Catedral",      "Linea D");
			s.agregarEstacionLinea("Santa Fe",      "Linea H");
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}