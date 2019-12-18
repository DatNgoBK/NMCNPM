package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ClubDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    
    /**
     * Phương thức truy vấn thông tin CLB
     * @return tập các bản ghi chứa thông tin CLB
     */ 
    
    public static ResultSet queryClubInformation(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Club");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn thông tin SVĐ theo tên CLB
     * @param data Tên CLB
     * @return bản ghi chứa kết quả là thông tin CLB 
     */
    
    public static ResultSet queryClubNameSearch(String data) {
        try {
            String sql = "select * from Club where clubName = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn thông tin SVĐ theo mã CLB
     * @param data Mã CLB
     * @return bản ghi chứa kết quả là thông tin CLB 
     */
    
    public static ResultSet queryClubIDSearch(String data) {
        try {
            String sql = "select * from Club where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn tên cầu thủ 
     * @param data mã câu lạc bộ
     * @return các bản ghi chứa tên cầu thủ
     */

    public static ResultSet queryPlayerInformationInClub(String data) {
        try {
            PreparedStatement ps = cnn.prepareStatement("select playerName from Player where clubID = ?");
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức thêm thông tin CLB vào CSDL
     * @param data data[0]: Mã CLB, data[1]: Tên CLB, data[2]: địa chỉ, data[3]: trang web, data[4]: mã sân vận động
     */

    public static void queryAddClub(String... data) {
        try {
            String sql = "insert into Club(clubID, clubName, address, website, stadiumID) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Trùng ID");
        }
    }
    
    /**
     * Phương thức cập nhật thông tin CLB vào CSDL
    * @param data data[0]: Mã CLB, data[1]: Tên CLB, data[2]: địa chỉ, data[3]: trang web, data[4]: mã sân vận động
     */

    public static void queryUpdateClub(String... data) {
        try {
            String sql = "Update Club set clubName = ?, address = ?, website = ?, stadiumID = ? where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức xóa thông tin CLB khỏi CSDL
     * @param data : mã CLB
     */

    public static void queryDeleteClub(String data) {
        try {
            String sql = "Delete Club where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClubDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
