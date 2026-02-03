import java.sql.*;

public class insertprepared {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user ="root";
        String password = "Admin@2004";
        String query = "insert into employees values (? , ?, ?,?);";

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
            ps.setString(3,"React Developer");
            ps.setInt(4,70000);

            int rs = ps.executeUpdate();

            if(rs> 0) System.out.println("Inserted Successfully" +rs);
            else System.out.println("FAILED INSERTION");

            ps.close();
            con.close();
            System.out.println("________closed_____");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
