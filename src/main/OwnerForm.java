/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import config.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author PC 12
 */
public class OwnerForm extends javax.swing.JFrame {

    /**
     * Creates new form OwnerForm
     */
    public OwnerForm() {
        initComponents();
    }

  
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 240, 230));

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 20, 60, 30));

        jButton2.setText("Edit");
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, 60, 30));

        jButton3.setText("Del");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, 60, 30));

        jButton4.setText("View");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 20, 60, 30));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/etc.png"))); // NOI18N
        jLabel4.setText("jLabel1");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void processTransaction(String oName, String vPlate, String vModel) {
    Connection conn = config.connectDB();
    try {
        conn.setAutoCommit(false);

        String ownerSql = "INSERT INTO tbl_Owners (o_name) VALUES (?)";
        PreparedStatement pstO = conn.prepareStatement(ownerSql, Statement.RETURN_GENERATED_KEYS);
        pstO.setString(1, oName);
        pstO.executeUpdate();

        ResultSet rs = pstO.getGeneratedKeys();
        int ownerId = rs.next() ? rs.getInt(1) : 0;

        String vehicleSql = "INSERT INTO tbl_Vehicles (v_plate, v_model, o_id) VALUES (?, ?, ?)";
        PreparedStatement pstV = conn.prepareStatement(vehicleSql);
        pstV.setString(1, vPlate);
        pstV.setString(2, vModel);
        pstV.setInt(3, ownerId);
        pstV.executeUpdate();

        conn.commit();
        javax.swing.JOptionPane.showMessageDialog(null, "Registration Successful!");
    } catch (SQLException e) {
        try { conn.rollback(); } catch (SQLException ex) { }
        javax.swing.JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
    } finally {
        try { conn.close(); } catch (SQLException e) { }
    }
}
    public void registerVehicleTransaction(String ownerName, String vehiclePlate, String vehicleModel) {
    Connection conn = config.connectDB();
    try {
        conn.setAutoCommit(false); // Start Transaction

        // 1. Insert Owner
        String ownerSql = "INSERT INTO tbl_Owners (o_name) VALUES (?)";
        PreparedStatement pstOwner = conn.prepareStatement(ownerSql, Statement.RETURN_GENERATED_KEYS);
        pstOwner.setString(1, ownerName);
        pstOwner.executeUpdate();

        // Get the generated Owner ID
        ResultSet rs = pstOwner.getGeneratedKeys();
        int ownerId = 0;
        if (rs.next()) { ownerId = rs.getInt(1); }

        // 2. Insert Vehicle linked to that Owner ID
        String vehicleSql = "INSERT INTO tbl_Vehicles (v_plate, v_model, o_id) VALUES (?, ?, ?)";
        PreparedStatement pstVehicle = conn.prepareStatement(vehicleSql);
        pstVehicle.setString(1, vehiclePlate);
        pstVehicle.setString(2, vehicleModel);
        pstVehicle.setInt(3, ownerId);
        pstVehicle.executeUpdate();

        conn.commit(); // Commit both if successful
        javax.swing.JOptionPane.showMessageDialog(null, "Transaction Successful: Owner and Vehicle Registered!");
        
    } catch (SQLException e) {
        try { conn.rollback(); } catch (SQLException ex) { /* Log Error */ }
        javax.swing.JOptionPane.showMessageDialog(null, "Transaction Failed: " + e.getMessage());
    } finally {
        try { conn.close(); } catch (SQLException e) { /* Log Error */ }
    }
}
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int row = jTable1.getSelectedRow();
    if (row != -1) {
        String id = jTable1.getValueAt(row, 0).toString();
        config conf = new config();
        conf.executeUpdate("DELETE FROM tbl_Owners WHERE o_id = ?", id);
        jButton4ActionPerformed(null); // Refresh table
    } else {
        javax.swing.JOptionPane.showMessageDialog(this, "Please select a row to delete.");
    }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        config conf = new config();
    conf.displayData("SELECT * FROM tbl_Owners", jTable1);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
String name = javax.swing.JOptionPane.showInputDialog("Owner Name:");
    String contact = javax.swing.JOptionPane.showInputDialog("Contact:");
    if (name != null && contact != null) {
        config conf = new config();
        conf.executeUpdate("INSERT INTO tbl_Owners (o_name, o_contact) VALUES (?, ?)", name, contact);
        jButton4ActionPerformed(null); // Refresh table
    }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(OwnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(OwnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(OwnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(OwnerForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new OwnerForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
