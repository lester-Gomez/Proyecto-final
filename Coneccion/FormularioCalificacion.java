//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Coneccion;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormularioCalificacion {
    public FormularioCalificacion() {
    }

    public static void mostrarFormulario() {
        JTextField idInscripcionField = new JTextField(10);
        JTextField calificacionField = new JTextField(10);
        JTextField fechaCalificacionField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("ID de la Inscripción:"));
        myPanel.add(idInscripcionField);
        myPanel.add(new JLabel("Calificación:"));
        myPanel.add(calificacionField);
        myPanel.add(new JLabel("Fecha de Calificación:"));
        myPanel.add(fechaCalificacionField);
        int result = JOptionPane.showConfirmDialog((Component)null, myPanel, "Por favor ingrese los datos de la Calificación", 2);
        if (result == 0) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCalificacion(Integer.parseInt(idInscripcionField.getText()), Double.parseDouble(calificacionField.getText()), fechaCalificacionField.getText());
        }

    }
}
