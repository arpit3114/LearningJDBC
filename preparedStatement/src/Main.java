import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/company";
        String user ="root";
        String password = "Admin@2004";
        String query = "select * from employees where salary > ?";

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
            ps.setInt(1,39000);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                 int id = rs.getInt("id");
                 String name = rs.getString("name");
                 String title = rs.getString("title");
                 double salary = rs.getDouble("salary");

                System.out.println("ID: "+id);
                System.out.println("Name: "+name);
                System.out.println("title: "+title);
                System.out.println("salary: "+salary);
                System.out.println("--------------------------");
            }

            rs.close();
            ps.close();
            con.close();
            System.out.println("________closed_____");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
