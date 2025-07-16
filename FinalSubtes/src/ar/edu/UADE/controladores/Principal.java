package ar.edu.UADE.controladores;

import javax.swing.SwingUtilities;

import ar.edu.UADE.excepciones.EstacionException;
import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.modelo.SistemaSubte;
import ar.edu.UADE.vista.ConsultaLineaGUI;

public class Principal {

	public static void main(String[] args) {
		cargarDatosDemo();                                   // modelo
		SwingUtilities.invokeLater(                          // vista
				() -> new ConsultaLineaGUI().setVisible(true)
		);
	}

	private static void cargarDatosDemo() {
		SistemaSubte subtes = SistemaSubte.getInstance();

		subtes.crearLineaSubte("Linea D");
		subtes.crearLineaSubte("Linea H");
		subtes.crearEstacion("Catedral",     90);
		subtes.crearEstacion("Santa Fe",    100);
		subtes.crearEstacion("Congreso",    110);
		subtes.crearEstacion("Plaza de Mayo", 120);

		try {
			// Vagones demo
			for (int i = 0; i < 3; i++) subtes.agregarVagonAleman("Linea D");
			for (int i = 0; i < 3; i++) subtes.agregarVagonArgentino("Linea H");

			// Estaciones en líneas
			subtes.agregarEstacionLinea("Plaza de Mayo", "Linea D");
			subtes.agregarEstacionLinea("Congreso",      "Linea D");
			subtes.agregarEstacionLinea("Santa Fe",      "Linea D");
			subtes.agregarEstacionLinea("Catedral",      "Linea D");
			subtes.agregarEstacionLinea("Santa Fe",      "Linea H");

			// Extras
			subtes.agregarVagonArgentino("Linea D");
			subtes.crearEstacion("Puerto Madero", 50);
			subtes.agregarEstacionLinea("Puerto Madero", "Linea D");

		} catch (EstacionException | LineaException e) {
			e.printStackTrace();
		}
	}
}
