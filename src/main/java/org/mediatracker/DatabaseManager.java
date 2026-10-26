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
        } catch (SQLException e) {
            System.out.println("Could not create media table.");
            e.printStackTrace();
        }
    }

    public static void insertTestMedia() {
        String sql = """
                INSERT INTO media (title, type, status, rating)
                VALUES (?, ?, ?, ?);
                """;

        try (Connection connection = connect();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, "One Piece");
            statement.setString(2, "Manga");
            statement.setString(3, "Reading");
            statement.setDouble(4, 9.5);

            statement.executeUpdate();
            System.out.println("Test media inserted succesfully.");
        } catch (SQLException e) {
            System.out.println("Could not insert test media.");
            e.printStackTrace();
        }
    }

    public static void readAllMedia() {
        String sql = "SELECT id, title, type, status, rating FROM media;";

        try (Connection connection = connect();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String type = resultSet.getString("type");
                String status = resultSet.getString("status");
                double rating = resultSet.getDouble("rating");

                System.out.println(
                        id + ": " + title + " | " + type + " | "
                                + status + " | Rating: " + rating
                );
            }
        } catch (SQLException e) {
            System.out.println("Could not read media.");
            e.printStackTrace();
        }
    }

    public static void saveMedia(Media media) {
        String sql = """
                INSERT INTO media (title, type, status, rating)
                VALUES (?, ?, ?, ?);
                """;

        try (Connection connection = connect();
             var statement = connection.prepareStatement(sql)) {

            statement.setString(1, media.getTitle());
            statement.setString(2, media.getType());
            statement.setString(3, media.getStatus());
            statement.setDouble(4, media.getRating());

            statement.executeUpdate();
            System.out.println("Media saved to database.");
        } catch (SQLException e) {
            System.out.println("Could not save media.");
            e.printStackTrace();
        }
    }

    public static void loadMedia(MediaLibrary library) {
        String sql = "SELECT title, type, status, rating FROM media;";

        try (Connection connection = connect();
             var statement = connection.createStatement();
             var resultSet = statement.executeQuery(sql)) {

            while (resultSet.next()) {
                String title = resultSet.getString("title");
                String type = resultSet.getString("type");
                String status = resultSet.getString("status");
                double rating = resultSet.getDouble("rating");

                Media media = new Media (title, type, status, rating);
                library.addMedia(media);
            }

            System.out.println("Media loaded from database.");
        } catch (SQLException e) {
            System.out.println("Could not load media.");
            e.printStackTrace();
        }
    }
}
