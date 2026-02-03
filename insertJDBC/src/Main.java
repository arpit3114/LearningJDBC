
import java.sql.*;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {

        String url = "jdbc:mysql://localhost:3306/company";
        String username = "root";
        String password = "Admin@2004";
        String query = "insert into employees values (3,'Rahul','full stack developer',50000),(4,'Raghav','data analyst',45000);";

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
            int rowsaffected = stmt.executeUpdate(query);

            if(rowsaffected > 0){
                System.out.println("------insert Successfully------- "+ rowsaffected);
            }else System.out.println("insertion failed-----!!!!!!!!");

            stmt.close();
            con.close();
            System.out.println("-------------connection closed-----------");

        }catch (SQLException e){
            System.out.println(e.getMessage());
        }

    }
}