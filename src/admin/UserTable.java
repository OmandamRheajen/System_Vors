package admin;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;
import net.proteanit.sql.DbUtils;
import config.config;
import config.Session;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import main.login;
import javax.swing.table.TableRowSorter;
import javax.swing.RowFilter;

public class UserTable extends javax.swing.JFrame {
    java.sql.Connection conn = null;
    java.sql.PreparedStatement pst = null;
    java.sql.ResultSet rs = null;
    public UserTable() {
        if (Session.getInstance().getUid() == null) {
        JOptionPane.showMessageDialog(null, "Login first!");
        new login().setVisible(true);
        this.dispose();
    } else {
        initComponents();
        
        DefaultTableModel model = (DefaultTableModel) u_table.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        u_table.setRowSorter(sorter);
        
        
        Session sess = Session.getInstance(); 
        
       
        displayUser(); 
    }
    }
    
    public void displayUser() {
        config conf = new config();
        
       
        String sql = "SELECT u_id, name, email, gender, role, status FROM user_tbl";
        conf.displayData(sql, u_table); // Change 'users_table' to your actual table variable name
    }

    


   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        u_table = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 300));

        jButton1.setText("Settings");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 170, 100, -1));

        jButton2.setText("Managements");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 130, 100, -1));

        jButton3.setText("Dashboard");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 90, 100, -1));

        jScrollPane1.setViewportView(u_table);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 330, 210));

        jButton5.setText("Add");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 30, 70, -1));

        jButton6.setText("Edit");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 30, 70, -1));

        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, -1, -1));

        jButton8.setText("Log Out");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 210, 100, -1));

        jLabel1.setBackground(new java.awt.Color(51, 51, 51));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 10)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("SEARCH");
        jLabel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 50, 20));

        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });
        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextField2KeyReleased(evt);
            }
        });
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, 90, 20));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/board.png"))); // NOI18N
        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(-290, -20, 840, 360));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void manageUser(String action, String u_id) {
    javax.swing.JTextField nameF = new javax.swing.JTextField();
    javax.swing.JTextField emailF = new javax.swing.JTextField();
    javax.swing.JComboBox<String> statusF = new javax.swing.JComboBox<>(new String[]{"Active", "Pending"});

    if (action.equals("Edit")) {
        int row = u_table.getSelectedRow();
        nameF.setText(u_table.getValueAt(row, 1).toString());
        emailF.setText(u_table.getValueAt(row, 2).toString());
        statusF.setSelectedItem(u_table.getValueAt(row, 3).toString());
    }

    Object[] inputFields = { "Name:", nameF, "Email:", emailF, "Status:", statusF };
    int result = javax.swing.JOptionPane.showConfirmDialog(null, inputFields, action + " User", javax.swing.JOptionPane.OK_CANCEL_OPTION);
    
    if (result == javax.swing.JOptionPane.OK_OPTION) {
        try {
            conn = config.dbConnector.getConnection();
            String sql = action.equals("Add") 
                ? "INSERT INTO tbl_accounts (name, email, status) VALUES (?, ?, ?)"
                : "UPDATE tbl_accounts SET name=?, email=?, status=? WHERE a_id=?";
            
            pst = conn.prepareStatement(sql);
            pst.setString(1, nameF.getText());
            pst.setString(2, emailF.getText());
            pst.setString(3, statusF.getSelectedItem().toString());
            if (action.equals("Edit")) pst.setString(4, u_id);

            pst.executeUpdate();
            refreshTable();
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }
}
    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        userForm uf = new userForm();
        uf.setVisible(true);
        uf.action = "Add";
        uf.submitButton.setText("Save");
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
       int a = JOptionPane.showConfirmDialog(null, "Confirm Logout?", "Logout", JOptionPane.YES_NO_OPTION);
   if (a == 0) {
    this.dispose();
    new login().setVisible(true);
}        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
      int row = u_table.getSelectedRow();
      if (row == -1) {
    JOptionPane.showMessageDialog(null, "Please select a user to delete!");
} else {
    String id = u_table.getValueAt(row, 0).toString();
    config conf = new config();
    String sql = "DELETE FROM user_tbl WHERE u_id = '" + id + "'";
    JOptionPane.showMessageDialog(null, "User Deleted!");
    displayUser(""); 
}        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
     DefaultTableModel model = (DefaultTableModel) u_table.getModel();
    TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
    u_table.setRowSorter(sorter);
    // Filters based on the text in the search bar (jTextField2)
    sorter.setRowFilter(RowFilter.regexFilter("(?i)" + jTextField2.getText()));
    }//GEN-LAST:event_jTextField2ActionPerformed

    private void jTextField2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyReleased
    try {
            String query = jTextField2.getText();
            String sql = "SELECT * FROM tbl_accounts WHERE name LIKE ? OR email LIKE ?";
            pst = conn.prepareStatement(sql);
            pst.setString(1, "%" + query + "%");
            pst.setString(2, "%" + query + "%");
            rs = pst.executeQuery();
            u_table.setModel(net.proteanit.sql.DbUtils.resultSetToTableModel(rs)); 
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_jTextField2KeyReleased

    {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserTable().setVisible(true);
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTable u_table;
    // End of variables declaration//GEN-END:variables
public static void main(String args[]) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            new UserTable().setVisible(true);
        }
    });
 }
}
