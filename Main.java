import Coneccion.*;
import java.sql.ResultSet;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static Connection conn = null;
    public static void main(String[] args) {
        JFrame frame = new JFrame("Panel de Administrador");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));

        JButton alumnoBtn = new JButton("Insertar Alumno");
        JButton cursoBtn = new JButton("Insertar Curso");
        JButton catedraticoBtn = new JButton("Insertar Catedrático");
        JButton asignacionBtn = new JButton("Insertar Asignación");
        JButton inscripcionBtn = new JButton("Insertar Inscripción");
        JButton calificacionBtn = new JButton("Insertar Calificación");

        panel.add(alumnoBtn);
        panel.add(cursoBtn);
        panel.add(catedraticoBtn);
        panel.add(asignacionBtn);
        panel.add(inscripcionBtn);
        panel.add(calificacionBtn);

        frame.add(panel);
        frame.setVisible(true);

        alumnoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioAlumno.mostrarFormulario();
            }
        });

        cursoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioCurso.mostrarFormulario();
            }
        });

        catedraticoBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioCatedratico.mostrarFormulario();
            }
        });

        asignacionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioAsignacion.mostrarFormulario();
            }
        });

        inscripcionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioInscripcion.mostrarFormulario();
            }
        });

        calificacionBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FormularioCalificacion.mostrarFormulario();
            }
        });
        Coneccion conexion = new Coneccion();
        conn = conexion.conector();
        if (conn != null) {
            System.out.println("Conexión establecida con éxito.");
            buscarAlumnos();
            buscarCatedraticos();
        } else {
            System.out.println("Error al establecer la conexión.");
        }
    }

    public static void buscarAlumnos() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM alumno");
            ResultSet rs = statement.executeQuery();
            System.out.println("Lista de Alumnos:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_alumno") + " - " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al buscar alumnos: " + ex.getMessage());
        }
    }

    public static void buscarCatedraticos() {
        try {
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM catedraticos");
            ResultSet rs = statement.executeQuery();
            System.out.println("Lista de Catedráticos:");
            while (rs.next()) {
                System.out.println(rs.getInt("id_catedratico") + " - " + rs.getString("nombre") + " " + rs.getString("apellido"));
            }
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("Error al buscar catedráticos: " + ex.getMessage());
        }
    }
}
