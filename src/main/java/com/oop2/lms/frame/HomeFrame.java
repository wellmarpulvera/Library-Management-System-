/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oop2.lms.frame;

import com.oop2.lms.components.Chart;
import com.oop2.lms.db.DbHelper;
import com.oop2.lms.model.User;
import com.oop2.lms.util.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author morax
 */
public class HomeFrame extends javax.swing.JFrame {

    private final DbHelper dbHelper;

    /**
     * Creates new form DashboardFrame
     */
    public HomeFrame() {
        initComponents();
        dbHelper = new DbHelper();
        changePanel(booksPanel);
        loadBooksTable();
        usernameLbl.setText(Session.getLoggedInUser().getUsername());
    }

    public void changePanel(JPanel newPanel) {
        JPanel jPanels[] = {booksPanel, borrowingsPanel, reservationsPanel, finesPanel};
        for (JPanel currPanel : jPanels) {
            if (currPanel == newPanel) {
                newPanel.setVisible(true);
            } else {
                currPanel.setVisible(false);
            }
        }
    }

    public void loadBooksTable() {
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.getBooks();
            while (rs.next()) {
                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String category = rs.getString("category");
                int stocks = rs.getInt("stocks");
                Object[] row = {id, title, author, category, String.valueOf(stocks)};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void loadReservationsTable() {
        DefaultTableModel model = (DefaultTableModel) reservationsTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.getUserReservations();
            while (rs.next()) {
                int id = rs.getInt("reservation_id");
                int userId = rs.getInt("user_id");
                int bookId = rs.getInt("book_id");
                Date reservationDate = rs.getDate("reservation_date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                Object[] row = {id, userId, bookId, sdf.format(reservationDate)};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    public void loadBorrowingsTable() {
        DefaultTableModel model = (DefaultTableModel) borrowingsTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.getUserBorrowings();
            while (rs.next()) {
                int id = rs.getInt("borrowing_id");
                int userId = rs.getInt("user_id");
                int bookId = rs.getInt("book_id");
                Date borrowDate = rs.getDate("borrow_date");
                Date dueDate = rs.getDate("due_date");
                Date returnDate = rs.getDate("return_date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String returnDateFormatted = null;
                if(returnDate != null)
                     returnDateFormatted = sdf.format(returnDate);
                Object[] row = {id, userId, bookId, sdf.format(borrowDate), sdf.format(dueDate), returnDateFormatted};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }
    
    public void loadFinesTable() {
        DefaultTableModel model = (DefaultTableModel) finesTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.getUserFines();
            while (rs.next()) {
                int id = rs.getInt("fine_id");
                int userId = rs.getInt("user_id");
                int bookId = rs.getInt("borrowing_id");
                float fineAmount = rs.getFloat("fine_amount");
                boolean paid = rs.getBoolean("paid");
                Object[] row = {id, userId, bookId, fineAmount, paid};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        finesNav = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reservationsNav = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        borrowingsNav = new javax.swing.JLabel();
        booksNav = new javax.swing.JLabel();
        booksPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        reserveBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        searchTxt = new com.oop2.lms.components.TextField();
        searchBtn1 = new javax.swing.JButton();
        popularBooksBtn = new com.oop2.lms.components.Button();
        reservationsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        reservationsTable = new javax.swing.JTable();
        jLabel11 = new javax.swing.JLabel();
        finesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        finesTable = new javax.swing.JTable();
        jLabel13 = new javax.swing.JLabel();
        borrowingsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        borrowingsTable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(39, 45, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finesNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        finesNav.setForeground(java.awt.Color.white);
        finesNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finesNav.setText("Fines");
        finesNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finesNavMouseClicked(evt);
            }
        });
        jPanel1.add(finesNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 0, 60, 80));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/Logo.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 80));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icons/logoutIcon.png"))); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(950, 30, -1, -1));

        reservationsNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        reservationsNav.setForeground(java.awt.Color.white);
        reservationsNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        reservationsNav.setText("Reservations");
        reservationsNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reservationsNavMouseClicked(evt);
            }
        });
        jPanel1.add(reservationsNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 110, 80));

        usernameLbl.setForeground(java.awt.Color.white);
        usernameLbl.setText("@username");
        jPanel1.add(usernameLbl, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(java.awt.Color.white);
        jLabel3.setText("Hi, ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, -1, -1));

        borrowingsNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        borrowingsNav.setForeground(java.awt.Color.white);
        borrowingsNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        borrowingsNav.setText("Borrowings");
        borrowingsNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                borrowingsNavMouseClicked(evt);
            }
        });
        jPanel1.add(borrowingsNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 110, 80));

        booksNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        booksNav.setForeground(java.awt.Color.white);
        booksNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booksNav.setText("Books");
        booksNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksNavMouseClicked(evt);
            }
        });
        jPanel1.add(booksNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 60, 80));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

        booksPanel.setBackground(new java.awt.Color(32, 36, 51));
        booksPanel.setForeground(java.awt.Color.white);
        booksPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        booksTable.setBackground(new java.awt.Color(39, 45, 67));
        booksTable.setForeground(java.awt.Color.white);
        booksTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Book ID", "Title", "Author", "Category", "Stocks"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        booksTable.setRowHeight(40);
        jScrollPane2.setViewportView(booksTable);

        booksPanel.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 700, 400));

        reserveBtn.setBackground(new java.awt.Color(202, 236, 255));
        reserveBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        reserveBtn.setForeground(new java.awt.Color(0, 0, 0));
        reserveBtn.setText("Reserve");
        reserveBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reserveBtnMouseClicked(evt);
            }
        });
        booksPanel.add(reserveBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 110, 40));

        jLabel7.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Books");
        booksPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));
        booksPanel.add(searchTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 90, 190, 40));

        searchBtn1.setBackground(new java.awt.Color(202, 236, 255));
        searchBtn1.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        searchBtn1.setForeground(new java.awt.Color(0, 0, 0));
        searchBtn1.setText("Search");
        searchBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtn1MouseClicked(evt);
            }
        });
        booksPanel.add(searchBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 110, 40));

        popularBooksBtn.setText("Popular Books");
        popularBooksBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                popularBooksBtnMouseClicked(evt);
            }
        });
        booksPanel.add(popularBooksBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, 150, 40));

        getContentPane().add(booksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        reservationsPanel.setBackground(new java.awt.Color(32, 36, 51));
        reservationsPanel.setForeground(java.awt.Color.white);
        reservationsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        reservationsTable.setBackground(new java.awt.Color(39, 45, 67));
        reservationsTable.setForeground(java.awt.Color.white);
        reservationsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Reservation ID", "User ID", "Book ID", "Reservation Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        reservationsTable.setRowHeight(40);
        jScrollPane4.setViewportView(reservationsTable);

        reservationsPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 700, 460));

        jLabel11.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reservations");
        reservationsPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(reservationsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        finesPanel.setBackground(new java.awt.Color(32, 36, 51));
        finesPanel.setForeground(java.awt.Color.white);
        finesPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        finesTable.setBackground(new java.awt.Color(39, 45, 67));
        finesTable.setForeground(java.awt.Color.white);
        finesTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Fine ID", "User ID", "Borrowing ID", "Amount", "Paid"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        finesTable.setRowHeight(40);
        jScrollPane6.setViewportView(finesTable);

        finesPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 700, 460));

        jLabel13.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fines/Payments");
        finesPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(finesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        borrowingsPanel.setBackground(new java.awt.Color(32, 36, 51));
        borrowingsPanel.setForeground(java.awt.Color.white);
        borrowingsPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        borrowingsTable.setBackground(new java.awt.Color(39, 45, 67));
        borrowingsTable.setForeground(java.awt.Color.white);
        borrowingsTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Borrowing ID", "User ID", "Book ID", "Borrow Date", "Due Date", "Return Date"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        borrowingsTable.setRowHeight(40);
        jScrollPane5.setViewportView(borrowingsTable);

        borrowingsPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 100, 700, 460));

        jLabel12.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Borrows / Returns");
        borrowingsPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 260, 90));

        getContentPane().add(borrowingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void finesNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_finesNavMouseClicked
        // TODO add your handling code here:
        changePanel(finesPanel);
        loadFinesTable();
    }//GEN-LAST:event_finesNavMouseClicked

    private void reservationsNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reservationsNavMouseClicked
        // TODO add your handling code here:
        changePanel(reservationsPanel);
        loadReservationsTable();
    }//GEN-LAST:event_reservationsNavMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        Session.clearSession();
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void reserveBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reserveBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();

        int selectedRowIndex = booksTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int bookId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        User user = Session.getLoggedInUser();
        Date reservationDate = new Date();
        dbHelper.addReservation(user.getId(), bookId, reservationDate);
        changePanel(reservationsPanel);
        loadReservationsTable();
    }//GEN-LAST:event_reserveBtnMouseClicked

    private void borrowingsNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_borrowingsNavMouseClicked
        // TODO add your handling code here:
        changePanel(borrowingsPanel);
        loadBorrowingsTable();
    }//GEN-LAST:event_borrowingsNavMouseClicked

    private void booksNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_booksNavMouseClicked
        // TODO add your handling code here:                              
        changePanel(booksPanel);
        loadBooksTable();
    }//GEN-LAST:event_booksNavMouseClicked

    private void searchBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtn1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.searchBooks(searchTxt.getText());
            while (rs.next()) {
                int id = rs.getInt("book_id");
                String title = rs.getString("title");
                String author = rs.getString("author");
                String category = rs.getString("category");
                Object[] row = {id, title, author, category};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
        }
    }//GEN-LAST:event_searchBtn1MouseClicked

    private void popularBooksBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_popularBooksBtnMouseClicked
        // TODO add your handling code here:
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        ResultSet rs = dbHelper.generatePopularBooksReport();
        try {
            while (rs.next()) {
                String title = rs.getString("title");
                int borrowCount = rs.getInt("borrow_count");
                dataset.addValue(borrowCount, "Popular Books", title);
            }
        } catch (SQLException ex) {
            Logger.getLogger(HomeFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        JFreeChart chart = ChartFactory.createBarChart(
                "Popular Books Borrowed",
                "Book Title",
                "Number of Borrowings",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);
        Chart chartDialog = new Chart("Reports", chart);
        chartDialog.setVisible(true);
    }//GEN-LAST:event_popularBooksBtnMouseClicked

    
    
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
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(HomeFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new HomeFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel booksNav;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTable booksTable;
    private javax.swing.JLabel borrowingsNav;
    private javax.swing.JPanel borrowingsPanel;
    private javax.swing.JTable borrowingsTable;
    private javax.swing.JLabel finesNav;
    private javax.swing.JPanel finesPanel;
    private javax.swing.JTable finesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private com.oop2.lms.components.Button popularBooksBtn;
    private javax.swing.JLabel reservationsNav;
    private javax.swing.JPanel reservationsPanel;
    private javax.swing.JTable reservationsTable;
    private javax.swing.JButton reserveBtn;
    private javax.swing.JButton searchBtn1;
    private com.oop2.lms.components.TextField searchTxt;
    private javax.swing.JLabel usernameLbl;
    // End of variables declaration//GEN-END:variables
}
