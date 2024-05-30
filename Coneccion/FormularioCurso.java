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

public class FormularioCurso {
    public FormularioCurso() {
    }

    public static void mostrarFormulario() {
        JTextField nombreCursoField = new JTextField(10);
        JTextField descripcionField = new JTextField(10);
        JTextField creditosField = new JTextField(10);
        JPanel myPanel = new JPanel();
        myPanel.setLayout(new GridLayout(3, 2));
        myPanel.add(new JLabel("Nombre del Curso:"));
        myPanel.add(nombreCursoField);
        myPanel.add(new JLabel("Descripción:"));
        myPanel.add(descripcionField);
        myPanel.add(new JLabel("Créditos:"));
        myPanel.add(creditosField);
        int result = JOptionPane.showConfirmDialog((Component)null, myPanel, "Por favor ingrese los datos del Curso", 2);
        if (result == 0) {
            InsertarDatos insertar = new InsertarDatos();
            insertar.insertarCurso(nombreCursoField.getText(), descripcionField.getText(), Integer.parseInt(creditosField.getText()));
        }

    }
}
