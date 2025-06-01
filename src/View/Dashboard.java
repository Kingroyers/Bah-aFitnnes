package View;

import Panels.Home;
import Panels.RegistroDiario;
import Panels.Usuarios;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class Dashboard extends javax.swing.JFrame {

    private ReadQR readQRInstance = null;  //para asegurarse de 
                                           //que solo exista una instancia de esta clase abierta (patrón Singleton).

    public Dashboard() {
        initComponents();
        setLocationRelativeTo(null);
        this.setResizable(false);
        setIconImage(getIconImage());
        InitContent();
    }

    private void InitContent() {
        Home hm = new Home();
        hm.setSize(990, 450);
        hm.setLocation(0, 0);

        jPanelContent.removeAll();
        jPanelContent.add(hm, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }

    public static void ShowJPanel(JPanel p) {
        p.setSize(990, 450);
        p.setLocation(0, 0);

        jPanelContent.removeAll();
        jPanelContent.add(p, BorderLayout.CENTER);
        jPanelContent.revalidate();
        jPanelContent.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBackground = new javax.swing.JPanel();
        jPanelHeader = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanelMenu = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButtonHome = new javax.swing.JButton();
        jButtonUsuarios = new javax.swing.JButton();
        jButtonAcceso = new javax.swing.JButton();
        jButtonAcceso1 = new javax.swing.JButton();
        jPanelTitle = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanelContent = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelBackground.setBackground(new java.awt.Color(255, 255, 255));
        jPanelBackground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelHeader.setBackground(new java.awt.Color(9, 29, 54));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/Logo2BF.png"))); // NOI18N
        jLabel1.setText("Bahía Fit");

        javax.swing.GroupLayout jPanelHeaderLayout = new javax.swing.GroupLayout(jPanelHeader);
        jPanelHeader.setLayout(jPanelHeaderLayout);
        jPanelHeaderLayout.setHorizontalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addContainerGap(1030, Short.MAX_VALUE))
        );
        jPanelHeaderLayout.setVerticalGroup(
            jPanelHeaderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHeaderLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel1)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelHeader, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 70));

        jPanelMenu.setBackground(new java.awt.Color(45, 77, 102));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Img/AvatarAdmin.png"))); // NOI18N
        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fulanito Detal");

        jLabel4.setForeground(new java.awt.Color(62, 129, 171));
        jLabel4.setText("Admin");

        jButtonHome.setBackground(new java.awt.Color(62, 98, 128));
        jButtonHome.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonHome.setForeground(new java.awt.Color(255, 255, 255));
        jButtonHome.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/MingcuteHome2Fill (1).png"))); // NOI18N
        jButtonHome.setText("HOME");
        jButtonHome.setBorder(null);
        jButtonHome.setBorderPainted(false);
        jButtonHome.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHomeActionPerformed(evt);
            }
        });

        jButtonUsuarios.setBackground(new java.awt.Color(62, 98, 128));
        jButtonUsuarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonUsuarios.setForeground(new java.awt.Color(255, 255, 255));
        jButtonUsuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconoUsers (1).png"))); // NOI18N
        jButtonUsuarios.setText("USUARIOS");
        jButtonUsuarios.setBorder(null);
        jButtonUsuarios.setBorderPainted(false);
        jButtonUsuarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jButtonAcceso.setBackground(new java.awt.Color(62, 98, 128));
        jButtonAcceso.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAcceso.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAcceso.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/iconoUsers (1).png"))); // NOI18N
        jButtonAcceso.setText("ACCESO");
        jButtonAcceso.setBorder(null);
        jButtonAcceso.setBorderPainted(false);
        jButtonAcceso.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAcceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAccesoActionPerformed(evt);
            }
        });

        jButtonAcceso1.setBackground(new java.awt.Color(62, 98, 128));
        jButtonAcceso1.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAcceso1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAcceso1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/GrommetIconsOnedrive.png"))); // NOI18N
        jButtonAcceso1.setText("REGISTRO DIARIO");
        jButtonAcceso1.setBorder(null);
        jButtonAcceso1.setBorderPainted(false);
        jButtonAcceso1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAcceso1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAcceso1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                .addContainerGap(71, Short.MAX_VALUE)
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelMenuLayout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(122, 122, 122))))
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel3))
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButtonHome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonUsuarios, javax.swing.GroupLayout.DEFAULT_SIZE, 197, Short.MAX_VALUE)
                            .addComponent(jButtonAcceso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButtonAcceso1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(49, 49, 49)
                .addComponent(jButtonHome, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAcceso, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAcceso1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(198, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 290, 650));

        jPanelTitle.setBackground(new java.awt.Color(62, 129, 171));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Gestión de Usuarios de Bahía Fit");

        javax.swing.GroupLayout jPanelTitleLayout = new javax.swing.GroupLayout(jPanelTitle);
        jPanelTitle.setLayout(jPanelTitleLayout);
        jPanelTitleLayout.setHorizontalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelTitleLayout.createSequentialGroup()
                .addContainerGap(224, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(224, 224, 224))
        );
        jPanelTitleLayout.setVerticalGroup(
            jPanelTitleLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelTitleLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel5)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        jPanelBackground.add(jPanelTitle, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 990, 120));

        jPanelContent.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanelContentLayout = new javax.swing.GroupLayout(jPanelContent);
        jPanelContent.setLayout(jPanelContentLayout);
        jPanelContentLayout.setHorizontalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 990, Short.MAX_VALUE)
        );
        jPanelContentLayout.setVerticalGroup(
            jPanelContentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        jPanelBackground.add(jPanelContent, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 990, 530));

        getContentPane().add(jPanelBackground, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1280, 720));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHomeActionPerformed
        ShowJPanel(new Home());
    }//GEN-LAST:event_jButtonHomeActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed

        ShowJPanel(new Usuarios());
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

    private void jButtonAccesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAccesoActionPerformed
        if (readQRInstance == null || !readQRInstance.isVisible()) {//basicamente primero verifica si ReadQR ya está run
            readQRInstance = new ReadQR();                          //para así crear una unica pestaña *Uso del Singleton*
            readQRInstance.setVisible(true);
        } else {
            readQRInstance.toFront();
        }
    }//GEN-LAST:event_jButtonAccesoActionPerformed

    private void jButtonAcceso1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAcceso1ActionPerformed
        ShowJPanel(new RegistroDiario());
    }//GEN-LAST:event_jButtonAcceso1ActionPerformed

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
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAcceso;
    private javax.swing.JButton jButtonAcceso1;
    private javax.swing.JButton jButtonHome;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanelBackground;
    private static javax.swing.JPanel jPanelContent;
    private javax.swing.JPanel jPanelHeader;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelTitle;
    // End of variables declaration//GEN-END:variables
}
