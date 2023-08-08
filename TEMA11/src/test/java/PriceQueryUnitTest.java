import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PriceQueryUnitTest {

    public static void main(String[] args) {
        try (Connection connection = YourDatabaseConnection.getConnection()) {
            queryAndPrintRoomPrices(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void queryAndPrintRoomPrices(Connection connection) throws SQLException {
        String query = "SELECT a.type, rf.value, rf.season FROM accommodation a " +
                "JOIN accommodation_room_fair_relation arfr ON a.id = arfr.accommodation_id " +
                "JOIN room_fair rf ON arfr.room_fair_id = rf.id";

        try (PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                String roomType = resultSet.getString("type");
                double roomPrice = resultSet.getDouble("value");
                String season = resultSet.getString("season");
                System.out.println("Room Type: " + roomType + ", Price: " + roomPrice + " (" + season + ")");
            }
        }
    }
}
