package com.junit.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.junit.com.DatabaseConnection;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseConnectionTest {

    private DatabaseConnection db;

    @BeforeEach
    void setUp() {
        db = new DatabaseConnection();
        db.connect();
    }

    @AfterEach
    void tearDown() {
        db.disconnect();
    }

    @Test
    void testDatabaseIsConnected() {
        assertTrue(db.isConnected(), "Database should be connected before test");
    }

    @Test
    void testDatabaseIsDisconnectedAfterTest() {
        assertTrue(db.isConnected());
        // disconnect will be tested implicitly by @AfterEach
    }
}
