package com.dbmsjdbc.jdbc.librarymanagementsystem;

import java.sql.Connection;
import java.sql.Statement;

public class DatabaseInitializer {

    public static void initialize() {

        String books = "CREATE TABLE IF NOT EXISTS books (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "title TEXT," +
                "author TEXT," +
                "category TEXT," +
                "total_copies INTEGER," +
                "available_copies INTEGER)";

        String students = "CREATE TABLE IF NOT EXISTS students (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "name TEXT)";

        String borrow = "CREATE TABLE IF NOT EXISTS borrow_records (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "book_id INTEGER," +
                "student_id INTEGER," +
                "borrow_date DATE DEFAULT CURRENT_DATE," +
                "return_date DATE," +
                "fine REAL DEFAULT 0)";

        try (Connection con = DBConnection.getConnection();
             Statement stmt = con.createStatement()) {

            stmt.execute(books);
            stmt.execute(students);
            stmt.execute(borrow);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}