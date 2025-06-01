/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Panels;

import Controller.AdminController;
import Controller.UsuarioController;
import Interfaces.CrudUsuariosInterfaces;
import Model.PagoModel;
import Model.UsuarioModel;
import View.*;
import java.awt.HeadlessException;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

public class Usuarios extends javax.swing.JPanel {

    UsuarioModel usuario_model = new UsuarioModel();
    PagoModel pago_model = new PagoModel();
    AdminController admin_controller = new AdminController();
    DefaultTableModel model = new DefaultTableModel();

    public Usuarios() {
        initComponents();
        MostrarEnTabla();
        initStyles();
        admin_controller.ExpiracionDePago();
    }

    private void initStyles() {
        jTextFieldBuscar.putClientProperty("JTextField.placeholderText", "Ingrese la identificación del usuario");
    }

    public void MostrarEnTabla() {

        List<PagoModel> mostrarusu = admin_controller.MostrarEnTabla("");
        model = (DefaultTableModel) jTableUsuarios.getModel();
        Object[] ob = new Object[8];

        model.setRowCount(0);

        for (int i = 0; i < mostrarusu.size(); i++) {

            ob[0] = mostrarusu.get(i).getIden();
            ob[1] = mostrarusu.get(i).getIdentificacion();
            ob[2] = mostrarusu.get(i).getNombre_usuario();
            ob[3] = mostrarusu.get(i).getApellido_usuario();
            ob[4] = mostrarusu.get(i).getCorreo_usuario();
            ob[5] = mostrarusu.get(i).getTelefono();
            ob[6] = mostrarusu.get(i).getPlan();
            ob[7] = mostrarusu.get(i).isPago_usuario();

            model.addRow(ob);

        }
        jTableUsuarios.setModel(model);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableUsuarios = new javax.swing.JTable();
        jButtonAgregar = new javax.swing.JButton();
        jButtonModificar = new javax.swing.JButton();
        jButtonEliminar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButtonRealizarpago = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setText("Usuarios");

        jTextFieldBuscar.setBorder(null);

        jButtonBuscar.setBackground(new java.awt.Color(45, 77, 102));
        jButtonBuscar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("BUSCAR");
        jButtonBuscar.setBorder(null);
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTableUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "#", "Identifiación", "Nombres", "Apellidos", "Correo", "Telefono", "Plan", "Pago"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.Boolean.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jTableUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableUsuarios);
        if (jTableUsuarios.getColumnModel().getColumnCount() > 0) {
            jTableUsuarios.getColumnModel().getColumn(0).setMinWidth(40);
            jTableUsuarios.getColumnModel().getColumn(0).setPreferredWidth(40);
            jTableUsuarios.getColumnModel().getColumn(0).setMaxWidth(40);
            jTableUsuarios.getColumnModel().getColumn(4).setMinWidth(100);
            jTableUsuarios.getColumnModel().getColumn(4).setPreferredWidth(100);
            jTableUsuarios.getColumnModel().getColumn(6).setMinWidth(70);
            jTableUsuarios.getColumnModel().getColumn(6).setPreferredWidth(70);
            jTableUsuarios.getColumnModel().getColumn(6).setMaxWidth(70);
            jTableUsuarios.getColumnModel().getColumn(7).setMinWidth(40);
            jTableUsuarios.getColumnModel().getColumn(7).setPreferredWidth(40);
            jTableUsuarios.getColumnModel().getColumn(7).setMaxWidth(40);
        }

