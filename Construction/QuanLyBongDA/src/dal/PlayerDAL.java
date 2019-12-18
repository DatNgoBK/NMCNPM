package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class PlayerDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    
    /**
     * Phương thức truy vấn thông tin cầu thủ
     * @return tập các bản ghi chứa thông tin cầu thủ
     */
    public static ResultSet queryPlayerInformation() {
        try {
            String sql = "select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubName from Player, Club where Player.clubID = Club.clubID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức thêm thông tin cầu thủ vào CSDL
     * @param data : mã cầu thủ
     * @param data1 : tên cầu thủ
     * @param data2 : Vị trí
     * @param data3 : chiều cao
     * @param data4 : cân nặng
     * @param data5 : Ngày sinh
     * @param data6 : Giới tính
     * @param data7 : Quê quán
     * @param data8 : mã CLB
     */

    public static void queryAddPlayer(String data, String data1, String data2, int data3, int data4, Date data5, String data6, String data7, String data8) {
        try {
            String sql = "insert into Player(playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubID) values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data1);
            ps.setString(3, data2);
            ps.setInt(4, data3);
            ps.setInt(5, data4);
            ps.setDate(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.setString(9, data8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Trùng mã cầu thủ");
        }
    }
    
    /**
     * Phương thức cập nhật thông tin cầu thủ vào CSDL
     * @param data : tên cầu thủ
     * @param data1 : Vị trí
     * @param data2 : chiều cao
     * @param data3 : cân nặng
     * @param data4 : Ngày sinh
     * @param data5 : Giới tính
     * @param data6 : Quê quán
     * @param data7 : mã CLB
     * @param data8 : mã cầu thủ
     */

    public static void queryUpdatePlayer(String data, String data1, int data2, int data3, Date data4, String data5, String data6, String data7, String data8) {
        try {
            String sql = "Update Player set playerName = ?, position = ?, height = ?, weight = ?, dateOfBirth = ?, sex = ?, country =?, clubID = ? where playerID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setString(2, data1);
            ps.setInt(3, data2);
            ps.setInt(4, data3);
            ps.setDate(5, data4);
            ps.setString(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.setString(9, data8);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức xóa thông tin cầu thủ trong CSDL
     * @param data : mã cầu thủ
     */

    public static void queryDeletePlayer(String data) {
        try {
            String sql = "Delete Player where playerID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức truy vấn tên cầu thủ 
     * @param data mã câu lạc bộ
     * @return các bản ghi chứa tên cầu thủ
     */

    public static ResultSet queryPlayerNameInAClub(String data) {
        try {
            String sql = "select playerName from Player where clubID = ?";
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
     * Phương thức truy vấn thông tin cầu thủ khi biết tên
     * @param data tên cầu thủ
     * @return bản ghi chứa thông tin cầu thủ
     */

    public static ResultSet queryPlayerNameSearch(String data) {
        try {
            String sql = "select * from Player where playerName = ?";
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
     * Phương thức truy vấn thông tin cầu thủ khi biết mã cầu thủ
     * @param data mã cầu thủ
     * @return bản ghi chứa thông tin cầu thủ
     */
    
    public static ResultSet queryPlayerIDSearch(String data) {
        try {
            String sql = "select playerID, playerName, position, height, weight, dateOfBirth, sex, country, clubID from Player where playerID = ?";
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
     * Phương thức đếm số cầu thủ của một CLB
     * @param data mã CLB
     * @return bản ghi chứa số lượng cầu thủ trong clb
     */

    

    public static ResultSet queryCountPlayerInClub(String data) {
        try {
            String sql = "SELECT COUNT(playerID) as soluong FROM Player where clubID = ?";
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
     * Phương thức truy vấn thông tin cầu thủ của 1 clb
     * @param data mã clb
     * @return các bản ghi chứa thông tin cầu thủ
     */
    
    
    public static ResultSet queryPlayerInAClub(String data) {
        try {
            String sql = "select * from Player where clubID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(PlayerDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
