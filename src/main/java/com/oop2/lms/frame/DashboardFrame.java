/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.oop2.lms.frame;

import com.oop2.lms.components.Chart;
import com.oop2.lms.db.DbHelper;
import com.oop2.lms.util.Session;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
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
public class DashboardFrame extends javax.swing.JFrame {

    private final DbHelper dbHelper;

    /**
     * Creates new form DashboardFrame
     */
    public DashboardFrame() {
        initComponents();
        dbHelper = new DbHelper();
        changePanel(usersPanel);
        loadUsersTable();
        usernameLbl.setText(Session.getLoggedInUser().getUsername());
    }

    public void changePanel(JPanel newPanel) {
        JPanel jPanels[] = {booksPanel, usersPanel, borrowingsPanel, reservationsPanel, finesPanel};
        for (JPanel currPanel : jPanels) {
            if (currPanel == newPanel) {
                newPanel.setVisible(true);
            } else {
                currPanel.setVisible(false);
            }
        }
    }

    public void loadUsersTable() {
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();
        model.setRowCount(0);
        try {
            ResultSet rs = dbHelper.getUsers();
            while (rs.next()) {
                int id = rs.getInt("user_id");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String role = rs.getString("role");
                Object[] row = {id, username, password, role};
                model.addRow(row);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage());
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
            ResultSet rs = dbHelper.getReservations();
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
            ResultSet rs = dbHelper.getBorrowings();
            while (rs.next()) {
                int id = rs.getInt("borrowing_id");
                int userId = rs.getInt("user_id");
                int bookId = rs.getInt("book_id");
                Date borrowDate = rs.getDate("borrow_date");
                Date dueDate = rs.getDate("due_date");
                Date returnDate = rs.getDate("return_date");
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                String returnDateFormatted = null;
                if (returnDate != null) {
                    returnDateFormatted = sdf.format(returnDate);
                }
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
            ResultSet rs = dbHelper.getFines();
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

        borrowingsPanel = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        borrowingsTable = new javax.swing.JTable();
        returnBorrowBtn = new javax.swing.JButton();
        addBorrowBtn = new javax.swing.JButton();
        deleteBorrowBtn = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        updateBorrowBtn1 = new javax.swing.JButton();
        booksPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        booksTable = new javax.swing.JTable();
        updateBookBtn = new javax.swing.JButton();
        addBookBtn = new javax.swing.JButton();
        deleteBookBtn = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        usersNav = new javax.swing.JLabel();
        finesNav = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        reservationsNav = new javax.swing.JLabel();
        usernameLbl = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        borrowingsNav = new javax.swing.JLabel();
        booksNav = new javax.swing.JLabel();
        reportsBtn = new com.oop2.lms.components.Button();
        finesPanel = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        finesTable = new javax.swing.JTable();
        paidBtn = new javax.swing.JButton();
        deleteFinesBtn = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        reservationsPanel = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        reservationsTable = new javax.swing.JTable();
        updateReservationsBtn = new javax.swing.JButton();
        addReservationsBtn = new javax.swing.JButton();
        deleteReservationsBtn = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        usersPanel = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        usersTable = new javax.swing.JTable();
        updateUserBtn = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        deleteUserBtn = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        borrowingsPanel.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 700, 400));

        returnBorrowBtn.setBackground(new java.awt.Color(154, 183, 141));
        returnBorrowBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        returnBorrowBtn.setForeground(new java.awt.Color(0, 0, 0));
        returnBorrowBtn.setText("RETURN");
        returnBorrowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                returnBorrowBtnMouseClicked(evt);
            }
        });
        borrowingsPanel.add(returnBorrowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 90, 110, 40));

        addBorrowBtn.setBackground(new java.awt.Color(209, 202, 255));
        addBorrowBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        addBorrowBtn.setForeground(new java.awt.Color(0, 0, 0));
        addBorrowBtn.setText("ADD");
        addBorrowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBorrowBtnMouseClicked(evt);
            }
        });
        borrowingsPanel.add(addBorrowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 40));

        deleteBorrowBtn.setBackground(new java.awt.Color(255, 202, 202));
        deleteBorrowBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        deleteBorrowBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteBorrowBtn.setText("DELETE");
        deleteBorrowBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBorrowBtnMouseClicked(evt);
            }
        });
        borrowingsPanel.add(deleteBorrowBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 90, 110, 40));

        jLabel12.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel12.setForeground(java.awt.Color.white);
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Borrows / Returns");
        borrowingsPanel.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 0, 260, 90));

        updateBorrowBtn1.setBackground(new java.awt.Color(202, 236, 255));
        updateBorrowBtn1.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        updateBorrowBtn1.setForeground(new java.awt.Color(0, 0, 0));
        updateBorrowBtn1.setText("UPDATE");
        updateBorrowBtn1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBorrowBtn1MouseClicked(evt);
            }
        });
        borrowingsPanel.add(updateBorrowBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, 110, 40));

        getContentPane().add(borrowingsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

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

        updateBookBtn.setBackground(new java.awt.Color(202, 236, 255));
        updateBookBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        updateBookBtn.setForeground(new java.awt.Color(0, 0, 0));
        updateBookBtn.setText("UPDATE");
        updateBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateBookBtnMouseClicked(evt);
            }
        });
        booksPanel.add(updateBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, 40));

        addBookBtn.setBackground(new java.awt.Color(209, 202, 255));
        addBookBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        addBookBtn.setForeground(new java.awt.Color(0, 0, 0));
        addBookBtn.setText("ADD");
        addBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addBookBtnMouseClicked(evt);
            }
        });
        booksPanel.add(addBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 40));

        deleteBookBtn.setBackground(new java.awt.Color(255, 202, 202));
        deleteBookBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        deleteBookBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteBookBtn.setText("DELETE");
        deleteBookBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBookBtnMouseClicked(evt);
            }
        });
        booksPanel.add(deleteBookBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 110, 40));

        jLabel7.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel7.setForeground(java.awt.Color.white);
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Books");
        booksPanel.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(booksPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        jPanel1.setBackground(new java.awt.Color(39, 45, 67));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        usersNav.setForeground(java.awt.Color.white);
        usersNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usersNav.setText("Users");
        usersNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                usersNavMouseClicked(evt);
            }
        });
        jPanel1.add(usersNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 60, 80));

        finesNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        finesNav.setForeground(java.awt.Color.white);
        finesNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        finesNav.setText("Fines");
        finesNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                finesNavMouseClicked(evt);
            }
        });
        jPanel1.add(finesNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 0, 60, 80));

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
        jPanel1.add(reservationsNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 110, 80));

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
        jPanel1.add(borrowingsNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 0, 110, 80));

        booksNav.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 14)); // NOI18N
        booksNav.setForeground(java.awt.Color.white);
        booksNav.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        booksNav.setText("Books");
        booksNav.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                booksNavMouseClicked(evt);
            }
        });
        jPanel1.add(booksNav, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 0, 60, 80));

        reportsBtn.setText("Show Reports");
        reportsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                reportsBtnMouseClicked(evt);
            }
        });
        jPanel1.add(reportsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 20, 120, 40));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1000, 80));

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

        finesPanel.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 700, 400));

        paidBtn.setBackground(new java.awt.Color(202, 236, 255));
        paidBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        paidBtn.setForeground(new java.awt.Color(0, 0, 0));
        paidBtn.setText("PAID");
        paidBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                paidBtnMouseClicked(evt);
            }
        });
        finesPanel.add(paidBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, 40));

        deleteFinesBtn.setBackground(new java.awt.Color(255, 202, 202));
        deleteFinesBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        deleteFinesBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteFinesBtn.setText("DELETE");
        deleteFinesBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteFinesBtnMouseClicked(evt);
            }
        });
        finesPanel.add(deleteFinesBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 40));

        jLabel13.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel13.setForeground(java.awt.Color.white);
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Fines/Payments");
        finesPanel.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(finesPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

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

        reservationsPanel.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 700, 400));

        updateReservationsBtn.setBackground(new java.awt.Color(202, 236, 255));
        updateReservationsBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        updateReservationsBtn.setForeground(new java.awt.Color(0, 0, 0));
        updateReservationsBtn.setText("UPDATE");
        updateReservationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateReservationsBtnMouseClicked(evt);
            }
        });
        reservationsPanel.add(updateReservationsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, 40));

        addReservationsBtn.setBackground(new java.awt.Color(209, 202, 255));
        addReservationsBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        addReservationsBtn.setForeground(new java.awt.Color(0, 0, 0));
        addReservationsBtn.setText("ADD");
        addReservationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addReservationsBtnMouseClicked(evt);
            }
        });
        reservationsPanel.add(addReservationsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 40));

        deleteReservationsBtn.setBackground(new java.awt.Color(255, 202, 202));
        deleteReservationsBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        deleteReservationsBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteReservationsBtn.setText("DELETE");
        deleteReservationsBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteReservationsBtnMouseClicked(evt);
            }
        });
        reservationsPanel.add(deleteReservationsBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 110, 40));

        jLabel11.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel11.setForeground(java.awt.Color.white);
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Reservations");
        reservationsPanel.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(reservationsPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        usersPanel.setBackground(new java.awt.Color(32, 36, 51));
        usersPanel.setForeground(java.awt.Color.white);
        usersPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usersTable.setBackground(new java.awt.Color(39, 45, 67));
        usersTable.setForeground(java.awt.Color.white);
        usersTable.setModel(new javax.swing.table.DefaultTableModel(
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
                "User ID", "Username", "Password", "Role"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        usersTable.setRowHeight(40);
        jScrollPane3.setViewportView(usersTable);

        usersPanel.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 700, 400));

        updateUserBtn.setBackground(new java.awt.Color(202, 236, 255));
        updateUserBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        updateUserBtn.setForeground(new java.awt.Color(0, 0, 0));
        updateUserBtn.setText("UPDATE");
        updateUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                updateUserBtnMouseClicked(evt);
            }
        });
        usersPanel.add(updateUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 90, 110, 40));

        jButton8.setBackground(new java.awt.Color(209, 202, 255));
        jButton8.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        jButton8.setForeground(new java.awt.Color(0, 0, 0));
        jButton8.setText("ADD");
        jButton8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton8MouseClicked(evt);
            }
        });
        usersPanel.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 110, 40));

        deleteUserBtn.setBackground(new java.awt.Color(255, 202, 202));
        deleteUserBtn.setFont(new java.awt.Font("JetBrains Mono SemiBold", 0, 14)); // NOI18N
        deleteUserBtn.setForeground(new java.awt.Color(0, 0, 0));
        deleteUserBtn.setText("DELETE");
        deleteUserBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteUserBtnMouseClicked(evt);
            }
        });
        usersPanel.add(deleteUserBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 90, 110, 40));

        jLabel10.setFont(new java.awt.Font("JetBrains Mono SemiBold", 1, 24)); // NOI18N
        jLabel10.setForeground(java.awt.Color.white);
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("Users");
        usersPanel.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 0, 230, 90));

        getContentPane().add(usersPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 1000, 620));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void usersNavMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_usersNavMouseClicked
        // TODO add your handling code here:
        changePanel(usersPanel);
        loadUsersTable();
    }//GEN-LAST:event_usersNavMouseClicked

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

    private void jButton8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton8MouseClicked
        // TODO add your handling code here:
        AddUserFrame addUserFrame = new AddUserFrame();
        addUserFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton8MouseClicked

    private void deleteUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteUserBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();

        int selectedRowIndex = usersTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int userId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.deleteUser(userId);
        loadUsersTable();
    }//GEN-LAST:event_deleteUserBtnMouseClicked

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        LoginFrame loginFrame = new LoginFrame();
        loginFrame.setVisible(true);
        Session.clearSession();
        dispose();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void updateUserBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateUserBtnMouseClicked
        // TODO add your handling code here:

        DefaultTableModel model = (DefaultTableModel) usersTable.getModel();

        int selectedRowIndex = usersTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int userId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        UpdateUserFrame updateUserFrame = new UpdateUserFrame();
        updateUserFrame.loadUser(userId);
        updateUserFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_updateUserBtnMouseClicked

    private void addBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBookBtnMouseClicked
        // TODO add your handling code here:
        AddBookFrame addBookFrame = new AddBookFrame();
        addBookFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_addBookBtnMouseClicked

    private void deleteBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBookBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();

        int selectedRowIndex = booksTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int bookId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.deleteBook(bookId);
        loadBooksTable();
    }//GEN-LAST:event_deleteBookBtnMouseClicked

    private void updateBookBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBookBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) booksTable.getModel();

        int selectedRowIndex = booksTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int bookId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        UpdateBookFrame updateBookFrame = new UpdateBookFrame();
        updateBookFrame.loadBook(bookId);
        updateBookFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_updateBookBtnMouseClicked

    private void addReservationsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addReservationsBtnMouseClicked
        // TODO add your handling code here:
        AddReservationFrame addReservationFrame = new AddReservationFrame();
        addReservationFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_addReservationsBtnMouseClicked

    private void deleteReservationsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteReservationsBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) reservationsTable.getModel();

        int selectedRowIndex = reservationsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int reservationId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.deleteReservation(reservationId);
        loadReservationsTable();
    }//GEN-LAST:event_deleteReservationsBtnMouseClicked

    private void updateReservationsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateReservationsBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) reservationsTable.getModel();

        int selectedRowIndex = reservationsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int reservationId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        UpdateReservationFrame updateReservationFrame = new UpdateReservationFrame();
        updateReservationFrame.loadReservation(reservationId);
        updateReservationFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_updateReservationsBtnMouseClicked

    private void addBorrowBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addBorrowBtnMouseClicked
        // TODO add your handling code here:
        AddBorrowingFrame addBorrowingFrame = new AddBorrowingFrame();
        addBorrowingFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_addBorrowBtnMouseClicked

    private void deleteBorrowBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBorrowBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) borrowingsTable.getModel();

        int selectedRowIndex = borrowingsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int borrowingId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.deleteBorrowing(borrowingId);
        loadBorrowingsTable();
    }//GEN-LAST:event_deleteBorrowBtnMouseClicked

    private void returnBorrowBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_returnBorrowBtnMouseClicked
        // TODO add your handling code here:  
        DefaultTableModel model = (DefaultTableModel) borrowingsTable.getModel();

        int selectedRowIndex = borrowingsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int borrowingId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.setReturnNow(borrowingId);
        loadBorrowingsTable();
    }//GEN-LAST:event_returnBorrowBtnMouseClicked

    private void updateBorrowBtn1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_updateBorrowBtn1MouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) borrowingsTable.getModel();

        int selectedRowIndex = borrowingsTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int borrowingId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        UpdateBorrowingFrame updateBorrowingFrame = new UpdateBorrowingFrame();
        updateBorrowingFrame.loadBorrowing(borrowingId);
        updateBorrowingFrame.setVisible(true);
        dispose();
    }//GEN-LAST:event_updateBorrowBtn1MouseClicked

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

    private void paidBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_paidBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) finesTable.getModel();

        int selectedRowIndex = finesTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int fineId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.updateFineStatus(fineId, true);
        loadFinesTable();
    }//GEN-LAST:event_paidBtnMouseClicked

    private void deleteFinesBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteFinesBtnMouseClicked
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) finesTable.getModel();

        int selectedRowIndex = finesTable.getSelectedRow();
        if (selectedRowIndex == -1) {
            return;
        }

        int fineId = Integer.parseInt(model.getValueAt(selectedRowIndex, 0).toString());
        dbHelper.deleteFine(fineId);
        loadFinesTable();
    }//GEN-LAST:event_deleteFinesBtnMouseClicked

    private void reportsBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_reportsBtnMouseClicked
        // TODO add your handling code here:
        Map<Integer, Integer> monthCounts = new HashMap<>();
        ResultSet rs = dbHelper.generateBorrowingReport();
        try {
            while (rs.next()) {
                int month = rs.getInt("month");
                int count = rs.getInt("count");
                monthCounts.put(month, count);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DashboardFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        // Add data to the dataset
        for (int i = 1; i <= 12; i++) {
            int count = monthCounts.getOrDefault(i, 0);
            dataset.addValue(count, "Borrowings", getMonthName(i));
        }
        JFreeChart chart = ChartFactory.createBarChart(
                "Borrowings per Month",
                "Month",
                "Number of Borrowings",
                dataset,
                org.jfree.chart.plot.PlotOrientation.VERTICAL,
                true, true, false);
        Chart chartDialog = new Chart("Reports", chart);
        chartDialog.setVisible(true);
    }//GEN-LAST:event_reportsBtnMouseClicked

    // Helper method to get month name from its number
    private String getMonthName(int month) {
        return switch (month) {
            case 1 -> "Jan";
            case 2 -> "Feb";
            case 3 -> "Mar";
            case 4 -> "Apr";
            case 5 -> "May";
            case 6 -> "Jun";
            case 7 -> "Jul";
            case 8 -> "Aug";
            case 9 -> "Sept";
            case 10 -> "Oct";
            case 11 -> "Nov";
            case 12 -> "Dec";
            default -> "";
        };
    }
    
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
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DashboardFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DashboardFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBookBtn;
    private javax.swing.JButton addBorrowBtn;
    private javax.swing.JButton addReservationsBtn;
    private javax.swing.JLabel booksNav;
    private javax.swing.JPanel booksPanel;
    private javax.swing.JTable booksTable;
    private javax.swing.JLabel borrowingsNav;
    private javax.swing.JPanel borrowingsPanel;
    private javax.swing.JTable borrowingsTable;
    private javax.swing.JButton deleteBookBtn;
    private javax.swing.JButton deleteBorrowBtn;
    private javax.swing.JButton deleteFinesBtn;
    private javax.swing.JButton deleteReservationsBtn;
    private javax.swing.JButton deleteUserBtn;
    private javax.swing.JLabel finesNav;
    private javax.swing.JPanel finesPanel;
    private javax.swing.JTable finesTable;
    private javax.swing.JButton jButton8;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JButton paidBtn;
    private com.oop2.lms.components.Button reportsBtn;
    private javax.swing.JLabel reservationsNav;
    private javax.swing.JPanel reservationsPanel;
    private javax.swing.JTable reservationsTable;
    private javax.swing.JButton returnBorrowBtn;
    private javax.swing.JButton updateBookBtn;
    private javax.swing.JButton updateBorrowBtn1;
    private javax.swing.JButton updateReservationsBtn;
    private javax.swing.JButton updateUserBtn;
    private javax.swing.JLabel usernameLbl;
    private javax.swing.JLabel usersNav;
    private javax.swing.JPanel usersPanel;
    private javax.swing.JTable usersTable;
    // End of variables declaration//GEN-END:variables
}
