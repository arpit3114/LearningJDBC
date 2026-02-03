import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.*;

public class reteriveData {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/imagedata";
        String user ="root";
        String password = "Admin@2004";
        String path = "E:\\DataReciver\\";
        String query = "select image_data from image_db where image_id = ?";

        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("-------DONE-----------");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("_________Connection successfully __________");

            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1,1);

            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                byte[] image_data = rs.getBytes("image_data");
                String img_path = path + "img.jpg";
                OutputStream os = new FileOutputStream(img_path);
                os.write(image_data);
            }else{
                System.out.println("NAHI HAI PHOOTO");
            }
            rs.close();
            ps.close();
            con.close();

        }catch (SQLException e){
            System.out.println(e.getMessage());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
