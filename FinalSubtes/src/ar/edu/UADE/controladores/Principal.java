package ar.edu.UADE.controladores;

import javax.swing.SwingUtilities;

import ar.edu.UADE.excepciones.EstacionException;
import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.modelo.SistemaSubte;
import ar.edu.UADE.vista.ConsultaLineaGUI;

public class Principal {

	public static void main(String[] args) {
		cargarDatosDemo();

		SwingUtilities.invokeLater(() -> {
			SubteController controller = new SubteController();
			new ConsultaLineaGUI(controller).setVisible(true);
		});
	}

	private static void cargarDatosDemo() {
		SistemaSubte subtes = SistemaSubte.getInstance();
		subtes.crearLineaSubte("Linea D");
		subtes.crearLineaSubte("Linea H");
		subtes.crearEstacion("Catedral", 90);
		subtes.crearEstacion("Santa Fe", 100);
		subtes.crearEstacion("Congreso", 110);
		subtes.crearEstacion("Plaza de Mayo", 120);

		try {
			for (int i = 0; i < 3; i++) subtes.agregarVagonAleman("Linea D");
			for (int i = 0; i < 3; i++) subtes.agregarVagonArgentino("Linea H");

			subtes.agregarEstacionLinea("Plaza de Mayo", "Linea D");
			subtes.agregarEstacionLinea("Congreso",      "Linea D");
			subtes.agregarEstacionLinea("Santa Fe",      "Linea D");
			subtes.agregarEstacionLinea("Catedral",      "Linea D");
			subtes.agregarEstacionLinea("Santa Fe",      "Linea H");

			/* extras de prueba */
			subtes.agregarVagonArgentino("Linea D");
			subtes.crearEstacion("Puerto Madero", 50);
			subtes.agregarEstacionLinea("Puerto Madero", "Linea D");

		} catch (EstacionException | LineaException e) {
			e.printStackTrace();
		}
	}
}