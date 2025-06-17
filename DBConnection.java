import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/Sprint1";
        String user = "root";
        String password = "54112";

        return DriverManager.getConnection(url, user, password);
    }
}
