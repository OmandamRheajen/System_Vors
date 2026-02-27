/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.Session;
import javax.swing.JOptionPane;
import main.login;

public class Userdashboard extends javax.swing.JFrame {
    
private String id, name, email, status;

public Userdashboard(String id, String name, String email, String status) {
      if (Session.getInstance().getUid() == null) {
        JOptionPane.showMessageDialog(null, "Login first!");
        new login().setVisible(true);
        this.dispose();
    } else {
    initComponents();
    this.id = id;
    this.name = name;
    this.email = email;
    this.status = status;
  }
}


   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("REPORTS");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 230, 70, 20));

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("MANAGE");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 230, 70, 30));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("USER DASHBOARD");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 250, 50));

        jLabel3.setFont(new java.awt.Font("Arial", 3, 36)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("VORS");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 10, -1, -1));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/report.png"))); // NOI18N
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 140, 90, 80));

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/set1.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 90, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/ksks3.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 380));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 400, 300));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
    admin.Account acc = new admin.Account(id, name, email, status);
        acc.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(() -> {
        new Userdashboard("0", "Guest", "guest@mail.com", "User").setVisible(true);
    });
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
