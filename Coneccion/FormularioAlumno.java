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

public class FormularioAlumno {
    public FormularioAlumno() {
    }

    public static void mostrarFormulario() {
        JTextField nombreField = new JTextField(10);
        JTextField apellidoField = new JTextField(10);
        JTextField fechaNacimientoField = new JTextField(10);
        JTextField direccionField = new JTextField(10);
        JTextField telefonoField = new JTextField(10);
        JTextField emailField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(6, 2));
        myPanel.add(new JLabel("Nombre:"));
        myPanel.add(nombreField);
        myPanel.add(new JLabel("Apellido:"));
        myPanel.add(apellidoField);
        myPanel.add(new JLabel("Fecha de Nacimiento:"));
        myPanel.add(fechaNacimientoField);
        myPanel.add(new JLabel("Dirección:"));
        myPanel.add(direccionField);
        myPanel.add(new JLabel("Teléfono:"));
        myPanel.add(telefonoField);
        myPanel.add(new JLabel("Email:"));
        myPanel.add(emailField);
        int result = JOptionPane.showConfirmDialog((Component)null, myPanel, "Por favor ingrese los datos del Alumno", 2);
        if (result == 0) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarAlumno(nombreField.getText(), apellidoField.getText(), fechaNacimientoField.getText(), direccionField.getText(), telefonoField.getText(), emailField.getText());
        }

    }
}
