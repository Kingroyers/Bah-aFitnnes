package View;

import Controller.AdminController;
import Model.AdminModel;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 * Jah40520
 *
 * @author Antonio
 */
public class Login extends javax.swing.JFrame {

    AdminController adminc = new AdminController();
    AdminModel adminmodel = new AdminModel();

    public Login() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
    }

    public void validarlogin() {

        String user = jTextUsuario.getText();
        String pass = String.valueOf(jPassword.getPassword());

        if (!"".equals(user) || !"".equals(pass)) {

            adminmodel = adminc.log(user, pass);

            if (adminmodel.getUsuario_admin() != null && adminmodel.getPass_admin() != null) {

                Dashboard menu = new Dashboard();
                menu.setVisible(true);
                dispose();

            } else {

                JOptionPane.showMessageDialog(null, "USER o PASSWORD INCORRECT");

            }

        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator1 = new javax.swing.JSeparator();
        btn_entrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(235, 239, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/IconLogin2.png"))); // NOI18N
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-240, 410, 460, -1));

        jPanel2.setBackground(new java.awt.Color(9, 29, 54));
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/IconLogin.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-50, 10, 540, 500));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 0, 380, 540));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Yu Gothic UI Light", 0, 12))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Contraseña");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 190, -1, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Usuario");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, -1, -1));

        jTextUsuario.setForeground(new java.awt.Color(204, 204, 204));
        jTextUsuario.setText("Ingrese su nombre de usuario");
        jTextUsuario.setBorder(null);
        jTextUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jTextUsuarioMousePressed(evt);
            }
        });
        jPanel3.add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, 270, 30));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("BIENVENIDO");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 320, -1));

        jPassword.setForeground(new java.awt.Color(204, 204, 204));
        jPassword.setText("**********");
        jPassword.setBorder(null);
        jPassword.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPasswordMousePressed(evt);
            }
        });
        jPanel3.add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 270, 30));

        jSeparator2.setBackground(new java.awt.Color(9, 29, 54));
        jSeparator2.setForeground(new java.awt.Color(9, 29, 54));
        jPanel3.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 150, 270, 10));

        jSeparator1.setBackground(new java.awt.Color(9, 29, 54));
        jSeparator1.setForeground(new java.awt.Color(9, 29, 54));
        jPanel3.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, 270, 10));

        btn_entrar.setBackground(new java.awt.Color(9, 29, 54));
        btn_entrar.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_entrar.setForeground(new java.awt.Color(255, 255, 255));
        btn_entrar.setText("ENTRAR");
        btn_entrar.setBorder(null);
        btn_entrar.setBorderPainted(false);
        btn_entrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_entrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_entrarActionPerformed(evt);
            }
        });
        jPanel3.add(btn_entrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 270, 30));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 70, 320, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 540));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextUsuarioMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextUsuarioMousePressed
        if (jTextUsuario.getText().equals("Ingrese su nombre de usuario")) {
            jTextUsuario.setText("");
            jTextUsuario.setForeground(Color.black);
        }
        if (String.valueOf(jPassword.getPassword()).isEmpty()) {
            jPassword.setText("**********");
            jPassword.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jTextUsuarioMousePressed

    private void jPasswordMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPasswordMousePressed
        if (String.valueOf(jPassword.getPassword()).equals("**********")) {
            jPassword.setText("");
            jPassword.setForeground(Color.black);
        }
        if (jTextUsuario.getText().isEmpty()) {
            jTextUsuario.setText("Ingrese su nombre de usuario");
            jTextUsuario.setForeground(Color.gray);
        }
    }//GEN-LAST:event_jPasswordMousePressed

    private void btn_entrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_entrarActionPerformed
        validarlogin();
    }//GEN-LAST:event_btn_entrarActionPerformed

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
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_entrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
