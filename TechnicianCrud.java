import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TechnicianCrud {

    public static void insertTechnician(Technician technician) {
        String query = "INSERT INTO Technician (technician_id, name, phone, skillset) VALUES (?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, technician.getId());
            stmt.setString(2, technician.getName());
            stmt.setString(3, technician.getPhone());
            stmt.setString(4, technician.getSkillset());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Technician inserted successfully.");
            } else {
                System.out.println("⚠️ Technician insertion failed.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error inserting technician: " + e.getMessage());
        }
    }
    public static List<Technician> reader(){
        List<Technician> Tech = new ArrayList<>();
        String query = "SELECT * FROM technician";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("technician_id");
                String name = rs.getString("name");
                String phone = rs.getString("phone");
                String skillset = rs.getString("skillset");

                Technician citizen = new Technician(id, name, phone, skillset);
                Tech.add(citizen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return Tech;
    }
    public static boolean deleteTechnicianByPhone(String phone){
            String query = "DELETE FROM technician WHERE phone = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, phone);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Technician with phone '" + phone + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No Technician found with phone '" + phone + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean deleteTechnicianById(int id){
            String query = "DELETE FROM technician WHERE technician_Id = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setInt(1, id);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Technician with id '" + id + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No Technician found with id '" + id + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean updateTechnicianByPhone(String newName, String newPhoneNumber, String skillset){
    String query = "UPDATE technician SET name = ?, skillset = ? WHERE phone = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, newName);
        pst.setString(2, skillset);
        pst.setString(3, newPhoneNumber);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Technician with phone '" + newPhoneNumber + "' updated successfully.");
            return true;
        } else {
            System.out.println("No Technician found with phone '" + newPhoneNumber + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public static boolean updateTechnicianById(int id, String newName, String newPhoneNumber, String skillset){
    String query = "UPDATE citizen SET name = ?, phone = ?, skillset = ? , WHERE citizen_Id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, newName);
        pst.setString(2, newPhoneNumber);
        pst.setString(3, skillset);
        pst.setInt(4, id);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Technician with id '" + id + "' updated successfully.");
            return true;
        } else {
            System.out.println("No Technician found with id '" + id + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
}
