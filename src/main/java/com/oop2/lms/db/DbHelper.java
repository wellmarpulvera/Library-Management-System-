/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.oop2.lms.db;

import com.oop2.lms.model.User;
import com.oop2.lms.util.Session;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Cabigas
 */
public class DbHelper {

    public Connection connection;

    public DbHelper() {
        try {
            connection = MySQLConnection.getConnection();
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ResultSet authenticate(String username, String password) {
        try {
            String sql = "SELECT * FROM Users WHERE username = ? AND `password` = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            statement.setString(2, password);
            return statement.executeQuery();
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ResultSet getUsers() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Users";
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void addUser(String username, String password, String role) {
        try {
            String query = "INSERT INTO users (username, `password`, `role`) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, role);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteUser(int id) {
        try {
            String query = "DELETE FROM users WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateUser(int userId, String username, String password, String role) {
        try {
            String query = "UPDATE users SET username = ?, `password` = ?, `role` = ? WHERE user_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, password);
                preparedStatement.setString(3, role);
                preparedStatement.setInt(4, userId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getUser(int userId) {
        try {
            String query = "SELECT * FROM users WHERE user_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, userId);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getBooks() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Books";
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void addBook(String title, String author, String category, int stocks) {
        try {
            String query = "INSERT INTO Books (title, author, category, stocks) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, category);
                preparedStatement.setInt(4, stocks);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBook(int id) {
        try {
            String query = "DELETE FROM Books WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBook(int bookId, String title, String author, String category, int stocks) {
        try {
            String query = "UPDATE Books SET title = ?, author = ?, category = ?, stocks = ? WHERE book_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setString(1, title);
                preparedStatement.setString(2, author);
                preparedStatement.setString(3, category);
                preparedStatement.setInt(4, stocks);
                preparedStatement.setInt(5, bookId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getBook(int bookId) {
        try {
            String query = "SELECT * FROM Books WHERE book_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, bookId);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getReservations() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Reservations";
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void addReservation(int userId, int bookId, Date reservation) {
        try {
            String query = "INSERT INTO Reservations (user_id, book_id, reservation_date) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, bookId);
                java.sql.Date sqlReservation = new java.sql.Date(reservation.getTime());
                preparedStatement.setDate(3, sqlReservation);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteReservation(int id) {
        try {
            String query = "DELETE FROM Reservations WHERE reservation_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateReservation(int reservationId, int userId, int bookId, Date reservation) {
        try {
            String query = "UPDATE Reservations SET user_id = ?, book_id = ?, reservation_date = ? WHERE reservation_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, bookId);
                java.sql.Date sqlReservation = new java.sql.Date(reservation.getTime());
                preparedStatement.setDate(3, sqlReservation);
                preparedStatement.setInt(4, reservationId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getReservation(int reservationId) {
        try {
            String query = "SELECT * FROM Reservations WHERE reservation_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, reservationId);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ResultSet getBorrowings() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Borrowings";
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void addBorrowing(int userId, int bookId, Date dueDate) {
        try {
            String query = "INSERT INTO Borrowings (user_id, book_id, due_date) VALUES (?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, bookId);
                java.sql.Date sqlDueDate = new java.sql.Date(dueDate.getTime());
                preparedStatement.setDate(3, sqlDueDate);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void deleteBorrowing(int id) {
        try {
            String query = "DELETE FROM Borrowings WHERE borrowing_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, id);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateBorrowing(int borrowingId, int userId, int bookId, Date dueDate) {
        try {
            String query = "UPDATE Borrowings SET user_id = ?, book_id = ?, due_date = ? WHERE borrowing_id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, userId);
                preparedStatement.setInt(2, bookId);
                java.sql.Date sqlDueDate = new java.sql.Date(dueDate.getTime());
                preparedStatement.setDate(3, sqlDueDate);
                preparedStatement.setInt(4, borrowingId);
                preparedStatement.executeUpdate();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getBorrowing(int borrowingId) {
        try {
            String query = "SELECT * FROM Borrowings WHERE borrowing_id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, borrowingId);
            return preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setReturnNow(int borrowingId) {
        try {
            String query = "{CALL return_now(?)}";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, borrowingId);
            preparedStatement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ResultSet getFines() {
        try {
            Statement stmt = connection.createStatement();
            String sql = "SELECT * FROM Fines";
            return stmt.executeQuery(sql);
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public void deleteFine(int fineId) {
        try {
            String sql = "DELETE FROM Fines WHERE fine_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setInt(1, fineId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public void updateFineStatus(int fineId, boolean paidStatus) {
        try {
            String sql = "UPDATE Fines SET paid = ? WHERE fine_id = ?";
            try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
                pstmt.setBoolean(1, paidStatus);
                pstmt.setInt(2, fineId);
                pstmt.executeUpdate();
            }
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    public ResultSet searchBooks(String searchQuery) {
        try {
            CallableStatement callableStatement = connection.prepareCall("{CALL searchBooks(?)}");
            callableStatement.setString(1, searchQuery);

            // Execute the stored procedure
            return callableStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ResultSet getUserReservations() {
        User user = Session.getLoggedInUser();
        try {
            String sql = "SELECT * FROM Reservations WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            return pstmt.executeQuery(); // Execute a query and return the result set
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }

    public ResultSet getUserBorrowings() {
        User user = Session.getLoggedInUser();
        try {
            String sql = "SELECT * FROM Borrowings WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            return pstmt.executeQuery(); // Execute a query and return the result set
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ResultSet getUserFines() {
        User user = Session.getLoggedInUser();
        try {
            String sql = "SELECT * FROM Fines WHERE user_id = ?";
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setInt(1, user.getId());
            return pstmt.executeQuery(); // Execute a query and return the result set
        } catch (SQLException e) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    
    public ResultSet generateBorrowingReport(){
        try {
            String query = "SELECT MONTH(borrow_date) AS month, COUNT(*) AS count " +
                    "FROM borrowings " +
                    "GROUP BY MONTH(borrow_date)";

            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public ResultSet generatePopularBooksReport(){
        try {
           String query = "SELECT b.title, COUNT(*) AS borrow_count " +
                    "FROM borrowings br " +
                    "INNER JOIN books b ON br.book_id = b.book_id " +
                    "GROUP BY br.book_id " +
                    "ORDER BY borrow_count DESC LIMIT 5"; // Limit to top 5 popular books

            PreparedStatement statement = connection.prepareStatement(query);
            return statement.executeQuery();
        } catch (SQLException ex) {
            Logger.getLogger(DbHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
