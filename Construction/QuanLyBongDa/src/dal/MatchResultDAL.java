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
import javax.swing.JTable;

/**
 *
 * @author Dat Ngo
 */
public class MatchResultDAL {

    public static Connection cnn = ConnectDatabase.getConnect();
    
    /**
     * Phương thức thêm kết quả trận đấu vào CSDL
     * @param data : data[0]: mã trận, data[1]: Bàn thắng đội nhà, data[1]: Bàn thắng đội khách
     */
    public static void addResult(String... data) {
        try {
            PreparedStatement ps = cnn.prepareStatement("insert into MatchResult(scheduleID, homeTeamGoal, visitorTeamGoal) values(?, ?, ?)");
            ps.setString(1, data[0]);
            ps.setInt(2, Integer.valueOf(data[1]));
            ps.setInt(3, Integer.valueOf(data[2]));
            ps.executeUpdate();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Trận đấu chưa có trong CSDL");
        }
    }
    
    /**
     * Phương thức cập nhật kết quả trận đấu
     * @param data data[0]: Bàn thắng đội nhà, data[1]: Bàn thắng đội khách, data[2]: mã trận
     */
    
    public static void updateResult(String... data) {
        try {
            PreparedStatement ps = cnn.prepareStatement("update MatchResult set homeTeamGoal = ?, visitorTeamGoal = ? where scheduleID = ?");
            ps.setInt(1, Integer.valueOf(data[0]));
            ps.setInt(2, Integer.valueOf(data[1]));
            ps.setString(3, data[2]);
            ps.executeUpdate();
        } catch (SQLException ex) {
            //JOptionPane.showMessageDialog(null, "Trận đấu chưa có trong CSDL");
        }
    }
    
    /**
     * Phương thức lấy về kết quả trận đấu
     * @param data : mã trận đấu
     * @return 
     */
    
    public static ResultSet showResult(String data){
        try {
            PreparedStatement ps = cnn.prepareStatement("select homeTeamGoal, visitorTeamGoal from MatchResult where scheduleID = ?");
            ps.setString(1, data);
            ResultSet rs = ps.executeQuery();
            if(rs.next() == false) return null;
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Phương thức lấy thông tin BXH
     * @return ResultSet chứa các hàng dữ liệu của BXH
     */

    public static ResultSet queryReceiveScoreChart() {
        try {
            String sql = "  select c.clubName as TenCLB,"
                    + "  (select count(*) from Schedule s, MatchResult mr where s.scheduleID = mr.scheduleID and (c.clubID = s.homeTeamID ) ) +  ( select count(*) from Schedule s, MatchResult mr where s.scheduleID = mr.scheduleID  and (c.clubID = s.visitorTeamID )) as SoTran,"
                    + "  (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal > mr.visitorTeamGoal) and (c.clubID = s.homeTeamID )) + (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal < mr.visitorTeamGoal) and (c.clubID = s.visitorTeamID )) as Thang,"
                    + "  (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal < mr.visitorTeamGoal) and (c.clubID = s.homeTeamID )) + (select count(*) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (mr.homeTeamGoal > mr.visitorTeamGoal) and (c.clubID = s.visitorTeamID )) as Thua,"
                    + "  (select sum(mr.homeTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.homeTeamID )) + (select sum(mr.visitorTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.visitorTeamID )) as BT,"
                    + "  (select sum(mr.visitorTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.homeTeamID )) + (select sum(mr.homeTeamGoal) from Schedule s, MatchResult mr where (s.scheduleID = mr.scheduleID) and (c.clubID = s.visitorTeamID )) as SBT"
                    + "  from Club c Order by Thang desc";
            PreparedStatement ps = cnn.prepareCall(sql);
            ResultSet rs = ps.executeQuery();
            return rs;
        } catch (SQLException ex) {
            Logger.getLogger(MatchResultDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
