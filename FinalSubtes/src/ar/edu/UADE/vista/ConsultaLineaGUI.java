package ar.edu.UADE.vista;

import javax.swing.*;
import java.awt.*;

import ar.edu.UADE.controladores.SubteController;
import ar.edu.UADE.controladores.SubteController.DatosLinea;
import ar.edu.UADE.excepciones.LineaException;

public class ConsultaLineaGUI extends JFrame {

    private final JTextField txtBuscar  = new JTextField(15);
    private final JLabel lblNombre      = new JLabel("―");
    private final JLabel lblCapacidad   = new JLabel("―");
    private final DefaultListModel<String> modeloLista = new DefaultListModel<>();
    private final JList<String> lstEstaciones = new JList<>(modeloLista);

    private final SubteController controller;

    public ConsultaLineaGUI(SubteController controller) {
        super("Consulta de Línea de Subte");
        this.controller = controller;           // inyección del único controlador
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(480, 360);
        setLocationRelativeTo(null);
        construirUI();
    }

    private void construirUI() {
        /* Panel de búsqueda */
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        top.add(new JLabel("Nombre Línea:"));
        top.add(txtBuscar);
        JButton btnBuscar = new JButton("Buscar");
        top.add(btnBuscar);

        /* Datos */
        JPanel centro = new JPanel(new GridLayout(2, 2, 6, 6));
        centro.add(new JLabel("Línea:"));
        centro.add(lblNombre);
        centro.add(new JLabel("Capacidad total:"));
        centro.add(lblCapacidad);

        JScrollPane scroll = new JScrollPane(lstEstaciones);
        scroll.setBorder(BorderFactory.createTitledBorder("Estaciones"));

        add(top,    BorderLayout.NORTH);
        add(centro, BorderLayout.CENTER);
        add(scroll, BorderLayout.SOUTH);

        btnBuscar.addActionListener(e -> buscar());
    }

    private void buscar() {
        String nombre = txtBuscar.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de línea.",
                    "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            DatosLinea dto = controller.consultarLinea(nombre);
            lblNombre.setText(dto.nombre());
            lblCapacidad.setText(String.valueOf(dto.capacidadTotal()));
            modeloLista.clear();
            dto.estaciones().forEach(modeloLista::addElement);
        } catch (LineaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(),
                    "Línea no encontrada", JOptionPane.ERROR_MESSAGE);
            limpiar();
        }
    }

    private void limpiar() {
        lblNombre.setText("―");
        lblCapacidad.setText("―");
        modeloLista.clear();
    }
}
