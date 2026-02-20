package com.dbmsjdbc.jdbc.librarymanagementsystem;

import java.sql.*;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class BorrowDAO {

    // Borrow Book
    public void borrowBook(int bookId, int studentId) {

        String updateStock = "UPDATE books SET available_copies = available_copies - 1 WHERE id=? AND available_copies > 0";
        String insertRecord = "INSERT INTO borrow_records(book_id, student_id) VALUES(?,?)";

        Connection con = null;

        try {
            con = DBConnection.getConnection();
            con.setAutoCommit(false);

            PreparedStatement ps1 = con.prepareStatement(updateStock);
            ps1.setInt(1, bookId);

            int rows = ps1.executeUpdate();
            if (rows == 0) {
                System.out.println("Book not available!");
                con.rollback();
                return;
            }

            PreparedStatement ps2 = con.prepareStatement(insertRecord);
            ps2.setInt(1, bookId);
            ps2.setInt(2, studentId);
            ps2.executeUpdate();

            con.commit();
            System.out.println("Book Borrowed!");

        } catch (Exception e) {
            try { con.rollback(); } catch (Exception ex) {}
        }
    }

    // Return Book + Fine Calculation
    public void returnBook(int recordId) {

        String select = "SELECT borrow_date, book_id FROM borrow_records WHERE id=?";
        String updateReturn = "UPDATE borrow_records SET return_date=?, fine=? WHERE id=?";
        String updateStock = "UPDATE books SET available_copies = available_copies + 1 WHERE id=?";

        try (Connection con = DBConnection.getConnection()) {

            PreparedStatement ps = con.prepareStatement(select);
            ps.setInt(1, recordId);
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                System.out.println("Record not found!");
                return;
            }

            LocalDate borrowDate = LocalDate.parse(rs.getString("borrow_date"));
            LocalDate today = LocalDate.now();

            long days = ChronoUnit.DAYS.between(borrowDate, today);

            double fine = 0;
            if (days > 7) {  // 7 days free
                fine = (days - 7) * 5; // ₹5 per day
            }

            PreparedStatement ps2 = con.prepareStatement(updateReturn);
            ps2.setString(1, today.toString());
            ps2.setDouble(2, fine);
            ps2.setInt(3, recordId);
            ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(updateStock);
            ps3.setInt(1, rs.getInt("book_id"));
            ps3.executeUpdate();

            System.out.println("Returned! Fine: ₹" + fine);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}