import java.sql.*;
public class DBOracleConnection {
    

        public static void getConnect(Citizen citizen){
        try {
            System.out.println("Enter ");
            Class.forName("oracle.jdbc.driver.OracleDriver");
            System.out.println("The");
            // Step 2: Create the connection
            // String url = "jdbc:oracle:thin:@//localhost:1521/xe";  // Format: jdbc:oracle:thin:@host:port:SID
             String url = "jdbc:oracle:thin:@//localhost:1522/XE"; 
            String username = "system";
            String password = "Password";
            System.out.println("Area");
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Connected to Oracle Database!");

            // Step 3: Execute query
           String query = "INSERT INTO Citizen (citizen_id, name, email, phone, address) VALUES (?, ?, ?, ?, ?)";
             PreparedStatement stmt = con.prepareStatement(query);

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


