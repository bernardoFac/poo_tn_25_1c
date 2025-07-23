// src/main/java/ar/edu/uade/vista/ConsultaLineaGUI.java
package ar.edu.UADE.vista;

import ar.edu.UADE.controlador.LineaController;
import ar.edu.UADE.dto.LineaDTO;
import ar.edu.UADE.excepciones.LineaException;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.stream.Collectors;


public class ConsultaLineaGUI extends JFrame {
    private final JTextField lineaField;
    private final JButton consultarBtn;
    private final JTable table;
    private final LineaController controller;

    public ConsultaLineaGUI(LineaController controller) {
        super("Consulta de Línea de Subte");
        this.controller = controller;

        // Panel superior: input + botón
        JPanel top = new JPanel();
        top.add(new JLabel("Nombre de Línea:"));
        lineaField = new JTextField(15);
        top.add(lineaField);
        consultarBtn = new JButton("Consultar");
        top.add(consultarBtn);


        table = new JTable(new DefaultTableModel(
                new Object[]{"Línea", "Capacidad Total", "Estaciones"}, 0
        ));

        setLayout(new BorderLayout());
        add(top, BorderLayout.NORTH);
        add(new JScrollPane(table), BorderLayout.CENTER);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 300);
        setLocationRelativeTo(null);

        consultarBtn.addActionListener(e -> onConsultar());

        setVisible(true);
    }

    private void onConsultar() {
        String nombre = lineaField.getText().trim();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        try {
            LineaDTO dto = controller.consultarLinea(nombre);
            // Convertir lista de estaciones a cadena
            String estacionesStr = dto.getEstaciones().stream()
                    .collect(Collectors.joining(", "));
            model.addRow(new Object[]{
                    dto.getNombre(),
                    dto.getCapacidadTotal(),
                    estacionesStr
            });
        } catch (LineaException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error al consultar línea",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }
}

