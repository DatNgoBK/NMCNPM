/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Dat Ngo
 */
public class ScheduleDAL {

    public static Connection cnn = ConnectDatabase.getConnect();

    /**
     * Phương thức truy vấn thông tin trận đấu
     * @return Bản ghi chứa thông tin của trận đấu.
     */
    
    public static ResultSet queryScheduleInformation() {
        try {
            String sql = "select sc.scheduleID, sc.round, sc.day, sc.time, s.stadiumName, c1.clubName as homeTeamName, c2.clubName as visitorTeamName, m.managerName from Schedule sc, Stadium s, Club c1, Club c2, Manager m where sc.stadiumID = s.stadiumID and c1.clubID = sc.homeTeamID and c2.clubID = visitorTeamID and sc.managerID = m.managerID";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức truy vấn thông tin của trận đấu có mã trận biết trước
     * @param data mã trận đấu
     * @return bản ghi chứa thông tin trận đấu
     */

    public static ResultSet queryScheduleIDSearch(String data) {
        try {
            String sql = "select scheduleID,homeTeamID,visitorTeamID,time,stadiumID from Schedule where scheduleID = ?";
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
     * Phương thức thêm thông tin trận đấu vào CSDL
     * @param data Mã trận
     * @param data1 Lượt trận
     * @param data2 Ngày thi đấu
     * @param data3 Thời gian thi đấu
     * @param data4 Mã SVĐ
     * @param data5 Mã CLB chủ nhà
     * @param data6 Mã CLB khách
     * @param data7 Mã người xác nhận
     */

    public static void queryAddSchedule(String data, int data1, Date data2, String data3, String data4, String data5, String data6, String data7) {
        try {
            String sql = "insert into Schedule(scheduleID, round, day, time, stadiumID, homeTeamID, visitorTeamID, managerID) values(?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.setInt(2, data1);
            ps.setDate(3, data2);
            ps.setString(4, data3);
            ps.setString(5, data4);
            ps.setString(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.executeUpdate();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Nhập trùng ID", "Thông báo", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /**
     * Phương thức cập nhật thông tin trận đấu vào CSDL
     * @param data Lượt trận
     * @param data1 Ngày thi đấu
     * @param data2 Thời gian thi đấu
     * @param data3 Mã SVĐ
     * @param data4 Mã CLB chủ nhà
     * @param data5 Mã CLB khách
     * @param data6 Mã người xác nhận
     * @param data7 Mã trận
     */

    public static void queryUpdateSchedule(int data, Date data1, String data2, String data3, String data4, String data5, String data6, String data7) {
        try {
            String sql = "Update Schedule set round = ?, day = ?, time = ?, stadiumID = ?, homeTeamID = ?, visitorTeamID = ?, managerID = ? where scheduleID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setInt(1, data);
            ps.setDate(2, data1);
            ps.setString(3, data2);
            ps.setString(4, data3);
            ps.setString(5, data4);
            ps.setString(6, data5);
            ps.setString(7, data6);
            ps.setString(8, data7);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * Phương thức xóa thông tin trận đấu khỏi CSDL
     * @param data Mã CLB
     */

    public static void queryDeleteSchedule(String data) {
        try {
            String sql = "Delete Schedule where scheduleID = ?";
            PreparedStatement ps = cnn.prepareStatement(sql);
            ps.setString(1, data);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ScheduleDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
