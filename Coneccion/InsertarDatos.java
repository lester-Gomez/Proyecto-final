//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package Coneccion;

import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class InsertarDatos {
    private Coneccion conexion = new Coneccion();

    public InsertarDatos() {
    }

    public void insertarAlumno(String nombre, String apellido, String fechaNacimiento, String direccion, String telefono, String email) {
        this.insertarDatos("alumno", "nombre, apellido, fecha_nacimiento, direccion, telefono, email", "?, ?, ?, ?, ?, ?", nombre, apellido, fechaNacimiento, direccion, telefono, email);
    }

    public void insertarCurso(String nombreCurso, String descripcion, int creditos) {
        this.insertarDatos("cursos", "nombre_curso, descripcion, creditos", "?, ?, ?", nombreCurso, descripcion, creditos);
    }

    public void insertarCatedratico(String nombre, String apellido, String especialidad, String email, String telefono, String fechaContratacion) {
        this.insertarDatos("catedraticos", "nombre, apellido, especialidad, email, telefono, fecha_contratacion", "?, ?, ?, ?, ?, ?", nombre, apellido, especialidad, email, telefono, fechaContratacion);
    }

    public void insertarAsignacionCursoCatedratico(int idCurso, int idCatedratico, String semestre, int ano) {
        this.insertarDatos("asignacion_cursos_catedraticos", "id_curso, id_catedratico, semestre, ano", "?, ?, ?, ?", idCurso, idCatedratico, semestre, ano);
    }

    public void insertarInscripcion(int idAlumno, int idAsignacion) {
        this.insertarDatos("inscripciones", "id_alumno, id_asignacion", "?, ?", idAlumno, idAsignacion);
    }

    public void insertarCalificacion(int idInscripcion, double calificacion, String fechaCalificacion) {
        this.insertarDatos("calificaciones", "id_inscripcion, calificacion, fecha_calificacion", "?, ?, ?", idInscripcion, calificacion, fechaCalificacion);
    }

    private void insertarDatos(String tabla, String columnas, String placeholders, Object... valores) {
        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = this.conexion.conector();
            if (conn != null) {
                String sql = "INSERT INTO " + tabla + " (" + columnas + ") VALUES (" + placeholders + ")";
                statement = conn.prepareStatement(sql);

                int filasInsertadas;
                for(filasInsertadas = 0; filasInsertadas < valores.length; ++filasInsertadas) {
                    statement.setObject(filasInsertadas + 1, valores[filasInsertadas]);
                }

                filasInsertadas = statement.executeUpdate();
                if (filasInsertadas > 0) {
                    JOptionPane.showMessageDialog((Component)null, "Datos insertados exitosamente en " + tabla + "!");
                }
            } else {
                JOptionPane.showMessageDialog((Component)null, "Error en la conexión a la base de datos.");
            }
        } catch (SQLException var17) {
            var17.printStackTrace();
            JOptionPane.showMessageDialog((Component)null, "Error al insertar los datos en " + tabla + ": " + var17.getMessage());
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }

                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException var16) {
                var16.printStackTrace();
            }

        }

    }
}
