/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Admin
 */
public class StadiumDAL {
    public static Connection cnn = ConnectDatabase.getConnect();
    /**
     * Phương thức truy vấn thông tin SVĐ
     * @return Các bản ghi chứa thông tin SVĐ
     */
    public static ResultSet queryStadiumInformation(){
        try {
            PreparedStatement ps = cnn.prepareStatement("select * from Stadium");
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn thông tin SVĐ theo tên SVĐ
     * @param data Tên SVĐ
     * @return bản ghi chứa kết quả là thông tin SVĐ 
     */
    
    public static ResultSet queryStadiumNameSearch(String data) {
        try {
            String sql = "select stadiumID,stadiumName,capacity,note from Stadium where stadiumName = ?";
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
     * Phương thức truy vấn thông tin SVĐ theo mã SVĐ
     * @param data Mã SVĐ
     * @return bản ghi chứa kết quả là thông tin SVĐ 
     */
    
    
    public static ResultSet queryStadiumIDSearch(String data) {
        try {
            String sql = "select stadiumID,stadiumName,capacity,note from Stadium where stadiumID = ?";
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
     * Phương thức thêm thông tin SVĐ vào CSDL
     * @param data data[0]: Mã SVĐ, data[1]: Tên SVĐ, data[2]: Năm thành lập, data[3]: Sức chứa, data[4]: Ghi chú
     */

    public static void queryAddStadium(String... data) {
        try {
            String sql = "insert into Stadium(stadiumID, stadiumName, foundedYear, capacity, note) values(?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Trùng mã SVĐ");
        }
    }
    
     /**
     * Phương thức cập nhật thông tin SVĐ vào CSDL
     * @param data data[0]: Tên SVĐ, data[1]: Năm thành lập, data[2]: Sức chứa, data[3]: Ghi chú, data[4]: Mã SVĐ
     */


    public static void queryUpdateStadium(String... data) {
        try {
            String sql = "Update Stadium set stadiumName = ?, foundedYear = ?, capacity = ?, note = ? where stadiumID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data[0]);
            ps.setString(2, data[1]);
            ps.setString(3, data[2]);
            ps.setString(4, data[3]);
            ps.setString(5, data[4]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StadiumDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức xóa thông tin SVĐ khỏi CSDL
     * @param data : mã SVĐ
     */

    public static void queryDeleteStadium(String data) {
        try {
            String sql = "Delete Stadium where stadiumID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Chỉ xóa được khi không thuộc về 1 CLB nào đó.");
        }
    }
}
