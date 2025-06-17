import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeCrud {

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
    public static List<ServiceType> reader(){
        List<ServiceType> Tech = new ArrayList<>();
        String query = "SELECT * FROM servicetype";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("service_id");
                String servicetype = rs.getString("typename");
                String description= rs.getString("description");

                ServiceType citizen = new ServiceType(id, servicetype,description);
                Tech.add(citizen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Tech;
    }
    public static boolean deleteServiceByType(String phone){
            String query = "DELETE FROM servicetype WHERE typename = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, phone);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("ServiceType with typename '" + phone + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("ServiceType found with typename '" + phone + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean deleteServiceById(int id){
            String query = "DELETE FROM technician WHERE service_Id = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setInt(1, id);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("ServiceType with id '" + id + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No ServiceType found with id '" + id + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean updateServiceByType(String typename, String description){
    String query = "UPDATE servicetype SET description = ?, WHERE typename = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, description);
        pst.setString(2, typename);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("ServiceType with typename '" + typename + "' updated successfully.");
            return true;
        } else {
            System.out.println("No ServiceType found with typename '" + typename + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public static boolean updateServiceById(int id, String typename, String description){
    String query = "UPDATE servicetype SET typename = ?, description = ? , WHERE service_Id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, typename);
        pst.setString(2, description);
        pst.setInt(3, id);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("ServiceType with id '" + id + "' updated successfully.");
            return true;
        } else {
            System.out.println("No ServiceType found with id '" + id + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}
