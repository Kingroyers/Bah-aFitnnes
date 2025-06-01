package Controller;

import Model.Conexionbd;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Acceso extends AdminController {

    Connection conn;
    Conexionbd cn = new Conexionbd();
    PreparedStatement ps;
    ResultSet rs;

    public void ConsultarRegistro(String codigoQR) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            // asegurar de que la conexión esté establecida
            if (conn == null || conn.isClosed()) {
                conn = cn.getConnection(); // Obtener la conexión si no está activa
            }

            String sql = "SELECT * FROM usuarios WHERE Identificacion = ?";
            stmt = conn.prepareStatement(sql);
            stmt.setString(1, codigoQR);

            rs = stmt.executeQuery();

            if (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                int pago = rs.getInt("pago");

                if (VerificarPago(codigoQR) && VerificacionExpiracion()) {
                    //NUEVO
                    if (!VerificarEntrada(codigoQR)) {

                        JOptionPane.showMessageDialog(null, "\nACCESO PERMITIDO:\n " + nombre + " " + apellido,
                                "MENSAJE DEL SISTEMA", JOptionPane.INFORMATION_MESSAGE);
                        RegistroDiario(codigoQR);
                    } else {
                        JOptionPane.showMessageDialog(null, "ACCESO DENEGADO, USUARIO YA HA ENTRADO", "MESAJE DEL SISTEMA",
                                JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ACCESO DENEGADO\n ",
                            "MESAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
                }
                // HASTA ACA
            } else {

                JOptionPane.showMessageDialog(null, "USUARIO NO REGISTRADO",
                        "MENSAJE DEL SISTEMA", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Error en la base de datos: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();//identificar exacatamente donde está el error
        } finally {
            // Cerrar ResultSet y PreparedStatement
            try {
                if (rs != null) {
                    rs.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public boolean VerificarPago(String codigoQR) {
        String sql = "SELECT pago FROM usuarios WHERE Identificacion = ?";
        try {

            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, codigoQR);
            rs = ps.executeQuery();

            if (rs.next()) {
                if (rs.getString("pago").equals("1")) {
                    return true;
                }
            } else {
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {

                if (rs != null) {
                    rs.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println(e.getMessage());
            }
        }
        return false;
    }
}
