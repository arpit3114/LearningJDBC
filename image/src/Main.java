import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException{

        String url = "jdbc:mysql://localhost:3306/imagedata";
        String user ="root";
        String password = "Admin@2004";
        String path = "D:\\Wallpapers\\batman.jpg";
        String query = "insert into image_db(image_data) values (?);";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-------DONE-----------");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try{
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("_________Connection successfully __________");

            FileInputStream file = new FileInputStream(path);
            byte[] imgdata = new byte[file.available()];
            file.read(imgdata);
            PreparedStatement ps = con.prepareStatement(query);
            ps.setBytes(1,imgdata);
            int affectedRows = ps.executeUpdate();

            if(affectedRows > 0) System.out.println("--------SUCCESS-----");
            else System.out.println("------FAILED--------");

            ps.close();
            con.close();
            System.out.println("________closed_____");
        }catch(SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
