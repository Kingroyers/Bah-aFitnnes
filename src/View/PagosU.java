package View;

import Controller.Acceso;
import Controller.UsuarioController;
import Model.Conexionbd;
import Model.UsuarioModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.HeadlessException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class PagosU extends javax.swing.JFrame {

    Acceso acceso = new Acceso();
    Connection conn;
    ResultSet rs;
    PreparedStatement ps;
    Conexionbd con = new Conexionbd();
    UsuarioModel usuario_model = new UsuarioModel();
    UsuarioController usuario_controller = new UsuarioController();

    public PagosU() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);

    }

    public void MostrarDatosUsuario(String ident) {

        String mostrar_datos = "SELECT * FROM usuarios WHERE Identificacion = ?";
        try {

            conn = con.getConnection();
            ps = conn.prepareStatement(mostrar_datos);
            ps.setString(1, ident);
            rs = ps.executeQuery();

            if (rs.next()) {

                lblNombrepago.setText(rs.getString("Nombre"));
                lblApellido.setText(rs.getString("Apellido"));
            } else {
                lblNombrepago.getText();
                lblApellido.getText();
                lblPlan.getText();
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

    public void ReactivarSuscripcion(String idUsuario) {
        String ident = jTextpagoIden.getText();
        if (!acceso.VerificarPago(ident)) {
            
            String selectedPlan = (String) jComboBoxPlan.getSelectedItem();
            int diasPlan = 0;

            // Verificar que se haya seleccionado un plan 
            if (selectedPlan != null && !selectedPlan.isEmpty()) {
                try {
                   
                    diasPlan = Integer.parseInt(selectedPlan.split(" ")[0]);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(this, "Formato de plan no válido.");
                    return;
                }
            } else {
                JOptionPane.showMessageDialog(this, "Por favor, selecciona un plan.");
                return;
            }

            // Formatear las fechas
            SimpleDateFormat sdt = new SimpleDateFormat("dd/MM/yyyy");
            Date fechaActual = new Date();

            // Calcula la fecha final sumando los días seleccionados al plan
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(fechaActual);
            calendar.add(Calendar.DAY_OF_YEAR, diasPlan);
            Date fechaFinal = calendar.getTime();

            System.out.println("Fecha actual: " + sdt.format(fechaActual));
            System.out.println("Fecha final después de sumar " + diasPlan + " días: " + sdt.format(fechaFinal));

            String reactivar = "UPDATE usuarios SET Plan = ?, fecha_expiracion = ?  WHERE Identificacion = ?";

            try {
                java.sql.Date sqlFechaFinal = new java.sql.Date(fechaFinal.getTime()); //transforma el dato Date a SQL

                conn = con.getConnection();
                ps = conn.prepareStatement(reactivar);
                ps.setString(1, selectedPlan);
                ps.setDate(2, sqlFechaFinal);
                ps.setString(3, idUsuario);
                ps.execute();
                if (rs.next()) {
                    System.out.println("consultando");
                } else {
                    System.out.println("lolo");
                }

                System.out.println("EXITOSO");
                System.out.println(reactivar);
                System.out.println(sqlFechaFinal + selectedPlan);
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
        } else {
            System.out.println("nada");
        }
    }
    
    private void GenerarFactura(String idUsuario){
        
        Document document = new Document();
        
        try {
             String ruta = System.getProperty("user.home");
             PdfWriter.getInstance(document, new FileOutputStream(ruta + "/Desktop/Factura_cliente.pdf"));
             document.open();
             document.addTitle("Factura Bahía");
             Image image = Image.getInstance("C:\\Users\\Antonio\\Documents\\NetBeansProjects\\SistemaGymR\\src\\Img\\Logo2BF.png");
             image.setAlignment(Image.ALIGN_CENTER);
             document.add(image);
             
             PdfPTable tabla = new PdfPTable(5);
             tabla.addCell("Identificacion");
             tabla.addCell("Nombre");
             tabla.addCell("Apellido");
             tabla.addCell("Plan");
             tabla.addCell("fecha_expiracion");
             
             String contenidoFactura = "Factura de Pago\n\n" +
                                      "Bahía GYM\n\n" +
                                      "Gracias por elegir Bahía GYM para alcanzar tus objetivos de salud y bienestar. " +
                                      "Esta factura corresponde al pago de tu plan de membresía, que te brinda acceso completo " +
                                      "a nuestras instalaciones, clases y servicios. Te recordamos que tu suscripción incluye " +
                                      "todos los beneficios para mejorar tu condición física y estilo de vida. Nos enorgullece " +
                                      "ser parte de tu viaje de entrenamiento y estamos aquí para apoyarte en cada paso. " +
                                      "¡Disfruta de tu experiencia en Bahía GYM!\n\n";
              Paragraph p1 = new Paragraph(contenidoFactura);
              document.add(p1);
      
             
             
             String sql = "SELECT Identificacion, Nombre, Apellido, Plan, fecha_expiracion FROM usuarios WHERE Identificacion = ?";
             try {
              conn = con.getConnection();
              ps = conn.prepareStatement(sql);
              ps.setString(1, idUsuario);
              rs = ps.executeQuery();
              
                 if (rs.next()) {
                     
                     do {                         
                         tabla.addCell(rs.getString(1));
                         tabla.addCell(rs.getString(2));
                         tabla.addCell(rs.getString(3));
                         tabla.addCell(rs.getString(4));
                         tabla.addCell(rs.getString(5));
                         
                     } while (rs.next());// se para hasta que no encuentre mas registros
                     document.add(tabla);
                 }else{
                     System.out.println("no genera factura");
                 }
                 
                 
            } catch ( DocumentException | SQLException e) {
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
             document.close();
             System.out.println("Factura generada");
             
        } catch (DocumentException | IOException e ) {
            System.out.println(e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTextpagoIden = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jButtonRealizaPago = new javax.swing.JButton();
        lblApellido = new javax.swing.JLabel();
        lblPlan = new javax.swing.JLabel();
        lblNombrepago = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jComboBoxPlan = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153)));

        jTextpagoIden.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextpagoIdenActionPerformed(evt);
            }
        });
        jTextpagoIden.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextpagoIdenKeyReleased(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setText("Identificacion");

        jButtonRealizaPago.setBackground(new java.awt.Color(45, 77, 102));
        jButtonRealizaPago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRealizaPago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRealizaPago.setText("REALIZAR PAGO ");
        jButtonRealizaPago.setBorder(null);
        jButtonRealizaPago.setBorderPainted(false);
        jButtonRealizaPago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRealizaPago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizaPagoActionPerformed(evt);
            }
        });

        lblApellido.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblApellido.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblApellido.setText("Apellido");

        lblPlan.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblPlan.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lblPlan.setText("Plan a pagar");

        lblNombrepago.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        lblNombrepago.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 153));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo2BF.png"))); // NOI18N

        jButton1.setBackground(new java.awt.Color(255, 153, 153));
        jButton1.setFont(new java.awt.Font("Segoe UI Light", 1, 12)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("X");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jComboBoxPlan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1 dias", "15 dias ", "30 dias ", " ", " " }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jTextpagoIden, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButtonRealizaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lblNombrepago, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(17, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jComboBoxPlan, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(63, 63, 63)
                .addComponent(jLabel2)
                .addGap(45, 45, 45)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextpagoIden, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblApellido)
                    .addComponent(lblNombrepago))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPlan)
                    .addComponent(jComboBoxPlan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(74, 74, 74)
                .addComponent(jButtonRealizaPago, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 337, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 514, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonRealizaPagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizaPagoActionPerformed

        if (jTextpagoIden.getText().trim().equals("")) {

            JOptionPane.showMessageDialog(this, "CAMPO VACIO");

        } else {
            String idUsuario = jTextpagoIden.getText();
            try {

                int numeroId = Integer.parseInt(idUsuario);
                ReactivarSuscripcion(idUsuario);
                usuario_controller.ValidaryActualizarPago(idUsuario);
                GenerarFactura(idUsuario);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "POR FAVOR, DIGITE SOLO NÚMEROS EN LA IDENTIFICACIÓN");
            }
        }
    }//GEN-LAST:event_jButtonRealizaPagoActionPerformed

    private void jTextpagoIdenKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextpagoIdenKeyReleased
        if (jTextpagoIden.getText().trim().equals("")) {

            lblNombrepago.setText("Nombre");
            lblApellido.setText("Apellido");
            lblPlan.setText("Plan a pagar");
        } else {
            MostrarDatosUsuario(jTextpagoIden.getText());
        }
    }//GEN-LAST:event_jTextpagoIdenKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextpagoIdenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextpagoIdenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextpagoIdenActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(PagosU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PagosU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PagosU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PagosU.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PagosU().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonRealizaPago;
    private javax.swing.JComboBox<String> jComboBoxPlan;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextpagoIden;
    private javax.swing.JLabel lblApellido;
    private javax.swing.JLabel lblNombrepago;
    private javax.swing.JLabel lblPlan;
    // End of variables declaration//GEN-END:variables
}
