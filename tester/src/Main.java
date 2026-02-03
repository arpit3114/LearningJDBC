
import java.sql.*;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String query = "select * from employees;";
        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Admin@2004";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-----------------------driver loaded Successfully ------------------------");
        }catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url,username,password);
            System.out.println("-----------connected Successfully---------------");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String title = rs.getString("title");
                double salary = rs.getDouble("salary");
                System.out.println("--------------------------------------");
                System.out.println("ID: "+id);
                System.out.println("name: "+name);
                System.out.println("title: "+title);
                System.out.println("Salary: "+salary);
            }

            rs.close();
            stmt.close();
            con.close();
            System.out.println("-------------connection closed-----------");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}