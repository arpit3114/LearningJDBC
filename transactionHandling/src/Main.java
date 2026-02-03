import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students";
        String user ="root";
        String password = "Admin@2004";
        String withdrawQuery = "update accounts set balance = balance - ? where account_num = ?";
        String depositQuery = "update accounts set balance = balance + ? where account_num = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-------DONE-----------");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("_________Connection successfully __________");
            // usually when we code the commit is always true so we have to firstly stop it by making false then we code
            con.setAutoCommit(false);

            try {
                PreparedStatement withdrawPs = con.prepareStatement(withdrawQuery);
                PreparedStatement depositPs = con.prepareStatement(depositQuery);

                withdrawPs.setDouble(1, 500.00);
                withdrawPs.setString(2, "account123");

                depositPs.setDouble(1, 500.00);
                depositPs.setString(2, "account45556");

                int rowaffectedWithdraw = withdrawPs.executeUpdate();
                int rowaffectedDeposite = depositPs.executeUpdate();

                if(rowaffectedDeposite > 0 && rowaffectedDeposite > 0){
                    // Transaction Handling
                    con.commit();
                    System.out.println("transaction Successfully");
                }else{
                    con.rollback();
                    System.out.println("Transcation Failed  ");
                }
            }catch (SQLException e){
                System.out.println(e.getMessage());
            }
            con.close();
            System.out.println("________closed_____");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
