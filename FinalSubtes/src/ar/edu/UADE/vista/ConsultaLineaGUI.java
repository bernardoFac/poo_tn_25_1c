package ar.edu.UADE.vista;

import javax.swing.*;
import java.awt.*;

import ar.edu.UADE.modelo.*;
import ar.edu.UADE.excepciones.LineaException;

public class ConsultaLineaGUI extends JFrame {

    private final JTextField txtNombreLinea = new JTextField(15);
    private final JTextArea txtSalida = new JTextArea();
    private final SistemaSubte subte = SistemaSubte.getInstance();

    public ConsultaLineaGUI() {
        super("Consulta de Línea de Subte");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(450, 320);
        setLocationRelativeTo(null);
        construirUI();
    }

    private void construirUI() {
        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 8));
        top.add(new JLabel("Nombre de Línea:"));
        top.add(txtNombreLinea);
        JButton btn = new JButton("Buscar");
        top.add(btn);

        txtSalida.setEditable(false);
        txtSalida.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        add(top, BorderLayout.NORTH);
        add(new JScrollPane(txtSalida), BorderLayout.CENTER);

        btn.addActionListener(e -> consultar());
    }

    private void consultar() {
        String nombre = txtNombreLinea.getText().trim();
        if (nombre.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Ingrese un nombre de línea", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }
        try {
            LineaSubte linea = subte.obtenerLinea(nombre);
            StringBuilder sb = new StringBuilder().append("LÍNEA: ").append(linea.getNombre()).append('\n').append("CAPACIDAD TOTAL: ").append(linea.getCapacidadTotal()).append('\n').append("ESTACIONES:\n");
            for (Estacion est : linea.getEstaciones()) {
                sb.append(" • ").append(est.getNombre()).append('\n');
            }
            txtSalida.setText(sb.toString());
        } catch (LineaException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Línea no encontrada", JOptionPane.ERROR_MESSAGE);
            txtSalida.setText("");
        }
    }
}
