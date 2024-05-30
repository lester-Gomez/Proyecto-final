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

public class FormularioCatedratico {
    public FormularioCatedratico() {
    }

    public static void mostrarFormulario() {
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField especialidadField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JTextField telefonoField = new JTextField(10);
        JTextField fechaContratacionField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 2));
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Apellido:"));
        myPanel.add(apellidoField);
        myPanel.add(new JLabel("Especialidad:"));
        myPanel.add(especialidadField);
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);
        myPanel.add(new JLabel("Teléfono:"));
        myPanel.add(telefonoField);
        myPanel.add(new JLabel("Fecha de Contratación:"));
        myPanel.add(fechaContratacionField);
        int result = JOptionPane.showConfirmDialog((Component)null, myPanel, "Por favor ingrese los datos del Catedrático", 2);
        if (result == 0) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCatedratico(nombreField.getText(), apellidoField.getText(), especialidadField.getText(), emailField.getText(), telefonoField.getText(), fechaContratacionField.getText());
        }

    }
}
