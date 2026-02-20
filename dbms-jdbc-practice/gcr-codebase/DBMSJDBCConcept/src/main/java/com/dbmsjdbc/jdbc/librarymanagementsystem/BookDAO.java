package com.dbmsjdbc.jdbc.librarymanagementsystem;

import java.sql.*;

public class BookDAO {

    // Add Book
    public void addBook(String title, String author, String category, int copies) {

        String sql = "INSERT INTO books(title, author, category, total_copies, available_copies) VALUES(?,?,?,?,?)";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, title);
            ps.setString(2, author);
            ps.setString(3, category);
            ps.setInt(4, copies);
            ps.setInt(5, copies);

            ps.executeUpdate();
            System.out.println("Book Added!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Search with Multiple Filters
    public void searchBooks(String title, String author, String category) {

        StringBuilder sql = new StringBuilder("SELECT * FROM books WHERE 1=1");

        if (title != null && !title.isEmpty())
            sql.append(" AND title LIKE ?");
        if (author != null && !author.isEmpty())
            sql.append(" AND author LIKE ?");
        if (category != null && !category.isEmpty())
            sql.append(" AND category LIKE ?");

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql.toString())) {

            int index = 1;

            if (title != null && !title.isEmpty())
                ps.setString(index++, "%" + title + "%");
            if (author != null && !author.isEmpty())
                ps.setString(index++, "%" + author + "%");
            if (category != null && !category.isEmpty())
                ps.setString(index++, "%" + category + "%");

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("title") + " | " +
                        rs.getString("author") + " | " +
                        rs.getString("available_copies"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}