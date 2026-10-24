package org.mediatracker;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseManager {
    private static final String URL = "jdbc:sqlite:media-tracker.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void createTable() {
        String sql = """
            CREATE TABLE IF NOT EXISTS media (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                title TEXT NOT NULL,
                type TEXT NOT NULL,
                status TEXT NOT NULL,
                rating REAL NOT NULL CHECK (rating >= 0 AND rating <= 10)
            );
            """;

        try (Connection connection = connect();
             var statement = connection.createStatement()) {

            statement.execute(sql);
            System.out.println("Media table is ready.");
        } catch (java.sql.SQLException e) {
            System.out.println("Could not create media table.");
            e.printStackTrace();
        }
    }
}
