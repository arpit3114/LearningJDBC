import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class updatePrepared {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user ="root";
        String password = "Admin@2004";
        String query = "update employees set id = ? where name = ? AND salary = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-------DONE-----------");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("_________Connection successfully __________");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,5);
            ps.setString(2,"Raj");
            ps.setInt(3,70000);

            int rs = ps.executeUpdate();

            if(rs> 0) System.out.println("updation Successfully " +rs);
            else System.out.println("updation failed");

            ps.close();
            con.close();
            System.out.println("________closed_____");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