        jButtonAgregar.setBackground(new java.awt.Color(45, 77, 102));
        jButtonAgregar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonAgregar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonAgregar.setText("AGREGAR");
        jButtonAgregar.setBorder(null);
        jButtonAgregar.setBorderPainted(false);
        jButtonAgregar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAgregarActionPerformed(evt);
            }
        });

        jButtonModificar.setBackground(new java.awt.Color(45, 77, 102));
        jButtonModificar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonModificar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonModificar.setText("MODIFICAR");
        jButtonModificar.setBorder(null);
        jButtonModificar.setBorderPainted(false);
        jButtonModificar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonModificarActionPerformed(evt);
            }
        });

        jButtonEliminar.setBackground(new java.awt.Color(45, 77, 102));
        jButtonEliminar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonEliminar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonEliminar.setText("ELIMINAR");
        jButtonEliminar.setBorder(null);
        jButtonEliminar.setBorderPainted(false);
        jButtonEliminar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonEliminarActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(9, 29, 54));
        jSeparator1.setForeground(new java.awt.Color(9, 29, 54));

        jButtonRealizarpago.setBackground(new java.awt.Color(45, 77, 102));
        jButtonRealizarpago.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonRealizarpago.setForeground(new java.awt.Color(255, 255, 255));
        jButtonRealizarpago.setText("REALIZAR PAGO");
        jButtonRealizarpago.setBorder(null);
        jButtonRealizarpago.setBorderPainted(false);
        jButtonRealizarpago.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonRealizarpago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRealizarpagoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRealizarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 878, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldBuscar))
                                .addGap(18, 18, 18)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(59, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextFieldBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRealizarpago, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        try {
            String usuarioBuscar = jTextFieldBuscar.getText();

            model = (DefaultTableModel) jTableUsuarios.getModel();
            model.setRowCount(0);
            admin_controller.MostrarEnTabla(usuarioBuscar).forEach((u) -> {
                model.addRow(new Object[]{
                    u.getIden(),
                    u.getIdentificacion(),
                    u.getNombre_usuario(),
                    u.getApellido_usuario(),
                    u.getCorreo_usuario(),
                    u.getTelefono(),
                    u.getPlan(),
                    u.isPago_usuario()
                });
            });

        } catch (HeadlessException e) {
            System.out.print(e.getMessage());
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonModificarActionPerformed
        if (jTableUsuarios.getSelectedRow() > -1) {
            try {
                int Idusuario = (int) jTableUsuarios.getValueAt(jTableUsuarios.getSelectedRow(), 0);
                CrudUsuariosInterfaces cui = new UsuarioController();
                Dashboard.ShowJPanel(new Agregar(cui.getUserById(Idusuario)));
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR EL USUARIO A MODIFICAR: \n", "ERROR", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButtonModificarActionPerformed

    private void jButtonEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEliminarActionPerformed
        CrudUsuariosInterfaces cui = new UsuarioController();
        model = (DefaultTableModel) jTableUsuarios.getModel();
        if (jTableUsuarios.getSelectedRows().length < 1) {
            JOptionPane.showMessageDialog(this, "DEBE SELECCIONAR UNO O MÁS USUARIOS A ELIMINAR \n", "AVISO", JOptionPane.INFORMATION_MESSAGE);
        } else {
            int[] selectedRows = jTableUsuarios.getSelectedRows();
            for (int i = selectedRows.length - 1; i >= 0; i--) {
                try {
                    int rowIndex = selectedRows[i];
                    int Idusuario = (int) jTableUsuarios.getValueAt(rowIndex, 0);
                    cui.eliminar(Idusuario);
                    model.removeRow(rowIndex);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "ERROR AL ELIMINAR EL/LOS USUARIOS: " + e.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_jButtonEliminarActionPerformed

    private void jButtonAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAgregarActionPerformed
        Dashboard.ShowJPanel(new Agregar());
    }//GEN-LAST:event_jButtonAgregarActionPerformed

    private void jTableUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableUsuariosMouseClicked

    }//GEN-LAST:event_jTableUsuariosMouseClicked

    private void jButtonRealizarpagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRealizarpagoActionPerformed
        PagosU pgu = new PagosU();
        pgu.setVisible(true);
    }//GEN-LAST:event_jButtonRealizarpagoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAgregar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonEliminar;
    private javax.swing.JButton jButtonModificar;
    private javax.swing.JButton jButtonRealizarpago;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTableUsuarios;
    private javax.swing.JTextField jTextFieldBuscar;
    // End of variables declaration//GEN-END:variables
}
