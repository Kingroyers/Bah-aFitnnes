package Controller;

import Model.AdminModel;
import Model.Conexionbd;
import Model.PagoModel;
import Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.swing.JOptionPane;

public class AdminController {

    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    Conexionbd con = new Conexionbd();

    public AdminModel log(String user, String pass) {

        AdminModel l = new AdminModel();
        String sql = "SELECT * FROM admin WHERE Usuario_admin = ? AND Pass_admin = ?";

        try {

            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {

                l.setId_admin(rs.getInt("ID_admin"));
                l.setUsuario_admin(rs.getString("Usuario_admin"));
                l.setPass_admin(rs.getString("Pass_admin"));

            }
        } catch (SQLException e) {

            System.out.println(e.toString());
        }
        return l;
    }

    public List<PagoModel> MostrarEnTabla(String idbuscar) {

        List<PagoModel> listusuario = new ArrayList<>();
        String sql = idbuscar.isEmpty() ? "SELECT * FROM usuarios" : "SELECT * FROM usuarios WHERE Identificacion LIKE '%" + idbuscar + "%'";

        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                PagoModel pago_model = new PagoModel();

                pago_model.setIden(rs.getInt("ID_usuarios"));
                pago_model.setIdentificacion(rs.getInt("Identificacion"));
                pago_model.setNombre_usuario(rs.getString("Nombre"));
                pago_model.setApellido_usuario(rs.getString("Apellido"));
                pago_model.setCorreo_usuario(rs.getString("Correo"));
                pago_model.setTelefono(rs.getInt("Telefono"));
                pago_model.setPlan(rs.getString("Plan"));
                pago_model.setPago_usuario(rs.getBoolean("pago"));

                listusuario.add(pago_model);

            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listusuario;
    }

    public List<UsuarioModel> MostrarRegistroDiario() {

        List<UsuarioModel> listentrada = new ArrayList<>();
        String sql = "SELECT * FROM registro";

        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {

                UsuarioModel usuario_model = new UsuarioModel();

                usuario_model.setIden(rs.getInt("id"));
                usuario_model.setIdentificacion(rs.getInt("identificacion"));
                usuario_model.setHora_entrada(rs.getString("fecha"));

                listentrada.add(usuario_model);
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return listentrada;
    }

    public void RegistroDiario(String cogidoQR) {

        String sql = "INSERT INTO registro(identificacion) VALUES (?)";
        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, cogidoQR);
            ps.execute();

        } catch (SQLException e) {
            e.printStackTrace();
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
                e.printStackTrace();
            }
        }
    }

    public void EliminarRegistros() {
        int opcion = JOptionPane.showConfirmDialog(null, "¿SEGURO QUE QUIERES ELIMINAR REGISTROS?", "MESAJE DEL SISTEMA",
                JOptionPane.YES_NO_OPTION);
        if (opcion == JOptionPane.YES_OPTION) {

            String sql = "DELETE FROM registro";
            try {
                conn = con.getConnection();
                ps = conn.prepareStatement(sql);
                ps.executeUpdate();

                JOptionPane.showMessageDialog(null, "ELIMINACION EXITOSA");

            } catch (SQLException e) {
                e.printStackTrace();
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
                    e.printStackTrace();
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "lolo");
        }
    }

    public boolean ConsultaUsuario(String identificacion) {
        String sql = "SELECT * FROM usuarios WHERE Identificacion = ?";
        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, identificacion);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
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

    //NUEVO 
    public boolean VerificarEntrada(String codigoQR) {
        String verificar = "SELECT * FROM registro WHERE identificacion = ?";
        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(verificar);
            ps.setString(1, codigoQR);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
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
        return true;
    }

    public boolean VerificacionExpiracion() {

        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.format(fechaActual);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        Date FechaFinal = calendar.getTime();

        String sql = "SELECT * FROM usuarios WHERE fecha_expiracion >= ?";

        try {
            java.sql.Date sqlFechaFinal = new java.sql.Date(FechaFinal.getTime());

            conn = con.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setDate(1, sqlFechaFinal);
            rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("fecha coincide");
                return true;//si la fecha es mayor a la actual lance true

            } else {
                System.out.println("nada no hace nada");
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

    public void ExpiracionDePago() {
        Date fechaActual = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.format(fechaActual);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(fechaActual);
        Date FechaFinal = calendar.getTime();
        java.sql.Date sqlFechaFinal = new java.sql.Date(FechaFinal.getTime());

        String Expiracion = "UPDATE usuarios SET pago = ? WHERE fecha_expiracion <= ?";

        try {
            conn = con.getConnection();
            ps = conn.prepareStatement(Expiracion);
            ps.setString(1, "0");
            ps.setDate(2, sqlFechaFinal);
            ps.execute();

            if (rs.next()) {
                System.out.println("actualizacion exitosa");//se actualiza si es menor o igual
            } else {
                System.out.println("no actualiza");
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
    }
}
