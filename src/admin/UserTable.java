
package admin;
import config.config;
import config.session;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;



public class UserTable extends javax.swing.JFrame {

    private Object welcome;

    
    public UserTable() {
        initComponents();
        session sess = session.getInstance(); 
    String userName = sess.getUserName();       
    displayeUser();
    }

     void displayeUser(){
    
        config conf = new config();
        String sql = "SELECT u_id, name, email, gender, role, status FROM user_tbl";
        conf.displayData(sql, UserTable);
        
    }
   

   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 11, -1, 300));

        jButton1.setText("Settings");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, 100, -1));

        jButton2.setText("Managements");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jButton3.setText("Dashboard");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 100, -1));

        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 320, 190));

        jButton5.setText("Add");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 30, 70, -1));

        jButton6.setText("Edit");
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 30, 70, -1));

        jButton7.setText("Delete");
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 30, -1, -1));

        jButton8.setText("Log Out");
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 90, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
