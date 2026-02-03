import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";

        String user = "root";
        String password = "Admin@2004";

        try(Connection conn = DriverManager.getConnection(url, user, password)) {
            System.out.println("Connected to the database");
        }
        catch(SQLException e) {
            System.out.println("Connection Failed! "+ e.getMessage());
        }
    }
}
