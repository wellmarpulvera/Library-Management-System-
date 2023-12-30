/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oop2.lms.frame;

import com.oop2.lms.db.DbHelper;
import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guinita
 */
public class AddBookFrame extends javax.swing.JFrame {

    private final DbHelper dbHelper;
    /**
     * Creates new form AddUserFrame
     */
    public AddBookFrame() {
        initComponents();
        getContentPane().setBackground(new Color(32, 36, 51));
        dbHelper = new DbHelper();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        titleTxt = new com.oop2.lms.components.TextField();
        jLabel3 = new javax.swing.JLabel();
        addBookBtn = new com.oop2.lms.components.Button();
        jButton1 = new javax.swing.JButton();
        authorTxt = new com.oop2.lms.components.TextField();
        jLabel4 = new javax.swing.JLabel();
        categoryTxt = new com.oop2.lms.components.TextField();
        jLabel5 = new javax.swing.JLabel();
        stocksTxt = new com.oop2.lms.components.TextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(32, 36, 51));
        setMaximumSize(new java.awt.Dimension(500, 700));
        setMinimumSize(new java.awt.Dimension(500, 700));
        setPreferredSize(new java.awt.Dimension(500, 700));
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(java.awt.Color.white);
        jLabel1.setText("Add Book Form");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, -1, -1));
        getContentPane().add(titleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 360, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Title");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, -1, -1));

        addBookBtn.setText("Add Book");
        addBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBookBtnMouseClicked(evt);
            }
        });
        getContentPane().add(addBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 520, 360, 50));

        jButton1.setBackground(new java.awt.Color(255, 102, 102));
        jButton1.setForeground(java.awt.Color.white);
        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 610, 100, 40));
        getContentPane().add(authorTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 210, 360, 60));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setForeground(java.awt.Color.white);
        jLabel4.setText("Author");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 180, -1, -1));
        getContentPane().add(categoryTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 330, 360, 60));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel5.setForeground(java.awt.Color.white);
        jLabel5.setText("Category");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, -1, -1));
        getContentPane().add(stocksTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 440, 360, 60));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel6.setForeground(java.awt.Color.white);
        jLabel6.setText("Stocks");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 410, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void addBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookBtnMouseClicked
        // TODO add your handling code here:
        String title = titleTxt.getText();
        String author = authorTxt.getText();
        String category = categoryTxt.getText();
        int stocks = Integer.parseInt(stocksTxt.getText());
        dbHelper.addBook(title, author, category, stocks);
        DashboardFrame dashboardFrame = new DashboardFrame();
        dashboardFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_addBookBtnMouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        DashboardFrame dashboardFrame = new DashboardFrame();
        dashboardFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1MouseClicked

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
            java.util.logging.Logger.getLogger(AddBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddBookFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddBookFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.oop2.lms.components.Button addBookBtn;
    private com.oop2.lms.components.TextField authorTxt;
    private com.oop2.lms.components.TextField categoryTxt;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private com.oop2.lms.components.TextField stocksTxt;
    private com.oop2.lms.components.TextField titleTxt;
    // End of variables declaration//GEN-END:variables
}
