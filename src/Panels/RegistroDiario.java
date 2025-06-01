package Panels;

import Controller.Acceso;
import Controller.AdminController;
import Model.UsuarioModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class RegistroDiario extends javax.swing.JPanel {

    AdminController admin_controller = new AdminController();
    DefaultTableModel model = new DefaultTableModel();
    Acceso acam = new Acceso();

    public RegistroDiario() {
        initComponents();
        MostrarEnTabla();
        conteo();
    }

    public void MostrarEnTabla() {

        List<UsuarioModel> mostrarusu = admin_controller.MostrarRegistroDiario();
        model = (DefaultTableModel) jTableRegistroDiario.getModel();
        Object[] ob = new Object[3];

        for (int i = 0; i < mostrarusu.size(); i++) {

            ob[0] = mostrarusu.get(i).getIden();
            ob[1] = mostrarusu.get(i).getIdentificacion();
            ob[2] = mostrarusu.get(i).getHora_entrada();

            model.addRow(ob);

        }
        jTableRegistroDiario.setModel(model);
    }

    public void conteo() {

        int totalconteo = jTableRegistroDiario.getRowCount();
        lblConteoDiario.setText("" + totalconteo);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableRegistroDiario = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblConteoDiario = new javax.swing.JLabel();
        jButtonReset = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTableRegistroDiario.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                " #", "Identificacion", "Hora_entrada"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableRegistroDiario);
        if (jTableRegistroDiario.getColumnModel().getColumnCount() > 0) {
            jTableRegistroDiario.getColumnModel().getColumn(0).setMinWidth(40);
            jTableRegistroDiario.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableRegistroDiario.getColumnModel().getColumn(0).setMaxWidth(40);
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 600, 386));

        jPanel1.setBackground(new java.awt.Color(62, 129, 171));

        jLabel1.setFont(new java.awt.Font("Segoe UI Light", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USUARIOS");

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Icon/Fa6SolidUsers.png"))); // NOI18N

        lblConteoDiario.setFont(new java.awt.Font("Segoe UI Light", 0, 18)); // NOI18N
        lblConteoDiario.setForeground(new java.awt.Color(255, 255, 255));
        lblConteoDiario.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lblConteoDiario.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblConteoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblConteoDiario, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(48, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(661, 22, -1, -1));

        jButtonReset.setBackground(new java.awt.Color(45, 77, 102));
        jButtonReset.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonReset.setForeground(new java.awt.Color(255, 255, 255));
        jButtonReset.setText("RESET");
        jButtonReset.setBorder(null);
        jButtonReset.setBorderPainted(false);
        jButtonReset.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonResetActionPerformed(evt);
            }
        });
        add(jButtonReset, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 180, 280, 30));
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonResetActionPerformed
        admin_controller.EliminarRegistros();
        MostrarEnTabla();
        model.setRowCount(0);
        conteo();
    }//GEN-LAST:event_jButtonResetActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonReset;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableRegistroDiario;
    private javax.swing.JLabel lblConteoDiario;
    // End of variables declaration//GEN-END:variables
}
