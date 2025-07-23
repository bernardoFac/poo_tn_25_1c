package ar.edu.UADE.main;

import ar.edu.UADE.controlador.LineaController;
import ar.edu.UADE.excepciones.EstacionException;
import ar.edu.UADE.excepciones.LineaException;
import ar.edu.UADE.modelo.SistemaSubte;
import ar.edu.UADE.vista.ConsultaLineaGUI;

import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        try {
            cargarDatosDemo();
        } catch (EstacionException | LineaException ex) {
            System.err.println("Error al inicializar datos de demo: " + ex.getMessage());

        }

        SwingUtilities.invokeLater(() -> {
            LineaController controller = new LineaController();
            new ConsultaLineaGUI(controller);
        });
    }

    private static void cargarDatosDemo() throws EstacionException, LineaException {
        SistemaSubte subte = SistemaSubte.getInstance();


        subte.crearLineaSubte("Linea D");
        subte.crearLineaSubte("Linea H");


        subte.crearEstacion("Catedral",     90);
        subte.crearEstacion("Santa Fe",    100);
        subte.crearEstacion("Congreso",    110);
        subte.crearEstacion("Plaza de Mayo", 120);
        subte.crearEstacion("Corrientes",  115);
        subte.crearEstacion("Once",        105);

        
        subte.agregarEstacionLinea("Catedral",     "Linea D");
        subte.agregarEstacionLinea("Santa Fe",     "Linea D");
        subte.agregarEstacionLinea("Congreso",     "Linea D");

        subte.agregarEstacionLinea("Plaza de Mayo","Linea H");
        subte.agregarEstacionLinea("Corrientes",   "Linea H");
        subte.agregarEstacionLinea("Once",         "Linea H");
    }
}