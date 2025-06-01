package Controller;

import Interfaces.CrudUsuariosInterfaces;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import Model.Conexionbd;
import Model.PagoModel;
import Model.UsuarioModel;
import java.awt.HeadlessException;

public class UsuarioController extends Conexionbd implements CrudUsuariosInterfaces {

    Connection conn;
    Conexionbd cn = new Conexionbd();
    PreparedStatement ps;
    ResultSet rs;
    Acceso acceso = new Acceso();
    UsuarioModel usuario_model = new UsuarioModel();

    public boolean validarFormulario(int identificacion, String nombre_usuario, String apellido_usuario, String correo_usuario, int telefono, String plan) {
        return !(identificacion == 0 || nombre_usuario.equals("") || apellido_usuario.equals("") || correo_usuario.equals("") || telefono == 0 || plan.equals(""));
    }

    public boolean existeUsuario(int identificacion) {
        boolean existe = false; // Por defecto, el usuario no existe
        String sql = "SELECT COUNT(*) FROM usuarios WHERE Identificacion = ?"; // Consulta SQL

        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, identificacion); // Establecer el parámetro
            rs = ps.executeQuery(); // Ejecutar la consulta

            if (rs.next()) {
                existe = rs.getInt(1) > 0; // Si el conteo es mayor que 0, el usuario existe
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return existe; // Retornar el resultado
    }

    public void ValidaryActualizarPago(String idUsuario) {
        try {
            if (acceso.ConsultaUsuario(idUsuario)) {

                if (!acceso.VerificarPago(idUsuario)) {
                    String actualizar = "UPDATE usuarios SET pago = ?  WHERE Identificacion = ?";
                    try {
                        conn = cn.getConnection();
                        ps = conn.prepareStatement(actualizar);
                        ps.setString(1, "1");
                        ps.setString(2, idUsuario);
                        ps.execute();

                        JOptionPane.showMessageDialog(null, "PAGO EXITOSO");
                    } catch (SQLException e) {
                        e.printStackTrace();

                    } finally {

                        try {
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

                    JOptionPane.showMessageDialog(null, "USUARIO ACTIVO");
                }
            } else {
                JOptionPane.showMessageDialog(null, "USUARIO NO ENCONTRADO", "MENSAJE DEL SISTEMA",
                        JOptionPane.ERROR_MESSAGE);
            }
        } catch (HeadlessException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void agregar(PagoModel usuario) {
        String sql = "INSERT INTO usuarios (Identificacion, Nombre, Apellido, Correo, Telefono, Plan, pago) VALUES(?,?,?,?,?,?,?)";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, usuario.getIdentificacion());
            ps.setString(2, usuario.getNombre_usuario());
            ps.setString(3, usuario.getApellido_usuario());
            ps.setString(4, usuario.getCorreo_usuario());
            ps.setInt(5, usuario.getTelefono());
            ps.setString(6, usuario.getPlan());
            ps.setBoolean(7, usuario.isPago_usuario());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public void modificar(PagoModel usuario) {
        String sql = "UPDATE usuarios SET Nombre = ?, Apellido = ?, Correo = ?, Telefono = ?, Plan = ?, pago = ? WHERE Identificacion = ?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNombre_usuario());
            ps.setString(2, usuario.getApellido_usuario());
            ps.setString(3, usuario.getCorreo_usuario());
            ps.setInt(4, usuario.getTelefono());
            ps.setString(5, usuario.getPlan());
            ps.setBoolean(6, usuario.isPago_usuario());
            ps.setInt(7, usuario.getIdentificacion());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
    }

    @Override
    public void eliminar(int idusuarios) {
        String sql = "DELETE FROM usuarios WHERE ID_usuarios = ?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idusuarios);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }

    }

    @Override
    public PagoModel getUserById(int idusuarios) {
        PagoModel pm = new PagoModel();
        String sql = "SELECT * FROM usuarios WHERE ID_usuarios = ? LIMIT 1";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idusuarios);
            rs = ps.executeQuery();

            while (rs.next()) {
                pm.setIden(rs.getInt("ID_usuarios"));
                pm.setIdentificacion(rs.getInt("Identificacion"));
                pm.setNombre_usuario(rs.getString("Nombre"));
                pm.setApellido_usuario(rs.getString("Apellido"));
                pm.setCorreo_usuario(rs.getString("Correo"));
                pm.setTelefono(rs.getInt("Telefono"));
                pm.setPlan(rs.getString("Plan"));
                pm.setPago_usuario(rs.getBoolean("Pago"));
            }
            rs.close();
            ps.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        } finally {
            try {
                conn.close();
            } catch (SQLException e) {
                System.out.println(e.toString());
            }
        }
        return pm;
    }

    //posible a borrar
    public void MostrarDatosUsuario(String ident, String nombre, String apellido, String plan) {

        String mostrar_datos = "SELECT * FROM usuarios WHERE Identificacion = ?";
        try {
            conn = cn.getConnection();
            ps = conn.prepareStatement(mostrar_datos);
            ps.setString(1, ident);
            rs = ps.executeQuery();

            if (rs.next()) {

                nombre = rs.getString("Nombre");
                apellido = rs.getString("Apellido");
                plan = rs.getString("plan");
            } else {
                System.out.println(mostrar_datos);
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
