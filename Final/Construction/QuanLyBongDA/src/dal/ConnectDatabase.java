package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConnectDatabase {
	public static String driver ="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	public static String url = "jdbc:sqlserver://localhost:1433; databaseName = QuanLyBongDa";
	public static String user = "sa";
	public static String password = "ngotiendat97";
	
        /**
         * Phương thức tạo kết nối với CSDL
         * @return Connection nếu kết nối đó thành công , trả về null nếu thất bại
         */
        
	public static Connection getConnect(){
            try {
                Class.forName(driver);
                Connection cnn = DriverManager.getConnection(url, user, password);
                return cnn;
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                Logger.getLogger(ConnectDatabase.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, "Kết nối tới server thất bại");
            return null;
	}
}
