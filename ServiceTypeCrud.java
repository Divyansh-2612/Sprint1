import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServiceTypeDAO {

    public static void insertServiceType(ServiceType serviceType) {
        String query = "INSERT INTO ServiceType (service_type_id, service_name, description) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, serviceType.getId());
            stmt.setString(2, serviceType.getTypeName());
            stmt.setString(3, serviceType.getDescription());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Service type inserted successfully.");
            } else {
                System.out.println("⚠️ Insertion failed.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error inserting service type: " + e.getMessage());
        }
    }
}
