package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CoachDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    
    /**
     * Phương thức truy vấn thông tin HLV
     * @return tập các bản ghi chứa thông tin HLV
     */
    
    public static ResultSet queryCoachInformation() {
        try {
            String sql = "select c.coachID, c.coachName, c.position, c.email, c.phone, c.dateOfBirth, c.sex, c.country, cl.clubName  from Coach c, Club cl where c.clubID = cl.clubID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn thông tin HLV theo tên HLV
     * @param data Tên HLV
     * @return bản ghi chứa kết quả là thông tin HLV
     */
    
    public static ResultSet queryCoachNameSearch(String data) {
        try {
            String sql = "select * from Coach where coachName = ?";
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
     * Phương thức truy vấn thông tin HLV theo mã HLV
     * @param data Mã HLV
     * @return bản ghi chứa kết quả là thông tin HLV 
     */
    
    public static ResultSet queryCoachIDSearch(String data) {
        try {
            String sql = "select * from Coach where coachID = ?";
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
     * Phương thức thêm thông tin HLV vào CSDL
     * @param data data[0]: Mã HLV, data[1]: Tên HLV, data[2]: vị trí, data[3]: email, data[4]: số điện thoại, data[5]: ngày sinh, data[6]: giới tính, data[7]: địa chỉ, data[8]: mã CLB
     */

    public static void queryAddCoach(String data, String data1, String data2, String data3, String data4, Date data5, String data6, String data7, String data8) {
        try {
            String sql = "insert into Coach(coachID, coachName, position, email, phone, dateOfBirth, sex, country, clubID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data1);
            ps.setString(3, data2);
            ps.setString(4, data3);
            ps.setString(5, data4);
            ps.setDate(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.setString(9, data8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Trùng mã HLV");
        }
    }
    
    /**
     * Phương thức cập nhật thông tin HLV vào CSDL
     * @param data data[0]: Mã HLV, data[1]: Tên HLV, data[2]: vị trí, data[3]: email, data[4]: số điện thoại, data[5]: ngày sinh, data[6]: giới tính, data[7]: địa chỉ, data[8]: mã CLB
     */

    public static void queryUpdateCoach(String data, String data1, String data2, String data3, Date data4, String data5, String data6, String data7, String data8) {
        try {
            String sql = "Update Coach set coachName = ?, position = ?, email = ?, phone = ?, dateOfBirth = ?, sex = ?, country =?, clubID = ? where coachID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data1);
            ps.setString(3, data2);
            ps.setString(4, data3);
            ps.setDate(5, data4);
            ps.setString(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.setString(9, data8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức xóa thông tin HLV khỏi CSDL
     * @param data : mã HLV
     */

    public static void queryDeleteCoach(String data) {
        try {
            String sql = "Delete Coach where coachID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(CoachDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
