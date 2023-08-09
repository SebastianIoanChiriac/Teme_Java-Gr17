package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertionTest {

    public static void main(String[] args) {
        try (Connection connection = YourDatabaseConnection.getConnection()) {
            insertData(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void insertData(Connection connection) throws SQLException {
        String accommodationInsertQuery = "INSERT INTO accommodation (id, type, bed_type, max_guests, description) VALUES (?, ?, ?, ?, ?)";
        String roomFairInsertQuery = "INSERT INTO room_fair (id, value, season) VALUES (?, ?, ?)";
        String relationInsertQuery = "INSERT INTO accommodation_room_fair_relation (id, accommodation_id, room_fair_id) VALUES (?, ?, ?)";

        try (PreparedStatement accommodationInsertStmt = connection.prepareStatement(accommodationInsertQuery);
             PreparedStatement roomFairInsertStmt = connection.prepareStatement(roomFairInsertQuery);
             PreparedStatement relationInsertStmt = connection.prepareStatement(relationInsertQuery)) {

            // Insert accommodation data
            accommodationInsertStmt.setInt(1, 1);
            accommodationInsertStmt.setString(2, "Hotel Room");
            accommodationInsertStmt.setString(3, "Queen Bed");
            accommodationInsertStmt.setInt(4, 2);
            accommodationInsertStmt.setString(5, "Cozy room with a view");
            accommodationInsertStmt.executeUpdate();

            // Insert room fair data
            roomFairInsertStmt.setInt(1, 1);
            roomFairInsertStmt.setDouble(2, 150.0);
            roomFairInsertStmt.setString(3, "Summer");
            roomFairInsertStmt.executeUpdate();

            // Insert relation data
            relationInsertStmt.setInt(1, 1);
            relationInsertStmt.setInt(2, 1);
            relationInsertStmt.setInt(3, 1);
            relationInsertStmt.executeUpdate();
        }
    }
}
