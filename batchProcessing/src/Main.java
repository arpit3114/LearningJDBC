import java.awt.desktop.SystemEventListener;
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String url = "JDBC:mysql://localhost:3306/company";
        String user ="root";
        String password = "Admin@2004";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-------DONE-----------");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("_________Connection successfully __________");
            con.setAutoCommit(false);
            String query = "insert into employees (id ,name, title, salary)values (?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(query);
            Scanner sc = new Scanner(System.in);
            while(true){
                System.out.print("enter id: ");
                int id = sc.nextInt();
                sc.nextLine();  // to consume buffer space which is generated after entering int or double
                System.out.print("Enter name: ");
                String name = sc.nextLine();
                System.out.print("Enter Job Title: ");
                String title = sc.nextLine();
                System.out.print("enter Salary: ");
                double salary = sc.nextDouble();
                ps.setInt(1,id);
                ps.setString(2,name);
                ps.setString(3,title);
                ps.setDouble(4,salary);
                ps.addBatch();
                System.out.println("Add more Values Y/N");
                String ans = sc.next();

                if(ans.toUpperCase().equals("N")) {
                    break;
                }
            }
            int[] batchResult = ps.executeBatch();
            con.commit();

            con.close();
            System.out.println("________closed_____");

        }catch(SQLException e){
            System.out.println(e.getMessage());
        }

    }
}
