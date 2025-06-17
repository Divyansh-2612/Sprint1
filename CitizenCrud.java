import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CitizenCrud{

    public static void insertCitizen(Citizen citizen) throws ClassNotFoundException {
        String query = "INSERT INTO Citizen (citizen_id, name, email, phone, address) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {

            stmt.setInt(1, citizen.getId());
            stmt.setString(2, citizen.getName());
            stmt.setString(3, citizen.getEmail());
            stmt.setString(4, citizen.getPhone());
            stmt.setString(5, citizen.getAddress());

            int rowsInserted = stmt.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("✅ Citizen inserted successfully.");
            } else {
                System.out.println("⚠️ Citizen insertion failed.");
            }

        } catch (SQLException e) {
            System.err.println("❌ Error inserting citizen: " + e.getMessage());
        }
    }
    public static List<Citizen> reader(){
        List<Citizen> citizens = new ArrayList<>();
        String query = "SELECT * FROM citizen";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement pst = con.prepareStatement(query);
             ResultSet rs = pst.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("citizen_id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String phone = rs.getString("phone");
                String address = rs.getString("address");

                Citizen citizen = new Citizen(id, name, phone, email, address);
                citizens.add(citizen);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return citizens;
    }
     public static boolean deleteCitizenByEmail(String email) {
            String query = "DELETE FROM citizen WHERE email = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, email);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Citizen with email '" + email + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No citizen found with email '" + email + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean deleteCitizenByPhone(String phone){
            String query = "DELETE FROM citizen WHERE phone = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setString(1, phone);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Citizen with phone '" + phone + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No citizen found with phone '" + phone + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
        public static boolean deleteCitizenById(int id){
            String query = "DELETE FROM citizen WHERE citizen_Id = ?";

            try (Connection con = DBConnection.getConnection();
                PreparedStatement pst = con.prepareStatement(query)) {

                pst.setInt(1, id);
                int rowsDeleted = pst.executeUpdate();

                if (rowsDeleted > 0) {
                    System.out.println("Citizen with id '" + id + "' deleted successfully.");
                    return true;
                } else {
                    System.out.println("No citizen found with id '" + id + "'.");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            return false;
        }
    public static boolean updateCitizenByEmail(String email, String newName, String newPhoneNumber, String newAddress) {
    String query = "UPDATE citizen SET name = ?, phone = ?, address = ? WHERE email = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, newName);
        pst.setString(2, newPhoneNumber);
        pst.setString(3, newAddress);
        pst.setString(4, email);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Citizen with email '" + email + "' updated successfully.");
            return true;
        } else {
            System.out.println("No citizen found with email '" + email + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public static boolean updateCitizenByPhone(String email, String newName, String newPhoneNumber, String newAddress){
    String query = "UPDATE citizen SET name = ?, email = ?, address = ? WHERE phone = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, newName);
        pst.setString(2, email);
        pst.setString(3, newAddress);
        pst.setString(4, newPhoneNumber);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Citizen with phone '" + newPhoneNumber + "' updated successfully.");
            return true;
        } else {
            System.out.println("No citizen found with phone '" + newPhoneNumber + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}
public static boolean updateCitizenById(int id,String email, String newName, String newPhoneNumber, String newAddress){
    String query = "UPDATE citizen SETname = ?, phone = ?, address = ? ,email =? WHERE citizen_Id = ?";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement pst = con.prepareStatement(query)) {

        pst.setString(1, newName);
        pst.setString(2, newPhoneNumber);
        pst.setString(3, newAddress);
        pst.setString(4, email);
        pst,setInt(5,id);

        int rowsUpdated = pst.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Citizen with id '" + id + "' updated successfully.");
            return true;
        } else {
            System.out.println("No citizen found with id '" + id + "'.");
        }

    } catch (Exception e) {
        e.printStackTrace();
    }

    return false;
}

}
